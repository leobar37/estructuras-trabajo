/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import ListasAux.ListaEnlazada;

import capaDatos.listaGrupos;

import capaNegocio.Grupo;
import capaNegocio.Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmMostrarGrupos extends javax.swing.JDialog {

    private String numSerie;
    private int codGrupo;
    private static Matricula obMatricula;

    public FrmMostrarGrupos(java.awt.Frame parent, boolean modal, String numSerie) {
        super(parent, modal);

        initComponents();
        listaGrupos.obtenerLista();
        this.numSerie = numSerie;
        tabla();
        this.setResizable(false);
        this.setTitle("Grupos Disponibles");
        setLocationRelativeTo(null);
    }

    public static Matricula getObMatricula() {
        return obMatricula;
    }

    public void setObMatricula(Matricula obMatricula) {
        this.obMatricula = obMatricula;
    }

    public void tabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("PROGRAMA");
        modelo.addColumn("NIVEL");
        modelo.addColumn("MODALIDAD");
        modelo.addColumn("LIBROS");
        modelo.addColumn("HORARIO");
        modelo.addColumn("FECHA I");
        ListaEnlazada lista;
        lista = Grupo.consultarTodo();
        Grupo grup;

        Object datos[] = new Object[7];

        for (int i = 0; i < lista.tamaño(); i++) {
            grup = (Grupo) lista.Buscar(i);
            datos[0] = grup.getIdGrupo();
            datos[1] = grup.getPrograma();
            datos[2] = grup.getNivel();
            datos[3] = grup.getModalidad();
            datos[4] = grup.getLibro();
            datos[5] = grup.getHorario();
            datos[6] = grup.getFechaInicio();
            modelo.addRow(datos);
        }
        tblGrupos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrupos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonAeroRight1 = new org.edisoncor.gui.button.ButtonAeroRight();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 187, 3));

        tblGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrupos);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Grupos disponibles");

        buttonAeroRight1.setBackground(new java.awt.Color(0, 0, 0));
        buttonAeroRight1.setText("confirmar");
        buttonAeroRight1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAeroRight1ActionPerformed(evt);
            }
        });

        jLabel2.setText("vicular Grupo:");

        lblGrupo.setText("???");

        jLabel4.setText("a matricula:");

        lblAlumno.setText("??????");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblGrupo)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblAlumno)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblGrupo)
                    .addComponent(jLabel4)
                    .addComponent(lblAlumno))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(buttonAeroRight1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAeroRight1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGruposMouseClicked

        int fila = tblGrupos.getSelectedRow();
        codGrupo = Integer.parseInt(tblGrupos.getValueAt(fila, 0).toString());
        lblGrupo.setText("" + codGrupo);
        lblAlumno.setText("" + numSerie);

    }//GEN-LAST:event_tblGruposMouseClicked

    private void buttonAeroRight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAeroRight1ActionPerformed
        //Matricula objMatricula = Matricula.obtenerMatricula(dniAlumno);
        int conf = JOptionPane.showConfirmDialog(null, "¿Desea vincular este grupo?", "CONFIRMACION", JOptionPane.YES_OPTION);
        if (conf == JOptionPane.YES_OPTION) {

            obMatricula = new Matricula(codGrupo, numSerie);
         
            FrmMatricula.setMatricula(obMatricula);
            dispose();
                 
        }

    }//GEN-LAST:event_buttonAeroRight1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMostrarGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMostrarGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMostrarGrupos dialog = new FrmMostrarGrupos(new javax.swing.JFrame(), true, null);
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
    private org.edisoncor.gui.button.ButtonAeroRight buttonAeroRight1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JTable tblGrupos;
    // End of variables declaration//GEN-END:variables
}
