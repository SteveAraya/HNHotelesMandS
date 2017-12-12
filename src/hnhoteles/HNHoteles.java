
package hnhoteles;

import Conectmysql.ConexionDB;
import Views.MainView;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Marcos and Steve
 */
public class HNHoteles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        MainView mainView = new MainView();
        mainView.setLocationRelativeTo(mainView);
        mainView.setVisible(true);
        
     
        
        
    }
    
}