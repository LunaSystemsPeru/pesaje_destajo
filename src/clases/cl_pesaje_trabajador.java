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

    private int idpesaje;
    private String fecha;
    private String hora;
    private int idcolaborador;
    private int idservicio;
    private double cantidad;
    private int idusuario;

    public cl_pesaje_trabajador() {
    }

    public int getIdpesaje() {
        return idpesaje;
    }

    public void setIdpesaje(int idpesaje) {
        this.idpesaje = idpesaje;
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

    public int getIdcolaborador() {
        return idcolaborador;
    }

    public void setIdcolaborador(int idcolaborador) {
        this.idcolaborador = idcolaborador;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    //para guardar cuando hay problemas de llave primaria
    public void obtener_codigo() {
        try {
            Statement st = c_conectar.conexion();
            String query = "select ifnull(max(idpesaje) + 1, 1) as codigo "
                    + "from pesaje ";
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                idpesaje = rs.getInt("codigo");
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
        String query = "insert into pesaje "
                + "Values ('" + idpesaje + "','" + fecha + "','" + hora + "', '" + idcolaborador + "', '" + idusuario + "','" + cantidad + "','" + idservicio + "' )";
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
                    + "where fecha = '" + fecha + "' "
                    + "and idservicio = '" + idservicio + "' ";
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
                    + "where fecha = '" + fecha + "' "
                    + "and idservicio = '" + idservicio + "' and idcolaborador = '" + idcolaborador + "'";
          // System.out.println(query);
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
            String query = "select p.fecha, p.hora, c.codigo, c.idcolaborador, c.apellidos, c.nombres, p.cantidad "
                    + "from pesaje as p "
                    + "inner join colaboradores as c on c.idcolaborador = p.idcolaborador "
                    + "where p.fecha = '" + fecha + "' "
                    + "and p.idservicio = '" + idservicio + "' "
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
                fila[2] = rs.getString("codigo");
                fila[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
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

    public void ver_detalle_trabajador(JTable tabla) {
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
                    + "where p.fecha = '" + fecha + "' "
                    + "and p.idservicio = '" + idservicio + "' and p.idcolaborador = '" + idcolaborador + "' "
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
                    + "where strftime('%Y%m', pt.fecha) =  strftime('%Y%m', current_date)"
                    + "group by pt.idservicio";
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
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pt.fecha)) as dias_produce, ts.apellidos, ts.nombres "
                    + "from pesaje as pt "
                    + "inner join colaboradores as ts on ts.idcolaborador = pt.idcolaborador "
                    + "where strftime('%Y', pt.fecha) =  strftime('%Y', current_date) "
                    + "group by pt.idcolaborador "
                    + "order by sum(pt.cantidad) desc "
                    + "limit 1";
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                numero[0] = c_varios.formato_totales(rs.getDouble("total_produce"));
                numero[1] = c_varios.formato_totales(rs.getDouble("promedio_produce"));
                numero[2] = c_varios.formato_totales(rs.getDouble("dias_produce"));
                numero[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
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
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pt.fecha)) as dias_produce, ts.apellidos, ts.nombres "
                    + "from pesaje as pt "
                    + "inner join colaboradores as ts on ts.idcolaborador = pt.idcolaborador "
                    + "where strftime('%Y%m', pt.fecha) =  strftime('%Y%m', current_date) "
                    + "group by pt.idcolaborador "
                    + "order by sum(pt.cantidad) asc "
                    + "limit 1";
            ResultSet rs = c_conectar.consulta(st, query);

            if (rs.next()) {
                numero[0] = c_varios.formato_totales(rs.getDouble("total_produce"));
                numero[1] = c_varios.formato_totales(rs.getDouble("promedio_produce"));
                numero[2] = c_varios.formato_totales(rs.getDouble("dias_produce"));
                numero[3] = rs.getString("apellidos") + " " + rs.getString("nombres");
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
                    + "where strftime('%Y', pt.fecha) =  strftime('%Y', current_date) and strftime('%m', pt.fecha) =  strftime('%m', current_date) "
                    + "group by pt.idservicio, pt.fecha "
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
