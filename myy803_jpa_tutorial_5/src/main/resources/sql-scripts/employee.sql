CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_5`;
USE `myy803_spring_boot_jpa_demo_db_5`;

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255),
  `name` varchar(45) DEFAULT NULL,
  `salary` double,
  `pension` double,
  PRIMARY KEY (`eid`)
);



