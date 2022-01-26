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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int idtipodocumento;
    private String apellidos;
    private String nombres;
    private String documentocuenta;
    private String nrocuenta;
    private int estado;
    private int nro_llamadas;
    private String fechamodificacion;

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

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
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

    public String getDocumentocuenta() {
        return documentocuenta;
    }

    public void setDocumentocuenta(String documentocuenta) {
        this.documentocuenta = documentocuenta;
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

    public String getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(String fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getDatos() {
        return this.apellidos + " " + this.nombres;
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
        String sql = "select idcolaborador, codigo, idtipodocumento, documento, apellidos, nombres, documentocuenta, nrocuenta, estado, fecha_modificacion "
                + "from colaboradores "
                + "order by apellidos asc, nombres asc ";
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[10];
        titulos[0] = "IdSistema";
        titulos[1] = "COD Trabajador";
        titulos[2] = "Tipo Documento";
        titulos[3] = "Nro Documento";
        titulos[4] = "Apellidos";
        titulos[5] = "Nombres";
        titulos[6] = "DNICuenta";
        titulos[7] = "Nro Cuenta";
        titulos[8] = "Estado";
        titulos[9] = "Ultima Modf.";

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

                for (int i = 0; i < 8; i++) {
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

    public void generarExcelDia(String fecha) {
        String sql = "select * "
                + "from pesaje "
                + "LEFT join colaboradores on colaboradores.idcolaborador = pesaje.idcolaborador "
                + "where pesaje.fecha = '" + fecha + "' ";
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[17];
        titulos[0] = "Codigo";
        titulos[1] = "Fecha";
        titulos[2] = "Hora";
        titulos[3] = "IdColaborador";
        titulos[4] = "idUsuario";
        titulos[5] = "Cantidad";
        titulos[6] = "idServico";
        titulos[7] = "idcolaborador";
        titulos[8] = "codigo";
        titulos[9] = "documento";
        titulos[10] = "idtipodocumento";
        titulos[11] = "apellidos";
        titulos[12] = "nombres";
        titulos[13] = "documentocuenta";
        titulos[14] = "nrocuenta";
        titulos[15] = "estado";
        titulos[16] = "quejas";

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
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_sql_dia_" + fecha + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_sql_dia_" + fecha + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Corte del Dia");

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

                for (int i = 0; i < titulos.length; i++) {
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

    public void ExportarExcelLiquidacion(String fecha) {
        String sql = "select pesaje.fecha, pesaje.idcolaborador,  sum(pesaje.cantidad), colaboradores.codigo, colaboradores.documento, "
                + "colaboradores.apellidos || colaboradores.nombres as datos, colaboradores.documentocuenta, colaboradores.nrocuenta, pesaje.idservicio, pd.nombre "
                + "from pesaje "
                + "inner join parametros_detalles as pd on pd.iddetalles = pesaje.idservicio "
                + "LEFT JOIN colaboradores on colaboradores.idcolaborador = pesaje.idcolaborador "
                + "where pesaje.fecha = '" + fecha + "' "
                + "GROUP by pesaje.idcolaborador ";
        Statement st = c_conectar.conexion();
        ResultSet rs = c_conectar.consulta(st, sql);

        String[] titulos = new String[10];
        titulos[0] = "Fecha";
        titulos[1] = "Idsistema";
        titulos[2] = "Cantidad Kg";
        titulos[3] = "Codigo";
        titulos[4] = "DNI";
        titulos[5] = "Apellidos y Nombres";
        titulos[6] = "DNI Cuenta";
        titulos[7] = "Nro Cuenta";
        titulos[8] = "IDServicio";
        titulos[9] = "Servicio";

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
        File archivo = new File(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_corte_dia_liquidacion" + fecha + ".xls");

        System.out.println(dir.getAbsolutePath() + File.separator + "reportes" + File.separator + "rpt_corte_dia_liquidacion" + fecha + ".xls");

        // Creamos el libro de trabajo de Excel formato OOXML
        HSSFWorkbook workbook = new HSSFWorkbook();

        // La hoja donde pondremos los datos
        HSSFSheet pagina = workbook.createSheet("Corte del Dia");

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

                for (int i = 0; i < titulos.length; i++) {
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
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            System.out.println("Archivo no localizable en sistema de archivos");
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Error de entrada/salida");
        }
    }

    public void llenar_text() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        File dir = new File("");
        String archivo = dir.getAbsolutePath() + File.separator + "excel.csv";

        Statement st = c_conectar.conexion();
        String query = "select * from colaboradores order by codigo asc limit 10";
        ResultSet rs = c_conectar.consulta(st, query);

        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);

            try {
                String linea = "";
                linea = "borrar fila 1 y 2";
                pw.println(linea);
                linea = "idcolaborador, codigo, documento, idtipodocumento, apellidos, nombres, documentocuenta, nrocuenta, estado, nrollamadas";
                pw.println(linea);
                linea = "";
                while (rs.next()) {
                    linea
                            += rs.getString("idcolaborador") + ","
                            + rs.getString("codigo") + ","
                            + rs.getString("documento") + ","
                            + rs.getString("idtipodocumento") + ","
                            + rs.getString("apellidos") + ","
                            + rs.getString("nombres") + ","
                            + rs.getString("documentocuenta") + ","
                            + rs.getString("nrocuenta") + ","
                            + rs.getString("estado") + ","
                            + rs.getString("nro_llamadas");
                    System.out.println(linea);

                    pw.println(linea);
                    linea = "";

                }
                c_conectar.cerrar(st);
                c_conectar.cerrar(rs);
            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
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
                Desktop.getDesktop().open(new File(archivo));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
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
            modelo.addColumn("Tipo Documento");
            modelo.addColumn("Documento");
            modelo.addColumn("Apellidos y Nombres");
            modelo.addColumn("DNI. Dueño CTA");
            modelo.addColumn("Nro Cuenta");
            modelo.addColumn("Mensajes");
            modelo.addColumn("Estado");
            modelo.addColumn("");

            while (rs.next()) {
                int idestado = rs.getInt("estado");
                String sestado = "";

                if (idestado == 0) {
                    sestado = "ACTIVO";
                }
                if (idestado == 1) {
                    sestado = "DESCANSO";
                }
                Object[] fila = new Object[9];
                fila[0] = rs.getInt("codigo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("documento");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
                fila[4] = rs.getString("documentocuenta");
                fila[5] = rs.getString("nrocuenta");
                fila[6] = rs.getString("nro_llamadas");
                fila[7] = sestado;
                fila[8] = rs.getString("idcolaborador");

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
            tabla.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(1);
            tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            tabla.getColumnModel().getColumn(8).setMinWidth(0);

            c_varios.centrar_celda(tabla, 1);
            c_varios.centrar_celda(tabla, 2);
            c_varios.centrar_celda(tabla, 4);
            c_varios.centrar_celda(tabla, 5);
            c_varios.centrar_celda(tabla, 6);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void mostrarSinCuentas(JTable tabla, String query, String fechainicio) {
        String fecha_inicial = fechainicio;
        Date date_final = c_varios.suma_dia(fecha_inicial, -7);
        String fecha_final = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date_final);

        query = "select p.idcolaborador, c.codigo, c.documento, c.apellidos, c.nombres, c.documentocuenta, c.nrocuenta, pd.nombre "
                + "from pesaje as p inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                + "inner join parametros_detalles as pd on pd.iddetalles = c.idtipodocumento "
                + "where p.fecha BETWEEN '" + fecha_final + "' and '" + fecha_inicial + "' and (c.nrocuenta is NULL or c.documentocuenta IS NULL or c.nrocuenta = '' or c.documentocuenta = '') and (c.documento is not null or c.documento != '' ) "
                + "group by c.idcolaborador "
                + "order by c.apellidos, c.nombres asc";
        //System.out.println(query);
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
            modelo.addColumn("Tipo Documento");
            modelo.addColumn("Documento");
            modelo.addColumn("Apellidos y Nombres");
            modelo.addColumn("DNI. Dueño CTA");
            modelo.addColumn("Nro Cuenta");
            modelo.addColumn("");

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("codigo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("documento");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
                fila[4] = rs.getString("documentocuenta");
                fila[5] = rs.getString("nrocuenta");
                fila[6] = rs.getString("idcolaborador");

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
            tabla.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(1);
            tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);

            c_varios.centrar_celda(tabla, 0);
            c_varios.centrar_celda(tabla, 1);
            c_varios.centrar_celda(tabla, 2);
            c_varios.centrar_celda(tabla, 4);
            c_varios.centrar_celda(tabla, 5);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void mostrarCuentasModificadasxMi(JTable tabla, String query, String fechainicio) {
        String fecha_inicial = fechainicio;
        Date date_final = c_varios.suma_dia(fecha_inicial, -7);
        String fecha_final = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date_final);

        query = "select c.idcolaborador, c.codigo, c.documento, c.apellidos, c.nombres, c.documentocuenta, c.nrocuenta, c.fecha_modificacion, pd.nombre "
                + "from colaboradores as c "
                + "inner join parametros_detalles as pd on pd.iddetalles = c.idtipodocumento "
                + "where c.fecha_modificacion BETWEEN '" + fecha_final + "' and '" + fecha_inicial + "' and c.documento != '' and c.nrocuenta != '' "
                + "order by c.apellidos, c.nombres asc";
        //System.out.println(query);
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
            modelo.addColumn("Tipo Documento");
            modelo.addColumn("Documento");
            modelo.addColumn("Apellidos y Nombres");
            modelo.addColumn("DNI. Dueño CTA");
            modelo.addColumn("Nro Cuenta");
            modelo.addColumn("Fecha Modificacion");
            modelo.addColumn("");

            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("codigo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("documento");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
                fila[4] = rs.getString("documentocuenta");
                fila[5] = rs.getString("nrocuenta");
                fila[6] = rs.getString("fecha_modificacion");
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
            tabla.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(1);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
            tabla.getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setMinWidth(0);

            c_varios.centrar_celda(tabla, 0);
            c_varios.centrar_celda(tabla, 1);
            c_varios.centrar_celda(tabla, 2);
            c_varios.centrar_celda(tabla, 4);
            c_varios.centrar_celda(tabla, 5);

        } catch (SQLException e) {
            System.out.print(e);
        }
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
                idtipodocumento = rs.getInt("idtipodocumento");
                documentocuenta = rs.getString("documentocuenta");
                nrocuenta = rs.getString("nrocuenta");
                nro_llamadas = rs.getInt("nro_llamadas");
                estado = rs.getInt("estado");
                fechamodificacion = rs.getString("fecha_modificacion");
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

    public boolean validarDocumento() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select idcolaborador "
                    + "from colaboradores "
                    + "where documento = '" + this.documento + "'";
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

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into colaboradores "
                + "Values ('" + idcolaborador + "', '" + codigo + "', '" + idtipodocumento + "', '" + documento + "', '" + apellidos + "', '" + nombres + "', '" + documentocuenta + "', '" + nrocuenta + "', '" + estado + "', '" + nro_llamadas + "', '" + fechamodificacion + "')";
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public boolean corregirFormatoDocumento() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "update colaboradores set documentocuenta = PRINTF('%08d',documentocuenta), documento = PRINTF('%08d',documento) ";
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
                + "set apellidos ='" + apellidos + "', nombres ='" + nombres + "', documento ='" + documento + "', idtipodocumento='" + idtipodocumento + "', documentocuenta='" + documentocuenta + "', nrocuenta= '" + nrocuenta + "',estado= '" + estado + "', fecha_modificacion = '"+this.fechamodificacion+"' "
                + "where idcolaborador ='" + idcolaborador + "' ";
        // System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean actualizarCuenta() {
        boolean actualizado = false;
        fechamodificacion = c_varios.getFechaActual();
        Statement st = c_conectar.conexion();
        String query = "update colaboradores "
                + "set documentocuenta ='" + documentocuenta + "', nrocuenta ='" + nrocuenta + "', fecha_modificacion = '"+this.fechamodificacion+"' "
                + "where documento ='" + documento + "' and fecha_modificacion < '" + fechamodificacion + "' ";
        //System.out.println(query);
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
