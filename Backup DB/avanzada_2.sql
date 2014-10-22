CREATE DATABASE  IF NOT EXISTS `avanzada_2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `avanzada_2`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: avanzada_2
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `auth_role`
--

DROP TABLE IF EXISTS `auth_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_role`
--

LOCK TABLES `auth_role` WRITE;
/*!40000 ALTER TABLE `auth_role` DISABLE KEYS */;
INSERT INTO `auth_role` VALUES (1,'admin'),(2,'entrenador'),(3,'cliente');
/*!40000 ALTER TABLE `auth_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user`
--

DROP TABLE IF EXISTS `auth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_user` (
  `user_id` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `role_id_fk_idx` (`role_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user`
--

LOCK TABLES `auth_user` WRITE;
/*!40000 ALTER TABLE `auth_user` DISABLE KEYS */;
INSERT INTO `auth_user` VALUES (0,'0000',3),(9,'0000',3),(10,'0000',3),(11,'0000',3),(12,'0000',3);
/*!40000 ALTER TABLE `auth_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `nombre_cliente` varchar(128) NOT NULL,
  `altura_cliente` float NOT NULL,
  `masa_cliente` float NOT NULL,
  `dob_cliente` date NOT NULL,
  `genero_cliente` char(1) NOT NULL,
  `rutina_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE KEY `rutina_id_UNIQUE` (`rutina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,0,'test',1.4,54,'2002-10-22','F',NULL),(3,0,'nombre_1',2,60,'1994-03-03','M',NULL),(4,0,'nombre_2',2,60,'1994-03-03','M',NULL),(5,0,'nombre_3',2,60,'1994-03-03','M',NULL),(6,0,'nombre_4',2,60,'1994-03-03','M',NULL),(7,0,'nombre_5',2,60,'1994-03-03','M',NULL),(8,0,'nombre_6',2,60,'1994-03-03','M',NULL),(9,0,'nombre_6',2,60,'1994-03-03','M',NULL),(10,0,'nombre_test',2,60,'1994-03-03','M',NULL),(11,0,'nombre_test_1',2,60,'1994-03-03','M',NULL),(12,12,'nombre_test_2',2,60,'1994-03-03','M',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejercicio` (
  `ejercicio_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_ejercicio` varchar(64) NOT NULL,
  `tipo_ejercicio` varchar(64) NOT NULL,
  PRIMARY KEY (`ejercicio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio`
--

LOCK TABLES `ejercicio` WRITE;
/*!40000 ALTER TABLE `ejercicio` DISABLE KEYS */;
INSERT INTO `ejercicio` VALUES (1,'aa','bb'),(2,'test_ejercicio','test_tipo');
/*!40000 ALTER TABLE `ejercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrenador` (
  `entrenador_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_entrenador` varchar(128) NOT NULL,
  PRIMARY KEY (`entrenador_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (1,'test2');
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutina`
--

DROP TABLE IF EXISTS `rutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutina` (
  `rutina_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rutina` varchar(64) NOT NULL,
  `entrenador_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rutina_id`),
  KEY `entrenador_id_fk_idx` (`entrenador_id`),
  CONSTRAINT `entrenador_id_fk` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador` (`entrenador_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutina`
--

LOCK TABLES `rutina` WRITE;
/*!40000 ALTER TABLE `rutina` DISABLE KEYS */;
INSERT INTO `rutina` VALUES (2,'test_1',NULL);
/*!40000 ALTER TABLE `rutina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutina_dia_ejercicio`
--

DROP TABLE IF EXISTS `rutina_dia_ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutina_dia_ejercicio` (
  `rutina_id` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `ejercicio_id` int(11) NOT NULL,
  PRIMARY KEY (`rutina_id`,`ejercicio_id`,`dia`),
  KEY `ejercicio_id_fk_idx` (`ejercicio_id`),
  CONSTRAINT `ejercicio_id_fk` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicio` (`ejercicio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rutina_id_fk` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`rutina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutina_dia_ejercicio`
--

LOCK TABLES `rutina_dia_ejercicio` WRITE;
/*!40000 ALTER TABLE `rutina_dia_ejercicio` DISABLE KEYS */;
INSERT INTO `rutina_dia_ejercicio` VALUES (2,1,1),(2,2,1),(2,3,1),(2,4,1);
/*!40000 ALTER TABLE `rutina_dia_ejercicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-22  0:59:40
