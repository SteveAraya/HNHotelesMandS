/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectmysql;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author marco
 */
public class ConexionDB {

    private static Connection conexiondb = null;
    private static final String driver = "com.mysql.jdb.Driver";
    private static final String userBD = "root";
    private static final String passwordBd = "123";
    private static final String url = "jdbc:mysql://localhost:3306/hnhoteles";

    public static Connection Connectdatabase(){
        try {
            conexiondb = DriverManager.getConnection(url, userBD, passwordBd);
            System.out.println("Connetion sucesfull");
        } catch (SQLException e) {

            System.out.println("Warning");
            System.out.println("Connetion Data Base problem");
            System.out.println("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());

        }
        return conexiondb;
    }

    public static void Dissconectdatabase() throws SQLException {
        try {
            if (conexiondb != null && !conexiondb.isClosed()) {
                conexiondb.close();
            }
        } catch (SQLException e) {

            System.out.println("Warning");
            System.out.println("Close Data Base problem");
            System.out.println("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());

        }
    }


}
