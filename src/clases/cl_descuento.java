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
 * @author luis
 */
public class cl_descuento {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_descuento;
    private String fecha;
    private int id_colaborador;
    private int id_cliente;
    private int id_sucursal;
    private double monto;
    private String motivo;

    public cl_descuento() {
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
            //c_conectar.conectar();
            Statement st = c_conectar.conexion();
            ResultSet rs = c_conectar.consulta(st, query);

            //La cantidad de columnas que tiene la consulta
            //Establecer como cabezeras el nombre de las colimnas
            modelo.addColumn("Id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Trabajador");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Monto");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_descuento");
                fila[1] = rs.getString("fecha");
                fila[2] = rs.getString("colaborador");
                fila[3] = rs.getString("motivo");
                fila[4] = rs.getString("monto");

                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into descuentos "
                + "Values ('" + id_descuento + "', '" + fecha + "','" + monto + "','" + id_colaborador + "', '" + id_sucursal + "', '" + id_cliente + "', '" + motivo + "')";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(id_descuento) + 1, 1) as codigo "
                    + "from descuentos ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_descuento = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public boolean cargar_datos() {
        boolean existe = false;
        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from descuentos "
                    + "where id_descuento ='" + id_descuento + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {

                monto = rs.getDouble("monto");
                motivo = rs.getString("motivo");
                fecha = rs.getString("fecha");

                existe = true;
            } else {
                existe = false;
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public boolean actualizar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update descuentos "
                + "set fecha ='" + fecha + "', motivo ='" + motivo + "', monto = '" + monto + "' "
                + "where id_descuento ='" + id_descuento + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

    public boolean eliminar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "delete from descuentos "
                + "where id_descuento='" + id_descuento + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }
}
