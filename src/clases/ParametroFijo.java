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
 * @author Mariela
 */
public class ParametroFijo {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    private int idplanta;
    private String nombreplanta;
    private String turno;
    private int aplicadescuento;
    private double descuentodia;
    private double topepesada;

    public ParametroFijo() {
    }

    public int getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public String getNombreplanta() {
        return nombreplanta;
    }

    public void setNombreplanta(String nombreplanta) {
        this.nombreplanta = nombreplanta;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAplicadescuento() {
        return aplicadescuento;
    }

    public void setAplicadescuento(int aplicadescuento) {
        this.aplicadescuento = aplicadescuento;
    }

    public double getDescuentodia() {
        return descuentodia;
    }

    public void setDescuentodia(double descuentodia) {
        this.descuentodia = descuentodia;
    }

    public double getTopepesada() {
        return topepesada;
    }

    public void setTopepesada(double topepesada) {
        this.topepesada = topepesada;
    }

    public boolean obtener_datos() {
        boolean existe = false;

        try {
            Statement st = c_conectar.conexion();
            String query = "select * "
                    + "from parametros_fijos "
                    + "where idsede = '" + this.idplanta + "'";
            //System.out.println(query);
            ResultSet rs = c_conectar.consulta(st, query);

            while (rs.next()) {
                existe = true;
                this.nombreplanta = rs.getString("nombresede");
                this.turno = rs.getString("turnosede");
                this.aplicadescuento = rs.getInt("aplica_descuento");
                this.descuentodia = rs.getDouble("descuentos_xdia");
                this.topepesada = rs.getDouble("tope_pesada");
            }
            c_conectar.cerrar(rs);
            c_conectar.cerrar(st);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

        return existe;
    }

    public boolean modificar() {
        boolean registrado = false;
        Statement st = c_conectar.conexion();
        String query = "update parametros_fijos "
                + "set nombresede = '" + this.nombreplanta + "', turnosede = '" + this.turno + "', aplica_descuento = '" + this.aplicadescuento + "', descuentos_xdia = '" + this.descuentodia + "', tope_pesada = '" + this.topepesada + "' "
                + "where idsede = '" + this.idplanta + "'";
        int resultado = c_conectar.actualiza(st, query);
        if (resultado > -1) {
            registrado = true;
        }
        c_conectar.cerrar(st);
        return registrado;
    }

}
