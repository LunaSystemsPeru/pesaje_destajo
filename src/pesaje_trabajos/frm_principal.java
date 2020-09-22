/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesaje_trabajos;

import clases.cl_conectar;
import clases.cl_pesaje_trabajador;
import clases.cl_reporte;
import clases.cl_usuarios;
import clases.cl_varios;
import formularios.frm_reg_pesaje;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import vistas.frm_ver_colaboradores;
import vistas.frm_ver_usuarios;
import vistas.frm_ver_parametros;

/**
 *
 * @author luis
 */
public class frm_principal extends javax.swing.JFrame {

    cl_conectar c_conectar = new cl_conectar();
    cl_varios c_varios = new cl_varios();

    public static cl_usuarios c_usuario = new cl_usuarios();

    cl_pesaje_trabajador c_pesaje_trabajador = new cl_pesaje_trabajador();

    /**
     * Creates new form frm_principal
     */
    public frm_principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println(c_varios.getHoraActual());
        c_conectar.conectar();
        cargar_login();

        txt_fecha_inicio.setText(c_varios.fecha_usuario(c_varios.getFechaActual()));

        cargar_mas_produce();
        cargar_menos_produce();
        cargar_resumen_anual();
    }

    private void cargar_login() {
        JDialog dialogo = new frm_login(this, true);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
    }

    private void cargar_resumen_anual() {
        String[] resumen_anual = c_pesaje_trabajador.mostrar_minimos();
        lbl_pe_maximo.setText(resumen_anual[1]);
        lbl_pe_minimo.setText(resumen_anual[2]);
        lbl_pe_promedio.setText(resumen_anual[3]);
        lbl_pe_total.setText(resumen_anual[0]);
    }

    private void cargar_mas_produce() {
        String[] resultado = c_pesaje_trabajador.mostrar_mas_produce();
        lbl_dtrabajados_mas.setText(resultado[2]);
        lbl_ppromedio_mas.setText(resultado[1]);
        lbl_tpesaje_mas.setText(resultado[0]);
        lbl_trabajador_mas.setText(resultado[3]);
    }

    private void cargar_menos_produce() {
        String[] resultado = c_pesaje_trabajador.mostrar_menos_produce();
        lbl_dtrabajados_menos.setText(resultado[2]);
        lbl_ppromedio_menos.setText(resultado[1]);
        lbl_tpesaje_menos.setText(resultado[0]);
        lbl_trabajador_menos.setText(resultado[3]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_menu_reportes = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        cbx_reporte = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_fecha_inicio = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_generar_excel = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_exit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_exit1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_pe_maximo = new javax.swing.JTextField();
        lbl_pe_minimo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_pe_promedio = new javax.swing.JTextField();
        lbl_pe_total = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbl_trabajador_mas = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_tpesaje_mas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbl_ppromedio_mas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lbl_dtrabajados_mas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lbl_trabajador_menos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_tpesaje_menos = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_ppromedio_menos = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_dtrabajados_menos = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        jd_menu_reportes.setTitle("Seleccionar Reporte");

        jLabel6.setText("Seleccionar Reporte");

        cbx_reporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rpt. Pesaje Diario", "Rpt. Pesaje - calculo de pagos", "Rpt. Pesaje Detalle dias trabajados" }));
        cbx_reporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_reporteItemStateChanged(evt);
            }
        });

        jLabel7.setText("Escriba Fecha ");

        try {
            txt_fecha_inicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fecha_inicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fecha_inicioKeyPressed(evt);
            }
        });

        jLabel8.setText("Nro Dias:");

        btn_generar_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clipboard_text.png"))); // NOI18N
        btn_generar_excel.setText("Generar");
        btn_generar_excel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_generar_excel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_generar_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_excelActionPerformed(evt);
            }
        });

        jSpinner1.setValue(7);

        javax.swing.GroupLayout jd_menu_reportesLayout = new javax.swing.GroupLayout(jd_menu_reportes.getContentPane());
        jd_menu_reportes.getContentPane().setLayout(jd_menu_reportesLayout);
        jd_menu_reportesLayout.setHorizontalGroup(
            jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_reporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                        .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                                .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(btn_generar_excel)))
                .addContainerGap())
        );
        jd_menu_reportesLayout.setVerticalGroup(
            jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                        .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_menu_reportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jd_menu_reportesLayout.createSequentialGroup()
                        .addComponent(btn_generar_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control de Pesajes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));

        jToolBar1.setFloatable(false);
        jToolBar1.setOpaque(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Identity-separation-man-qr-code-data-barcode-512.png"))); // NOI18N
        jButton2.setText("Colaboradores");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/inventory_management-512.png"))); // NOI18N
        jButton3.setText("Pesaje");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/archiver-512.png"))); // NOI18N
        jButton6.setText("Parametros");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/customer-testimonials-512.png"))); // NOI18N
        jButton4.setText("Usuarios");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator2);

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Product-sale-report-icon.png"))); // NOI18N
        btn_exit.setText("Reportes");
        btn_exit.setFocusable(false);
        btn_exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_exit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_exit);
        jToolBar1.add(jSeparator1);

        btn_exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/close_delete-512.png"))); // NOI18N
        btn_exit1.setText("Exit");
        btn_exit1.setFocusable(false);
        btn_exit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_exit1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_exit1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen ultimos 30 dias"));

        jLabel9.setText("Pesaje Maximo:");

        jLabel10.setText("Pesaje Minimo:");

        lbl_pe_maximo.setEditable(false);
        lbl_pe_maximo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_pe_maximo.setText("0.00");

        lbl_pe_minimo.setEditable(false);
        lbl_pe_minimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_pe_minimo.setText("0.00");

        jLabel11.setText("Pesaje Promedio:");

        jLabel12.setText("Total Pesaje:");

        lbl_pe_promedio.setEditable(false);
        lbl_pe_promedio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_pe_promedio.setText("0.00");

        lbl_pe_total.setEditable(false);
        lbl_pe_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_pe_total.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_pe_maximo)
                        .addComponent(lbl_pe_minimo)
                        .addComponent(lbl_pe_promedio, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addComponent(lbl_pe_total, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pe_maximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pe_minimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pe_promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pe_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajador que mas produce"));

        lbl_trabajador_mas.setText("jLabel13");

        jLabel14.setText("Total Pesaje:");

        lbl_tpesaje_mas.setEditable(false);
        lbl_tpesaje_mas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_tpesaje_mas.setText("0.00");

        jLabel15.setText("Pesaje Promedio:");

        lbl_ppromedio_mas.setEditable(false);
        lbl_ppromedio_mas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_ppromedio_mas.setText("0.00");

        jLabel16.setText("Dias Trabajados:");

        lbl_dtrabajados_mas.setEditable(false);
        lbl_dtrabajados_mas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_dtrabajados_mas.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_trabajador_mas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tpesaje_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ppromedio_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dtrabajados_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_trabajador_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_tpesaje_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbl_ppromedio_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbl_dtrabajados_mas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajador que menos produce"));

        lbl_trabajador_menos.setText("jLabel13");

        jLabel17.setText("Total Pesaje:");

        lbl_tpesaje_menos.setEditable(false);
        lbl_tpesaje_menos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_tpesaje_menos.setText("0.00");

        jLabel18.setText("Pesaje Promedio:");

        lbl_ppromedio_menos.setEditable(false);
        lbl_ppromedio_menos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_ppromedio_menos.setText("0.00");

        jLabel19.setText("Dias Trabajados:");

        lbl_dtrabajados_menos.setEditable(false);
        lbl_dtrabajados_menos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_dtrabajados_menos.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_trabajador_menos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tpesaje_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ppromedio_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dtrabajados_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_trabajador_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbl_tpesaje_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbl_ppromedio_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lbl_dtrabajados_menos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/currency.png"))); // NOI18N
        jButton9.setText("Actualizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(19, 19, 19))
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frm_ver_colaboradores formulario = new frm_ver_colaboradores();
        c_varios.llamar_ventana(formulario, 0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        frm_reg_pesaje formulario = new frm_reg_pesaje();
        c_varios.llamar_ventana(formulario, 0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        frm_ver_usuarios formulario = new frm_ver_usuarios();
        c_varios.llamar_ventana(formulario, 1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        frm_ver_parametros formulario = new frm_ver_parametros();
        c_varios.llamar_ventana(formulario, 1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        jd_menu_reportes.setModal(true);
        jd_menu_reportes.setSize(452, 218);
        jd_menu_reportes.setLocationRelativeTo(null);
        jd_menu_reportes.setVisible(true);


    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exit1ActionPerformed

    private void txt_fecha_inicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_inicioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_fecha_inicio.getText().length() == 10) {
                if (cbx_reporte.getSelectedIndex() == 0) {
                    btn_generar_excel.setEnabled(true);
                    btn_generar_excel.requestFocus();
                    jSpinner1.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_txt_fecha_inicioKeyPressed

    private void cbx_reporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_reporteItemStateChanged
        txt_fecha_inicio.setEnabled(true);
        txt_fecha_inicio.requestFocus();
    }//GEN-LAST:event_cbx_reporteItemStateChanged

    private void btn_generar_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_excelActionPerformed
        cl_reporte c_reporte = new cl_reporte();
        c_reporte.setFecha_inicio(c_varios.fecha_myql(txt_fecha_inicio.getText()));
        c_reporte.setDias(Integer.parseInt(jSpinner1.getValue().toString()));
        c_reporte.generar_excel();
    }//GEN-LAST:event_btn_generar_excelActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cargar_mas_produce();
        cargar_resumen_anual();
        cargar_menos_produce();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_exit1;
    private javax.swing.JButton btn_generar_excel;
    private javax.swing.JComboBox<String> cbx_reporte;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSpinner jSpinner1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDialog jd_menu_reportes;
    private javax.swing.JTextField lbl_dtrabajados_mas;
    private javax.swing.JTextField lbl_dtrabajados_menos;
    private javax.swing.JTextField lbl_pe_maximo;
    private javax.swing.JTextField lbl_pe_minimo;
    private javax.swing.JTextField lbl_pe_promedio;
    private javax.swing.JTextField lbl_pe_total;
    private javax.swing.JTextField lbl_ppromedio_mas;
    private javax.swing.JTextField lbl_ppromedio_menos;
    private javax.swing.JTextField lbl_tpesaje_mas;
    private javax.swing.JTextField lbl_tpesaje_menos;
    private javax.swing.JLabel lbl_trabajador_mas;
    private javax.swing.JLabel lbl_trabajador_menos;
    private javax.swing.JFormattedTextField txt_fecha_inicio;
    // End of variables declaration//GEN-END:variables
}
