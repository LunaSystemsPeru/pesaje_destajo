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
    cl_reporte c_reporte = new cl_reporte();
    int id_usuario = frm_principal.c_usuario.getId_usuario();

    public void llenar_series(JPanel panel) {

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
    
    public void SeriesCortadoresDia(JPanel panel) {

        XYSeries series = new XYSeries("Nro");
        Integer[] valor_x = c_pesaje.cortadoresMensual();
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

    public void llenar_horas(JPanel panel, String fecha) {

        XYSeries series = new XYSeries("Kg");
        Integer[] valor_x = c_reporte.pesaje_horas_dia(fecha);
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
                "Pesaje x Horas", // Title
                "Hora", // x-axis Label
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
        panel.removeAll();
        panel.add(chartPanel);
        panel.repaint();
    }

}
