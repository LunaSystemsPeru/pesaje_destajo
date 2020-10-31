/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.cl_colaborador;
import clases.cl_descuento;
import clases.cl_llamadas;
import clases.cl_parametro_detalle;
import clases.cl_pesaje_trabajador;
import clases.cl_varios;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.m_trabajo;
import objects.o_trabajo;
import pesaje_trabajos.frm_principal;
//rpt_excel_pesaje_diario_trabajador

public class frm_reg_pesaje extends javax.swing.JInternalFrame {

    cl_varios c_varios = new cl_varios();
    m_trabajo m_trabajo = new m_trabajo();
    cl_colaborador c_colaborador = new cl_colaborador();
    cl_colaborador c_busqueda_colaborador = new cl_colaborador();
    cl_pesaje_trabajador c_busqueda_pesaje = new cl_pesaje_trabajador();
    cl_pesaje_trabajador c_pesaje_trabajador = new cl_pesaje_trabajador();
    cl_descuento c_descuento = new cl_descuento();

    cl_parametro_detalle c_detalle = new cl_parametro_detalle();
    cl_llamadas c_llamada = new cl_llamadas();

    int id_usuario = frm_principal.c_usuario.getId_usuario();
    double tope = 0;
    int fila_seleccionada = -1;

    double dneto;
    double tope_maximo = 0;
    int idtiposervicio;

    String fecha;

    DefaultTableModel modelo;

    /**
     * Creates new form frm_reg_pesaje
     */
    public frm_reg_pesaje() {
        initComponents();
        //ftffecha.setDateFormatString(c_varios.fecha_usuario(c_varios.getFechaActual()));

        m_trabajo.cbx_trabajo(cbx_trabajo);
        modelotabla();

        c_detalle.setIddetalle(1);
        c_detalle.obtener_datos();
        tope_maximo = Double.parseDouble(c_detalle.getValor());
        jLabel16.setText(c_varios.formato_numero(tope_maximo));

        c_pesaje_trabajador.pesaje_horas_hoy(jTable1);

        fecha = c_varios.getFechaActual();
        setearFecha(fecha);

        c_descuento.setFecha(fecha);
        c_descuento.AgruparDescuentos(jTable2);
    }

    private void setearFecha(String date) {
        try {
            java.util.Date date2;
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            jDateChooser1.setDate(date2);
            ftffecha.setDate(date2);
        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private void modelotabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Colaborador");
        modelo.addColumn("Peso");
        modelo.addColumn("Hora");
        modelo.addColumn("Fecha");
        modelo.addColumn("");
        t_listrabaj.setModel(modelo);
        t_listrabaj.getColumnModel().getColumn(0).setPreferredWidth(40);
        t_listrabaj.getColumnModel().getColumn(1).setPreferredWidth(250);
        t_listrabaj.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_listrabaj.getColumnModel().getColumn(3).setPreferredWidth(80);
        t_listrabaj.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_listrabaj.getColumnModel().getColumn(5).setPreferredWidth(0);
        t_listrabaj.getColumnModel().getColumn(5).setMaxWidth(0);
        t_listrabaj.getColumnModel().getColumn(5).setMinWidth(0);
        t_listrabaj.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        t_listrabaj.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        c_varios.centrar_celda(t_listrabaj, 0);
        c_varios.centrar_celda(t_listrabaj, 3);
        c_varios.centrar_celda(t_listrabaj, 4);

    }

    private void limpiar() {
        txt_colaborador.setText("");
        txt_nombrecolaborador.setText("");
        txt_cantidad.setText("");
        txt_colaborador.requestFocus();
        btn_agregar.setEnabled(false);
        //desactivar_botones_trabajador();
    }

    private void activar_botones_trabajador() {
        jButton7.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton6.setEnabled(true);
        jButton5.setEnabled(true);
    }

    private void desactivar_botones_trabajador() {
        jButton7.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton6.setEnabled(false);
        jButton5.setEnabled(false);
    }

    private boolean validar_trabajador() {
        if (c_colaborador.getCodigo() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "NO HA INGRESADO CODIGO DE TRABAJADOR");
            desactivar_botones_trabajador();
            txt_colaborador.requestFocus();
            return false;
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

        jd_detalle_trabajador = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_detalle_trabajador = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jd_memorandum = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_cod_memorandum = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jd_total_trabajador = new javax.swing.JDialog();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_cod_memorandum1 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jd_parametros = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbx_trabajo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_tope = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ftffecha = new com.toedter.calendar.JDateChooser();
        jButton15 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_colaborador = new javax.swing.JTextField();
        txt_nombrecolaborador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        txt_tara_balanza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_neto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txt_promedio_trabajador = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_listrabaj = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jd_detalle_trabajador.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jd_detalle_trabajador.setTitle("ver detalle de Pesaje de Trabajador");

        jLabel8.setText("Trabajador:");

        t_detalle_trabajador.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(t_detalle_trabajador);

        jTextField1.setEnabled(false);

        jLabel11.setText("Total Pesaje:");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel17.setText("Ingrese Codigo:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/find.png"))); // NOI18N
        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jd_detalle_trabajadorLayout = new javax.swing.GroupLayout(jd_detalle_trabajador.getContentPane());
        jd_detalle_trabajador.getContentPane().setLayout(jd_detalle_trabajadorLayout);
        jd_detalle_trabajadorLayout.setHorizontalGroup(
            jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_detalle_trabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(jd_detalle_trabajadorLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jd_detalle_trabajadorLayout.createSequentialGroup()
                        .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jd_detalle_trabajadorLayout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jd_detalle_trabajadorLayout.setVerticalGroup(
            jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_detalle_trabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_detalle_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        jd_memorandum.setTitle("Agregar Llamada de Atencion al Trabajador");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Trabajador:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Fecha:");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Descripcion:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTextField5.setEditable(false);

        jToolBar1.setFloatable(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/accept.png"))); // NOI18N
        jButton4.setText("Grabar");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jLabel18.setText("Codigo:");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/find.png"))); // NOI18N
        jButton12.setText("Busca");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jd_memorandumLayout = new javax.swing.GroupLayout(jd_memorandum.getContentPane());
        jd_memorandum.getContentPane().setLayout(jd_memorandumLayout);
        jd_memorandumLayout.setHorizontalGroup(
            jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_memorandumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jd_memorandumLayout.createSequentialGroup()
                        .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addGroup(jd_memorandumLayout.createSequentialGroup()
                                .addComponent(txt_cod_memorandum, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addGap(0, 281, Short.MAX_VALUE))))
                    .addGroup(jd_memorandumLayout.createSequentialGroup()
                        .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jd_memorandumLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jd_memorandumLayout.setVerticalGroup(
            jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_memorandumLayout.createSequentialGroup()
                .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jd_memorandumLayout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cod_memorandum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_memorandumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        jd_total_trabajador.setTitle("Obtener Peso x Dia");

        jTextField6.setEditable(false);

        jLabel19.setText("Codigo:");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Trabajador:");

        txt_cod_memorandum1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cod_memorandum1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cod_memorandum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cod_memorandum1KeyPressed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/find.png"))); // NOI18N
        jButton13.setText("Buscar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel21.setText("Total Kgs:");

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jd_total_trabajadorLayout = new javax.swing.GroupLayout(jd_total_trabajador.getContentPane());
        jd_total_trabajador.getContentPane().setLayout(jd_total_trabajadorLayout);
        jd_total_trabajadorLayout.setHorizontalGroup(
            jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_total_trabajadorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jd_total_trabajadorLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jd_total_trabajadorLayout.createSequentialGroup()
                        .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addGroup(jd_total_trabajadorLayout.createSequentialGroup()
                                .addComponent(txt_cod_memorandum1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13)
                                .addGap(0, 147, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jd_total_trabajadorLayout.setVerticalGroup(
            jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_total_trabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cod_memorandum1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jd_total_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jd_parametros.setTitle("Parametros Pesaje");

        jLabel9.setText("Parametros para Pesaje");

        jCheckBox1.setText("Activar");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/accept.png"))); // NOI18N
        jButton8.setText("Grabar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jd_parametrosLayout = new javax.swing.GroupLayout(jd_parametros.getContentPane());
        jd_parametros.getContentPane().setLayout(jd_parametrosLayout);
        jd_parametrosLayout.setHorizontalGroup(
            jd_parametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_parametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_parametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_parametrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );
        jd_parametrosLayout.setVerticalGroup(
            jd_parametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_parametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setClosable(true);
        setTitle("Registrar Pesaje Diario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Pesaje"));

        jLabel1.setText("Tipo de Trabajo:");

        jLabel2.setText("Fecha");

        cbx_trabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PESAJE", "DESTAJO", "CORTE Y FILETE" }));
        cbx_trabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_trabajoMouseClicked(evt);
            }
        });
        cbx_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_trabajoActionPerformed(evt);
            }
        });
        cbx_trabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_trabajoKeyPressed(evt);
            }
        });

        jLabel5.setText("Tope:");

        txt_tope.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tope.setText("0.00");
        txt_tope.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_topeKeyPressed(evt);
            }
        });

        jLabel15.setText("Tope Maximo:");

        jLabel16.setText("jLabel16");

        ftffecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftffechaKeyPressed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/accept.png"))); // NOI18N
        jButton15.setText("Iniciar Servicio");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftffecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tope, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftffecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_tope, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Colaborador"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Colaborador:");

        txt_colaborador.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_colaborador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_colaborador.setEnabled(false);
        txt_colaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_colaboradorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_colaboradorKeyTyped(evt);
            }
        });

        txt_nombrecolaborador.setEditable(false);
        txt_nombrecolaborador.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Peso - Cantidad:");

        txt_cantidad.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cantidad.setEnabled(false);
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/accept.png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setEnabled(false);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        txt_tara_balanza.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_tara_balanza.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tara_balanza.setText("0.00");
        txt_tara_balanza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tara_balanzaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("=");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("-");

        txt_neto.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_neto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_neto.setText("0.00");
        txt_neto.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add.png"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.setEnabled(false);
        jButton2.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/trash_16.png"))); // NOI18N
        jButton9.setText("Eliminar");
        jButton9.setEnabled(false);
        jButton9.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txt_promedio_trabajador.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_promedio_trabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_promedio_trabajador.setEnabled(false);
        txt_promedio_trabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_promedio_trabajadorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_promedio_trabajadorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tara_balanza, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_neto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_agregar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombrecolaborador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_promedio_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nombrecolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_promedio_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tara_balanza, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_neto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Trabajadores"));

        t_listrabaj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"09:35:02", "1", "ACUÑA CARLOS JOSE ", "3.00"},
                {"09:36:15", "25", "VILLANUEVA ACUÑA JOSE", "15.00"},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hora", "ID.", "Colaborador", "Cantidad"
            }
        ));
        t_listrabaj.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        t_listrabaj.setRowHeight(20);
        t_listrabaj.setShowHorizontalLines(false);
        t_listrabaj.setShowVerticalLines(false);
        t_listrabaj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_listrabajMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_listrabaj);
        if (t_listrabaj.getColumnModel().getColumnCount() > 0) {
            t_listrabaj.getColumnModel().getColumn(0).setPreferredWidth(80);
            t_listrabaj.getColumnModel().getColumn(1).setPreferredWidth(50);
            t_listrabaj.getColumnModel().getColumn(2).setPreferredWidth(400);
            t_listrabaj.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/chart_bar.png"))); // NOI18N
        jButton1.setText("ver Total Kg.");
        jButton1.setEnabled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user_thief_baldie.png"))); // NOI18N
        jButton7.setText("<html><center>ver Total Kgs Trabajador.</center></html>");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/error.png"))); // NOI18N
        jButton3.setText("<html><center>Llamada Atencion</center></html>");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pagos.png"))); // NOI18N
        jButton6.setText("Descuento");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clipboard_text.png"))); // NOI18N
        jButton5.setText("<html><center>ver Kgs Detallados del Trabajador</center></html>");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/locked-30.png"))); // NOI18N
        jButton11.setText("Parametros");
        jButton11.setToolTipText("No Abrir!!");
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(20);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane4.setViewportView(jTable1);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(452, 402));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if (dneto > tope_maximo) {
            //JOptionPane.showMessageDialog(null, "ESTE VALOR NO ESTA PERMITIDO \nSOBREPASA EL TOPE MAXIMO");
            txt_cantidad.selectAll();
            btn_agregar.setEnabled(false);
            txt_cantidad.requestFocus();
        } else {
            //ingresar a la base de datos
            c_pesaje_trabajador.setHora(c_varios.getHoraActual());
            c_pesaje_trabajador.setIdcolaborador(c_colaborador.getIdcolaborador());
            c_pesaje_trabajador.setCantidad(dneto);
            c_pesaje_trabajador.setFecha(c_varios.fecha_myql(fecha));
            c_pesaje_trabajador.setIdservicio(idtiposervicio);
            c_pesaje_trabajador.setIdusuario(id_usuario);
            c_pesaje_trabajador.obtener_codigo();
            c_pesaje_trabajador.registrar();

            Object fila[] = new Object[6];
            fila[0] = txt_colaborador.getText();
            fila[1] = txt_nombrecolaborador.getText();
            fila[2] = c_varios.formato_numero(dneto);
            fila[3] = c_varios.getHoraActual();
            fila[4] = c_varios.fecha_myql(fecha);
            fila[5] = c_pesaje_trabajador.getIdpesaje();
            modelo.addRow(fila);

            t_listrabaj.scrollRectToVisible(t_listrabaj.getCellRect(t_listrabaj.getRowCount() - 1, 0, true));

            //limpiar campos
            limpiar();
            c_pesaje_trabajador.pesaje_horas_hoy(jTable1);
            c_descuento.setFecha(fecha);
            c_descuento.AgruparDescuentos(jTable2);

            btn_agregar.setEnabled(false);
            txt_colaborador.setText("");
            txt_nombrecolaborador.setText("");
            txt_cantidad.setText("");
            txt_colaborador.requestFocus();
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void cbx_trabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_trabajoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_trabajoMouseClicked

    private void cbx_trabajoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_trabajoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fecha = sdf.format(ftffecha.getDate());

            // btn_iniciar.requestFocus();
            o_trabajo o_trabajo = (o_trabajo) cbx_trabajo.getSelectedItem();

            c_detalle.setIddetalle(o_trabajo.getId_tipo_trabajo());
            c_detalle.obtener_datos();

            tope = Double.parseDouble(c_detalle.getValor());
            txt_tope.setText(c_varios.formato_numero(Double.parseDouble(c_detalle.getValor())));

            //mostrar datos grabados 
            modelotabla();

            c_pesaje_trabajador.setFecha(c_varios.fecha_myql(fecha));
            c_pesaje_trabajador.setIdservicio(o_trabajo.getId_tipo_trabajo());
            c_pesaje_trabajador.ver_pesaje_fecha(modelo);
            t_listrabaj.setModel(modelo);

            txt_colaborador.setEnabled(true);
            jButton1.setEnabled(true);
            txt_colaborador.requestFocus();
        }
    }//GEN-LAST:event_cbx_trabajoKeyPressed

    private void cbx_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_trabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_trabajoActionPerformed

    private void txt_colaboradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fecha = sdf.format(ftffecha.getDate());

            if (txt_colaborador.getText().length() > 0) {
                int colaborador = Integer.parseInt(txt_colaborador.getText());
                c_colaborador.setCodigo(colaborador);

                if (c_colaborador.obtener_datos_codigo()) {
                    c_colaborador.obtener_datos();
                    txt_nombrecolaborador.setText(c_colaborador.getDatos());

                    //obtener primer pesaje
                    //obtener la hora de ese pesaje
                    c_pesaje_trabajador.setFecha(c_varios.fecha_myql(fecha));
                    String horaprimera = c_pesaje_trabajador.obtenerPrimerPesaje();
                    //obtener primer pesaje del trabajador
                    c_pesaje_trabajador.setIdcolaborador(c_colaborador.getIdcolaborador());
                    String horapeso1 = c_pesaje_trabajador.obtenerPrimerPesajeTrabajador();

                    String horaactual = c_varios.getHoraActual();
                    horaactual = horaactual.substring(0, 2);

                    int hora1 = Integer.parseInt(horaprimera);
                    int horapeso = Integer.parseInt(horaactual);

                    //comparar si no hay ootro pesaje
                    if (Integer.parseInt(horapeso1) == 0) {

                        //comparar hora con la hora actual si es mayor a 6 de diferencia mostrar alaerta
                        if (horapeso - hora1 > 2) {
                            JOptionPane.showMessageDialog(null, "<html><h2>ALERTA</h2> <h4>no registra pesaje en las ultimas 03 horas</h4></html>");
                        }
                    }

                    //activar botones trabajador
                    activar_botones_trabajador();

                    txt_cantidad.setEnabled(true);
                    txt_cantidad.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "No existe Trabajor");
                    txt_colaborador.setText("");
                    txt_colaborador.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txt_colaboradorKeyPressed

    private void txt_cantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_cantidad.getText().length() > 0) {
                String tara = txt_tara_balanza.getText();
                double dtara = 0;
                if (c_varios.esDecimal(tara)) {
                    dtara = Double.parseDouble(tara);
                }

                String pesaje = txt_cantidad.getText();
                double dcantidad;

                dneto = 0;

                if (c_varios.esDecimal(pesaje)) {
                    dcantidad = Double.parseDouble(pesaje);

                    dneto = dcantidad - dtara;
                    txt_neto.setText(c_varios.formato_numero(dneto));

                    if (dneto <= tope & dneto <= tope_maximo) {
                        btn_agregar.setEnabled(true);
                        btn_agregar.doClick();
                    } else if (dneto > tope & dneto <= tope_maximo) {
                        JOptionPane.showMessageDialog(null, "ESTE NUMERO ES MAYOR AL TOPE");
                        // txt_cantidad.selectAll();
                        //txt_cantidad.requestFocus();
                        btn_agregar.setEnabled(true);
                        btn_agregar.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "ESTE NUMERO ES MAYOR AL TOPE FINAL");
                        btn_agregar.setEnabled(false);
                        txt_cantidad.selectAll();
                        txt_cantidad.requestFocus();
                    }
                }
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            limpiar();
        }
    }//GEN-LAST:event_txt_cantidadKeyPressed

    private void txt_colaboradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_colaboradorKeyTyped
        c_varios.solo_numeros(evt);
        c_varios.limitar_caracteres(evt, txt_colaborador, 4);
    }//GEN-LAST:event_txt_colaboradorKeyTyped

    private void txt_topeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_topeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String texto = txt_tope.getText();
            if (c_varios.esDecimal(texto)) {
                tope = Double.parseDouble(texto);
                c_detalle.setValor(tope + "");
                c_detalle.actualizar();
                txt_colaborador.setEnabled(true);
                txt_colaborador.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_topeKeyPressed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        c_varios.solo_precio(evt);
        c_varios.limitar_caracteres(evt, txt_cantidad, 8);
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void txt_tara_balanzaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tara_balanzaKeyTyped
        c_varios.solo_precio(evt);
        c_varios.limitar_caracteres(evt, txt_tara_balanza, 8);
    }//GEN-LAST:event_txt_tara_balanzaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        c_pesaje_trabajador.setFecha(c_varios.fecha_myql(fecha));
        String[] data = c_pesaje_trabajador.obtener_total_fecha();
        double total = Double.parseDouble(data[0]);
        int cantidad = Integer.parseInt(data[1]);
        JOptionPane.showMessageDialog(null, "<html>El pesaje total del dia es: <h2>" + c_varios.formato_numero(total) + "</h2><br>Nro de Cortadores: <h2>" + cantidad + "</h2></html>");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        jd_total_trabajador.setModal(true);
        jd_total_trabajador.setSize(400, 264);
        jd_total_trabajador.setLocationRelativeTo(null);
        txt_cod_memorandum1.setText("");
        jTextField6.setText("");
        jTextField8.setText("");
        jd_total_trabajador.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        try {
        jd_detalle_trabajador.setModal(true);
        jd_detalle_trabajador.setSize(436, 474);
        jd_detalle_trabajador.setLocationRelativeTo(null);
        String date = c_varios.fecha_myql(fecha);
        //java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        // jDateChooser2.setDate(date2);
        jTextField7.setText("");
        jTextField1.setText("");
        jTextField4.setText("");
        t_detalle_trabajador.removeAll();

        jd_detalle_trabajador.setVisible(true);
        /*    } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }*/
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTextArea1.getText().length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ffecha2 = sdf.format(jDateChooser1.getDate());

            c_llamada.setFecha(c_varios.fecha_myql(ffecha2));
            c_llamada.setIdcolaborador(c_busqueda_colaborador.getIdcolaborador());
            c_llamada.setIdusuario(id_usuario);
            c_llamada.setTexto(jTextArea1.getText().toUpperCase());
            c_llamada.obtener_codigo();
            c_llamada.registrar();

            jd_memorandum.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jd_memorandum.setModal(true);
        jd_memorandum.setSize(578, 440);

        jTextField5.setText(txt_nombrecolaborador.getText());
        jTextArea1.requestFocus();

        jd_memorandum.setLocationRelativeTo(null);
        jd_memorandum.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jTextField7.getText().length() > 0) {

            c_busqueda_colaborador.setCodigo(Integer.parseInt(jTextField7.getText()));

            if (c_busqueda_colaborador.obtener_datos_codigo()) {
                c_busqueda_colaborador.obtener_datos();
                jTextField1.setText(c_busqueda_colaborador.getDatos());

                c_busqueda_pesaje.setIdcolaborador(c_busqueda_colaborador.getIdcolaborador());
                c_busqueda_pesaje.ver_detalle_trabajador(t_detalle_trabajador);

                double total = 0;
                for (int i = 0; i < t_detalle_trabajador.getRowCount(); i++) {
                    total += Double.parseDouble(t_detalle_trabajador.getValueAt(i, 2).toString());
                }
                jTextField4.setText(c_varios.formato_totales(total));
                jTextField7.requestFocus();
                jTextField7.selectAll();
            }
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void ftffechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftffechaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_ftffechaKeyPressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (txt_cod_memorandum.getText().length() > 0) {
            c_busqueda_colaborador.setCodigo(Integer.parseInt(txt_cod_memorandum.getText()));

            if (c_busqueda_colaborador.obtener_datos_codigo()) {
                c_busqueda_colaborador.obtener_datos();
                jTextField5.setText(c_busqueda_colaborador.getDatos());
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (txt_cod_memorandum1.getText().length() > 0) {
            c_busqueda_colaborador.setCodigo(Integer.parseInt(txt_cod_memorandum1.getText()));

            if (c_busqueda_colaborador.obtener_datos_codigo()) {

                c_detalle.setIddetalle(13);
                c_detalle.obtener_datos();
                String activo_descuento = c_detalle.getValor();
                //System.out.println(activo_descuento);

                c_detalle.setIddetalle(12);
                c_detalle.obtener_datos();
                double totalkgdescuentos = Double.parseDouble(c_detalle.getValor());

                c_busqueda_colaborador.obtener_datos();
                jTextField6.setText(c_busqueda_colaborador.getDatos());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                fecha = sdf.format(ftffecha.getDate());
                setearFecha(c_varios.fecha_myql(fecha));

                // btn_iniciar.requestFocus();
                o_trabajo o_trabajo = (o_trabajo) cbx_trabajo.getSelectedItem();

                c_busqueda_pesaje.setFecha(c_varios.fecha_myql(fecha));
                c_busqueda_pesaje.setIdservicio(o_trabajo.getId_tipo_trabajo());
                c_busqueda_pesaje.setIdcolaborador(c_busqueda_colaborador.getIdcolaborador());
                double totaltrabajadores = c_busqueda_pesaje.obtener_total_trabajador_fecha();
                if (totaltrabajadores > 2) {
                    if (activo_descuento.equals("1")) {
                        totaltrabajadores = totaltrabajadores - totalkgdescuentos;
                    }
                }
                jTextField8.setText(c_varios.formato_totales(totaltrabajadores));

                txt_cod_memorandum1.requestFocus();
                txt_cod_memorandum1.selectAll();
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.format(ftffecha.getDate());
        setearFecha(c_varios.fecha_myql(fecha));

        // btn_iniciar.requestFocus();
        o_trabajo o_trabajo = (o_trabajo) cbx_trabajo.getSelectedItem();

        c_detalle.setIddetalle(o_trabajo.getId_tipo_trabajo());
        c_detalle.obtener_datos();

        idtiposervicio = c_detalle.getIddetalle();
        tope = Double.parseDouble(c_detalle.getValor());
        txt_tope.setText(c_varios.formato_numero(tope));

        //mostrar datos grabados 
        modelotabla();

        c_pesaje_trabajador.setFecha(c_varios.fecha_myql(fecha));
        c_pesaje_trabajador.setIdservicio(o_trabajo.getId_tipo_trabajo());
        c_pesaje_trabajador.ver_pesaje_fecha(modelo);
        t_listrabaj.setModel(modelo);

        c_descuento.setFecha(c_varios.fecha_myql(fecha));
        c_descuento.AgruparDescuentos(jTable2);

        txt_colaborador.setEnabled(true);
        jButton1.setEnabled(true);
        txt_colaborador.requestFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txt_promedio_trabajadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_promedio_trabajadorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_promedio_trabajadorKeyPressed

    private void txt_promedio_trabajadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_promedio_trabajadorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_promedio_trabajadorKeyTyped

    private void t_listrabajMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_listrabajMouseClicked
        if (evt.getClickCount() == 2) {
            fila_seleccionada = t_listrabaj.getSelectedRow();
            c_pesaje_trabajador.setIdpesaje(Integer.parseInt(t_listrabaj.getValueAt(fila_seleccionada, 5).toString()));
            jButton9.setEnabled(true);
        }
    }//GEN-LAST:event_t_listrabajMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setEnabled(false);
        c_pesaje_trabajador.eliminar();
        modelo.removeRow(fila_seleccionada);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(ftffecha.getDate());
        System.out.println(fecha);
        frm_descuento.fecha = fecha;
        JDialog dialogo = new frm_descuento(null, true);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_cod_memorandum1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cod_memorandum1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton13.requestFocus();
        }
    }//GEN-LAST:event_txt_cod_memorandum1KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        c_detalle.setIddetalle(13);
        c_detalle.obtener_datos();
        if (jCheckBox1.isSelected()) {
            c_detalle.setValor("1");
            c_detalle.actualizar();
        } else {
            c_detalle.setValor("0");
            c_detalle.actualizar();
        }
        jd_parametros.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jd_parametros.setModal(true);
        jd_parametros.setSize(578, 240);

        c_detalle.setIddetalle(13);
        c_detalle.obtener_datos();
        if (c_detalle.getValor().equals("0")) {
            jCheckBox1.setSelected(false);
        } else {
            jCheckBox1.setSelected(true);
        }

        jd_parametros.setLocationRelativeTo(null);
        jd_parametros.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTextField7.getText().length() > 0) {
                jButton10.doClick();
            }
        }
    }//GEN-LAST:event_jTextField7KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JComboBox<String> cbx_trabajo;
    private com.toedter.calendar.JDateChooser ftffecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDialog jd_detalle_trabajador;
    private javax.swing.JDialog jd_memorandum;
    private javax.swing.JDialog jd_parametros;
    private javax.swing.JDialog jd_total_trabajador;
    private javax.swing.JTable t_detalle_trabajador;
    private javax.swing.JTable t_listrabaj;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cod_memorandum;
    private javax.swing.JTextField txt_cod_memorandum1;
    private javax.swing.JTextField txt_colaborador;
    private javax.swing.JTextField txt_neto;
    private javax.swing.JTextField txt_nombrecolaborador;
    private javax.swing.JTextField txt_promedio_trabajador;
    private javax.swing.JTextField txt_tara_balanza;
    private javax.swing.JTextField txt_tope;
    // End of variables declaration//GEN-END:variables
}
