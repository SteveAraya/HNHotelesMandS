
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import static Views.MainView.userTypeMenu;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steve and Marcos
 */
public class UserView extends javax.swing.JFrame {

    GlobalsSingleton global = GlobalsSingleton.getInstance();
    Connection conect = ConexionDB.Connectdatabase();
    DefaultTableModel dftables = new DefaultTableModel();
    
    public UserView() throws SQLException {
        initComponents();
        
        showUserType();
        showUserInfo();
        showCards();
        
    }

    //This method show the Card view.
    public static void showCardView() {

        CardView oCardView = new CardView();
        oCardView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oCardView.setLocationRelativeTo(null);
        oCardView.setVisible(true);

    }
    
    //This method show the type user en the view
    public void showUserType() {

        ImageIcon userNormal = new ImageIcon(getClass().getResource("../images/normalUser.png"));
        Icon iconUserNormal = new ImageIcon(userNormal.getImage());

        ImageIcon userAdmin = new ImageIcon(getClass().getResource("../images/adminUser.png"));
        Icon iconUserAdmin = new ImageIcon(userAdmin.getImage());

        GlobalsSingleton global = GlobalsSingleton.getInstance();
        
        if (global.getUserType().equals("Administrator")){
            
            lbl_imageType.setIcon(iconUserAdmin);

        }
        
        else{

            lbl_imageType.setIcon(iconUserNormal);
            
        }

    }
    
    //This method show the information about the user
    public void showUserInfo(){
        
        txt_name.setText(global.getUserName());
        txt_lastName.setText(global.getUserLastName());
        txt_gender.setText(global.getUserGender());
        txt_email.setText(global.getUserEmail());
        txt_telephone.setText(String.valueOf(global.getUserTelephone()));
        txt_type.setText(global.getUserType());
        txt_country.setText(global.getCountry());
        txt_currencyType.setText(global.getCurrencyType());
        
        txt_name.setEditable(false);
        txt_lastName.setEditable(false);
        txt_gender.setEditable(false);
        txt_email.setEditable(false);
        txt_telephone.setEditable(false);
        txt_country.setEditable(false);
        txt_currencyType.setEditable(false);
        btn_change.setEnabled(false);
        cbo_coinType.setEnabled(false);
        
        txt_type.setEditable(false);
        txt_type.setHorizontalAlignment(JTextField.CENTER);
   
    }
    
    //This method show to the user the info that this can change
    public void showInfoEdit(){
        
        txt_country.setEditable(true);
        txt_telephone.setEditable(true);
        cbo_coinType.setEnabled(true);
        btn_change.setEnabled(true);
        jP_changes.setBackground(Color.CYAN);
 
    }
    
    //This method show all the cards that the user has.
    public void showCards() throws SQLException {

        String urlhotelverify = "SELECT * FROM card";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet resultservice = selectconect.executeQuery(urlhotelverify);
        tbl_cards.setModel(dftables);
        dftables.setColumnIdentifiers(new Object[]{"Card Type", "Card Number", "Security Code", "Month Expiration", "Year Expiration"});

        try {
            while (resultservice.next()) {
                
                serviceverification = resultservice.getInt("id_user");

                if (serviceverification == (GlobalsSingleton.getInstance().getUserID())) {
                    try {
                        while (resultservice.next()) {
                            
                            dftables.addRow(new Object[]{resultservice.getString("card_type"),
                                resultservice.getString("cardnumber"),
                                resultservice.getString("secury_code"),
                                resultservice.getString("expirationmount"),
                                resultservice.getString("expirationyear")});

                        }
                    } catch (SQLException e) {

                    }

                } 
                
            }
            
        } 
        
        catch (SQLException e) {

        }
    }
    
    //This method save the changes that the user do it
    public void editInfo() throws SQLException {
        
        if (cbo_coinType.getSelectedItem().toString().equals("Select a Coin Type")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Coint Type to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_coinType.requestFocus();
            return;
            
        }
        
        if (txt_country.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Country to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_telephone.requestFocus();
            return;
            
        }
        
        if (txt_telephone.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Telephone Number to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_telephone.requestFocus();
            return;
            
        }

        String country = txt_country.getText();
        int telephone = Integer.parseInt(txt_telephone.getText());
        String  cointType = cbo_coinType.getSelectedItem().toString();
        

        try {
            String url=("update newuser SET cellphone=?,country=?,cointype=?"
                    +"where id_user= "+GlobalsSingleton.getInstance().getUserID()+" " );
           
            
            PreparedStatement inserthotel = conect.prepareStatement(url);
            inserthotel.setInt(1, telephone);
            inserthotel.setString(2, country);
            inserthotel.setString(3, cointType);

        
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                              + "Inténtelo nuevamente.\n"
                                              + "Error: "+e, "Error en la operación", 
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_lastName = new javax.swing.JTextField();
        lbl_imageType = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_gender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_type = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cards = new javax.swing.JTable();
        btn_addCard = new javax.swing.JButton();
        btn_userEdit = new javax.swing.JButton();
        btn_change = new javax.swing.JButton();
        jP_changes = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_country = new javax.swing.JTextField();
        cbo_coinType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_telephone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_currencyType = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("User Name");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("User Last Name");

        txt_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("User Gender");

        txt_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_genderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("User Email");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        txt_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_typeActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Credit Cards");

        tbl_cards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Card Type", "Card Number", "Security Code ", "Month Expiration", "Year Expiration"
            }
        ));
        jScrollPane1.setViewportView(tbl_cards);

        btn_addCard.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_addCard.setText("Add Credit Card");
        btn_addCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(btn_addCard))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_addCard)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_userEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UserEdit.png"))); // NOI18N
        btn_userEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userEditActionPerformed(evt);
            }
        });

        btn_change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        btn_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeActionPerformed(evt);
            }
        });

        jP_changes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Country");

        txt_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_countryActionPerformed(evt);
            }
        });

        cbo_coinType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Coin Type", "Colones", "Dollars", "Euro" }));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("User Telephone");

        txt_telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telephoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_changesLayout = new javax.swing.GroupLayout(jP_changes);
        jP_changes.setLayout(jP_changesLayout);
        jP_changesLayout.setHorizontalGroup(
            jP_changesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_changesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_changesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_changesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_country))
                    .addGroup(jP_changesLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(cbo_coinType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_changesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_telephone)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_changesLayout.setVerticalGroup(
            jP_changesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_changesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_changesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_changesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_coinType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Currency Type ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_imageType, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(txt_gender)
                            .addComponent(txt_lastName)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_email)
                            .addComponent(jLabel1)
                            .addComponent(txt_currencyType))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_userEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jP_changes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_change)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_imageType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_userEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_currencyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_change))
                            .addComponent(jP_changes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastNameActionPerformed

    private void txt_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_genderActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telephoneActionPerformed

    private void txt_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_typeActionPerformed

    private void btn_userEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userEditActionPerformed
           
        showInfoEdit();
   
    }//GEN-LAST:event_btn_userEditActionPerformed

    private void txt_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_countryActionPerformed

    private void btn_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeActionPerformed
    
        
        
        
        
        
        
        
        
        
        jP_changes.setBackground(Color.WHITE);
        
    }//GEN-LAST:event_btn_changeActionPerformed

    private void btn_addCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCardActionPerformed

        showCardView();
            
    }//GEN-LAST:event_btn_addCardActionPerformed

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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCard;
    private javax.swing.JButton btn_change;
    private javax.swing.JButton btn_userEdit;
    private javax.swing.JComboBox<String> cbo_coinType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jP_changes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imageType;
    public static javax.swing.JTable tbl_cards;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_currencyType;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_type;
    // End of variables declaration//GEN-END:variables
}