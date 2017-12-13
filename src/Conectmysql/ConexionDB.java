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

    public static Connection Connectdatabase() throws SQLException {
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

    public static ResultSet databaseQuery(String query) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSet = null;
        
        try {
            Connectdatabase();
            statement = (Statement) conexiondb.createStatement();
            resultSet = statement.executeQuery(query);
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            
        } catch (SQLException e) {

            System.out.println("Warning");
            System.out.println("Ocurred an error executing the query");
            System.out.println("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            Dissconectdatabase();
        }
        return cachedRowSet;
    }

    public static PreparedStatement Connectdatabase(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
