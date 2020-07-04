/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaCliente;

import ListasAux.ListaEnlazada;
import capaDatos.ListaCuotas;
import capaNegocio.Cuota;

import capaNegocio.ReporteCuotas;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmReportePagos extends javax.swing.JDialog {

    private String dni = null;

    public FrmReportePagos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ListaEnlazada lista = Cuota.PagosVecidos();
        tablaNormal(lista);
        validaciones();
        setLocationRelativeTo(null);
    }

    public void validaciones() {
        Alternos.Alternos.limitarSoloNumeroRes(txtDe, 3);
        Alternos.Alternos.limitarSoloNumeroRes(txthasta, 3);
        Alternos.Alternos.limitarSoloMontos(txtMora);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menPrincipal = new javax.swing.JPopupMenu();
        pago = new javax.swing.JMenuItem();
        matricula = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        buttonAero2 = new org.edisoncor.gui.button.ButtonAero();
        jLabel6 = new javax.swing.JLabel();
        txtDe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txthasta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        pago.setText("detalles de pago");
        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });
        menPrincipal.add(pago);

        matricula.setText("detalles de matricula");
        matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaActionPerformed(evt);
            }
        });
        menPrincipal.add(matricula);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 187, 3));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Reporte de Pagos");

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

        jLabel2.setText("Alumnos que deben:");

        jLabel4.setText("mora:");

        buttonAero2.setBackground(new java.awt.Color(0, 0, 0));
        buttonAero2.setText("aplicar mora");
        buttonAero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAero2ActionPerformed(evt);
            }
        });

        jLabel6.setText("rango de :");

        jLabel7.setText("hasta:");

        jLabel8.setText("dias");

        jLabel10.setText("aplicar mora en un rango de dias:");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(buttonAero2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 60, Short.MAX_VALUE))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(32, 32, 32)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(buttonAero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("configurar Mora");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla2);

        jLabel9.setText("cuotas:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        dni = tabla.getValueAt(fila, 1).toString();
        ListaEnlazada lista = ListaCuotas.cuotasxAlumno(dni);
        llenarTablaCuotas(lista);
        if (evt.getClickCount() == 2) {
             menPrincipal.show(evt.getComponent(), evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void buttonAero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAero2ActionPerformed
        if (!Alternos.Alternos.Probar(panel2)) {
            JOptionPane.showMessageDialog(this, "hay espacios vacios");
            return;
        } else {
            int m = JOptionPane.showConfirmDialog(this, "SE APLICARA LA MORA A TODOS"
                    + "\nLAS CUOTA QUE SE ENCUENTREN EN ESE RANGO DE DIAS TARDADOS", "SISTEMA", JOptionPane.YES_OPTION);
            if (m == JOptionPane.YES_OPTION) {
                int desde = Integer.parseInt(txtDe.getText());
                int hasta = Integer.parseInt(txthasta.getText());
                float mora = Float.parseFloat(txtMora.getText());
                ReporteCuotas.aplicarMora(desde, hasta, mora);
                JOptionPane.showMessageDialog(this, "Se aplico correctamente la mora");
            }
        }

    }//GEN-LAST:event_buttonAero2ActionPerformed

    private void pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoActionPerformed
        if (dni == null) {
            JOptionPane.showMessageDialog(null, "dni no seleccionado");
            return;
        }
        FrmControlDePagos objDePagos = new FrmControlDePagos(null, true, dni);
        objDePagos.setVisible(true);
    }//GEN-LAST:event_pagoActionPerformed

    private void matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaActionPerformed
        if (dni == null) {
            JOptionPane.showMessageDialog(null, "dni no seleccionado");
            return;
        }
        MostrarMatriculas objMatriculas = new MostrarMatriculas(null, true, dni);
        objMatriculas.setVisible(true);

    }//GEN-LAST:event_matriculaActionPerformed

    public void llenarTablaCuotas(ListaEnlazada lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nro de cuota");
        modelo.addColumn("vencimiento");
        modelo.addColumn("monto");
        modelo.addColumn("estado");
        modelo.addColumn("dias atrasado");
        Object fila[] = new Object[5];
        for (int i = 0; i < lista.tamaño(); i++) {
            Cuota objCuota = (Cuota) lista.Buscar(i);
            fila[0] = objCuota.getIdCuota();
            Date fechaAux = Alternos.Alternos.formatoFecha(objCuota.getFecha());
            fila[1] = fechaAux;
            fila[2] = objCuota.getMonto();
            if (objCuota.isEstado()) {
                String p = "pagado";
                fila[3] = p;
                fila[4] = "-";
            } else {
                int p = Cuota.cuotaVencida(objCuota);
                fila[3] = "deuda";
                if (p > 0) {
                    fila[4] = p;
                } else {
                    fila[4] = "-";
                }
            }
            modelo.addRow(fila);

        }
        tabla2.setModel(modelo);

    }
//metodo entra en accion en aplicar mora

    public void tabla(ListaEnlazada list) {
        boolean[] editable = {false, false, false, false, true};
        DefaultTableModel modelo = new DefaultTableModel() {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columIndex) {
                return types[columIndex];
            }

            @Override
            public boolean isCellEditable(int a, int b) {
                return editable[b];
            }

        };
        modelo.addColumn("nombre");
        modelo.addColumn("dni");
        modelo.addColumn("deuda Total");
        modelo.addColumn("Cant Cuotas");
        modelo.addColumn("prueba");
        Object fila[] = new Object[5];
        for (int i = 0; i < list.tamaño(); i++) {
            String[] arr = (String[]) list.Buscar(i);
            fila[0] = arr[0];
            fila[1] = arr[1];
            fila[2] = arr[2];
            fila[3] = arr[3];
            fila[4] = true;
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
    }

    public void tablaNormal(ListaEnlazada list) {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int a, int b) {
                return false;
            }

        };
        modelo.addColumn("nombre");
        modelo.addColumn("dni");
        modelo.addColumn("deuda Total");
        modelo.addColumn("Cant Cuotas");
        Object fila[] = new Object[5];
        for (int i = 0; i < list.tamaño(); i++) {
            String[] arr = (String[]) list.Buscar(i);
            fila[0] = arr[0];
            fila[1] = arr[1];
            fila[2] = arr[2];
            fila[3] = arr[3];
            modelo.addRow(fila);

        }
        tabla.setModel(modelo);
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
            java.util.logging.Logger.getLogger(FrmReportePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportePagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmReportePagos dialog = new FrmReportePagos(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonAero buttonAero2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem matricula;
    private javax.swing.JPopupMenu menPrincipal;
    private javax.swing.JMenuItem pago;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField txtDe;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txthasta;
    // End of variables declaration//GEN-END:variables
}
