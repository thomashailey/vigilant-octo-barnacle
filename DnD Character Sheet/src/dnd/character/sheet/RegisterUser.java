/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

import dnd.character.sheet.GUIfolder.MainForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author thoma
 */
public class RegisterUser {
    
    DatabaseConnection database = new DatabaseConnection();
    Connection connection = null;
    PreparedStatement statement;
    ResultSet results;
    String sql = null;
    
    public boolean UserRegistration(String username, String password, int verificationCode) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        String name = username;
        String pass = password;
        int code = verificationCode;
        boolean userExists;
        boolean goHome = false;
        
        AuthenticateUser auth = new AuthenticateUser();
        
        userExists = auth.UserExists(name);
        
        if (userExists) {
            JOptionPane.showMessageDialog(null,"Username already exists.","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            CreateUser(name, pass, code);
            JOptionPane.showMessageDialog(null,"User successfully created. Logging in.", "User Created", JOptionPane.PLAIN_MESSAGE);
            auth.SetCurrentUser(name);
            goHome = true;
        }
        
        return goHome;
    } 
    
    private void CreateUser(String username, String password, int verificationCode) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        String name = username;
        String pass = password;
        int code = verificationCode;
        
        sql = String.format("INSERT INTO user_data (userPassword, userType, userName, userVerificationCode) VALUES (\'%s\', \'Standard\', \'%s\', \'%d\')",
                pass, name, code);
        statement = connection.prepareStatement(sql);
        statement.execute();
    }

}
