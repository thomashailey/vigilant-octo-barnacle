CREATE DATABASE  IF NOT EXISTS `dnd_app_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dnd_app_database`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: dnd_app_database
-- ------------------------------------------------------
-- Server version	8.0.40

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
) ENGINE=InnoDB AUTO_INCREMENT=364 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-28 20:49:27
