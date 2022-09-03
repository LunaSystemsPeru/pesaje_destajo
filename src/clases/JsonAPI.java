/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import formularios.frm_actualizar_cuentas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mariela
 */
public class JsonAPI {
    
    cl_colaborador Colaborador = new cl_colaborador();
    
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36";
    
    public JsonAPI() {
    }
    
    public String getJsonCuentasServidor() {
        
        StringBuffer response = null;
        
        try {
            //Generar la URL
            //String url = SERVER_PATH + "consultas_json/composer/consulta_sunat_JMP.php?ruc=" + ruc;
            String url = "https://gthconsultora.ml/ajax/obtenerListaObrerosCuenta.php";
            //Creamos un nuevo objeto URL con la url donde pedir el JSON
            URL obj = new URL(url);
            //Creamos un objeto de conexión
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Añadimos la cabecera
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            // Enviamos la petición por POST
            con.setDoOutput(true);
            //Capturamos la respuesta del servidor
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            //if (responseCode != 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
            //System.out.println("Respuesta del servidor: " + response);
            //cerramos la conexión
            in.close();
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return response.toString();
    }
    
    public void leerCuentasServidor() throws ParseException {
        String json = getJsonCuentasServidor();
        ArrayList datos = new ArrayList(7);
        System.out.println("INFORMACIÓN OBTENIDA DE LA BASE DE DATOS:");
        
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement obj = parser.parse(json);
        JsonArray arr = obj.getAsJsonArray();
        //JsonObject jobject = arr.get(0).getAsJsonObject();
        for (Iterator iterator = arr.iterator(); iterator.hasNext();) {
            JsonObject next = (JsonObject) iterator.next();
            Colaborador.setDocumento(next.get("nrodocumento").getAsString());
            if (Colaborador.validarDocumento()) {
                Colaborador.setDocumentocuenta(next.get("nrodnititular").getAsString());
                Colaborador.setNrocuenta(next.get("nrocuenta").getAsString());
                Colaborador.setFechamodificacion(next.get("fec_modificacion").getAsString());
                Colaborador.actualizarCuenta();
                frm_actualizar_cuentas.jLabel2.setText("Modificando cuenta de " + next.get("nombres").getAsString());
                //System.out.println("Modificando cuenta de " + next.get("nombres").getAsString());
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }
    }
    
    public void crearJsonDnis(ArrayList dnis) {
        Gson g = new Gson();
        
        
        JsonArray array = new JsonArray();
        ArrayList listajson = new ArrayList();
        
        for (int i = 0; i < dnis.size(); i++) {
            //personal.setDocumento(dnis.get(i).toString());
            JsonPrimitive elemento = new JsonPrimitive(dnis.get(i).toString());
            JsonObject object = new JsonObject();
            object.add("documento", elemento);
            array.add(object);
            listajson.add(object);
        }
        //generar json 
         String json = "arraydocumentos=" + array.toString();
        //String json = new Gson().toJson(listajson);
        System.out.println(json);
        
        String url = "https://gthconsultora.ml/ajax/obtenerCuentasxDocumento.php";
        
        StringBuffer response = null;
        
        try {
            //Creamos un nuevo objeto URL con la url donde pedir el JSON
            URL obj = new URL(url);
            //Creamos un objeto de conexión
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Añadimos la cabecera
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            // Enviamos la petición por POST
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            //Capturamos la respuesta del servidor
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            //if (responseCode != 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
            System.out.println("Respuesta del servidor: " + response);
            //cerramos la conexión
            in.close();
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //leer json y mostrar datos
        ArrayList datos = new ArrayList(7);
        //System.out.println("INFORMACIÓN OBTENIDA DE LA BASE DE DATOS:");

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement obj = parser.parse(response.toString());
        JsonArray arr = obj.getAsJsonArray();
        //JsonObject jobject = arr.get(0).getAsJsonObject();
        for (Iterator iterator = arr.iterator(); iterator.hasNext();) {
            JsonObject next = (JsonObject) iterator.next();
            Colaborador.setDocumento(next.get("nrodocumento").getAsString());
            if (Colaborador.validarDocumento()) {
                Colaborador.setDocumentocuenta(next.get("nrodnititular").getAsString());
                Colaborador.setNrocuenta(next.get("nrocuenta").getAsString());
                Colaborador.setFechamodificacion(next.get("fec_modificacion").getAsString());
                Colaborador.actualizarCuenta();
                frm_actualizar_cuentas.jLabel2.setText("Modificando cuenta de " + next.get("nombres").getAsString());
                //System.out.println("Modificando cuenta de " + next.get("nombres").getAsString());
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }
    }
    
    public void enviarCuentas (String json) {
        String url = "https://gthconsultora.ml/ajax/obtenerCuentasModificadas.php";
        
        StringBuffer response = null;
        
        try {
            //Creamos un nuevo objeto URL con la url donde pedir el JSON
            URL obj = new URL(url);
            //Creamos un objeto de conexión
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Añadimos la cabecera
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            // Enviamos la petición por POST
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            //Capturamos la respuesta del servidor
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            //if (responseCode != 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
            System.out.println("Respuesta del servidor: " + response);
            //cerramos la conexión
            in.close();
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
