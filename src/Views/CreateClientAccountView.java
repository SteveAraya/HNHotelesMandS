
package Views;

import Conectmysql.ConexionDB;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author Steve and Marcos
 */
public class CreateClientAccountView extends javax.swing.JFrame {

    public CreateClientAccountView() {
        initComponents();
    }

    //this method cleans the textFields of the view.
    public void cleanUserTextFields(){
       
        txt_userName.setText("");
        txt_lastName.setText("");
        cbo_Gender.setSelectedIndex(0);
        cbo_UserType.setSelectedIndex(0);
        cbo_coinType.setSelectedIndex(0);
        txt_email.setText("");
        txt_telephone.setText("");
        txt_country.setText("");
        psw_password.setText("");
        psw_confirmPassword.setText("");
        
    }
    
    //this method check the password whith the confirpassword.
    public void checkPassword(String pass, String confirmPass){
        
        if(!pass.equals(confirmPass)){
            
            JOptionPane.showMessageDialog(this, "The PassWord is different, perform the operation again, please. ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            
            psw_password.setText("");
            psw_confirmPassword.setText("");
            this.psw_password.requestFocus();
            
            return;
  
        }
   
    }
    
    //This method say if a character is numeric or not.
    private static boolean isNumeric(char caracter){
        try {
            
        Integer.parseInt(String.valueOf(caracter));
        return true;
        
        } catch (NumberFormatException ex){
            
        return false;
        
        }
    }
    
    //this method confirms the requirements of the key.
    public boolean checkPasswordRequirements(String passwordCheck){
        
        boolean isBad = true;
        
        String chain = "";
        
        char [] ArrayChain;
        
        int accountant = 0;
        
        int longPassword = 0;
        
        chain = passwordCheck;
        
        ArrayChain = chain.toCharArray();

        for( int i = 0; i < ArrayChain.length; i++){
            
            if (isNumeric(ArrayChain[i])){
                
                accountant++;
                
            }
            
            longPassword++;

        }

        if (accountant > 0 && (longPassword >= 6 && longPassword <= 20)){
            
            isBad = false;
    
        }
        
        System.out.println("accountant  " + accountant);
        System.out.println("longPassword  " + longPassword);
        
        return isBad;

    }

    //This method creates a new user account.
    public void createAccount() throws SQLException{

        if (txt_userName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter a NAME to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_userName.requestFocus();
            return;
            
        }
        
        if (txt_lastName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Last Name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_lastName.requestFocus();
            return;
            
        }
        
        if (cbo_Gender.getSelectedItem().toString().equals("Select a Gender")){
            
            JOptionPane.showMessageDialog(this, "You must enter a GENDER to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_Gender.requestFocus();
            return;
            
        }
        
        if (cbo_UserType.getSelectedItem().toString().equals("Select a User Type")){
            
            JOptionPane.showMessageDialog(this, "You must enter a User Type to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_UserType.requestFocus();
            return;
            
        }
        
        if (cbo_coinType.getSelectedItem().toString().equals("Select a Coin Type")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Coint Type to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_UserType.requestFocus();
            return;
            
        }
        
        if (txt_email.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter an Email to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_email.requestFocus();
            return;
            
        }
        
        if (txt_telephone.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Telephone Number to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_telephone.requestFocus();
            return;
            
        }
        
        if (txt_country.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Country to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_telephone.requestFocus();
            return;
            
        }

        if (psw_password.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter a PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.psw_password.requestFocus();
            return;
            
        }
        
        if (psw_confirmPassword.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must confirm the PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.psw_confirmPassword.requestFocus();
            return;
            
        }
        
        String name = txt_userName.getText();
        String lastName = txt_lastName.getText();
        String  gender = cbo_Gender.getSelectedItem().toString();
        String  userType = cbo_UserType.getSelectedItem().toString();
        String  cointType = cbo_coinType.getSelectedItem().toString();
        String email = txt_email.getText();
        int telephone = Integer.parseInt(txt_telephone.getText());
        String country = txt_country.getText();
        
        String pass = "";
        
        char [] password = psw_password.getPassword();
        for( int x = 0; x < password.length; x++){
            
            pass += password[x];
            
        }
        
        String confirmPass = "";
        
        char [] confirmPassword = psw_confirmPassword.getPassword();
        for( int x = 0; x < confirmPassword.length; x++){
            
            confirmPass += confirmPassword[x];
            
        }
        
        checkPassword(pass, confirmPass);
        
        if(checkPasswordRequirements(pass)){
            
            JOptionPane.showMessageDialog(this, "the key does not meet the "
                    + "standards, remember that it must contain a number and "
                    + "must be between 6 and 20 in length",
                        "Error", JOptionPane.ERROR_MESSAGE);
            
            psw_password.setText("");
            psw_confirmPassword.setText("");
            
            this.psw_password.requestFocus();
            
                return;

        }
        
        else{
            
            Connection conect = ConexionDB.Connectdatabase();

            try {
                PreparedStatement insert = conect.prepareStatement("Insert Into "
                        + "newuser(usertype, username, last_name, gender, email, "
                        + "user_password, cellphone, country, coinType)"
                        + "Values(?,?,?,?,?,?,?,?,?)");
                
                insert.setString(1, userType);
                insert.setString(2, name);
                insert.setString(3, lastName);
                insert.setString(4, gender);
                insert.setString(5, email);
                insert.setString(6, pass);
                insert.setInt(7, telephone);
                insert.setString(8, country);
                insert.setString(9, cointType);


                int a = insert.executeUpdate();


            } catch (Exception e) {

                JOptionPane.showMessageDialog(rootPane,"Error");
            }        // TODO 

        }
        
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
        txt_userName = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_Gender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        psw_password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        psw_confirmPassword = new javax.swing.JPasswordField();
        btn_createAccount = new javax.swing.JButton();
        cbo_UserType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_telephone = new javax.swing.JTextField();
        cbo_coinType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_country = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/create-an-account.png"))); // NOI18N

        txt_userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userNameActionPerformed(evt);
            }
        });
        txt_userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userNameKeyPressed(evt);
            }
        });

        txt_lastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lastNameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("User Name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("User last name  ");

        cbo_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Gender", "Male", "Female" }));
        cbo_Gender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_GenderKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("User Email Address");

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("User Password");

        psw_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_passwordKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Confirm Your Password");

        psw_confirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_confirmPasswordKeyPressed(evt);
            }
        });

        btn_createAccount.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_createAccount.setText("Create Your HNHotel Account");
        btn_createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createAccountActionPerformed(evt);
            }
        });
        btn_createAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_createAccountKeyPressed(evt);
            }
        });

        cbo_UserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a User Type", "Client", "Administrator" }));
        cbo_UserType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_UserTypeKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("User Telephone");

        txt_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telephoneKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telephoneKeyPressed(evt);
            }
        });

        cbo_coinType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Coin Type", "Colones", "Dollars", "Euro" }));
        cbo_coinType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_coinTypeKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Country");

        txt_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_countryActionPerformed(evt);
            }
        });
        txt_country.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_countryKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_createAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_lastName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psw_confirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psw_password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_telephone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbo_Gender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbo_UserType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_coinType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_coinType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_UserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(psw_password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psw_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("HNHotels");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel8)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createAccountActionPerformed
        
        try {
            createAccount();
        } catch (SQLException ex) {
            Logger.getLogger(CreateClientAccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_btn_createAccountActionPerformed

    private void txt_userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userNameActionPerformed

    private void txt_userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userNameKeyPressed
        
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_lastName.requestFocus();   
        }
 
    }//GEN-LAST:event_txt_userNameKeyPressed

    private void txt_lastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lastNameKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_Gender.requestFocus();   
        }
  
    }//GEN-LAST:event_txt_lastNameKeyPressed

    private void cbo_GenderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_GenderKeyPressed
      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_UserType.requestFocus();
               
        }
   
    }//GEN-LAST:event_cbo_GenderKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_telephone.requestFocus();
               
        }
        
    }//GEN-LAST:event_txt_emailKeyPressed

    private void psw_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_passwordKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.psw_confirmPassword.requestFocus();
               
        }
  
    }//GEN-LAST:event_psw_passwordKeyPressed

    private void psw_confirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_confirmPasswordKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.btn_createAccount.requestFocus();
               
        }
  
    }//GEN-LAST:event_psw_confirmPasswordKeyPressed

    private void btn_createAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_createAccountKeyPressed

        try {
            createAccount();
        } catch (SQLException ex) {
            Logger.getLogger(CreateClientAccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_btn_createAccountKeyPressed

    private void cbo_UserTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_UserTypeKeyPressed
   
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_email.requestFocus();   
        } 
        
    }//GEN-LAST:event_cbo_UserTypeKeyPressed

    private void txt_telephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telephoneKeyTyped

        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_telephoneKeyTyped

    private void txt_telephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telephoneKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_coinType.requestFocus();
               
        }
        
    }//GEN-LAST:event_txt_telephoneKeyPressed

    private void cbo_coinTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_coinTypeKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_country.requestFocus();
               
        }
        
    }//GEN-LAST:event_cbo_coinTypeKeyPressed

    private void txt_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_countryActionPerformed

    private void txt_countryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_countryKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.psw_password.requestFocus();
               
        }
 
    }//GEN-LAST:event_txt_countryKeyPressed

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
            java.util.logging.Logger.getLogger(CreateClientAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateClientAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateClientAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateClientAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateClientAccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createAccount;
    private javax.swing.JComboBox<String> cbo_Gender;
    private javax.swing.JComboBox<String> cbo_UserType;
    private javax.swing.JComboBox<String> cbo_coinType;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPasswordField psw_confirmPassword;
    private javax.swing.JPasswordField psw_password;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}