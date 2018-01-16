
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class Card {
    
    private String ownersName;
    private String ownersLastName;
    private String cardType;
    private int securityCode;
    private int year;
    private int month;

    public Card(String ownersName, String ownersLastName, String cardType, int securityCode, int year, int month) {
        this.ownersName = ownersName;
        this.ownersLastName = ownersLastName;
        this.cardType = cardType;
        this.securityCode = securityCode;
        this.year = year;
        this.month = month;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnersLastName() {
        return ownersLastName;
    }

    public void setOwnersLastName(String ownersLastName) {
        this.ownersLastName = ownersLastName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
      
    
}