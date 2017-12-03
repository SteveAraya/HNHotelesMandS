
package Views;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos and Steve
 */
public class CreateAccountView extends javax.swing.JFrame {

    /**
     * Creates new form LogInView
     */
    public CreateAccountView() {
        initComponents();
    }

    //this method cleans the textFields of the view.
    public void cleanUserTextFields(){
       
        userNameTextField.setText("");
        lastNameTextField.setText("");
        cbo_Gender.setSelectedIndex(0);
        emailTextField.setText("");
        passwordPasswordField.setText("");
        confirmPasswordPasswordField.setText("");
    
    }
    
    
    public void checkPassword(String pass, String confirmPass){
        
        if(!pass.equals(confirmPass)){
            
            JOptionPane.showMessageDialog(this, "The PassWord is different, perform the operation again, please. ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            
            passwordPasswordField.setText("");
            confirmPasswordPasswordField.setText("");
            this.passwordPasswordField.requestFocus();
            
                return;
  
        }
   
    }

    //This method creates a new user account.
    public void createAccount(){

        if (userNameTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a NAME to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.userNameTextField.requestFocus();
            return;
            
        }
        
        if (lastNameTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a Last Name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.lastNameTextField.requestFocus();
            return;
            
        }
        
        if (cbo_Gender.getSelectedItem().toString().equals("Select a Gender")){
            
            JOptionPane.showMessageDialog(this, "You must define an GENDER to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_Gender.requestFocus();
            return;
            
        }
        
        if (emailTextField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define an Email to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.emailTextField.requestFocus();
            return;
            
        }

        if (passwordPasswordField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must define a PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.passwordPasswordField.requestFocus();
            return;
            
        }
        
        if (confirmPasswordPasswordField.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must confirm the PASSWORD to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.confirmPasswordPasswordField.requestFocus();
            return;
            
        }
        
        String name = userNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String  gender = cbo_Gender.getSelectedItem().toString();
        String email = emailTextField.getText();
        
        String pass = "";
        
        char [] password = passwordPasswordField.getPassword();
        for( int x = 0; x < password.length; x++){
            
            pass+=password[x];
            
        }
        
        String confirmPass = "";
        
        char [] confirmPassword = confirmPasswordPasswordField.getPassword();
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
        userNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_Gender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        confirmPasswordPasswordField = new javax.swing.JPasswordField();
        createAccountButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/create-an-account.png"))); // NOI18N

        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });
        userNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTextFieldKeyPressed(evt);
            }
        });

        lastNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastNameTextFieldKeyPressed(evt);
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

        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("User Password");

        passwordPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordPasswordFieldKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Confirm Your Password");

        confirmPasswordPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordPasswordFieldKeyPressed(evt);
            }
        });

        createAccountButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        createAccountButton.setText("Create Your HNHotel Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });
        createAccountButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createAccountButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameTextField)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailTextField)
                    .addComponent(passwordPasswordField)
                    .addComponent(confirmPasswordPasswordField)
                    .addComponent(createAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
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
                .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cbo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPasswordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        
        createAccount();
   
    }//GEN-LAST:event_createAccountButtonActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void userNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFieldKeyPressed
        
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.lastNameTextField.requestFocus();   
        }
 
    }//GEN-LAST:event_userNameTextFieldKeyPressed

    private void lastNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTextFieldKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_Gender.requestFocus();   
        }
  
    }//GEN-LAST:event_lastNameTextFieldKeyPressed

    private void cbo_GenderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_GenderKeyPressed
      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.emailTextField.requestFocus();
               
        }
   
    }//GEN-LAST:event_cbo_GenderKeyPressed

    private void emailTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextFieldKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.passwordPasswordField.requestFocus();
               
        }
        
    }//GEN-LAST:event_emailTextFieldKeyPressed

    private void passwordPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPasswordFieldKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.confirmPasswordPasswordField.requestFocus();
               
        }
  
    }//GEN-LAST:event_passwordPasswordFieldKeyPressed

    private void confirmPasswordPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordPasswordFieldKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.createAccountButton.requestFocus();
               
        }
  
    }//GEN-LAST:event_confirmPasswordPasswordFieldKeyPressed

    private void createAccountButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createAccountButtonKeyPressed
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_createAccountButtonKeyPressed

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
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_Gender;
    private javax.swing.JPasswordField confirmPasswordPasswordField;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
