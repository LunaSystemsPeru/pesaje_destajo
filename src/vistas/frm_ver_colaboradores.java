/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.cl_colaborador;
import clases.cl_varios;
import formularios.frm_colaborador;
import formularios.frm_load_colaborador;
import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class frm_ver_colaboradores extends javax.swing.JInternalFrame {
    
    cl_colaborador c_colaborador = new cl_colaborador();
    cl_varios c_varios = new cl_varios();
    int fila_seleccionada;
    String query;

    /**
     * Creates new form frm_ver_colaboradores
     */
    public frm_ver_colaboradores() {
        initComponents();
        
        txt_fecha_reporte.setText(c_varios.fecha_usuario(c_varios.getFechaActual()));
        
        query = "select * "
                + "from colaboradores "
                + "order by apellidos asc, nombres asc";
        
        c_colaborador.mostrar(t_colaboradores, query);
    }
    
    private void activar_botones() {
        btn_modificar.setEnabled(true);
        btn_d_baja.setEnabled(true);
        btn_reporte.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }
    
    private void desactivar_botones() {
        btn_modificar.setEnabled(false);
        btn_d_baja.setEnabled(false);
        btn_reporte.setEnabled(false);
        btn_eliminar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_fecha = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        btn_generar_reporte = new javax.swing.JButton();
        txt_fecha_reporte = new javax.swing.JFormattedTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_d_baja = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_reporte = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_cerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_colaboradores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbx_colaborador = new javax.swing.JComboBox<>();
        txt_colaborador = new javax.swing.JTextField();

        jLabel2.setText("Buscar por Fecha:");

        btn_generar_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clipboard_text.png"))); // NOI18N
        btn_generar_reporte.setText("Generar Reporte");
        btn_generar_reporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_generar_reporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_generar_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_reporteActionPerformed(evt);
            }
        });

        try {
            txt_fecha_reporte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jd_fechaLayout = new javax.swing.GroupLayout(jd_fecha.getContentPane());
        jd_fecha.getContentPane().setLayout(jd_fechaLayout);
        jd_fechaLayout.setHorizontalGroup(
            jd_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_fechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fecha_reporte)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btn_generar_reporte)
                .addContainerGap())
        );
        jd_fechaLayout.setVerticalGroup(
            jd_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_fechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jd_fechaLayout.createSequentialGroup()
                        .addComponent(btn_generar_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jd_fechaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fecha_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setTitle("Ver Colaboradores");

        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_nuevo);

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/application_edit.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);
        btn_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modificar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_modificar);

        btn_d_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/error.png"))); // NOI18N
        btn_d_baja.setText("Dar de Baja");
        btn_d_baja.setEnabled(false);
        btn_d_baja.setFocusable(false);
        btn_d_baja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_d_baja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_d_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_d_bajaActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_d_baja);
        jToolBar1.add(jSeparator1);

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/trash_16.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        btn_eliminar.setFocusable(false);
        btn_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_eliminar);

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clipboard_text.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setFocusable(false);
        btn_actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_actualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_actualizar);

        btn_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clipboard_text.png"))); // NOI18N
        btn_reporte.setText("Rpt. Pesaje");
        btn_reporte.setEnabled(false);
        btn_reporte.setFocusable(false);
        btn_reporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_reporte);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/excel.png"))); // NOI18N
        jButton1.setText("Lista Excel ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/excel.png"))); // NOI18N
        jButton2.setText("Importar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cross.png"))); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cerrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_cerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_cerrar);

        t_colaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        t_colaboradores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        t_colaboradores.setRowHeight(20);
        t_colaboradores.setShowHorizontalLines(false);
        t_colaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_colaboradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_colaboradores);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/magnifier.png"))); // NOI18N
        jLabel1.setText("Buscar por:");

        cbx_colaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "CODIGO" }));
        cbx_colaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_colaboradorActionPerformed(evt);
            }
        });

        txt_colaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_colaboradorActionPerformed(evt);
            }
        });
        txt_colaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_colaboradorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_colaboradorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void cbx_colaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_colaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_colaboradorActionPerformed

    private void t_colaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_colaboradoresMouseClicked
        
        if (evt.getClickCount() == 2) {
            //capture el nro de fla
            fila_seleccionada = t_colaboradores.getSelectedRow();
            //capturar id colaborador
            c_colaborador.setIdcolaborador(Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 7).toString()));
            activar_botones();
        }
    }//GEN-LAST:event_t_colaboradoresMouseClicked

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        Frame f = JOptionPane.getRootFrame();
        frm_colaborador.c_colaborador.setIdcolaborador(0);
        frm_colaborador dialog = new frm_colaborador(f, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        desactivar_botones();
        Frame f = JOptionPane.getRootFrame();
        frm_colaborador.c_colaborador.setIdcolaborador(this.c_colaborador.getIdcolaborador());
        frm_colaborador dialog = new frm_colaborador(f, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        desactivar_botones();
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Eliminar el Colaborador?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id_trabajador = Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 7).toString());
            c_colaborador.setIdcolaborador(id_trabajador);
            c_colaborador.eliminar();
            c_colaborador.mostrar(t_colaboradores, query);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_colaboradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_colaboradorKeyPressed

    private void txt_colaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyReleased
        String text = txt_colaborador.getText();
        int tipo_busqueda = cbx_colaborador.getSelectedIndex();
        if (tipo_busqueda == 1) {
            query = "select * "
                    + "from colaboradores "
                    + "where codigo ='" + text + "' "
                    + "order by apellidos, nombres asc";
            
        }
        if (tipo_busqueda == 0) {
            query = "select * "
                    + "from colaboradores "
                    + "where apellidos || ' ' || nombres like  '%" + text + "%' "
                    + "order by apellidos, nombres asc";
        }
        c_colaborador.mostrar(t_colaboradores, query);
    }//GEN-LAST:event_txt_colaboradorKeyReleased

    private void txt_colaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_colaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_colaboradorActionPerformed

    private void btn_d_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_d_bajaActionPerformed
        desactivar_botones();
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de dar de Baja al Colaborador?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id_trabajador = Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 7).toString());
            c_colaborador.setIdcolaborador(id_trabajador);
            c_colaborador.darbaja();
            c_colaborador.mostrar(t_colaboradores, query);
        }
    }//GEN-LAST:event_btn_d_bajaActionPerformed

    private void btn_generar_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_reporteActionPerformed
        String fecha_inicio = c_varios.fecha_myql(txt_fecha_reporte.getText());
        

    }//GEN-LAST:event_btn_generar_reporteActionPerformed

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
        desactivar_botones();
        jd_fecha.setModal(true);
        jd_fecha.setSize(400, 134);
        jd_fecha.setLocationRelativeTo(null);
        jd_fecha.setVisible(true);
    }//GEN-LAST:event_btn_reporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        c_colaborador.mostrar(t_colaboradores, query);
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Frame f = JOptionPane.getRootFrame();
        frm_load_colaborador dialog = new frm_load_colaborador(f, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_d_baja;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_generar_reporte;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_reporte;
    private javax.swing.JComboBox<String> cbx_colaborador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDialog jd_fecha;
    private javax.swing.JTable t_colaboradores;
    private javax.swing.JTextField txt_colaborador;
    private javax.swing.JFormattedTextField txt_fecha_reporte;
    // End of variables declaration//GEN-END:variables
}
