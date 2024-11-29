/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

/**
 *
 * @author Gina
 */
public class Proficiency {

    public Proficiency(int proficiencyCreatorID, String proficiencyName, String proficiencyType, String proficiencyDescription, boolean proficiencyPublic) {
        this.proficiencyCreatorID = proficiencyCreatorID;
        this.proficiencyName = proficiencyName;
        this.proficiencyType = proficiencyType;
        this.proficiencyDescription = proficiencyDescription;
        this.proficiencyPublic = proficiencyPublic;
    }
    
    private int proficiencyCreatorID;
    private String proficiencyName;
    private String proficiencyType;
    private String proficiencyDescription;
    private boolean proficiencyPublic;

    public int getProficiencyCreatorID() {
        return proficiencyCreatorID;
    }

    public void setProficiencyCreatorID(int proficiencyCreatorID) {
        this.proficiencyCreatorID = proficiencyCreatorID;
    }

    public String getProficiencyName() {
        return proficiencyName;
    }

    public void setProficiencyName(String proficiencyName) {
        this.proficiencyName = proficiencyName;
    }

    public String getProficiencyType() {
        return proficiencyType;
    }

    public void setProficiencyType(String proficiencyType) {
        this.proficiencyType = proficiencyType;
    }

    public String getProficiencyDescription() {
        return proficiencyDescription;
    }

    public void setProficiencyDescription(String proficiencyDescription) {
        this.proficiencyDescription = proficiencyDescription;
    }

    public boolean isProficiencyPublic() {
        return proficiencyPublic;
    }

    public void setProficiencyPublic(boolean proficiencyPublic) {
        this.proficiencyPublic = proficiencyPublic;
    }
    
}
