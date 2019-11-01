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
public class cl_pesaje_trabajador {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_trabajador;
    private int id_tipo_trabajo;
    private String fecha;
    private String hora;
    private Double cantidad;
    private int id_sucursal;
    private int id_cliente;

    public cl_pesaje_trabajador() {
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getId_tipo_trabajo() {
        return id_tipo_trabajo;
    }

    public void setId_tipo_trabajo(int id_tipo_trabajo) {
        this.id_tipo_trabajo = id_tipo_trabajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
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

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into pesaje "
                + "Values ('" + id_trabajador + "','" + id_sucursal + "','" + id_cliente + "', '" + fecha + "', '" + hora + "','" + cantidad + "','" + id_tipo_trabajo + "' )";
        //System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }
    
    
    
    public double obtener_total_fecha() {
        double total_cantidad = 0;
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(cantidad) as total "
                    + "from pesaje "
                    + "where fecha = '" + fecha + "' and id_sucursal = '" + id_sucursal + "' and id_cliente = '" + id_cliente + "' "
                    + "and id_tipo_trabajo = '" + id_tipo_trabajo + "' ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                total_cantidad = rs.getDouble("total");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return total_cantidad;

    }
    
    public double obtener_total_trabajador_fecha() {
        double total_cantidad = 0;
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(cantidad) as total "
                    + "from pesaje "
                    + "where fecha = '" + fecha + "' and id_sucursal = '" + id_sucursal + "' and id_cliente = '" + id_cliente + "' "
                    + "and id_tipo_trabajo = '" + id_tipo_trabajo + "' and id_trabajador = '"+id_trabajador+"'";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                total_cantidad = rs.getDouble("total");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return total_cantidad;

    }
    
    public void ver_pesaje_fecha(DefaultTableModel modelo) {
      //  DefaultTableModel modelo;
        try {
           /* modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
*/
            Statement st = c_conectar.conexion();
            String query = "select p.fecha, p.hora, ts.id_trabajador, ts.colaborador, p.cantidad "
                    + "from pesaje as p "
                    + "inner join trabajadores_sucursal as ts on ts.id_cliente = p.id_cliente and ts.id_sucursal = p.id_sucursal and ts.id_trabajador = p.id_trabajador "
                    + "where p.fecha = '" + fecha + "' and p.id_sucursal = '" + id_sucursal + "' and p.id_cliente = '" + id_cliente + "' "
                    + "and p.id_tipo_trabajo = '" + id_tipo_trabajo + "' "
                    + "order by p.hora asc";
           // System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);
/*
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Id.");
            modelo.addColumn("Colaborador");
            modelo.addColumn("Cantidad");
*/
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("fecha");
                fila[1] = rs.getString("hora");
                fila[2] = rs.getString("id_trabajador");
                fila[3] = rs.getString("colaborador");
                fila[4] = c_varios.formato_numero(rs.getDouble("cantidad"));

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

         /*   tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(450);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
            c_varios.centrar_celda(tabla, 0);
            c_varios.centrar_celda(tabla, 1);
            c_varios.centrar_celda(tabla, 2);
            c_varios.derecha_celda(tabla, 4);
*/

        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
    public void ver_detalle_trabajador (JTable tabla) {
        DefaultTableModel modelo;
        try {
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            Statement st = c_conectar.conexion();
            String query = "select p.fecha, p.hora, p.cantidad "
                    + "from pesaje as p "
                    + "where p.fecha = '" + fecha + "' and p.id_sucursal = '" + id_sucursal + "' and p.id_cliente = '" + id_cliente + "' "
                    + "and p.id_tipo_trabajo = '" + id_tipo_trabajo + "' and p.id_trabajador = '"+id_trabajador+"' "
                    + "order by p.hora asc";
           // System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Cantidad");

            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("fecha");
                fila[1] = rs.getString("hora");
                fila[2] = c_varios.formato_numero(rs.getDouble("cantidad"));

                modelo.addRow(fila);

            }
            c_conectar.cerrar(st);
            c_conectar.cerrar(rs);

            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
            c_varios.centrar_celda(tabla, 0);
            c_varios.centrar_celda(tabla, 1);
            c_varios.derecha_celda(tabla, 2);
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public String[] mostrar_minimos() {
        String numero[] = new String[4];
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_cantidad, max(pt.cantidad) as maximo, min(pt.cantidad) as minimo, avg(pt.cantidad) as promedio "
                    + "from pesaje as pt "
                    + "where pt.id_sucursal = '" + id_sucursal + "' and pt.id_cliente = '" + id_cliente + "' and strftime('%Y', pt.fecha) =  strftime('%Y', current_date)"
                    + "group by pt.id_tipo_trabajo";
           // System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                numero[0] = c_varios.formato_totales(rs.getDouble("total_cantidad"));
                numero[1] = c_varios.formato_totales(rs.getDouble("maximo"));
                numero[2] = c_varios.formato_totales(rs.getDouble("minimo"));
                numero[3] = c_varios.formato_totales(rs.getDouble("promedio"));
            } else {
                numero[0] = "0.00";
                numero[1] = "0.00";
                numero[2] = "0.00";
                numero[3] = "0.00";
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return numero;
    }

    public String[] mostrar_mas_produce() {
        String numero[] = new String[4];
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pt.fecha)) as dias_produce, ts.colaborador "
                    + "from pesaje as pt "
                    + "inner join trabajadores_sucursal as ts on ts.id_trabajador = pt.id_trabajador and ts.id_sucursal = pt.id_sucursal and ts.id_cliente = pt.id_cliente "
                    + "where pt.id_sucursal = '" + id_sucursal + "' and pt.id_cliente = '" + id_cliente + "' and strftime('%Y', pt.fecha) =  strftime('%Y', current_date) "
                    + "group by pt.id_trabajador "
                    + "order by sum(pt.cantidad) desc "
                    + "limit 1";
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                numero[0] = c_varios.formato_totales(rs.getDouble("total_produce"));
                numero[1] = c_varios.formato_totales(rs.getDouble("promedio_produce"));
                numero[2] = c_varios.formato_totales(rs.getDouble("dias_produce"));
                numero[3] = rs.getString("colaborador");
            } else {
                numero[0] = "0.00";
                numero[1] = "0.00";
                numero[2] = "0.00";
                numero[3] = "NO HAY DATOS";
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return numero;
    }
    
    public String[] mostrar_menos_produce() {
        String numero[] = new String[4];
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pt.fecha)) as dias_produce, ts.colaborador "
                    + "from pesaje as pt "
                    + "inner join trabajadores_sucursal as ts on ts.id_trabajador = pt.id_trabajador and ts.id_sucursal = pt.id_sucursal and ts.id_cliente = pt.id_cliente "
                    + "where pt.id_sucursal = '" + id_sucursal + "' and pt.id_cliente = '" + id_cliente + "' and strftime('%Y', pt.fecha) =  strftime('%Y', current_date) "
                    + "group by pt.id_trabajador "
                    + "order by sum(pt.cantidad) asc "
                    + "limit 1";
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                numero[0] = c_varios.formato_totales(rs.getDouble("total_produce"));
                numero[1] = c_varios.formato_totales(rs.getDouble("promedio_produce"));
                numero[2] = c_varios.formato_totales(rs.getDouble("dias_produce"));
                numero[3] = rs.getString("colaborador");
            } else {
                numero[0] = "0.00";
                numero[1] = "0.00";
                numero[2] = "0.00";
                numero[3] = "NO HAY DATOS";
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return numero;
    }
    
    public Integer[] pesaje_mensual() {
        int total_mes = cl_varios.diasDelMes(c_varios.obtener_mes(), c_varios.obtener_anio());
        Integer[] valor_x = new Integer[total_mes];
        // System.out.println("total dias de este mes = " + total_mes);

        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_dia, strftime('%d', pt.fecha) as dia "
                    + "from pesaje as pt "
                    + "where pt.id_sucursal = '"+id_sucursal+"' and pt.id_cliente = '"+id_cliente+"' and strftime('%Y', pt.fecha) =  strftime('%Y', current_date) and strftime('%m', pt.fecha) =  strftime('%m', current_date) "
                    + "group by pt.id_tipo_trabajo, pt.fecha "
                    + "order by pt.fecha asc";
            //  System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                valor_x[rs.getInt("dia")] = rs.getInt("total_dia");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return valor_x;
    }
    
}
