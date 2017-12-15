/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marco
 */
public class Rooms extends javax.swing.JFrame {

    Connection conect = ConexionDB.Connectdatabase();
    DefaultTableModel dftablert = new DefaultTableModel();
    DefaultTableModel dftabler = new DefaultTableModel();

    /**
     * Creates new form Rooms
     *
     * @throws java.sql.SQLException
     */
    public Rooms() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        verifyroom();
        verifytyperoom();
    }

    public void cleantexfield() {

        txt_numroom.setText("");
        txt_floornumber.setText("");
        txt_description.setText("");
        txt_roomsize.setText("");
        txt_roomprice.setText("");
        txt_roomattractive.setText("");
        txt_roomprice.setText("");
        txt_roomtype.setText("");
        txt_capacity.setText("");
        txt_bedtype.setText("");
        txt_typeroom.setText("");

    }

    public void verifyroom() throws SQLException {

        String urlhotelverify = "SELECT * FROM room";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultroom = selectconect.executeQuery(urlhotelverify);
        tbl_room.setModel(dftabler);
        dftabler.setColumnIdentifiers(new Object[]{"Num Room", "Floor", "Description", "Room size",
            "Room Attractive", "Room Type", "Room status", "Room Price"});

        try {
            while (resultroom.next()) {
                serviceverification = resultroom.getInt("id_hotel");

                if (serviceverification == (GlobalsSingleton.getInstance().getIdHotel())) {

                    dftabler.addRow(new Object[]{resultroom.getInt("num_room"), resultroom.getString("floornumber"),
                        resultroom.getString("description"), resultroom.getInt("roomsize"), resultroom.getString("room_attractive"),
                        resultroom.getInt("id_type"), resultroom.getString("roomstatus"), resultroom.getInt("roomprice")});

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void verifytyperoom() throws SQLException {

        String urlhotelverify = "SELECT * FROM roomtype";
        int typeroomverify;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultroomtype = selectconect.executeQuery(urlhotelverify);

        tbl_typeroom.setModel(dftablert);
        dftablert.setColumnIdentifiers(new Object[]{"Room Type", "Capacity", "Bed Type", "Code"});

        try {
            while (resultroomtype.next()) {
                typeroomverify = resultroomtype.getInt("id_hotel");

                if (typeroomverify == GlobalsSingleton.getInstance().getIdHotel()) {

                    dftablert.addRow(new Object[]{resultroomtype.getString("room_type"), resultroomtype.getInt("capacity"), resultroomtype.getString("bedtype"),
                        resultroomtype.getString("id_type")});

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertroom() throws SQLException {

        int num_room = Integer.parseInt(txt_numroom.getText());
        String floornumber = txt_floornumber.getText();
        String description = txt_description.getText();
        String roomsize = txt_roomsize.getText();
        String room_attractive = txt_roomattractive.getText();
        String room_type = txt_typeroom.getText();
        int roomstatus = 0;
        int roomprice = Integer.parseInt(txt_roomprice.getText());

        try {
            PreparedStatement insertroom = conect.prepareStatement("Insert Into room(num_room,floornumber,description,roomsize,room_attractive,id_type,roomstatus,roomprice,id_hotel)"
                    + "Values(?,?,?,?,?,?,?,?,?)");
            insertroom.setInt(1, num_room);
            insertroom.setString(2, floornumber);
            insertroom.setString(3, description);
            insertroom.setString(4, roomsize);
            insertroom.setString(5, room_attractive);
            insertroom.setString(6, room_type);
            insertroom.setInt(7, roomstatus);
            insertroom.setInt(8, roomprice);
            insertroom.setInt(9, GlobalsSingleton.getInstance().getIdHotel());

            int servicei = insertroom.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "succesfull");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    public void inserttyperoom() throws SQLException {

        String roomtype = txt_roomtype.getText();
        int capacity = Integer.parseInt(txt_capacity.getText());
        String bedtype = txt_bedtype.getText();

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery("SELECT season_code FROM season");

        try {
            while (resultservice.next()) {
                if (resultservice.getString("season_code").equals("2")) {
                    String seasonverify = resultservice.getString("season_code");

                    try {
                        PreparedStatement insertroomtype = conect.prepareStatement("Insert Into roomtype(room_type,capacity,bedtype,season_code,id_hotel)"
                                + "Values(?,?,?,?,?)");

                        insertroomtype.setString(1, roomtype);
                        insertroomtype.setInt(2, capacity);
                        insertroomtype.setString(3, bedtype);
                        insertroomtype.setString(4, seasonverify);
                        insertroomtype.setInt(5, GlobalsSingleton.getInstance().getIdHotel());

                        int servicei = insertroomtype.executeUpdate();

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Error\n"
                                + "Try Again .\n"
                                + "Error: " + e, "Error in the operation:",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {

        }

    }

    public void updateroom() {

        int num_room = Integer.parseInt(txt_numroom.getText());
        String floornumber = txt_floornumber.getText();
        String description = txt_description.getText();
        String roomsize = txt_roomsize.getText();
        String room_attractive = txt_typeroom.getText();
        String room_type = txt_typeroom.getText();
        int roomstatus = 0;
        int roomprice = Integer.parseInt(txt_roomprice.getText());

        try {
            String url = ("update room SET num_room=?,floornumber=?,description=?,roomsize=?,room_attractive=?,id_type=?,roomstatus=?,roomprice=?,id_hotel=?"
                    + "where id_hotel=? ");

            PreparedStatement insertroom = conect.prepareStatement(url);
            
            insertroom.setInt(1, num_room);
            insertroom.setString(2, floornumber);
            insertroom.setString(3, description);
            insertroom.setString(4, roomsize);
            insertroom.setString(5, room_attractive);
            insertroom.setString(6, room_type);
            insertroom.setInt(7, roomstatus);
            insertroom.setInt(8, roomprice);
            insertroom.setInt(9, GlobalsSingleton.getInstance().getIdHotel());

            if (insertroom.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                        + "Inténtelo nuevamente.", "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error\n"
                    + "Try Again .\n"
                    + "Error: " + e, "Error in the operation:",
                    JOptionPane.ERROR_MESSAGE);

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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_bedtype = new javax.swing.JTextField();
        txt_capacity = new javax.swing.JTextField();
        txt_roomtype = new javax.swing.JTextField();
        btn_inserttype = new javax.swing.JButton();
        btn_modifytype = new javax.swing.JButton();
        btn_deletetype = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_typeroom = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_roomsize = new javax.swing.JTextField();
        txt_floornumber = new javax.swing.JTextField();
        txt_numroom = new javax.swing.JTextField();
        btn_insertrooms = new javax.swing.JButton();
        btn_modifyrooms = new javax.swing.JButton();
        btn_deleterooms = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        txt_roomprice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_room = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txt_typeroom = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_roomattractive = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("Room Type");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Capacity");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setText("Bed Type");

        txt_bedtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        txt_capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        txt_roomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        btn_inserttype.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_inserttype.setText("Insert");
        btn_inserttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertroom1ActionPerformed(evt);
            }
        });

        btn_modifytype.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_modifytype.setText("Modify");
        btn_modifytype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyroom1ActionPerformed(evt);
            }
        });
        btn_modifytype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modifyroom1KeyPressed(evt);
            }
        });

        btn_deletetype.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_deletetype.setText("Delete");
        btn_deletetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteroom1ActionPerformed(evt);
            }
        });
        btn_deletetype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteroom1KeyPressed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tbl_typeroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_typeroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_typeroomMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_typeroom);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_capacity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bedtype, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_modifytype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_deletetype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_inserttype, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_roomtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_bedtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_inserttype)
                        .addGap(17, 17, 17)
                        .addComponent(btn_modifytype)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_deletetype)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Type Room", jPanel7);

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Num Room");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Floor Number");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description");

        txt_roomsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        txt_floornumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        txt_numroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btn_insertrooms.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_insertrooms.setText("Insert");
        btn_insertrooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertroomsroomActionPerformed(evt);
            }
        });

        btn_modifyrooms.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_modifyrooms.setText("Modify");
        btn_modifyrooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyroomActionPerformed(evt);
            }
        });
        btn_modifyrooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modifyroomKeyPressed(evt);
            }
        });

        btn_deleterooms.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_deleterooms.setText("Delete");
        btn_deleterooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteroomActionPerformed(evt);
            }
        });
        btn_deleterooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteroomKeyPressed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room size");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Room Price");

        txt_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descriptionjTextField4ActionPerformed(evt);
            }
        });

        txt_roomprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roompricejTextField4ActionPerformed(evt);
            }
        });

        tbl_room.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_room.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_roomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_room);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Room Attractive");

        txt_typeroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_typeroomjTextField4ActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Room Type");

        txt_roomattractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roomattractivejTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_typeroom, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel13)
                                .addComponent(jLabel16))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_roomsize, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_floornumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_numroom, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_description, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(txt_roomprice, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(txt_roomattractive, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(111, 111, 111)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_modifyrooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleterooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_insertrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_numroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_insertrooms)
                        .addGap(17, 17, 17)
                        .addComponent(btn_modifyrooms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_deleterooms))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_floornumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_roomsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_roomprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_roomattractive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_typeroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rooms", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteroomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteroomKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteroomKeyPressed

    private void btn_deleteroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteroomActionPerformed

    private void btn_modifyroomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modifyroomKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyroomKeyPressed

    private void btn_modifyroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyroomActionPerformed
        try {
            updateroom();
            GlobalsSingleton.getInstance().cleantableservice(dftabler);
            verifyroom();
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_modifyroomActionPerformed

    private void btn_insertroomsroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertroomsroomActionPerformed
        try {
            insertroom();
            verifyroom();

        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GlobalsSingleton.getInstance().cleantableservice(dftabler);
        cleantexfield();
    }//GEN-LAST:event_btn_insertroomsroomActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void btn_deleteroom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteroom1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteroom1KeyPressed

    private void btn_deleteroom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteroom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteroom1ActionPerformed

    private void btn_modifyroom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modifyroom1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyroom1KeyPressed

    private void btn_modifyroom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyroom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyroom1ActionPerformed

    private void btn_insertroom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertroom1ActionPerformed

        if (txt_roomtype.getText().isEmpty() || txt_capacity.getText().isEmpty() || txt_bedtype.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "you must fill all the fields");
            GlobalsSingleton.getInstance().cleantableservice(dftablert);

        }
        try {
            inserttyperoom();

            GlobalsSingleton.getInstance().cleantableservice(dftablert);
            verifyroom();

        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        GlobalsSingleton.getInstance().cleantableservice(dftablert);

        cleantexfield();


    }//GEN-LAST:event_btn_insertroom1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txt_descriptionjTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descriptionjTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descriptionjTextField4ActionPerformed

    private void txt_roompricejTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roompricejTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roompricejTextField4ActionPerformed

    private void txt_typeroomjTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_typeroomjTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_typeroomjTextField4ActionPerformed

    private void txt_roomattractivejTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roomattractivejTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roomattractivejTextField4ActionPerformed

    private void tbl_typeroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_typeroomMouseClicked

        int select = tbl_typeroom.rowAtPoint(evt.getPoint());
        txt_roomtype.setText(String.valueOf(tbl_typeroom.getValueAt(select, 0)));
        txt_capacity.setText(String.valueOf(tbl_typeroom.getValueAt(select, 1)));
        txt_bedtype.setText(String.valueOf(tbl_typeroom.getValueAt(select, 2)));

    }//GEN-LAST:event_tbl_typeroomMouseClicked

    private void tbl_roomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_roomMouseClicked

        int select = tbl_room.rowAtPoint(evt.getPoint());
        txt_numroom.setText(String.valueOf(tbl_room.getValueAt(select, 0)));
        txt_floornumber.setText(String.valueOf(tbl_room.getValueAt(select, 1)));
        txt_description.setText(String.valueOf(tbl_room.getValueAt(select, 2)));
        txt_roomsize.setText(String.valueOf(tbl_room.getValueAt(select, 3)));
        txt_roomattractive.setText(String.valueOf(tbl_room.getValueAt(select, 4)));
        txt_typeroom.setText(String.valueOf(tbl_room.getValueAt(select, 5)));
        txt_roomprice.setText(String.valueOf(tbl_room.getValueAt(select, 7)));

    }//GEN-LAST:event_tbl_roomMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked

    }//GEN-LAST:event_jScrollPane2MouseClicked

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
            java.util.logging.Logger.getLogger(Rooms.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rooms.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rooms.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rooms.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Rooms().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Rooms.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deleterooms;
    private javax.swing.JButton btn_deletetype;
    private javax.swing.JButton btn_insertrooms;
    private javax.swing.JButton btn_inserttype;
    private javax.swing.JButton btn_modifyrooms;
    private javax.swing.JButton btn_modifytype;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_room;
    private javax.swing.JTable tbl_typeroom;
    private javax.swing.JTextField txt_bedtype;
    private javax.swing.JTextField txt_capacity;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_floornumber;
    private javax.swing.JTextField txt_numroom;
    private javax.swing.JTextField txt_roomattractive;
    private javax.swing.JTextField txt_roomprice;
    private javax.swing.JTextField txt_roomsize;
    private javax.swing.JTextField txt_roomtype;
    private javax.swing.JTextField txt_typeroom;
    // End of variables declaration//GEN-END:variables
}
