CREATE DATABASE  IF NOT EXISTS `proiect` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_romanian_ci */;
USE `proiect`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proiect
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `TaskID` int(11) DEFAULT NULL,
  `Comment` varchar(45) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Date_Hour` datetime DEFAULT NULL,
  KEY `Comments_TaskID_idx` (`TaskID`),
  KEY `Comments_Username_idx` (`Username`),
  CONSTRAINT `Comments_TaskID` FOREIGN KEY (`TaskID`) REFERENCES `tasks` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Comments_Username` FOREIGN KEY (`Username`) REFERENCES `users` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `files` (
  `TaskID` int(11) DEFAULT NULL,
  `File` blob,
  KEY `TaskID_idx` (`TaskID`),
  CONSTRAINT `files_TaskID` FOREIGN KEY (`TaskID`) REFERENCES `tasks` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissions` (
  `PermissionName` varchar(45) NOT NULL,
  PRIMARY KEY (`PermissionName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES ('CAN_COMMENT'),('CAN_CREATE_NEW_TASK'),('CAN_DELETE_PROJECT');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectmembers`
--

DROP TABLE IF EXISTS `projectmembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectmembers` (
  `ProjectID` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  KEY `Username_idx` (`Username`),
  KEY `ProjectID_idx` (`ProjectID`),
  CONSTRAINT `projectmembers_ProjectID` FOREIGN KEY (`ProjectID`) REFERENCES `projects` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `projectmembers_Username` FOREIGN KEY (`Username`) REFERENCES `users` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectmembers`
--

LOCK TABLES `projectmembers` WRITE;
/*!40000 ALTER TABLE `projectmembers` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectmembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Manager` varchar(20) DEFAULT NULL,
  `Client` varchar(45) DEFAULT NULL,
  `ReleaseDate` datetime DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Manager_idx` (`Manager`),
  CONSTRAINT `Manager` FOREIGN KEY (`Manager`) REFERENCES `users` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (4,'fdsaf','robert','asdf','2011-11-11 00:00:00','asdf','aasdf');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TaskName` varchar(45) DEFAULT NULL,
  `ProjectID` int(11) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProjectID_idx` (`ProjectID`),
  CONSTRAINT `tasks_ProjectID` FOREIGN KEY (`ProjectID`) REFERENCES `projects` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (3,'fsdfad',4,'2018-07-14 00:00:00','Pending');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskworkers`
--

DROP TABLE IF EXISTS `taskworkers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taskworkers` (
  `TaskID` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  KEY `taskworkers_TaskID_idx` (`TaskID`),
  KEY `taskworkers_Username_idx` (`Username`),
  CONSTRAINT `taskworkers_TaskID` FOREIGN KEY (`TaskID`) REFERENCES `tasks` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `taskworkers_Username` FOREIGN KEY (`Username`) REFERENCES `users` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskworkers`
--

LOCK TABLES `taskworkers` WRITE;
/*!40000 ALTER TABLE `taskworkers` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskworkers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpermissions`
--

DROP TABLE IF EXISTS `userpermissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userpermissions` (
  `Username` varchar(20) DEFAULT NULL,
  `PermissionName` varchar(45) DEFAULT NULL,
  KEY `userpermissions_Username_idx` (`Username`),
  KEY `userpermissions_PermissionName_idx` (`PermissionName`),
  CONSTRAINT `userpermissions_PermissionName` FOREIGN KEY (`PermissionName`) REFERENCES `permissions` (`PermissionName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userpermissions_Username` FOREIGN KEY (`Username`) REFERENCES `users` (`Username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpermissions`
--

LOCK TABLES `userpermissions` WRITE;
/*!40000 ALTER TABLE `userpermissions` DISABLE KEYS */;
INSERT INTO `userpermissions` VALUES ('Gigel','CAN_COMMENT');
/*!40000 ALTER TABLE `userpermissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Gigel','asdf','gigel@gigle.gigel','male'),('robert','robert','robert.robert@robert.ro','male');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-18 14:00:16
