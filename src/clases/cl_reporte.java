/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Mariela
 */
public class cl_reporte {

    cl_varios c_varios = new cl_varios();
    cl_conectar c_conectar = new cl_conectar();

    public cl_reporte() {
    }

    private String fecha_inicio;
    private int dias;

    public void maximo_minimo_fecha(String fecha, JTable tabla, int tipo) {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        String concatsql;
        if (tipo == 0) {
            concatsql = "order by cantidad asc, hora asc, codigo asc ";
        } else {
            concatsql = "order by cantidad desc, hora asc, codigo asc ";
        }

        String sql = "select p.cantidad, p.hora, c.codigo "
                + "from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where p.fecha = '" + fecha + "' "
                + concatsql
                + "limit 10";
        //  System.out.println(sql);

        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        modelo.addColumn("COD. Trab.");
        modelo.addColumn("Hora");
        modelo.addColumn("Peso");

        try {
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("codigo");
                fila[1] = rs.getString("hora");
                fila[2] = c_varios.formato_numero(rs.getDouble("cantidad"));
                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(40);
            c_varios.centrar_celda(tabla, 0);
            c_varios.centrar_celda(tabla, 1);
            c_varios.derecha_celda(tabla, 2);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public Integer[] pesaje_horas_dia(String fecha) {
        int total_horas = 25;
        Integer[] valor_x = new Integer[total_horas];
        // System.out.println("total dias de este mes = " + total_mes);

        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(cantidad) as peso, strftime('%H', hora) as hora "
                    + "from pesaje "
                    + "where fecha = '" + fecha + "' "
                    + "group by  strftime('%H', hora) "
                    + "limit 24";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                valor_x[rs.getInt("hora")] = rs.getInt("peso");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return valor_x;
    }

    public void peso_semanal() {
        String fecha_inicial = fecha_inicio;
        Date fecha_final = c_varios.suma_dia(fecha_inicial, dias);
        String date_final = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_final);

        String subquery = "";
        for (int i = 0; i <= dias; i++) {
            Date fecha_temp = c_varios.suma_dia(fecha_inicial, i);
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_temp);
            subquery += "sum(case when fecha= '" + date + "' then cantidad else 0 end) as '" + date + "', ";
        }

        String sql = "select c.codigo, c.apellidos || ' ' || c.nombres as empleado, "
                + subquery
                + "sum(cantidad) as total "
                + " from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where p.fecha BETWEEN '" + fecha_inicial + "' and '" + date_final + "' "
                + "group by p.idcolaborador "
                + "order by c.codigo asc";

        // System.out.println(sql);
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void generar_excel() {
        String fecha_inicial = fecha_inicio;
        Date fecha_final = c_varios.suma_dia(fecha_inicial, dias - 1);
        String date_final = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_final);
      //  System.out.println("fecha final" + date_final);

        String subquery = "";

        String[] titulos = new String[dias + 5];
        titulos[0] = "Codigo";
        titulos[1] = "Empleado";
        titulos[2] = "Documento";
        titulos[3] = "Nro Cuenta";

        
        for (int i = 0; i < dias  ; i++) {
            Date fecha_temp = c_varios.suma_dia(fecha_inicial, i);
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_temp);
            subquery += "sum(case when fecha= '" + date + "' then cantidad else 0 end) as '" + date + "', ";
            titulos[4 + i] = date;
        }
        titulos[dias + 4] = "Total Kgs";

        String sql = "select c.codigo, c.apellidos || ' ' || c.nombres as empleado, c.documento, c.nrocuenta, "
                + subquery
                + "sum(cantidad) as total "
                + " from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where p.fecha BETWEEN '" + fecha_inicial + "' and '" + date_final + "' "
                + "group by p.idcolaborador "
                + "order by c.apellidos || ' ' || c.nombres asc";

         // System.out.println(sql);
        File dir = new File("");

        String carpeta_reportes = dir.getAbsolutePath() + File.separator + "reportes";

        File directorio = new File(carpeta_reportes);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }

        // Creamos el archivo donde almacenaremos la hoja
        // de calculo, recuerde usar la extension correcta,
        // en este caso .xlsx
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "pesaje_" + fecha_inicio + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "pesaje_" + fecha_inicio + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Resumen");

        // Creamos una fila en la hoja en la posicion 0
        HSSFRow fila = pagina.createRow(0);
        //System.out.println(titulos.length + " total columnas");
        
        pagina.setColumnWidth(0, 1550);
        pagina.setColumnWidth(1, 15000);
        pagina.setColumnWidth(3, 4200);

        // Creamos el encabezado
        for (int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion 
            // indicada por el contador del ciclo
            HSSFCell celda = fila.createCell(i);

            // Indicamos el estilo que deseamos 
            // usar en la celda, en este caso el unico 
            // que hemos creado
            celda.setCellValue(titulos[i]);
        }

        //se hace el recorrido de la base de datos para cargar lo vaores en las celdas
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        int filanro = 1;
        try {
            while (rs.next()) {

                // Ahora creamos una fila en la posicion 1
                fila = pagina.createRow(filanro);
                // Y colocamos los datos en esa fila

                for (int i = 0; i < dias + 5; i++) {
                    // Creamos una celda en esa fila, en la
                    // posicion indicada por el contador del ciclo
                    HSSFCell celda = fila.createCell(i);
                    // System.out.println(rs.getString(i+1));
                    
                    if (i < 4) {
                        celda.setCellValue(rs.getString(i + 1));
                    }

                    if (i > 3) {
                        celda.setCellValue(rs.getDouble(i + 1));
                        HSSFCellStyle style = workbook.createCellStyle();
                        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###0.00"));
                        celda.setCellStyle(style);
                        celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    }

                }

                filanro++;
            }
        } catch (SQLException ex) {
            System.out.println(" problema sql " + ex.getLocalizedMessage());
        }
        c_conectar.cerrar(rs);
        c_conectar.cerrar(st);

        // Ahora guardaremos el archivo
        try {
            FileOutputStream salida = new FileOutputStream(archivo);
            workbook.write(salida);
            salida.close();

            System.out.println("Archivo creado existosamente en " + archivo.getAbsolutePath());
            Notification.show("Creado", "Archivo creado existosamente en " + archivo.getAbsolutePath());

            Desktop.getDesktop().open(new File(archivo.getAbsolutePath()));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Archivo no localizable en sistema de archivos");
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error de entrada/salida");
        }
    }

}
