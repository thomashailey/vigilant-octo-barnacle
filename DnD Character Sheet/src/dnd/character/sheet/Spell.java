/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

/**
 *
 * @author Gina
 */
public class Spell {

    public Spell(int spellCreatorID, String spellName, int spellLevel, int spellRange, String spellEffect, String spellSchool, boolean spellPublic) {
        this.spellCreatorID = spellCreatorID;
        this.spellName = spellName;
        this.spellLevel = spellLevel;
        this.spellRange = spellRange;
        this.spellEffect = spellEffect;
        this.spellSchool = spellSchool;
        this.spellPublic = spellPublic;
    }
    
    private int spellCreatorID;
    private String spellName;
    private int spellLevel;
    private int spellRange;
    private String spellEffect;
    private String spellSchool;
    private boolean spellPublic;
    

    public int getSpellCreatorID() {
        return spellCreatorID;
    }

    public void setSpellCreatorID(int spellCreatorID) {
        this.spellCreatorID = spellCreatorID;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public int getSpellRange() {
        return spellRange;
    }

    public void setSpellRange(int spellRange) {
        this.spellRange = spellRange;
    }

    public String getSpellEffect() {
        return spellEffect;
    }

    public void setSpellEffect(String spellEffect) {
        this.spellEffect = spellEffect;
    }

    public String getSpellSchool() {
        return spellSchool;
    }

    public void setSpellSchool(String spellSchool) {
        this.spellSchool = spellSchool;
    }

    public boolean isSpellPublic() {
        return spellPublic;
    }

    public void setSpellPublic(boolean spellPublic) {
        this.spellPublic = spellPublic;
    }
    
}
