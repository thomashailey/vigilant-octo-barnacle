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
    
    public Character CreateSimpleCharacterObject(int characterID) throws SQLException, ClassNotFoundException {
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
    
    public Character CreateFullCharacterObject(int characterID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        
        String name, race, charClass, privacy, notes, STRSave, DEXSave, CONSave, INTSave, WISSave, CHASave;
        int level, ac, profMod, hp, STR, DEX, CON, INT, WIS, CHA;
        
        String parsing;
        
        Character characterBasics = CreateSimpleCharacterObject(characterID);
        ArrayList<String> fundList = new ArrayList<>();
        ArrayList<String> statList = new ArrayList<>();
        
        fundList = ObtainFundamentals(characterID);
        statList = ObtainStats(characterID);
        
//        String[] informationList = parsing.split(",");
        
        // first set of info (name, level, race, class, public/private
        name = characterBasics.getCharName();
        level = characterBasics.getCharLevel();
        race = characterBasics.getCharRace();
        charClass = characterBasics.getCharClass();
        privacy = characterBasics.getPublicChar();
        
        Character character = new Character(characterID, name, level, race, charClass, privacy);
        
        // second set of info (AC, ProfMod, HP, AdditionalNotes
        if (!fundList.get(0).equals("Null") && !statList.get(0).equals("Null")) {
            // testing
            System.out.println("FundList and StatList != null");
            
            parsing = fundList.get(0);
            String[] parsedList = parsing.split(",");
            
            ac = Integer.parseInt(parsedList[0]);
            profMod = Integer.parseInt(parsedList[1]);
            hp = Integer.parseInt(parsedList[2]);
            notes = parsedList[3];
            
            parsing = statList.get(0);
            parsedList = parsing.split(",");
            
            STR = Integer.parseInt(parsedList[0]);
            STRSave = parsedList[1];
            DEX = Integer.parseInt(parsedList[2]);
            DEXSave = parsedList[3];
            CON = Integer.parseInt(parsedList[4]);
            CONSave = parsedList[5];
            INT = Integer.parseInt(parsedList[6]);
            INTSave = parsedList[7];
            WIS = Integer.parseInt(parsedList[8]);
            WISSave = parsedList[9];
            CHA = Integer.parseInt(parsedList[10]);
            CHASave = parsedList[11];
            
            character = new Character(characterID, name, level, race, charClass, privacy, 
                ac, profMod, hp, notes, STR, STRSave, DEX, DEXSave, 
                CON, CONSave, INT, INTSave, WIS, WISSave, CHA, CHASave);
        } else if (!fundList.get(0).equals("Null") && statList.get(0).equals("Null")) {
            // testing
            System.out.println("FundList != null");
            
            parsing = fundList.get(0);
            String[] parsedList = parsing.split(",");
            
            ac = Integer.parseInt(parsedList[0]);
            profMod = Integer.parseInt(parsedList[1]);
            hp = Integer.parseInt(parsedList[2]);
            notes = parsedList[3];
            
            character = new Character(characterID, name, level, race, charClass, privacy,
                ac, profMod, hp, notes);
        } else if (fundList.get(0).equals("Null") && !statList.get(0).equals("Null")) {
            // testing
            System.out.println("StatList != null");
            
            parsing = statList.get(0);
            String[] parsedList = parsing.split(",");
            
            STR = Integer.parseInt(parsedList[0]);
            STRSave = parsedList[1];
            DEX = Integer.parseInt(parsedList[2]);
            DEXSave = parsedList[3];
            CON = Integer.parseInt(parsedList[4]);
            CONSave = parsedList[5];
            INT = Integer.parseInt(parsedList[6]);
            INTSave = parsedList[7];
            WIS = Integer.parseInt(parsedList[8]);
            WISSave = parsedList[9];
            CHA = Integer.parseInt(parsedList[10]);
            CHASave = parsedList[11];
            
            character = new Character(characterID, name, level, race, charClass, privacy,
                STR, STRSave, DEX, DEXSave, CON, CONSave, INT, INTSave, WIS, WISSave, CHA, CHASave);
        }
        
        return character;
    }
    
    public ArrayList ObtainFundamentals(int characterID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        ArrayList<String> fundList = new ArrayList<>();
        
        
        // AC, Proficiency Modifier, HP, Additional Notes
        // int charAC, int charProfMod, int charHP, String additionalNotes, 
        sql = String.format("SELECT characterAC, characterProficiencyMod, characterHP, characterAdditionalNotes "
                + "FROM character_fundamentals WHERE characterFundID = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        if (!results.isBeforeFirst()) {
            fundList.add("Null");
        } else {
            while (results.next()) {
            fundList.add(results.getInt("characterAC") +","+ results.getInt("characterProficiencyMod") 
                    + ","+ results.getInt("characterHP") + "," + results.getString("characterAdditionalNotes"));
            }
        }
        
        return fundList;
    }
    
    public ArrayList ObtainStats(int characterID) throws SQLException, ClassNotFoundException {
        connection = database.OpenConnection();
        ArrayList<String> statList = new ArrayList<>();
        
        // AC, Proficiency Modifier, HP, Additional Notes
        // int charAC, int charProfMod, int charHP, String additionalNotes, 
        sql = String.format("SELECT characterSTR, characterSTRSave, characterDEX, characterDEXSave, " +
                "characterCON, characterCONSave, characterINT, characterINTSave, "
                + "characterWIS, characterWISSave, characterCHA, characterCHASave "
                + "FROM character_stats WHERE characterIDstats = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        if (!results.isBeforeFirst()) {
            statList.add("Null");
        } else {
            while (results.next()) {
            statList.add(results.getInt("characterSTR") +","+ results.getString("characterSTRSave") 
                + ","+ results.getInt("characterDEX") +","+ results.getString("characterDEXSave")
                + ","+ results.getInt("characterCON") +","+ results.getString("characterCONSave")
                + ","+ results.getInt("characterINT") +","+ results.getString("characterINTSave")
                + ","+ results.getInt("characterWIS") +","+ results.getString("characterWISSave")
                + ","+ results.getInt("characterCHA") +","+ results.getString("characterCHASave"));
            }
        }
        
        return statList;
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
