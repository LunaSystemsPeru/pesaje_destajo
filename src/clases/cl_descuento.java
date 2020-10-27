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
public class cl_descuento {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int iddescuento;
    private String fecha;
    private int iditem;
    private double monto;
    private int idcolaborador;
    private int idusuario;

    public cl_descuento() {
    }

    public int getIddescuento() {
        return iddescuento;
    }

    public void setIddescuento(int iddescuento) {
        this.iddescuento = iddescuento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(int idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

            Statement st = c_conectar.conexion();
            String query = "select d.iddescuentos, d.monto, d.fecha, pd.nombre, u.username "
                    + "from descuentos as d "
                    + "inner join parametros_detalles as pd on pd.iddetalles = d.idarticulo "
                    + "inner join usuarios as u on u.idusuario = d.idusuario "
                    + "where d.idcolaborador = '" + this.idcolaborador + "' and fecha = '"+fecha+"' "
                    + "order by d.fecha asc "
                    + "limit 30";
            ResultSet rs = c_conectar.consulta(st, query);

            modelo.addColumn("Fecha");
            modelo.addColumn("Item");
            modelo.addColumn("Monto");
            modelo.addColumn("Registrado por");
            modelo.addColumn("");

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = c_varios.fecha_usuario(rs.getString("fecha"));
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getDouble("monto");
                fila[3] = rs.getString("username");
                fila[4] = rs.getInt("iddescuentos");

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(1);
            tabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into descuentos "
                + "Values ('" + iddescuento + "',"
                + " '" + fecha + "',"
                + " '" + monto + "',"
                + " '" + iditem + "',"
                + " '" + idcolaborador + "',"
                + " '" + idusuario + "')";
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
            String query = "select ifnull(max(iddescuentos) + 1, 1) as codigo "
                    + "from descuentos ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                iddescuento = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public boolean eliminar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "delete from descuentos "
                + "where iddescuentos ='" + iddescuento + "' ";
        //  System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
}
