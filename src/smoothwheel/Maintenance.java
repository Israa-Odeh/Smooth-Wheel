/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoothwheel;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.*;
import oracle.sql.*;

/**
 *
 * @author User
 */
public class Maintenance extends javax.swing.JFrame {

    MaintenanceTable maintenanceTable;

    /**
     * Creates new form Maintenance
     */
    public Maintenance() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon();
        maintenanceTable = new MaintenanceTable();
        loadCarID();
        updateMaintenanceTable();
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

    public void setMaintenanceID(String mainID) {
        this.jTxt_MaintenanceID.setText(mainID);
    }

    public void setCarID(String carID) {
        this.jComboBox_CarID.setSelectedItem(carID);
    }

    public Maintenance getCurrentInterface() {
        return this;
    }

    private void updateMaintenanceTable() {
        try {
            Connection connection = prepareDrivers();
            Statement newStatement = connection.createStatement();
            String query1 = "Select * from Maintenance";
            ResultSet result = newStatement.executeQuery(query1);
            DefaultTableModel maintenanceTableModel = (DefaultTableModel) maintenanceTable.getTableName().getModel();
            maintenanceTableModel.setRowCount(0);
            while (result.next()) {
                Vector maintenanceVector = new Vector();
                maintenanceVector.add(result.getString("MAINTENANCE_ID"));
                maintenanceVector.add(result.getString("CAR_ID"));
                maintenanceTableModel.addRow(maintenanceVector);
            }
        } catch (SQLException ex) {
            ErrorNotification error = new ErrorNotification();
            error.setVisible(true);
            error.setText(ex.toString());
            callTimer(error);
        }
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

    private boolean checkAffectedPart() {
        boolean checkFlag;
        if (jRbtn_Mirrors.isSelected() || jRbtn_LicensePlate.isSelected() || jRbtn_WheelCover.isSelected() || jRbtn_DoorHandle.isSelected()
                || jRbtn_HeadLamps.isSelected() || jRbtn_TailLights.isSelected() || jRbtn_Roof.isSelected() || jRbtn_Grille.isSelected()
                || jRbtn_Bumper.isSelected() || jRbtn_Windows.isSelected() || jRbtn_Wipers.isSelected() || jRbtn_Doors.isSelected()) {
            checkFlag = true;
            return checkFlag;
        } else {
            checkFlag = false;
            return checkFlag;
        }
    }

    private boolean checkMinorMaintenance() {
        boolean minorFlag;
        if (jRbtn_tires.isSelected() || jRbtn_EnginePerformance.isSelected() || jRbtn_OilFilters.isSelected() || jRbtn_WiperBlades.isSelected()
                || jRbtn_Fluids.isSelected() || jRbtn_SeatBelts.isSelected() || jRbtn_Lights.isSelected() || jRbtn_AirFilters.isSelected()
                || jRbtn_WashCar.isSelected() || jRbtn_CoolingSystem.isSelected() || jRbtn_Brakes.isSelected() || jRbtn_Battery.isSelected()) {
            minorFlag = true;
            return minorFlag;
        } else {
            minorFlag = false;
            return minorFlag;
        }
    }

    private void clearCheckBoxes() {
        jRbtn_tires.setSelected(false);
        jRbtn_EnginePerformance.setSelected(false);
        jRbtn_OilFilters.setSelected(false);
        jRbtn_WiperBlades.setSelected(false);
        jRbtn_Fluids.setSelected(false);
        jRbtn_SeatBelts.setSelected(false);
        jRbtn_Lights.setSelected(false);
        jRbtn_AirFilters.setSelected(false);
        jRbtn_WashCar.setSelected(false);
        jRbtn_CoolingSystem.setSelected(false);
        jRbtn_Brakes.setSelected(false);
        jRbtn_Battery.setSelected(false);

        jRbtn_Mirrors.setSelected(false);
        jRbtn_LicensePlate.setSelected(false);
        jRbtn_WheelCover.setSelected(false);
        jRbtn_DoorHandle.setSelected(false);
        jRbtn_HeadLamps.setSelected(false);
        jRbtn_TailLights.setSelected(false);
        jRbtn_Roof.setSelected(false);
        jRbtn_Grille.setSelected(false);
        jRbtn_Bumper.setSelected(false);
        jRbtn_Windows.setSelected(false);
        jRbtn_Wipers.setSelected(false);
        jRbtn_Doors.setSelected(false);
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
        jLbl_AffectedParts = new javax.swing.JLabel();
        jRbtn_Mirrors = new javax.swing.JRadioButton();
        jRbtn_WheelCover = new javax.swing.JRadioButton();
        jRbtn_DoorHandle = new javax.swing.JRadioButton();
        jRbtn_HeadLamps = new javax.swing.JRadioButton();
        jRbtn_LicensePlate = new javax.swing.JRadioButton();
        jRbtn_TailLights = new javax.swing.JRadioButton();
        jRbtn_Roof = new javax.swing.JRadioButton();
        jRbtn_Grille = new javax.swing.JRadioButton();
        jRbtn_Bumper = new javax.swing.JRadioButton();
        jRbtn_Windows = new javax.swing.JRadioButton();
        jRbtn_Wipers = new javax.swing.JRadioButton();
        jRbtn_Doors = new javax.swing.JRadioButton();
        jRbtn_tires = new javax.swing.JRadioButton();
        jRbtn_OilFilters = new javax.swing.JRadioButton();
        jRbtn_Fluids = new javax.swing.JRadioButton();
        jRbtn_Lights = new javax.swing.JRadioButton();
        jRbtn_WashCar = new javax.swing.JRadioButton();
        jRbtn_Brakes = new javax.swing.JRadioButton();
        jRbtn_SeatBelts = new javax.swing.JRadioButton();
        jRbtn_WiperBlades = new javax.swing.JRadioButton();
        jRbtn_EnginePerformance = new javax.swing.JRadioButton();
        jRbtn_AirFilters = new javax.swing.JRadioButton();
        jRbtn_CoolingSystem = new javax.swing.JRadioButton();
        jRbtn_Battery = new javax.swing.JRadioButton();
        jLbl_MinorMaintenance = new javax.swing.JLabel();
        jLbl_CarID = new javax.swing.JLabel();
        jLbl_MaintenanceID = new javax.swing.JLabel();
        jTxt_MaintenanceID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtn_Search = new javax.swing.JButton();
        jComboBox_CarID = new javax.swing.JComboBox<>();
        jBtn_Add = new javax.swing.JButton();
        jBtn_Delete = new javax.swing.JButton();
        jBtn_ReturnBack = new javax.swing.JButton();
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

        jLbl_AffectedParts.setBackground(new java.awt.Color(0, 0, 0, 50));
        jLbl_AffectedParts.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_AffectedParts.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_AffectedParts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_AffectedParts.setText("Affected Parts");
        jLbl_AffectedParts.setOpaque(true);
        jPanel1.add(jLbl_AffectedParts);
        jLbl_AffectedParts.setBounds(20, 110, 270, 36);

        jRbtn_Mirrors.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Mirrors.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Mirrors.setText("Outside Mirrors");
        jPanel1.add(jRbtn_Mirrors);
        jRbtn_Mirrors.setBounds(20, 160, 160, 20);

        jRbtn_WheelCover.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_WheelCover.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_WheelCover.setText("Wheel Cover");
        jPanel1.add(jRbtn_WheelCover);
        jRbtn_WheelCover.setBounds(20, 220, 150, 20);

        jRbtn_DoorHandle.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_DoorHandle.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_DoorHandle.setText("Door Handle");
        jPanel1.add(jRbtn_DoorHandle);
        jRbtn_DoorHandle.setBounds(20, 250, 150, 20);

        jRbtn_HeadLamps.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_HeadLamps.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_HeadLamps.setText("Head Lamps");
        jPanel1.add(jRbtn_HeadLamps);
        jRbtn_HeadLamps.setBounds(20, 280, 150, 20);

        jRbtn_LicensePlate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_LicensePlate.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_LicensePlate.setText("License Plate");
        jPanel1.add(jRbtn_LicensePlate);
        jRbtn_LicensePlate.setBounds(20, 190, 150, 20);

        jRbtn_TailLights.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_TailLights.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_TailLights.setText("Tail Lights");
        jPanel1.add(jRbtn_TailLights);
        jRbtn_TailLights.setBounds(20, 310, 150, 20);

        jRbtn_Roof.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Roof.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Roof.setText("Roof");
        jPanel1.add(jRbtn_Roof);
        jRbtn_Roof.setBounds(20, 340, 150, 20);

        jRbtn_Grille.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Grille.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Grille.setText("Grille");
        jPanel1.add(jRbtn_Grille);
        jRbtn_Grille.setBounds(20, 370, 150, 20);

        jRbtn_Bumper.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Bumper.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Bumper.setText("Bumper");
        jPanel1.add(jRbtn_Bumper);
        jRbtn_Bumper.setBounds(20, 400, 150, 20);

        jRbtn_Windows.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Windows.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Windows.setText("Windows");
        jPanel1.add(jRbtn_Windows);
        jRbtn_Windows.setBounds(20, 430, 150, 20);

        jRbtn_Wipers.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Wipers.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Wipers.setText("Wipers");
        jPanel1.add(jRbtn_Wipers);
        jRbtn_Wipers.setBounds(20, 460, 150, 20);

        jRbtn_Doors.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Doors.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Doors.setText("Doors");
        jPanel1.add(jRbtn_Doors);
        jRbtn_Doors.setBounds(20, 490, 150, 20);

        jRbtn_tires.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_tires.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_tires.setText("Check and maintain tires");
        jPanel1.add(jRbtn_tires);
        jRbtn_tires.setBounds(400, 60, 230, 20);

        jRbtn_OilFilters.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_OilFilters.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_OilFilters.setText("Change Oil and Oil Filter");
        jPanel1.add(jRbtn_OilFilters);
        jRbtn_OilFilters.setBounds(400, 90, 220, 27);

        jRbtn_Fluids.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Fluids.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Fluids.setText("check the fluids");
        jPanel1.add(jRbtn_Fluids);
        jRbtn_Fluids.setBounds(400, 120, 190, 20);

        jRbtn_Lights.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Lights.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Lights.setText("Test the lights");
        jPanel1.add(jRbtn_Lights);
        jRbtn_Lights.setBounds(400, 150, 170, 20);

        jRbtn_WashCar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_WashCar.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_WashCar.setText("Wash the car");
        jPanel1.add(jRbtn_WashCar);
        jRbtn_WashCar.setBounds(400, 180, 160, 20);

        jRbtn_Brakes.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Brakes.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Brakes.setText("Check Brakes");
        jPanel1.add(jRbtn_Brakes);
        jRbtn_Brakes.setBounds(400, 210, 140, 20);

        jRbtn_SeatBelts.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_SeatBelts.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_SeatBelts.setText("Check seat belts");
        jPanel1.add(jRbtn_SeatBelts);
        jRbtn_SeatBelts.setBounds(650, 120, 190, 20);

        jRbtn_WiperBlades.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_WiperBlades.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_WiperBlades.setText("Replace Wiper Blades");
        jPanel1.add(jRbtn_WiperBlades);
        jRbtn_WiperBlades.setBounds(650, 90, 210, 20);

        jRbtn_EnginePerformance.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_EnginePerformance.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_EnginePerformance.setText("Check Engine Performance");
        jPanel1.add(jRbtn_EnginePerformance);
        jRbtn_EnginePerformance.setBounds(650, 60, 240, 20);

        jRbtn_AirFilters.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_AirFilters.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_AirFilters.setText("Check air filter");
        jPanel1.add(jRbtn_AirFilters);
        jRbtn_AirFilters.setBounds(650, 150, 180, 20);

        jRbtn_CoolingSystem.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_CoolingSystem.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_CoolingSystem.setText("Check cooling system");
        jPanel1.add(jRbtn_CoolingSystem);
        jRbtn_CoolingSystem.setBounds(650, 180, 200, 20);

        jRbtn_Battery.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRbtn_Battery.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_Battery.setText("Check battery");
        jPanel1.add(jRbtn_Battery);
        jRbtn_Battery.setBounds(650, 210, 170, 20);

        jLbl_MinorMaintenance.setBackground(new java.awt.Color(0, 0, 0, 50));
        jLbl_MinorMaintenance.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_MinorMaintenance.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_MinorMaintenance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbl_MinorMaintenance.setText("Minor Maintenance");
        jLbl_MinorMaintenance.setOpaque(true);
        jPanel1.add(jLbl_MinorMaintenance);
        jLbl_MinorMaintenance.setBounds(400, 20, 490, 36);

        jLbl_CarID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_CarID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_CarID.setText("Car ID");
        jPanel1.add(jLbl_CarID);
        jLbl_CarID.setBounds(920, 20, 270, 36);

        jLbl_MaintenanceID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLbl_MaintenanceID.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_MaintenanceID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_MaintenanceID.setText("Maintenance ID");
        jPanel1.add(jLbl_MaintenanceID);
        jLbl_MaintenanceID.setBounds(20, 20, 270, 30);

        jTxt_MaintenanceID.setBackground(new java.awt.Color(153, 153, 153, 0));
        jTxt_MaintenanceID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTxt_MaintenanceID.setForeground(new java.awt.Color(255, 255, 255));
        jTxt_MaintenanceID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_MaintenanceID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTxt_MaintenanceID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTxt_MaintenanceID.setOpaque(false);
        jPanel1.add(jTxt_MaintenanceID);
        jTxt_MaintenanceID.setBounds(20, 55, 270, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0, 5));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(400, 54, 490, 180);

        jBtn_Search.setBackground(new java.awt.Color(255, 255, 255));
        jBtn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jBtn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SearchActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Search);
        jBtn_Search.setBounds(290, 45, 40, 40);

        jComboBox_CarID.setBackground(new java.awt.Color(97, 96, 96));
        jComboBox_CarID.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_CarID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox_CarID);
        jComboBox_CarID.setBounds(920, 60, 270, 30);

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
        jBtn_Add.setBounds(700, 550, 180, 80);

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
        jBtn_Delete.setBounds(880, 550, 170, 80);

        jBtn_ReturnBack.setBackground(new java.awt.Color(169, 166, 166));
        jBtn_ReturnBack.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jBtn_ReturnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Return Back.png"))); // NOI18N
        jBtn_ReturnBack.setBorder(null);
        jBtn_ReturnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ReturnBackActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_ReturnBack);
        jBtn_ReturnBack.setBounds(10, 550, 130, 80);

        jTbtn_ShowTable.setBackground(new java.awt.Color(169, 166, 166));
        jTbtn_ShowTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Tables.png"))); // NOI18N
        jTbtn_ShowTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTbtn_ShowTableItemStateChanged(evt);
            }
        });
        jPanel1.add(jTbtn_ShowTable);
        jTbtn_ShowTable.setBounds(1050, 550, 170, 80);

        jLbl_Background.setBackground(new java.awt.Color(209, 209, 209));
        jLbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainImage.jpg"))); // NOI18N
        jPanel1.add(jLbl_Background);
        jLbl_Background.setBounds(0, -60, 1330, 750);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1330, 690));

        jLbl_Header.setBackground(new java.awt.Color(255, 255, 255));
        jLbl_Header.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLbl_Header.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbl_Header.setText("  Smooth Wheel  ");
        jPanel2.add(jLbl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AddActionPerformed
        boolean checkMinor = checkMinorMaintenance();
        if (jTxt_MaintenanceID.getText().equals("") || checkMinor == false) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to fill in all the required <br/> information about the maintenance record.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            String affectedPartString;
            try {
                Statement newstatement = connection.createStatement();
                String sqlString = "insert into Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jComboBox_CarID.getSelectedItem().toString() + "')";
                int isAdded = newstatement.executeUpdate(sqlString);

                if (jRbtn_Mirrors.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Mirrors.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_LicensePlate.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_LicensePlate.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_WheelCover.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_WheelCover.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_DoorHandle.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_DoorHandle.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_HeadLamps.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_HeadLamps.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_TailLights.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_TailLights.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }
                if (jRbtn_Roof.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Roof.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_Grille.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Grille.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_Bumper.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Bumper.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_Windows.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Windows.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_Wipers.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Wipers.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                if (jRbtn_Doors.isSelected()) {
                    affectedPartString = "insert into Affected_Part values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Doors.getText() + "')";
                    newstatement.executeUpdate(affectedPartString);
                }

                String minorMaintenance;
                if (jRbtn_tires.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_tires.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_EnginePerformance.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_EnginePerformance.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_OilFilters.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_OilFilters.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_WiperBlades.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_WiperBlades.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_Fluids.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Fluids.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_SeatBelts.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_SeatBelts.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_Lights.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Lights.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_AirFilters.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_AirFilters.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_WashCar.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_WashCar.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_CoolingSystem.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_CoolingSystem.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_Brakes.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Brakes.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (jRbtn_Battery.isSelected()) {
                    minorMaintenance = "insert into Minor_Maintenance values(" + this.jTxt_MaintenanceID.getText() + ", '" + this.jRbtn_Battery.getText() + "')";
                    newstatement.executeUpdate(minorMaintenance);
                }

                if (isAdded == 1) {
                    connection.commit();
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("<html> The maintenance record is successfully added.</html>");
                    callTimer(success);
                } else {
                    ErrorNotification error = new ErrorNotification();
                    error.setVisible(true);
                    error.setText("<html> The maintenance record can't be added! <br/> Please try again. <html>");
                    callTimer(error);
                }
                connection.close();

                String newRow[] = {this.jTxt_MaintenanceID.getText(), this.jComboBox_CarID.getSelectedItem().toString()};
                DefaultTableModel tableModel = (DefaultTableModel) maintenanceTable.getTableName().getModel();
                tableModel.addRow(newRow);
                jTxt_MaintenanceID.setText("");
                clearCheckBoxes();

            } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
                ErrorNotification failed = new ErrorNotification();
                failed.setVisible(true);
                failed.setText("<html> There is an added maintenance record with the <br/> selected maintenance ID! </html>");
                callTimer(failed);
            } catch (SQLException ex) {
                ErrorNotification error = new ErrorNotification();
                error.setVisible(true);
                error.setText("Please make sure to enter valid information!");
                callTimer(error);
            }
        }
    }//GEN-LAST:event_jBtn_AddActionPerformed

    private void jBtn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_DeleteActionPerformed
        boolean checkMinor = checkMinorMaintenance();
        if (jTxt_MaintenanceID.getText().equals("")) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to search about a specific <br/> maintenance record by the maintenance ID <br/> to delete.</html>");
            callTimer(warning);
        } else {
            Connection connection = prepareDrivers();
            try {
                Statement deleteStatement = connection.createStatement();
                String maintenanceID = this.jTxt_MaintenanceID.getText();
                String delete1 = "delete from Maintenance where Maintenance_ID =" + maintenanceID;
                String delete2 = "delete from Minor_Maintenance where Maintenance_ID =" + maintenanceID;
                String delete3 = "delete from Affected_Part where Maintenance_ID =" + maintenanceID;

                deleteStatement.executeUpdate(delete3);
                deleteStatement.executeUpdate(delete2);
                int isDeleted1 = deleteStatement.executeUpdate(delete1);

                if (isDeleted1 == 1) {
                    connection.commit();
                    jTxt_MaintenanceID.setText("");
                    clearCheckBoxes();
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("The maintenance record is successfully deleted.");
                    callTimer(success);
                    updateMaintenanceTable();
                } else {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The maintenance record can't be deleted! <br/> Please try again.</html>");
                    callTimer(warning);
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

    private void jBtn_ReturnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ReturnBackActionPerformed
        new WelcomeInterface().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_ReturnBackActionPerformed

    private void jTbtn_ShowTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTbtn_ShowTableItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            maintenanceTable.setVisible(true);
            jTbtn_ShowTable.setBackground(Color.WHITE);
            jBtn_ReturnBack.setEnabled(false);
            jBtn_Add.setEnabled(false);
            jBtn_Delete.setEnabled(false);
        } else {
            maintenanceTable.setVisible(false);
            jBtn_ReturnBack.setEnabled(true);
            jTbtn_ShowTable.setBackground(Color.LIGHT_GRAY);
            jBtn_Add.setEnabled(true);
            jBtn_Delete.setEnabled(true);
        }
    }//GEN-LAST:event_jTbtn_ShowTableItemStateChanged

    private void jBtn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SearchActionPerformed
        boolean affectedFlag = checkAffectedPart();
        boolean minorFlag = checkMinorMaintenance();
        if (jTxt_MaintenanceID.getText().equals("") && minorFlag == false && affectedFlag == false) {
            WarningNotification warning = new WarningNotification();
            warning.setVisible(true);
            warning.setText("<html> Please make sure to fill in the maintenance ID <br/> to search about a specific maintenance record. </html>");
            callTimer(warning);
        } else if (!jTxt_MaintenanceID.getText().equals("") && minorFlag == false && affectedFlag == false) {
            Connection connection = prepareDrivers();
            try {
                PreparedStatement queryStatement = connection.prepareStatement("Select * from Maintenance where Maintenance_ID = ?");
                String maintenanceID = this.jTxt_MaintenanceID.getText();
                queryStatement.setString(1, maintenanceID);
                ResultSet result = queryStatement.executeQuery();

                queryStatement = connection.prepareStatement("Select * from Affected_Part where Maintenance_ID = ?");
                queryStatement.setString(1, maintenanceID);
                ResultSet affectedPartsResult = queryStatement.executeQuery();

                queryStatement = connection.prepareStatement("Select * from Minor_Maintenance where Maintenance_ID = ?");
                queryStatement.setString(1, maintenanceID);
                ResultSet MinorResult = queryStatement.executeQuery();

                if (result.next()) {
                    String maintenanceRowDetails[] = {result.getString("Maintenance_ID"), result.getString("Car_ID")};
                    connection.commit();
                    jTxt_MaintenanceID.setText(maintenanceRowDetails[0]);
                    jComboBox_CarID.setSelectedItem(maintenanceRowDetails[1]);

                    while (affectedPartsResult.next()) {
                        if (jRbtn_Mirrors.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Mirrors.setSelected(true);
                        }
                        if (jRbtn_LicensePlate.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_LicensePlate.setSelected(true);
                        }

                        if (jRbtn_WheelCover.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_WheelCover.setSelected(true);
                        }

                        if (jRbtn_DoorHandle.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_DoorHandle.setSelected(true);
                        }

                        if (jRbtn_HeadLamps.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_HeadLamps.setSelected(true);
                        }

                        if (jRbtn_TailLights.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_TailLights.setSelected(true);
                        }

                        if (jRbtn_Roof.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Roof.setSelected(true);
                        }

                        if (jRbtn_Grille.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Grille.setSelected(true);
                        }

                        if (jRbtn_Bumper.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Bumper.setSelected(true);
                        }

                        if (jRbtn_Windows.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Windows.setSelected(true);
                        }

                        if (jRbtn_Wipers.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Wipers.setSelected(true);
                        }

                        if (jRbtn_Doors.getText().equals(affectedPartsResult.getString("Affected_Part"))) {
                            jRbtn_Doors.setSelected(true);
                        }

                        while (MinorResult.next()) {
                            if (jRbtn_tires.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_tires.setSelected(true);
                            }

                            if (jRbtn_EnginePerformance.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_EnginePerformance.setSelected(true);
                            }

                            if (jRbtn_OilFilters.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_OilFilters.setSelected(true);
                            }

                            if (jRbtn_WiperBlades.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_WiperBlades.setSelected(true);
                            }

                            if (jRbtn_Fluids.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_Fluids.setSelected(true);
                            }

                            if (jRbtn_SeatBelts.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_SeatBelts.setSelected(true);
                            }

                            if (jRbtn_Lights.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_Lights.setSelected(true);
                            }

                            if (jRbtn_AirFilters.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_AirFilters.setSelected(true);
                            }

                            if (jRbtn_WashCar.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_WashCar.setSelected(true);
                            }

                            if (jRbtn_CoolingSystem.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_CoolingSystem.setSelected(true);
                            }
                            if (jRbtn_Brakes.getText().equals(MinorResult.getString("Minor_maintenance"))) {
                                jRbtn_Brakes.setSelected(true);
                            }
                        }
                    }
                    SuccessNotification success = new SuccessNotification();
                    success.setVisible(true);
                    success.setText("<html> The required Maintenance record is <br/> successfully found. </html>");
                    callTimer(success);
                } else {
                    WarningNotification warning = new WarningNotification();
                    warning.setVisible(true);
                    warning.setText("<html> The maintenance ID you have entered doesn't <br/> belong to any stored maintenance record! <br/> please try again with a valid maintenance ID.</html>");
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
            warning.setText("<html> Please make sure to search using <br/> the maintenance ID only! </html>");
            callTimer(warning);
        }
    }//GEN-LAST:event_jBtn_SearchActionPerformed

    private void jBtn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtn_CloseMouseClicked

    private void jBtn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_CloseMouseEntered
        jBtn_Close.setBackground(Color.red);
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
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Add;
    private javax.swing.JButton jBtn_Close;
    private javax.swing.JButton jBtn_Delete;
    private javax.swing.JButton jBtn_ReturnBack;
    private javax.swing.JButton jBtn_Search;
    private javax.swing.JComboBox<String> jComboBox_CarID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbl_AffectedParts;
    private javax.swing.JLabel jLbl_Background;
    private javax.swing.JLabel jLbl_CarID;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_MaintenanceID;
    private javax.swing.JLabel jLbl_MinorMaintenance;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRbtn_AirFilters;
    private javax.swing.JRadioButton jRbtn_Battery;
    private javax.swing.JRadioButton jRbtn_Brakes;
    private javax.swing.JRadioButton jRbtn_Bumper;
    private javax.swing.JRadioButton jRbtn_CoolingSystem;
    private javax.swing.JRadioButton jRbtn_DoorHandle;
    private javax.swing.JRadioButton jRbtn_Doors;
    private javax.swing.JRadioButton jRbtn_EnginePerformance;
    private javax.swing.JRadioButton jRbtn_Fluids;
    private javax.swing.JRadioButton jRbtn_Grille;
    private javax.swing.JRadioButton jRbtn_HeadLamps;
    private javax.swing.JRadioButton jRbtn_LicensePlate;
    private javax.swing.JRadioButton jRbtn_Lights;
    private javax.swing.JRadioButton jRbtn_Mirrors;
    private javax.swing.JRadioButton jRbtn_OilFilters;
    private javax.swing.JRadioButton jRbtn_Roof;
    private javax.swing.JRadioButton jRbtn_SeatBelts;
    private javax.swing.JRadioButton jRbtn_TailLights;
    private javax.swing.JRadioButton jRbtn_WashCar;
    private javax.swing.JRadioButton jRbtn_WheelCover;
    private javax.swing.JRadioButton jRbtn_Windows;
    private javax.swing.JRadioButton jRbtn_WiperBlades;
    private javax.swing.JRadioButton jRbtn_Wipers;
    private javax.swing.JRadioButton jRbtn_tires;
    private javax.swing.JToggleButton jTbtn_ShowTable;
    private javax.swing.JTextField jTxt_MaintenanceID;
    // End of variables declaration//GEN-END:variables
}
