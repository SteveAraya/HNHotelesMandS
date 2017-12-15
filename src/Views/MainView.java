/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steve and Marcos
 */
public class MainView extends javax.swing.JFrame {

    GlobalsSingleton global = GlobalsSingleton.getInstance();
    Connection conect = ConexionDB.Connectdatabase();
    DefaultTableModel dftables = new DefaultTableModel();

    public MainView() {
        initComponents();
        blockItems();

    }

    //This method show the Log In view.
    public static void showLogIn() {

        LogInView oLogInView = new LogInView();
        oLogInView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oLogInView.setLocationRelativeTo(null);
        oLogInView.setVisible(true);

    }

    //This method show the Create Account view.
    public static void showCreateAccount() {

        CreateClientAccountView oCreateAccount = new CreateClientAccountView();
        oCreateAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oCreateAccount.setLocationRelativeTo(null);
        oCreateAccount.setVisible(true);

    }

    //This method show the User view.
    public static void showUserView() throws SQLException {

        UserView oUserView = new UserView();
        oUserView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oUserView.setLocationRelativeTo(null);
        oUserView.setVisible(true);

    }

    //This method show the Create Hotel view.
    public static void showCreateHotel() throws SQLException {

        CreateHotel oCreateHotel = new CreateHotel();
        oCreateHotel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oCreateHotel.setLocationRelativeTo(null);
        oCreateHotel.setVisible(true);

    }

    //This method show the Hotel view.
    public static void showHotel() throws SQLException {

        HotelView oHotelView = new HotelView();
        oHotelView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oHotelView.setLocationRelativeTo(null);
        oHotelView.setVisible(true);

    }

    //This method show the Queries view.
    public static void showQuery() {

        QueriesView oQueriesView = new QueriesView();
        oQueriesView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oQueriesView.setLocationRelativeTo(null);
        oQueriesView.setVisible(true);

    }

    //This method show the Queries view.
    public static void showReservation() throws SQLException {

        ReservationsView oReservationsView = new ReservationsView();
        oReservationsView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oReservationsView.setLocationRelativeTo(null);
        oReservationsView.setVisible(true);

    }

    //This method block the Items of the main view.
    public void blockItems() {

        txt_entrydate.setEnabled(false);
        txt_exitdate.setEnabled(false);

        ((DefaultEditor) sp_roomAmount.getEditor()).getTextField().setEditable(false);
        sp_roomAmount.setEnabled(false);

        ((DefaultEditor) sp_adultAmount.getEditor()).getTextField().setEditable(false);
        sp_adultAmount.setEnabled(false);

        ((DefaultEditor) sp_childremAmount.getEditor()).getTextField().setEditable(false);
        sp_childremAmount.setEnabled(false);

        searchButton.setEnabled(false);
        seeHotelButton.setEnabled(false);
        selectHotelButton.setEnabled(false);

        userProfileViewMenu.setEnabled(false);
        modifyUserMenu.setEnabled(false);
        createHotelMenu.setEnabled(false);
        userTypeMenu.setEnabled(false);

        entryDateLabel.setText("HN Hotels");
        exitDateLabel.setText("HN Hotels");
        roomAmountLabel.setText("HN Hotels");
        adultAmountjLabel.setText("HN Hotels");
        childremAmountjLabel.setText("HN Hotels");

    }

    //This method enable the Items of the main view.
    public void enableItems() {

        txt_entrydate.setEnabled(true);
        txt_exitdate.setEnabled(true);

        ((DefaultEditor) sp_roomAmount.getEditor()).getTextField().setEditable(true);
        sp_roomAmount.setEnabled(true);

        ((DefaultEditor) sp_adultAmount.getEditor()).getTextField().setEditable(true);
        sp_adultAmount.setEnabled(true);

        ((DefaultEditor) sp_childremAmount.getEditor()).getTextField().setEditable(true);
        sp_childremAmount.setEnabled(true);

        searchButton.setEnabled(true);

        entryDateLabel.setText("Entry Date");
        exitDateLabel.setText("Exit Date");
        roomAmountLabel.setText("Room Amount");
        adultAmountjLabel.setText("Adult Amount");
        childremAmountjLabel.setText("Children Amount");

    }

    //This method clean the values of the search
    public void cleanValues() {

        sp_roomAmount.setModel(new javax.swing.SpinnerNumberModel());
        sp_adultAmount.setModel(new javax.swing.SpinnerNumberModel());
        sp_childremAmount.setModel(new javax.swing.SpinnerNumberModel());
        txt_entrydate.setText("");
        txt_exitdate.setText("");

    }

    //This method cleans the Hotels Table. This is done to re-insert the data and not to repeat the data.
    //This method search all the hoteles that the program has
    public void searchHotels() throws SQLException {

        int roomAmount = Integer.parseInt(sp_roomAmount.getValue().toString());
        int adultAmount = Integer.parseInt(sp_adultAmount.getValue().toString());
        int childremAmount = Integer.parseInt(sp_childremAmount.getValue().toString());
        String entryDate = txt_entrydate.getText();
        String exitDate = txt_exitdate.getText();

        String urlhotelverify = "SELECT * FROM hotel ORDER BY starnumbers DESC;";

        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_Hotels.setModel(dftables);
        dftables.setColumnIdentifiers(new Object[]{"Hotel Name", "Number of Stars", "Lodging Type"});

        try {

            while (resultservice.next()) {

                dftables.addRow(new Object[]{resultservice.getString("hotel_name"),
                    resultservice.getString("starnumbers"),
                    resultservice.getString("lodgingtype")});

            }

        } catch (SQLException e) {

        }

    }

    //This method select the hotel that the user wants to watch
    public void selectRows() {

        int row = tbl_Hotels.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this, "Select one Hotel Please.",
                    "Empty fields", JOptionPane.WARNING_MESSAGE);

            return;

        } else {

            String hotelName = tbl_Hotels.getValueAt(row, 0).toString();

            global.setHotelName(hotelName);

        }

    }

    //This method verify if the user is active or not
    public void verifyUser() {

        if (global.getUserCondition().equals("Inactive")) {

            Icon blueIcon = new ImageIcon("yourFile.gif");
            Object[] options = {"Create an Account", "Initiate Session"};
            int choice = JOptionPane.showOptionDialog(null,
                    "You must initiate secion and if you do not have an account you must create one.",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    blueIcon,
                    options,
                    options[0]);

            if (choice == JOptionPane.YES_OPTION) {

                showCreateAccount();

            } else {

                showLogIn();

            }

        }

    }

    public void selectdata() {
        
        int adultamount=(int) sp_adultAmount.getValue();
        int childrenamount=(int) sp_adultAmount.getValue();
        int roomnamount=(int) sp_adultAmount.getValue();
        String entry=txt_entrydate.getText();
        String exit=txt_exitdate.getText();
        
        global.setAdultAmount(adultamount);
        global.setChildremAmount(childrenamount);
        global.setRoomAmount(roomnamount);

        global.setEntryDate(entry);
        global.setExitDate(exit);

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
        searchPanel = new javax.swing.JPanel();
        entryDateLabel = new javax.swing.JLabel();
        exitDateLabel = new javax.swing.JLabel();
        roomAmountLabel = new javax.swing.JLabel();
        adultAmountjLabel = new javax.swing.JLabel();
        childremAmountjLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        sp_roomAmount = new javax.swing.JSpinner();
        sp_adultAmount = new javax.swing.JSpinner();
        sp_childremAmount = new javax.swing.JSpinner();
        txt_entrydate = new javax.swing.JTextField();
        txt_exitdate = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Hotels = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        seeHotelButton = new javax.swing.JButton();
        selectHotelButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        searchMenu = new javax.swing.JMenu();
        searchHotelMenuItem = new javax.swing.JMenuItem();
        logInMenu = new javax.swing.JMenu();
        logInMenuItem = new javax.swing.JMenuItem();
        createAccountMenu = new javax.swing.JMenu();
        createUserAccountMenuItem = new javax.swing.JMenuItem();
        userProfileViewMenu = new javax.swing.JMenu();
        userProfileMenuItem = new javax.swing.JMenuItem();
        modifyUserMenu = new javax.swing.JMenu();
        queriesMenuItem = new javax.swing.JMenuItem();
        createHotelMenu = new javax.swing.JMenu();
        createHotelMenuItem = new javax.swing.JMenuItem();
        userTypeMenu = new javax.swing.JMenu();
        userActiveInactiveMenu = new javax.swing.JMenu();
        closeMenu = new javax.swing.JMenu();
        closeProgramMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));

        entryDateLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        entryDateLabel.setText("Entry Date");

        exitDateLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        exitDateLabel.setText("Exit Date");

        roomAmountLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        roomAmountLabel.setText("Room Amount");

        adultAmountjLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        adultAmountjLabel.setText("Adult Amount");

        childremAmountjLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        childremAmountjLabel.setText("Children Amount");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchHotel.png"))); // NOI18N

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchButtonKeyPressed(evt);
            }
        });

        txt_entrydate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_entrydateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(exitDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entryDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roomAmountLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(adultAmountjLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(childremAmountjLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addComponent(sp_adultAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sp_roomAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_childremAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_entrydate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_exitdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entryDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_entrydate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(exitDateLabel)
                .addGap(18, 18, 18)
                .addComponent(txt_exitdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roomAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp_roomAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adultAmountjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp_adultAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(childremAmountjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp_childremAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel7))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Hotels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hotel Name", "Number of Stars", "Lodging Type"
            }
        ));
        jScrollPane1.setViewportView(tbl_Hotels);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchHotel.png"))); // NOI18N

        seeHotelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seeHotel.png"))); // NOI18N
        seeHotelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeHotelButtonActionPerformed(evt);
            }
        });

        selectHotelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectHotel.png"))); // NOI18N
        selectHotelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHotelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seeHotelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectHotelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(seeHotelButton)
                        .addGap(18, 18, 18)
                        .addComponent(selectHotelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        searchMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/serch.png"))); // NOI18N

        searchHotelMenuItem.setText("Search Hotel");
        searchHotelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHotelMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(searchHotelMenuItem);

        jMenuBar1.add(searchMenu);

        logInMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_login.png"))); // NOI18N

        logInMenuItem.setText("User Log-In");
        logInMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInMenuItemActionPerformed(evt);
            }
        });
        logInMenu.add(logInMenuItem);

        jMenuBar1.add(logInMenu);

        createAccountMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/create-an-account.png"))); // NOI18N

        createUserAccountMenuItem.setText("Create User Account");
        createUserAccountMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserAccountMenuItemActionPerformed(evt);
            }
        });
        createAccountMenu.add(createUserAccountMenuItem);

        jMenuBar1.add(createAccountMenu);

        userProfileViewMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N

        userProfileMenuItem.setText("User Profile");
        userProfileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userProfileMenuItemActionPerformed(evt);
            }
        });
        userProfileViewMenu.add(userProfileMenuItem);

        jMenuBar1.add(userProfileViewMenu);

        modifyUserMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/queryView.png"))); // NOI18N

        queriesMenuItem.setText("Queries View");
        queriesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queriesMenuItemActionPerformed(evt);
            }
        });
        modifyUserMenu.add(queriesMenuItem);

        jMenuBar1.add(modifyUserMenu);

        createHotelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/887169_home_512x512.png"))); // NOI18N

        createHotelMenuItem.setText("Create Hotel");
        createHotelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createHotelMenuItemActionPerformed(evt);
            }
        });
        createHotelMenu.add(createHotelMenuItem);

        jMenuBar1.add(createHotelMenu);

        userTypeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/normalUser.png"))); // NOI18N
        jMenuBar1.add(userTypeMenu);

        userActiveInactiveMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inactiveUser.png"))); // NOI18N
        jMenuBar1.add(userActiveInactiveMenu);

        closeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N

        closeProgramMenuItem.setText("Close the Program");
        closeProgramMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeProgramMenuItemActionPerformed(evt);
            }
        });
        closeMenu.add(closeProgramMenuItem);

        jMenuBar1.add(closeMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchHotelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHotelMenuItemActionPerformed

        enableItems();
        this.txt_entrydate.requestFocus();

    }//GEN-LAST:event_searchHotelMenuItemActionPerformed

    private void logInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInMenuItemActionPerformed

        showLogIn();

    }//GEN-LAST:event_logInMenuItemActionPerformed

    private void queriesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queriesMenuItemActionPerformed

        showQuery();

    }//GEN-LAST:event_queriesMenuItemActionPerformed

    private void userProfileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userProfileMenuItemActionPerformed

        try {
            showUserView();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_userProfileMenuItemActionPerformed

    private void closeProgramMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeProgramMenuItemActionPerformed


    }//GEN-LAST:event_closeProgramMenuItemActionPerformed

    private void createUserAccountMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserAccountMenuItemActionPerformed

        showCreateAccount();

    }//GEN-LAST:event_createUserAccountMenuItemActionPerformed

    private void createHotelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createHotelMenuItemActionPerformed

        try {

            showCreateHotel();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_createHotelMenuItemActionPerformed

    private void seeHotelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeHotelButtonActionPerformed

        try {
            selectRows();
            showHotel();

        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_seeHotelButtonActionPerformed

    private void selectHotelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHotelButtonActionPerformed
        // TODO add your handling code here:

        selectRows();
        verifyUser();

    }//GEN-LAST:event_selectHotelButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        try {
            GlobalsSingleton.getInstance().cleantableservice(dftables);
            selectdata();
            searchHotels();
            seeHotelButton.setEnabled(true);
            selectHotelButton.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchButtonKeyPressed

        try {
            GlobalsSingleton.getInstance().cleantableservice(dftables);
            searchHotels();
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_searchButtonKeyPressed

    private void entryjDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entryjDateChooserKeyPressed


    }//GEN-LAST:event_entryjDateChooserKeyPressed

    private void exitjDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitjDateChooserKeyPressed


    }//GEN-LAST:event_exitjDateChooserKeyPressed

    private void txt_entrydateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_entrydateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_entrydateActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adultAmountjLabel;
    private javax.swing.JLabel childremAmountjLabel;
    private javax.swing.JMenu closeMenu;
    private javax.swing.JMenuItem closeProgramMenuItem;
    private javax.swing.JMenu createAccountMenu;
    public static javax.swing.JMenu createHotelMenu;
    private javax.swing.JMenuItem createHotelMenuItem;
    private javax.swing.JMenuItem createUserAccountMenuItem;
    private javax.swing.JLabel entryDateLabel;
    private javax.swing.JLabel exitDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logInMenu;
    private javax.swing.JMenuItem logInMenuItem;
    public static javax.swing.JMenu modifyUserMenu;
    private javax.swing.JMenuItem queriesMenuItem;
    private javax.swing.JLabel roomAmountLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JMenuItem searchHotelMenuItem;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton seeHotelButton;
    private javax.swing.JButton selectHotelButton;
    public static javax.swing.JSpinner sp_adultAmount;
    public static javax.swing.JSpinner sp_childremAmount;
    public static javax.swing.JSpinner sp_roomAmount;
    private javax.swing.JTable tbl_Hotels;
    private javax.swing.JTextField txt_entrydate;
    private javax.swing.JTextField txt_exitdate;
    public static javax.swing.JMenu userActiveInactiveMenu;
    public static javax.swing.JMenuItem userProfileMenuItem;
    public static javax.swing.JMenu userProfileViewMenu;
    public static javax.swing.JMenu userTypeMenu;
    // End of variables declaration//GEN-END:variables
}
