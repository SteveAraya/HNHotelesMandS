
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class Hotel {
    private int id_hotel;
    private String name;
    private String address;
    private String country;
    private int telephone;
    private int constructionYear;
    private int starsNumber;
    private String lodgingType;
    private int HotelSize;
    private String checkInTime;
    private String checkOutTime;
    private String checkinrequeriment;

    public Hotel(int id_hotel, String name, String address, String country, int telephone, int constructionYear, int starsNumber, String lodgingType, int HotelSize, String checkInTime, String checkOutTime, String checkinrequeriment) {
        this.id_hotel = id_hotel;
        this.name = name;
        this.address = address;
        this.country = country;
        this.telephone = telephone;
        this.constructionYear = constructionYear;
        this.starsNumber = starsNumber;
        this.lodgingType = lodgingType;
        this.HotelSize = HotelSize;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.checkinrequeriment = checkinrequeriment;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public String getLodgingType() {
        return lodgingType;
    }

    public void setLodgingType(String lodgingType) {
        this.lodgingType = lodgingType;
    }

    public int getHotelSize() {
        return HotelSize;
    }

    public void setHotelSize(int HotelSize) {
        this.HotelSize = HotelSize;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getCheckinrequeriment() {
        return checkinrequeriment;
    }

    public void setCheckinrequeriment(String checkinrequeriment) {
        this.checkinrequeriment = checkinrequeriment;
    }


}