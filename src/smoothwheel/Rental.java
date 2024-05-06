/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import oracle.jdbc.*;
import oracle.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Rental extends javax.swing.JFrame {

    RentalTable rentalsTable;

    /**
     * Creates new form Rental
     */
    public Rental() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon();
        jDateChooser_Pickup.setDateFormatString("yyyy-MM-dd");
        jDateChooser_Return.setDateFormatString("yyyy-MM-dd");
        rentalsTable = new RentalTable();
        updateCarsTable();
        loadCarID();
        loadCustomerID();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Wheel.png")));
    }

    private void callTimer(JFrame notification) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                notification.setVisible(false);
            }
        }, 6000);
    }

    private Connection prepareDrivers() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String url, username, password;
            url = "jdbc:oracle:thin:@localhost:1521:xe";
            username = "c##IsraaOdeh";
            password = "IsraaOdeh5";
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
        return connection;
    }

    private void updateCarsTable() {
        try {
            Connection connection = prepareDrivers();
            Statement newStatement = connection.createStatement();
            String query = "Select * from Rents_A";
            ResultSet result = newStatement.executeQuery(query);
            DefaultTableModel rentalsTableModel = (DefaultTableModel) rentalsTable.getTableName().getModel();
            rentalsTableModel.setRowCount(0);
            while (result.next()) {
                Vector rentalsVector = new Vector();
                rentalsVector.add(result.getString("Customer_ID"));
                rentalsVector.add(result.getString("Car_ID"));
                rentalsVector.add(result.getString("Pickup_Date").substring(0, 10));
                rentalsVector.add(result.getString("Return_Date").substring(0, 10));
                rentalsVector.add(result.getString("Rental_Fee"));
                rentalsTableModel.addRow(rentalsVector);
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
    }

    public Rental getCurrentInterface() {
        return this;
    }

    public void loadCarID() {
        Connection connection = prepareDrivers();
        try {
            PreparedStatement loadcarID = connection.prepareStatement("Select Car_ID from Car");
            ResultSet queryResult = loadcarID.executeQuery();
            jComboBox_CarID.removeAllItems();
            while (queryResult.next()) {
                jComboBox_CarID.addItem(queryResult.getString(1));
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
    }

    public void loadCustomerID() {
        Connection connection = prepareDrivers();
        try {
            PreparedStatement loadCustomerID = connection.prepareStatement("Select Customer_ID from Customer");
            ResultSet queryResult = loadCustomerID.executeQuery();
            jComboBox_CustomerID.removeAllItems();
            while (queryResult.next()) {
                jComboBox_CustomerID.addItem(queryResult.getString(1));
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
    }

    public int daysBetween(java.util.Date date1, java.util.Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public void setCustomerID(String customerID) {
        this.jComboBox_CustomerID.setSelectedItem(customerID);
    }

    public void setCarID(String carID) {
        this.jComboBox_CarID.setSelectedItem(carID);
    }

    public void setPickupDate(java.util.Date pickupDate) {
        this.jDateChooser_Pickup.setDate(pickupDate);
    }

    public void setReturnDate(java.util.Date returnDate) {
        this.jDateChooser_Return.setDate(returnDate);
    }

    public void setRentalFee(String RentalFee) {
        this.jTxt_RentalFee.setText(RentalFee);
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
        jComboBox_CarID = new javax.swing.JComboBox<>();
        jLbl_CarID = new javax.swing.JLabel();
        jLbl_CustomerID = new javax.swing.JLabel();
        jLbl_PickupDate = new javax.swing.JLabel();
        jDateChooser_Pickup = new com.toedter.calendar.JDateChooser();
        jLbl_RentalFee = new javax.swing.JLabel();
        jTxt_RentalFee = new javax.swing.JTextField();
        jLbl_ReturnDate = new javax.swing.JLabel();
        jDateChooser_Return = new com.toedter.calendar.JDateChooser();
        jComboBox_CustomerID = new javax.swing.JComboBox<>();
        jBtn_Calculate = new javax.swing.JButton();
        jBtn_Search = new javax.swing.JButton();
        jBtn_ReturnBack = new javax.swing.JButton();
        jBtn_Add = new javax.swing.JButton();
        jBtn_Edit = new javax.swing.JButton();
        jBtn_Delete = new javax.swing.JButton();
        jTbtn_ShowTable = new javax.swing.JToggleButton();
        jLbl_Background = new javax.swing.JLabel();
        jLbl_Header = new javax.swing.JLabel();
        jBtn_Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smooth Wheel");
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jComboBox_CarID.setBackground(new java.awt.Color(153, 153, 153, 5));
        jComboBox_CarID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_CarID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        jPanel1.add(jComboBox_CarID);
        jComboBox_CarID.setBounds(50, 200, 270, 30);

        jLbl_CarID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_CarID.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_CarID.setText("Car ID");
        jPanel1.add(jLbl_CarID);
        jLbl_CarID.setBounds(50, 160, 270, 36);

        jLbl_CustomerID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_CustomerID.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CustomerID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_CustomerID.setText("Customer ID");
        jPanel1.add(jLbl_CustomerID);
        jLbl_CustomerID.setBounds(50, 30, 270, 36);

        jLbl_PickupDate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_PickupDate.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_PickupDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_PickupDate.setText("Pickup Date");
        jPanel1.add(jLbl_PickupDate);
        jLbl_PickupDate.setBounds(400, 30, 270, 36);

        jDateChooser_Pickup.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jDateChooser_Pickup);
        jDateChooser_Pickup.setBounds(400, 70, 270, 30);

        jLbl_RentalFee.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_RentalFee.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_RentalFee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_RentalFee.setText("Rental Fee");
        jPanel1.add(jLbl_RentalFee);
        jLbl_RentalFee.setBounds(50, 300, 270, 36);

        jTxt_RentalFee.setEditable(false);
        jTxt_RentalFee.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_RentalFee.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTxt_RentalFee.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_RentalFee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_RentalFee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jTxt_RentalFee);
        jTxt_RentalFee.setBounds(50, 340, 270, 34);

        jLbl_ReturnDate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_ReturnDate.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_ReturnDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_ReturnDate.setText("Return Date");
        jPanel1.add(jLbl_ReturnDate);
        jLbl_ReturnDate.setBounds(400, 160, 270, 36);

        jDateChooser_Return.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jDateChooser_Return);
        jDateChooser_Return.setBounds(400, 200, 270, 30);

        jComboBox_CustomerID.setBackground(new java.awt.Color(153, 153, 153, 5));
        jComboBox_CustomerID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jComboBox_CustomerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2" }));
        jPanel1.add(jComboBox_CustomerID);
        jComboBox_CustomerID.setBounds(50, 70, 270, 30);

        jBtn_Calculate.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Calculate.setFont(new java.awt.Font("Segoe Script", 1, 16)); // NOI18N
        jBtn_Calculate.setText("Check and Calculate");
        jBtn_Calculate.setFocusPainted(false);
        jBtn_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_CalculateActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Calculate);
        jBtn_Calculate.setBounds(50, 380, 270, 40);

        jBtn_Search.setBackground(new java.awt.Color(255, 255, 255));
        jBtn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jBtn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Search);
        jBtn_Search.setBounds(320, 60, 40, 40);

        jBtn_ReturnBack.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_ReturnBack.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_ReturnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Return Back.png"))); // NOI18N
        jBtn_ReturnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ReturnBackActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_ReturnBack);
        jBtn_ReturnBack.setBounds(20, 550, 130, 80);

        jBtn_Add.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_Add.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jBtn_Add.setBorder(null);
        jBtn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AddActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Add);
        jBtn_Add.setBounds(690, 550, 130, 80);

        jBtn_Edit.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_Edit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        jBtn_Edit.setBorder(null);
        jBtn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_EditActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Edit);
        jBtn_Edit.setBounds(820, 550, 130, 80);

        jBtn_Delete.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_Delete.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jBtn_Delete.setBorder(null);
        jBtn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Delete);
        jBtn_Delete.setBounds(950, 550, 130, 80);

        jTbtn_ShowTable.setBackground(new java.awt.Color(169, 166, 166));
        jTbtn_ShowTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Tables.png"))); // NOI18N
        jTbtn_ShowTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTbtn_ShowTableItemStateChanged(evt);
            }
        });
        jPanel1.add(jTbtn_ShowTable);
        jTbtn_ShowTable.setBounds(1080, 550, 130, 80);

        jLbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainImage.jpg"))); // NOI18N
        jPanel1.add(jLbl_Background);
        jLbl_Background.setBounds(0, -60, 1350, 750);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 1350, 690));

        jLbl_Header.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLbl_Header.setText("Smooth Wheel ");
        jPanel2.add(jLbl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));

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
        jPanel2.add(jBtn_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 5, 40, 30));

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

    private void jBtn_ReturnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ReturnBackActionPerformed
        new WelcomeInterface().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_ReturnBackActionPerformed

    private void jBtn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AddActionPerformed
        if (jDateChooser_Pickup.getDate() == null || jDateChooser_Return.getDate() == null
                || jTxt_RentalFee.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to fill in all the required <br/> information to rent a car.</html>");
            callTimer(warning);
        } else if (jComboBox_CarID.getSelectedItem() == null) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> All the cars in your rental company are rented! <br/> Please add new cars or wait until customers <br/>"
                    + "return the rented cars.</html>");
            callTimer(warning);
        } else {
            String carID = this.jComboBox_CarID.getSelectedItem().toString();
            Date pickup = new Date(this.jDateChooser_Pickup.getDate().getTime());
            Date Return = new Date(this.jDateChooser_Return.getDate().getTime());

            Connection connection = prepareDrivers();
            try {
                PreparedStatement checkCarID = connection.prepareStatement("Select Car_ID from Rents_A where Car_ID = ?");
                checkCarID.setString(1, carID);
                ResultSet checkResult = checkCarID.executeQuery();
                boolean found = checkResult.next();
                if (found == true) {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The Car with the selected ID is rented! <br/> you can't rent it again.</html>");
                    callTimer(warning);
                } else {
                    PreparedStatement newstatement = connection.prepareStatement("insert into Rents_A (Customer_ID, Car_ID, Pickup_Date, Return_Date, Rental_Fee) values(?, ?, ?, ?, ?)");
                    newstatement.setString(1, jComboBox_CustomerID.getSelectedItem().toString());
                    newstatement.setString(2, jComboBox_CarID.getSelectedItem().toString());
                    newstatement.setDate(3, pickup);
                    newstatement.setDate(4, Return);
                    newstatement.setString(5, jTxt_RentalFee.getText());
                    int isRented = newstatement.executeUpdate();
                    if (isRented == 1) {
                        connection.commit();
                        SuccessNotification success = new SuccessNotification();
                        success.setVisible(true);
                        success.setText("<html> The car is successfully rented.</html>");
                        callTimer(success);
                    } else {
                        ErrorNotification error = new ErrorNotification();
                        error.setVisible(true);
                        error.setText("<html> The car can't be rented! <br/> Please try again. <html>");
                        callTimer(error);
                    }
                    String newRow[] = {this.jComboBox_CustomerID.getSelectedItem().toString(), carID,
                        pickup.toString().substring(0, 10), Return.toString().substring(0, 10), this.jTxt_RentalFee.getText()};
                    DefaultTableModel rentalsTableModel = (DefaultTableModel) rentalsTable.getTableName().getModel();
                    rentalsTableModel.addRow(newRow);
                    jComboBox_CarID.setSelectedIndex(0);
                    jComboBox_CustomerID.setSelectedIndex(0);
                    jDateChooser_Pickup.setDate(null);
                    jDateChooser_Return.setDate(null);
                    jTxt_RentalFee.setText("");
                }
                connection.close();
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText("Please make sure to enter valid information!");
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_AddActionPerformed

    private void jBtn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_EditActionPerformed
        if (jDateChooser_Pickup.getDate() == null || jDateChooser_Return.getDate() == null
                || jTxt_RentalFee.getText().equals("")) {
            SpecialErrorNotification warning = new SpecialErrorNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to search about a specific <br/> rented car by the Car ID and the customer ID "
                    + "<br/> together or simply select a specific row <br/> from the cars' table to update.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                String carID = this.jComboBox_CarID.getSelectedItem().toString();
                String customerID = this.jComboBox_CustomerID.getSelectedItem().toString();
                PreparedStatement checkIDs = connection.prepareStatement("Select Car_ID from Rents_A where Car_ID = ? and Customer_ID = ?");
                checkIDs.setString(1, carID);
                checkIDs.setString(2, customerID);
                ResultSet checkResult = checkIDs.executeQuery();
                boolean found = checkResult.next();
                if (found == false) {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The Car with the selected ID isn't rented yet! <br/> you can't update it.</html>");
                    callTimer(warning);
                } else {
                    DefaultTableModel rentalsModel = (DefaultTableModel) rentalsTable.getTableName().getModel();
                    int selectedRowIndex = rentalsTable.getTableName().getSelectedRow();
                    PreparedStatement updateStatement = connection.prepareStatement("Update Rents_A set PICKUP_DATE = ?, "
                            + "RETURN_DATE = ?, RENTAL_FEE = ? where CUSTOMER_ID = ? and CAR_ID = ?");

                    Date pickupDate = new Date(this.jDateChooser_Pickup.getDate().getTime());
                    Date returnDate = new Date(this.jDateChooser_Return.getDate().getTime());

                    updateStatement.setDate(1, pickupDate);
                    updateStatement.setDate(2, returnDate);
                    updateStatement.setString(3, jTxt_RentalFee.getText());
                    updateStatement.setString(4, jComboBox_CustomerID.getSelectedItem().toString());
                    updateStatement.setString(5, jComboBox_CarID.getSelectedItem().toString());

                    int isUpdated = updateStatement.executeUpdate();
                    if (isUpdated == 1) {
                        connection.commit();
                        jComboBox_CarID.setSelectedIndex(0);
                        jComboBox_CustomerID.setSelectedIndex(0);
                        jDateChooser_Pickup.setDate(null);
                        jDateChooser_Return.setDate(null);
                        jTxt_RentalFee.setText("");
                        SuccessNotification success = new SuccessNotification();
                        success.setVisible(true);
                        success.setText("The rented car is successfully updated.");
                        callTimer(success);
                        updateCarsTable();
                    } else {
                        WarningNotification warning = new WarningNotification();
                        warning.setVisible(true);
                        warning.setText("<html> The selected rented car can't be updated! <br/> Please try again.</html>");
                        callTimer(warning);
                    }
                }
                connection.close();
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText("Please make sure to enter valid information!");
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_EditActionPerformed

    private void jBtn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_DeleteActionPerformed
        if (jDateChooser_Pickup.getDate() == null || jDateChooser_Return.getDate() == null
                || jTxt_RentalFee.getText().equals("")) {
            SpecialErrorNotification warning = new SpecialErrorNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to search about a specific <br/> rented car by the Car ID and the customer ID "
                    + "<br/> together or simply select a specific row <br/> from the cars' table to update.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                String carID = this.jComboBox_CarID.getSelectedItem().toString();
                String customerID = this.jComboBox_CustomerID.getSelectedItem().toString();
                PreparedStatement checkIDs = connection.prepareStatement("Select Car_ID from Rents_A where Car_ID = ? and Customer_ID = ?");
                checkIDs.setString(1, carID);
                checkIDs.setString(2, customerID);
                ResultSet checkResult = checkIDs.executeQuery();
                boolean found = checkResult.next();
                if (found == false) {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The Car with the selected ID isn't rented yet! <br/> you can't delete it.</html>");
                    callTimer(warning);
                } else {
                    PreparedStatement deleteStatement = connection.prepareStatement("delete from Rents_A where Car_ID = ? and Customer_ID = ?");
                    deleteStatement.setString(1, carID);
                    deleteStatement.setString(2, customerID);
                    int isDeleted = deleteStatement.executeUpdate();
                    if (isDeleted == 1) {
                        connection.commit();
                        jComboBox_CarID.setSelectedIndex(0);
                        jComboBox_CustomerID.setSelectedIndex(0);
                        jDateChooser_Pickup.setDate(null);
                        jDateChooser_Return.setDate(null);
                        jTxt_RentalFee.setText("");
                        SuccessNotification success = new SuccessNotification();
                        success.setVisible(true);
                        success.setText("The rented car is successfully deleted.");
                        callTimer(success);
                        updateCarsTable();
                    } else {
                        WarningNotification warning = new WarningNotification();
                        warning.setVisible(true);
                        warning.setText("<html> The selected rented car can't be deleted! <br/> Please try again.</html>");
                        callTimer(warning);
                    }
                }
                connection.close();
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText(ex.toString());
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_DeleteActionPerformed

    private void jBtn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtn_CloseMouseClicked

    private void jBtn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseEntered
        jBtn_Close.setBackground(Color.red);
    }//GEN-LAST:event_jBtn_CloseMouseEntered

    private void jBtn_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseExited
        jBtn_Close.setBackground(Color.white);
    }//GEN-LAST:event_jBtn_CloseMouseExited

    private void jTbtn_ShowTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTbtn_ShowTableItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rentalsTable.setVisible(true);
            jBtn_ReturnBack.setEnabled(false);
            jBtn_Add.setEnabled(false);
            jBtn_Edit.setEnabled(false);
            jBtn_Delete.setEnabled(false);
            jTbtn_ShowTable.setBackground(Color.WHITE);
        } else {
            rentalsTable.setVisible(false);
            jBtn_ReturnBack.setEnabled(true);
            jBtn_Add.setEnabled(true);
            jBtn_Edit.setEnabled(true);
            jBtn_Delete.setEnabled(true);
            jTbtn_ShowTable.setBackground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_jTbtn_ShowTableItemStateChanged

    private void jBtn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchActionPerformed

        Connection connection = prepareDrivers();
        try {
            String carID = this.jComboBox_CarID.getSelectedItem().toString();
            String customerID = this.jComboBox_CustomerID.getSelectedItem().toString();
            PreparedStatement queryStatement = connection.prepareStatement("Select * from Rents_A where Car_ID = ? and Customer_ID = ?");
            queryStatement.setString(1, carID);
            queryStatement.setString(2, customerID);
            ResultSet result = queryStatement.executeQuery();
            if (result.next()) {
                String rentalRowDetails[] = {result.getString("Customer_ID"), result.getString("Car_ID"), result.getString("RENTAL_FEE")};
                Date pickupDate = new Date(result.getDate("PICKUP_DATE").getTime());
                Date returnDate = new Date(result.getDate("RETURN_DATE").getTime());
                connection.commit();
                jComboBox_CustomerID.setSelectedItem(rentalRowDetails[0]);
                jComboBox_CarID.setSelectedItem(rentalRowDetails[1]);
                jTxt_RentalFee.setText(rentalRowDetails[2]);
                jDateChooser_Pickup.setDate(pickupDate);
                jDateChooser_Return.setDate(returnDate);
                SuccessNotification success = new SuccessNotification();
                success.setVisible(true);
                success.setText("The required rented car is successfully found.");
                callTimer(success);
            } else {
                WarningNotification warning = new WarningNotification();
                warning.setVisible(true);
                warning.setText("<html> The Car with the selected IDs isn't <br/> rented yet! you can't serach about it.</html>");
                callTimer(warning);
            }
            connection.close();
        } catch (SQLException ex) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText(ex.toString());
            callTimer(warning);
        }
    }//GEN-LAST:event_jBtn_SearchActionPerformed

    private void jBtn_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_CalculateActionPerformed
        String carID = this.jComboBox_CarID.getSelectedItem().toString();
        Connection connection = prepareDrivers();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("Select Rental_Fee_Per_Day from Car where Car_ID = ?");
            queryStatement.setString(1, carID);
            ResultSet result = queryStatement.executeQuery();
            if (result.next()) {
                connection.commit();
                String RentalFeePerDay = result.getString("Rental_Fee_Per_Day");
                int days = daysBetween(this.jDateChooser_Pickup.getDate(), this.jDateChooser_Return.getDate());
                if (days == 0) {
                    this.jTxt_RentalFee.setText(Integer.toString(Integer.parseInt(RentalFeePerDay)));
                } else {
                    int totalRentalFee = days * Integer.parseInt(RentalFeePerDay);
                    this.jTxt_RentalFee.setText(Integer.toString(totalRentalFee));
                }
            } else {
                WarningNotification warning = new WarningNotification();
                warning.setVisible(true);
                warning.setText("<html> The selected car isn't registered yet!</html>");
                callTimer(warning);
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
    }//GEN-LAST:event_jBtn_CalculateActionPerformed

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
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Add;
    private javax.swing.JButton jBtn_Calculate;
    private javax.swing.JButton jBtn_Close;
    private javax.swing.JButton jBtn_Delete;
    private javax.swing.JButton jBtn_Edit;
    private javax.swing.JButton jBtn_ReturnBack;
    private javax.swing.JButton jBtn_Search;
    private javax.swing.JComboBox<String> jComboBox_CarID;
    private javax.swing.JComboBox<String> jComboBox_CustomerID;
    private com.toedter.calendar.JDateChooser jDateChooser_Pickup;
    private com.toedter.calendar.JDateChooser jDateChooser_Return;
    private javax.swing.JLabel jLbl_Background;
    private javax.swing.JLabel jLbl_CarID;
    private javax.swing.JLabel jLbl_CustomerID;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_PickupDate;
    private javax.swing.JLabel jLbl_RentalFee;
    private javax.swing.JLabel jLbl_ReturnDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jTbtn_ShowTable;
    private javax.swing.JTextField jTxt_RentalFee;
    // End of variables declaration//GEN-END:variables
}
