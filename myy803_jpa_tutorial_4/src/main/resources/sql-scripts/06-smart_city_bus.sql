
CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_4`;
USE `myy803_spring_boot_jpa_demo_db_4`;

CREATE TABLE `services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `drivers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `routes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `service_id` int DEFAULT NULL, 
  `driver_id` int DEFAULT NULL, 
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  CONSTRAINT `fk_driver_to_route` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`) 
);

CREATE TABLE `stops` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `latitude` double DEFAULT 0,
  `longtitude` double DEFAULT 0,
  `route_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_route` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`) 
);


CREATE TABLE `ticket_control_agents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `stops_agents` (
  `stop_id` int NOT NULL,
  `agent_id` int NOT NULL,
  PRIMARY KEY (`stop_id`, `agent_id`),
  CONSTRAINT `fk_stop` FOREIGN KEY (`stop_id`) REFERENCES `stops` (`id`),
  CONSTRAINT `fk_agent` FOREIGN KEY (`agent_id`) REFERENCES `ticket_control_agents` (`id`)
);


