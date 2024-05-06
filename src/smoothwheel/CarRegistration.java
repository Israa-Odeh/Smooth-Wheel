/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.*;
import oracle.sql.*;

/**
 *
 * @author User
 */
public class CarRegistration extends javax.swing.JFrame {

    CarsTable carsTable;

    /**
     * Creates new form CarRegistration
     */
    public CarRegistration() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon();
        carsTable = new CarsTable();
        updateCarsTable();
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
            String query = "Select * from Car";
            ResultSet result = newStatement.executeQuery(query);

            DefaultTableModel carTableModel = (DefaultTableModel) carsTable.getTableName().getModel();
            carTableModel.setRowCount(0);
            while (result.next()) {
                Vector carVector = new Vector();

                carVector.add(result.getString("Car_ID"));
                carVector.add(result.getString("Manufacturer_Company"));
                carVector.add(result.getString("Model_Of_Car"));
                carVector.add(result.getString("Color"));
                carVector.add(result.getString("Engine_Power"));
                carVector.add(result.getString("Gear_Type"));
                carVector.add(result.getString("Fuel_Type"));
                carVector.add(result.getString("Fuel_Tank_Capacity"));
                carVector.add(result.getString("Number_Of_Seats"));
                carVector.add(result.getString("Rental_Fee_Per_Day"));

                carTableModel.addRow(carVector);
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
    }

    public CarRegistration getCurrentInterface() {
        return this;
    }

    public void setCarID(String carID) {
        this.jTxt_CarID.setText(carID);
    }

    public void setManufacturerCompany(String ManufacturerCompany) {
        this.jTxt_ManufacturerCompany.setText(ManufacturerCompany);
    }

    public void setModel(String model) {
        this.jTxt_Model.setText(model);
    }

    public void setColor(String color) {
        this.jComboBox_Color.setSelectedItem(color);
    }

    public void setEnginePower(String power) {
        this.jTxt_EnginePower.setText(power);
    }

    public void setGearType(String Gear) {
        this.jComboBox_Gear.setSelectedItem(Gear);
    }

    public void setFuelType(String Fuel) {
        this.jComboBox_FuelType.setSelectedItem(Fuel);
    }

    public void setTankCapacity(String Tank) {
        this.jComboBox_TankCapacity.setSelectedItem(Tank);
    }

    public void setSeatCapacity(String seat) {
        this.jComboBox_SeatCapacity.setSelectedItem(seat);
    }

    public void setRentalFeePerDay(String rental) {
        this.jTxt_RentalFee.setText(rental);
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
        jPanel2 = new javax.swing.JPanel();
        jLbl_FuelType = new javax.swing.JLabel();
        jComboBox_Gear = new javax.swing.JComboBox<>();
        jLbl_GearType = new javax.swing.JLabel();
        jComboBox_Color = new javax.swing.JComboBox<>();
        jLbl_Color = new javax.swing.JLabel();
        jTxt_ManufacturerCompany = new javax.swing.JTextField();
        jLbl_MaufCompany = new javax.swing.JLabel();
        jBtn_Search = new javax.swing.JButton();
        jLbl_CarID = new javax.swing.JLabel();
        jTxt_CarID = new javax.swing.JTextField();
        jLbl_Model = new javax.swing.JLabel();
        jTxt_Model = new javax.swing.JTextField();
        jLbl_EnginePower = new javax.swing.JLabel();
        jTxt_EnginePower = new javax.swing.JTextField();
        jComboBox_FuelType = new javax.swing.JComboBox<>();
        jLbl_SeatCapacity = new javax.swing.JLabel();
        jLbl_TankCapacity = new javax.swing.JLabel();
        jComboBox_TankCapacity = new javax.swing.JComboBox<>();
        jBtn_AddCar = new javax.swing.JButton();
        jBtn_Edit = new javax.swing.JButton();
        jBtn_Delete = new javax.swing.JButton();
        jBtn_ReturnBack = new javax.swing.JButton();
        jComboBox_SeatCapacity = new javax.swing.JComboBox<>();
        jTbtn_ShowCarsTable = new javax.swing.JToggleButton();
        jTxt_RentalFee = new javax.swing.JTextField();
        jLbl_RentalPerDay = new javax.swing.JLabel();
        jLbl_Background = new javax.swing.JLabel();
        jBtn_Close = new javax.swing.JButton();
        jLbl_Header = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smooth Wheel");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(null);

        jLbl_FuelType.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_FuelType.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_FuelType.setText("Fuel Type");
        jPanel2.add(jLbl_FuelType);
        jLbl_FuelType.setBounds(700, 90, 270, 40);

        jComboBox_Gear.setBackground(new java.awt.Color(175, 204, 233));
        jComboBox_Gear.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox_Gear.setForeground(new java.awt.Color(232, 226, 226));
        jComboBox_Gear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automatic" }));
        jComboBox_Gear.setOpaque(false);
        jPanel2.add(jComboBox_Gear);
        jComboBox_Gear.setBounds(360, 140, 270, 30);

        jLbl_GearType.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_GearType.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_GearType.setText("Gear Type ");
        jPanel2.add(jLbl_GearType);
        jLbl_GearType.setBounds(360, 96, 270, 36);

        jComboBox_Color.setBackground(new java.awt.Color(175, 204, 233));
        jComboBox_Color.setEditable(true);
        jComboBox_Color.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox_Color.setForeground(new java.awt.Color(232, 226, 226));
        jComboBox_Color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White", "Black", "Red", "Green", "Yellow", "Purple", "Pink", "Blue", "Gray", "Orange" }));
        jComboBox_Color.setOpaque(false);
        jPanel2.add(jComboBox_Color);
        jComboBox_Color.setBounds(700, 50, 270, 30);

        jLbl_Color.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_Color.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Color.setText("Color");
        jPanel2.add(jLbl_Color);
        jLbl_Color.setBounds(700, 10, 270, 36);

        jTxt_ManufacturerCompany.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_ManufacturerCompany.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTxt_ManufacturerCompany.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_ManufacturerCompany.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_ManufacturerCompany.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_ManufacturerCompany.setOpaque(false);
        jPanel2.add(jTxt_ManufacturerCompany);
        jTxt_ManufacturerCompany.setBounds(10, 140, 270, 30);

        jLbl_MaufCompany.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_MaufCompany.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_MaufCompany.setText("Manufacturer Company ");
        jPanel2.add(jLbl_MaufCompany);
        jLbl_MaufCompany.setBounds(10, 96, 270, 36);

        jBtn_Search.setBackground(new java.awt.Color(255, 255, 255));
        jBtn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jBtn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchActionPerformed(evt);
            }
        });
        jPanel2.add(jBtn_Search);
        jBtn_Search.setBounds(240, 40, 40, 40);

        jLbl_CarID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_CarID.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarID.setText("Car ID");
        jPanel2.add(jLbl_CarID);
        jLbl_CarID.setBounds(10, 10, 270, 36);

        jTxt_CarID.setBackground(new java.awt.Color(255, 255, 255, 0));
        jTxt_CarID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTxt_CarID.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_CarID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_CarID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_CarID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTxt_CarID.setOpaque(false);
        jPanel2.add(jTxt_CarID);
        jTxt_CarID.setBounds(10, 50, 230, 30);

        jLbl_Model.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_Model.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Model.setText("Model");
        jPanel2.add(jLbl_Model);
        jLbl_Model.setBounds(10, 190, 270, 40);

        jTxt_Model.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_Model.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTxt_Model.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_Model.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_Model.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_Model.setOpaque(false);
        jPanel2.add(jTxt_Model);
        jTxt_Model.setBounds(10, 230, 270, 30);

        jLbl_EnginePower.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_EnginePower.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_EnginePower.setText("Engine power ");
        jPanel2.add(jLbl_EnginePower);
        jLbl_EnginePower.setBounds(10, 270, 270, 36);

        jTxt_EnginePower.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_EnginePower.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTxt_EnginePower.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_EnginePower.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_EnginePower.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_EnginePower.setOpaque(false);
        jPanel2.add(jTxt_EnginePower);
        jTxt_EnginePower.setBounds(10, 310, 270, 30);

        jComboBox_FuelType.setBackground(new java.awt.Color(175, 204, 233));
        jComboBox_FuelType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox_FuelType.setForeground(new java.awt.Color(232, 226, 226));
        jComboBox_FuelType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasoline", "Diesel" }));
        jPanel2.add(jComboBox_FuelType);
        jComboBox_FuelType.setBounds(700, 140, 270, 30);

        jLbl_SeatCapacity.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_SeatCapacity.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_SeatCapacity.setText("Seat Capacity");
        jPanel2.add(jLbl_SeatCapacity);
        jLbl_SeatCapacity.setBounds(360, 10, 270, 36);

        jLbl_TankCapacity.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_TankCapacity.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_TankCapacity.setText("Fuel Tank Capacity");
        jPanel2.add(jLbl_TankCapacity);
        jLbl_TankCapacity.setBounds(700, 190, 270, 36);

        jComboBox_TankCapacity.setBackground(new java.awt.Color(175, 204, 233));
        jComboBox_TankCapacity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox_TankCapacity.setForeground(new java.awt.Color(232, 226, 226));
        jComboBox_TankCapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30", "40", "50", "60", "70", "80", "90", "100" }));
        jComboBox_TankCapacity.setOpaque(false);
        jPanel2.add(jComboBox_TankCapacity);
        jComboBox_TankCapacity.setBounds(700, 230, 270, 30);

        jBtn_AddCar.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_AddCar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_AddCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jBtn_AddCar.setBorder(null);
        jBtn_AddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AddCarActionPerformed(evt);
            }
        });
        jPanel2.add(jBtn_AddCar);
        jBtn_AddCar.setBounds(740, 550, 130, 80);

        jBtn_Edit.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_Edit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        jBtn_Edit.setBorder(null);
        jBtn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_EditActionPerformed(evt);
            }
        });
        jPanel2.add(jBtn_Edit);
        jBtn_Edit.setBounds(870, 550, 130, 80);

        jBtn_Delete.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_Delete.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jBtn_Delete.setBorder(null);
        jBtn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtn_Delete);
        jBtn_Delete.setBounds(1000, 550, 130, 80);

        jBtn_ReturnBack.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_ReturnBack.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_ReturnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Return Back.png"))); // NOI18N
        jBtn_ReturnBack.setBorder(null);
        jBtn_ReturnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ReturnBackActionPerformed(evt);
            }
        });
        jPanel2.add(jBtn_ReturnBack);
        jBtn_ReturnBack.setBounds(10, 550, 130, 80);

        jComboBox_SeatCapacity.setBackground(new java.awt.Color(175, 204, 233));
        jComboBox_SeatCapacity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox_SeatCapacity.setForeground(new java.awt.Color(232, 226, 226));
        jComboBox_SeatCapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "5", "6", "7", "8" }));
        jComboBox_SeatCapacity.setOpaque(false);
        jPanel2.add(jComboBox_SeatCapacity);
        jComboBox_SeatCapacity.setBounds(360, 50, 270, 30);

        jTbtn_ShowCarsTable.setBackground(new java.awt.Color(169, 166, 166));
        jTbtn_ShowCarsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Tables.png"))); // NOI18N
        jTbtn_ShowCarsTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTbtn_ShowCarsTableItemStateChanged(evt);
            }
        });
        jPanel2.add(jTbtn_ShowCarsTable);
        jTbtn_ShowCarsTable.setBounds(1130, 550, 130, 80);

        jTxt_RentalFee.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_RentalFee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTxt_RentalFee.setForeground(new java.awt.Color(232, 226, 226));
        jTxt_RentalFee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_RentalFee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_RentalFee.setOpaque(false);
        jPanel2.add(jTxt_RentalFee);
        jTxt_RentalFee.setBounds(360, 230, 270, 30);

        jLbl_RentalPerDay.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_RentalPerDay.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_RentalPerDay.setText("Rental Fee Per Day");
        jPanel2.add(jLbl_RentalPerDay);
        jLbl_RentalPerDay.setBounds(360, 190, 270, 36);

        jLbl_Background.setBackground(new java.awt.Color(157, 200, 243));
        jLbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainImage.jpg"))); // NOI18N
        jPanel2.add(jLbl_Background);
        jLbl_Background.setBounds(0, -60, 1330, 750);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, 1330, 690));

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
        jPanel1.add(jBtn_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 5, 40, 30));

        jLbl_Header.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLbl_Header.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_Header.setText("  Smooth Wheel  ");
        jPanel1.add(jLbl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtn_CloseMouseClicked

    private void jBtn_ReturnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ReturnBackActionPerformed
        new WelcomeInterface().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_ReturnBackActionPerformed

    private void jBtn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_DeleteActionPerformed
        if (jTxt_CarID.getText().equals("") || jTxt_Model.getText().equals("")
                || jTxt_EnginePower.getText().equals("")
                || jTxt_ManufacturerCompany.getText().equals("") || jTxt_RentalFee.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html>Please make sure to search about a specific car <br/> using the Car ID or simply select a specific row <br/> from the cars' table to delete.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                PreparedStatement deleteStatement = connection.prepareStatement("delete from Car where Car_ID = ?");
                String carID = this.jTxt_CarID.getText();
                deleteStatement.setString(1, carID);
                int isDeleted = deleteStatement.executeUpdate();
                if (isDeleted == 1) {
                    connection.commit();
                    jTxt_CarID.setText("");
                    jTxt_ManufacturerCompany.setText("");
                    jTxt_Model.setText("");
                    jTxt_EnginePower.setText("");
                    jTxt_RentalFee.setText("");
                    jComboBox_SeatCapacity.setSelectedItem("2");
                    jComboBox_Gear.setSelectedItem("Manual");
                    jComboBox_Color.setSelectedItem("White");
                    jComboBox_FuelType.setSelectedItem("Gasoline");
                    jComboBox_TankCapacity.setSelectedItem("30");
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("The car is successfully deleted.");
                    callTimer(success);
                    updateCarsTable();
                } else {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The selected car can't be deleted! <br/> Please try again.</html>");
                    callTimer(warning);
                }
                connection.close();
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText("The selected car is reserved! you can't delete it.");
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_DeleteActionPerformed

    private void jBtn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_EditActionPerformed
        if (jTxt_CarID.getText().equals("") || jTxt_Model.getText().equals("")
                || jTxt_EnginePower.getText().equals("")
                || jTxt_ManufacturerCompany.getText().equals("") || jTxt_RentalFee.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to search about a specific car <br/> by the Car ID or simply select a specific row <br/> from the cars' table to update.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                DefaultTableModel carsModel = (DefaultTableModel) carsTable.getTableName().getModel();
                int selectedRowIndex = carsTable.getTableName().getSelectedRow();
                PreparedStatement updateStatement = connection.prepareStatement("Update Car set Manufacturer_Company = ?, Model_Of_Car = ?, Color = ?, Engine_Power = ?, "
                        + "Gear_Type = ?, Fuel_Type = ?, Fuel_Tank_Capacity = ?, Number_Of_Seats = ?, Rental_Fee_Per_Day = ? where car_ID = ?");
                updateStatement.setString(1, jTxt_ManufacturerCompany.getText());
                updateStatement.setString(2, jTxt_Model.getText());
                updateStatement.setString(3, jComboBox_Color.getSelectedItem().toString());
                updateStatement.setString(4, jTxt_EnginePower.getText());
                updateStatement.setString(5, jComboBox_Gear.getSelectedItem().toString());
                updateStatement.setString(6, jComboBox_FuelType.getSelectedItem().toString());
                updateStatement.setString(7, jComboBox_TankCapacity.getSelectedItem().toString());
                updateStatement.setString(8, jComboBox_SeatCapacity.getSelectedItem().toString());
                updateStatement.setString(9, jTxt_RentalFee.getText());
                updateStatement.setString(10, jTxt_CarID.getText());

                int isUpdated = updateStatement.executeUpdate();
                if (isUpdated == 1) {
                    connection.commit();
                    jTxt_CarID.setText("");
                    jTxt_ManufacturerCompany.setText("");
                    jTxt_Model.setText("");
                    jTxt_EnginePower.setText("");
                    jTxt_RentalFee.setText("");
                    jComboBox_SeatCapacity.setSelectedItem("2");
                    jComboBox_Gear.setSelectedItem("Manual");
                    jComboBox_Color.setSelectedItem("White");
                    jComboBox_FuelType.setSelectedItem("Gasoline");
                    jComboBox_TankCapacity.setSelectedItem("30");
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("The car is successfully updated.");
                    callTimer(success);
                    updateCarsTable();
                } else {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The selected car can't be updated! <br/> Please try again.</html>");
                    callTimer(warning);
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

    private void jBtn_AddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AddCarActionPerformed

        if (jTxt_CarID.getText().equals("") || jTxt_Model.getText().equals("")
                || jTxt_EnginePower.getText().equals("")
                || jTxt_ManufacturerCompany.getText().equals("") || jTxt_RentalFee.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html>Please make sure to fill in all the required <br/> information about the car.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                Statement newstatement = connection.createStatement();
                String sqlString = "insert into Car values('" + this.jTxt_CarID.getText() + "', '" + this.jTxt_ManufacturerCompany.getText() + "',"
                        + " '" + this.jTxt_Model.getText() + "', '" + this.jComboBox_Color.getSelectedItem().toString() + "', "
                        + " " + this.jTxt_EnginePower.getText() + ", '" + this.jComboBox_Gear.getSelectedItem().toString() + "', "
                        + " '" + this.jComboBox_FuelType.getSelectedItem().toString() + "',"
                        + " " + this.jComboBox_TankCapacity.getSelectedItem().toString() + ","
                        + " " + this.jComboBox_SeatCapacity.getSelectedItem().toString() + ", "
                        + " " + this.jTxt_RentalFee.getText() + ")";
                int isAdded = newstatement.executeUpdate(sqlString);
                if (isAdded == 1) {
                    connection.commit();
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("<html> The car is successfully added.</html>");
                    callTimer(success);
                } else {
                    ErrorNotification error = new ErrorNotification();
                    error.setVisible(true);
                    error.setText("<html> The car can't be added! <br/> Please try again. <html>");
                    callTimer(error);
                }
                connection.close();

                String newRow[] = {this.jTxt_CarID.getText(), this.jTxt_ManufacturerCompany.getText(),
                    this.jTxt_Model.getText(), this.jComboBox_Color.getSelectedItem().toString(),
                    this.jTxt_EnginePower.getText(), this.jComboBox_Gear.getSelectedItem().toString(),
                    this.jComboBox_FuelType.getSelectedItem().toString(),
                    this.jComboBox_TankCapacity.getSelectedItem().toString(),
                    this.jComboBox_SeatCapacity.getSelectedItem().toString(),
                    this.jTxt_RentalFee.getText()};
                DefaultTableModel tableModel = (DefaultTableModel) carsTable.getTableName().getModel();
                tableModel.addRow(newRow);
                jTxt_CarID.setText("");
                jTxt_ManufacturerCompany.setText("");
                jTxt_Model.setText("");
                jTxt_EnginePower.setText("");
                jTxt_RentalFee.setText("");
                jComboBox_SeatCapacity.setSelectedItem("2");
                jComboBox_Gear.setSelectedItem("Manual");
                jComboBox_Color.setSelectedItem("White");
                jComboBox_FuelType.setSelectedItem("Gasoline");
                jComboBox_TankCapacity.setSelectedItem("30");
            } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
                ErrorNotification failed = new ErrorNotification();
                failed.setVisible(true);
                failed.setText("<html> There is an added car with this id! <br/> please use a unique car ID. </html>");
                callTimer(failed);
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText("Please make sure to enter vaild information!");
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_AddCarActionPerformed

    private void jBtn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseEntered
        jBtn_Close.setBackground(Color.red);
    }//GEN-LAST:event_jBtn_CloseMouseEntered

    private void jBtn_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseExited
        jBtn_Close.setBackground(Color.white);
    }//GEN-LAST:event_jBtn_CloseMouseExited

    private void jTbtn_ShowCarsTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTbtn_ShowCarsTableItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            carsTable.setVisible(true);
            jBtn_ReturnBack.setEnabled(false);
            jBtn_AddCar.setEnabled(false);
            jBtn_Edit.setEnabled(false);
            jBtn_Delete.setEnabled(false);
            jTbtn_ShowCarsTable.setBackground(Color.WHITE);
        } else {
            carsTable.setVisible(false);
            jTbtn_ShowCarsTable.setBackground(Color.LIGHT_GRAY);
            jBtn_ReturnBack.setEnabled(true);
            jBtn_AddCar.setEnabled(true);
            jBtn_Edit.setEnabled(true);
            jBtn_Delete.setEnabled(true);
        }
    }//GEN-LAST:event_jTbtn_ShowCarsTableItemStateChanged

    private void jBtn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchActionPerformed
        if (jTxt_CarID.getText().equals("") && jTxt_Model.getText().equals("")
                && jTxt_EnginePower.getText().equals("") && jTxt_ManufacturerCompany.getText().equals("")
                && jTxt_RentalFee.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to fill in the Car ID <br/> to search about a specific car. </html>");
            callTimer(warning);
        } else if (!jTxt_CarID.getText().equals("") && jTxt_Model.getText().equals("")
                && jTxt_EnginePower.getText().equals("") && jTxt_ManufacturerCompany.getText().equals("")
                && jTxt_RentalFee.getText().equals("")) {
            Connection connection = prepareDrivers();
            try {
                PreparedStatement queryStatement = connection.prepareStatement("Select * from Car where Car_ID = ?");
                String carID = this.jTxt_CarID.getText();
                queryStatement.setString(1, carID);
                ResultSet result = queryStatement.executeQuery();
                if (result.next()) {
                    String carRowDetails[] = {result.getString("Car_ID"), result.getString("Manufacturer_Company"), result.getString("Model_Of_Car"),
                        result.getString("Color"), result.getString("Engine_Power"), result.getString("Gear_Type"), result.getString("Fuel_Type"),
                        result.getString("Fuel_Tank_Capacity"), result.getString("Number_Of_Seats"), result.getString("Rental_Fee_Per_Day")};
                    connection.commit();
                    jTxt_CarID.setText(carRowDetails[0]);
                    jTxt_ManufacturerCompany.setText(carRowDetails[1]);
                    jTxt_Model.setText(carRowDetails[2]);
                    jComboBox_Color.setSelectedItem(carRowDetails[3]);
                    jTxt_EnginePower.setText(carRowDetails[4]);
                    jComboBox_Gear.setSelectedItem(carRowDetails[5]);
                    jComboBox_FuelType.setSelectedItem(carRowDetails[6]);
                    jComboBox_TankCapacity.setSelectedItem(carRowDetails[7]);
                    jComboBox_SeatCapacity.setSelectedItem(carRowDetails[8]);
                    jTxt_RentalFee.setText(carRowDetails[9]);
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("The required car is successfully found.");
                    callTimer(success);
                } else {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The Car ID you have entered doesn't belong to <br/> any stored car! please try again with a valid <br/> Car ID.</html>");
                    callTimer(warning);
                }
                connection.close();
            } catch (SQLException ex) {
                WarningNotification warning = new WarningNotification();
                warning.setVisible(true);
                warning.setText(ex.toString());
                callTimer(warning);
            }
        } else {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to search using the Car ID only! </html>");
            callTimer(warning);
        }
    }//GEN-LAST:event_jBtn_SearchActionPerformed

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
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_AddCar;
    private javax.swing.JButton jBtn_Close;
    private javax.swing.JButton jBtn_Delete;
    private javax.swing.JButton jBtn_Edit;
    private javax.swing.JButton jBtn_ReturnBack;
    private javax.swing.JButton jBtn_Search;
    private javax.swing.JComboBox<String> jComboBox_Color;
    private javax.swing.JComboBox<String> jComboBox_FuelType;
    private javax.swing.JComboBox<String> jComboBox_Gear;
    private javax.swing.JComboBox<String> jComboBox_SeatCapacity;
    private javax.swing.JComboBox<String> jComboBox_TankCapacity;
    private javax.swing.JLabel jLbl_Background;
    private javax.swing.JLabel jLbl_CarID;
    private javax.swing.JLabel jLbl_Color;
    private javax.swing.JLabel jLbl_EnginePower;
    private javax.swing.JLabel jLbl_FuelType;
    private javax.swing.JLabel jLbl_GearType;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_MaufCompany;
    private javax.swing.JLabel jLbl_Model;
    private javax.swing.JLabel jLbl_RentalPerDay;
    private javax.swing.JLabel jLbl_SeatCapacity;
    private javax.swing.JLabel jLbl_TankCapacity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jTbtn_ShowCarsTable;
    private javax.swing.JTextField jTxt_CarID;
    private javax.swing.JTextField jTxt_EnginePower;
    private javax.swing.JTextField jTxt_ManufacturerCompany;
    private javax.swing.JTextField jTxt_Model;
    private javax.swing.JTextField jTxt_RentalFee;
    // End of variables declaration//GEN-END:variables
}
