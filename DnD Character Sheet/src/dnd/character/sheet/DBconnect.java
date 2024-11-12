/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

import com.sun.jdi.connect.spi.Connection;
import java.sql.*;

/**
 *
 * @author thoma
 */
public class DBconnect {
    public Connection OpenConnection() throws SQLException, ClassNotFoundException {
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Create connection
        java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnd_app_database","root","devry123");
        
        return (Connection) connection;
    }
        public static void CloseConnection() throws SQLException {
        java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnd_app_database","root","devry123");
        connection.close();
        }
}
