/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import Alternos.Alternos;
import capaDatos.listaAlumno;
import capaDatos.listaGrupos;
import capaDatos.listaMatricula;
import capaNegocio.Alumno;
import capaNegocio.Grupo;
import capaNegocio.Matricula;
import capaNegocio.Pago;
import capaNegocio.ReportesMatricula;
import java.util.Date;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmMatricula extends javax.swing.JFrame {
    
    private String dniAlumno = null;
    private Alumno auxAlumno = null;
    private Grupo grupo = null;
    private Pago pago = null;
    private Alumno alumn = null;
    private static Matricula matricula = null;
    private String numSerie = null;
    public FrmMatricula() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Matricula");
        validaciones();
        this.setResizable(false);
        //  listaAlumno.llenarlista();
        //listaGrupos.obtenerLista();
        //listaMatricula.llenarlista();

    }
    
    public void validaciones() {
        Alternos.limitarSoloNumeroRes(txtDniAlumno, 8);
        Alternos.limitarSoloNumeroRes(txtNroCuotas, 1);
        Alternos.limitarSoloMontos(txtAcuenta);
        
    }
    
    public static Matricula getMatricula() {
        return matricula;
    }
    
    public static void setMatricula(Matricula mat) {
        matricula = mat;
    }
    
    public void Limpiar() {
        numSerie =null;
        dniAlumno = null;
        auxAlumno = null;
        grupo = null;
        setMatricula(null);
        pago = null;
        alumn = null;
        ((JTextField) fechaPago.getDateEditor().getUiComponent()).setText("");
        Alternos.LimpiarCajas(panel1);
        Alternos.LimpiarCajas(panel2);
        lblNombre.setText("?????");
        lblApellidos.setText("?????");
        lblGrupo.setText("????");
        lblMontoPago.setText("?????");
        lblCuotaxMes.setText("?????");
        llenarListaDatosGrupo(null,false);
        llenarListaFecha(null,false);
        txtAcuenta.setEnabled(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDniAlumno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDatos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jdateFechaMatricula = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        lblNumSerie = new javax.swing.JLabel();
        btnGenerarNumSerie = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMontoPago = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNroCuotas = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblCuotaxMes = new javax.swing.JLabel();
        buttonAeroLeft1 = new org.edisoncor.gui.button.ButtonAeroLeft();
        jLabel11 = new javax.swing.JLabel();
        txtAcuenta = new javax.swing.JTextField();
        fechaPago = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        buttonAero1 = new org.edisoncor.gui.button.ButtonAero();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(249, 187, 3));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Alumno:");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Grupo");

        jLabel3.setText("Nombre:");

        jLabel4.setText("apellidos:");

        lblNombre.setText("-----------------------------------");

        lblApellidos.setText("-----------------------------------");

        lblGrupo.setText("----------------------------------");

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaDatos);

        jLabel5.setText("Detalles de Grupo:");

        jLabel14.setText("N. Matricula:");

        lblNumSerie.setText("??????");

        btnGenerarNumSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarNumSerieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(10, 10, 10))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(lblNumSerie)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGenerarNumSerie)
                                    .addComponent(jButton1)))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jdateFechaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblNumSerie))
                    .addComponent(btnGenerarNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblApellidos))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblGrupo))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jdateFechaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(249, 187, 3));

        jLabel6.setText("Detalles de Pago");

        jLabel7.setText("Monto : ");

        lblMontoPago.setText("?????");

        jLabel8.setText("numero de cuotas:");

        txtNroCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroCuotasActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("monto por cada Cuota");

        lblCuotaxMes.setText("??????");

        buttonAeroLeft1.setBackground(new java.awt.Color(0, 0, 0));
        buttonAeroLeft1.setText("MATRICULAR");
        buttonAeroLeft1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAeroLeft1ActionPerformed(evt);
            }
        });

        jLabel11.setText("a cuenta:");

        jLabel12.setText("primer pago:");

        jScrollPane2.setViewportView(lista2);

        jLabel13.setText("Fechas de pago");

        buttonAero1.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero1.setText("LIMPIAR");
        buttonAero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel6))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel7))
                                        .addGap(9, 9, 9)))
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCuotaxMes))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(fechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblMontoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAeroLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel11)
                        .addGap(54, 54, 54)
                        .addComponent(txtAcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(22, 22, 22)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoPago)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(fechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblCuotaxMes))
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAeroLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Registro de Matricula ");

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(20, 20, 20)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        alumn = listaAlumno.buscaxDniAumno(txtDniAlumno.getText());
        
        if (alumn == null) {
            int dato = JOptionPane.showConfirmDialog(null, "Alumno no encontrado "
                    + "\n ¿desea Registrarlo?", "¡alerta!", JOptionPane.YES_OPTION);
            if (dato == JOptionPane.YES_OPTION) {
                //System.out.println("valor si");
                FrmRegistrarAlumnno objAlumnno = new FrmRegistrarAlumnno(null, true);
                objAlumnno.setVisible(true);
                return;
            } else {
                return;
            }
            
        } else {
            auxAlumno = alumn;
            System.out.println("registrado" + alumn.getDni());
            dniAlumno = txtDniAlumno.getText();
            lblApellidos.setText(alumn.getApellidos());
            lblNombre.setText(alumn.getNombre());
        }/*
        Alumno alumn2 = listaAlumno.buscaxDniAumno(txtDniAlumno.getText());
        if (alumn2 == null) {
            JOptionPane.showMessageDialog(null, "alumno no registrado");
            return;
        }*/

        //lblGrupo.setText(""+ob);
    }//GEN-LAST:event_jButton1ActionPerformed
    //cuando aux es verdadero cargara los datos 
    //cua
    public void llenarListaDatosGrupo(Grupo gr,boolean aux) {
        DefaultListModel modelo = new DefaultListModel();
       if(aux){
        modelo.addElement("Nivel: " + gr.getNivel());
        modelo.addElement("Libro: " + gr.getLibro());
        modelo.addElement("Programa: " + gr.getPrograma());
        modelo.addElement("Modalidad: " + gr.getModalidad());          
       } 
 
        listaDatos.setModel(modelo);
        
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (dniAlumno == null) {
            return;
        }
          boolean ver= ReportesMatricula.verificarMatricula(dniAlumno);
         if(ver){
             Matricula mat = getMatricula();
            if (mat == null) {
                if(numSerie ==null){
                   JOptionPane.showMessageDialog(null, "No se ha generado un numero de serie");    
                    return;
                }
                FrmMostrarGrupos obFrmMostrarGrupos = new FrmMostrarGrupos(null, true, numSerie);
                obFrmMostrarGrupos.setVisible(true);
            } else {
                //System.out.println("se encontro en el frm");
                lblGrupo.setText("" + mat.getCodGrupo());
                grupo = listaGrupos.obtnerGrupo(mat.getCodGrupo());
                // if(grupo== null)
                lblMontoPago.setText("" + grupo.getPrecioTotal());
                llenarListaDatosGrupo(grupo,true);
            }  
         }else{
             JOptionPane.showMessageDialog(null, "Este alumno cuenta con una matricula en curso");
         }  

/*
        //  Alumno alumn = listaAlumno.buscaxDniAumno(txtDniAlumno.getText());
        if (mat1 == null) {
           // System.out.println("se encontro en la lista");
          
            
        } else {
            
            lblGrupo.setText("" + mat1.getCodGrupo());
            grupo = listaGrupos.obtnerGrupo(mat1.getCodGrupo());
            // if(grupo== null)
            lblMontoPago.setText("" + grupo.getPrecioTotal());
            llenarListaDatosGrupo(grupo,true);
            LlenarDatosPago(mat1.getPagoAlumno());
        }
        */
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNroCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroCuotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroCuotasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confi = JOptionPane.showConfirmDialog(null, "¿esta seguro de cerrar?"
                + "\nlos datos modificados se perderan ", "!WARNIGN¡", JOptionPane.YES_OPTION);
        if (confi == JOptionPane.YES_OPTION) {
            Alumno.modificarAlumno(dniAlumno, auxAlumno);
            setMatricula(null);
            dispose();
            
        }

    }//GEN-LAST:event_formWindowClosing
    //cuando aux es true los datos se van a llenar
    
    public void llenarListaFecha(List<java.util.Date> listaFecha,boolean aux) {
        DefaultListModel modelo = new DefaultListModel();
       if(aux){
        for (int i = 0; i < listaFecha.size(); i++) {
            java.util.Date dato = listaFecha.get(i);
            String fecha = Alternos.convertirFecha(dato);
            modelo.addElement(fecha);
        }    
       } 
       
        lista2.setModel(modelo);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtNroCuotas.getText().equalsIgnoreCase("")) {
            return;
        }
        int nroCuota = Integer.parseInt(txtNroCuotas.getText());
        if (nroCuota == 0) {
            return;
        }
        pago = new Pago(grupo.getPrecioTotal(), nroCuota);
        lblCuotaxMes.setText("" + pago.Montocuota());
        java.util.Date fechaPrimerPago = fechaPago.getDate();
        List<java.util.Date> listaFecha = Pago.getMesesDePago(fechaPrimerPago, nroCuota);
        llenarListaFecha(listaFecha,true);
    }//GEN-LAST:event_jButton3ActionPerformed
    public void LlenarDatosPago(Pago pago) {
        lblCuotaxMes.setEnabled(false);
        lblCuotaxMes.setText("" + pago.getNroCuotas());
        fechaPago.setDate(pago.getFechaPago());
        List<java.util.Date> listaFecha = Pago.getMesesDePago(pago.getFechaPago(), pago.getNroCuotas());
        llenarListaFecha(listaFecha,true);
        txtAcuenta.setEnabled(false);
        txtAcuenta.setText("" + pago.getCuenta());
    }
    private void buttonAeroLeft1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAeroLeft1ActionPerformed
        if(!Alternos.Probar(panel1)  || !Alternos.Probar(panel2)){
            JOptionPane.showMessageDialog(null,"Existen campos vacios");
            return;
        }
        float montoCuenta = Float.parseFloat(txtAcuenta.getText());
        if (montoCuenta >= 50) {
            pago.setCuenta(montoCuenta);
            java.util.Date fechaPrimerPago = fechaPago.getDate();
            pago.setFechaPago(fechaPrimerPago);            
            Matricula objMatricula = FrmMostrarGrupos.getObMatricula();
            objMatricula.setDniAlumno(dniAlumno);
            objMatricula.setPagoAlumno(pago);
            Date fechaMatricula = Alternos.formatoFecha(jdateFechaMatricula.getDate());
            objMatricula.setFechaMatricula(fechaMatricula);
        
           
            if(numSerie==null){
               JOptionPane.showMessageDialog(null, "No se ha Generado Un Numero de Serie");
               return;
            }
            objMatricula.setIdMatricula(numSerie);
                pago.generarPagos(numSerie);
            objMatricula.setMatriculaEstado(Matricula.activo);
            listaMatricula.adicionar(objMatricula);  
            //listaMatricula.guardarLista();
            System.out.println("grupos"+objMatricula.getCodGrupo());
            JOptionPane.showMessageDialog(null, "ALUMNO MATRICULADO CON EXITO");
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "COMO REQUISITO SE TIENE QUE PAGAR LA MATRICULA"
                    + "CON VALOR A 50 SOLES", "SISTEMA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonAeroLeft1ActionPerformed

    private void buttonAero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero1ActionPerformed
        Limpiar();
        
    }//GEN-LAST:event_buttonAero1ActionPerformed

    private void btnGenerarNumSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarNumSerieActionPerformed
         numSerie = Matricula.GenerarNumeroMatricula();   
        lblNumSerie.setText(""+numSerie);
    }//GEN-LAST:event_btnGenerarNumSerieActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarNumSerie;
    private org.edisoncor.gui.button.ButtonAero buttonAero1;
    private org.edisoncor.gui.button.ButtonAeroLeft buttonAeroLeft1;
    private com.toedter.calendar.JDateChooser fechaPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdateFechaMatricula;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCuotaxMes;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblMontoPago;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumSerie;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> listaDatos;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTextField txtAcuenta;
    private javax.swing.JTextField txtDniAlumno;
    private javax.swing.JTextField txtNroCuotas;
    // End of variables declaration//GEN-END:variables
}
