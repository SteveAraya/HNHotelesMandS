/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import static Views.MainView.showCreateAccount;
import static Views.MainView.showLogIn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steve and Marcos
 */
public class HotelView extends javax.swing.JFrame {
   
    GlobalsSingleton global = GlobalsSingleton.getInstance();
    Connection conect = ConexionDB.Connectdatabase();
    DefaultTableModel dftables = new DefaultTableModel();
    DefaultTableModel dftables2 = new DefaultTableModel();
    DefaultTableModel dftables3 = new DefaultTableModel();
    
    public HotelView() throws SQLException {
        
        initComponents();
        showImagesHotel();
        blockItems();
        showHotelInfo();
           
    }

    //This method show the starts that the hotel has.
    public void showStars(){
        
        ImageIcon star = new ImageIcon(getClass().getResource("../images/star.png"));
        Icon iconStar = new ImageIcon(star.getImage());
        
        if (global.getHotelStars() == 1){
            
            star1jLabel.setIcon(iconStar);
            
        }
        
        if (global.getHotelStars() == 2){
            
            star1jLabel.setIcon(iconStar);
            star2jLabel.setIcon(iconStar);
            
        }
        
        if (global.getHotelStars() == 3){
            
            star1jLabel.setIcon(iconStar);
            star2jLabel.setIcon(iconStar);
            star3jLabel.setIcon(iconStar);
            
        }
        
        if (global.getHotelStars() == 4){
            
            star1jLabel.setIcon(iconStar);
            star2jLabel.setIcon(iconStar);
            star3jLabel.setIcon(iconStar);
            star4jLabel.setIcon(iconStar);
            
        }
        
        else{
            
            star1jLabel.setIcon(iconStar);
            star2jLabel.setIcon(iconStar);
            star3jLabel.setIcon(iconStar);
            star4jLabel.setIcon(iconStar);
            star5jLabel.setIcon(iconStar);

        }

    }
    
    public void showImagesHotel(){
        
        ImageIcon empty = new ImageIcon(getClass().getResource("../images/empty.png"));
        Icon iconEmpty = new ImageIcon(empty.getImage());
        
        
        imagesHoteljLabel.setIcon(iconEmpty);
        imagesHoteljLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagesHoteljLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        
    }
    
    //This method show the Queries view.
    public static void showReservation() {

        ReservationsView oReservationsView = new ReservationsView();
        oReservationsView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oReservationsView.setLocationRelativeTo(null);
        oReservationsView.setVisible(true);

    }
    
    public void blockItems(){
        
        txt_hotelName.setEditable(false);
        txt_telNumber.setEditable(false);
        txt_country.setEditable(false);
        txt_ubication.setEditable(false);
        txt_chechInTime.setEditable(false);
        txt_checkOutTime.setEditable(false);
        txt_lodgingType.setEditable(false);
        txt_construtionYear.setEditable(false);
        txt_hotelSize.setEditable(false);
        txt_requirementCheckin.setEditable(false);
  
    }
    
    //This method verify if the user is active or not
    public void verifyUser(){
        
        if(global.getUserCondition().equals("Inactive")){
            
            Icon blueIcon = new ImageIcon("yourFile.gif");
            Object[] options = { "Create an Account", "Initiate Session" };
            int choice = JOptionPane.showOptionDialog(null, 
                "You must initiate secion and if you do not have an account you must create one.", 
                "Select an Option", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                blueIcon, 
                options, 
                options[0]);

            if (choice == JOptionPane.YES_OPTION){

                showCreateAccount();

            }

            else{

                showLogIn();

            }

        }
   
    }
    
    //This method is for  veri if the hotel has a  service
    public void verifyService() throws SQLException {

        String urlhotelverify = "SELECT * FROM service";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_servicesHotel.setModel(dftables);
        dftables.setColumnIdentifiers(new Object[]{"Hotel's Services "});

        try {
            while (resultservice.next()) {
                
                serviceverification = resultservice.getInt("id_hotel");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdHotel())) {

                    dftables.addRow(new Object[]{resultservice.getString("service_name")});

                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
        //This method is for  veri if the hotel has a  service
    public void verifyRoomType() throws SQLException {

        String urlhotelverify = "SELECT * FROM roomtype";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_roomInformation.setModel(dftables3);
        dftables3.setColumnIdentifiers(new Object[]{"Room Type", "Room Information "});

        try {
            while (resultservice.next()) {
                
                serviceverification = resultservice.getInt("id_hotel");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdHotel())) {

                    dftables3.addRow(new Object[]{resultservice.getString("room_type"), resultservice.getString("bedtype")});

                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //This method is for  veri if the hotel has room type

    public void verifyAttractive() throws SQLException {

        String urlhotelverify = "SELECT * FROM attractive";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_attractionsHotel.setModel(dftables2);
        dftables2.setColumnIdentifiers(new Object[]{"Hotel's Attractions"});

        try {
            
            while (resultservice.next()) {
                
                serviceverification = resultservice.getInt("id_hotel");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdHotel())) {
                    
                    dftables2.addRow(new Object[]{resultservice.getString("attractive_name")});

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
   
    //This method show the information about the Hotel
    public void showHotelInfo() throws SQLException{
        
        String urlUser = "SELECT * FROM hotel ";

        int idHotel;
        String hotelName;
        int telNumber;
        String country;
        String ubication;
        int chechInTime;
        int checkOutTime;
        String lodgingType;
        int construtionYear;
        int hotelSize;
        int starnumbers;
        String requirementCheckin;

        java.sql.Statement selectconect = conect.createStatement();

        ResultSet result = selectconect.executeQuery(urlUser);

        while (result.next()) {

            idHotel = result.getInt("id_hotel");
            hotelName = result.getString("hotel_name");
            telNumber = result.getInt("telephone");
            country = result.getString("country");
            ubication = result.getString("address");
            chechInTime = result.getInt("checkingtime");
            checkOutTime = result.getInt("chekouttime");
            lodgingType = result.getString("lodgingtype");
            construtionYear = result.getInt("construcctionyears");
            hotelSize = result.getInt("hotelsize");
            starnumbers = result.getInt("starnumbers");
            requirementCheckin = result.getString("requirementCheckin");

            if (hotelName.equals(global.getHotelName())) {
                    
                txt_hotelName.setText(hotelName);
                txt_telNumber.setText(String.valueOf(telNumber));
                txt_country.setText(country);
                txt_ubication.setText(ubication);
                txt_chechInTime.setText(String.valueOf(chechInTime));
                txt_checkOutTime.setText(String.valueOf(checkOutTime));
                txt_lodgingType.setText(lodgingType);
                txt_construtionYear.setText(String.valueOf(construtionYear));
                txt_hotelSize.setText(String.valueOf(hotelSize));
                txt_requirementCheckin.setText(requirementCheckin);
                
                global.setHotelStars(starnumbers);
                global.setIdHotel(idHotel);
                
                showStars();
                verifyService();
                verifyAttractive();
                verifyRoomType();

            }

        }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hotelName = new javax.swing.JTextField();
        txt_telNumber = new javax.swing.JTextField();
        txt_country = new javax.swing.JTextField();
        txt_ubication = new javax.swing.JTextField();
        txt_chechInTime = new javax.swing.JTextField();
        txt_checkOutTime = new javax.swing.JTextField();
        txt_lodgingType = new javax.swing.JTextField();
        txt_construtionYear = new javax.swing.JTextField();
        hotelPicturejLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_hotelSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_servicesHotel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_attractionsHotel = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_roomInformation = new javax.swing.JTable();
        star2jLabel = new javax.swing.JLabel();
        star1jLabel = new javax.swing.JLabel();
        star5jLabel = new javax.swing.JLabel();
        star3jLabel = new javax.swing.JLabel();
        star4jLabel = new javax.swing.JLabel();
        imagesHoteljLabel = new javax.swing.JLabel();
        previousjButton = new javax.swing.JButton();
        nextjButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_requirementCheckin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Country");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Hotel Name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Telephone Number");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Ubication");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Checkin Time");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Checkout Time");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("LodgingType ");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Construction Year");

        txt_hotelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hotelNameActionPerformed(evt);
            }
        });

        txt_telNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telNumberActionPerformed(evt);
            }
        });

        txt_ubication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ubicationActionPerformed(evt);
            }
        });

        txt_checkOutTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_checkOutTimeActionPerformed(evt);
            }
        });

        txt_construtionYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_construtionYearActionPerformed(evt);
            }
        });

        hotelPicturejLabel.setText("Picture Hotel");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("Hotel Size");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("m² ");

        tbl_servicesHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel's Services "
            }
        ));
        jScrollPane1.setViewportView(tbl_servicesHotel);

        tbl_attractionsHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel's Attractions "
            }
        ));
        jScrollPane2.setViewportView(tbl_attractionsHotel);

        tbl_roomInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Type", "Room Information "
            }
        ));
        jScrollPane4.setViewportView(tbl_roomInformation);

        previousjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N

        nextjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        nextjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextjButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Check In Requirement");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setText("Make a Reservation In This Hotel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelPicturejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ubication, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_country))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_telNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_checkOutTime))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_chechInTime, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_lodgingType, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hotelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_construtionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imagesHoteljLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextjButton)
                            .addComponent(previousjButton))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(star1jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star2jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star3jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star4jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star5jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(txt_requirementCheckin)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelPicturejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(star1jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(star2jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(star5jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(star3jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(star4jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_telNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_ubication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_requirementCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_chechInTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_checkOutTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_lodgingType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_construtionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_hotelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nextjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(previousjButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagesHoteljLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hotelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hotelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hotelNameActionPerformed

    private void txt_telNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telNumberActionPerformed

    private void txt_ubicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ubicationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ubicationActionPerformed

    private void txt_checkOutTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_checkOutTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_checkOutTimeActionPerformed

    private void txt_construtionYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_construtionYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_construtionYearActionPerformed

    private void nextjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextjButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextjButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        showReservation();
  
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HotelView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HotelView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hotelPicturejLabel;
    private javax.swing.JLabel imagesHoteljLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton nextjButton;
    private javax.swing.JButton previousjButton;
    private javax.swing.JLabel star1jLabel;
    private javax.swing.JLabel star2jLabel;
    private javax.swing.JLabel star3jLabel;
    private javax.swing.JLabel star4jLabel;
    private javax.swing.JLabel star5jLabel;
    private javax.swing.JTable tbl_attractionsHotel;
    private javax.swing.JTable tbl_roomInformation;
    private javax.swing.JTable tbl_servicesHotel;
    private javax.swing.JTextField txt_chechInTime;
    private javax.swing.JTextField txt_checkOutTime;
    private javax.swing.JTextField txt_construtionYear;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_hotelName;
    private javax.swing.JTextField txt_hotelSize;
    private javax.swing.JTextField txt_lodgingType;
    private javax.swing.JTextField txt_requirementCheckin;
    private javax.swing.JTextField txt_telNumber;
    private javax.swing.JTextField txt_ubication;
    // End of variables declaration//GEN-END:variables
}