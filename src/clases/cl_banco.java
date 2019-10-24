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
public class cl_banco {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_banco;
    private String nombre;

    public cl_banco() {
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
            modelo.addColumn("Nombre");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("id_banco");
                fila[1] = rs.getString("nombre");

                modelo.addRow(fila);
            }

            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into bancos "
                + "Values ('" + id_banco + "', '" + nombre + "')";
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
            String query = "select ifnull(max(id_banco) + 1, 1) as codigo "
                    + "from bancos ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_banco = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

//paravisualizar los datos en el frame para modificar
    public void cargar_datos() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from bancos "
                    + "where id_banco='" + id_banco + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {

                nombre = rs.getString("nombre");

            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    //actualizar los datos modificados
    public boolean actualizar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update bancos "
                + "set nombre ='" + nombre + "' "
                + "where id_banco ='" + id_banco + "' ";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

}
