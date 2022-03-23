/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.cl_colaborador;
import clases.cl_parametro_detalle;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import models.m_combobox;
import nicon.notify.core.Notification;
import objects.o_combobox;
import vistas.frm_ver_colaboradores;

/**
 *
 * @author Mariela
 */
public class frm_colaborador extends javax.swing.JDialog {

    public static cl_colaborador c_colaborador = new cl_colaborador();
    cl_varios c_varios = new cl_varios();
    m_combobox ComboBox = new m_combobox();

    /**
     * Creates new form frm_colaborador
     */
    public frm_colaborador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ComboBox.setId(5);
        ComboBox.llenarComboBox(cbx_nacionalidad);

        if (c_colaborador.getIdcolaborador() > 0) {
            c_colaborador.obtener_datos();
            txt_codigo.setText(c_colaborador.getCodigo() + "");
            txt_codigo.setEditable(false);
            txt_documento.setText(c_colaborador.getDocumento());
            txt_apellidos.setText(c_colaborador.getApellidos());
            txt_nombres.setText(c_colaborador.getNombres());
            txt_documentocuenta.setText(c_colaborador.getDocumentocuenta());
            txt_nrocuenta.setText(c_colaborador.getNrocuenta());
            if (c_colaborador.getDocumento().equals(c_colaborador.getDocumentocuenta())) {
                jCheckBox2.setSelected(true); 
            } else {
                jCheckBox2.setSelected(false); 
            }
            btn_modificar.setEnabled(true);
            txt_apellidos.requestFocus();
        } else {
            c_colaborador.obtener_codigovisible();
            txt_codigo.setText(c_colaborador.getCodigo() + "");
            txt_codigo.setEditable(false);
            txt_documento.requestFocus();
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

        jCheckBox1 = new javax.swing.JCheckBox();
        jToolBar1 = new javax.swing.JToolBar();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_documento = new javax.swing.JTextField();
        cbx_nacionalidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_documentocuenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_nrocuenta = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administrar Colaborador");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Activo");

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

        jLabel3.setText("Estado:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Trabajador"));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Codigo.");

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Nombres");

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombresKeyPressed(evt);
            }
        });

        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellidos");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nro Doc. Identidad:");

        txt_documento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_documentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_documentoKeyTyped(evt);
            }
        });

        cbx_nacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CARNET EXTRANJERIA", "PASAPORTE", "CARNET IDENTIDAD" }));
        cbx_nacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_nacionalidadKeyPressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo Documento:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("DNI del Trabajador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbx_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Pago"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nro Documento");

        txt_documentocuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_documentocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_documentocuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_documentocuentaKeyTyped(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nro Cuenta:");

        txt_nrocuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nrocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nrocuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nrocuentaKeyTyped(evt);
            }
        });

        jCheckBox2.setText("es mi cuenta");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Escribir dni del dueño de la cuenta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_documentocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nrocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_documentocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nrocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_documentocuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentocuentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nrocuenta.requestFocus();
        }
    }//GEN-LAST:event_txt_documentocuentaKeyPressed

    private void txt_documentocuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentocuentaKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_documentocuenta, 8);
    }//GEN-LAST:event_txt_documentocuentaKeyTyped

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
            int largocuenta = txt_nrocuenta.getText().length();
            if (largocuenta == 13 || largocuenta == 14 || largocuenta == 0) {
                if (c_colaborador.getIdcolaborador() > 0) {
                    btn_modificar.setEnabled(true);
                } else {
                    btn_guardar.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "FALTAN DIGITOS A LA CUENTA");
            }
        }
    }//GEN-LAST:event_txt_nrocuentaKeyPressed

    private void txt_nrocuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nrocuentaKeyTyped
        c_varios.limitar_caracteres(evt, txt_nrocuenta, 14);
        c_varios.solo_numeros(evt);
    }//GEN-LAST:event_txt_nrocuentaKeyTyped

    private void llenar_datos() {
        c_colaborador.setCodigo(Integer.parseInt(txt_codigo.getText().trim()));
        c_colaborador.setApellidos(txt_apellidos.getText().trim().toUpperCase());
        c_colaborador.setNombres(txt_nombres.getText().trim().toUpperCase());
        o_combobox combo = (o_combobox) cbx_nacionalidad.getSelectedItem();
        c_colaborador.setIdtipodocumento(combo.getId());
        c_colaborador.setDocumentocuenta(txt_documentocuenta.getText().trim());
        c_colaborador.setDocumento(txt_documento.getText().trim());
        c_colaborador.setNrocuenta(txt_nrocuenta.getText().trim());
        if (txt_nrocuenta.getText().length() > 12) {
            c_colaborador.setFechamodificacion(c_varios.getFechaActual());
        } else {
            c_colaborador.setFechamodificacion("1000-01-01");
        }
    }
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        llenar_datos();
        if (c_colaborador.validarDocumento()) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE Numero de DNI\nEl trabajador ya se encuentra registrado");
            txt_apellidos.setText("");
        } else {
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
                txt_documentocuenta.requestFocus();
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
            } else {
                btn_guardar.setEnabled(true);
            }
            cbx_nacionalidad.requestFocus();
        }
    }//GEN-LAST:event_txt_codigoKeyPressed

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_codigo, 5);
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void txt_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentoKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_documento, 8);
    }//GEN-LAST:event_txt_documentoKeyTyped

    private void txt_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_documentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int largodni = txt_documento.getText().length();
            if (largodni == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese Nro de DNI del Trabajador");
                txt_documento.requestFocus();
            } else if (largodni < 8 && largodni > 0) {
                JOptionPane.showMessageDialog(null, "Ingrese numero correcto del documento.\nEl numero que ingreso tiene " + largodni + " digitos");
                txt_documento.requestFocus();
                txt_documento.selectAll();
            } else {
                String texto = txt_documento.getText().trim();
                c_colaborador.setDocumento(texto);
                if (c_colaborador.validarDocumento()) {
                    JOptionPane.showMessageDialog(null, "Este nro de documento ya esta registrado \nVerifique");
                    txt_apellidos.setEnabled(false);
                    txt_documento.selectAll();
                    txt_documento.requestFocus();
                } else {
                    txt_apellidos.setEnabled(true);
                    txt_apellidos.requestFocus();
                }

            }
        }
    }//GEN-LAST:event_txt_documentoKeyPressed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            txt_documentocuenta.setText(txt_documento.getText().trim());
        } else {
            txt_documentocuenta.setText("");
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

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
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_documento;
    private javax.swing.JTextField txt_documentocuenta;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_nrocuenta;
    // End of variables declaration//GEN-END:variables
}
