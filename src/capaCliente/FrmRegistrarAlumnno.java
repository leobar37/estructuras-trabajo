/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import Alternos.Alternos;
import capaDatos.listaAlumno;
import capaNegocio.Alumno;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;


import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class FrmRegistrarAlumnno extends javax.swing.JDialog {

    private String cod = null;
    private String pathImagen = "vacio";

    public FrmRegistrarAlumnno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        go();
        this.setTitle("Registro de Alumnos");
    }

    public void go() {
        this.setTitle("Registro de Alumnos");
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/alumnoIco.png")).getImage());
        this.setResizable(false);

        panelImge.setIcon(new ImageIcon("fondo blanco.png"));
        panelImge.repaint();
        validaciones();
        llenartabla();
    }

    public void validaciones() {
        Alternos.limitarSoloNumeroRes(txtDNI, 8);
        Alternos.limitarSoloNumeroRes(txtCelular, 9);
        Alternos.limitarSoloNumeroRes(txtEdad, 2);
        Alternos.limitarSoloNumero(txtEdad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos1 = new javax.swing.JPanel();
        panelRegistro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtLugar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jdateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        buttonCircle1 = new org.edisoncor.gui.button.ButtonCircle();
        contenedorImagen = new javax.swing.JPanel();
        panelImge = new org.edisoncor.gui.panel.PanelImage();
        jLabel6 = new javax.swing.JLabel();
        JFechaRegistro = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox<>();
        btnRegitrar = new org.edisoncor.gui.button.ButtonAero();
        jLabel1 = new javax.swing.JLabel();
        panelMostrar = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnActualizar = new org.edisoncor.gui.button.ButtonAero();
        btndarBaja = new org.edisoncor.gui.button.ButtonAero();
        btnLimpiar = new org.edisoncor.gui.button.ButtonAero();
        btnModificar = new org.edisoncor.gui.button.ButtonAero();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelDatos1.setBackground(new java.awt.Color(255, 255, 255));

        panelRegistro.setBackground(new java.awt.Color(250, 187, 4));

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Edad:");

        jLabel7.setText("Fecha de Nacimiento:");

        jLabel8.setText("Direccion:");

        jLabel9.setText("Celular:");

        jLabel10.setText("Correo:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Lugar");

        buttonCircle1.setText("buttonCircle1");
        buttonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCircle1ActionPerformed(evt);
            }
        });

        contenedorImagen.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelImgeLayout = new javax.swing.GroupLayout(panelImge);
        panelImge.setLayout(panelImgeLayout);
        panelImgeLayout.setHorizontalGroup(
            panelImgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        panelImgeLayout.setVerticalGroup(
            panelImgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contenedorImagenLayout = new javax.swing.GroupLayout(contenedorImagen);
        contenedorImagen.setLayout(contenedorImagenLayout);
        contenedorImagenLayout.setHorizontalGroup(
            contenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenedorImagenLayout.setVerticalGroup(
            contenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setText("Fecha Registro");

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("sexo:");

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "femenino", "masculiino" }));

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRegistroLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel6)
                                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel8))
                                            .addComponent(jLabel5)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdateFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txtCorreo)
                                    .addComponent(JFechaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(contenedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                        .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(JFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnRegitrar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegitrar.setText("Registrar");
        btnRegitrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegitrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Control de Alumnos");

        panelMostrar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMostrarLayout = new javax.swing.GroupLayout(panelMostrar);
        panelMostrar.setLayout(panelMostrarLayout);
        panelMostrarLayout.setHorizontalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelMostrarLayout.setVerticalGroup(
            panelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btndarBaja.setBackground(new java.awt.Color(0, 0, 0));
        btndarBaja.setText("dar baja");

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatos1Layout = new javax.swing.GroupLayout(panelDatos1);
        panelDatos1.setLayout(panelDatos1Layout);
        panelDatos1Layout.setHorizontalGroup(
            panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatos1Layout.createSequentialGroup()
                .addGroup(panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(166, 166, 166))
                    .addGroup(panelDatos1Layout.createSequentialGroup()
                        .addGroup(panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatos1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btndarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnRegitrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatos1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatos1Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatos1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        panelDatos1Layout.setVerticalGroup(
            panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(jSeparator1)
            .addGroup(panelDatos1Layout.createSequentialGroup()
                .addGroup(panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatos1Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(panelMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatos1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegitrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public String urlImagen(String dniAlumno){        
        String path = "fotos/"+dniAlumno+".jpg";
        return  path;
    }
    private void btnRegitrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegitrarActionPerformed
        
        if (listaAlumno.buscaxDniPos(txtDNI.getText()) != -1) {
            JOptionPane.showMessageDialog(null, "ya existe este alumno");
            return;
        }
        if (!Alternos.Probar(panelRegistro)) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
            return;
        }
       //proceso de conversion de java.util.date a java.sql.date 
        Date fecha = jdateFechaNacimiento.getDate();
        long time = fecha.getTime();
        java.sql.Date fechaGuardar = new java.sql.Date(time);
        //----------------fin-------------
        //guardar la imagen
        if (pathImagen.equalsIgnoreCase("vacio")) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado una imagen");
            return;
        }
        Alumno objAlumno = new Alumno();
        //FECHA DE REGISTRO
        Date fechaaux =JFechaRegistro.getDate();
        Date fechaRegistro =Alternos.formatoFecha(fechaaux);
        
        objAlumno.setFechaRegistro(fechaRegistro);
      
        String dni = txtDNI.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String direccion = txtDireccion.getText();
        String celular = txtCelular.getText();
        String correo = txtCorreo.getText();
        String lugar = txtLugar.getText();
        String sexo = cboSexo.getSelectedItem().toString();
        objAlumno.setSexo(sexo);
        Alumno.guardarImagen(dni, pathImagen);
        objAlumno.setImagen(urlImagen(dni));
        objAlumno.setFechaNacimiento(fechaGuardar);
        objAlumno.setDni(dni);
        objAlumno.setNombre(nombres);
        objAlumno.setApellidos(apellidos);
        objAlumno.setEdad(edad);
        objAlumno.setDireccion(direccion);
        objAlumno.setCelular(celular);
        objAlumno.setCorreo(correo);
        objAlumno.setLugar(lugar);
        
        listaAlumno.adicionar(objAlumno);
        JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente");
        
        listaAlumno.guardarLista();
        Limpiar();
        llenartabla();
    }//GEN-LAST:event_btnRegitrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (cod == null) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado un usuario");
            return;
        }
        if (!Alternos.Probar(panelRegistro)) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
            return;
        }
      
        Date fecha = jdateFechaNacimiento.getDate();
        long time = fecha.getTime();
        java.sql.Date fechaGuardar = new java.sql.Date(time);
        //guardar la imagen
        if (pathImagen.equalsIgnoreCase("vacio")) {
            JOptionPane.showMessageDialog(null, "no se ha seleccionado una imagen");
        }
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String direccion = txtDireccion.getText();
        String celular = txtCelular.getText();
        String correo = txtCorreo.getText();
        String lugar = txtCorreo.getText();
        Alumno obj = new Alumno();
        //obj.setImagen(pathImagen);
        //**************modificar imagen*******************//
        Alumno aux = listaAlumno.buscaxDniAumno(cod);
        if(!pathImagen.equalsIgnoreCase(aux.getImagen())){
            Alumno.BorrarImagen(cod);
            Alumno.guardarImagen(cod, pathImagen);
            //obj.setImagen(urlImagen(cod));
        }else{
           obj.setImagen(urlImagen(cod)); 
        }
        //fin
        obj.setFechaNacimiento(fechaGuardar);
        obj.setDni(cod);
        obj.setNombre(nombres);
        obj.setApellidos(apellidos);
        obj.setEdad(edad);
        obj.setDireccion(direccion);
        obj.setCelular(celular);
        obj.setCorreo(correo);
        obj.setLugar(lugar);
       obj.setSexo(cboSexo.getSelectedItem().toString());
        JOptionPane.showMessageDialog(null, "Alumno modificado exitosamente");
        Alumno.modificarAlumno(cod, obj);
        listaAlumno.guardarLista();
        Limpiar();
        llenartabla();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        cod = tabla.getValueAt(fila, 0).toString();
        Alumno objAlumno = listaAlumno.buscaxDniAumno(cod);
        if (objAlumno == null) {
            return;
        }
        if (objAlumno.getImagen().equalsIgnoreCase("vacio")) {
            System.out.println("no hay niguna imagen");
        } else {
            try {
                pathImagen = objAlumno.getImagen();
                Image ima = ImageIO.read(new File(objAlumno.getImagen()));
                panelImge.setIcon(new ImageIcon(ima));
                panelImge.repaint();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "error en la lectura de la imagen");
            }
        }
        txtNombres.setText(objAlumno.getNombre());
        txtApellidos.setText(objAlumno.getApellidos());
        jdateFechaNacimiento.setDate(objAlumno.getFechaNacimiento());
        txtLugar.setText(objAlumno.getLugar());
        txtDNI.setText(cod);
        txtEdad.setText("" + objAlumno.getEdad());
        txtDireccion.setText("" + objAlumno.getDireccion());
        txtCelular.setText("" + objAlumno.getCelular());
        txtCorreo.setText("" + objAlumno.getCorreo());
    }//GEN-LAST:event_tablaMouseClicked
    public void llenartabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("EDAD");
        modelo.addColumn("CELULAR");
        modelo.addColumn("CORREO");
        modelo.addColumn("FECHA");
        modelo.addColumn("SEXO");
        ListasAux.ListaEnlazada lista = Alumno.consultar();
        Object fila[] = new Object[8];
        for (int i = 0; i < lista.tamaño(); i++) {
            Alumno objAlumno = (Alumno) lista.Buscar(i);
            fila[0] = objAlumno.getDni();
            fila[1] = objAlumno.getNombre();
            fila[2] = objAlumno.getApellidos();
            fila[3] = objAlumno.getEdad();
            fila[4] = objAlumno.getCelular();
            fila[5] = objAlumno.getCorreo();
            fila[6] = objAlumno.getFechaNacimiento();
            fila[7] =objAlumno.getSexo();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        llenartabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // lblIamagen.setIcon(new ImageIcon("/imagenes/men.png"));
        try {
            String data = Alumno.BuscarDni(txtDNI.getText());
            System.out.println("datos" + data);
            int cont = 0;
            String resultado = "";
            char[] datos = data.toCharArray();
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] == '|') {
                    cont++;
                    if (cont == 1) {
                        txtApellidos.setText(resultado.replace("|", " "));
                        resultado = "";
                    }
                    if (cont == 2) {
                        txtNombres.setText(resultado.replace("|", " "));
                        resultado = "";
                    }
                }
                resultado = resultado + datos[i];
                txtLugar.setText(resultado.replace("|", "/"));
            }

            // String datos[]  = data.split(" | ");
            //txtApellidos.setText(datos[0]);
            System.out.println("estoy");
            // System.out.println(datos[0]);
            //txtNombres.setText(datos[1]);

        } catch (IOException ex) {
            Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    public void Limpiar() {
        Alternos.LimpiarCajas(panelRegistro);
        panelImge.setIcon(new ImageIcon("C:\\Users\\Leobar37\\Pictures\\fondo blanco.png"));
        panelImge.repaint();
        pathImagen = "vacio";
        ((JTextField) jdateFechaNacimiento.getDateEditor().getUiComponent()).setText("");
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
        // jdateFechaNacimiento.setDate(new Date());
        ///    JTextField texto = jdateFechaNacimiento.get
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void buttonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCircle1ActionPerformed
        JFileChooser jf = new JFileChooser("C:/Users/Leobar37/Pictures/imagenes ramdom");
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        jf.setFileFilter(fil);
        jf.setCurrentDirectory(new File("Fotos"));
        int el = jf.showOpenDialog(this);
        if (el == JFileChooser.APPROVE_OPTION) {
            try {
                //txtRuta.setText(jf.getSelectedFile().getAbsolutePath());
                pathImagen = jf.getSelectedFile().getAbsolutePath();
                //------proceso de guardado de imagen desde un lugar cualquiera hacia la raiz del proyecto----//
                Image img = new ImageIcon(pathImagen).getImage();
                BufferedImage imagen = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D pintor = imagen.createGraphics();
                pintor.drawImage(img, 0, 0, null);
                pintor.dispose();
              
                File fichero = new File("fotos/prueba2.jpg");
                fichero.createNewFile();
                //if(fichero.createNewFile())return;   
                ImageIO.write(imagen, "jpg", fichero);
                //----------------------fin proceso--------------------------//

                panelImge.setIcon(new ImageIcon(pathImagen));
                panelImge.repaint();
            } catch (IOException ex) {
                Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_buttonCircle1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int edad = Alternos.retornaEdad(jdateFechaNacimiento.getDate());
        txtEdad.setText(""+(edad-1));
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAlumnno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistrarAlumnno dialog = new FrmRegistrarAlumnno(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser JFechaRegistro;
    private org.edisoncor.gui.button.ButtonAero btnActualizar;
    private org.edisoncor.gui.button.ButtonAero btnLimpiar;
    private org.edisoncor.gui.button.ButtonAero btnModificar;
    private org.edisoncor.gui.button.ButtonAero btnRegitrar;
    private org.edisoncor.gui.button.ButtonAero btndarBaja;
    private org.edisoncor.gui.button.ButtonCircle buttonCircle1;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JPanel contenedorImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdateFechaNacimiento;
    private javax.swing.JPanel panelDatos1;
    private org.edisoncor.gui.panel.PanelImage panelImge;
    private javax.swing.JPanel panelMostrar;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
