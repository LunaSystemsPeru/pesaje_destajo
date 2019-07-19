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

/**
 *
 * @author KALEK
 */
public class cl_pesaje_trabajador {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_trabajador;
    private int id_pesaje;
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

    public int getId_pesaje() {
        return id_pesaje;
    }

    public void setId_pesaje(int id_pesaje) {
        this.id_pesaje = id_pesaje;
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
        String query = "insert into pesaje_trabajador "
                + "Values ('" + id_trabajador + "', '" + hora + "','" + cantidad + "','" + id_pesaje + "','" + id_sucursal + "','" + id_cliente + "' )";
        System.out.println(query);
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

    public String[] mostrar_minimos() {
        String numero[] = new String[4];
        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_cantidad, max(pt.cantidad) as maximo, min(pt.cantidad) as minimo, avg(pt.cantidad) as promedio "
                    + "from pesaje_trabajador as pt "
                    + "  inner join pesaje_diario pd on pt.id_pesaje = pd.id_pesaje and pt.id_sucursal = pd.id_sucursal and pt.id_cliente = pd.id_cliente "
                    + "where pd.id_sucursal = '" + id_sucursal + "' and pd.id_cliente = '" + id_cliente + "' and strftime('%Y', pd.fecha) =  strftime('%Y', current_date)"
                    + "group by pd.id_tipo_trabajo";
            //System.out.println(query);
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
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pd.fecha)) as dias_produce, ts.colaborador "
                    + "from pesaje_trabajador as pt "
                    + "inner join pesaje_diario as pd on pt.id_pesaje = pd.id_pesaje and pt.id_sucursal = pd.id_sucursal and pt.id_cliente = pd.id_cliente "
                    + "inner join trabajadores_sucursal as ts on ts.id_trabajador = pt.id_trabajador and ts.id_sucursal = pt.id_sucursal and ts.id_cliente = pt.id_cliente "
                    + "where pd.id_sucursal = '" + id_sucursal + "' and pd.id_cliente = '" + id_cliente + "' and strftime('%Y', pd.fecha) =  strftime('%Y', current_date) "
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
            String query = "select sum(pt.cantidad) as total_produce, avg(pt.cantidad) as promedio_produce, count(distinct(pd.fecha)) as dias_produce, ts.colaborador "
                    + "from pesaje_trabajador as pt "
                    + "inner join pesaje_diario as pd on pt.id_pesaje = pd.id_pesaje and pt.id_sucursal = pd.id_sucursal and pt.id_cliente = pd.id_cliente "
                    + "inner join trabajadores_sucursal as ts on ts.id_trabajador = pt.id_trabajador and ts.id_sucursal = pt.id_sucursal and ts.id_cliente = pt.id_cliente "
                    + "where pd.id_sucursal = '" + id_sucursal + "' and pd.id_cliente = '" + id_cliente + "' and strftime('%Y', pd.fecha) =  strftime('%Y', current_date) "
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
}
