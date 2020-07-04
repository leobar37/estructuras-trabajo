/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import ListasAux.ListaEnlazada;
import capaNegocio.Alumno;
import capaNegocio.Matricula;
import capaNegocio.ReportesMatricula;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MostrarMatriculas extends javax.swing.JDialog {

    private int tipo = -1;
    String codMatricula = null;
    private String dniAlumno = null;
    private Alumno objAlumno = null;

    public MostrarMatriculas(java.awt.Frame parent, boolean modal, String dniAlumno) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
        this.dniAlumno = dniAlumno;
        tabla(dniAlumno);
        objAlumno = Alumno.ObtnerAlumno(dniAlumno);
        LlenarDatosAlumno(objAlumno);
    }

    public void LlenarDatosAlumno(Alumno objAlumno) {
        if (objAlumno == null) {
            return;
        }
        imagenPanel.setIcon(new ImageIcon(objAlumno.getImagen()));
        imagenPanel.repaint();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("Nombre: " + objAlumno.getNombre());
        modelo.addElement("Apellidos: " + objAlumno.getApellidos());
        modelo.addElement("Edad:  " + objAlumno.getEdad());
        modelo.addElement("Telefono: " + objAlumno.getCelular());
        listaDatos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imagenPanel = new org.edisoncor.gui.panel.PanelImage();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDatos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cboSeleccion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buttonAero1 = new org.edisoncor.gui.button.ButtonAero();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 186, 4));

        imagenPanel.setBackground(new java.awt.Color(255, 255, 255));
        imagenPanel.setForeground(new java.awt.Color(255, 255, 255));
        imagenPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alumnoIco.png"))); // NOI18N

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        jLabel1.setText("Datos del Alumno:");

        jScrollPane1.setViewportView(listaDatos);

        jLabel2.setText("Matriculas:");

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
        jScrollPane2.setViewportView(tabla);

        cboSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dado de baja", "retirado", "terminado", "retirado por pago" }));

        jLabel3.setText("estado:");

        buttonAero1.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero1.setText("cambiar");
        buttonAero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(cboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(buttonAero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero1ActionPerformed
        int res = JOptionPane.showConfirmDialog(null, "¿Estas Seguro?"
                + "\nalgunas acciones no se pueden restaurar");
        if (res == JOptionPane.YES_OPTION) {
            int cbo = cboSeleccion.getSelectedIndex();
            if (codMatricula == null) {
                JOptionPane.showMessageDialog(null, "No se ha seleccinado una matricula");
                return;
            }

            if (cbo == 0) {
                tipo = Matricula.dadoBaja;
                ReportesMatricula.CambiarEstadoMatricula(codMatricula, tipo);
                codMatricula = null;
                tabla(dniAlumno);
            } else {
                if (cbo == 1) {
                    tipo = Matricula.retirado;
                    ReportesMatricula.CambiarEstadoMatricula(codMatricula, tipo);
                    codMatricula = null;
                    tabla(dniAlumno);
                } else {
                    if (cbo == 2) {
                        tipo = Matricula.terminado;
                        ReportesMatricula.CambiarEstadoMatricula(codMatricula, tipo);
                        codMatricula = null;
                        tabla(dniAlumno);
                    } else {
                        if (cbo == 3) {
                            tipo = Matricula.anuladoxPago;
                            ReportesMatricula.CambiarEstadoMatricula(codMatricula, tipo);
                            codMatricula = null;
                            tabla(dniAlumno);
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_buttonAero1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        codMatricula = tabla.getValueAt(fila, 0).toString();


    }//GEN-LAST:event_tablaMouseClicked

    public void tabla(String num) {
        ListaEnlazada lista = ReportesMatricula.RetornarMatriculas(num);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo Matricula");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("estado");
        Object fila[] = new Object[3];
        for (int i = 0; i < lista.tamaño(); i++) {
            Matricula objMatricula = (Matricula) lista.Buscar(i);
            fila[0] = objMatricula.getIdMatricula();
            fila[1] = objMatricula.getFechaMatricula();
            int aux = objMatricula.getMatriculaEstado();
            fila[2] = retornaEstado(aux);
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
    }

    private String retornaEstado(int aux) {
        String estado = "";
        switch (aux) {
            case Matricula.anuladoxPago:
                estado = "anulado por pago";
                break;
            case Matricula.dadoBaja:
                estado = "dado de baja";
                break;
            case Matricula.activo:
                estado = "Estudiando";
                break;
            case Matricula.retirado:
                estado = "Retirado";
                break;
            case Matricula.terminado:
                estado = "Terminado";
                break;
            default:
                break;
        }
        return estado;
    }

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
            java.util.logging.Logger.getLogger(MostrarMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MostrarMatriculas dialog = new MostrarMatriculas(new javax.swing.JFrame(), true, null);
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
    private org.edisoncor.gui.button.ButtonAero buttonAero1;
    private javax.swing.JComboBox<String> cboSeleccion;
    private org.edisoncor.gui.panel.PanelImage imagenPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaDatos;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
