/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

/**
 *
 * @author Gina
 */
public class Character {
    
    private int charID;
    private String charName;
    private int charLevel;
    private String charRace;
    private String charClass;
    private String publicChar;
    
    private int charAC;
    private int charProfMod;
    private int charHP;
    
    private int spellSaveDC;
    private int spellAttackMod;
    
    private String additionalNotes;
    
    private int strStat;
    private String strProf;
    private int dexStat;
    private String dexProf;
    private int conStat;
    private String conProf;
    private int intStat;
    private String intProf;
    private int wisStat;
    private String wisProf;
    private int chaStat;
    private String chaProf;

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, String publicChar, 
            int strStat, String strProf, int dexStat, String dexProf, int conStat, String conProf, int intStat, String intProf, 
            int wisStat, String wisProf, int chaStat, String chaProf) {
        this.charID = charID;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charRace = charRace;
        this.charClass = charClass;
        this.publicChar = publicChar;
        this.strStat = strStat;
        this.strProf = strProf;
        this.dexStat = dexStat;
        this.dexProf = dexProf;
        this.conStat = conStat;
        this.conProf = conProf;
        this.intStat = intStat;
        this.intProf = intProf;
        this.wisStat = wisStat;
        this.wisProf = wisProf;
        this.chaStat = chaStat;
        this.chaProf = chaProf;
    }

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, String publicChar, 
            int charAC, int charProfMod, int charHP, int spellSaveDC, int spellAttackMod, String additionalNotes, int strStat, String strProf, 
            int dexStat, String dexProf, int conStat, String conProf, int intStat, String intProf, int wisStat, String wisProf, int chaStat, String chaProf) {
        this.charID = charID;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charRace = charRace;
        this.charClass = charClass;
        this.publicChar = publicChar;
        this.charAC = charAC;
        this.charProfMod = charProfMod;
        this.charHP = charHP;
        this.spellSaveDC = spellSaveDC;
        this.spellAttackMod = spellAttackMod;
        this.additionalNotes = additionalNotes;
        this.strStat = strStat;
        this.strProf = strProf;
        this.dexStat = dexStat;
        this.dexProf = dexProf;
        this.conStat = conStat;
        this.conProf = conProf;
        this.intStat = intStat;
        this.intProf = intProf;
        this.wisStat = wisStat;
        this.wisProf = wisProf;
        this.chaStat = chaStat;
        this.chaProf = chaProf;
    }

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, String publicChar, 
            int charAC, int charProfMod, int charHP, String additionalNotes, int strStat, String strProf, int dexStat, String dexProf, 
            int conStat, String conProf, int intStat, String intProf, int wisStat, String wisProf, int chaStat, String chaProf) {
        this.charID = charID;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charRace = charRace;
        this.charClass = charClass;
        this.publicChar = publicChar;
        this.charAC = charAC;
        this.charProfMod = charProfMod;
        this.charHP = charHP;
        this.additionalNotes = additionalNotes;
        this.strStat = strStat;
        this.strProf = strProf;
        this.dexStat = dexStat;
        this.dexProf = dexProf;
        this.conStat = conStat;
        this.conProf = conProf;
        this.intStat = intStat;
        this.intProf = intProf;
        this.wisStat = wisStat;
        this.wisProf = wisProf;
        this.chaStat = chaStat;
        this.chaProf = chaProf;
    }

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, String publicChar, 
            int charAC, int charProfMod, int charHP, String additionalNotes) {
        this.charID = charID;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charRace = charRace;
        this.charClass = charClass;
        this.publicChar = publicChar;
        this.charAC = charAC;
        this.charProfMod = charProfMod;
        this.charHP = charHP;
        this.additionalNotes = additionalNotes;
    }

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, String publicChar) {
        this.charID = charID;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charRace = charRace;
        this.charClass = charClass;
        this.publicChar = publicChar;
    }

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getPublicChar() {
        return publicChar;
    }

    public void setPublicChar(String publicChar) {
        this.publicChar = publicChar;
    }

    public int getCharAC() {
        return charAC;
    }

    public void setCharAC(int charAC) {
        this.charAC = charAC;
    }

    public int getCharProfMod() {
        return charProfMod;
    }

    public void setCharProfMod(int charProfMod) {
        this.charProfMod = charProfMod;
    }

    public int getCharHP() {
        return charHP;
    }

    public void setCharHP(int charHP) {
        this.charHP = charHP;
    }

    public int getSpellSaveDC() {
        return spellSaveDC;
    }

    public void setSpellSaveDC(int spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public int getSpellAttackMod() {
        return spellAttackMod;
    }

    public void setSpellAttackMod(int spellAttackMod) {
        this.spellAttackMod = spellAttackMod;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public int getStrStat() {
        return strStat;
    }

    public void setStrStat(int strStat) {
        this.strStat = strStat;
    }

    public String getStrProf() {
        return strProf;
    }

    public void setStrProf(String strProf) {
        this.strProf = strProf;
    }

    public int getDexStat() {
        return dexStat;
    }

    public void setDexStat(int dexStat) {
        this.dexStat = dexStat;
    }

    public String getDexProf() {
        return dexProf;
    }

    public void setDexProf(String dexProf) {
        this.dexProf = dexProf;
    }

    public int getConStat() {
        return conStat;
    }

    public void setConStat(int conStat) {
        this.conStat = conStat;
    }

    public String getConProf() {
        return conProf;
    }

    public void setConProf(String conProf) {
        this.conProf = conProf;
    }

    public int getIntStat() {
        return intStat;
    }

    public void setIntStat(int intStat) {
        this.intStat = intStat;
    }

    public String getIntProf() {
        return intProf;
    }

    public void setIntProf(String intProf) {
        this.intProf = intProf;
    }

    public int getWisStat() {
        return wisStat;
    }

    public void setWisStat(int wisStat) {
        this.wisStat = wisStat;
    }

    public String getWisProf() {
        return wisProf;
    }

    public void setWisProf(String wisProf) {
        this.wisProf = wisProf;
    }

    public int getChaStat() {
        return chaStat;
    }

    public void setChaStat(int chaStat) {
        this.chaStat = chaStat;
    }

    public String getChaProf() {
        return chaProf;
    }

    public void setChaProf(String chaProf) {
        this.chaProf = chaProf;
    }

    
    
}
