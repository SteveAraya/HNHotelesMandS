
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class User {
    
    private String userName;
    private String UserLastName;
    private String UserGender;
    private String UserEmail;
    private String UserPassword ;
    private String UserNumber;
    private String Usertype;

    public User(String userName, String UserLastName, String UserGender, String UserEmail, String UserPassword, String UserNumber) {
        this.userName = userName;
        this.UserLastName = UserLastName;
        this.UserGender = UserGender;
        this.UserEmail = UserEmail;
        this.UserPassword = UserPassword;
        this.UserNumber = UserNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String UserLastName) {
        this.UserLastName = UserLastName;
    }

    public String getUserGender() {
        return UserGender;
    }

    public void setUserGender(String UserGender) {
        this.UserGender = UserGender;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(String UserNumber) {
        this.UserNumber = UserNumber;
    }
    
    
    
    
    
    
    
    
}