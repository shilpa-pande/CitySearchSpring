-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: citysearch
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admincity_classified`
--

DROP TABLE IF EXISTS `admincity_classified`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admincity_classified` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admincity_classified`
--

LOCK TABLES `admincity_classified` WRITE;
/*!40000 ALTER TABLE `admincity_classified` DISABLE KEYS */;
INSERT INTO `admincity_classified` VALUES (18,'sector 22,near vishal megamart','hospital','delhi','8433001626','aims123@gmail.com','Aims Hospital'),(20,'111,green park','hospital','Mumbai','7846536698','max@gmail.com','MAx Hospital'),(21,'12,gandhinagar','shopping malls','chennai','8973456880','dlf@gmail.com','DLF Mall'),(22,'dispensory road','shopping malls','bangaluru','8433001626','amb@gmail.com','Ambians MAll'),(23,'123,raipur','shopping malls','kolkata','8433001626','pacific@gmail.com','PAcific MAll'),(25,'delhi ina','colleges','delhi','8433001626','du@gmail.com','Delhi University'),(26,'kargi chowk','colleges','ddun','8433001626','du@gmail.com','Doon University'),(28,'12,gandhinagar','school','chennai','8433001626','dps@gmail.com','DPS'),(31,'112,kiran nagar','bank','delhi','8433001626','sbi@gmail.com','State Bank Of India'),(32,'123,raipur','bank','chennai','8433001626','canara@gmail.com','Canara Bank'),(33,'delhi ina','atm','bangaluru','8433001626','pnb.atm@gmail.com','Punjab Atm'),(36,'delhi ina','company','Mumbai','8433001626','tcs@gmail.com','TCS');
/*!40000 ALTER TABLE `admincity_classified` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_classified`
--

DROP TABLE IF EXISTS `city_classified`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_classified` (
  `id` int NOT NULL,
  `buysell` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cityuser_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmfpa8wcfk7ov42f584a75luor` (`cityuser_id`),
  CONSTRAINT `FKmfpa8wcfk7ov42f584a75luor` FOREIGN KEY (`cityuser_id`) REFERENCES `city_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_classified`
--

LOCK TABLES `city_classified` WRITE;
/*!40000 ALTER TABLE `city_classified` DISABLE KEYS */;
INSERT INTO `city_classified` VALUES (8,'buy','yellow color,gucci brand,etc','BAG',2),(9,'buy','maruti brand ,red in color','car',2),(10,'sell','formal dress','dress',2),(11,'sell','titan watch,golden look','watch',4),(12,'buy','blue in color,maruti suzuki','car',4),(13,'sell','new in condition,mi phone','phone',4),(14,'buy','lakme,red in color','lipstick',7),(15,'sell','long gown,blue in color with floral touch','dress',7),(16,'buy','bata shoes,brown in color','shoes',6),(17,'buy','banarasi saari  oragnge and blue colr','saari',6);
/*!40000 ALTER TABLE `city_classified` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_user`
--

DROP TABLE IF EXISTS `city_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_user` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dcmu74t1ggjqclnffbnn4q4ro` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_user`
--

LOCK TABLES `city_user` WRITE;
/*!40000 ALTER TABLE `city_user` DISABLE KEYS */;
INSERT INTO `city_user` VALUES (1,'112,kiran nagar','8433001626','gurgaon','shilpa@gmail.com','Shilpa PAndey','$2a$10$4FgyLHgBzBLZwi334wFgmu59mRUakn0EkOhS7mHi9Oob8cKSlbeOm','ROLE_ADMIN'),(2,'delhi ina','8433001626','chennai','shilpa1311@gmail.com','Shilpa PAndey','$2a$10$uRDy6oSGoZu4vh6mNvZVeeaZ.9MVZHw5ZyD18NRsMf74N4mHCTUOm','ROLE_USER'),(3,'123,raipur','9411507438','raipur','shivani@mail.com','Shivani Gupta','$2a$10$QKbvu4j7rY/bb4tNSSwdLeZSQyBgWjBvtTpHAzZRHUyOT1jVaQFRu','ROLE_USER'),(4,'12,gandhinagar','2436576878','chennai','pragya@gmail.com','pragya singh','$2a$10$/uzifIQt95g7Ee02SS/qF.M9oi4Oeu43MvZau4AgmXTNUHn.Ucxvu','ROLE_USER'),(5,'123,cross road','8976543288','mumbai','vikrant@gmail.com','vikrant','$2a$10$junXUxCycHD4mXJDDI0XauAhW.Bg7cLSxPNe130civ154f5WOTtN2','ROLE_USER'),(6,'190,gandhiroad','7896684976','ddun','preety@gmail.com','preety','$2a$10$72Mwx6/r3G9K9uSm5isaYO.57pjEJSBfcOSqZJgF.S348wvlIu1yG','ROLE_USER'),(7,'45,abc,street','8433001626','mumbai','mamta@gmail.com','mamta','$2a$10$sEipXZi/DO.ubj4xpV/LAu7Hc1X3MxjO2S5rbJC1RaBebJ2p6kbqK','ROLE_USER'),(27,'ddun','8433001626','delhi','admin@gmail.com','admin','$2a$10$nWKPHb5FE5O1fkHh/4UkluTBQPB/bkQarP/zEEMgzl5hw8.j2rYbO','ROLE_ADMIN');
/*!40000 ALTER TABLE `city_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (37);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17 15:22:08
