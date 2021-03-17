CREATE DATABASE  IF NOT EXISTS `medkee` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `medkee`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medkee
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `benhvienphongkham`
--

DROP TABLE IF EXISTS `benhvienphongkham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benhvienphongkham` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sodienthoai` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tomtat` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `mota` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `anh` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `anhdaidien` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `QuanHuyenid` int DEFAULT NULL,
  `ThanhPhoid` int DEFAULT NULL,
  `LoaiHinhid` int DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  `urlBv` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `xepHang` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benhvienphongkham`
--

LOCK TABLES `benhvienphongkham` WRITE;
/*!40000 ALTER TABLE `benhvienphongkham` DISABLE KEYS */;
INSERT INTO `benhvienphongkham` VALUES (33,'bệnh viện dã chiến','99 Trần Bình, Cầu Giấy, Hà Nội','0222245454','123','123123','bac-si-gioi-kham-chua-dau-vai-gay-tphcm.jpg','123123',1,1,1,12312,'123123',1),(34,'bệnh viện trần bìnhzzz','78 Giải Phóng','0222242342','123','ấ','5ccd879e1a18fc46a509.jpg','123123',1,123,123123,12312,'123123',1),(36,'bệnh viện 111','99 Trần Bình, Cầu Giấy, Hà Nội','0222423423','123','ấ','bac-si-chua-thoat-vi-dia-dem-tphcm.jpg','asdasd',123123,1,123123,1,'123123',1),(37,'ádasd111','99 Trần Bình','0222245454','123123','ấ','bac-si-chua-thoat-vi-dia-dem-tphcm.jpg','asdasd',1,1,1,1,'123123',1),(38,'ádasd111','78 Giải Phóng','0222242342','123','123123','bac-si-chua-thoat-vi-dia-dem-tphcm.jpg','asdasd',123123,1,123123,1,'123123',1),(39,'ádasdas','99 Trần Bình','0222423423','123123','123','kham-benh-khoi-ho-hap-o-dau-tot-tphcm.jpg','123123',1,1,1,1,'123123',1),(40,'xfgxfgfgfcvg','78 Giải Phóng','0222423423','123','123','kinh-nghiem-kham-chua-benh-tram-cam-tai-bv-trung-uong.jpg','asdasd',123123,1,1,1,'123123',1),(41,'ádasd','99 Trần Bình','0222242342','123123','123123','kinh-nghiem-kham-tong-quat-tai-pk-bv-dai-hoc-y-duoc-1-tphcm.jpg','123123',1,123,123123,1,'123123',1);
/*!40000 ALTER TABLE `benhvienphongkham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaihinh`
--

DROP TABLE IF EXISTS `loaihinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaihinh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaihinh`
--

LOCK TABLES `loaihinh` WRITE;
/*!40000 ALTER TABLE `loaihinh` DISABLE KEYS */;
INSERT INTO `loaihinh` VALUES (2,'Phòng Khám',0),(3,'Bệnh viện tư',0),(4,'Bệnh viện công',0),(5,'loại hình 1',1),(27,'bệnh viện thanh nhàn',1),(28,'duong',1),(29,'duong',1),(30,'duongpro 123',1);
/*!40000 ALTER TABLE `loaihinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhpho`
--

DROP TABLE IF EXISTS `thanhpho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhpho` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhpho`
--

LOCK TABLES `thanhpho` WRITE;
/*!40000 ALTER TABLE `thanhpho` DISABLE KEYS */;
INSERT INTO `thanhpho` VALUES (1,'Hà Nội',1),(2,'Hồ Chí Minh',1),(4,'Nghệ An',1),(5,'Hội An',NULL),(6,'Quảng Ninh',NULL),(7,'Quảng Nam',NULL),(8,'Nghệ An',1),(11,'37',1),(12,'38',1),(13,'37222',1),(14,'38`1`1w`',1),(15,'1123',1),(16,'12',1),(17,'1',1),(18,'99991',1),(19,'112121212',1212),(20,'121212',1212),(21,'38',1212);
/*!40000 ALTER TABLE `thanhpho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','admin'),(2,'customer','123456','customer'),(3,'duongqt5','toilatoi01','admin'),(4,'luong1609','thangdeu123','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'medkee'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 11:13:08
