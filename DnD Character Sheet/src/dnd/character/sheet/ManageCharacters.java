/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

import dnd.character.sheet.GUIfolder.MainForm;
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
    
    public Character CreateCharacterObject(int characterID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        ArrayList<String> characterList = new ArrayList<>();
        
        sql = String.format("SELECT * FROM character_basics WHERE characterID = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        // name, level, race, class
        
        while (results.next()) {
            characterList.add(results.getString("characterName") +","+ results.getInt("characterLevel") 
                    + ","+ results.getString("characterRace") + "," + results.getString("characterClass") + "," 
                            + results.getString("characterPublic"));
        }
        
        String parsing = characterList.get(0);
        String[] informationList = parsing.split(",");
        
        String name = informationList[0];
        int level = Integer.parseInt(informationList[1]);
        String race = informationList[2];
        String charClass = informationList[3];
        String privacy = informationList[4];
        
        Character character = new Character(characterID, name, level, race, charClass, privacy);
        
        return character;
    }
    
    public String DisplayCharacter(Character character) throws SQLException, ClassNotFoundException {
        String displayString;
        
        displayString = "Name: " + character.getCharName() + "\n" + 
                "Level: " + character.getCharLevel() + "\n" + 
                "Class: " + character.getCharClass() + "\n" + 
                "Race: " + character.getCharRace();
        
        return displayString;
    }
}
