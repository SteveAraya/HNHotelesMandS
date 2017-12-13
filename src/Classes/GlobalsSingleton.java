
package Classes;

import Views.MainView;

/**
 *
 * @author Marco and Steve
 */
public class GlobalsSingleton {
    
    static GlobalsSingleton instance;
    
    //Aqui van todas las globales que tengamos que usar
    
    String idUser;
    String userType = "Client";
    String userCondition = "Inactive";
    String idHotel;
    

    
    
    private GlobalsSingleton() {
        
    }
    
    public static GlobalsSingleton getInstance(){
        
        if (instance == null){
            
            instance = new GlobalsSingleton();
            
        }
    
        return instance;

    }

    public String getIdUser() {
        return instance.idUser;
    }

    public void setIdUser(String idUser) {
        instance.idUser = idUser;
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



   
    
    
    
    
     
    
}