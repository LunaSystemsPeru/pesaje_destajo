/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Mariela
 */
public class cl_colaborador {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int idcolaborador;
    private int codigo;
    private String documento;
    private int idnacionalidad;
    private String apellidos;
    private String nombres;
    private String nrocuenta;
    private int estado;
    private int nro_llamadas;

    public cl_colaborador() {
    }

    public int getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(int idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(int idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(String nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNro_llamadas() {
        return nro_llamadas;
    }

    public void setNro_llamadas(int nro_llamadas) {
        this.nro_llamadas = nro_llamadas;
    }

    public String getDatos() {
        return apellidos + " " + nombres;
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from colaboradores "
                    + "where idcolaborador = '" + idcolaborador + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                codigo = rs.getInt("codigo");
                apellidos = rs.getString("apellidos");
                nombres = rs.getString("nombres");
                documento = rs.getString("documento");
                idnacionalidad = rs.getInt("idnacionalidad");
                nrocuenta = rs.getString("nrocuenta");
                nro_llamadas = rs.getInt("nro_llamadas");
                estado = rs.getInt("estado");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public boolean obtener_datos_codigo() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select idcolaborador "
                    + "from colaboradores "
                    + "where codigo = '" + codigo + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                idcolaborador = rs.getInt("idcolaborador");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public void mostrarHistorico() {
        String sql = "select c.codigo,  c.apellidos || ' ' || c.nombres  as empleado, p.fecha, sum(p.cantidad) as peso "
                + "from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where c.codigo = '" + this.codigo + "' "
                + "group by p.fecha "
                + "order by p.fecha asc";
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[4];
        titulos[0] = "Codigo";
        titulos[1] = "Empleado";
        titulos[2] = "Fecha";
        titulos[3] = "Pesaje";

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
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "historico_empleado_" + codigo + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "historico_empleado_" + codigo + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Historico");

        // Creamos una fila en la hoja en la posicion 0
        HSSFRow fila = pagina.createRow(0);
        System.out.println(titulos.length + " total columnas");

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
        int filanro = 1;
        try {
            while (rs.next()) {

                // Ahora creamos una fila en la posicion 1
                fila = pagina.createRow(filanro);
                // Y colocamos los datos en esa fila

                for (int i = 0; i < 4; i++) {
                    // Creamos una celda en esa fila, en la
                    // posicion indicada por el contador del ciclo
                    HSSFCell celda = fila.createCell(i);
                    //System.out.println(rs.getString(i));
                    celda.setCellValue(rs.getString(i + 1));
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

    public void mostrarPesajexFecha(String fecha) {
        String sql = "select c.codigo,  c.apellidos || ' ' || c.nombres  as empleado, p.fecha, p.hora, sum(p.cantidad) as peso "
                + "from pesaje as p "
                + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "where c.codigo = '" + this.codigo + "' and p.fecha = '" + fecha + "' "
                + "group by p.hora "
                + "order by p.hora asc";
        //System.out.println(sql);
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[5];
        titulos[0] = "Codigo";
        titulos[1] = "Empleado";
        titulos[2] = "Fecha";
        titulos[3] = "Hora";
        titulos[4] = "Pesaje";

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
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_empleado_horas_" + codigo + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_empleado_horas_" + codigo + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Historico");

        // Creamos una fila en la hoja en la posicion 0
        HSSFRow fila = pagina.createRow(0);
        System.out.println(titulos.length + " total columnas");

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
        int filanro = 1;
        try {
            while (rs.next()) {

                // Ahora creamos una fila en la posicion 1
                fila = pagina.createRow(filanro);
                // Y colocamos los datos en esa fila

                for (int i = 0; i < 5; i++) {
                    // Creamos una celda en esa fila, en la
                    // posicion indicada por el contador del ciclo
                    HSSFCell celda = fila.createCell(i);
                    //System.out.println(rs.getString(i));
                    celda.setCellValue(rs.getString(i + 1));
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

    public void generarExcelTrabajadores() {
        String sql = "select codigo, documento, apellidos || ' ' || nombres, nrocuenta "
                + "from colaboradores "
                + "order by apellidos asc, nombres asc ";
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[4];
        titulos[0] = "Codigo";
        titulos[1] = "Documento";
        titulos[2] = "Apellidos y Nombres";
        titulos[3] = "Nro Cuenta";

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
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_lista_empleado" + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_lista_empleado" + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Historico");

        // Creamos una fila en la hoja en la posicion 0
        HSSFRow fila = pagina.createRow(0);
        System.out.println(titulos.length + " total columnas");

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
        int filanro = 1;
        try {
            while (rs.next()) {

                // Ahora creamos una fila en la posicion 1
                fila = pagina.createRow(filanro);
                // Y colocamos los datos en esa fila

                for (int i = 0; i < 4; i++) {
                    // Creamos una celda en esa fila, en la
                    // posicion indicada por el contador del ciclo
                    HSSFCell celda = fila.createCell(i);
                    //System.out.println(rs.getString(i));
                    celda.setCellValue(rs.getString(i + 1));
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

    public void llenar_text() {
        String query = "select * from colaboradores order by codigo asc";
        try {

            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            String linea = "";
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                File dir;
                dir = new File("");
                //System.out.println(dir.getAbsolutePath() + File.separator + "excel.csv");

                fichero = new FileWriter(dir.getAbsolutePath() + File.separator + "excel.csv");
                pw = new PrintWriter(fichero);

                while (rs.next()) {
                    linea
                            += rs.getString("idcolaborador") + ","
                            + rs.getString("codigo") + ","
                            + rs.getString("documento") + ","
                            + rs.getString("idnacionalidad") + ","
                            + rs.getString("apellidos") + ","
                            + rs.getString("nombres") + ","
                            + rs.getString("nrocuenta") + ","
                            + rs.getString("estado") + ","
                            + rs.getString("nro_llamadas") + "\n";
                    //    System.out.println(linea);

                    pw.println(linea);

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para 
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
        } catch (SQLException e) {
            System.out.print(e);
        }

    }

    public void mostrar(JTable tabla, String query) {
        DefaultTableModel modelo;
        try {
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            modelo.addColumn("Codigo");
            modelo.addColumn("Nacionalidad");
            modelo.addColumn("Documento");
            modelo.addColumn("Apellidos y Nombres");
            modelo.addColumn("Nro Cuenta");
            modelo.addColumn("Mensajes");
            modelo.addColumn("Estado");
            modelo.addColumn("");

            while (rs.next()) {
                int idnacion = rs.getInt("idnacionalidad");
                int idestado = rs.getInt("estado");
                String nacionalidad = "";
                String sestado = "";
                if (idnacion == 1) {
                    nacionalidad = "PERUANO";
                }
                if (idnacion == 2) {
                    nacionalidad = "VENEZOLANO";
                }
                if (idnacion == 2) {
                    nacionalidad = "COLOMBIANO";
                }
                if (idnacion == 4) {
                    nacionalidad = "OTRO";
                }

                if (idestado == 0) {
                    sestado = "ACTIVO";
                }
                if (idestado == 1) {
                    sestado = "DESCANSO";
                }
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("codigo");
                fila[1] = nacionalidad;
                fila[2] = rs.getString("documento");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
                fila[4] = rs.getString("nrocuenta");
                fila[5] = rs.getString("nro_llamadas");
                fila[6] = sestado;
                fila[7] = rs.getString("idcolaborador");

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(1);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
            tabla.getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setMinWidth(0);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into colaboradores "
                + "Values ('" + idcolaborador + "', '" + codigo + "', '" + documento + "', '" + idnacionalidad + "', '" + apellidos + "', '" + nombres + "', '" + nrocuenta + "', '" + estado + "', '" + nro_llamadas + "')";
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    //para guardar cuando hay problemas de llave primaria
    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(idcolaborador) + 1, 1) as codigo "
                    + "from colaboradores ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                idcolaborador = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public void obtener_codigovisible() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(codigo) + 1, 1) as codigo "
                    + "from colaboradores ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                codigo = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public boolean actualizar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update colaboradores "
                + "set apellidos ='" + apellidos + "', nombres ='" + nombres + "', documento ='" + documento + "', idnacionalidad='" + idnacionalidad + "',nrocuenta= '" + nrocuenta + "',estado= '" + estado + "' "
                + "where idcolaborador ='" + idcolaborador + "' ";
        // System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean darbaja() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update colaboradores "
                + "set estado = 0 "
                + "where idcolaborador ='" + idcolaborador + "' ";
        //   System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean eliminar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "delete from colaboradores "
                + "where idcolaborador ='" + idcolaborador + "' ";
        //  System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean eliminar_todo() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "delete from colaboradores ";
        //  System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
}
