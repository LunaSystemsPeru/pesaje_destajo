/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author KALEK
 */
public class cl_pesaje_diario {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int id_pesaje;
    private int id_sucursal;
    private int id_cliente;
    private String fecha;
    private int id_tipo_trabajo;
    private int id_usuario;

    public cl_pesaje_diario() {
    }

    public int getId_pesaje() {
        return id_pesaje;
    }

    public void setId_pesaje(int id_pesaje) {
        this.id_pesaje = id_pesaje;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_tipo_trabajo() {
        return id_tipo_trabajo;
    }

    public void setId_tipo_trabajo(int id_tipo_trabajo) {
        this.id_tipo_trabajo = id_tipo_trabajo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean registrar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "insert into pesaje_diario "
                + "Values ('" + id_pesaje + "', '" + id_sucursal + "', '" + id_cliente + "', '" + fecha + "', '" + id_tipo_trabajo + "', '" + id_usuario + "')";
      //  System.out.println(query);
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
            String query = "select ifnull(max(id_pesaje) + 1, 1) as codigo "
                    + "from pesaje_diario "
                    + "where id_cliente='" + id_cliente + "' and id_sucursal= '" + id_sucursal + "' ";
         //   System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                id_pesaje = rs.getInt("codigo");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public Integer[] pesaje_mensual() {
        int total_mes = cl_varios.diasDelMes(c_varios.obtener_mes(), c_varios.obtener_anio());
        Integer[] valor_x = new Integer[total_mes];
       // System.out.println("total dias de este mes = " + total_mes);

        try {
            Statement st = c_conectar.conexion();
            String query = "select sum(pt.cantidad) as total_dia, strftime('%d', pd.fecha) as dia "
                    + "from pesaje_trabajador as pt "
                    + "inner join pesaje_diario as pd on pt.id_pesaje = pd.id_pesaje and pt.id_sucursal = pd.id_sucursal and pt.id_cliente = pd.id_cliente "
                    + "where pd.id_sucursal = '2' and pd.id_cliente = '2' and strftime('%Y', pd.fecha) =  strftime('%Y', current_date) and strftime('%m', pd.fecha) =  strftime('%m', current_date) "
                    + "group by pd.id_tipo_trabajo, pd.fecha "
                    + "order by pd.fecha asc";
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
