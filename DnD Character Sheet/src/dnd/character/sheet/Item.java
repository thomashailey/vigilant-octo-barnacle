/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dnd.character.sheet;

/**
 *
 * @author Gina
 */
public class Item {
    
    private int itemCreatorID;
    private String itemName;
    private String itemDescription;
    private String itemType;
    private String itemRarity;
    private int itemCostNum;
    private String itemCostType;
    private boolean itemAttuned;
    
    private boolean itemPublic;
    
    private int weaponAttackBonus;
    private int weaponAttackRange;
    private String weaponDamage;
    
    
    public Item(int itemCreatorID, String itemName, String itemDescription, String itemType, String itemRarity, int itemCostNum, String itemCostType, boolean itemAttuned, boolean itemPublic, int weaponAttackBonus, int weaponAttackRange, String weaponDamage) {
        this.itemCreatorID = itemCreatorID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemRarity = itemRarity;
        this.itemCostNum = itemCostNum;
        this.itemCostType = itemCostType;
        this.itemAttuned = itemAttuned;
        this.itemPublic = itemPublic;
        this.weaponAttackBonus = weaponAttackBonus;
        this.weaponAttackRange = weaponAttackRange;
        this.weaponDamage = weaponDamage;
    }
    

    public Item(int itemCreatorID, String itemName, String itemDescription, String itemType, String itemRarity, int itemCostNum, String itemCostType, boolean itemAttuned, boolean itemPublic) {
        this.itemCreatorID = itemCreatorID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemRarity = itemRarity;
        this.itemCostNum = itemCostNum;
        this.itemCostType = itemCostType;
        this.itemAttuned = itemAttuned;
        this.itemPublic = itemPublic;
    }
    

    public int getItemCreatorID() {
        return itemCreatorID;
    }

    public void setItemCreatorID(int itemCreatorID) {
        this.itemCreatorID = itemCreatorID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemRarity() {
        return itemRarity;
    }

    public void setItemRarity(String itemRarity) {
        this.itemRarity = itemRarity;
    }

    public int getItemCostNum() {
        return itemCostNum;
    }

    public void setItemCostNum(int itemCostNum) {
        this.itemCostNum = itemCostNum;
    }

    public String getItemCostType() {
        return itemCostType;
    }

    public void setItemCostType(String itemCostType) {
        this.itemCostType = itemCostType;
    }

    public boolean isItemAttuned() {
        return itemAttuned;
    }

    public void setItemAttuned(boolean itemAttuned) {
        this.itemAttuned = itemAttuned;
    }

    public boolean isItemPublic() {
        return itemPublic;
    }

    public void setItemPublic(boolean itemPublic) {
        this.itemPublic = itemPublic;
    }

    public int getWeaponAttackBonus() {
        return weaponAttackBonus;
    }

    public void setWeaponAttackBonus(int weaponAttackBonus) {
        this.weaponAttackBonus = weaponAttackBonus;
    }

    public int getWeaponAttackRange() {
        return weaponAttackRange;
    }

    public void setWeaponAttackRange(int weaponAttackRange) {
        this.weaponAttackRange = weaponAttackRange;
    }

    public String getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(String weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    
}
