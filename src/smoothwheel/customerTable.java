/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALFALAK
 */
public class customerTable extends javax.swing.JFrame {

    /**
     * Creates new form customerTable
     */
    public customerTable() {
        initComponents();
        customer_tableee.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        customer_tableee.getTableHeader().setOpaque(false);
        customer_tableee.setRowHeight(25);
        jScrollPane1.getViewport().setBackground(new Color(237,228,213));

    }

    public JTable getTableName() {
        return customer_tableee;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customer_tableee = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customer_tableee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUSTOMER ID", "FIRST NAME", "MIDDLE NAME", "LAST NAME", "LICENSE ID", "PHONE NUMBER", "   CITY", "EMPLOYEE ID"
            }
        ));
        customer_tableee.setFocusable(false);
        customer_tableee.setIntercellSpacing(new java.awt.Dimension(0, 0));
        customer_tableee.setMinimumSize(new java.awt.Dimension(120, 625));
        customer_tableee.setOpaque(false);
        customer_tableee.setPreferredSize(new java.awt.Dimension(600, 625));
        customer_tableee.setSelectionForeground(new java.awt.Color(72, 87, 128));
        customer_tableee.setShowGrid(true);
        customer_tableee.setShowHorizontalLines(false);
        customer_tableee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tableeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customer_tableee);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 47, 1280, 510));

        jLabel2.setBackground(new java.awt.Color(237, 228, 213));
        jLabel2.setFont(new java.awt.Font("Edwardian Script ITC", 1, 40)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N
        jLabel2.setText("Smooth Wheel  ");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private int selectedRowIndex;


    private void customer_tableeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tableeeMouseClicked
        DefaultTableModel carsTableModel = (DefaultTableModel) customer_tableee.getModel();
        selectedRowIndex = customer_tableee.getSelectedRow();
        CustomerRegistration CustomerRegistration0 = new CustomerRegistration();
        CustomerRegistration0 = CustomerRegistration0.getCurrentInterface();

        CustomerRegistration0.setVisible(true);
        CustomerRegistration0.cusID(carsTableModel.getValueAt(selectedRowIndex, 0).toString());
        CustomerRegistration0.fname(carsTableModel.getValueAt(selectedRowIndex, 1).toString());
        CustomerRegistration0.mname(carsTableModel.getValueAt(selectedRowIndex, 2).toString());
        CustomerRegistration0.lname(carsTableModel.getValueAt(selectedRowIndex, 3).toString());
        CustomerRegistration0.LicenseID(carsTableModel.getValueAt(selectedRowIndex, 4).toString());
        CustomerRegistration0.Phone(carsTableModel.getValueAt(selectedRowIndex, 5).toString());
        CustomerRegistration0.CITY(carsTableModel.getValueAt(selectedRowIndex, 6).toString());
        CustomerRegistration0.empid(carsTableModel.getValueAt(selectedRowIndex, 7).toString());


    }//GEN-LAST:event_customer_tableeeMouseClicked

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
            java.util.logging.Logger.getLogger(customerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customer_tableee;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
