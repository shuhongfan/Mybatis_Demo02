CREATE DATABASE spring;
USE `spring`;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
insert into `account`(`id`,`username`,`balance`) values
 (1,'zhangsan',100),(3,'lisi',500),(4,'wangwu',300);
