-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mess
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `mess_deposit`
--

DROP TABLE IF EXISTS `mess_deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mess_deposit` (
  `deposit_id` int NOT NULL AUTO_INCREMENT,
  `paid_user` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `deposit_date` date DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `payment_by` int DEFAULT NULL,
  `received_by` int DEFAULT NULL,
  `payment_mode` varchar(20) DEFAULT NULL,
  `outstanding` int DEFAULT NULL,
  `comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`deposit_id`),
  KEY `fk_user_id_idx` (`paid_user`),
  KEY `fk_deposit_by_idx` (`payment_by`),
  KEY `fk_deposit_to_idx` (`received_by`),
  CONSTRAINT `fk_paid_user_id` FOREIGN KEY (`paid_user`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_payment_by` FOREIGN KEY (`payment_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_received_by` FOREIGN KEY (`received_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mess_deposit`
--

LOCK TABLES `mess_deposit` WRITE;
/*!40000 ALTER TABLE `mess_deposit` DISABLE KEYS */;
INSERT INTO `mess_deposit` VALUES (1,31,9,2021,'2021-08-04',2000,31,32,'upi',0,NULL);
/*!40000 ALTER TABLE `mess_deposit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mess_expense`
--

DROP TABLE IF EXISTS `mess_expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mess_expense` (
  `expense_id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `is_self` tinyint DEFAULT '0',
  PRIMARY KEY (`expense_id`),
  KEY `fk_expense_user_id_idx` (`user_id`),
  CONSTRAINT `fk_expense_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mess_expense`
--

LOCK TABLES `mess_expense` WRITE;
/*!40000 ALTER TABLE `mess_expense` DISABLE KEYS */;
/*!40000 ALTER TABLE `mess_expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `branch` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `student_id` varchar(15) NOT NULL,
  `role_id` int DEFAULT NULL,
  `is_veg` tinyint DEFAULT NULL,
  `is_active` tinyint DEFAULT '0',
  `is_disabled` tinyint DEFAULT '1',
  `is_new` tinyint DEFAULT '1',
  `reg_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_role_id_idx` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (31,'vipvipul1','Vipul Kumar','7733344455','vipvipul1@gmail.com','vipvipul1','Chirkunda','IT','1994-10-10','1410902014',1,0,1,0,0,'2021-07-16 09:37:52'),(32,'shshruti','Shruti Barnwal','7778889990','shrutibarnwal99@gmail.com','shshruti','Kapasara','CSE','1999-10-14','2344423',2,0,1,0,1,'2021-07-19 00:39:30');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_meal`
--

DROP TABLE IF EXISTS `user_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_meal` (
  `meal_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `date` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `morning` int DEFAULT '1',
  `day` int DEFAULT '1',
  `night` int DEFAULT '1',
  PRIMARY KEY (`meal_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_meal_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_meal`
--

LOCK TABLES `user_meal` WRITE;
/*!40000 ALTER TABLE `user_meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_meal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-04 20:18:05
