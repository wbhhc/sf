-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 10.1.51.215    Database: basic
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `sf_state`
--

DROP TABLE IF EXISTS `sf_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sf_state` (
  `APP_ID` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CODE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `FLAG` varchar(1) CHARACTER SET latin1 DEFAULT '1',
  PRIMARY KEY (`APP_ID`,`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sf_state`
--

LOCK TABLES `sf_state` WRITE;
/*!40000 ALTER TABLE `sf_state` DISABLE KEYS */;
INSERT INTO `sf_state` VALUES ('ecc-ei','#','开始','1'),('ecc-ei','1','待流调','1'),('ecc-ei','2','已流调','1'),('ecc-ei','3','待审核','1'),('ecc-ei','4','审核通过','1'),('ecc-ei','5','审核未通过','1'),('emergency-control','#','开始','1'),('emergency-control','1','待流调','1'),('emergency-control','2','已流调','1'),('emergency-control','3','待审核','1'),('emergency-control','4','审核通过','1'),('emergency-control','5','审核未通过','1');
/*!40000 ALTER TABLE `sf_state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-02 23:01:08
