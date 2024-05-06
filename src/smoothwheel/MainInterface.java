/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainInterface extends javax.swing.JFrame {

    /**
     * Creates new form MainInterface
     */
    public MainInterface() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Wheel.png")));
    }

    private void hideMainInterface() {
        this.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jBtn_SignIn = new javax.swing.JButton();
        jBtn_AboutUs = new javax.swing.JButton();
        jLbl_Title = new javax.swing.JLabel();
        jLbl_MainBackground = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jBtn_Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smooth Wheel");
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1088, 590));
        jPanel1.setLayout(null);

        jBtn_SignIn.setBackground(new java.awt.Color(240, 225, 210));
        jBtn_SignIn.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jBtn_SignIn.setText("Sign In");
        jBtn_SignIn.setBorder(new javax.swing.border.MatteBorder(null));
        jBtn_SignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBtn_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SignInActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_SignIn);
        jBtn_SignIn.setBounds(530, 180, 200, 50);

        jBtn_AboutUs.setBackground(new java.awt.Color(240, 225, 210));
        jBtn_AboutUs.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_AboutUs.setText("About Us");
        jBtn_AboutUs.setBorder(null);
        jBtn_AboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AboutUsActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_AboutUs);
        jBtn_AboutUs.setBounds(530, 240, 200, 50);

        jLbl_Title.setBackground(new java.awt.Color(0, 0, 0, 1));
        jLbl_Title.setFont(new java.awt.Font("Edwardian Script ITC", 1, 110)); // NOI18N
        jLbl_Title.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Title.setText("Smooth Wheel  ");
        jLbl_Title.setOpaque(true);
        jPanel1.add(jLbl_Title);
        jLbl_Title.setBounds(0, 0, 590, 150);

        jLbl_MainBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_MainBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mix Of Lamborghinis.gif"))); // NOI18N
        jPanel1.add(jLbl_MainBackground);
        jLbl_MainBackground.setBounds(0, 0, 1330, 700);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 1330, 700));

        jLabel12.setFont(new java.awt.Font("Edwardian Script ITC", 1, 25)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("  Smooth Wheel  ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        jBtn_Close.setBackground(new java.awt.Color(255, 255, 255));
        jBtn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close.png"))); // NOI18N
        jBtn_Close.setBorder(null);
        jBtn_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtn_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtn_CloseMouseExited(evt);
            }
        });
        jPanel2.add(jBtn_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SignInActionPerformed
        new SignIN().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_SignInActionPerformed

    private void jBtn_AboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AboutUsActionPerformed
        new AboutUs().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_AboutUsActionPerformed

    private void jBtn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtn_CloseMouseClicked

    private void jBtn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseEntered
        jBtn_Close.setBackground(Color.RED);
    }//GEN-LAST:event_jBtn_CloseMouseEntered

    private void jBtn_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseExited
        jBtn_Close.setBackground(Color.white);
    }//GEN-LAST:event_jBtn_CloseMouseExited

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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainInterface mainInterface = new MainInterface();
                mainInterface.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_AboutUs;
    private javax.swing.JButton jBtn_Close;
    private javax.swing.JButton jBtn_SignIn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLbl_MainBackground;
    private javax.swing.JLabel jLbl_Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
