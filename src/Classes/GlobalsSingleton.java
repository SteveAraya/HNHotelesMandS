package Classes;

import Views.MainView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco and Steve
 */
public class GlobalsSingleton {

    static GlobalsSingleton instance;

    //Aqui van todas las globales que tengamos que usar
    String userEmail;
    String userType;
    String userCondition = "Inactive";
    int idHotel;

    int userID;
    String userName;
    String userLastName;
    String userGender;
    int userTelephone;
    String country;
    String currencyType;
    

    private GlobalsSingleton() {

    }

    public static GlobalsSingleton getInstance() {

        if (instance == null) {

            instance = new GlobalsSingleton();

        }

        return instance;

    }
    //methow for refresh jtable
     public void cleantableservice(DefaultTableModel table) {

        int a = table.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            table.removeRow(table.getRowCount() - 1);
        }
    }

    public String getUserEmail() {
        return instance.userEmail;
    }

    public void setUserEmail(String userEmail) {
        instance.userEmail = userEmail;
    }

    public String getUserType() {
        return instance.userType;
    }

    public void setUserType(String userType) {
        instance.userType = userType;
    }

    public String getUserCondition() {
        return instance.userCondition;
    }

    public void setUserCondition(String userCondition) {
        instance.userCondition = userCondition;
    }

    public int getIdHotel() {
        return instance.idHotel;
    }

    public void setIdHotel(int idHotel) {
        instance.idHotel = idHotel;
    }

    public int getUserID() {
        return instance.userID;
    }

    public void setUserID(int userID) {
        instance.userID = userID;
    }

    public String getUserName() {
        return instance.userName;
    }

    public void setUserName(String userName) {
        instance.userName = userName;
    }

    public String getUserLastName() {
        return instance.userLastName;
    }

    public void setUserLastName(String userLastName) {
        instance.userLastName = userLastName;
    }

    public String getUserGender() {
        return instance.userGender;
    }

    public void setUserGender(String userGender) {
        instance.userGender = userGender;
    }

    public int getUserTelephone() {
        return instance.userTelephone;
    }

    public void setUserTelephone(int userTelephone) {
        instance.userTelephone = userTelephone;
    }

    public String getCountry() {
        return instance.country;
    }

    public void setCountry(String country) {
        instance.country = country;
    }

    public String getCurrencyType() {
        return instance.currencyType;
    }

    public void setCurrencyType(String currencyType) {
        instance.currencyType = currencyType;
    }

    
    
    
    
    
    
    
    
}