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

/**
 *
 * @author luis
 */
public class m_clientes {
    
    cl_conectar c_conectar = new cl_conectar();
    
    public void cbx_clientes(JComboBox cbx) {
        try {
            Statement st = c_conectar.conexion();       
            String query = "select id_cliente, razon_social "
                    + "from clientes "
                    + "order by razon_social asc";
            ResultSet rs = c_conectar.consulta(st, query);
            
            while (rs.next()) {
                cbx.addItem(new o_clientes(rs.getInt("id_cliente"), rs.getString("razon_social")));
            }
            
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
