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
 * @author KALEK
 */
public class cl_tipo_trabajo {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_tipo_trabajo;
    private String descripcion;
    private int id_sucursal;
    private int id_cliente;
    private double preciokg;
    private double tope;

    public cl_tipo_trabajo() {
    }

    public int getId_tipo_trabajo() {
        return id_tipo_trabajo;
    }

    public void setId_tipo_trabajo(int id_tipo_trabajo) {
        this.id_tipo_trabajo = id_tipo_trabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getPreciokg() {
        return preciokg;
    }

    public void setPreciokg(double preciokg) {
        this.preciokg = preciokg;
    }

    public double getTope() {
        return tope;
    }

    public void setTope(double tope) {
        this.tope = tope;
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
            //c_conectar.conectar

            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            modelo.addColumn("Id");
            modelo.addColumn("Cliente");
            modelo.addColumn("Sucursal");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Tope");
            modelo.addColumn("Preciokg");
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_tipo_trabajo");
                fila[1] = rs.getString("razon_social");
                fila[2] = rs.getString("nsucursal");
                fila[3] = rs.getString("descripcion");
                fila[4] = rs.getString("tope");
                fila[5] = rs.getString("preciokg");

                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from tipo_trabajo "
                    + "where id_tipo_trabajo = '" + id_tipo_trabajo + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                descripcion = rs.getString("descripcion");
                id_sucursal = rs.getInt("id_sucursal");
                id_cliente = rs.getInt("id_cliente");
                preciokg = rs.getDouble("preciokg");
                tope = rs.getInt("tope");
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
        String query = "insert into tipo_trabajo "
                + "Values ('" + id_tipo_trabajo + "', '" + descripcion + "', '" + id_sucursal + "', '" + id_cliente + "', '" + preciokg + "', '" + tope + "')";
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    //para guarar cuano hay porblemas de llave primaria
    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(id_tipo_trabajo) + 1, 1) as codigo "
                    + "from tipo_trabajo ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_tipo_trabajo = rs.getInt("codigo");
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
        String query = "update tipo_trabajo "
                + "set descripcion='" + descripcion + "', id_sucursal='" + id_sucursal + "', id_cliente='" + id_cliente + "', preciokg='" + preciokg + "' "
                + "where id_tipo_trabajo='" + id_tipo_trabajo + "' ";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
}
