/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectmysql;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author marco
 */
public class ConexionDB {

    private static Connection conexiondb;
    private static final String driver = "com.mysql.jdb.Driver";
    private static final String userBD = "root";
    private static final String passwordBd = "PAvilionP9";
    private static final String url = "jdbc:mysql://localhost:3306/hnhoteles";

    public static void Connect() {
        conexiondb = null;
        try {
            Class.forName(driver);
            conexiondb = DriverManager.getConnection(url, userBD, passwordBd);
            System.out.print("Succesfull Connection");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error conecction" + e);
        }
    }
    //with this metow retur the connection

    public Connection getConnection() {
        return conexiondb;
    }

    public void disconnect() {
        conexiondb = null;
        if (conexiondb == null) {
            System.out.println("Succesful disconect");
        }
    }
}
