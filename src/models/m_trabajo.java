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

    public void cbx_trabajo(JComboBox cbx, int id_sucursal, int id_cliente) {
        cbx.removeAllItems();
        try {
            Statement st = c_conectar.conexion();
            String query = "select id_tipo_trabajo, descripcion "
                    + "from tipo_trabajo "
                    + "where id_cliente= '" + id_cliente + "' and id_sucursal= '" + id_sucursal + "' "
                    + "order by descripcion asc";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                cbx.addItem(new o_trabajo(rs.getInt("id_tipo_trabajo"), rs.getString("descripcion")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }

    }
}
