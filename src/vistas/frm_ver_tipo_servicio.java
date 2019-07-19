/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.cl_tipo_trabajo;
import clases.cl_varios;
import formularios.frm_reg_trabajo;
import pesaje_trabajos.frm_principal;

/**
 *
 * @author luis
 */
public class frm_ver_tipo_servicio extends javax.swing.JInternalFrame {

    cl_varios c_varios = new cl_varios();
    cl_tipo_trabajo c_tipo_trabajo = new cl_tipo_trabajo();
    int fila_seleccionada;
    int id_sucursal = frm_principal.c_sucursales.getId_sucursal();
    int id_cliente = frm_principal.c_sucursales.getId_cliente();

    public frm_ver_tipo_servicio() {
        initComponents();
        String query = "select tt.id_tipo_trabajo, tt.descripcion, tt.tope, c.razon_social, cs.nombre as nsucursal, tt.preciokg "
                + "from tipo_trabajo as tt "
                + "inner join clientes as c on c.id_cliente = tt.id_cliente "
                + "inner join clientes_sucursal as cs on cs.id_sucursal = tt.id_sucursal and cs.id_cliente = tt.id_cliente "
                + "where tt.id_sucursal = '" + id_sucursal + "' and tt.id_cliente = '" + id_cliente + "'";
        c_tipo_trabajo.mostrar(t_servicio, query);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_frm_servicio = new javax.swing.JDialog();
        jToolBar5 = new javax.swing.JToolBar();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_servicio = new javax.swing.JTable();

        jToolBar5.setFloatable(false);
        jToolBar5.setEnabled(false);
        jToolBar5.setOpaque(false);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        jButton11.setText("Grabar");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/application_edit.png"))); // NOI18N
        jButton12.setText("Modificar");
        jButton12.setEnabled(false);
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cross.png"))); // NOI18N
        jButton13.setText("Salir");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(jButton13);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Id.");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Precio x Kg.");

        jTextField1.setEnabled(false);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jd_frm_servicioLayout = new javax.swing.GroupLayout(jd_frm_servicio.getContentPane());
        jd_frm_servicio.getContentPane().setLayout(jd_frm_servicioLayout);
        jd_frm_servicioLayout.setHorizontalGroup(
            jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addGroup(jd_frm_servicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(jd_frm_servicioLayout.createSequentialGroup()
                        .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jd_frm_servicioLayout.setVerticalGroup(
            jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_frm_servicioLayout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_frm_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setTitle("Ver Tipos de Servicios");

        jToolBar4.setFloatable(false);
        jToolBar4.setEnabled(false);
        jToolBar4.setOpaque(false);

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
        jToolBar4.add(btn_nuevo);

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
        jToolBar4.add(btn_modificar);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cross.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.setFocusable(false);
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jToolBar4.add(btn_salir);

        t_servicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "DESTAJO", "25.00"},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID.", "Nombre", "Precio x KG"
            }
        ));
        t_servicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_servicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_servicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        frm_reg_trabajo.registrar = true;
        frm_reg_trabajo reg_trabajo = new frm_reg_trabajo();
        c_varios.llamar_ventana(reg_trabajo);
        this.dispose();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        frm_reg_trabajo.c_tipo_trabajo.setId_tipo_trabajo(c_tipo_trabajo.getId_tipo_trabajo());
        frm_reg_trabajo.registrar = false;
        frm_reg_trabajo reg_trabajo = new frm_reg_trabajo();
        c_varios.llamar_ventana(reg_trabajo);
        this.dispose();

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();

    }//GEN-LAST:event_btn_salirActionPerformed

    private void t_servicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_servicioMouseClicked
        if (evt.getClickCount() == 2) {
            //capture el nro de fla
            fila_seleccionada = t_servicio.getSelectedRow();
            //capturar id cliente
            c_tipo_trabajo.setId_tipo_trabajo(Integer.parseInt(t_servicio.getValueAt(fila_seleccionada, 0).toString()));
            btn_modificar.setEnabled(true);
        }
    }//GEN-LAST:event_t_servicioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JDialog jd_frm_servicio;
    private javax.swing.JTable t_servicio;
    // End of variables declaration//GEN-END:variables
}
