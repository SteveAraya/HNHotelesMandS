
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
    String idHotel;
    
    String userID;
    String userName;
    String userLastName;
    String userGender;
    int userTelephone;
    

    
    
    private GlobalsSingleton() {
        
    }
    
    public static GlobalsSingleton getInstance(){
        
        if (instance == null){
            
            instance = new GlobalsSingleton();
            
        }
    
        return instance;

    }

    public String getUserEmail() {
        return instance.userEmail;
    }

    public void setUserEmail(String userEmail) {
        instance.userEmail = userEmail;
    }

    public String getIdHotel() {
        return instance.idHotel;
    }

    public void setIdHotel(String idHotel) {
        instance.idHotel = idHotel;
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

    public String getUserID() {
        return instance.userID;
    }

    public void setUserID(String userID) {
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

    
    
    
    


   
    
    
    
    
     
    
}