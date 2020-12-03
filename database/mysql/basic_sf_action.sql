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
-- Table structure for table `sf_action`
--

DROP TABLE IF EXISTS `sf_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sf_action` (
  `APP_ID` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CODE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `SOURCE_CODE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `TARGET_CODE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `FLAG` varchar(1) CHARACTER SET latin1 DEFAULT '1',
  PRIMARY KEY (`APP_ID`,`CODE`),
  KEY `SF_ACTION_SF_STATE_FK1_idx` (`APP_ID`,`SOURCE_CODE`),
  KEY `SF_ACTION_SF_STATE_FK2_idx` (`APP_ID`,`TARGET_CODE`),
  CONSTRAINT `SF_ACTION_SF_STATE_FK1` FOREIGN KEY (`APP_ID`, `SOURCE_CODE`) REFERENCES `sf_state` (`APP_ID`, `CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SF_ACTION_SF_STATE_FK2` FOREIGN KEY (`APP_ID`, `TARGET_CODE`) REFERENCES `sf_state` (`APP_ID`, `CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sf_action`
--

LOCK TABLES `sf_action` WRITE;
/*!40000 ALTER TABLE `sf_action` DISABLE KEYS */;
INSERT INTO `sf_action` VALUES ('ecc-ei','1','开始流调','#','1','0'),('ecc-ei','2','提交流调个案','1','2','0'),('ecc-ei','3','提交报告','2','3','0'),('ecc-ei','4','撤回','2','1','0'),('ecc-ei','5','通过','3','4','0'),('ecc-ei','6','不通过','3','5','0'),('ecc-ei','7','撤回','3','1','0'),('ecc-ei','8','提交报告','5','3','0'),('emergency-control','1','开始流调','#','1','1'),('emergency-control','10','编辑流调个案','5','2','1'),('emergency-control','2','提交流调个案','1','2','1'),('emergency-control','3','提交报告','2','3','1'),('emergency-control','4','撤回','2','1','0'),('emergency-control','5','通过','3','4','1'),('emergency-control','6','不通过','3','5','1'),('emergency-control','7','撤回','3','2','1'),('emergency-control','8','提交报告','5','3','1'),('emergency-control','9','编辑流调个案','2','2','1');
/*!40000 ALTER TABLE `sf_action` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-02 23:01:07
