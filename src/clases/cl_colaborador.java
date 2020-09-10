/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
                System.out.println(dir.getAbsolutePath() + File.separator + "excel.csv");

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