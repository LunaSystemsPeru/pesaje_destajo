/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;

import br.com.adilson.util.PrinterMatrix;
import clases.cl_colaborador;
import clases.cl_conectar;
import clases.cl_descuento;
import clases.cl_parametro_detalle;
import clases.cl_pesaje_trabajador;
import clases.cl_varios;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author gerenciatecnica
 */
public class Print_Pesaje_Corte_Dia {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    cl_parametro_detalle c_detalle = new cl_parametro_detalle();
    cl_colaborador c_colaborador = new cl_colaborador();
    cl_descuento c_descuento = new cl_descuento();
    cl_pesaje_trabajador c_pesaje = new cl_pesaje_trabajador();

    leer_numeros leer = new leer_numeros();

    private final String fecha;
    private final int idcolaborador;
    private String nombreempresa;
    private String rucempresa;

    public Print_Pesaje_Corte_Dia(String fecha, int idcolaborador) {
        this.fecha = fecha;
        this.idcolaborador = idcolaborador;
        c_detalle.setIddetalle(2);
        c_detalle.obtener_datos();
        nombreempresa = c_detalle.getNombre();
        rucempresa = c_detalle.getValor();

        c_colaborador.setIdcolaborador(idcolaborador);
        c_colaborador.obtener_datos();
    }

    public void generar_ticket() {
        PrinterMatrix printer = new PrinterMatrix();

        double totaldescuentos = 0;
        double pagokilos = 0;
        double totalcobro = 0;
        //  Extenso e = new Extenso();
        //   e.setNumber(101.85);
        printer.setOutSize(19, 40);

        //imprimir cabezera
        printer.printTextLinCol(1, 1, varios_impresion.centrar_texto(40, "** " + nombreempresa + " **"));
        printer.printTextLinCol(2, 1, varios_impresion.centrar_texto(40, "RUC: " + rucempresa));

        printer.printTextLinCol(4, 1, "COD: " + c_colaborador.getCodigo());
        printer.printTextLinCol(5, 1, c_colaborador.getDatos());
        printer.printTextLinCol(6, 1, "FECHA PESAJE: " + c_varios.fecha_usuario(fecha));

        int inicioitem = 8;
        c_pesaje.setFecha(fecha);
        c_pesaje.setIdcolaborador(idcolaborador);

        ArrayList aservicios = c_pesaje.obtenerServiciosFecha();
        for (Object aservicio : aservicios) {
            //castear a objeto
            Object oservicios[] = (Object[]) aservicio;

            int iidservicio = Integer.parseInt(oservicios[0].toString());
            c_pesaje.setIdservicio(iidservicio);
            c_detalle.setIddetalle(iidservicio);
            c_detalle.obtener_datos();
            double pagokg = Double.parseDouble(c_detalle.getValor());
            int nropesadas = c_pesaje.contar_pesadas_trabajador_fecha();
            double totalkios = c_pesaje.obtener_total_trabajador_fecha();
            
            double pagoservicio = totalkios * pagokg;
            pagoservicio = Math.floor(pagoservicio);
            pagokilos += pagoservicio;

            String textoizquierda = varios_impresion.texto_izquierda(25, oservicios[1].toString() + " - " + pagokg);
            String textoderecha = varios_impresion.texto_derecha(14, "Pesadas: " + nropesadas + "");

            printer.printTextLinCol(inicioitem, 1, textoizquierda + textoderecha);

            inicioitem++;
            
            String textoizquierda2 = varios_impresion.texto_izquierda(20, "TOT KG: " + c_varios.formato_numero(totalkios));
            String textoderecha2 = varios_impresion.texto_derecha(20, "A PAGAR:  S/ " + c_varios.formato_numero(pagoservicio) + ""); 
            printer.printTextLinCol(inicioitem, 1, textoizquierda2 + textoderecha2);
        }

        inicioitem++;
        inicioitem++;
        printer.printTextLinCol(inicioitem, 1, "DESCUENTOS:");
        c_descuento.setFecha(fecha);
        c_descuento.setIdcolaborador(idcolaborador);
        ArrayList adescuentos = c_descuento.AgruparDescuentosTrabajador();

        for (Object descuento : adescuentos) {
            inicioitem++;
            //castear objeto a arraylist 
            ArrayList objeto = (ArrayList) descuento;

            String descuentoizquierda = varios_impresion.texto_izquierda(30, objeto.get(0).toString());
            double valordescuento = Double.parseDouble(objeto.get(1).toString());
            totaldescuentos += valordescuento;
            String descuentoderecha = varios_impresion.texto_derecha(10, "S/ " + c_varios.formato_totales(valordescuento));
            //mostrar linea de decuento 
            //item  - s/ precio
            printer.printTextLinCol(inicioitem, 1, descuentoizquierda + descuentoderecha);
        }

        inicioitem++;
        inicioitem++;
        totalcobro = pagokilos - totaldescuentos;
        printer.printTextLinCol(inicioitem, 1, varios_impresion.texto_derecha(40, "POR COBRAR: S/ " + c_varios.formato_numero(totalcobro)));

        inicioitem++;
        inicioitem++;
        printer.printTextLinCol(inicioitem, 1, "IMPRESO: " + c_varios.getFechaHora());

        //mostrar en consola
        printer.show();

        //grabar en txt
        printer.toFile("impresion.txt");

        //enviar a imprimir
        //leer archivo
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        //comandos impresora para reiniciar y cortar
        byte[] initEP = new byte[]{0x1b, '@'};
        byte[] cutP = new byte[]{0x1d, 'V', 1};

        //inciiar servicio impresion
        PrinterService printerService = new PrinterService();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        printerService.printBytes(defaultPrintService.getName(), initEP);

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;

        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        /*
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (PrintException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "error al imprimir \n" + ex.getLocalizedMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen impresoras instaladas");
            System.err.println("No existen impresoras instaladas");
        }

        //enviar comando de corte
        printerService.printBytes(defaultPrintService.getName(), cutP);
         */
    }

}
