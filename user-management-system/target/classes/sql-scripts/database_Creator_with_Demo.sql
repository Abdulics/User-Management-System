CREATE DATABASE IF NOT EXISTS `management-system-new` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ 
/*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE IF NOT EXISTS `management-system-new`.`user_information` (
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `em_id` int NOT NULL,
  PRIMARY KEY (`em_id`),
  UNIQUE KEY `em_id_UNIQUE` (`em_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  CREATE TABLE IF NOT EXISTS `management-system-new`.`login` (
  `em_id` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `prev` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  UNIQUE KEY `em_id_UNIQUE` (`em_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `management-system-new`.`report` (
  `em_id` int NOT NULL,
  `report` text,
  `rep_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  UNIQUE KEY `em_id_UNIQUE` (`em_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `management-system-new`.`access` (
  `em_id` int NOT NULL,
  `accessDate` datetime NOT NULL,
  PRIMARY KEY (`em_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `management-system-new`.`user_information` WRITE;
/*!40000 ALTER TABLE `management-system-new`.`user_information` DISABLE KEYS */;
INSERT INTO `management-system-new`.`user_information` VALUES ('AdminFirstName','AdminLastName','admin@dulTek.com', 0000),('Mary','Public','mary@dulTek.com', 0001),('John','Doe','john@dulTek.com', 0002),('Ajay','Rao','ajay@dulTek.com', 0003),('Bill','Neely','bill@dulTek.com', 0004),('Maxwell','Dixon','max@luv2code.com', 0005);
/*!40000 ALTER TABLE `management-system-new`.`user_information` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `management-system-new`.`login` WRITE;
/*!40000 ALTER TABLE `management-system-new`.`login` DISABLE KEYS */;
INSERT INTO `management-system-new`.`login` VALUES (0000, 'admin', 'password', 'adm'),(0001, 'marypublic', 'mary', 'emp'),(0002, 'johndoe', 'john', 'emp'),(0003, 'ajarao', 'ajay', 'emp'),(0004, 'billneely', 'bill', 'emp'),(0005, 'maxwelldixon', 'maxwell', 'emp');
/*!40000 ALTER TABLE `management-system-new`.`login` ENABLE KEYS */;
UNLOCK TABLES;

