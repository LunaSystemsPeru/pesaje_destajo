/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author luis
 */
public class o_clientes {

    private int id_cliente;
    private String razon_social;

    public o_clientes(int id_cliente, String razon_social) {
        this.id_cliente = id_cliente;
        this.razon_social = razon_social;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getRazon_social() {
        return razon_social;
    }

    @Override
    public String toString() {
        return razon_social;
    }

}
