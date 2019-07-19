/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.cl_banco;
import clases.cl_json_entidad;
import clases.cl_trabajadores_sucursal;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import models.m_combobox;
import objects.o_combobox;
import org.json.simple.parser.ParseException;
import pesaje_trabajos.frm_principal;
import vistas.frm_ver_colaboradores;

/**
 *
 * @author luis
 */
public class frm_reg_colaborador extends javax.swing.JInternalFrame {

    public static cl_trabajadores_sucursal c_colaborador = new cl_trabajadores_sucursal();
    cl_varios c_varios = new cl_varios();
    m_combobox m_combobox = new m_combobox();
    cl_banco c_banco = new cl_banco();

    public static boolean registrar;

    /**
     * Creates new form frm_reg_colaborador
     */
    public frm_reg_colaborador() {
        initComponents();
        m_combobox.llenar_bancos(cbx_bancos);
        
        if (registrar == false) {
            c_colaborador.setId_cliente(frm_principal.c_sucursales.getId_cliente());
            c_colaborador.setId_sucursal(frm_principal.c_sucursales.getId_sucursal());

            c_colaborador.cargar_datos();
            System.out.println("cargar dni " + c_colaborador.getDni());
            txtdni.setText(c_colaborador.getDni());
            txtapnombre.setText(c_colaborador.getColaborador());
            txtdireccion.setText(c_colaborador.getDireccion());
            cbx_sexo.setSelectedIndex(c_colaborador.getSexo() - 1);
            cbx_estadoc.setSelectedIndex(c_colaborador.getEstado_civil() - 1);
            txttelefono.setText(c_colaborador.getTelefono());
            ftffecha.setText(c_varios.fecha_usuario(c_colaborador.getFecha_nacimiento()));
            c_banco.setId_banco(c_colaborador.getId_banco());
            c_banco.cargar_datos();
            cbx_bancos.setSelectedItem(c_banco.getNombre());
            txtnrocuenta.setText(c_colaborador.getNro_cuenta());

            //habilitar cambio de modificacion
            txtdni.setEnabled(true);
            txtapnombre.setEnabled(true);
            txtdireccion.setEnabled(true);
            cbx_sexo.setEnabled(true);
            cbx_estadoc.setEnabled(true);
            txttelefono.setEnabled(true);
            ftffecha.setEnabled(true);
            txtnrocuenta.setEnabled(true);
            cbx_bancos.setEnabled(true);
            btn_modificar.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdni = new javax.swing.JTextField();
        txtapnombre = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        ftffecha = new javax.swing.JFormattedTextField();
        cbx_sexo = new javax.swing.JComboBox<>();
        cbx_estadoc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtnrocuenta = new javax.swing.JTextField();
        cbx_bancos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Registrar Colaborador");

        jLabel1.setText("DNI:");

        jLabel2.setText("Apellidos y Nombres:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Sexo:");

        jLabel5.setText("Estado Civil:");

        jLabel6.setText("Telefono:");

        jLabel8.setText("Fecha Nacimiento:");

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

        txtdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdniKeyPressed(evt);
            }
        });

        txtapnombre.setEnabled(false);
        txtapnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtapnombreKeyPressed(evt);
            }
        });

        txtdireccion.setEnabled(false);
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdireccionKeyPressed(evt);
            }
        });

        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setEnabled(false);
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoKeyPressed(evt);
            }
        });

        try {
            ftffecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftffecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftffecha.setEnabled(false);
        ftffecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftffechaKeyPressed(evt);
            }
        });

        cbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO" }));
        cbx_sexo.setEnabled(false);
        cbx_sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_sexoKeyPressed(evt);
            }
        });

        cbx_estadoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTERO", "CASADO", "DIVORCIADO", "VIUDO" }));
        cbx_estadoc.setEnabled(false);
        cbx_estadoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_estadocKeyPressed(evt);
            }
        });

        jLabel9.setText("Nro Cuenta:");

        txtnrocuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnrocuenta.setEnabled(false);
        txtnrocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnrocuentaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnrocuentaKeyPressed(evt);
            }
        });

        cbx_bancos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BANCO DE CREDITO", "BANCO DE LA NACION", "BBVA ", "SCOTIABANK", "INTERBANK", " " }));
        cbx_bancos.setEnabled(false);
        cbx_bancos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_bancosKeyPressed(evt);
            }
        });

        jLabel7.setText("Banco:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnrocuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(cbx_bancos, 0, 464, Short.MAX_VALUE)
                    .addComponent(txtapnombre)
                    .addComponent(txtdireccion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_estadoc, javax.swing.GroupLayout.Alignment.LEADING, 0, 173, Short.MAX_VALUE)
                            .addComponent(txtdni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_sexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftffecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_estadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftffecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_bancos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnrocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
        frm_ver_colaboradores formulario = new frm_ver_colaboradores();
        c_varios.llamar_ventana(formulario);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        c_colaborador.setDni(txtdni.getText());
        c_colaborador.setColaborador(txtapnombre.getText());
        c_colaborador.setDireccion(txtdireccion.getText());
        c_colaborador.setSexo(cbx_sexo.getSelectedIndex() + 1);
        c_colaborador.setEstado_civil(cbx_estadoc.getSelectedIndex() + 1);
        c_colaborador.setTelefono(txttelefono.getText());
        c_colaborador.setId_cliente(frm_principal.c_sucursales.getId_cliente());
        c_colaborador.setId_sucursal(frm_principal.c_sucursales.getId_sucursal());
        c_colaborador.setFecha_nacimiento(c_varios.fecha_myql(ftffecha.getText()));
        c_colaborador.setNro_cuenta(txtnrocuenta.getText());
        o_combobox o_banco = (o_combobox) cbx_bancos.getSelectedItem();
        c_colaborador.setId_banco(o_banco.getId());

        c_colaborador.obtener_codigo();

        boolean registrado = c_colaborador.registrar();

        if (registrado) {
            this.dispose();
            frm_ver_colaboradores formulario = new frm_ver_colaboradores();
            c_varios.llamar_ventana(formulario);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void ftffechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftffechaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (ftffecha.getText().length() > 0) {
                cbx_bancos.setEnabled(true);
                cbx_bancos.requestFocus();
            }
        }
    }//GEN-LAST:event_ftffechaKeyPressed

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txttelefono.getText().length() > 0) {
                ftffecha.setEnabled(true);
                ftffecha.requestFocus();
            }
        }
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txtnrocuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnrocuentaKeyPressed
        // TODO add your handling code here:sss
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txttelefono.getText().length() > 0) {
                // txtestado.setEnabled(true);
                // txtestado.requestFocus();
                btn_guardar.setEnabled(true);

            }
        }
    }//GEN-LAST:event_txtnrocuentaKeyPressed

    private void txtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtdni.getText().length() == 8) {
                //dni
                try {
                    if (c_varios.verificar_conexion()) {
                        String json = cl_json_entidad.getJSONDNI(txtdni.getText());
                        //Lo mostramos
                        String datos = cl_json_entidad.showJSONDNI(json);
                        txtapnombre.setText(datos);
                    }
                    txtapnombre.setEnabled(true);
                    txtapnombre.requestFocus();

                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
                }

            }
        }
    }//GEN-LAST:event_txtdniKeyPressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        c_colaborador.setDni(txtdni.getText());
        c_colaborador.setColaborador(txtapnombre.getText());
        c_colaborador.setDireccion(txtdireccion.getText());
        c_colaborador.setSexo(cbx_sexo.getSelectedIndex() + 1);
        c_colaborador.setEstado_civil(cbx_estadoc.getSelectedIndex() + 1);
        c_colaborador.setTelefono(txttelefono.getText());
        c_colaborador.setId_cliente(frm_principal.c_sucursales.getId_cliente());
        c_colaborador.setId_sucursal(frm_principal.c_sucursales.getId_sucursal());
        c_colaborador.setFecha_nacimiento(c_varios.fecha_myql(ftffecha.getText()));
        c_colaborador.setNro_cuenta(txtnrocuenta.getText());

        boolean actualizado = c_colaborador.actualizar();

        if (actualizado) {
            this.dispose();
            frm_ver_colaboradores formulario = new frm_ver_colaboradores();
            c_varios.llamar_ventana(formulario);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txtapnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapnombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtapnombre.getText().length() > 0) {
                txtdireccion.setEnabled(true);
                txtdireccion.requestFocus();
            }
        }
    }//GEN-LAST:event_txtapnombreKeyPressed

    private void txtdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtdireccion.getText().length() > 0) {
                cbx_sexo.setEnabled(true);
                cbx_sexo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtdireccionKeyPressed

    private void cbx_sexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_sexoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbx_estadoc.setEnabled(true);
            cbx_estadoc.requestFocus();
        }
    }//GEN-LAST:event_cbx_sexoKeyPressed

    private void cbx_estadocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_estadocKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            txttelefono.setEnabled(true);
            txttelefono.requestFocus();
        }
    }//GEN-LAST:event_cbx_estadocKeyPressed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped

        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txtdni, 8);

    }//GEN-LAST:event_txtdniKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txttelefono, 9);
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtnrocuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnrocuentaKeyTyped

        c_varios.limitar_caracteres(evt, txtnrocuenta, 25);
    }//GEN-LAST:event_txtnrocuentaKeyTyped

    private void cbx_bancosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_bancosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtnrocuenta.setEnabled(true);
            txtnrocuenta.requestFocus();
        }
    }//GEN-LAST:event_cbx_bancosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cbx_bancos;
    private javax.swing.JComboBox<String> cbx_estadoc;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JFormattedTextField ftffecha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtapnombre;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnrocuenta;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}