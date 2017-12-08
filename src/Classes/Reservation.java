package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Steve and Marcos
 */
public class Reservation {

    private int reservation_num;
    private String EntryDate;
    private String ExitDate;
    private int NighstNumber;
    private String RoomType;
    private String RoomAmount;
    private int roomprice;
    private String UserName;
    private String ChildrenAmount;
    private String AdultAmount;

    public Reservation(int reservation_num, String EntryDate, String ExitDate, int NighstNumber, String RoomType, String RoomAmount, int roomprice, String UserName, String ChildrenAmount, String AdultAmount) {
        this.reservation_num = reservation_num;
        this.EntryDate = EntryDate;
        this.ExitDate = ExitDate;
        this.NighstNumber = NighstNumber;
        this.RoomType = RoomType;
        this.RoomAmount = RoomAmount;
        this.roomprice = roomprice;
        this.UserName = UserName;
        this.ChildrenAmount = ChildrenAmount;
        this.AdultAmount = AdultAmount;
    }

    public int getReservation_num() {
        return reservation_num;
    }

    public void setReservation_num(int reservation_num) {
        this.reservation_num = reservation_num;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }

    public String getExitDate() {
        return ExitDate;
    }

    public void setExitDate(String ExitDate) {
        this.ExitDate = ExitDate;
    }

    public int getNighstNumber() {
        return NighstNumber;
    }

    public void setNighstNumber(int NighstNumber) {
        this.NighstNumber = NighstNumber;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public String getRoomAmount() {
        return RoomAmount;
    }

    public void setRoomAmount(String RoomAmount) {
        this.RoomAmount = RoomAmount;
    }

    public int getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(int roomprice) {
        this.roomprice = roomprice;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getChildrenAmount() {
        return ChildrenAmount;
    }

    public void setChildrenAmount(String ChildrenAmount) {
        this.ChildrenAmount = ChildrenAmount;
    }

    public String getAdultAmount() {
        return AdultAmount;
    }

    public void setAdultAmount(String AdultAmount) {
        this.AdultAmount = AdultAmount;
    }

    public static String actualdate() {// static methow for get actully date for reservation day
        Date actualdate = new Date();
        SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
        return formatdate.format(actualdate);
    }

}
