/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import static Views.UserView.tbl_cards;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steve and Marcos
 */
public class ReservationsView extends javax.swing.JFrame {

    GlobalsSingleton global = GlobalsSingleton.getInstance();
    Connection conect = ConexionDB.Connectdatabase();
    DefaultTableModel dftables = new DefaultTableModel();
    DefaultTableModel dftables1 = new DefaultTableModel();

    public ReservationsView() throws SQLException {
        initComponents();
        blockItems();
        showCards();
        showRoomType();
        showInfoReservation();

    }

    public void blockItems() {

        txt_entryDate.setEnabled(false);
        txt_exitDate.setEnabled(false);
        txt_childremAmount.setEnabled(false);
        txt_adultsAmount.setEnabled(false);
        txt_roomType.setEnabled(false);
        txt_bedType.setEnabled(false);
        txt_cardNumber.setEnabled(false);

        txt_entryDate.setText(global.getEntryDate());
        txt_exitDate.setText(global.getExitDate());
        txt_childremAmount.setText(" " + global.getChildremAmount());
        txt_adultsAmount.setText(" " + global.getAdultAmount());

    }

    public void addRoomType() {

        String roomType = txt_roomType.getText();
        String bedType = txt_bedType.getText();
        String cardNumber = txt_cardNumber.getText();

    }

    public void showInfoReservation() {

//        txt_entryDate.setText(global.getEntryDate());
//        txt_exitDate.setText(global.getEntryDate());
        //este night number hay que calcular el numero de noche con los jcaledar
        txt_nightsNumber.setText("8");
        txt_childremAmount.setText(Integer.toString(global.getChildremAmount()));
        txt_adultsAmount.setText(Integer.toString(global.getAdultAmount()));

    }

    //This method show all the cards that the user has.
    public void showCards() throws SQLException {

        String urlhotelverify = "SELECT * FROM card";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_card.setModel(dftables);
        dftables.setColumnIdentifiers(new Object[]{"Card Number"});

        try {
            while (resultservice.next()) {

                serviceverification = resultservice.getInt("id_user");

                if (serviceverification == (GlobalsSingleton.getInstance().getUserID())) {

                    dftables.addRow(new Object[]{resultservice.getString("cardnumber")});

                }

            }

        } catch (SQLException e) {

        }
    }

    //This method select the card that the user wants to choose
    public void selectRowsCard() {

        int row = tbl_card.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this, "Select one Card please.",
                    "Empty fields", JOptionPane.WARNING_MESSAGE);

            return;

        } else {

            String cardNumber = tbl_card.getValueAt(row, 0).toString();

            txt_cardNumber.setText(cardNumber);

        }

    }

    //This method show all the room tha the hotel has.
    public void showRoomType() throws SQLException {

        String urlhotelverify = "SELECT * FROM roomtype";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_roomType.setModel(dftables1);
        dftables1.setColumnIdentifiers(new Object[]{"Room Type", "Bed Tipe"});

        try {
            while (resultservice.next()) {

                serviceverification = resultservice.getInt("id_hotel");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdHotel())) {
                    try {
                        while (resultservice.next()) {

                            dftables1.addRow(new Object[]{resultservice.getString("room_type"), resultservice.getString("bedtype")});

                            global.setIdRoomType(resultservice.getInt("id_type"));

                        }
                    } catch (SQLException e) {

                    }

                }

            }

        } catch (SQLException e) {

        }
    }

    //This method select the card that the user wants to choose
    public void selectRowsRoom() {

        int row = tbl_roomType.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this, "Select one Room Type Please",
                    "Empty fields", JOptionPane.WARNING_MESSAGE);

            return;

        } else {

            String roomType = tbl_roomType.getValueAt(row, 0).toString();
            String bedType = tbl_roomType.getValueAt(row, 1).toString();

            txt_roomType.setText(roomType);
            txt_bedType.setText(bedType);

        }

    }

    //This method show all the cards that the user has.
    public void saveNumRoom() throws SQLException {

        String urlhotelverify = "SELECT * FROM room";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);

        try {
            while (resultservice.next()) {

                serviceverification = resultservice.getInt("id_type");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdRoomType())) {

                    global.setNumRoom(resultservice.getInt("num_room"));

                }

            }

        } catch (SQLException e) {

        }
    }

    //This method has a reservation
    public void makeReservation() {

        if (txt_entryDate.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter an Owner Name to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_entryDate.requestFocus();
            return;

        }

        if (txt_exitDate.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter an Owner Last Name to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_exitDate.requestFocus();
            return;

        }

        if (txt_cardNumber.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Number to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_cardNumber.requestFocus();
            return;

        }

        if (txt_nightsNumber.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_nightsNumber.requestFocus();
            return;

        }

        if (txt_childremAmount.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_childremAmount.requestFocus();
            return;

        }

        if (txt_adultsAmount.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_adultsAmount.requestFocus();
            return;

        }

        if (txt_roomType.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_roomType.requestFocus();
            return;

        }

        if (txt_bedType.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_bedType.requestFocus();
            return;

        }

        if (txt_cardNumber.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_cardNumber.requestFocus();
            return;

        }

        String entryDate = txt_entryDate.getText();
        String exitDate = txt_exitDate.getText();
        int nightsNumber = Integer.parseInt(txt_nightsNumber.getText());
        int childremAmount = Integer.parseInt(txt_childremAmount.getText());
        int adultsAmount = Integer.parseInt(txt_adultsAmount.getText());
        String statusReservation = "Completed";
        int idUser = global.getUserID();
        int numRoom = global.getNumRoom();
        String cardNumber = global.getCardNumber();

        Connection conect = ConexionDB.Connectdatabase();

        try {
            PreparedStatement insert = conect.prepareStatement("Insert Into "
                    + "reservation(entrydate,exitdate,nightsnumbers,childrenamount,adultsamount,reservationstatus,num_room,id_user,cardnumber)"
                    + "Values(?,?,?,?,?,?,?,?,?)");

            insert.setString(1, entryDate);
            insert.setString(2, exitDate);
            insert.setInt(3, nightsNumber);
            insert.setInt(4, childremAmount);
            insert.setInt(5, adultsAmount);
            insert.setString(6, statusReservation);
            insert.setInt(7, numRoom);
            insert.setInt(8, idUser);
            insert.setString(9, cardNumber);

            int a = insert.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }        // TODO 

        this.dispose();

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
        jLabel1 = new javax.swing.JLabel();
        txt_entryDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_exitDate = new javax.swing.JTextField();
        txt_nightsNumber = new javax.swing.JTextField();
        txt_childremAmount = new javax.swing.JTextField();
        txt_adultsAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_roomType = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_roomType = new javax.swing.JTextField();
        txt_bedType = new javax.swing.JTextField();
        btn_chooseRoomType = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_card = new javax.swing.JTable();
        btn_chooseCard = new javax.swing.JButton();
        txt_cardNumber = new javax.swing.JTextField();
        btn_makeReservation = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Entry Date");

        txt_entryDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_entryDateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Exit Date");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Nights Number");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Children Amount");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Adults Amount");

        txt_nightsNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nightsNumberActionPerformed(evt);
            }
        });

        txt_childremAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_childremAmountActionPerformed(evt);
            }
        });

        tbl_roomType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Room Type", "Bed Type"
            }
        ));
        jScrollPane1.setViewportView(tbl_roomType);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Room Type");

        txt_bedType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bedTypeActionPerformed(evt);
            }
        });

        btn_chooseRoomType.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_chooseRoomType.setText("Add Room Type");
        btn_chooseRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseRoomTypeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Card");

        tbl_card.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Card Number"
            }
        ));
        jScrollPane2.setViewportView(tbl_card);

        btn_chooseCard.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_chooseCard.setText("Add Room Type");
        btn_chooseCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseCardActionPerformed(evt);
            }
        });

        btn_makeReservation.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_makeReservation.setText("Make a Reservation");
        btn_makeReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_makeReservationActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reservation.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_entryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_exitDate)
                    .addComponent(txt_nightsNumber)
                    .addComponent(txt_childremAmount)
                    .addComponent(txt_adultsAmount)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btn_makeReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_chooseCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(txt_roomType)
                            .addComponent(txt_bedType)
                            .addComponent(btn_chooseRoomType, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(txt_cardNumber)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_entryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_exitDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btn_chooseRoomType))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nightsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_roomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_bedType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_childremAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_adultsAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_chooseCard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_makeReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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

    private void txt_bedTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bedTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bedTypeActionPerformed

    private void btn_makeReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_makeReservationActionPerformed

        try {
            saveNumRoom();
            makeReservation();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationsView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_makeReservationActionPerformed

    private void txt_entryDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_entryDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_entryDateActionPerformed

    private void txt_nightsNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nightsNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nightsNumberActionPerformed

    private void txt_childremAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_childremAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_childremAmountActionPerformed

    private void btn_chooseRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseRoomTypeActionPerformed

        selectRowsRoom();

    }//GEN-LAST:event_btn_chooseRoomTypeActionPerformed

    private void btn_chooseCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseCardActionPerformed

        selectRowsCard();

    }//GEN-LAST:event_btn_chooseCardActionPerformed

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
            java.util.logging.Logger.getLogger(ReservationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReservationsView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ReservationsView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chooseCard;
    private javax.swing.JButton btn_chooseRoomType;
    private javax.swing.JButton btn_makeReservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_card;
    private javax.swing.JTable tbl_roomType;
    private javax.swing.JTextField txt_adultsAmount;
    private javax.swing.JTextField txt_bedType;
    private javax.swing.JTextField txt_cardNumber;
    private javax.swing.JTextField txt_childremAmount;
    private javax.swing.JTextField txt_entryDate;
    private javax.swing.JTextField txt_exitDate;
    private javax.swing.JTextField txt_nightsNumber;
    private javax.swing.JTextField txt_roomType;
    // End of variables declaration//GEN-END:variables
}
