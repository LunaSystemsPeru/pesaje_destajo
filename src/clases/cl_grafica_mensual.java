/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import pesaje_trabajos.frm_principal;

/**
 *
 * @author luis
 */
public class cl_grafica_mensual {

    cl_pesaje_trabajador c_pesaje = new cl_pesaje_trabajador();
    
    int id_cliente = frm_principal.c_sucursales.getId_cliente();
    int id_sucursal = frm_principal.c_sucursales.getId_sucursal();
    int id_usuario = frm_principal.c_usuario.getId_usuario();

    public void llenar_series(JPanel panel) {

        c_pesaje.setId_cliente(id_cliente);
        c_pesaje.setId_sucursal(id_sucursal);
        
        XYSeries series = new XYSeries("Kg");
        Integer[] valor_x = c_pesaje.pesaje_mensual();
       // System.out.println("canidad_items" + valor_x.length);

        for (int i = 1; i < valor_x.length; i++) {
            int valor = 0;
            if (valor_x[i] != null) {
                valor = valor_x[i];
            }
            series.add(i, valor);
            //System.out.println(i + " valor " + valor);
        }

// Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

// Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Pesaje del mes actual", // Title
                "dias", // x-axis Label
                "pesaje(kg)", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

        ChartPanel chartPanel = new ChartPanel((JFreeChart) null);
        chartPanel.setChart(chart);
        chartPanel.setBounds(0, 0, 419, 309);
        panel.add(chartPanel);
    }

}
