/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
            String query = "select * "
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
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("codigo");
                fila[1] = rs.getString("idnacionalidad");
                fila[2] = rs.getString("documento");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
                fila[4] = rs.getString("nrocuenta");
                fila[5] = rs.getString("nro_llamdas");
                fila[6] = rs.getString("estado");
                fila[7] = rs.getString("idcolaborador");

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);

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
        System.out.println(query);
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
        System.out.println(query);
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
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
}
