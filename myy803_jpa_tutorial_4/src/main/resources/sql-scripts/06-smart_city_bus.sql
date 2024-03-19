
CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_4`;
USE `myy803_spring_boot_jpa_demo_db_4`;

CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `driver` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `service_id` int DEFAULT NULL, 
  `driver_id` int DEFAULT NULL, 
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `fk_driver_to_route` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`) 
);

CREATE TABLE `stop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `latitude` double DEFAULT 0,
  `longtitude` double DEFAULT 0,
  `route_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) 
);


CREATE TABLE `ticket_control_agent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `stops_agents` (
  `stop_id` int NOT NULL,
  `agent_id` int NOT NULL,
  CONSTRAINT `fk_stop` FOREIGN KEY (`stop_id`) REFERENCES `stop` (`id`),
  CONSTRAINT `fk_agent` FOREIGN KEY (`agent_id`) REFERENCES `ticket_control_agent` (`id`)
);


