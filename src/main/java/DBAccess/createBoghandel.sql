CREATE DATABASE  IF NOT EXISTS `boghandel`;

USE `boghandel`;

DROP TABLE IF EXISTS `bøger`;
CREATE TABLE `bøger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(90) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `bøger` WRITE;
INSERT INTO `bøger` VALUES 
(1,'21 lessons','Yuval Noah Harari',100,20),
(2,'The Lord of the Rings','J. R. R. Tolkien',125,15),
(3,'Crime and Punishment','Fyodor Dostoevsky',300,10),
(4,'American Psycho','Bret Easton Ellis',50,20),
(5,'12 Rules for life','Jordan B. Peterson',100,20),
(6,'Biblen','Gud',100,20);
UNLOCK TABLES;