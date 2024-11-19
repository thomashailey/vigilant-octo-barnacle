/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thoma
 */
public class AuthenticateUser {
    DatabaseConnection database = new DatabaseConnection();
    Connection connection = null;
    PreparedStatement statement;
    ResultSet results;
    String sql = null;
    
    public boolean SearchDatabase(String username, String password, int verificationCode) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        String name = username;
        String pass = password;
        int code = verificationCode;
        boolean userExists;
        boolean userVerified;
        boolean goHome = false;
        
        userExists = UserExists(name);
        
        if (userExists) {
            userVerified = VerifyUser(name, pass, code);
            System.out.println("userVerified method completed");
            if (userVerified) {
                System.out.println("User Successfully Verified");
                SetCurrentUser(name);
                goHome = true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Username, password, or code incorrect. Please retry.", "Notice", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "User does not exist, please Register", "Notice", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return goHome;
    }
    
    boolean UserExists(String username) throws SQLException, ClassNotFoundException {
        boolean exists;
        
        connection = database.OpenConnection();
        sql = String.format("SELECT * FROM user_data WHERE userName = \'%s\'", username);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        if (!results.next()) {
            exists = false;
        } else {
            exists = true;
        }
        
        return exists;
    }
    
    boolean VerifyUser(String username, String password, int verificationCode) throws SQLException, ClassNotFoundException {
        boolean verified = false;
        connection = database.OpenConnection();
        String name = username;
        String pass = password;
        int code = verificationCode;
        
        sql = String.format("SELECT * FROM user_data WHERE userName = \'%s\' AND userPassword = \'%s\' AND userVerificationCode = \'%d\'",
                name, pass, code);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        if (results.next()) {
            verified = true;
        }
        
        return verified;
    }
    
    void SetCurrentUser(String username) throws SQLException, ClassNotFoundException {
        int userID = 0;
        
        connection = database.OpenConnection();
        sql = String.format("SELECT * FROM user_data WHERE userName = \'%s\'", username);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            userID = results.getInt("userID");
//            System.out.println(userID);
        }
//        System.out.println(userID);
        
        try {
            File userIdFile = new File("currentuser.txt");
            if (userIdFile.createNewFile()) {
                System.out.println("File created: " + userIdFile.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred");
            ex.printStackTrace();
        }
        
        Integer tempNum = new Integer(userID);
        String data = tempNum.toString();
        
        try {
            FileWriter myWriter = new FileWriter("currentuser.txt");
            BufferedWriter br = new BufferedWriter(myWriter);
            br.write(data);
            br.close();
            System.out.println("Successfully wrote to file, userID set to: " + data);
        } catch (IOException ex) {
            System.out.println("An error occurred");
            ex.printStackTrace();
        }
    }
    
    
    public String CheckUserType(int userID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        int id = userID;
        String type = "";
        
        sql = String.format("SELECT userType FROM user_data WHERE userID = \'%d\'",
                id);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            type = results.getString(1);
        }
        System.out.println(type);
        
        return type;
    }
    
    public String ReadFile() throws FileNotFoundException, IOException {
        FileReader file = new FileReader("currentuser.txt");
        String data = "";
        
        BufferedReader br = new BufferedReader(file);
        data = br.readLine();
        
        return data;
    }
}
