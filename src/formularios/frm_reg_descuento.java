package formularios;

import clases.cl_descuento;
import clases.cl_memoramdo;
import clases.cl_trabajadores_sucursal;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import pesaje_trabajos.frm_principal;
import vistas.frm_ver_descuentos;
import vistas.frm_ver_memorandos;
import vistas.frm_ver_tipo_servicio;

/**
 *
 * @author KALEK
 */
public class frm_reg_descuento extends javax.swing.JInternalFrame {

    cl_varios c_varios = new cl_varios();
    public static cl_descuento c_descuento = new cl_descuento();
    cl_trabajadores_sucursal c_trabajador = new cl_trabajadores_sucursal();

    public static boolean registrar;

    int id_cliente = frm_principal.c_sucursales.getId_cliente();
    int id_sucursal = frm_principal.c_sucursales.getId_sucursal();
    int id_usuario = frm_principal.c_usuario.getId_usuario();

    /**
     * Creates new form frm_reg_trabajo
     */
    public frm_reg_descuento() {
        initComponents();

        if (registrar == false) {
            c_descuento.cargar_datos();
            txt_motivo.setText(c_descuento.getMotivo());
            txt_monto.setText(c_descuento.getMonto() + "");
            txt_fecha.setText(c_varios.fecha_usuario(c_descuento.getFecha()));
            txt_motivo.setEnabled(true);
            txt_monto.setEnabled(true);
            txt_motivo.requestFocus();
            btn_modificar.setEnabled(true);
        } else {
            txt_fecha.setText(c_varios.fecha_usuario(c_varios.getFechaActual()));
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

        jToolBar1 = new javax.swing.JToolBar();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_colaborador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_motivo = new javax.swing.JTextField();
        txt_monto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Agregar Llamada de Atencion");

        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel1.setText("Descripcion:");

        jLabel3.setText("Colaborador:");

        jLabel5.setText("Buscar por Codigo:");

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
        });

        txt_colaborador.setEnabled(false);

        jLabel6.setText("Fecha:");

        try {
            txt_fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setEnabled(false);
        txt_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fechaKeyPressed(evt);
            }
        });

        jLabel2.setText("Enter para buscar");
        jLabel2.setEnabled(false);

        txt_motivo.setEnabled(false);
        txt_motivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_motivoKeyPressed(evt);
            }
        });

        txt_monto.setEnabled(false);
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_montoKeyPressed(evt);
            }
        });

        jLabel4.setText("Monto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_colaborador)
                    .addComponent(txt_motivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        //capturar a la bd de sistema
        c_descuento.setId_colaborador(Integer.parseInt(txt_codigo.getText()));
        c_descuento.setFecha(c_varios.fecha_myql(txt_fecha.getText()));
        c_descuento.setMotivo(txt_motivo.getText().toUpperCase());
        c_descuento.setMonto(Double.parseDouble(txt_monto.getText()));
        c_descuento.setId_cliente(id_cliente);
        c_descuento.setId_sucursal(id_sucursal);
        c_descuento.obtener_codigo();
        boolean registrado = c_descuento.registrar();

        if (registrado) {
            this.dispose();
            frm_ver_descuentos formulario = new frm_ver_descuentos();
            c_varios.llamar_ventana(formulario);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        c_descuento.setFecha(c_varios.fecha_myql(txt_fecha.getText()));
        c_descuento.setMotivo(txt_motivo.getText().toUpperCase());
        c_descuento.setMonto(Double.parseDouble(txt_monto.getText()));
        boolean actualizado = c_descuento.actualizar();

        if (actualizado) {
            this.dispose();
            frm_ver_descuentos formulario = new frm_ver_descuentos();
            c_varios.llamar_ventana(formulario);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        frm_ver_descuentos formulario = new frm_ver_descuentos();
        c_varios.llamar_ventana(formulario);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String codigo = txt_codigo.getText();
            if (c_varios.esEntero(codigo)) {
                c_trabajador.setId_trabajador(Integer.parseInt(codigo));
                c_trabajador.setId_cliente(id_cliente);
                c_trabajador.setId_sucursal(id_sucursal);
                c_trabajador.cargar_datos();
                txt_colaborador.setText(c_trabajador.getColaborador());
                txt_fecha.setEnabled(true);
                txt_fecha.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_codigoKeyPressed

    private void txt_fechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fechaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fecha.getText().length() == 10) {
                txt_motivo.setEnabled(true);
                btn_guardar.setEnabled(true);
                txt_motivo.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_fechaKeyPressed

    private void txt_motivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_motivoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_motivo.getText().length() > 0) {
                txt_monto.setEnabled(true);
                txt_monto.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_motivoKeyPressed

    private void txt_montoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_monto.getText().length() > 0) {
                String monto = txt_monto.getText();
                if (c_varios.esDecimal(monto)) {
                    btn_guardar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO");
                }
            }
        }
    }//GEN-LAST:event_txt_montoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_colaborador;
    private javax.swing.JFormattedTextField txt_fecha;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_motivo;
    // End of variables declaration//GEN-END:variables
}
