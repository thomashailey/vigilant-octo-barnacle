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
    private boolean publicChar;
    
    private int charAC;
    private int charProfMod;
    private int charHP;
    
    private int spellSaveDC;
    private int spellAttackMod;
    
    private String additionalNotes;
    
    private int strStat;
    private boolean strProf;
    private int dexStat;
    private boolean dexProf;
    private int conStat;
    private boolean conProf;
    private int intStat;
    private boolean intProf;
    private int wisStat;
    private boolean wisProf;
    private int chaStat;
    private boolean chaProf;

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, boolean publicChar, int charAC, int charProfMod, int charHP, int spellSaveDC, int spellAttackMod, String additionalNotes, int strStat, boolean strProf, int dexStat, boolean dexProf, int conStat, boolean conProf, int intStat, boolean intProf, int wisStat, boolean wisProf, int chaStat, boolean chaProf) {
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


    public Character(int charID, String charName, int charLevel, String charRace, String charClass, boolean publicChar, int charAC, int charProfMod, int charHP, String additionalNotes, int strStat, boolean strProf, int dexStat, boolean dexProf, int conStat, boolean conProf, int intStat, boolean intProf, int wisStat, boolean wisProf, int chaStat, boolean chaProf) {
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

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, boolean publicChar, int charAC, int charProfMod, int charHP, String additionalNotes) {
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

    public Character(int charID, String charName, int charLevel, String charRace, String charClass, boolean publicChar) {
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

    public boolean isPublicChar() {
        return publicChar;
    }

    public void setPublicChar(boolean publicChar) {
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

    public boolean isStrProf() {
        return strProf;
    }

    public void setStrProf(boolean strProf) {
        this.strProf = strProf;
    }

    public int getDexStat() {
        return dexStat;
    }

    public void setDexStat(int dexStat) {
        this.dexStat = dexStat;
    }

    public boolean isDexProf() {
        return dexProf;
    }

    public void setDexProf(boolean dexProf) {
        this.dexProf = dexProf;
    }

    public int getConStat() {
        return conStat;
    }

    public void setConStat(int conStat) {
        this.conStat = conStat;
    }

    public boolean isConProf() {
        return conProf;
    }

    public void setConProf(boolean conProf) {
        this.conProf = conProf;
    }

    public int getIntStat() {
        return intStat;
    }

    public void setIntStat(int intStat) {
        this.intStat = intStat;
    }

    public boolean isIntProf() {
        return intProf;
    }

    public void setIntProf(boolean intProf) {
        this.intProf = intProf;
    }

    public int getWisStat() {
        return wisStat;
    }

    public void setWisStat(int wisStat) {
        this.wisStat = wisStat;
    }

    public boolean isWisProf() {
        return wisProf;
    }

    public void setWisProf(boolean wisProf) {
        this.wisProf = wisProf;
    }

    public int getChaStat() {
        return chaStat;
    }

    public void setChaStat(int chaStat) {
        this.chaStat = chaStat;
    }

    public boolean isChaProf() {
        return chaProf;
    }

    public void setChaProf(boolean chaProf) {
        this.chaProf = chaProf;
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
    
    
    
}
