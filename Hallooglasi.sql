-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: hallooglasi
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `adresa`
--

DROP TABLE IF EXISTS `adresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresa` (
  `naseljeId` int(11) NOT NULL,
  `ulicaId` int(11) NOT NULL,
  PRIMARY KEY (`naseljeId`,`ulicaId`),
  KEY `FK_js41uc2imtu1a6yvncnb2hjac` (`ulicaId`),
  CONSTRAINT `FK_2fcvt2daikyxp7lsxronokstb` FOREIGN KEY (`naseljeId`) REFERENCES `naselje` (`naseljeId`),
  CONSTRAINT `FK_js41uc2imtu1a6yvncnb2hjac` FOREIGN KEY (`ulicaId`) REFERENCES `ulica` (`ulicaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresa`
--

LOCK TABLES `adresa` WRITE;
/*!40000 ALTER TABLE `adresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `adresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clan`
--

DROP TABLE IF EXISTS `clan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clan` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clan`
--

LOCK TABLES `clan` WRITE;
/*!40000 ALTER TABLE `clan` DISABLE KEYS */;
INSERT INTO `clan` VALUES ('ijankovic47@gmail.com','111111aa','admin','0631809541','Ivan-Jankovic');
/*!40000 ALTER TABLE `clan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `naselje`
--

DROP TABLE IF EXISTS `naselje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `naselje` (
  `naseljeId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `opstina_opstinaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`naseljeId`),
  KEY `FK_6macracotsnxiedmapcemacl8` (`opstina_opstinaId`),
  CONSTRAINT `FK_6macracotsnxiedmapcemacl8` FOREIGN KEY (`opstina_opstinaId`) REFERENCES `opstina` (`opstinaId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `naselje`
--

LOCK TABLES `naselje` WRITE;
/*!40000 ALTER TABLE `naselje` DISABLE KEYS */;
INSERT INTO `naselje` VALUES (1,'Arnajevo',1),(2,'Bacevac',1),(3,'Bela reka',1),(4,'Ada Ciganlija',2),(5,'Banovo brdo',2),(6,'Bele vode',2),(7,'Begaljica',3),(8,'Bolec',3),(9,'Brestovik',3),(10,'Arapovac',4),(11,'Barosevac',4),(12,'Barzilovica',4),(13,'Americ',5),(14,'Beluce',5),(15,'Crkvine',5),(16,'Ada Medjica',6),(17,'Arena',6),(18,'Bezanijska kosa 1',6),(19,'Baljevac',7),(20,'Baric',7),(21,'Belo polje',7),(22,'27. marta',8),(23,'Ada Huja',8),(24,'Bela stena',8),(25,'Centar',9),(26,'Kanarevo brdo',9),(27,'Kijevo',9),(28,'Beogradjanka',10),(29,'Balkanska',10),(30,'Bara Venecija',10),(31,'Avala',11),(32,'Babe',11),(33,'Djurinci',11),(34,'25. maj',12),(35,'Andricev venac',12),(36,'Atelje 212',12),(37,'Becmen',13),(38,'Boljevci',13),(39,'Dobanovci',13),(40,'Autokomanda',14),(41,'Banjica',14),(42,'Beli potok',14),(43,'Beogradska',15),(44,'Bulevar kralja Aleksandra',15),(45,'Crveni krst',15),(46,'Altina',16),(47,'Batajnica',16),(48,'Gornji grad',16),(49,'Bulbulder',17),(50,'Bulevar kralja Aleksandra',17),(51,'Cvetanova cuprija',17);
/*!40000 ALTER TABLE `naselje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opstina`
--

DROP TABLE IF EXISTS `opstina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opstina` (
  `opstinaId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`opstinaId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opstina`
--

LOCK TABLES `opstina` WRITE;
/*!40000 ALTER TABLE `opstina` DISABLE KEYS */;
INSERT INTO `opstina` VALUES (1,'Barajevo'),(2,'Cukarica'),(3,'Grocka'),(4,'Lazarevac'),(5,'Mladenovac'),(6,'Novi Beograd'),(7,'Obrenovac'),(8,'Palilula'),(9,'Rakovica'),(10,'Savski venac'),(11,'Sopot'),(12,'Stari grad'),(13,'Surcin'),(14,'Vozdovac'),(15,'Vracar'),(16,'Zemun'),(17,'Zvezdara');
/*!40000 ALTER TABLE `opstina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slika`
--

DROP TABLE IF EXISTS `slika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slika` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sadrzaj` longblob,
  `stan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_138ek2hnqgvbr745wdyikwmbj` (`stan_id`),
  CONSTRAINT `FK_138ek2hnqgvbr745wdyikwmbj` FOREIGN KEY (`stan_id`) REFERENCES `stan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slika`
--

LOCK TABLES `slika` WRITE;
/*!40000 ALTER TABLE `slika` DISABLE KEYS */;
/*!40000 ALTER TABLE `slika` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stan`
--

DROP TABLE IF EXISTS `stan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brojSoba` varchar(255) DEFAULT NULL,
  `cena` int(11) NOT NULL,
  `depozit` bit(1) NOT NULL,
  `grejanje` varchar(255) DEFAULT NULL,
  `internet` bit(1) NOT NULL,
  `kablovska` bit(1) NOT NULL,
  `klima` bit(1) NOT NULL,
  `kvadratura` int(11) NOT NULL,
  `mapa` longtext,
  `nacinPlacanja` varchar(255) DEFAULT NULL,
  `namestenost` varchar(255) DEFAULT NULL,
  `naslov` varchar(255) DEFAULT NULL,
  `opis` longtext,
  `sprat` int(11) NOT NULL,
  `telefon` bit(1) NOT NULL,
  `terasa` bit(1) NOT NULL,
  `validiran` bit(1) NOT NULL,
  `adresa_naseljeId` int(11) DEFAULT NULL,
  `adresa_ulicaId` int(11) DEFAULT NULL,
  `clan_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t6p548wws7hcar6vj5m3u4u3g` (`adresa_naseljeId`,`adresa_ulicaId`),
  KEY `FK_ei8hgdd3nqpngqmgf3dx4rrvs` (`clan_email`),
  CONSTRAINT `FK_ei8hgdd3nqpngqmgf3dx4rrvs` FOREIGN KEY (`clan_email`) REFERENCES `clan` (`email`),
  CONSTRAINT `FK_t6p548wws7hcar6vj5m3u4u3g` FOREIGN KEY (`adresa_naseljeId`, `adresa_ulicaId`) REFERENCES `adresa` (`naseljeId`, `ulicaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stan`
--

LOCK TABLES `stan` WRITE;
/*!40000 ALTER TABLE `stan` DISABLE KEYS */;
/*!40000 ALTER TABLE `stan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ulica`
--

DROP TABLE IF EXISTS `ulica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ulica` (
  `ulicaId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ulicaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ulica`
--

LOCK TABLES `ulica` WRITE;
/*!40000 ALTER TABLE `ulica` DISABLE KEYS */;
/*!40000 ALTER TABLE `ulica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-10 16:32:46
