/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.cl_colaborador;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import nicon.notify.core.Notification;
import vistas.frm_ver_colaboradores;

/**
 *
 * @author Mariela
 */
public class frm_colaborador extends javax.swing.JDialog {

    public static cl_colaborador c_colaborador = new cl_colaborador();
    cl_varios c_varios = new cl_varios();

    /**
     * Creates new form frm_colaborador
     */
    public frm_colaborador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (c_colaborador.getIdcolaborador() > 0) {
            c_colaborador.obtener_datos();
            txt_codigo.setText(c_colaborador.getCodigo() + "");
            txt_codigo.setEditable(false);
            txt_apellidos.setText(c_colaborador.getApellidos());
            txt_nombres.setText(c_colaborador.getNombres());
            txt_documento.setText(c_colaborador.getDocumento());
            txt_nrocuenta.setText(c_colaborador.getNrocuenta());
            btn_modificar.setEnabled(true);
            txt_apellidos.requestFocus();
        } else {
            c_colaborador.obtener_codigovisible();
            txt_codigo.setText(c_colaborador.getCodigo() + "");
            txt_codigo.setEditable(false);
            txt_apellidos.requestFocus();
            btn_guardar.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_documento = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        txt_apellidos = new javax.swing.JTextField();
        cbx_nacionalidad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_nrocuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administrar Colaborador");

        txt_documento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_documentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_documentoKeyTyped(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Activo");

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyPressed(evt);
            }
        });

        cbx_nacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERUANO", "VENEZOLANO", "COLOMBIANO", "OTRO" }));
        cbx_nacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_nacionalidadKeyPressed(evt);
            }
        });

        jLabel9.setText("Nro Cuenta:");

        jLabel1.setText("Nro Documento");

        txt_nrocuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nrocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nrocuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nrocuentaKeyTyped(evt);
            }
        });

        jLabel2.setText("Apellidos");

        jLabel10.setText("Codigo.");

        jLabel4.setText("Nacionalidad");

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
        });

        jToolBar1.setFloatable(false);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/accept.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.setFocusable(false);
        btn_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_guardar);

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/application_edit.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);
        btn_modificar.setFocusable(false);
        btn_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_modificar);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.setFocusable(false);
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_salir);

        jLabel11.setText("Nombres");

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombresKeyPressed(evt);
            }
        });

        jLabel3.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                        .addComponent(txt_nrocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nombres)
                        .addComponent(txt_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox1))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_documento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nrocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentoKeyPressed

    }//GEN-LAST:event_txt_documentoKeyPressed

    private void txt_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentoKeyTyped

        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_documento, 8);
    }//GEN-LAST:event_txt_documentoKeyTyped

    private void txt_apellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_apellidos.getText().length() > 0) {
                txt_nombres.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_apellidosKeyPressed

    private void cbx_nacionalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_nacionalidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_documento.requestFocus();
        }
    }//GEN-LAST:event_cbx_nacionalidadKeyPressed

    private void txt_nrocuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nrocuentaKeyPressed
        // TODO add your handling code here:sss
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_guardar.setEnabled(true);
        }
    }//GEN-LAST:event_txt_nrocuentaKeyPressed

    private void txt_nrocuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nrocuentaKeyTyped

        c_varios.limitar_caracteres(evt, txt_nrocuenta, 25);
    }//GEN-LAST:event_txt_nrocuentaKeyTyped

    private void llenar_datos() {
        c_colaborador.setCodigo(Integer.parseInt(txt_codigo.getText().trim()));
        c_colaborador.setApellidos(txt_apellidos.getText().trim().toUpperCase());
        c_colaborador.setNombres(txt_nombres.getText().trim().toUpperCase());
        c_colaborador.setIdnacionalidad(cbx_nacionalidad.getSelectedIndex() + 1);
        c_colaborador.setDocumento(txt_documento.getText().trim());
        c_colaborador.setNrocuenta(txt_nrocuenta.getText().trim());
    }
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        llenar_datos();
        if (!"".equals(c_colaborador.getApellidos()) & !"".equals(c_colaborador.getNombres())) {
            if (c_colaborador.getCodigo() == 0) {
                c_colaborador.obtener_codigovisible();
            }
            c_colaborador.obtener_codigo();

            boolean registrado = c_colaborador.registrar();

            if (registrado) {
                btn_salir.doClick();
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HA INGRESADO DATOS");
            txt_apellidos.requestFocus();
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        llenar_datos();
        if (!"".equals(c_colaborador.getApellidos()) & !"".equals(c_colaborador.getNombres())) {
            boolean actualizado = c_colaborador.actualizar();

            if (actualizado) {
                btn_salir.doClick();
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HA INGRESADO DATOS");
            txt_apellidos.requestFocus();
        }

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
        frm_ver_colaboradores.btn_actualizar.doClick();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void txt_nombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nombres.getText().length() > 0) {
                cbx_nacionalidad.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nombresKeyPressed

    private void txt_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            c_colaborador.setCodigo(Integer.parseInt(txt_codigo.getText()));
            if (c_colaborador.obtener_datos_codigo()) {
                Notification.show("Busqueda Colaborador", "El codigo ingresado ya existe");
                c_colaborador.obtener_datos();
                txt_apellidos.setText(c_colaborador.getApellidos());
                txt_nombres.setText(c_colaborador.getNombres());
                btn_guardar.setEnabled(false);
            }  else {
                btn_guardar.setEnabled(true);
            }
            txt_apellidos.requestFocus();
        }
    }//GEN-LAST:event_txt_codigoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_colaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_colaborador dialog = new frm_colaborador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cbx_nacionalidad;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_documento;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_nrocuenta;
    // End of variables declaration//GEN-END:variables
}
