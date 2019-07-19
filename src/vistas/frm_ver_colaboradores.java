/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.cl_trabajadores_sucursal;
import clases.cl_varios;
import formularios.frm_reg_colaborador;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import pesaje_trabajos.frm_principal;

/**
 *
 * @author luis
 */
public class frm_ver_colaboradores extends javax.swing.JInternalFrame {

    cl_trabajadores_sucursal c_colaborador = new cl_trabajadores_sucursal();
    cl_varios c_varios = new cl_varios();
    int fila_seleccionada;
    int id_sucursal = frm_principal.c_sucursales.getId_sucursal();
    int id_cliente = frm_principal.c_sucursales.getId_cliente();

    /**
     * Creates new form frm_ver_colaboradores
     */
    public frm_ver_colaboradores() {
        initComponents();

        txt_fecha_reporte.setText(c_varios.fecha_usuario(c_varios.getFechaActual()));

        String query = "select * "
                + "from trabajadores_sucursal "
                + "where id_cliente='" + id_cliente + "'  and id_sucursal='" + id_sucursal + "' "
                + "order by colaborador asc";

        c_colaborador.mostrar(t_colaboradores, query);
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
        btn_reporte = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        t_colaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_colaboradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_colaboradores);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/magnifier.png"))); // NOI18N
        jLabel1.setText("Buscar por:");

        cbx_colaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "NOMBRE" }));
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
            c_colaborador.setId_trabajador(Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 0).toString()));
            btn_modificar.setEnabled(true);
            btn_d_baja.setEnabled(true);
            btn_reporte.setEnabled(true);
            btn_eliminar.setEnabled(true);
        }
    }//GEN-LAST:event_t_colaboradoresMouseClicked

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        frm_reg_colaborador.registrar = true;
        frm_reg_colaborador reg_colaborador = new frm_reg_colaborador();
        c_varios.llamar_ventana(reg_colaborador);
        this.dispose();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        frm_reg_colaborador.c_colaborador.setId_trabajador(c_colaborador.getId_trabajador());
        frm_reg_colaborador.registrar = false;
        frm_reg_colaborador reg_colaborador = new frm_reg_colaborador();
        c_varios.llamar_ventana(reg_colaborador);
        this.dispose();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Eliminar el Colaborador?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id_trabajador = Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 0).toString());
            c_colaborador.setId_trabajador(id_trabajador);
            c_colaborador.setId_sucursal(id_sucursal);
            c_colaborador.setId_cliente(id_cliente);
            c_colaborador.eliminar();
            String query = "select * "
                    + "from trabajadores_sucursal "
                    + "where id_cliente='" + id_cliente + "'  and id_sucursal='" + id_sucursal + "' "
                    + "order by colaborador asc";
            c_colaborador.mostrar(t_colaboradores, query);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_colaboradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_colaboradorKeyPressed

    private void txt_colaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyReleased
        String query = "";
        String text = txt_colaborador.getText();
        int tipo_busqueda = cbx_colaborador.getSelectedIndex();
        if (tipo_busqueda == 0) {
            query = "select * "
                    + "from trabajadores_sucursal "
                    + "where id_trabajador='" + text + "' and id_sucursal='" + id_sucursal + "' and id_cliente='" + id_cliente + "' "
                    + "order by colaborador asc";

        }
        if (tipo_busqueda == 1) {
            query = "select * "
                    + "from trabajadores_sucursal "
                    + "where colaborador like  '%" + text + "%' and id_sucursal='" + id_sucursal + "' and id_cliente='" + id_cliente + "' "
                    + "order by colaborador asc";
        }
        c_colaborador.mostrar(t_colaboradores, query);
    }//GEN-LAST:event_txt_colaboradorKeyReleased

    private void txt_colaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_colaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_colaboradorActionPerformed

    private void btn_d_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_d_bajaActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Esta Seguro de Anular el Colaborador?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id_trabajador = Integer.parseInt(t_colaboradores.getValueAt(fila_seleccionada, 0).toString());
            c_colaborador.setId_trabajador(id_trabajador);
            c_colaborador.setId_sucursal(id_sucursal);
            c_colaborador.setId_cliente(id_cliente);
            c_colaborador.elimbaja();
            String query = "select * "
                    + "from trabajadores_sucursal "
                    + "where id_cliente='" + id_cliente + "'  and id_sucursal='" + id_sucursal + "' "
                    + "order by colaborador asc";
            c_colaborador.mostrar(t_colaboradores, query);
        }
    }//GEN-LAST:event_btn_d_bajaActionPerformed

    private void btn_generar_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_reporteActionPerformed
        String fecha_inicio = c_varios.fecha_myql(txt_fecha_reporte.getText());

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("f_inicio", fecha_inicio);
        parametros.put("id_trabajador", c_colaborador.getId_trabajador());
        parametros.put("id_cliente", id_cliente);
        parametros.put("id_sucursal", id_sucursal);
        c_varios.ver_reporte_excel("rpt_excel_pesaje_diario_trabajador", parametros, "rpt_excel_pesaje_diario_trabajador");

    }//GEN-LAST:event_btn_generar_reporteActionPerformed

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
        jd_fecha.setModal(true);
        jd_fecha.setSize(400, 134);
        jd_fecha.setLocationRelativeTo(null);
        jd_fecha.setVisible(true);
    }//GEN-LAST:event_btn_reporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id_cliente", id_cliente);
        parametros.put("id_sucursal", id_sucursal);
        c_varios.ver_reporte_excel("rpt_excel_trabajadores", parametros, "rpt_excel_trabajadores");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_d_baja;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_generar_reporte;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_reporte;
    private javax.swing.JComboBox<String> cbx_colaborador;
    private javax.swing.JButton jButton1;
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
