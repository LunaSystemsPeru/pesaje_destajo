/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static formularios.frm_actualizar_cuentas.jLabel2;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mariela
 */
public class CuentasExteriores extends Thread {

    JsonAPI apijson = new JsonAPI();
    cl_varios Util = new cl_varios();

    public void run() {
            try {
                jLabel2.setText("Leyendo Cuentas del servidor, espere un momento");
                apijson.leerCuentasServidor();
                jLabel2.setText("Cuentas Modificadas en base de datos");
            } catch (ParseException e) {
                System.out.println(e.getLocalizedMessage());
            }
    }

}
