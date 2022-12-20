/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import static formularios.frm_actualizar_cuentas.jLabel2;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariela
 */
public class HiloEnviaCuenta extends Thread {

    JsonAPI apijson = new JsonAPI();
    cl_varios Util = new cl_varios();
    Gson g = new Gson();
    JsonArray array;
    ArrayList Lista;

    @Override
    public void run() {
        leerArray();
    }

    public void setLista(ArrayList Lista) {
        this.Lista = Lista;
    }

    private void leerArray() {

        JOptionPane.showMessageDialog(null, "las Cuentas se estan enviando al servidor\nespere el mensaje de confirmacion");
        int item = 0;
        for (Iterator iterator = Lista.iterator(); iterator.hasNext();) {
            item++;
            Object next[] = (Object[]) iterator.next();

            array = new JsonArray();
            //personal.setDocumento(dnis.get(i).toString());
            JsonPrimitive documento = new JsonPrimitive(next[0].toString());
            JsonPrimitive documentocta = new JsonPrimitive(next[1].toString());
            JsonPrimitive numerocta = new JsonPrimitive(next[2].toString());
            JsonPrimitive fechamodificacion = new JsonPrimitive(next[3].toString());
            JsonObject object = new JsonObject();
            object.add("documento", documento);
            object.add("documentocuenta", documentocta);
            object.add("nrocuenta", numerocta);
            object.add("fechamodificacion", fechamodificacion);
            array.add(object);
            String json = "arraydocumentos=" + array.toString();
            //System.out.println(json);

            String respuesta = apijson.enviarCuentas(json);
            jLabel2.setText(item + " enviando CTa de : " + respuesta);

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }

        }

        jLabel2.setText("Cuentas Enviadas en base de datos");
        JOptionPane.showMessageDialog(null, "Cuentas Fueron enviadas\nRevisar si le falta cargar cuentas");
    }

}
