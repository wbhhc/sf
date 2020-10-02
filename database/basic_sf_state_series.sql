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
-- Table structure for table `sf_state_series`
--

DROP TABLE IF EXISTS `sf_state_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sf_state_series` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APP_ID` varchar(50) CHARACTER SET latin1 NOT NULL,
  `BUSINESS_CODE` varchar(500) CHARACTER SET latin1 NOT NULL,
  `ACTION_CODE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATE_USER_CODE` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `CREATE_USER_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(2000) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `I_SF_STATE_SERIES2` (`CREATE_TIME`),
  KEY `I_SF_STATE_SERIES1` (`APP_ID`,`BUSINESS_CODE`),
  KEY `SF_STATE_SERIES_SF_ACTION_FK_idx` (`APP_ID`,`ACTION_CODE`),
  CONSTRAINT `SF_STATE_SERIES_SF_ACTION_FK` FOREIGN KEY (`APP_ID`, `ACTION_CODE`) REFERENCES `sf_action` (`APP_ID`, `CODE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sf_state_series`
--

LOCK TABLES `sf_state_series` WRITE;
/*!40000 ALTER TABLE `sf_state_series` DISABLE KEYS */;
INSERT INTO `sf_state_series` VALUES (3,'ecc-ei','123','1','2020-09-10 09:44:17','-','-',NULL),(12,'ecc-ei','1111111155|123','1','2020-09-14 06:11:25','-','-',NULL),(13,'emergency-control','24','2','2020-09-14 06:41:39','-','-',NULL),(16,'emergency-control','24','2','2020-09-14 07:01:14','-','-',NULL),(17,'emergency-control','24','2','2020-09-14 07:01:42','-','-',NULL),(21,'emergency-control','26','2','2020-09-15 01:35:29','-','-',NULL),(22,'emergency-control','24','4','2020-09-15 02:05:49','-','-',NULL),(23,'emergency-control','24','4','2020-09-15 02:08:15','-','-',NULL),(24,'emergency-control','24','4','2020-09-15 02:08:41','-','-',NULL),(25,'emergency-control','24','4','2020-09-15 02:13:44','-','-',NULL),(26,'emergency-control','24','4','2020-09-15 02:27:15','-','-',NULL),(27,'emergency-control','28','2','2020-09-15 03:15:00','-','-',NULL),(28,'emergency-control','32','4','2020-09-15 06:24:18','-','-',NULL),(29,'emergency-control','1','4','2020-09-15 06:25:30','-','-',NULL),(30,'emergency-control','32','4','2020-09-15 06:30:55','-','-',NULL),(31,'emergency-control','28','4','2020-09-15 06:31:07','-','-',NULL),(32,'emergency-control','28','2','2020-09-15 07:56:31','-','-',NULL),(33,'emergency-control','28','4','2020-09-15 07:57:34','-','-',NULL),(34,'emergency-control','28','2','2020-09-15 08:00:36','-','-',NULL),(35,'emergency-control','28','4','2020-09-15 08:02:12','-','-',NULL),(36,'emergency-control','33','2','2020-09-15 08:30:12','-','-',NULL),(37,'emergency-control','12','3','2020-09-16 02:05:36','-','-',NULL),(38,'emergency-control','12','7','2020-09-16 02:07:13','-','-',NULL),(39,'emergency-control','12','3','2020-09-16 02:08:01','-','-',NULL),(40,'emergency-control','12','5','2020-09-16 02:08:36','-','-',NULL),(41,'emergency-control','12','3','2020-09-16 02:11:12','-','-',NULL),(42,'emergency-control','12','6','2020-09-16 02:12:45','-','-',NULL),(43,'emergency-control','12','3','2020-09-16 02:15:56','-','-',NULL),(44,'emergency-control','38','2','2020-09-16 06:54:52','-','-',NULL),(45,'emergency-control','38','2','2020-09-16 06:56:44','-','-',NULL),(46,'emergency-control','38','3','2020-09-16 07:28:28','-','-',NULL),(47,'emergency-control','38','5','2020-09-16 07:30:15','-','-',NULL),(48,'emergency-control','39','2','2020-09-16 07:31:43','-','-',NULL),(49,'emergency-control','39','3','2020-09-16 07:44:20','-','-',NULL),(50,'emergency-control','39','7','2020-09-16 07:44:52','-','-',NULL),(51,'emergency-control','39','2','2020-09-16 07:48:21','-','-',NULL),(52,'emergency-control','39','3','2020-09-16 07:49:36','-','-',NULL),(53,'emergency-control','39','6','2020-09-16 07:50:11','-','-',NULL),(54,'emergency-control','39','3','2020-09-16 07:50:59','-','-',NULL),(55,'emergency-control','39','5','2020-09-16 07:55:33','-','-',NULL),(56,'emergency-control','40','2','2020-09-17 00:43:27','-','-',NULL),(57,'emergency-control','40','3','2020-09-17 00:43:41','-','-',NULL),(58,'emergency-control','40','7','2020-09-17 00:52:17','-','-',NULL),(59,'emergency-control','40','2','2020-09-17 01:12:59','-','-',NULL),(60,'emergency-control','40','3','2020-09-17 01:13:32','-','-',NULL),(61,'emergency-control','40','7','2020-09-17 01:14:09','-','-',NULL),(62,'emergency-control','40','2','2020-09-17 01:14:23','-','-',NULL),(63,'emergency-control','40','3','2020-09-17 01:22:52','-','-',NULL),(64,'emergency-control','40','6','2020-09-17 01:23:19','-','-',NULL),(65,'emergency-control','40','8','2020-09-17 01:35:06','-','-',NULL),(66,'emergency-control','40','5','2020-09-17 01:35:44','-','-',NULL),(67,'emergency-control','41','2','2020-09-17 02:04:08','-','-',NULL),(68,'emergency-control','41','3','2020-09-17 02:15:47','-','-',NULL),(69,'emergency-control','41','6','2020-09-17 02:16:12','-','-',NULL),(70,'emergency-control','41','8','2020-09-17 02:17:21','-','-',NULL),(71,'emergency-control','41','5','2020-09-17 02:17:33','-','-',NULL),(72,'emergency-control','42','2','2020-09-17 02:25:17','-','-',NULL),(73,'emergency-control','42','3','2020-09-17 02:27:27','-','-',NULL),(74,'emergency-control','42','7','2020-09-17 02:27:33','-','-',NULL),(75,'emergency-control','42','2','2020-09-17 02:50:03','-','-',NULL),(76,'emergency-control','42','3','2020-09-17 02:50:44','-','-',NULL),(77,'emergency-control','42','6','2020-09-17 02:51:00','-','-',NULL),(78,'emergency-control','42','8','2020-09-17 02:52:23','-','-',NULL),(79,'emergency-control','42','5','2020-09-17 02:52:34','-','-',NULL),(80,'emergency-control','42','7','2020-09-17 03:22:20','-','-',NULL),(81,'emergency-control','42','2','2020-09-17 03:23:38','-','-',NULL),(82,'emergency-control','42','3','2020-09-17 03:24:08','-','-',NULL),(83,'emergency-control','42','6','2020-09-17 03:24:25','-','-',NULL),(84,'emergency-control','42','8','2020-09-17 03:24:49','-','-',NULL),(85,'emergency-control','42','5','2020-09-17 03:25:02','-','-',NULL),(86,'emergency-control','43','2','2020-09-17 06:05:42','-','-',NULL),(87,'emergency-control','43','3','2020-09-17 06:13:56','-','-',NULL),(88,'emergency-control','43','5','2020-09-17 06:14:05','-','-',NULL),(89,'emergency-control','44','2','2020-09-17 06:15:16','-','-',NULL),(90,'emergency-control','44','3','2020-09-17 06:18:22','-','-',NULL),(91,'emergency-control','44','5','2020-09-17 06:18:57','-','-',NULL),(92,'emergency-control','47','2','2020-09-17 06:22:29','-','-',NULL),(93,'emergency-control','48','2','2020-09-17 06:34:36','-','-',NULL),(94,'emergency-control','49','2','2020-09-17 06:42:55','-','-',NULL),(95,'emergency-control','50','2','2020-09-17 06:45:57','-','-',NULL),(96,'emergency-control','51','2','2020-09-17 07:08:01','-','-',NULL),(97,'emergency-control','52','2','2020-09-17 07:16:46','-','-',NULL),(98,'emergency-control','53','4','2020-09-17 07:26:04','-','-',NULL),(99,'emergency-control','53','3','2020-09-17 07:28:15','-','-',NULL),(100,'emergency-control','53','6','2020-09-17 07:28:55','-','-',NULL),(101,'emergency-control','53','8','2020-09-17 07:30:04','-','-',NULL),(102,'emergency-control','53','6','2020-09-17 07:30:26','-','-',NULL),(103,'emergency-control','53','8','2020-09-17 07:30:30','-','-',NULL),(104,'emergency-control','53','5','2020-09-17 07:30:48','-','-',NULL),(105,'emergency-control','54','4','2020-09-17 07:33:23','-','-',NULL),(106,'emergency-control','54','3','2020-09-17 07:35:24','-','-',NULL),(107,'emergency-control','54','7','2020-09-17 07:35:37','-','-',NULL),(108,'emergency-control','54','3','2020-09-17 07:36:22','-','-',NULL),(109,'emergency-control','54','6','2020-09-17 07:36:29','-','-',NULL),(110,'emergency-control','54','8','2020-09-17 07:36:52','-','-',NULL),(111,'emergency-control','54','5','2020-09-17 07:36:54','-','-',NULL),(112,'emergency-control','55','3','2020-09-17 07:48:38','-','-',NULL),(113,'emergency-control','55','5','2020-09-17 07:50:49','-','-',NULL),(114,'emergency-control','56','4','2020-09-17 08:34:00','-','-',NULL),(115,'emergency-control','56','3','2020-09-17 08:44:40','-','-',NULL),(116,'emergency-control','56','6','2020-09-17 08:44:58','-','-',NULL),(117,'emergency-control','56','8','2020-09-17 08:45:33','-','-',NULL),(118,'emergency-control','56','6','2020-09-17 08:46:18','-','-',NULL),(119,'emergency-control','56','8','2020-09-17 08:47:01','-','-',NULL),(120,'emergency-control','56','5','2020-09-17 08:47:09','-','-',NULL),(121,'emergency-control','57','4','2020-09-18 01:54:59','-','-',NULL),(122,'emergency-control','57','3','2020-09-18 02:01:45','-','-',NULL),(123,'emergency-control','57','5','2020-09-18 02:15:31','-','-',NULL),(124,'emergency-control','58','3','2020-09-18 03:07:04','-','-',NULL),(125,'emergency-control','58','6','2020-09-18 03:07:13','-','-',NULL),(126,'emergency-control','58','8','2020-09-18 03:17:38','-','-',NULL),(127,'emergency-control','58','7','2020-09-18 03:17:43','-','-',NULL),(128,'emergency-control','58','3','2020-09-18 03:20:59','-','-',NULL),(129,'emergency-control','58','6','2020-09-18 03:21:06','-','-',NULL),(130,'emergency-control','58','8','2020-09-18 03:23:34','-','-',NULL),(131,'emergency-control','58','6','2020-09-18 03:23:39','-','-',NULL),(132,'emergency-control','59','4','2020-09-18 05:53:13','-','-',NULL),(133,'emergency-control','59','3','2020-09-18 06:03:22','-','-',NULL),(134,'emergency-control','60','4','2020-09-18 06:55:25','-','-',NULL),(135,'emergency-control','60','3','2020-09-18 06:57:50','-','-',NULL),(136,'emergency-control','60','5','2020-09-18 06:58:03','-','-',NULL),(137,'emergency-control','61','3','2020-09-18 08:45:44','-','-',NULL),(138,'emergency-control','61','6','2020-09-18 08:46:50','-','-',NULL),(139,'emergency-control','61','8','2020-09-18 08:46:56','-','-',NULL),(140,'emergency-control','61','5','2020-09-18 08:47:07','-','-',NULL),(141,'emergency-control','62','3','2020-09-21 00:08:37','-','-',NULL),(142,'emergency-control','62','5','2020-09-21 00:08:45','-','-',NULL),(143,'emergency-control','63','3','2020-09-21 01:49:04','-','-',NULL),(144,'emergency-control','63','5','2020-09-21 02:10:50','-','-',NULL),(145,'emergency-control','59','5','2020-09-21 02:12:01','-','-',NULL),(146,'emergency-control','12','5','2020-09-21 02:13:33','-','-',NULL),(147,'emergency-control','65','3','2020-09-21 02:19:13','-','-',NULL),(148,'emergency-control','65','5','2020-09-21 02:19:54','-','-',NULL),(149,'emergency-control','67','3','2020-09-21 02:27:35','-','-',NULL),(150,'emergency-control','55','3','2020-09-21 02:28:22','-','-',NULL),(151,'emergency-control','58','8','2020-09-21 02:28:28','-','-',NULL),(152,'emergency-control','66','3','2020-09-21 02:28:55','-','-',NULL),(153,'emergency-control','66','5','2020-09-21 02:29:05','-','-',NULL),(154,'emergency-control','58','5','2020-09-21 02:54:16','-','-',NULL),(155,'emergency-control','64','4','2020-09-21 02:55:25','-','-',NULL),(156,'emergency-control','55','6','2020-09-21 03:00:41','-','-',NULL),(157,'emergency-control','67','6','2020-09-21 03:09:28','-','-',NULL),(158,'emergency-control','67','8','2020-09-21 03:10:40','-','-',NULL),(159,'emergency-control','67','5','2020-09-21 03:10:53','-','-',NULL),(160,'emergency-control','21','3','2020-09-21 05:27:36','-','-',NULL),(161,'emergency-control','21','6','2020-09-21 05:27:57','-','-',NULL),(162,'emergency-control','68','3','2020-09-21 06:16:17','-','-',NULL),(163,'emergency-control','68','6','2020-09-21 06:16:27','-','-',NULL),(164,'emergency-control','68','8','2020-09-21 07:14:07','-','-',NULL),(165,'emergency-control','68','5','2020-09-21 07:15:03','-','-',NULL),(166,'emergency-control','69','3','2020-09-21 07:49:39','-','-',NULL),(167,'emergency-control','69','5','2020-09-21 08:12:40','-','-',NULL),(168,'emergency-control','70','3','2020-09-21 08:31:55','-','-',NULL),(169,'emergency-control','70','5','2020-09-21 08:32:20','-','-',NULL),(170,'emergency-control','71','4','2020-09-21 09:47:56','-','-',NULL),(171,'emergency-control','72','3','2020-09-21 09:57:34','-','-',NULL),(172,'emergency-control','72','6','2020-09-21 09:58:48','-','-',NULL),(173,'emergency-control','72','8','2020-09-21 10:00:24','-','-',NULL),(174,'emergency-control','72','6','2020-09-21 10:00:41','-','-',NULL),(175,'emergency-control','72','8','2020-09-21 10:02:15','-','-',NULL),(176,'emergency-control','72','5','2020-09-21 10:02:24','-','-',NULL),(177,'emergency-control','74','3','2020-09-22 00:28:12','-','-',NULL),(178,'emergency-control','74','5','2020-09-22 00:44:19','-','-',NULL),(179,'emergency-control','75','4','2020-09-22 01:26:01','-','-',NULL),(180,'emergency-control','39','3','2020-09-22 05:37:54','-','-',NULL),(181,'emergency-control','78','3','2020-09-22 07:34:14','-','-',NULL),(182,'emergency-control','78','7','2020-09-22 07:34:28','-','-',NULL),(183,'emergency-control','78','3','2020-09-22 07:35:05','-','-',NULL),(184,'emergency-control','78','6','2020-09-22 07:35:19','-','-',NULL),(185,'emergency-control','78','3','2020-09-22 07:35:55','-','-',NULL),(186,'emergency-control','78','5','2020-09-22 07:36:10','-','-',NULL),(187,'emergency-control','79','3','2020-09-22 07:40:18','-','-',NULL),(188,'emergency-control','79','6','2020-09-22 07:40:41','-','-',NULL),(189,'emergency-control','79','8','2020-09-22 07:41:14','-','-',NULL),(190,'emergency-control','79','5','2020-09-22 07:41:34','-','-',NULL),(191,'emergency-control','80','3','2020-09-22 08:14:46','-','-',NULL),(192,'emergency-control','80','7','2020-09-22 08:14:55','-','-',NULL),(193,'emergency-control','80','3','2020-09-22 08:15:07','-','-',NULL),(194,'emergency-control','80','6','2020-09-22 08:15:25','-','-',NULL),(195,'emergency-control','80','8','2020-09-22 08:15:33','-','-',NULL),(196,'emergency-control','80','5','2020-09-22 08:15:41','-','-',NULL),(197,'emergency-control','55','8','2020-09-22 08:30:55','-','-',NULL),(198,'emergency-control','55','6','2020-09-22 08:31:15','-','-',NULL),(199,'emergency-control','81','3','2020-09-23 00:28:07','-','-',NULL),(200,'emergency-control','81','6','2020-09-23 00:28:31','-','-',NULL),(201,'emergency-control','81','8','2020-09-23 00:31:35','-','-',NULL),(202,'emergency-control','81','5','2020-09-23 00:31:44','-','-',NULL),(203,'emergency-control','21','8','2020-09-23 00:48:46','-','-',NULL),(204,'emergency-control','55','8','2020-09-23 00:51:04','-','-',NULL),(205,'emergency-control','55','6','2020-09-23 00:52:43','-','-',NULL),(206,'emergency-control','21','6','2020-09-23 00:52:54','-','-',NULL),(207,'emergency-control','82','3','2020-09-23 04:00:54','-','-',NULL),(208,'emergency-control','85','3','2020-09-23 07:20:45','-','-',NULL),(209,'emergency-control','85','6','2020-09-23 07:21:03','-','-',NULL),(210,'emergency-control','85','8','2020-09-23 07:21:31','-','-',NULL),(211,'emergency-control','85','6','2020-09-23 07:21:46','-','-',NULL),(212,'emergency-control','85','8','2020-09-23 07:25:42','-','-',NULL),(213,'emergency-control','85','5','2020-09-23 07:25:58','-','-',NULL),(214,'emergency-control','90','3','2020-09-23 09:06:15','-','-',NULL),(215,'emergency-control','91','3','2020-09-23 09:24:56','-','-',NULL),(216,'emergency-control','91','6','2020-09-23 09:25:34','-','-',NULL),(217,'emergency-control','91','8','2020-09-23 09:27:13','-','-',NULL),(218,'emergency-control','91','5','2020-09-23 09:27:33','-','-',NULL),(219,'emergency-control','94','3','2020-09-24 12:44:02','-','-',NULL),(220,'emergency-control','94','6','2020-09-24 12:44:14','-','-',NULL),(221,'emergency-control','94','8','2020-09-24 12:44:42','-','-',NULL),(222,'emergency-control','94','5','2020-09-24 12:44:56','-','-',NULL),(223,'emergency-control','90','6','2020-09-24 13:52:37','-','-',NULL),(224,'emergency-control','90','8','2020-09-24 15:14:59','-','-',NULL),(225,'emergency-control','90','6','2020-09-24 15:15:10','-','-',NULL),(226,'emergency-control','88','3','2020-09-25 05:21:04','-','-',NULL),(227,'emergency-control','88','5','2020-09-25 05:21:15','-','-',NULL),(228,'emergency-control','86','3','2020-09-25 05:21:41','-','-',NULL),(229,'emergency-control','86','5','2020-09-25 05:21:50','-','-',NULL),(230,'emergency-control','87','3','2020-09-25 05:23:53','-','-',NULL),(231,'emergency-control','87','5','2020-09-25 05:24:00','-','-',NULL),(232,'emergency-control','84','3','2020-09-25 05:24:43','-','-',NULL),(233,'emergency-control','84','5','2020-09-25 05:24:50','-','-',NULL),(234,'emergency-control','95','3','2020-09-27 00:21:47','-','-',NULL),(235,'emergency-control','95','6','2020-09-27 00:22:03','-','-',NULL),(236,'emergency-control','95','8','2020-09-27 00:22:32','-','-',NULL),(237,'emergency-control','95','6','2020-09-27 00:47:38','-','-',NULL),(238,'emergency-control','102','3','2020-09-27 06:27:15','-','-',NULL),(239,'emergency-control','102','5','2020-09-27 06:28:35','-','-',NULL),(240,'emergency-control','103','3','2020-09-27 07:02:54','-','-',NULL),(241,'emergency-control','103','6','2020-09-27 07:04:32','-','-',NULL),(242,'emergency-control','103','8','2020-09-27 07:04:44','-','-',NULL),(243,'emergency-control','103','5','2020-09-27 07:05:10','-','-',NULL),(244,'emergency-control','98','3','2020-09-27 07:05:49','-','-',NULL),(245,'emergency-control','98','5','2020-09-27 07:06:00','-','-',NULL),(246,'emergency-control','100','3','2020-09-27 07:47:04','-','-',NULL),(247,'emergency-control','100','7','2020-09-27 08:34:48','-','-',NULL),(248,'emergency-control','105','3','2020-09-27 08:46:58','-','-',NULL),(249,'emergency-control','105','6','2020-09-27 08:47:09','-','-',NULL),(250,'emergency-control','105','8','2020-09-27 08:47:17','-','-',NULL),(251,'emergency-control','105','5','2020-09-27 08:47:26','-','-',NULL),(252,'emergency-control','90','8','2020-09-28 01:04:08','-','-',NULL),(253,'emergency-control','107','3','2020-09-28 01:17:10','-','-',NULL),(254,'emergency-control','106','3','2020-09-28 02:45:54','-','-',NULL),(255,'emergency-control','106','6','2020-09-28 03:04:26','-','-',NULL),(256,'emergency-control','106','8','2020-09-28 03:05:55','-','-',NULL),(257,'emergency-control','106','6','2020-09-28 03:07:30','-','-',NULL),(258,'emergency-control','106','8','2020-09-28 03:08:09','-','-',NULL),(259,'emergency-control','106','6','2020-09-28 03:08:36','-','-',NULL),(260,'emergency-control','106','8','2020-09-28 03:10:07','-','-',NULL),(261,'emergency-control','106','5','2020-09-28 03:10:48','-','-',NULL),(262,'emergency-control','108','3','2020-09-28 03:33:13','-','-',NULL),(263,'emergency-control','108','5','2020-09-28 03:33:34','-','-',NULL),(264,'emergency-control','107','7','2020-09-28 05:30:15','-','-',NULL),(265,'emergency-control','107','3','2020-09-28 05:49:52','-','-',NULL),(266,'emergency-control','107','5','2020-09-28 05:50:23','-','-',NULL),(267,'emergency-control','112','3','2020-09-28 12:28:36','-','-',NULL),(268,'emergency-control','112','5','2020-09-28 12:28:51','-','-',NULL);
/*!40000 ALTER TABLE `sf_state_series` ENABLE KEYS */;
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
