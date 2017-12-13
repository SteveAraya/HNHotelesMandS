package Classes;

import Views.MainView;

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
    String idHotel = "1";

    int userID;
    String userName;
    String userLastName;
    String userGender;
    int userTelephone;

    private GlobalsSingleton() {

    }

    public static GlobalsSingleton getInstance() {

        if (instance == null) {

            instance = new GlobalsSingleton();

        }

        return instance;

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserCondition() {
        return userCondition;
    }

    public void setUserCondition(String userCondition) {
        this.userCondition = userCondition;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(int userTelephone) {
        this.userTelephone = userTelephone;
    }

}
