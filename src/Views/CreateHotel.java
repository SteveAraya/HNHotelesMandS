package Views;

import Classes.GlobalsSingleton;
import Conectmysql.ConexionDB;
import com.mysql.jdbc.ResultSetRow;
import com.sun.glass.events.KeyEvent;
import com.sun.prism.PresentableState;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos and Steve
 */
public class CreateHotel extends javax.swing.JFrame {

    Connection conect = ConexionDB.Connectdatabase();

    /**
     * Creates new form LogInView
     */
    public CreateHotel() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        verifyhotel();

    }

    //this method cleans the textFields of the view.
    public void createhotelstatusfalse() {

        txt_hotelName.setEditable(false);
        txt_telephone.setEditable(false);
        txt_checkin.setEditable(false);
        txt_LodgingType.setEditable(false);
        txt_HotelSize.setEditable(false);
        sp_ConstrucctionYear.setValue(0);
        txt_checkout.setEditable(false);
        txt_checkin.setEditable(false);
        txt_checkinrequeriment.setEditable(false);
        sp_starnumbers.setValue(0);
        txt_idhotel.setEditable(false);
        txt_ubication.setEditable(false);
        txt_country.setEditable(false);

    }

    public void cleanserviceTextFields() {
        txt_servicecode.setText("");
        txt_serviceName.setText("");
    }

    public void insertservice() {
        String servicecode = txt_servicecode.getText();
        String service = txt_serviceName.getText();

        try {
            PreparedStatement insertatracctive = conect.prepareStatement("Insert Into attractive(attractive_code,attractive_name,id_hotel)"
                    + "Values(?,?,?)");
            insertatracctive.setString(1, servicecode);
            insertatracctive.setString(2, service);
            insertatracctive.setInt(3,GlobalsSingleton.getInstance().getIdHotel());;

            int a = insertatracctive.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Error");
        }
    }

    public void cleanattractiveTextFields() {
        txt_attractivecode.setText("");
        txt_attractivename.setText("");
    }

    public void insertattractive() throws SQLException {
        String attrarctivecode = txt_attractivecode.getText();
        String attractivename = txt_attractivename.getText();

        try {
            PreparedStatement insertatracctive = conect.prepareStatement("Insert Into attractive(attractive_code,attractive_name,id_hotel)"
                    + "Values(?,?,?)");
            insertatracctive.setString(1, attrarctivecode);
            insertatracctive.setString(2, attractivename);
            insertatracctive.setInt(3, GlobalsSingleton.getInstance().getIdHotel());

            int a = insertatracctive.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Error");
        }        // TODO 

    }
    
 public void verifyhotel() throws SQLException {

        String urlhotelverify = "SELECT * FROM hotel";
        int useridverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet result = selectconect.executeQuery(urlhotelverify);

        while (result.next()) {
            useridverification = result.getInt("id_user");
            if (useridverification == GlobalsSingleton.getInstance().getUserID()) {
                JOptionPane.showMessageDialog(rootPane, "Welcome ");
                createhotelstatusfalse();
                return;
            } else {

                JOptionPane.showMessageDialog(rootPane, "Welcome can you create your hotel ");
                return;
            }
        }
    }
    public void verifyservice() throws SQLException {

        String urlhotelverify = "SELECT * FROM service";
        int serviceverification;

        java.sql.Statement selectconect = conect.createStatement();
        ResultSet result = selectconect.executeQuery(urlhotelverify);

        while (result.next()) {
            serviceverification = result.getInt("id_hotel");
            if (serviceverification == GlobalsSingleton.getInstance().getIdHotel()) {
                
                return;
            } 
        }
    }
    

    //This method creates a new hotel.
    public void createHotel() throws SQLException {

        String hotelname = txt_hotelName.getText();
        int telphone = Integer.parseInt(txt_telephone.getText());
        String checkin = txt_checkin.getText();
        String lodgintype = txt_LodgingType.getText();
        int hotelsize = Integer.parseInt(txt_HotelSize.getText());
        String construcctionyear = sp_ConstrucctionYear.getValue().toString();
        String chekout = txt_checkout.getText();
        String checkinrequeriment = txt_checkinrequeriment.getText();
        String starnumber = sp_starnumbers.getValue().toString();
        int id_hotel = Integer.parseInt(txt_idhotel.getText());
        String ubication = (txt_ubication.getText());
        String country = txt_country.getText();


        try {
            PreparedStatement inserthotel = conect.prepareStatement("Insert Into hotel(id_hotel,hotel_name,country,telephone,address,construcctionyears,starnumbers,lodgingtype,"
                    + "hotelsize,checkingtime,chekouttime,requirementCheckin,id_user)"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            inserthotel.setInt(1, id_hotel);
            inserthotel.setString(2, hotelname);
            inserthotel.setString(3, country);
            inserthotel.setInt(4, telphone);
            inserthotel.setString(5, ubication);
            inserthotel.setString(6, construcctionyear);
            inserthotel.setString(7, starnumber);
            inserthotel.setString(8, lodgintype);
            inserthotel.setInt(9, hotelsize);
            inserthotel.setString(10, checkin);
            inserthotel.setString(11, chekout);
            inserthotel.setString(12, checkinrequeriment);
            inserthotel.setInt(13, GlobalsSingleton.getInstance().getUserID());

            int a = inserthotel.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Error");
        }        // TODO 

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
        jPanel3 = new javax.swing.JPanel();
        txt_hotelName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_telephone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_checkin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_LodgingType = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_HotelSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sp_ConstrucctionYear = new javax.swing.JSpinner();
        btn_createAccount = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_country = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_ubication = new javax.swing.JTextField();
        txt_checkout = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_checkinrequeriment = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        sp_starnumbers = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        txt_idhotel = new javax.swing.JTextField();
        btn_modifyAccount = new javax.swing.JButton();
        btn_deleteAccount = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txt_servicecode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_serviceName = new javax.swing.JTextField();
        btn_insertservice = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_modifyAccount1 = new javax.swing.JButton();
        btn_deleteAccount1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_services = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_attractivecode = new javax.swing.JTextField();
        txt_attractivename = new javax.swing.JTextField();
        btn_insertatractive = new javax.swing.JButton();
        btn_deleteAccount2 = new javax.swing.JButton();
        btn_modifyAccount2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_attractive = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_selectimage = new javax.swing.JButton();
        txt_image = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/887169_home_512x512.png"))); // NOI18N
        jLabel1.setFocusable(false);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Hotel Name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Telephone Number");

        txt_telephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telephoneKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Ubication");

        txt_checkin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_checkinKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("LodgingType ");

        txt_LodgingType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_LodgingTypeKeyPressed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Construction Year");

        btn_createAccount.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_createAccount.setText("Create ");
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

        jLabel16.setFont(jLabel16.getFont().deriveFont(jLabel16.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel16.setText("Country");

        txt_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_countryActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Checkin Time");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Checkout Time");

        txt_ubication.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ubicationKeyPressed(evt);
            }
        });

        txt_checkout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_checkoutKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Checkin Requeriment");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Star Numbers");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setText("Id Hotel");

        btn_modifyAccount.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_modifyAccount.setText("Modify");
        btn_modifyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyAccountActionPerformed(evt);
            }
        });
        btn_modifyAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modifyAccountKeyPressed(evt);
            }
        });

        btn_deleteAccount.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_deleteAccount.setText("Delete");
        btn_deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteAccountActionPerformed(evt);
            }
        });
        btn_deleteAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteAccountKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel16)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txt_HotelSize)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6))
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel20)
                                .addComponent(txt_hotelName)
                                .addComponent(txt_ubication)
                                .addComponent(txt_telephone)
                                .addComponent(txt_country)
                                .addComponent(txt_checkin)
                                .addComponent(txt_checkout)
                                .addComponent(txt_checkinrequeriment)
                                .addComponent(txt_LodgingType)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(sp_ConstrucctionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sp_starnumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(51, 51, 51)
                                    .addComponent(jLabel21))
                                .addComponent(jLabel22)
                                .addComponent(txt_idhotel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_createAccount)
                                .addGap(30, 30, 30)
                                .addComponent(btn_modifyAccount)
                                .addGap(18, 18, 18)
                                .addComponent(btn_deleteAccount)))
                        .addGap(0, 51, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idhotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ubication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_checkinrequeriment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_LodgingType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_HotelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_starnumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_ConstrucctionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_createAccount)
                    .addComponent(btn_modifyAccount)
                    .addComponent(btn_deleteAccount))
                .addGap(12, 12, 12))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Service");

        txt_serviceName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serviceNameActionPerformed(evt);
            }
        });

        btn_insertservice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_insertservice.setText("Insert");
        btn_insertservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertserviceActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Services");

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel23.setText("Services Code");

        btn_modifyAccount1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_modifyAccount1.setText("Modify");
        btn_modifyAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyAccount1ActionPerformed(evt);
            }
        });
        btn_modifyAccount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modifyAccount1KeyPressed(evt);
            }
        });

        btn_deleteAccount1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_deleteAccount1.setText("Delete");
        btn_deleteAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteAccount1ActionPerformed(evt);
            }
        });
        btn_deleteAccount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteAccount1KeyPressed(evt);
            }
        });

        tbl_services.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_services);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_serviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_servicecode, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertservice)
                    .addComponent(btn_modifyAccount1)
                    .addComponent(btn_deleteAccount1))
                .addGap(71, 71, 71))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel23)
                        .addGap(2, 2, 2)
                        .addComponent(txt_servicecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_insertservice)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btn_modifyAccount1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteAccount1)
                    .addComponent(txt_serviceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("HNHotels");

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Attractive");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Attractive Code");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Attractive");

        txt_attractivecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_attractivecodeActionPerformed(evt);
            }
        });

        txt_attractivename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_attractivenameActionPerformed(evt);
            }
        });

        btn_insertatractive.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_insertatractive.setText("Insert");
        btn_insertatractive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertatractiveActionPerformed(evt);
            }
        });

        btn_deleteAccount2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_deleteAccount2.setText("Delete");
        btn_deleteAccount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteAccount2ActionPerformed(evt);
            }
        });
        btn_deleteAccount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteAccount2KeyPressed(evt);
            }
        });

        btn_modifyAccount2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_modifyAccount2.setText("Modify");
        btn_modifyAccount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyAccount2ActionPerformed(evt);
            }
        });
        btn_modifyAccount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_modifyAccount2KeyPressed(evt);
            }
        });

        tbl_attractive.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbl_attractive);

        jScrollPane4.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_attractivename, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(txt_attractivecode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_modifyAccount2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleteAccount2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_insertatractive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addComponent(txt_attractivecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_attractivename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_insertatractive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_modifyAccount2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_deleteAccount2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("Hotel Image");

        btn_selectimage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_selectimage.setText("Select");
        btn_selectimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectimageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_selectimage)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_selectimage)
                    .addComponent(txt_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jButton1.setText("Admin Hotel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel8)
                .addGap(216, 216, 216)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createAccountActionPerformed

        if (txt_hotelName.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a Hotel NAME to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_hotelName.requestFocus();
            return;

        }
        if (txt_idhotel.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a id Hotel to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_idhotel.requestFocus();
            return;

        }

        if (txt_checkin.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define  checkin time  to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_checkin.requestFocus();
            return;

        }
        if (txt_checkout.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define checkout time to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_checkout.requestFocus();
            return;

        }

        if (txt_HotelSize.getText().equals("Select a Gender")) {

            JOptionPane.showMessageDialog(this, "You must define a Hotel Size  to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_HotelSize.requestFocus();
            return;

        }

        if (txt_LodgingType.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a Lodgin Type  to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_LodgingType.requestFocus();
            return;

        }

        if (sp_ConstrucctionYear.getValue().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define Construcction Year  to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_serviceName.requestFocus();
            return;

        }
        if (sp_starnumbers.getValue().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a number of star to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.sp_starnumbers.requestFocus();
            return;

        }

        if (txt_ubication.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a ubication to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_ubication.requestFocus();
            return;

        }

        if (txt_checkinrequeriment.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a checkin requeriment to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_checkinrequeriment.requestFocus();
            return;

        }
        if (txt_country.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a country to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_country.requestFocus();
            return;

        }

        if (txt_telephone.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a telephone number to create a hotel",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_telephone.requestFocus();
            return;

        }

        try {
            createHotel();
            JOptionPane.showMessageDialog(rootPane, "Succesfull");
            createhotelstatusfalse();
        } catch (SQLException ex) {
            Logger.getLogger(CreateHotel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_createAccountActionPerformed

    private void txt_hotelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hotelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hotelNameActionPerformed

    private void txt_hotelNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hotelNameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.txt_checkin.requestFocus();
        }

    }//GEN-LAST:event_txt_hotelNameKeyPressed

    private void txt_checkinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_checkinKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.txt_HotelSize.requestFocus();
        }

    }//GEN-LAST:event_txt_checkinKeyPressed

    private void txt_LodgingTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LodgingTypeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.txt_servicecode.requestFocus();

        }

    }//GEN-LAST:event_txt_LodgingTypeKeyPressed

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

    private void txt_serviceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serviceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serviceNameActionPerformed

    private void btn_insertserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertserviceActionPerformed
        if (txt_servicecode.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a Services Offered to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_servicecode.requestFocus();
            return;

        }

        if (txt_serviceName.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define service name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_serviceName.requestFocus();
            return;

        }
        insertservice();
        cleanserviceTextFields();

    }//GEN-LAST:event_btn_insertserviceActionPerformed

    private void txt_attractivecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_attractivecodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_attractivecodeActionPerformed

    private void txt_attractivenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_attractivenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_attractivenameActionPerformed

    private void btn_insertatractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertatractiveActionPerformed
        if (txt_servicecode.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define a attraction code to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_attractivecode.requestFocus();
            return;

        }

        if (txt_serviceName.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "You must define  Attraction Name to create an account",
                    "Problem creating user account", JOptionPane.ERROR_MESSAGE);
            this.txt_attractivename.requestFocus();
            return;

        }        // TODO add your handling code here:
        try {
            insertattractive();
        } catch (SQLException ex) {
            Logger.getLogger(CreateHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
        cleanattractiveTextFields();
    }//GEN-LAST:event_btn_insertatractiveActionPerformed

    private void txt_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_countryActionPerformed

    private void txt_ubicationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ubicationKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ubicationKeyPressed

    private void txt_checkoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_checkoutKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_checkoutKeyPressed

    private void btn_selectimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectimageActionPerformed
        JFileChooser imagefile = new JFileChooser();
        int imagewindow = imagefile.showOpenDialog(null);
        if (imagewindow == JFileChooser.APPROVE_OPTION) {
            File file = imagefile.getSelectedFile();
            txt_image.setText(String.valueOf(file));
        }

    }//GEN-LAST:event_btn_selectimageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            ConexionDB.Connectdatabase();
        } catch (SQLException ex) {
            Logger.getLogger(CreateHotel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_modifyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccountActionPerformed

    private void btn_modifyAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modifyAccountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccountKeyPressed

    private void btn_deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccountActionPerformed

    private void btn_deleteAccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteAccountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccountKeyPressed

    private void btn_modifyAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyAccount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccount1ActionPerformed

    private void btn_modifyAccount1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modifyAccount1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccount1KeyPressed

    private void btn_deleteAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteAccount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccount1ActionPerformed

    private void btn_deleteAccount1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteAccount1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccount1KeyPressed

    private void btn_deleteAccount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteAccount2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccount2ActionPerformed

    private void btn_deleteAccount2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteAccount2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteAccount2KeyPressed

    private void btn_modifyAccount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyAccount2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccount2ActionPerformed

    private void btn_modifyAccount2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_modifyAccount2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifyAccount2KeyPressed

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
                try {
                    new CreateHotel().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateHotel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createAccount;
    private javax.swing.JButton btn_deleteAccount;
    private javax.swing.JButton btn_deleteAccount1;
    private javax.swing.JButton btn_deleteAccount2;
    private javax.swing.JButton btn_insertatractive;
    private javax.swing.JButton btn_insertservice;
    private javax.swing.JButton btn_modifyAccount;
    private javax.swing.JButton btn_modifyAccount1;
    private javax.swing.JButton btn_modifyAccount2;
    private javax.swing.JButton btn_selectimage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner sp_ConstrucctionYear;
    private javax.swing.JSpinner sp_starnumbers;
    private javax.swing.JTable tbl_attractive;
    private javax.swing.JTable tbl_services;
    private javax.swing.JTextField txt_HotelSize;
    private javax.swing.JTextField txt_LodgingType;
    private javax.swing.JTextField txt_attractivecode;
    private javax.swing.JTextField txt_attractivename;
    private javax.swing.JTextField txt_checkin;
    private javax.swing.JTextField txt_checkinrequeriment;
    private javax.swing.JTextField txt_checkout;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_hotelName;
    private javax.swing.JTextField txt_idhotel;
    private javax.swing.JTextField txt_image;
    private javax.swing.JTextField txt_serviceName;
    private javax.swing.JTextField txt_servicecode;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_ubication;
    // End of variables declaration//GEN-END:variables
}
