/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Gina
 */
public class ManageCharacters {
    DatabaseConnection database = new DatabaseConnection();
    Connection connection = null;
    PreparedStatement statement;
    ResultSet results;
    String sql = null;
    
    
    public ArrayList DisplayID(int userID) throws SQLException, ClassNotFoundException {
        int user = userID;
        connection = database.OpenConnection();
        ArrayList<Integer> id = new ArrayList<>();
        
        sql = String.format("SELECT characterID FROM character_basics WHERE characterIDuser = \'%d\'", user);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            id.add(results.getInt(1));
        }
        
        return id;
    }
    public ArrayList DisplayName(int userID) throws SQLException, ClassNotFoundException {
        int user = userID;
        connection = database.OpenConnection();
        ArrayList<String> name = new ArrayList<>();
        
        sql = String.format("SELECT characterName FROM character_basics WHERE characterIDuser = \'%d\'", user);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            name.add(results.getString(1));
        }
        
        return name;
    }
    
    public void CreateCharacterObject(int characterID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        ArrayList<String> characterList = new ArrayList<>();
        
        sql = String.format("SELECT * FROM character_basics WHERE characterID = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        // name, level, race, class
        
        while (results.next()) {
            characterList.add(results.getString("characterName") +","+ results.getInt("characterLevel") 
                    + ","+ results.getString("characterRace") + "," + results.getString("characterClass"));
        }
    }
    
    public void DisplayCharacter(int characterID) throws SQLException, ClassNotFoundException {
        
    }
}
