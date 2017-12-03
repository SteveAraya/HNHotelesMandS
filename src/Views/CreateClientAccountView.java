
package Views;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos and Steve
 */
public class CreateClientAccountView extends javax.swing.JFrame {

    /**
     * Creates new form LogInView
     */
    public CreateClientAccountView() {
        initComponents();
    }

    //this method cleans the textFields of the view.
    public void cleanUserTextFields(){
       
        txt_userName.setText("");
        txt_lastName.setText("");
        cbo_Gender.setSelectedIndex(0);
        txt_email.setText("");
        psw_password.setText("");
        psw_confirmPassword.setText("");
    
    }
    
    
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

    //This method creates a new user account.
    public void createAccount(){

        if (txt_userName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a NAME to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_userName.requestFocus();
            return;
            
        }
        
        if (txt_lastName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Last Name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_lastName.requestFocus();
            return;
            
        }
        
        if (cbo_Gender.getSelectedItem().toString().equals("Select a Gender")){
            
            JOptionPane.showMessageDialog(this, "You must define an GENDER to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_Gender.requestFocus();
            return;
            
        }
        
        if (txt_email.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define an Email to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_email.requestFocus();
            return;
            
        }

        if (psw_password.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PASSWORD to create an account",
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
        String email = txt_email.getText();
        
        String pass = "";
        
        char [] password = psw_password.getPassword();
        for( int x = 0; x < password.length; x++){
            
            pass+=password[x];
            
        }
        
        String confirmPass = "";
        
        char [] confirmPassword = psw_confirmPassword.getPassword();
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_lastName)
                    .addComponent(txt_userName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_email)
                    .addComponent(psw_password)
                    .addComponent(psw_confirmPassword)
                    .addComponent(btn_createAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cbo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(26, 26, 26)
                .addComponent(cbo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psw_password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psw_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_createAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("HNHotels");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(178, 178, 178))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            
            this.txt_email.requestFocus();
               
        }
   
    }//GEN-LAST:event_cbo_GenderKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.psw_password.requestFocus();
               
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
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btn_createAccountKeyPressed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField psw_confirmPassword;
    private javax.swing.JPasswordField psw_password;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
