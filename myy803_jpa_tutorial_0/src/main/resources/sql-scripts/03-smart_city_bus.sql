CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db`;
USE `myy803_spring_boot_jpa_demo_db`;

DROP TABLE IF EXISTS `stop`;

CREATE TABLE `stop` (
  `id` int NOT NULL auto_increment,
  `name` varchar(45) DEFAULT NULL,
  `latitude` double DEFAULT 0,
  `longtitude` double DEFAULT 0,
  PRIMARY KEY (`id`)
);

