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
-- Table structure for table `sf_business_process`
--

DROP TABLE IF EXISTS `sf_business_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sf_business_process` (
  `APP_ID` varchar(50) NOT NULL,
  `BUSINESS_CODE` varchar(500) NOT NULL,
  `STATE_CODE` varchar(50) NOT NULL,
  PRIMARY KEY (`APP_ID`,`BUSINESS_CODE`),
  KEY `SF_BUZ_PROC_SF_STATE_FK_idx` (`APP_ID`,`STATE_CODE`),
  CONSTRAINT `SF_BUZ_PROC_SF_STATE_FK` FOREIGN KEY (`APP_ID`, `STATE_CODE`) REFERENCES `sf_state` (`APP_ID`, `CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sf_business_process`
--

LOCK TABLES `sf_business_process` WRITE;
/*!40000 ALTER TABLE `sf_business_process` DISABLE KEYS */;
INSERT INTO `sf_business_process` VALUES ('ecc-ei','1111111155|123','1'),('ecc-ei','123','1'),('emergency-control','1','1'),('emergency-control','123','1'),('emergency-control','24','1'),('emergency-control','28','1'),('emergency-control','32','1'),('emergency-control','64','1'),('emergency-control','71','1'),('emergency-control','75','1'),('emergency-control','100','2'),('emergency-control','26','2'),('emergency-control','33','2'),('emergency-control','47','2'),('emergency-control','48','2'),('emergency-control','49','2'),('emergency-control','50','2'),('emergency-control','51','2'),('emergency-control','52','2'),('emergency-control','39','3'),('emergency-control','82','3'),('emergency-control','90','3'),('emergency-control','102','4'),('emergency-control','103','4'),('emergency-control','105','4'),('emergency-control','106','4'),('emergency-control','107','4'),('emergency-control','108','4'),('emergency-control','112','4'),('emergency-control','12','4'),('emergency-control','38','4'),('emergency-control','40','4'),('emergency-control','41','4'),('emergency-control','42','4'),('emergency-control','43','4'),('emergency-control','44','4'),('emergency-control','53','4'),('emergency-control','54','4'),('emergency-control','56','4'),('emergency-control','57','4'),('emergency-control','58','4'),('emergency-control','59','4'),('emergency-control','60','4'),('emergency-control','61','4'),('emergency-control','62','4'),('emergency-control','63','4'),('emergency-control','65','4'),('emergency-control','66','4'),('emergency-control','67','4'),('emergency-control','68','4'),('emergency-control','69','4'),('emergency-control','70','4'),('emergency-control','72','4'),('emergency-control','74','4'),('emergency-control','78','4'),('emergency-control','79','4'),('emergency-control','80','4'),('emergency-control','81','4'),('emergency-control','84','4'),('emergency-control','85','4'),('emergency-control','86','4'),('emergency-control','87','4'),('emergency-control','88','4'),('emergency-control','91','4'),('emergency-control','94','4'),('emergency-control','98','4'),('emergency-control','21','5'),('emergency-control','55','5'),('emergency-control','95','5');
/*!40000 ALTER TABLE `sf_business_process` ENABLE KEYS */;
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
