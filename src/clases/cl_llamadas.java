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
public class cl_llamadas {

    cl_conectar c_conectar = new cl_conectar();

    private int idllamada;
    private int idcolaborador;
    private String fecha;
    private String texto;
    private int idusuario;

    public cl_llamadas() {
    }

    public int getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(int idllamada) {
        this.idllamada = idllamada;
    }

    public int getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(int idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from llamadas_atencion "
                    + "where idllamadas = '" + idllamada + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                fecha = rs.getString("fecha");
                texto = rs.getString("mensaje");
                idcolaborador = rs.getInt("idcolaborador");
                idusuario = rs.getInt("idusuario");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public void mostrar(JTable tabla) {
        DefaultTableModel modelo;
        try {
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            String query = "select * from llamadas_atencion "
                    + "where idcolaborador = '" + this.idcolaborador + "' "
                    + "order by fecha asc";
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            modelo.addColumn("id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Mensaje");
            modelo.addColumn("Usuario");

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idllamadas");
                fila[1] = rs.getString("fecha");
                fila[2] = rs.getString("mensaje");
                fila[3] = rs.getString("idusuario");
                modelo.addRow(fila);
            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into llamadas_atencion "
                + "Values ('" + idllamada + "', '" + fecha + "', '" + texto + "', '" + idcolaborador + "', '" + idusuario + "')";
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
            String query = "select ifnull(max(idllamadas) + 1, 1) as codigo "
                    + "from llamadas_atencion ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                idllamada = rs.getInt("codigo");
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
        String query = "update llamadas_atencion "
                + "set mensaje ='" + texto + "' "
                + "where idllamadas ='" + idllamada + "' ";
       // System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
}
