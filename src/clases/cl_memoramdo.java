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
public class cl_memoramdo {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_memorando;
    private String fecha;
    private String contenido;
    private int id_trabajador;
    private int id_sucursal;
    private int id_cliente;

    public cl_memoramdo() {
    }

    public int getId_memorando() {
        return id_memorando;
    }

    public void setId_memorando(int id_memorando) {
        this.id_memorando = id_memorando;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
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

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id_memorandum");
                fila[1] = rs.getString("fecha");
                fila[2] = rs.getString("colaborador");
                fila[3] = rs.getString("descripcion");

                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(550);
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into memorandos "
                + "Values ('" + id_memorando + "', '" + fecha + "','" + contenido + "','" + id_trabajador + "', '" + id_sucursal + "', '" + id_cliente + "')";
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
            String query = "select ifnull(max(id_memorandum) + 1, 1) as codigo "
                    + "from memorandos ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_memorando = rs.getInt("codigo");
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
                    + "from memorandos "
                    + "where id_memorandum ='" + id_memorando + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {

                contenido = rs.getString("descripcion");
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
        String query = "update memorandos "
                + "set fecha ='" + fecha + "', descripcion='" + contenido + "' "
                + "where id_memorandum ='" + id_memorando + "'";
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
        String query = "delete from memorandos "
                + "where id_memorandum='" + id_memorando + "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public int contar_memos() {
        int contar = 0;
        try {
            Statement st = c_conectar.conexion();
            String query = "select count(*) as contar  "
                    + "from memorandos "
                    + "where id_trabajador = '" + id_trabajador + "' and id_cliente = '" + id_cliente + "' and id_sucursal = '" + id_sucursal + "'";
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                contar = rs.getInt("contar");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return contar;

    }
}
