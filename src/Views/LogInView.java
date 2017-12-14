package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import static Views.MainView.userTypeMenu;
import com.sun.glass.events.KeyEvent;
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

/**
 *
 * @author Steve and Marcos
 */
public class LogInView extends javax.swing.JFrame {

    GlobalsSingleton global = GlobalsSingleton.getInstance();

    /**
     * Creates new form CreateClientAccountView
     */
    public LogInView() {
        initComponents();

    }

    //this method shows the CreateClientAccountView view.
    public static void showCreateAccount() {

        CreateClientAccountView oCreateAccount = new CreateClientAccountView();
        oCreateAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oCreateAccount.setLocationRelativeTo(null);
        oCreateAccount.setVisible(true);

    }

    //this method cleans the textFields of the view.
    public void cleanUserTextFields() {

        txt_email.setText("");
        psw_password.setText("");

    }

    //This method show the user type in to the view.
    public void showUserType() {

        ImageIcon userNormal = new ImageIcon(getClass().getResource("../images/normalUser.png"));
        Icon iconUserNormal = new ImageIcon(userNormal.getImage());

        ImageIcon userAdmin = new ImageIcon(getClass().getResource("../images/adminUser.png"));
        Icon iconUserAdmin = new ImageIcon(userAdmin.getImage());

        GlobalsSingleton global = GlobalsSingleton.getInstance();

        if (global.getUserType().equals("Administrator")) {

            MainView.userTypeMenu.setIcon(iconUserAdmin);
            MainView.createHotelMenu.setEnabled(true);

        } else {

            MainView.userTypeMenu.setIcon(iconUserNormal);
            MainView.createHotelMenu.setEnabled(false);

        }

        userTypeMenu.setEnabled(true);

    }

    //This method show if there is a active user or not.
    public void showUserActiveInactive() {

        ImageIcon userActive = new ImageIcon(getClass().getResource("../images/userActive.png"));
        Icon iconUserActive = new ImageIcon(userActive.getImage());

        ImageIcon useInactive = new ImageIcon(getClass().getResource("../images/inactiveUser.png"));
        Icon iconUseInactive = new ImageIcon(useInactive.getImage());

        GlobalsSingleton global = GlobalsSingleton.getInstance();

        if (global.getUserCondition().equals("Active")) {

            MainView.userActiveInactiveMenu.setIcon(iconUserActive);
            MainView.userProfileViewMenu.setEnabled(true);
            MainView.modifyUserMenu.setEnabled(true);

        } else {

            MainView.userActiveInactiveMenu.setIcon(iconUseInactive);

        }

    }

    public void searchUserHotel(int idUser) throws SQLException{
        
        Connection conect = ConexionDB.Connectdatabase();

        String urlUser = "SELECT * FROM hotel ";

        int idHotelDB;
        int idUserDB;
        
        java.sql.Statement selectconect = conect.createStatement();

        ResultSet result = selectconect.executeQuery(urlUser);

        while (result.next()) {

            idHotelDB = result.getInt("id_hotel");
            idUserDB = result.getInt("id_user");
            

            if (idUserDB == global.getUserID()) {
            
                global.setIdHotel(idHotelDB);
                
                System.out.println(global.getIdHotel());

                this.dispose();

                return;

            } 
            
            else {

                global.setIdHotel(0);

                return;
   
            }

        }
  
    }
    
    
    
    //This method activates the user
    public void activeUser() throws SQLException {

        String pass = "";

        char[] password = psw_password.getPassword();
        for (int x = 0; x < password.length; x++) {

            pass += password[x];

        }

        if (txt_email.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define an Email Address to enter",
                    "Sign In Problem", JOptionPane.ERROR_MESSAGE);
            this.txt_email.requestFocus();
            return;

        }

        if (pass.equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a Password to enter",
                    "Sign In Problem", JOptionPane.ERROR_MESSAGE);
            this.psw_password.requestFocus();
            return;

        }

        String userEmail = txt_email.getText();

        Connection conect = ConexionDB.Connectdatabase();

        String urlUser = "SELECT * FROM newuser ";

        String userEmailDB;
        String userPasswordDB;
        String userTypeDB;
        int userIDDB;
        String userNameDB;
        String userLastNameDB;
        String userGenderDB;
        int userTelephoneDB;

        java.sql.Statement selectconect = conect.createStatement();

        ResultSet result = selectconect.executeQuery(urlUser);

        while (result.next()) {

            userEmailDB = result.getString("email");
            userPasswordDB = result.getString("user_password");
            userTypeDB = result.getString("usertype");

            userIDDB = result.getInt("id_user");
            userNameDB = result.getString("username");
            userLastNameDB = result.getString("last_name");
            userGenderDB = result.getString("gender");
            userTelephoneDB = result.getInt("cellphone");

            if (userEmailDB.equals(userEmail)) {

                if (userPasswordDB.equals(pass)) {

                    global.setUserEmail(userEmailDB);

                    global.setUserType(userTypeDB);

                    global.setUserCondition("Active");

                    global.setUserID(userIDDB);

                    global.setUserName(userNameDB);

                    global.setUserLastName(userLastNameDB);

                    global.setUserGender(userGenderDB);

                    global.setUserTelephone(userTelephoneDB);
                    
                    searchUserHotel(userIDDB);

                    this.dispose();

                    return;

                } else {

                    JOptionPane.showMessageDialog(this, "The Passsword is incorrect, "
                            + "enter the correct Password", "Error", JOptionPane.ERROR_MESSAGE);

                    psw_password.setText("");

                    this.txt_email.requestFocus();

                    return;

                }

            }

        }

        JOptionPane.showMessageDialog(this, "The Email is incorrect, "
                + "enter the correct Email", "Error", JOptionPane.ERROR_MESSAGE);

        txt_email.setText("");

        psw_password.setText("");

        this.txt_email.requestFocus();

        return;

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        logInButton = new javax.swing.JButton();
        psw_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_login.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("User Email Address");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("User Password");

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });

        logInButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        logInButton.setText("Log-In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        psw_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_passwordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(psw_password)
                    .addComponent(txt_email)
                    .addComponent(logInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(0, 166, Short.MAX_VALUE)))
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
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psw_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel5.setText("HNHotels");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(177, 177, 177))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed

        try {
            activeUser();
            showUserType();
            showUserActiveInactive();

        } catch (SQLException ex) {
            Logger.getLogger(LogInView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_logInButtonActionPerformed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.psw_password.requestFocus();
        }

    }//GEN-LAST:event_txt_emailKeyPressed

    private void psw_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_passwordKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.logInButton.requestFocus();
        }

    }//GEN-LAST:event_psw_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logInButton;
    private javax.swing.JPasswordField psw_password;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
