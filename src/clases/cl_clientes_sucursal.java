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
public class cl_clientes_sucursal {

    cl_conectar c_conectar = new cl_conectar();
    cl_trabajadores_sucursal c_colaborador = new cl_trabajadores_sucursal();

    private int id_sucursal;
    private int id_cliente;
    private String nombre;
    private String direccion;

    public cl_clientes_sucursal() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
            //c_conectar.conectar();
            Statement st = c_conectar.conexion();
            String query = "select id_sucursal,nombre,direccion "
                    + "from clientes_sucursal "
                    + "where id_cliente='" + id_cliente + "' ";
            ResultSet rs = c_conectar.consulta(st, query);

            //La cantidad de columnas que tiene la consulta
            //Establecer como cabezeras el nombre de las colimnas
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_sucursal");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("direccion");
                modelo.addRow(fila);
            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(450);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(id_sucursal) + 1, 1) as codigo "
                    + "from clientes_sucursal ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_sucursal = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into clientes_sucursal "
                + "Values ('" + id_sucursal + "', '" + id_cliente + "','" + nombre + "','" + direccion + "')";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public boolean actualizar() {
        boolean actualizado = false;
        Statement st = c_conectar.conexion();
        String query = "update clientes_sucursal "
                + "set nombre='" + nombre + "', direccion='" + direccion + "' "
                + "where id_sucursal='" + id_sucursal + "' and id_cliente='" + id_cliente + "' ";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
    
    
     public void cargar_datos() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from clientes_sucursal "
                    + "where id_sucursal='" + id_sucursal + "' and id_cliente='" + id_cliente + "' ";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
              
                nombre = rs.getString("nombre");
                direccion = rs.getString("direccion");
             
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

}
