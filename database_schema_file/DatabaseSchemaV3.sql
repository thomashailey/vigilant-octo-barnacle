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
  `characterArmorID` int NOT NULL AUTO_INCREMENT,
  `characterIDarmor` int NOT NULL,
  `armorName` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `armorDescription` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`characterArmorID`),
  UNIQUE KEY `characterArmorID_UNIQUE` (`characterArmorID`),
  KEY `characterIDarmor_idx` (`characterIDarmor`),
  CONSTRAINT `characterIDarmor` FOREIGN KEY (`characterIDarmor`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
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
  `characterAC` int NOT NULL,
  `characterProficiencyMod` int NOT NULL,
  `characterHP` int NOT NULL,
  PRIMARY KEY (`characterID`),
  UNIQUE KEY `characterID_UNIQUE` (`characterID`),
  KEY `characterIDuser_idx` (`characterIDuser`),
  CONSTRAINT `characterIDuser` FOREIGN KEY (`characterIDuser`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_feats`
--

DROP TABLE IF EXISTS `character_feats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_feats` (
  `characterFeatID` int NOT NULL AUTO_INCREMENT,
  `characterIDfeat` int NOT NULL,
  `featListID` int NOT NULL,
  PRIMARY KEY (`characterFeatID`),
  UNIQUE KEY `characterFeatID_UNIQUE` (`characterFeatID`),
  KEY `characterIDfeat_idx` (`characterIDfeat`),
  KEY `featListID_idx` (`featListID`),
  CONSTRAINT `characterIDfeat` FOREIGN KEY (`characterIDfeat`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `featListID` FOREIGN KEY (`featListID`) REFERENCES `feats_list` (`featID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_inventory`
--

DROP TABLE IF EXISTS `character_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_inventory` (
  `characterInventoryID` int NOT NULL AUTO_INCREMENT,
  `characterIDinv` int NOT NULL,
  `inventoryItemName` varchar(60) NOT NULL,
  `inventoryItemDescription` varchar(200) DEFAULT NULL,
  `inventoryItemQuantity` int DEFAULT NULL,
  PRIMARY KEY (`characterInventoryID`),
  UNIQUE KEY `characterInventoryID_UNIQUE` (`characterInventoryID`),
  KEY `characterIDinv_idx` (`characterIDinv`),
  CONSTRAINT `characterIDinv` FOREIGN KEY (`characterIDinv`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_languages`
--

DROP TABLE IF EXISTS `character_languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_languages` (
  `characterLanguageID` int NOT NULL AUTO_INCREMENT,
  `characterIDLang` int NOT NULL,
  `languageName` varchar(45) NOT NULL,
  PRIMARY KEY (`characterLanguageID`),
  UNIQUE KEY `characterLanguageID_UNIQUE` (`characterLanguageID`),
  KEY `characterIDLang_idx` (`characterIDLang`),
  CONSTRAINT `characterIDLang` FOREIGN KEY (`characterIDLang`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_proficiencies`
--

DROP TABLE IF EXISTS `character_proficiencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_proficiencies` (
  `characterProficiencyID` int NOT NULL AUTO_INCREMENT,
  `characterIDprof` int NOT NULL,
  `proficiencyName` enum('Athletics','Acrobatics','Sleight of Hand','Stealth','Arcana','History','Investigation','Nature','Religion','Animal Handling','Insight','Medicine','Perception','Survival','Deception','Intimidation','Performance','Persuasion') NOT NULL,
  `proficiencyStatus` enum('Not Proficient','Proficient','Expertise') NOT NULL DEFAULT 'Not Proficient',
  `proficiencyTotal` int NOT NULL,
  PRIMARY KEY (`characterProficiencyID`),
  UNIQUE KEY `characterProficiencyID_UNIQUE` (`characterProficiencyID`),
  KEY `characterIDprof_idx` (`characterIDprof`),
  CONSTRAINT `characterIDprof` FOREIGN KEY (`characterIDprof`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_spells`
--

DROP TABLE IF EXISTS `character_spells`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_spells` (
  `characterSpellID` int NOT NULL AUTO_INCREMENT,
  `characterIDspell` int NOT NULL,
  `spellListID` int NOT NULL,
  PRIMARY KEY (`characterSpellID`),
  UNIQUE KEY `characterSpellID_UNIQUE` (`characterSpellID`),
  KEY `characterIDspell_idx` (`characterIDspell`),
  KEY `spellListID_idx` (`spellListID`),
  CONSTRAINT `characterIDspell` FOREIGN KEY (`characterIDspell`) REFERENCES `character_basics` (`characterID`),
  CONSTRAINT `spellListID` FOREIGN KEY (`spellListID`) REFERENCES `spell_table` (`spellID`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_spellslots`
--

DROP TABLE IF EXISTS `character_spellslots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_spellslots` (
  `characterSlotID` int NOT NULL AUTO_INCREMENT,
  `characterIDspells` int NOT NULL,
  `spellAttackModifier` int DEFAULT NULL,
  `spellSaveDC` int DEFAULT NULL,
  `spellSlotAvailable` int DEFAULT NULL,
  `spellSlotLevel` int DEFAULT NULL,
  PRIMARY KEY (`characterSlotID`),
  UNIQUE KEY `characterSlotID_UNIQUE` (`characterSlotID`),
  KEY `characterIDspells_idx` (`characterIDspells`),
  CONSTRAINT `characterIDspells` FOREIGN KEY (`characterIDspells`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_stats`
--

DROP TABLE IF EXISTS `character_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_stats` (
  `characterStatKey` int NOT NULL AUTO_INCREMENT,
  `characterID` int NOT NULL,
  `characterSTR` int NOT NULL,
  `characterSTRSave` enum('Yes','No') NOT NULL DEFAULT 'No',
  `characterDEX` int NOT NULL,
  `characterDEXSave` enum('Yes','No') NOT NULL DEFAULT 'No',
  `characterCON` int NOT NULL,
  `characterCONSave` enum('Yes','No') NOT NULL DEFAULT 'No',
  `characterINT` int NOT NULL,
  `characterINTSave` enum('Yes','No') NOT NULL DEFAULT 'No',
  `characterWIS` int NOT NULL,
  `characterWISSave` enum('Yes','No') NOT NULL DEFAULT 'No',
  `characterCHA` int NOT NULL,
  `characterCHASave` enum('Yes','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`characterStatKey`),
  UNIQUE KEY `characterStatKey_UNIQUE` (`characterStatKey`),
  UNIQUE KEY `characterID_UNIQUE` (`characterID`),
  KEY `characterID_idx` (`characterID`),
  CONSTRAINT `characterID` FOREIGN KEY (`characterID`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_tools`
--

DROP TABLE IF EXISTS `character_tools`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_tools` (
  `characterToolID` int NOT NULL AUTO_INCREMENT,
  `characterIDTool` int NOT NULL,
  `toolName` varchar(45) NOT NULL,
  `toolDescription` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`characterToolID`),
  UNIQUE KEY `characterToolsID_UNIQUE` (`characterToolID`),
  KEY `characterIDTool_idx` (`characterIDTool`),
  CONSTRAINT `characterIDTool` FOREIGN KEY (`characterIDTool`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `character_weapons`
--

DROP TABLE IF EXISTS `character_weapons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character_weapons` (
  `weaponID` int NOT NULL AUTO_INCREMENT,
  `characterIDweapon` int NOT NULL,
  `weaponName` varchar(60) NOT NULL,
  `weaponAttackBonus` int NOT NULL,
  `weaponDamage` varchar(30) NOT NULL,
  `weaponDescription` varchar(250) DEFAULT NULL,
  `weaponRange` int NOT NULL,
  PRIMARY KEY (`weaponID`),
  UNIQUE KEY `weaponID_UNIQUE` (`weaponID`),
  KEY `characterIDweapon_idx` (`characterIDweapon`),
  CONSTRAINT `characterIDweapon` FOREIGN KEY (`characterIDweapon`) REFERENCES `character_basics` (`characterID`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  PRIMARY KEY (`featID`),
  UNIQUE KEY `featID_UNIQUE` (`featID`),
  KEY `featCreatorID_idx` (`featCreatorID`),
  CONSTRAINT `featCreatorID` FOREIGN KEY (`featCreatorID`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `saved_items`
--

DROP TABLE IF EXISTS `saved_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saved_items` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `itemName` varchar(60) NOT NULL,
  `itemDescription` text NOT NULL,
  `itemType` enum('Armor','Potion','Ring','Rod','Scroll','Staff','Wand','Weapon','Wondrous Item') NOT NULL,
  `itemRarity` enum('Common','Uncommon','Rare','Very Rare','Legendary') NOT NULL,
  `itemCostNum` int NOT NULL DEFAULT '0',
  `itemCostType` enum('Copper','Silver','Electrum','Gold','Platinum') NOT NULL DEFAULT 'Gold',
  `itemAttuned` enum('True','False') NOT NULL DEFAULT 'False',
  `userID` int NOT NULL,
  PRIMARY KEY (`itemID`),
  UNIQUE KEY `itemID_UNIQUE` (`itemID`),
  KEY `userID_idx` (`userID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `spell_table`
--

DROP TABLE IF EXISTS `spell_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spell_table` (
  `spellID` int NOT NULL AUTO_INCREMENT,
  `spellName` varchar(100) NOT NULL,
  `spellLevel` int DEFAULT NULL,
  `spellRange` int DEFAULT NULL,
  `spellEffect` text,
  `spellSchool` enum('-','Abjuration','Conjuration','Divination','Enchantment','Evocation','Illusion','Necromancy','Transmutation') DEFAULT NULL,
  `spellCreatorID` int NOT NULL,
  PRIMARY KEY (`spellID`),
  UNIQUE KEY `spellID_UNIQUE` (`spellID`),
  KEY `spellCreatorID_idx` (`spellCreatorID`),
  CONSTRAINT `spellCreatorID` FOREIGN KEY (`spellCreatorID`) REFERENCES `user_data` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `userType` enum('Admin','Moderator','Standard') NOT NULL,
  `userName` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-11 20:48:51
