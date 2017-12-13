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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Steve and Marcos
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
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
    public static void showUserView() {

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
    public static void showHotel() {

        HotelView oHotelView = new HotelView();
        oHotelView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oHotelView.setLocationRelativeTo(null);
        oHotelView.setVisible(true);

    }

    //This method block the Items of the main view.
    public void blockItems() {

        entryjDateChooser.setEnabled(false);
        exitjDateChooser.setEnabled(false);

        ((DefaultEditor) roomAmountjSpinner.getEditor()).getTextField().setEditable(false);
        roomAmountjSpinner.setEnabled(false);

        ((DefaultEditor) adultAmountjSpinner.getEditor()).getTextField().setEditable(false);
        adultAmountjSpinner.setEnabled(false);

        ((DefaultEditor) childremAmountjSpinner.getEditor()).getTextField().setEditable(false);
        childremAmountjSpinner.setEnabled(false);

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

        entryjDateChooser.setEnabled(true);
        exitjDateChooser.setEnabled(true);

        ((DefaultEditor) roomAmountjSpinner.getEditor()).getTextField().setEditable(true);
        roomAmountjSpinner.setEnabled(true);

        ((DefaultEditor) adultAmountjSpinner.getEditor()).getTextField().setEditable(true);
        adultAmountjSpinner.setEnabled(true);

        ((DefaultEditor) childremAmountjSpinner.getEditor()).getTextField().setEditable(true);
        childremAmountjSpinner.setEnabled(true);

        searchButton.setEnabled(true);
        seeHotelButton.setEnabled(true);
        selectHotelButton.setEnabled(true);

        entryDateLabel.setText("Entry Date");
        exitDateLabel.setText("Exit Date");
        roomAmountLabel.setText("Room Amount");
        adultAmountjLabel.setText("Adult Amount");
        childremAmountjLabel.setText("Children Amount");

    }

    public void cleanjSpinner() {
//        roomAmountjSpinner.
//        adultAmountjSpinner.
//        childremAmountjSpinner.

    }



    //This method obtains the position of the tree.
    //Tengo que hacerlo para que la base de datos
//    public int getNumberOfRow(){
//        
//            int numRow = 0;
//            
//            while(tempTree.getTreeNext() != firstTree){
//                numRow += 1;
//                tempTree = tempTree.getTreeNext();
//            }
//            
//            return 1 + numRow;
//            
//        }
//    
//    }


    public void searchHotels() {

        //ver que putas recibe un spiner
//        if (roomAmountjSpinner.getText().equals("")){
//            
//            JOptionPane.showMessageDialog(this, "You must define an amount of rooms to search hotels",
//                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
//            this.roomAmountjSpinner.requestFocus();
//            return;
//            
//        }
//        if (adultAmountjSpinner.getText().equals("")){
//            
//            JOptionPane.showMessageDialog(this, "You must define an amount of adults to search hotels",
//                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
//            this.adultAmountjSpinner.requestFocus();
//            return;
//            
//        }
//        if (childremAmountjSpinner.getText().equals("")){
//            
//            JOptionPane.showMessageDialog(this, "You must define an amount of childrem to search hotels",
//                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
//            this.childremAmountjSpinner.requestFocus();
//            return;
//            
//        }

//        String Table[][] = new String[getNumberOfRow()][2]; 
//            
//            int fila = 0;
//            
//            while(tempTree.getTreeNext() != firstTree){
//                
//                Table[fila][0] = String.valueOf(tempTree.getTreeID());
//                Table[fila][1] = tempTree.getTopicDescription();
//                fila+=1;
//                tempTree = tempTree.getTreeNext();
//  
//            }
//            
//            Table[fila][0] = String.valueOf(tempTree.getTreeID());
//            Table[fila][1] = tempTree.getTopicDescription();
//            
//            
//               treeTable.setModel(new javax.swing.table.DefaultTableModel(
//                Table,
//                new String[]{
//                    "Numerical identifier", "Description of the topic"
//                        
//                }











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
        roomAmountjSpinner = new javax.swing.JSpinner();
        adultAmountjSpinner = new javax.swing.JSpinner();
        childremAmountjSpinner = new javax.swing.JSpinner();
        entryjDateChooser = new com.toedter.calendar.JDateChooser();
        exitjDateChooser = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        editUserMenuItem = new javax.swing.JMenuItem();
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
                        .addComponent(adultAmountjSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roomAmountjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(childremAmountjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entryjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entryDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(exitDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roomAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomAmountjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adultAmountjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adultAmountjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(childremAmountjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(childremAmountjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel7))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hotel Name", "Price Per Night", "Number of Stars", "Lodging Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        modifyUserMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UserEdit.png"))); // NOI18N

        editUserMenuItem.setText("Edit User");
        editUserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserMenuItemActionPerformed(evt);
            }
        });
        modifyUserMenu.add(editUserMenuItem);

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
        this.entryjDateChooser.requestFocus();

    }//GEN-LAST:event_searchHotelMenuItemActionPerformed

    private void logInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInMenuItemActionPerformed

        showLogIn();

    }//GEN-LAST:event_logInMenuItemActionPerformed

    private void editUserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserMenuItemActionPerformed


    }//GEN-LAST:event_editUserMenuItemActionPerformed

    private void userProfileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userProfileMenuItemActionPerformed

        showUserView();

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

        showHotel();


    }//GEN-LAST:event_seeHotelButtonActionPerformed

    private void selectHotelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHotelButtonActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
        
    }//GEN-LAST:event_selectHotelButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        searchHotels();


    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchButtonKeyPressed

        searchHotels();


    }//GEN-LAST:event_searchButtonKeyPressed

    private void entryjDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entryjDateChooserKeyPressed


    }//GEN-LAST:event_entryjDateChooserKeyPressed

    private void exitjDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitjDateChooserKeyPressed


    }//GEN-LAST:event_exitjDateChooserKeyPressed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adultAmountjLabel;
    private javax.swing.JSpinner adultAmountjSpinner;
    private javax.swing.JLabel childremAmountjLabel;
    private javax.swing.JSpinner childremAmountjSpinner;
    private javax.swing.JMenu closeMenu;
    private javax.swing.JMenuItem closeProgramMenuItem;
    private javax.swing.JMenu createAccountMenu;
    public static javax.swing.JMenu createHotelMenu;
    private javax.swing.JMenuItem createHotelMenuItem;
    private javax.swing.JMenuItem createUserAccountMenuItem;
    private javax.swing.JMenuItem editUserMenuItem;
    private javax.swing.JLabel entryDateLabel;
    private com.toedter.calendar.JDateChooser entryjDateChooser;
    private javax.swing.JLabel exitDateLabel;
    private com.toedter.calendar.JDateChooser exitjDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu logInMenu;
    private javax.swing.JMenuItem logInMenuItem;
    public static javax.swing.JMenu modifyUserMenu;
    private javax.swing.JLabel roomAmountLabel;
    private javax.swing.JSpinner roomAmountjSpinner;
    private javax.swing.JButton searchButton;
    private javax.swing.JMenuItem searchHotelMenuItem;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton seeHotelButton;
    private javax.swing.JButton selectHotelButton;
    public static javax.swing.JMenu userActiveInactiveMenu;
    public static javax.swing.JMenuItem userProfileMenuItem;
    public static javax.swing.JMenu userProfileViewMenu;
    public static javax.swing.JMenu userTypeMenu;
    // End of variables declaration//GEN-END:variables
}