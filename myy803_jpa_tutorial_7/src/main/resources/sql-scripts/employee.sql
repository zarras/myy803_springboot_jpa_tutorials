CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_7`;
USE `myy803_spring_boot_jpa_demo_db_7`;


CREATE TABLE `active_employees` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `salary` double,
  PRIMARY KEY (`eid`)
);

CREATE TABLE `retired_employees` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `pension` double,
  PRIMARY KEY (`eid`)
);

