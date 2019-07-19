/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import clases.cl_conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import objects.o_clientes;
import objects.o_sucursal;

/**
 *
 * @author KALEK
 */
public class m_sucursal {

    cl_conectar c_conectar = new cl_conectar();

    public void cbx_sucursales(JComboBox cbx, int id_cliente) {
        try {
            Statement st = c_conectar.conexion();
            String query = "select id_sucursal, nombre "
                    + "from clientes_sucursal "
                    + "where id_cliente= '" + id_cliente + "' "
                    + "order by nombre asc";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                cbx.addItem(new o_sucursal(rs.getInt("id_sucursal"), rs.getString("nombre")));
            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
