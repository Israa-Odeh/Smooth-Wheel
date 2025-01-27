/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class RentalTable extends javax.swing.JFrame {

    private int selectedRowIndex;

    /**
     * Creates new form CarsTable
     */
    public RentalTable() {
        initComponents();
        jTbl_Rental.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        jTbl_Rental.getTableHeader().setOpaque(false);
        jTbl_Rental.setRowHeight(25);
        jScrollPane1.getViewport().setBackground(new Color(237,228,213));
    }

    public JTable getTableName() {
        return jTbl_Rental;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_Rental = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(237, 228, 213));
        jLabel1.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        jLabel1.setText("Smooth Wheel  ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 56));

        jTbl_Rental.setBackground(new java.awt.Color(242, 239, 239));
        jTbl_Rental.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTbl_Rental.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Car ID", "Pickup Date", "Return Date", "Rental Fee"
            }
        ));
        jTbl_Rental.setFocusable(false);
        jTbl_Rental.setGridColor(new java.awt.Color(51, 28, 28));
        jTbl_Rental.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTbl_Rental.setRowHeight(25);
        jTbl_Rental.setSelectionBackground(new java.awt.Color(72, 87, 128));
        jTbl_Rental.setShowGrid(true);
        jTbl_Rental.setShowHorizontalLines(false);
        jTbl_Rental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbl_RentalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbl_Rental);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 1280, 500));

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

    private void jTbl_RentalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_RentalMouseClicked
        try {
            DefaultTableModel RentalsTableModel = (DefaultTableModel) jTbl_Rental.getModel();
            selectedRowIndex = jTbl_Rental.getSelectedRow();
            Rental currentRentalInterface = new Rental();
            currentRentalInterface = currentRentalInterface.getCurrentInterface();
            currentRentalInterface.setVisible(true);
            currentRentalInterface.setCustomerID(RentalsTableModel.getValueAt(selectedRowIndex, 0).toString());
            currentRentalInterface.setCarID(RentalsTableModel.getValueAt(selectedRowIndex, 1).toString());
            Date pickupDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) RentalsTableModel.getValueAt(selectedRowIndex, 2));
            Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) RentalsTableModel.getValueAt(selectedRowIndex, 3));
            currentRentalInterface.setPickupDate((java.util.Date) pickupDate);
            currentRentalInterface.setReturnDate((java.util.Date) returnDate);
            currentRentalInterface.setRentalFee(RentalsTableModel.getValueAt(selectedRowIndex, 4).toString());
        } catch (ParseException ex) {
            Logger.getLogger(RentalTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTbl_RentalMouseClicked

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
            java.util.logging.Logger.getLogger(RentalTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editjTbl_Rental //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentalTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbl_Rental;
    // End of variables declaration//GEN-END:variables
}
