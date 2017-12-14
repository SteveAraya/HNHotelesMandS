/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Steve and Marcos
 */
public class CardView extends javax.swing.JFrame {

    GlobalsSingleton global = GlobalsSingleton.getInstance();
    
    public CardView() {
        initComponents();
    }

    //this method cleans the textFields of the view.
    public void cleanCardTextFields(){
       
        txt_ownerName.setText("");
        txt_ownerLastName.setText("");
        txt_cardNumber.setText("");
        txt_cardCode.setText("");
        cbo_cardType.setSelectedIndex(0);
        cbo_month.setSelectedIndex(0);
        cbo_year.setSelectedIndex(0);
        
        
    }
    
    public void addCard() throws SQLException{
        
        if (txt_ownerName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter an Owner Name to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_ownerName.requestFocus();
            return;
            
        }
        
        if (txt_ownerLastName.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter an Owner Last Name to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_ownerLastName.requestFocus();
            return;
            
        }
        
        if (txt_cardNumber.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Card Number to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_cardNumber.requestFocus();
            return;
            
        }
        
        if (txt_cardCode.getText().equals("")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Card Code to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_cardCode.requestFocus();
            return;
            
        }
        
        if (cbo_cardType.getSelectedItem().toString().equals("Card Type")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Card Type to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_cardType.requestFocus();
            return;
            
        }
        
        if (cbo_month.getSelectedItem().toString().equals("Months")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Month to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_month.requestFocus();
            return;
            
        }
        
        if (cbo_year.getSelectedItem().toString().equals("Select a Year")){
            
            JOptionPane.showMessageDialog(this, "You must enter a Year to add a Card",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.cbo_year.requestFocus();
            return;
            
        }
 
        txt_ownerName.setText("");
        txt_ownerLastName.setText("");
        txt_cardNumber.setText("");
        txt_cardCode.setText("");
        cbo_cardType.setSelectedIndex(0);
        cbo_month.setSelectedIndex(0);
        cbo_year.setSelectedIndex(0);
        
        String ownerName = txt_ownerName.getText();
        String ownerLastName = txt_ownerLastName.getText();
        int  cardNumber = Integer.parseInt(txt_cardNumber.getText());
        int  cardCode = Integer.parseInt(txt_cardCode.getText());
        String  cardType = cbo_cardType.getSelectedItem().toString();
        int month = Integer.parseInt(cbo_cardType.getSelectedItem().toString());
        int year = Integer.parseInt(cbo_cardType.getSelectedItem().toString());
        int idUser = global.getUserID();

        Connection conect = ConexionDB.Connectdatabase();

        try {
            PreparedStatement insert = conect.prepareStatement("Insert Into "
                    + "card(cardnumber, id_user, ownersname, ownerslastname, secury_code, card_type, "
                    + "expirationyear, expirationmount)"
                    + "Values(?,?,?,?,?,?,?,?)");
                
            insert.setInt(1, cardNumber);
            insert.setInt(2, idUser);
            insert.setString(3, ownerName);
            insert.setString(4, ownerLastName);
            insert.setInt(5, cardCode);
            insert.setString(6, cardType);
            insert.setInt(7, year);
            insert.setInt(8, month);

            int a = insert.executeUpdate();

        } catch (Exception e) {

                JOptionPane.showMessageDialog(rootPane,"Error");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_cardType = new javax.swing.JComboBox<>();
        txt_ownerName = new javax.swing.JTextField();
        txt_ownerLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cardNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_cardCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_addCard = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbo_month = new javax.swing.JComboBox<>();
        cbo_year = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Owner Name");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Owner Last Name");

        cbo_cardType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card Type", "Visa", "Master Card", "Discover", "American Express" }));
        cbo_cardType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_cardTypeKeyPressed(evt);
            }
        });

        txt_ownerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ownerNameActionPerformed(evt);
            }
        });
        txt_ownerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ownerNameKeyPressed(evt);
            }
        });

        txt_ownerLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ownerLastNameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Card Number");

        txt_cardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cardNumberActionPerformed(evt);
            }
        });
        txt_cardNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cardNumberKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cardNumberKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Security Card Code ");

        txt_cardCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cardCodeActionPerformed(evt);
            }
        });
        txt_cardCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cardCodeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cardCodeKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Expiration Month");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Expiration Year");

        btn_addCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addCard.png"))); // NOI18N
        btn_addCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCardActionPerformed(evt);
            }
        });
        btn_addCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_addCardKeyPressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/card.png"))); // NOI18N

        cbo_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Months", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbo_month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_monthKeyPressed(evt);
            }
        });

        cbo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Year", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cbo_year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_yearKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_cardCode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ownerLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(cbo_cardType, 0, 218, Short.MAX_VALUE)
                                            .addComponent(txt_ownerName)
                                            .addComponent(jLabel3)
                                            .addComponent(txt_cardNumber))
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addComponent(cbo_month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbo_year, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_addCard))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_addCard)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ownerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_cardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cardCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(cbo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ownerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ownerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ownerNameActionPerformed

    private void txt_cardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cardNumberActionPerformed

    private void txt_cardCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cardCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cardCodeActionPerformed

    private void btn_addCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCardActionPerformed
        
        try {
            addCard();
        } catch (SQLException ex) {
            Logger.getLogger(CreateClientAccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cleanCardTextFields();
        
        this.dispose();
 
    }//GEN-LAST:event_btn_addCardActionPerformed

    private void txt_ownerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ownerNameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_ownerLastName.requestFocus();
               
        }
 
    }//GEN-LAST:event_txt_ownerNameKeyPressed

    private void txt_ownerLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ownerLastNameKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_cardType.requestFocus();
               
        }
        
    }//GEN-LAST:event_txt_ownerLastNameKeyPressed

    private void cbo_cardTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_cardTypeKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_cardNumber.requestFocus();
               
        }
        
    }//GEN-LAST:event_cbo_cardTypeKeyPressed

    private void txt_cardNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cardNumberKeyPressed
       
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.txt_cardCode.requestFocus();
               
        }
       
    }//GEN-LAST:event_txt_cardNumberKeyPressed

    private void txt_cardCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cardCodeKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_month.requestFocus();
               
        }
        
    }//GEN-LAST:event_txt_cardCodeKeyPressed

    private void cbo_monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_monthKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.cbo_year.requestFocus();
               
        }
        
    }//GEN-LAST:event_cbo_monthKeyPressed

    private void cbo_yearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_yearKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            this.btn_addCard.requestFocus();
               
        }
        
    }//GEN-LAST:event_cbo_yearKeyPressed

    private void btn_addCardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addCardKeyPressed
        
        try {
            addCard();
        } catch (SQLException ex) {
            Logger.getLogger(CreateClientAccountView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cleanCardTextFields();
        
        this.dispose();
        
    }//GEN-LAST:event_btn_addCardKeyPressed

    private void txt_cardNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cardNumberKeyTyped
        
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_cardNumberKeyTyped

    private void txt_cardCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cardCodeKeyTyped
        
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_cardCodeKeyTyped

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
            java.util.logging.Logger.getLogger(CardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCard;
    private javax.swing.JComboBox<String> cbo_cardType;
    private javax.swing.JComboBox<String> cbo_month;
    private javax.swing.JComboBox<String> cbo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_cardCode;
    private javax.swing.JTextField txt_cardNumber;
    private javax.swing.JTextField txt_ownerLastName;
    private javax.swing.JTextField txt_ownerName;
    // End of variables declaration//GEN-END:variables
}