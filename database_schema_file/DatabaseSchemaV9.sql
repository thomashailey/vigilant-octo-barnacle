CREATE DATABASE  IF NOT EXISTS `dnd_app_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dnd_app_database`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: dnd_app_database
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `character_armor`
--

DROP TABLE IF EXISTS `character_armor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_armor` (
  `characterArmorPK` int NOT NULL AUTO_INCREMENT,
  `characterIDarmor` int NOT NULL,
  `armorItemID` int NOT NULL,
  PRIMARY KEY (`characterArmorPK`),
  UNIQUE KEY `characterArmorPK_UNIQUE` (`characterArmorPK`),
  KEY `characterIDarmor_idx` (`characterIDarmor`),
  KEY `armorID_idx` (`armorItemID`),
  CONSTRAINT `armorID` FOREIGN KEY (`armorItemID`) REFERENCES `saved_items` (`itemID`),
  CONSTRAINT `characterIDarmor` FOREIGN KEY (`characterIDarmor`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_basics`
--

DROP TABLE IF EXISTS `character_basics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_basics` (
  `characterID` int NOT NULL AUTO_INCREMENT,
  `characterIDuser` int NOT NULL,
  `characterName` varchar(60) NOT NULL,
  `characterLevel` int NOT NULL,
  `characterRace` varchar(45) NOT NULL,
  `characterClass` varchar(45) NOT NULL,
  `characterPublic` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`characterID`),
  UNIQUE KEY `characterID_UNIQUE` (`characterID`),
  KEY `characterIDuser_idx` (`characterIDuser`),
  CONSTRAINT `characterIDuser` FOREIGN KEY (`characterIDuser`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_feats`
--

DROP TABLE IF EXISTS `character_feats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_feats` (
  `characterFeatPK` int NOT NULL AUTO_INCREMENT,
  `characterIDfeat` int NOT NULL,
  `featListID` int NOT NULL,
  PRIMARY KEY (`characterFeatPK`),
  UNIQUE KEY `characterFeatPK_UNIQUE` (`characterFeatPK`),
  KEY `characterIDfeat_idx` (`characterIDfeat`),
  KEY `featListID_idx` (`featListID`),
  CONSTRAINT `characterIDfeat` FOREIGN KEY (`characterIDfeat`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `featListID` FOREIGN KEY (`featListID`) REFERENCES `feats_list` (`featID`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_fundamentals`
--

DROP TABLE IF EXISTS `character_fundamentals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_fundamentals` (
  `characterFundPK` int NOT NULL AUTO_INCREMENT,
  `characterFundID` int NOT NULL,
  `characterAC` int DEFAULT NULL,
  `characterProficiencyMod` int DEFAULT NULL,
  `characterHP` int DEFAULT NULL,
  `characterAdditionalNotes` text,
  PRIMARY KEY (`characterFundPK`),
  UNIQUE KEY `characterFundID_UNIQUE` (`characterFundID`),
  UNIQUE KEY `characterFundPK_UNIQUE` (`characterFundPK`),
  CONSTRAINT `characterFundID` FOREIGN KEY (`characterFundID`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_inventory`
--

DROP TABLE IF EXISTS `character_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_inventory` (
  `characterInventoryPK` int NOT NULL AUTO_INCREMENT,
  `characterIDinventory` int NOT NULL,
  `inventoryItemName` varchar(60) NOT NULL,
  `inventoryItemDescription` varchar(200) DEFAULT NULL,
  `inventoryItemQuantity` int DEFAULT NULL,
  PRIMARY KEY (`characterInventoryPK`),
  UNIQUE KEY `characterInventoryID_UNIQUE` (`characterInventoryPK`),
  KEY `characterIDinv_idx` (`characterIDinventory`),
  CONSTRAINT `characterIDinventory` FOREIGN KEY (`characterIDinventory`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=591 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_otherproficiencies`
--

DROP TABLE IF EXISTS `character_otherproficiencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_otherproficiencies` (
  `characterOtherProficiencyPK` int NOT NULL AUTO_INCREMENT,
  `characterIDotherproficiency` int NOT NULL,
  `characterProficiencyListID` int NOT NULL,
  PRIMARY KEY (`characterOtherProficiencyPK`),
  UNIQUE KEY `characterOtherProficiencyPK_UNIQUE` (`characterOtherProficiencyPK`),
  KEY `characterIDotherproficiency_idx` (`characterIDotherproficiency`),
  KEY `characterProficiencyListID_idx` (`characterProficiencyListID`),
  CONSTRAINT `characterIDotherproficiency` FOREIGN KEY (`characterIDotherproficiency`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `characterProficiencyListID` FOREIGN KEY (`characterProficiencyListID`) REFERENCES `proficiencies_list` (`proficiencyID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_skillproficiencies`
--

DROP TABLE IF EXISTS `character_skillproficiencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_skillproficiencies` (
  `characterSkillProficiencyPK` int NOT NULL AUTO_INCREMENT,
  `characterIDskillproficiency` int NOT NULL,
  `proficiencyName` enum('Athletics','Acrobatics','Sleight of Hand','Stealth','Arcana','History','Investigation','Nature','Religion','Animal Handling','Insight','Medicine','Perception','Survival','Deception','Intimidation','Performance','Persuasion') NOT NULL,
  `proficiencyStatus` enum('Not Proficient','Proficient','Expertise') NOT NULL DEFAULT 'Not Proficient',
  PRIMARY KEY (`characterSkillProficiencyPK`),
  UNIQUE KEY `characterProficiencyID_UNIQUE` (`characterSkillProficiencyPK`),
  KEY `characterIDprof_idx` (`characterIDskillproficiency`),
  CONSTRAINT `characterIDproficiency` FOREIGN KEY (`characterIDskillproficiency`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=593 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_spellattackinfo`
--

DROP TABLE IF EXISTS `character_spellattackinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_spellattackinfo` (
  `characterSpellAttackPK` int NOT NULL AUTO_INCREMENT,
  `characterSpellAttackID` int NOT NULL,
  `spellAttackModifier` int DEFAULT NULL,
  `spellSaveDC` int DEFAULT NULL,
  PRIMARY KEY (`characterSpellAttackPK`),
  UNIQUE KEY `characterSpellAttackPK_UNIQUE` (`characterSpellAttackID`),
  CONSTRAINT `characterSpellAttackID` FOREIGN KEY (`characterSpellAttackID`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_spells`
--

DROP TABLE IF EXISTS `character_spells`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_spells` (
  `characterSpellPK` int NOT NULL AUTO_INCREMENT,
  `characterIDspell` int NOT NULL,
  `spellListID` int NOT NULL,
  PRIMARY KEY (`characterSpellPK`),
  UNIQUE KEY `characterSpellID_UNIQUE` (`characterSpellPK`),
  KEY `characterIDspell_idx` (`characterIDspell`),
  KEY `spellListID_idx` (`spellListID`),
  CONSTRAINT `characterIDspell` FOREIGN KEY (`characterIDspell`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `spellListID` FOREIGN KEY (`spellListID`) REFERENCES `spell_table` (`spellID`)
) ENGINE=InnoDB AUTO_INCREMENT=395 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_spellslots`
--

DROP TABLE IF EXISTS `character_spellslots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_spellslots` (
  `characterSlotPK` int NOT NULL AUTO_INCREMENT,
  `characterIDspellslots` int NOT NULL,
  `spellSlotLevel` int DEFAULT NULL,
  PRIMARY KEY (`characterSlotPK`),
  UNIQUE KEY `characterSlotID_UNIQUE` (`characterSlotPK`),
  KEY `characterIDspells_idx` (`characterIDspellslots`),
  CONSTRAINT `characterIDspellslots` FOREIGN KEY (`characterIDspellslots`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=545 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_stats`
--

DROP TABLE IF EXISTS `character_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_stats` (
  `characterStatPK` int NOT NULL AUTO_INCREMENT,
  `characterIDstats` int NOT NULL,
  `characterSTR` int DEFAULT NULL,
  `characterSTRSave` enum('Yes','No') DEFAULT 'No',
  `characterDEX` int DEFAULT NULL,
  `characterDEXSave` enum('Yes','No') DEFAULT 'No',
  `characterCON` int DEFAULT NULL,
  `characterCONSave` enum('Yes','No') DEFAULT 'No',
  `characterINT` int DEFAULT NULL,
  `characterINTSave` enum('Yes','No') DEFAULT 'No',
  `characterWIS` int DEFAULT NULL,
  `characterWISSave` enum('Yes','No') DEFAULT 'No',
  `characterCHA` int DEFAULT NULL,
  `characterCHASave` enum('Yes','No') DEFAULT 'No',
  PRIMARY KEY (`characterStatPK`),
  UNIQUE KEY `characterStatKey_UNIQUE` (`characterStatPK`),
  UNIQUE KEY `characterID_UNIQUE` (`characterIDstats`),
  KEY `characterID_idx` (`characterIDstats`),
  CONSTRAINT `characterIDstats` FOREIGN KEY (`characterIDstats`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=564 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_weapons`
--

DROP TABLE IF EXISTS `character_weapons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_weapons` (
  `characterWeaponPK` int NOT NULL AUTO_INCREMENT,
  `characterIDweapons` int NOT NULL,
  `weaponsListID` int NOT NULL,
  PRIMARY KEY (`characterWeaponPK`),
  UNIQUE KEY `weaponID_UNIQUE` (`characterWeaponPK`),
  KEY `characterIDweapon_idx` (`characterIDweapons`),
  KEY `weaponsListID_idx` (`weaponsListID`),
  CONSTRAINT `characterIDweapons` FOREIGN KEY (`characterIDweapons`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `weaponsListID` FOREIGN KEY (`weaponsListID`) REFERENCES `weapons_list` (`weaponPK`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feats_list`
--

DROP TABLE IF EXISTS `feats_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feats_list` (
  `featID` int NOT NULL AUTO_INCREMENT,
  `featCreatorID` int NOT NULL,
  `featName` varchar(100) NOT NULL,
  `featDescription` text NOT NULL,
  `featsPublic` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`featID`),
  UNIQUE KEY `featID_UNIQUE` (`featID`),
  KEY `featCreatorID_idx` (`featCreatorID`),
  CONSTRAINT `featCreatorID` FOREIGN KEY (`featCreatorID`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proficiencies_list`
--

DROP TABLE IF EXISTS `proficiencies_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proficiencies_list` (
  `proficiencyID` int NOT NULL AUTO_INCREMENT,
  `userIDproficiencies` int NOT NULL,
  `proficiencyType` enum('Language','Tool','Weapon','Armor') NOT NULL,
  `proficiencyName` varchar(60) NOT NULL,
  `proficiencyDescription` text,
  `proficiencyPublic` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`proficiencyID`),
  UNIQUE KEY `proficiencyID_UNIQUE` (`proficiencyID`),
  KEY `userIDproficiencies_idx` (`userIDproficiencies`),
  CONSTRAINT `userIDproficiencies` FOREIGN KEY (`userIDproficiencies`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `saved_items`
--

DROP TABLE IF EXISTS `saved_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_items` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `userIDitems` int NOT NULL,
  `itemName` varchar(60) NOT NULL,
  `itemDescription` text NOT NULL,
  `itemType` enum('Armor','Potion','Ring','Rod','Scroll','Staff','Wand','Weapon','Wondrous Item') NOT NULL,
  `itemRarity` enum('Common','Uncommon','Rare','Very Rare','Legendary') NOT NULL,
  `itemCostNum` int NOT NULL DEFAULT '0',
  `itemCostType` enum('Copper','Silver','Electrum','Gold','Platinum') NOT NULL DEFAULT 'Gold',
  `itemAttuned` enum('True','False') NOT NULL DEFAULT 'False',
  `itemsPublic` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`itemID`),
  UNIQUE KEY `itemID_UNIQUE` (`itemID`),
  KEY `userID_idx` (`userIDitems`),
  CONSTRAINT `userIDitems` FOREIGN KEY (`userIDitems`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=546 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `spell_table`
--

DROP TABLE IF EXISTS `spell_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_table` (
  `spellID` int NOT NULL AUTO_INCREMENT,
  `spellCreatorID` int NOT NULL,
  `spellName` varchar(100) NOT NULL,
  `spellLevel` int DEFAULT NULL,
  `spellRange` int DEFAULT NULL,
  `spellEffect` text,
  `spellSchool` enum('-','Abjuration','Conjuration','Divination','Enchantment','Evocation','Illusion','Necromancy','Transmutation') DEFAULT NULL,
  `spellsPublic` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`spellID`),
  UNIQUE KEY `spellID_UNIQUE` (`spellID`),
  KEY `spellCreatorID_idx` (`spellCreatorID`),
  CONSTRAINT `spellCreatorID` FOREIGN KEY (`spellCreatorID`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_data` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userPassword` varchar(20) NOT NULL,
  `userType` enum('AdminLevelOne','AdminLevelTwo','Moderator','Standard') NOT NULL,
  `userName` varchar(45) NOT NULL,
  `userVerificationCode` int NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weapons_list`
--

DROP TABLE IF EXISTS `weapons_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapons_list` (
  `weaponPK` int NOT NULL AUTO_INCREMENT,
  `weaponItemID` int NOT NULL,
  `weaponAttackBonus` int DEFAULT NULL,
  `weaponDamage` varchar(45) DEFAULT NULL,
  `weaponRange` int DEFAULT NULL,
  PRIMARY KEY (`weaponPK`),
  UNIQUE KEY `weaponPK_UNIQUE` (`weaponPK`),
  UNIQUE KEY `weaponsItemID_UNIQUE` (`weaponItemID`),
  CONSTRAINT `weaponItemID` FOREIGN KEY (`weaponItemID`) REFERENCES `saved_items` (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-02 20:17:00
