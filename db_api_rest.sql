/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.26 : Database - db_api_rest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_api_rest` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_api_rest`;

/*Table structure for table `genero` */

DROP TABLE IF EXISTS `genero`;

CREATE TABLE `genero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `genero` */

insert  into `genero`(`id`,`imagen`,`nombre`) values 
(2,'accion.jpg','accion'),
(3,'fantasia.jpg','fantasía'),
(4,'aventura.jpg','aventura'),
(5,'suspenso.jpg','suspenso'),
(6,'terror.jpg','terror'),
(7,'musical.jpg','musical'),
(8,'comedia.jpg','comedia');

/*Table structure for table `pelicula_serie` */

DROP TABLE IF EXISTS `pelicula_serie`;

CREATE TABLE `pelicula_serie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `calificacion` int DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `titulo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `pelicula_serie` */

insert  into `pelicula_serie`(`id`,`calificacion`,`fecha_creacion`,`imagen`,`titulo`) values 
(11,5,'2021-09-06 15:05:58',NULL,'Shrek 2'),
(12,5,'2021-09-17 15:06:02',NULL,'Shrek 3'),
(13,5,'2021-09-25 15:06:04',NULL,'Shrek 4'),
(14,5,'2021-08-30 15:06:06',NULL,'Shrek 5');

/*Table structure for table `pelicula_serie_genero` */

DROP TABLE IF EXISTS `pelicula_serie_genero`;

CREATE TABLE `pelicula_serie_genero` (
  `id_pelicula_serie` bigint NOT NULL,
  `id_genero` bigint NOT NULL,
  PRIMARY KEY (`id_pelicula_serie`,`id_genero`),
  KEY `FK304x5yyf733urf1jcmkhsb5ui` (`id_genero`),
  CONSTRAINT `FK304x5yyf733urf1jcmkhsb5ui` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKbcqchqxtbwqvq1kn560bv193c` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `pelicula_serie_genero` */

insert  into `pelicula_serie_genero`(`id_pelicula_serie`,`id_genero`) values 
(12,2),
(14,3),
(14,6),
(11,8);

/*Table structure for table `personaje` */

DROP TABLE IF EXISTS `personaje`;

CREATE TABLE `personaje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `edad` int DEFAULT NULL,
  `historia` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `peso` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `personaje` */

insert  into `personaje`(`id`,`edad`,`historia`,`imagen`,`nombre`,`peso`) values 
(2,20,NULL,'burro.jpg','Burro',25),
(3,15,NULL,'gato.jpg','Gato con Botas',30),
(4,25,NULL,NULL,'Shrek',50);

/*Table structure for table `personaje_pelicula_serie` */

DROP TABLE IF EXISTS `personaje_pelicula_serie`;

CREATE TABLE `personaje_pelicula_serie` (
  `id_personaje` bigint NOT NULL,
  `id_pelicula_serie` bigint NOT NULL,
  PRIMARY KEY (`id_personaje`,`id_pelicula_serie`),
  KEY `FK5ksxrodtkvxnpx462wuv4opb` (`id_pelicula_serie`),
  CONSTRAINT `FK5ksxrodtkvxnpx462wuv4opb` FOREIGN KEY (`id_pelicula_serie`) REFERENCES `pelicula_serie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKbwwk1tqei85kwt8by8yqce7ou` FOREIGN KEY (`id_personaje`) REFERENCES `personaje` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `personaje_pelicula_serie` */

insert  into `personaje_pelicula_serie`(`id_personaje`,`id_pelicula_serie`) values 
(3,11),
(4,11),
(4,12),
(4,13),
(4,14);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`first_name`,`last_name`,`password`,`username`) values 
(5,'condori.miguel99@hotmail.com','miguel','condori','1234','miguel99');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
