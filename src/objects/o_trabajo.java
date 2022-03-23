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
public class o_trabajo {
    
    private int id_tipo_trabajo;
    private String descripcion;

    public o_trabajo(int id_tipo_trabajo, String descripcion) {
        this.id_tipo_trabajo = id_tipo_trabajo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_trabajo() {
        return id_tipo_trabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
     @Override
    public String toString() {
        return descripcion;
    }
}
