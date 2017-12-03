
package Views;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos and Steve
 */
public class CreateHotel extends javax.swing.JFrame {

    /**
     * Creates new form LogInView
     */
    public CreateHotel() {
        initComponents();
    }

    //this method cleans the textFields of the view.
    public void cleanUserTextFields(){
       
        txt_hotelName.setText("");
        txt_ubication.setText("");
        txt_Adminemail.setText("");
        psw_adminpassword.setText("");
        psw_adminconfirmPassword.setText("");
        txt_HotelSize.setText("");
    
    }
    
    
    public void checkPassword(String pass, String confirmPass){
        
        if(!pass.equals(confirmPass)){
            
            JOptionPane.showMessageDialog(this, "The PassWord is different, perform the operation again, please. ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            
            psw_adminpassword.setText("");
            psw_adminconfirmPassword.setText("");
            this.psw_adminpassword.requestFocus();
            
                return;
  
        }
   
    }

    //This method creates a new user account.
    public void createAccount(){

        if (txt_hotelName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a NAME to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_hotelName.requestFocus();
            return;
            
        }
        
        if (txt_ubication.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Last Name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_ubication.requestFocus();
            return;
            
        }
        
        if (txt_HotelSize.getText().equals("Select a Gender")){
            
            JOptionPane.showMessageDialog(this, "You must define an GENDER to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_HotelSize.requestFocus();
            return;
            
        }
        
        if (txt_Adminemail.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define an Email to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_Adminemail.requestFocus();
            return;
            
        }

        if (psw_adminpassword.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.psw_adminpassword.requestFocus();
            return;
            
        }
        
        if (psw_adminconfirmPassword.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must confirm the PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.psw_adminconfirmPassword.requestFocus();
            return;
            
        }
        
        String name = txt_hotelName.getText();
        String lastName = txt_ubication.getText();
        String  hotelsize = txt_HotelSize.getText();
        String email = txt_Adminemail.getText();
        
        String pass = "";
        
        char [] password = psw_adminpassword.getPassword();
        for( int x = 0; x < password.length; x++){
            
            pass+=password[x];
            
        }
        
        String confirmPass = "";
        
        char [] confirmPassword = psw_adminconfirmPassword.getPassword();
        for( int x = 0; x < confirmPassword.length; x++){
            
            confirmPass+=confirmPassword[x];
            
        }
        
        
        checkPassword(pass, confirmPass);
       
        
        
        
        
        
        
        
        
        
        

//Este if verifica el email, si el email esta ya registrado en la base de datos, entonces se prodece a informar al 
//usuario que ese email ya esta en uso.
//        if(){
//            
//            JOptionPane.showMessageDialog(this, "The Email " + emailTextField.getText() + 
//                        " is already used in another account",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//            
//            emailTextField.setText("");
//            this.emailTextField.requestFocus();
//            
//                return;
// 
//        }
        

//Este else es para cuando no existe el email, entonces se procede a crear la nueva cuenta de usuario
//        else{
//   
//
//  
//        }
        
//        this.dispose();
   
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
        txt_hotelName = new javax.swing.JTextField();
        txt_ubication = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Adminemail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        psw_adminpassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        psw_adminconfirmPassword = new javax.swing.JPasswordField();
        btn_createAccount = new javax.swing.JButton();
        txt_telephone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_HotelSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/887169_home_512x512.png"))); // NOI18N
        jLabel1.setFocusable(false);

        txt_hotelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hotelNameActionPerformed(evt);
            }
        });
        txt_hotelName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hotelNameKeyPressed(evt);
            }
        });

        txt_ubication.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ubicationKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Hotel Name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Telephone Number");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Admin Email Address");

        txt_Adminemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AdminemailKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("User Password");

        psw_adminpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_adminpasswordKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Confirm Your Password");

        psw_adminconfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_adminconfirmPasswordKeyPressed(evt);
            }
        });

        btn_createAccount.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_createAccount.setText("Create Your Admin HNHotel Account");
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

        txt_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telephoneKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Ubication");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Construction Year");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("Hotel Size");

        txt_HotelSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HotelSizeActionPerformed(evt);
            }
        });
        txt_HotelSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_HotelSizeKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("m² ");

        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(267, 267, 267)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_hotelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                        .addComponent(txt_ubication, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(psw_adminconfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_telephone, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Adminemail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(psw_adminpassword, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(118, 118, 118)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_HotelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 99, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(btn_createAccount)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_HotelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ubication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Adminemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psw_adminpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psw_adminconfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btn_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("HNHotels");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createAccountActionPerformed
        
        createAccount();
   
    }//GEN-LAST:event_btn_createAccountActionPerformed

    private void txt_hotelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hotelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hotelNameActionPerformed

    private void txt_hotelNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hotelNameKeyPressed
        
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_ubication.requestFocus();   
        }
 
    }//GEN-LAST:event_txt_hotelNameKeyPressed

    private void txt_ubicationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ubicationKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_HotelSize.requestFocus();   
        }
  
    }//GEN-LAST:event_txt_ubicationKeyPressed

    private void txt_AdminemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AdminemailKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.psw_adminpassword.requestFocus();
               
        }
        
    }//GEN-LAST:event_txt_AdminemailKeyPressed

    private void psw_adminpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_adminpasswordKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.psw_adminconfirmPassword.requestFocus();
               
        }
  
    }//GEN-LAST:event_psw_adminpasswordKeyPressed

    private void psw_adminconfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_adminconfirmPasswordKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.btn_createAccount.requestFocus();
               
        }
  
    }//GEN-LAST:event_psw_adminconfirmPasswordKeyPressed

    private void btn_createAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_createAccountKeyPressed
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btn_createAccountKeyPressed

    private void txt_telephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telephoneKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telephoneKeyPressed

    private void txt_HotelSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HotelSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HotelSizeActionPerformed

    private void txt_HotelSizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HotelSizeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HotelSizeKeyPressed

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
            java.util.logging.Logger.getLogger(CreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CreateHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPasswordField psw_adminconfirmPassword;
    private javax.swing.JPasswordField psw_adminpassword;
    private javax.swing.JTextField txt_Adminemail;
    private javax.swing.JTextField txt_HotelSize;
    private javax.swing.JTextField txt_hotelName;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_ubication;
    // End of variables declaration//GEN-END:variables
}
