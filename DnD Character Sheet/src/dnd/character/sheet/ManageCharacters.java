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
        ArrayList<String> characterList = new ArrayList<>();
        
        // ID, name, level, race, class, publicChar
        // int charID, String charName, int charLevel, String charRace, String charClass, String publicChar,
        sql = String.format("SELECT * FROM character_basics WHERE characterID = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        while (results.next()) {
            characterList.add(results.getString("characterName") +","+ results.getInt("characterLevel") 
                    + ","+ results.getString("characterRace") + "," + results.getString("characterClass") + "," 
                            + results.getString("characterPublic"));
        }
        
        // AC, Proficiency Modifier, HP, Additional Notes
        // int charAC, int charProfMod, int charHP, String additionalNotes, 
        sql = String.format("SELECT characterAC, characterProficiencyMod, characterHP, characterAdditionalNotes "
                + "FROM character_fundamentals WHERE characterFundID = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            characterList.add(results.getInt("characterAC") +","+ results.getInt("characterProficiencyMod") 
                    + ","+ results.getInt("characterHP") + "," + results.getString("characterAdditionalNotes"));
        }
        
        // int strStat, boolean strProf, int dexStat, boolean dexProf, int conStat, boolean conProf, 
        // int intStat, boolean intProf, int wisStat, boolean wisProf, int chaStat, boolean chaProf
        sql = String.format("SELECT characterSTR, characterSTRSave, characterDEX, characterDEXSave, " +
                "characterCON, characterCONSave, characterINT, characterINTSave, "
                + "characterWIS, characterWISSave, characterCHA, characterCHASave "
                + "FROM character_stats WHERE characterIDstats = \'%d\'", characterID);
        statement = connection.prepareStatement(sql);
        results = statement.executeQuery();
        
        while (results.next()) {
            characterList.add(results.getInt("characterSTR") +","+ results.getString("characterSTRSave") 
                + ","+ results.getInt("characterDEX") +","+ results.getString("characterDEXSave")
                + ","+ results.getInt("characterCON") +","+ results.getString("characterCONSave")
                + ","+ results.getInt("characterINT") +","+ results.getString("characterINTSave")
                + ","+ results.getInt("characterWIS") +","+ results.getString("characterWISSave")
                + ","+ results.getInt("characterCHA") +","+ results.getString("characterCHASave"));
        }
        
        System.out.println(characterList);
        
        String name, race, charClass, privacy, notes, STRSave, DEXSave, CONSave, INTSave, WISSave, CHASave;
        int level, ac, profMod, hp, STR, DEX, CON, INT, WIS, CHA;
        
        String parsing = characterList.get(0);
        String[] informationList = parsing.split(",");
        
        // first set of info (name, level, race, class, public/private
        name = informationList[0];
        level = Integer.parseInt(informationList[1]);
        race = informationList[2];
        charClass = informationList[3];
        privacy = informationList[4];
        
        // second set of info (AC, ProfMod, HP, AdditionalNotes
        parsing = characterList.get(1);
        informationList = parsing.split(",");
        ac = Integer.parseInt(informationList[0]);
        profMod = Integer.parseInt(informationList[1]);
        hp = Integer.parseInt(informationList[2]);
        notes = informationList[3];
        
        // third set of info (spellsavedc, spellattackmod)
        parsing = characterList.get(2);
        informationList = parsing.split(",");
        STR = Integer.parseInt(informationList[0]);
        STRSave = informationList[1];
        DEX = Integer.parseInt(informationList[2]);
        DEXSave = informationList[3];
        CON = Integer.parseInt(informationList[4]);
        CONSave = informationList[5];
        INT = Integer.parseInt(informationList[6]);
        INTSave = informationList[7];
        WIS = Integer.parseInt(informationList[8]);
        WISSave = informationList[9];
        CHA = Integer.parseInt(informationList[10]);
        CHASave = informationList[11];
        
        
        Character character = new Character(characterID, name, level, race, charClass, privacy, 
            ac, profMod, hp, notes, STR, STRSave, DEX, DEXSave, 
            CON, CONSave, INT, INTSave, WIS, WISSave, CHA, CHASave);
        
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
