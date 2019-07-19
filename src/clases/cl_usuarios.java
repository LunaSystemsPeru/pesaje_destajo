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
public class cl_usuarios {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_usuario;
    private String username;
    private String contrasena;
    private String nombre_completo;
    private String telefono;
    private String email;

    public cl_usuarios() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean comprobar_usuario_nick() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
                       
            String query = "select id_usuario "
                    + "from usuarios "
                    + "where username = '" + username + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                id_usuario = rs.getInt("id_usuario");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from usuarios "
                    + "where id_usuario = '" + id_usuario + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                username = rs.getString("username");
                contrasena = rs.getString("contrasena");
                nombre_completo = rs.getString("nombre_completo");
                telefono = rs.getString("telefono");
                email = rs.getString("email");

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

            modelo.addColumn("id");
            modelo.addColumn("Username");
            modelo.addColumn("Nombre completos");
            modelo.addColumn("Telefono");
            modelo.addColumn("email");

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_usuario");
                fila[1] = rs.getString("username");
                fila[2] = rs.getString("nombre_completo");
                fila[3] = rs.getString("telefono");
                fila[4] = rs.getString("email");

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into usuarios "
                + "Values ('" + id_usuario + "', '" + username + "', '" + contrasena + "', '" + nombre_completo + "', '" + telefono + "', '" + email + "')";
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
            String query = "select ifnull(max(id_usuario) + 1, 1) as codigo "
                    + "from usuarios ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_usuario = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public void cargar_datos() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from usuarios "
                    + "where id_usuario='" + id_usuario + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {

                username = rs.getString("username");
                contrasena = rs.getString("contrasena");
                nombre_completo = rs.getString("nombre_completo");
                telefono = rs.getString("telefono");
                email = rs.getString("email");

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
        String query = "update usuarios "
                + "set username='" + username + "', contrasena='" + contrasena + "', nombre_completo='" + nombre_completo + "', telefono='" + telefono + "',email= '"
                + email + "' "
                + "where id_usuario='" + id_usuario + "' ";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }

}
