/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author KALEK
 */
public class o_sucursal {
    
    private int id_sucursal;
    private String nombre;

    public o_sucursal(int id_sucursal, String nombre) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

   
    @Override
    public String toString(){
    return nombre;
    }
    
    
}
