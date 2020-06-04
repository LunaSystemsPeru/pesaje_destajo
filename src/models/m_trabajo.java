package models;

import clases.cl_conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import objects.o_trabajo;

public class m_trabajo {

    cl_conectar c_conectar = new cl_conectar();

    public void cbx_trabajo(JComboBox cbx) {
        cbx.removeAllItems();
        try {
            Statement st = c_conectar.conexion();
            String query = "select iddetalles, nombre, valor "
                    + "from parametros_detalles "
                    + "where idparametros = '4' "
                    + "order by nombre asc";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                cbx.addItem(new o_trabajo(rs.getInt("iddetalles"), rs.getString("nombre")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }

    }
}
