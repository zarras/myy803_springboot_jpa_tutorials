CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_6`;
USE `myy803_spring_boot_jpa_demo_db_6`;

CREATE TABLE `employees` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eid`)
);

CREATE TABLE `active_employees` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `salary` double,
  PRIMARY KEY (`aid`),
  CONSTRAINT `fk_active_employee` FOREIGN KEY (`aid`) REFERENCES `employees` (`eid`)
);

CREATE TABLE `retired_employees` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `pension` double,
  PRIMARY KEY (`rid`),
  CONSTRAINT `fk_retired_employee` FOREIGN KEY (`rid`) REFERENCES `employees` (`eid`)
);

