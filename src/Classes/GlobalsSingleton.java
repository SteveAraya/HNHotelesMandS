package Classes;

import Views.MainView;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco and Steve
 */
public class GlobalsSingleton {

    static GlobalsSingleton instance;

    //User
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

    //Hotel
    int roomAmount;
    int adultAmount;
    int childremAmount;
    String entryDate;
    String exitDate;
    int nigthnumbers;

    String hotelName;
    int hotelStars;

    String cardNumber;
    int numRoom;
    int idRoomType;

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

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getAdultAmount() {
        return adultAmount;
    }

    public void setAdultAmount(int adultAmount) {
        this.adultAmount = adultAmount;
    }

    public int getChildremAmount() {
        return childremAmount;
    }

    public void setChildremAmount(int childremAmount) {
        this.childremAmount = childremAmount;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public int getNigthnumbers() {
        return nigthnumbers;
    }

    public void setNigthnumbers(int nigthnumbers) {
        this.nigthnumbers = nigthnumbers;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(int idRoomType) {
        this.idRoomType = idRoomType;
    }

   
}
