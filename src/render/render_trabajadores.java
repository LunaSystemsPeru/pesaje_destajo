/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lubricante
 */
public class render_trabajadores extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        // SI EN CADA FILA DE LA TABLA LA CELDA 5 ES IGUAL A ACTIVO COLOR AZUL
        if (Integer.parseInt(String.valueOf(table.getValueAt(row, 9))) == 2) {
            setBackground(Color.green);
            setForeground(Color.black);
        }
        if (Integer.parseInt(String.valueOf(table.getValueAt(row, 9))) >= 3) {
            setBackground(Color.red);
            setForeground(Color.white);
        }
        if (Integer.parseInt(String.valueOf(table.getValueAt(row, 9))) == 0) {
            setBackground(Color.white);
            setForeground(Color.black);
        }

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }

}
