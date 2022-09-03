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
import javax.swing.JFileChooser;
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
import pesaje_trabajos.frm_principal;
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
    private int servicioid;

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

    public int getServicioid() {
        return servicioid;
    }

    public void setServicioid(int servicioid) {
        this.servicioid = servicioid;
    }

    public void generar_excel() {
        String fecha_inicial = fecha_inicio;
        Date fecha_final = c_varios.suma_dia(fecha_inicial, dias - 1);
        String date_final = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_final);
        //  System.out.println("fecha final" + date_final);

        String subquery = "";

        String[] titulos = new String[dias + 9];
        titulos[0] = "Codigo";
        titulos[1] = "Empleado";
        titulos[2] = "Documento";
        titulos[3] = "Nro Cuenta";

        for (int i = 0; i < dias; i++) {
            Date fecha_temp = c_varios.suma_dia(fecha_inicial, i);
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(fecha_temp);
            subquery += "sum(case when fecha= '" + date + "' then cantidad else 0 end) as '" + date + "', ";
            titulos[4 + i] = c_varios.fecha_usuario(date);
        }
        titulos[dias + 4] = "Total Kgs";
        titulos[dias + 5] = "S/ Pesaje";
        titulos[dias + 6] = "Desc. TG";
        titulos[dias + 7] = "Desc. Empresa";
        titulos[dias + 8] = "a Pagar";

        String sql = "select c.codigo, c.apellidos || ' ' || c.nombres as empleado, c.documentocuenta, c.nrocuenta, "
                + subquery
                + "sum(cantidad) as total,"
                + "sum(cantidad) * 0.5 as subtotal, "
                + "ifnull((select sum(monto) from descuentos where idarticulo in (4,5) and fecha BETWEEN '" + fecha_inicial + "' and '" + date_final + "' and idcolaborador = c.idcolaborador ), 0) as descuento_juan, "
                + "ifnull((select sum(monto) from descuentos where idarticulo in (3,10,11) and fecha BETWEEN '" + fecha_inicial + "' and '" + date_final + "' and idcolaborador = c.idcolaborador ), 0) as descuento_jorge"
                + " from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where p.fecha BETWEEN '" + fecha_inicial + "' and '" + date_final + "' and idservicio = '"+servicioid+"' "
                + "group by p.idcolaborador "
                + "order by c.apellidos || ' ' || c.nombres asc";

        //   System.out.println(sql);
        File dir = new File("");

        String carpeta_reportes = dir.getAbsolutePath() + File.separator + "reportes";

        //String nombre_archivo = carpeta_reportes + File.separator + "pesaje_" + fecha_inicio + "_hasta_" + date_final + ".xls";
        JFileChooser guardar = new JFileChooser();
        //guardar.showSaveDialog(null);

        guardar.setDialogTitle("Seleccionar Carpeta para guardar Reporte");
        guardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //guardar.setFileSelectionMode(JFileChooser.FILES_ONLY);
        guardar.setName("pesaje_" + fecha_inicio + "_hasta_" + date_final + ".xls");
        guardar.setAcceptAllFileFilterUsed(false);
        guardar.setApproveButtonText("Sel. Carpeta ");

        if (guardar.showSaveDialog(frm_principal.jTabbedPane1) == JFileChooser.APPROVE_OPTION) {
            String carpetanueva = guardar.getSelectedFile().toString();
            System.out.println(carpetanueva);
            carpeta_reportes = carpetanueva + File.separator + "pesaje_" + fecha_inicio + "_hasta_" + date_final;
        } else {
            JOptionPane.showMessageDialog(null, "SE GUARDARA EL REPORTE EN LA CARPETA POR DEFECTO");
            carpeta_reportes += File.separator + "pesaje_" + fecha_inicio + "_hasta_" + date_final;
        }

        //   System.out.println(guardarComo());
        /*
        File directorio = new File(carpeta_reportes);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
         */
        // Creamos el archivo donde almacenaremos la hoja
        // de calculo, recuerde usar la extension correcta,
        // en este caso .xlsx
        String nombre_archivo = carpeta_reportes + ".xls";// + File.separator + "pesaje_" + fecha_inicio + "_hasta_" + date_final + ".xls";
        File archivo = new File(nombre_archivo);
        //File archivo =narchivo;

        System.out.println(nombre_archivo);

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

        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###0.00"));

        int filanro = 1;
        try {
            while (rs.next()) {

                // Ahora creamos una fila en la posicion 1
                fila = pagina.createRow(filanro);
                double monto_pesaje = 0;
                double desc_juan = 0;
                double desc_jorge = 0;
                double apagar = 0;
                // Y colocamos los datos en esa fila

                for (int i = 0; i < (dias + 9); i++) {
                    // Creamos una celda en esa fila, en la
                    // posicion indicada por el contador del ciclo
                    HSSFCell celda = fila.createCell(i);

                    if (i < 4) {
                        celda.setCellValue(rs.getString(i + 1));
                    }

                    if (i > 3) {
                        if (i < dias + 8) {
                            celda.setCellValue(rs.getDouble(i + 1));
                        }

                        celda.setCellStyle(style);
                        celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    }

                    if (i == (dias + 8)) {
                        monto_pesaje = rs.getDouble(dias + 6);
                        desc_juan = rs.getDouble(dias + 7);
                        desc_jorge = rs.getDouble(dias + 8);
                        apagar = monto_pesaje - desc_jorge - desc_juan;
                        celda.setCellValue(apagar);
                        celda.setCellStyle(style);
                        celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    }

                }

                filanro++;
            }
        } catch (SQLException ex) {
            System.out.println(" problema sql " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "ERROR CON EL SQL \n" + ex.getLocalizedMessage());
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
            JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL ARCHIVO \n" + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error de entrada/salida");
            JOptionPane.showMessageDialog(null, "Error de entrada/salida \n" + ex.getLocalizedMessage());
        }
    }

    public String guardarComo() {

        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        guardar.setName(fecha_inicio);
        File archivo = guardar.getSelectedFile();
        return archivo.toString();
    }

}
