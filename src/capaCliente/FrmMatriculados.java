/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import Alternos.Alternos;
import Alternos.Grafico;
import ListasAux.ListaEnlazada;
import capaNegocio.Alumno;

import capaNegocio.ReporteAlumno;
import capaNegocio.ReportesMatricula;

import java.awt.event.ItemEvent;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Leobar37
 */
public class FrmMatriculados extends javax.swing.JDialog {

    public static JFreeChart imagen;
    public JDialog dialogoReporte = null;
    private ListaEnlazada lista = null;
    //informa al evento que se selecciono matriculados o no matriculados
    //matriculados = 1 No matriculados = 2

    private int activateNoMatri = 0;

    public FrmMatriculados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //tabla();
        // this.setSize(770, 530);
        setLocationRelativeTo(null);
       //mostrarGraficoMatriculado();
    }

    /*
    public void tabla() {
     DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("DNI Alumno");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");

        //  int codGrupo = Integer.parseInt(cboGrupos.getSelectedItem().toString());
        ListasAux.ListaEnlazada listaAlumnos;
        listaAlumnos = ReportesMatricula.mostrarAlumnosMatriculados();
        if (listaAlumnos.tamaño() > 0) {
            Object datos[] = new Object[3];
            for (int i = 0; i < listaAlumnos.tamaño(); i++) {
                Alumno alu = (Alumno) listaAlumnos.Buscar(i);
                datos[0] = alu.getDni();
                datos[1] = alu.getNombres();
                datos[2] = alu.getApellidos();
                modelo.addRow(datos);
            }
            //  tabla.setModel(modelo);
        }
    }
     */
    public void mostrarGraficoMatriculado() {
        ListaEnlazada lista2 = ReportesMatricula.mostrarAlumnosMatriculados();
        ListaEnlazada lista3 = ReportesMatricula.mostrarAlumnosNoMatriculados();
        int arr[] = {lista2.tamaño(),lista3.tamaño()};
        String namme[] = {"Matriculados", "no Matriculados"};
        Grafico.GraficoCircular(panelMatriculas, arr, namme);
        int[] arr1 = ReporteAlumno.retornoXGenero(lista2);
        int[] arr2 = ReporteAlumno.retornoXGenero(lista3);
        int[] totalGen = {(arr1[0] + arr2[0]), (arr1[1] + arr2[1])};
        String gen[] = {"Femenino", "Masculino"};
        Grafico.GraficoCircular(panel1, totalGen, gen);
    }

    public void tabla(ListaEnlazada list) {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int n, int l) {
                return false;
            }
        };
        modelo.addColumn("dni");
        modelo.addColumn("nombre");
        modelo.addColumn("apellidos");
        modelo.addColumn("edad");
        modelo.addColumn("F. Registro");
        modelo.addColumn("F.Nacimiento");
        modelo.addColumn("sexo");
        Object fila[] = new Object[7];
        for (int i = 0; i < list.tamaño(); i++) {
            Alumno objAlumno = (Alumno) list.Buscar(i);
            fila[0] = objAlumno.getDni();
            fila[1] = objAlumno.getNombre();
            fila[2] = objAlumno.getApellidos();
            fila[3] = objAlumno.getEdad();
            fila[4] = objAlumno.getFechaRegistro();
            fila[5] = objAlumno.getFechaNacimiento();
            fila[6] =objAlumno.getSexo();
            modelo.addRow(fila);

        }
        tabla.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        PopMenuRegistrado = new javax.swing.JPopupMenu();
        OpenMatriculas = new javax.swing.JMenuItem();
        PopMenuMatriculados = new javax.swing.JPopupMenu();
        panelCentro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cboSelect = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMostrarGrafico = new org.edisoncor.gui.button.ButtonAero();
        buttonAero2 = new org.edisoncor.gui.button.ButtonAero();
        buttonAero4 = new org.edisoncor.gui.button.ButtonAero();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboOrdena = new javax.swing.JComboBox<>();
        buttonAero1 = new org.edisoncor.gui.button.ButtonAero();
        panelGraficos = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelMatriculas = new javax.swing.JPanel();
        buttonAero3 = new org.edisoncor.gui.button.ButtonAero();

        jLabel8.setText("jLabel8");

        OpenMatriculas.setText("Consultar Matriculas");
        OpenMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMatriculasActionPerformed(evt);
            }
        });
        PopMenuRegistrado.add(OpenMatriculas);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCentro.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(249, 187, 3));

        jLabel1.setText("Tipo de consulta:");

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "matriculados", "no matriculados" }));
        cbotipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jLabel4.setText("regular resultado:");

        cboSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dias", "meses", "semanas", "Grupos" }));

        jLabel6.setText("Rango de Fechas:");

        jLabel11.setText("cantidad:");

        lblCantidad.setText("??????");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(lblCantidad))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(cboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(125, 125, 125))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel5.setText("Reporte de Alumnos Registrados y Matriculados(grafico)");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnMostrarGrafico.setBackground(new java.awt.Color(0, 0, 0));
        btnMostrarGrafico.setText("GRAFICO");
        btnMostrarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarGraficoActionPerformed(evt);
            }
        });

        buttonAero2.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero2.setText("GUARDAR");
        buttonAero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero2ActionPerformed(evt);
            }
        });

        buttonAero4.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero4.setText("MOSTRAR");
        buttonAero4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMostrarGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAero4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(buttonAero2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMostrarGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAero4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel9.setText("Lista:");

        jLabel10.setText("ordenar por:");

        cboOrdena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "edad", "apellidos", "fecha Nacimiento", "fecha de Registro", "nombres" }));

        buttonAero1.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero1.setText("ORDENAR");
        buttonAero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero1ActionPerformed(evt);
            }
        });

        panelGraficos.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jLabel7.setText("Grafico Matriculados:");

        jLabel13.setText("Grafico por Genero:");

        panelMatriculas.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout panelMatriculasLayout = new javax.swing.GroupLayout(panelMatriculas);
        panelMatriculas.setLayout(panelMatriculasLayout);
        panelMatriculasLayout.setHorizontalGroup(
            panelMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMatriculasLayout.setVerticalGroup(
            panelMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        buttonAero3.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero3.setText("CONSULTAR POR INTERVALO DE FECHA");
        buttonAero3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
        panelGraficos.setLayout(panelGraficosLayout);
        panelGraficosLayout.setHorizontalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficosLayout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficosLayout.createSequentialGroup()
                        .addGroup(panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelMatriculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panelGraficosLayout.createSequentialGroup()
                        .addGroup(panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(buttonAero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelGraficosLayout.setVerticalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(panelMatriculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCentroLayout = new javax.swing.GroupLayout(panelCentro);
        panelCentro.setLayout(panelCentroLayout);
        panelCentroLayout.setHorizontalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentroLayout.createSequentialGroup()
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5))
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCentroLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCentroLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCentroLayout.setVerticalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCentroLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipoItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            String modo = cbotipo.getSelectedItem().toString();
            if (modo.equalsIgnoreCase("matriculados")) {
                lista = ReportesMatricula.mostrarAlumnosMatriculados();
                int[] num = ReporteAlumno.retornoXGenero(lista);
                String[] genero = {"mujeres", "varones"};
               
                
                Grafico.GraficoCircular(panel1, num, genero);
                activateNoMatri = 1;
                lblCantidad.setText("" + (lista.tamaño()));
                tabla(lista);
            } else {
                activateNoMatri = 2;
                lista = ReportesMatricula.mostrarAlumnosNoMatriculados();
                int[] num = ReporteAlumno.retornoXGenero(lista);
               
                String[] genero = {"mujeres", "varones"};
               // panel1.repaint();
                Grafico.GraficoCircular(panel1, num, genero);
                lblCantidad.setText("" + (lista.tamaño()));
                tabla(lista);
            }
        }
    }//GEN-LAST:event_cbotipoItemStateChanged
    private void VentanaReporte(DefaultCategoryDataset data, int tipo) {
        String tipoReporte = "";
        if (tipo == ReportesMatricula.AlumnosMatriculados) {
            tipoReporte = "Grafico Matriculados";
        }
        if (tipo == ReportesMatricula.AlumnosNoMatriculados) {
            tipoReporte = "Grafico no Matriculados";
        }
        if (dialogoReporte == null) {
            dialogoReporte = new JDialog(this, false);
            imagen = Grafico.GraficoBarrasG(this, dialogoReporte, data, tipoReporte, "---", "Cantidad");
            
        } else {
            // if(dialogoReporte.isActive()){
            dialogoReporte.dispose();
            dialogoReporte = null;
            dialogoReporte = new JDialog(this, false);
            imagen = Grafico.GraficoBarrasG(this, dialogoReporte, data, tipoReporte, "---", "Cantidad");                  //}

        }
    }
    private void btnMostrarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarGraficoActionPerformed
        String dato1 = ((JTextField) fechaInicio.getDateEditor().getUiComponent()).getText();
        String dato2 = ((JTextField) fechaFin.getDateEditor().getUiComponent()).getText();
        if (dato1.equalsIgnoreCase("") || dato2.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado el rango de fechas");
            return;
        }
        String selecion = cboSelect.getSelectedItem().toString();
        String tipo = cbotipo.getSelectedItem().toString();
        int tipoaux = 0;
        if (tipo.equals("matriculados")) {
            tipoaux = ReportesMatricula.AlumnosMatriculados;
        }
        if (tipo.equals("no matriculados")) {
            tipoaux = ReportesMatricula.AlumnosNoMatriculados;
        }
        Date fechaI = fechaInicio.getDate();
        Date fechaF = fechaFin.getDate();
        DefaultCategoryDataset datos = null;

        switch (selecion) {
            case "dias":
                java.util.List<Date> lista = ReportesMatricula.getIntervaloFechas(fechaI, fechaF, Calendar.DAY_OF_MONTH);
                if (lista.size() > 60) {
                    JOptionPane.showMessageDialog(null, "Ups..."
                            + "\nAl parecer son muchos dias"
                            + "\nPor favor reduzca el rango");
                } else {
                    datos = ReportesMatricula.reporteMatriculas(tipoaux, fechaI, fechaF, Calendar.DAY_OF_MONTH);
                    VentanaReporte(datos, tipoaux);
                    //  System.out.println("dias");
                }

                break;
            case "meses":
                java.util.List<Date> lista2 = ReportesMatricula.getIntervaloFechas(fechaI, fechaF, Calendar.MONTH);
                if (lista2.size() > 12) {
                    JOptionPane.showMessageDialog(null, "Ups..."
                            + "\nAl parecer son muchos meses"
                            + "\nPor favor reduzca el rango");
                    return;
                }
                datos = ReportesMatricula.reporteMatriculas(tipoaux, fechaI, fechaF, Calendar.MONTH);
                VentanaReporte(datos, tipoaux);
                //  System.out.println("meses");
                break;
            case "semanas":
                java.util.List<Date> lista3 = ReportesMatricula.getIntervaloFechas(fechaI, fechaF, Calendar.MONTH);
                if (lista3.size() > 10) {
                    JOptionPane.showMessageDialog(null, "Ups..."
                            + "\nAl parecer son muchos semanas"
                            + "\nPor favor reduzca el rango");
                    return;
                }
                datos = ReportesMatricula.reporteMatriculas(tipoaux, fechaI, fechaF, Calendar.WEEK_OF_MONTH);
                VentanaReporte(datos, tipoaux);
                //System.out.println("semanas");
                break;
            case "Grupos":
                //condiciomn
                if (activateNoMatri == 2) {
                    JOptionPane.showMessageDialog(null, "UPS..."
                            + "\nERROR DE SELECCION");
                    return;
                }
                datos = ReportesMatricula.reporteMatriculas(tipoaux, fechaI, fechaF, ReportesMatricula.ReGrupo);
                VentanaReporte(datos, tipoaux);
                break;
            default:
                break;
        }


    }//GEN-LAST:event_btnMostrarGraficoActionPerformed

    private void buttonAero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero2ActionPerformed

        String nombre = JOptionPane.showInputDialog(null, "ingrese nombre del reporte");

        Grafico.GuardarReporte(imagen, nombre);
        JOptionPane.showMessageDialog(null, "Se guardo el archivo");

        //String ruta = jfr.getCurrentDirectory().getAbsolutePath();

    }//GEN-LAST:event_buttonAero2ActionPerformed

    private void buttonAero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero1ActionPerformed
        int select = cboOrdena.getSelectedIndex();
        if (select == 0) {
            lista = ReporteAlumno.OrdenPorEdad(lista);
            tabla(lista);
        }
        if (select == 1) {
            lista = ReporteAlumno.OrdenarxApellido(lista);
            tabla(lista);
        }
        if (select == 2) {
            lista = ReporteAlumno.OrdenarxFechaNacimiento(lista);
            tabla(lista);
        }
        if (select == 3) {
            lista = ReporteAlumno.ordenarxFechaRegistro(lista);
            tabla(lista);
        }
        if (select == 4) {
            lista = ReporteAlumno.OrdenarxNombre(lista);
            tabla(lista);
        }


    }//GEN-LAST:event_buttonAero1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            PopMenuRegistrado.show(evt.getComponent(), evt.getX(), evt.getY());
        }


    }//GEN-LAST:event_tablaMouseClicked

    private void OpenMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMatriculasActionPerformed
        String dni = null;
        dni = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        if (activateNoMatri == 1 && dni != null) {
           
            MostrarMatriculas objMatricula = new MostrarMatriculas(null, true, dni);
            objMatricula.setVisible(true);
        }
        // MostrarMatriculas objMatricula = new o
    }//GEN-LAST:event_OpenMatriculasActionPerformed

    private void buttonAero4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero4ActionPerformed
      mostrarGraficoMatriculado();
    }//GEN-LAST:event_buttonAero4ActionPerformed

    private void buttonAero3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero3ActionPerformed
        String dato1 = ((JTextField) fechaInicio.getDateEditor().getUiComponent()).getText();
        String dato2 = ((JTextField) fechaFin.getDateEditor().getUiComponent()).getText();
        if (dato1.equalsIgnoreCase("") || dato2.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado el rango de fechas");
            return;
        }
        String namme[] = {"Matriculados", "no Matriculados"};
        int n[] = ReportesMatricula.retornaMatyNoMatxRango(Alternos.formatoFecha(fechaInicio.getDate()), Alternos.formatoFecha(fechaFin.getDate()));
       
            Grafico.GraficoCircular(panelMatriculas, n,namme);
    }//GEN-LAST:event_buttonAero3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMatriculados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatriculados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMatriculados dialog = new FrmMatriculados(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuItem OpenMatriculas;
    private javax.swing.JPopupMenu PopMenuMatriculados;
    private javax.swing.JPopupMenu PopMenuRegistrado;
    private org.edisoncor.gui.button.ButtonAero btnMostrarGrafico;
    private org.edisoncor.gui.button.ButtonAero buttonAero1;
    private org.edisoncor.gui.button.ButtonAero buttonAero2;
    private org.edisoncor.gui.button.ButtonAero buttonAero3;
    private org.edisoncor.gui.button.ButtonAero buttonAero4;
    private javax.swing.JComboBox<String> cboOrdena;
    private javax.swing.JComboBox<String> cboSelect;
    private javax.swing.JComboBox<String> cbotipo;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelGraficos;
    private javax.swing.JPanel panelMatriculas;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
