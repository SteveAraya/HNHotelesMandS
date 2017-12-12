/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectmysql;

import com.mysql.jdbc.Statement;
import com.sun.rowset.CachedRowSetImpl;
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

    private static Connection conexiondb = null;
    private static final String driver = "com.mysql.jdb.Driver";
    private static final String userBD = "root";
    private static final String passwordBd = "123";
    private static final String url = "jdbc:mysql://localhost:3306/HNHoteles";

    public static void Connectdatabase() throws SQLException {
        try {
            conexiondb = DriverManager.getConnection(url, userBD, passwordBd);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Connetion Data Base problem");
            alert.setContentText("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());
            alert.showAndWait();
        }
    }

    public static void Dissconectdatabase() throws SQLException {
        try {
            if (conexiondb != null && !conexiondb.isClosed()) {
                conexiondb.close();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Close Data Base problem");
            alert.setContentText("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());
            alert.showAndWait();
        }
    }

    public static ResultSet bdQuery(String query) throws SQLException {
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Ocurred an error executing the query");
            alert.setContentText("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());
            alert.showAndWait();
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

    public static void dbUpdate(String updateQuery) throws SQLException {
        Statement statement = null;
        try {
            Connectdatabase();
            statement = (Statement) conexiondb.createStatement();
            statement.execute(updateQuery);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Ocurred an error executing the query");
            alert.setContentText("Error: " + e.getMessage() + "\n" + "Error code: " + e.getErrorCode());
            alert.showAndWait();
        } finally {
            if (statement != null) {
                statement.close();
            }
            Dissconectdatabase();
        }
    }

}
