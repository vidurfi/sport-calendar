-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: sport_calendar
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Vienna'),(2,'Bratislava'),(3,'Budapest'),(4,'Prague'),(5,'Warsaw'),(6,'Berlin');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `match_view`
--

DROP TABLE IF EXISTS `match_view`;
/*!50001 DROP VIEW IF EXISTS `match_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `match_view` AS SELECT 
 1 AS `id`,
 1 AS `date`,
 1 AS `hometeam`,
 1 AS `awayteam`,
 1 AS `city`,
 1 AS `sport`,
 1 AS `stadium`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matches` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `_home_team_id` int NOT NULL,
  `_away_team_id` int NOT NULL,
  `_stadium_id` int NOT NULL,
  `_sport_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `_home_team_id_match_idx` (`_home_team_id`),
  KEY `_away_team_id_match_idx` (`_away_team_id`),
  KEY `_stadium_id_match_idx` (`_stadium_id`),
  KEY `_sport_id_match_idx` (`_sport_id`),
  CONSTRAINT `_away_team_id_match` FOREIGN KEY (`_away_team_id`) REFERENCES `teams` (`id`),
  CONSTRAINT `_home_team_id_match` FOREIGN KEY (`_home_team_id`) REFERENCES `teams` (`id`),
  CONSTRAINT `_sport_id_match` FOREIGN KEY (`_sport_id`) REFERENCES `sports` (`id`),
  CONSTRAINT `_stadium_id_match` FOREIGN KEY (`_stadium_id`) REFERENCES `stadiums` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,'2022-04-08 12:30:00',1,4,2,3),(2,'2022-01-10 13:30:00',3,2,1,2),(3,'2022-01-15 16:00:00',6,5,2,1),(4,'2022-01-10 20:30:00',4,1,2,3),(5,'2022-01-20 12:00:00',4,2,2,6),(6,'2022-01-03 13:30:00',5,2,4,3),(7,'2022-02-08 15:30:00',1,4,2,4),(8,'2022-02-12 16:30:00',3,2,1,2),(9,'2022-02-13 16:00:00',6,5,2,3),(11,'2022-02-24 18:30:00',3,2,2,6),(12,'2022-03-03 16:30:00',5,2,4,3),(13,'2022-03-08 12:30:00',1,4,2,3),(14,'2022-03-10 13:00:00',3,2,1,2),(15,'2022-03-20 16:00:00',2,4,2,6),(16,'2022-03-10 20:30:00',4,1,2,3),(17,'2022-03-20 12:00:00',3,2,2,6),(18,'2022-03-03 16:30:00',1,2,4,5),(19,'2022-02-01 12:00:00',5,2,3,4),(20,'2022-04-08 12:30:00',2,4,2,3);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports`
--

DROP TABLE IF EXISTS `sports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sport_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports`
--

LOCK TABLES `sports` WRITE;
/*!40000 ALTER TABLE `sports` DISABLE KEYS */;
INSERT INTO `sports` VALUES (1,'Football'),(2,'Basketball'),(3,'Baseball'),(4,'Hockey'),(5,'Water polo'),(6,'Volleyball');
/*!40000 ALTER TABLE `sports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadiums`
--

DROP TABLE IF EXISTS `stadiums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stadiums` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stadium_name` varchar(255) DEFAULT NULL,
  `_city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `_city_id_idx` (`_city_id`),
  CONSTRAINT `_city_id_stadium` FOREIGN KEY (`_city_id`) REFERENCES `cities` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadiums`
--

LOCK TABLES `stadiums` WRITE;
/*!40000 ALTER TABLE `stadiums` DISABLE KEYS */;
INSERT INTO `stadiums` VALUES (1,'Pusk├ís Ar├⌐na',3),(2,'Duna Ar├⌐na',3),(3,'Allianz-Stadion',1),(4,'Strahov Stadium',4),(5,'Teheln├⌐ pole',2),(6,'Stadion Narodowy',5),(7,'Olympiastadion',6);
/*!40000 ALTER TABLE `stadiums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) NOT NULL,
  `_city_id` int NOT NULL,
  `_stadium_id` int DEFAULT NULL,
  `_sport_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `_city_id_idx` (`_city_id`),
  KEY `_stadium_id_idx` (`_stadium_id`),
  KEY `_sport_id_idx` (`_sport_id`),
  CONSTRAINT `_city_id_team` FOREIGN KEY (`_city_id`) REFERENCES `cities` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `_sport_id_team` FOREIGN KEY (`_sport_id`) REFERENCES `sports` (`id`),
  CONSTRAINT `_stadium_id_team` FOREIGN KEY (`_stadium_id`) REFERENCES `stadiums` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Team Lion',2,NULL,3),(2,'Team Monkey',1,NULL,5),(3,'Team Water',3,2,5),(4,'Team Fire',1,3,3),(5,'Team Dog',5,6,2),(6,'Team Seal',4,NULL,5),(7,'Team Elephant',6,7,2);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `match_view`
--

/*!50001 DROP VIEW IF EXISTS `match_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `match_view` AS select `m`.`id` AS `id`,`m`.`date` AS `date`,`t1`.`team_name` AS `hometeam`,`t2`.`team_name` AS `awayteam`,`c`.`city_name` AS `city`,`sp`.`sport_name` AS `sport`,`st`.`stadium_name` AS `stadium` from (((((`matches` `m` left join `teams` `t1` on((`m`.`_home_team_id` = `t1`.`id`))) left join `teams` `t2` on((`m`.`_away_team_id` = `t2`.`id`))) left join `stadiums` `st` on((`m`.`_stadium_id` = `st`.`id`))) left join `sports` `sp` on((`m`.`_sport_id` = `sp`.`id`))) join `cities` `c` on((`st`.`_city_id` = `c`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28 10:30:41
