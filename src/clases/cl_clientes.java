
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
public class cl_clientes {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_cliente;
    private String ruc;
    private String razon_social;
    private String direccion;
    private String estado;
    private String condicion;

    public cl_clientes() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

//para conectar el a bd    
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
            modelo.addColumn("Ruc");
            modelo.addColumn("Razon Social");
            modelo.addColumn("Direccion");
            modelo.addColumn("Estado");
            modelo.addColumn("Condicion");

            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_cliente");
                fila[1] = rs.getString("ruc");
                fila[2] = rs.getString("razon_social");
                fila[3] = rs.getString("direccion");
                fila[4] = rs.getString("estado");
                fila[5] = rs.getString("condicion");

                modelo.addRow(fila);
            }
            
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(450);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(70);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(70);

        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into clientes "
                + "Values ('" + id_cliente + "', '" + ruc + "', '" + razon_social + "', '" + direccion + "', '" + estado + "', '" + condicion + "')";
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
            String query = "select ifnull(max(id_cliente) + 1, 1) as codigo "
                    + "from clientes ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_cliente = rs.getInt("codigo");
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
                    + "from clientes "
                    + "where id_cliente='" + id_cliente + "'";
            System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {

                ruc = rs.getString("ruc");
                razon_social = rs.getString("razon_social");
                direccion = rs.getString("direccion");
                estado = rs.getString("estado");
                condicion = rs.getString("condicion");

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
        String query = "update clientes "
                + "set ruc='" + ruc + "', razon_social='" + razon_social + "', direccion='" + direccion + "', estado='" + estado + "',condicion= '"
                + condicion + "' "
                + "where id_cliente='" + id_cliente + "' ";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            actualizado = true;
        }
        c_conectar.cerrar(st);
        return actualizado;
    }
        
        
        
       public boolean eliminar() {
        boolean eliminar = false;
        Statement st = c_conectar.conexion();
        String query = "delete from clientes "
                 + "where id_cliente = '" + id_cliente+ "'";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            eliminar = true;
        }
        c_conectar.cerrar(st);
        return eliminar; 
    }

       
       
    /*  public boolean comprobar_cliente() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from clientes "
                    + "where id_cliente = '" + codigo + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                documento = rs.getString("documento");
                nombre = rs.getString("nombre");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                celular = rs.getString("celular");
                ultima_venta = rs.getString("ultima_venta");
                venta = rs.getDouble("venta");
                pago = rs.getDouble("pago");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }*/
 /*       public boolean comprobar_cliente_doc() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select id_cliente "
                    + "from clientes "
                    + "where documento = '" + documento + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                codigo = rs.getInt("id_cliente");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    } */
        
       
}
