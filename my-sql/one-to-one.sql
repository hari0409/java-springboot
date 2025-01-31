-- Creating DB 
DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;
CREATE SCHEMA `hb-01-one-to-one-uni`;
use `hb-01-one-to-one-uni`; 

-- Disable Foreign Key Constraint
SET FOREIGN_KEY_CHECKS = 0;

-- Create Parent Table
CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create Child Table
CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
--   Create Foreign Key Index & Foreign Key looking up to Parent's PK
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Set Foreign Key Constraint back
SET FOREIGN_KEY_CHECKS = 1;
