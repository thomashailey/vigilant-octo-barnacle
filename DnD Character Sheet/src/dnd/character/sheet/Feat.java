/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

/**
 *
 * @author Gina
 */
public class Feat {
    
    private int featCreatorID;
    private String featName;
    private String featDescription;
    private boolean featPublic;

    public Feat(int featCreatorID, String featName, String featDescription, boolean featPublic) {
        this.featCreatorID = featCreatorID;
        this.featName = featName;
        this.featDescription = featDescription;
        this.featPublic = featPublic;
    }

    public int getFeatCreatorID() {
        return featCreatorID;
    }

    public void setFeatCreatorID(int featCreatorID) {
        this.featCreatorID = featCreatorID;
    }

    public String getFeatName() {
        return featName;
    }

    public void setFeatName(String featName) {
        this.featName = featName;
    }

    public String getFeatDescription() {
        return featDescription;
    }

    public void setFeatDescription(String featDescription) {
        this.featDescription = featDescription;
    }

    public boolean isFeatPublic() {
        return featPublic;
    }

    public void setFeatPublic(boolean featPublic) {
        this.featPublic = featPublic;
    }
    
}
