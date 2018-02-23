/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.5.50 : Database - gestionassociatives
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestionassociatives` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gestionassociatives`;

/*Table structure for table `adherent` */

DROP TABLE IF EXISTS `adherent`;

CREATE TABLE `adherent` (
  `idAdherent` int(4) NOT NULL AUTO_INCREMENT,
  `nomsprenoms` varchar(80) DEFAULT NULL,
  `datelieunaissance` varchar(80) DEFAULT NULL,
  `numerocnilieudelivrance` varchar(80) DEFAULT NULL,
  `residencetelephone` varchar(80) DEFAULT NULL,
  `situationmatrimonialenomepouse` varchar(80) DEFAULT NULL,
  `nomperemere` varchar(80) DEFAULT NULL,
  `procheacontacter` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idAdherent`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `adherent` */

insert  into `adherent`(`idAdherent`,`nomsprenoms`,`datelieunaissance`,`numerocnilieudelivrance`,`residencetelephone`,`situationmatrimonialenomepouse`,`nomperemere`,`procheacontacter`) values (3,'KUICHEU MOUNOU LANDRY','06 JANVIER 1986 A BAZOU','108982080 DELIVRE LE 09JUILLET 2008 A CE26','OLEMBE TEL 691090604','CELIBATAIRE','MOUNOU  et   TONKUE','MBEUNTCHA'),(4,'KUICHEU MOUNOU LANDRY','06 JANVIER 1986  A  BAZOU','108982080 DELIVREE LE 09JUILLET 2008 A CE26','OLEMBE TEL:691090604','CELIBATAIRE','MOUNOU ET TONKUE','MBEUNTCHA 655551818'),(5,'NYA MOUNOU GERVAIS','26 DECEMBRE 1990 A BAZOU','123476589','NYOM  TEL 655551818','CELIBATAIRE','MOUNOU AND TONKUE','KUICHEU'),(6,'KATTY FRU','6 JUIN 1997 A BAMENDA','1234512344','DOUALA  ET 670894893','CELIBATAIRE','KUICHEU','KUICHEU  ET  655551818'),(7,'MTAMACK','01012017 ET DOUALA','108956432','ODZA  ET 654329223','MARIE','MTEM ET DOP','PSQTA 654239876');

/*Table structure for table `aide` */

DROP TABLE IF EXISTS `aide`;

CREATE TABLE `aide` (
  `idAide` int(4) NOT NULL AUTO_INCREMENT,
  `idAdherent` int(4) DEFAULT NULL,
  `nomAdherent` varchar(80) NOT NULL,
  `montantaide` varchar(20) NOT NULL,
  `titreaide` varchar(100) NOT NULL,
  `delaiaide` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAide`),
  KEY `idAdherent` (`idAdherent`),
  CONSTRAINT `idAdherent` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `aide` */

insert  into `aide`(`idAide`,`idAdherent`,`nomAdherent`,`montantaide`,`titreaide`,`delaiaide`) values (1,5,'NYA MOUNOU GERVAIS','ggg','jjj','jjj'),(2,6,'KATTY FRU','2500','AIDE MARIAGE','15 SEPT 2017'),(3,7,'MTAMACK','4000','AIDE NAISSANCE','17112017'),(4,3,'KUICHEU MOUNOU LANDRY','7000','AIDE CONSTRUCTION','31122017'),(5,3,'KUICHEU MOUNOU LANDRY','17000','AIDE MARIAGE KUICHEU','12122017'),(6,3,'KUICHEU MOUNOU LANDRY','10000','AIDE VOIR BEBE','23122017');

/*Table structure for table `authentification` */

DROP TABLE IF EXISTS `authentification`;

CREATE TABLE `authentification` (
  `idAuthentification` int(4) NOT NULL AUTO_INCREMENT,
  `login` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idAuthentification`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `authentification` */

insert  into `authentification`(`idAuthentification`,`login`,`password`) values (1,'kuicheu','kuicheu'),(3,'mounou','mounou'),(4,'mekem','mekem');

/*Table structure for table `participation` */

DROP TABLE IF EXISTS `participation`;

CREATE TABLE `participation` (
  `idParticipation` int(4) NOT NULL AUTO_INCREMENT,
  `idAdherent` int(4) DEFAULT NULL,
  `nomAdherent` varchar(50) DEFAULT NULL,
  `dateparticipation` varchar(50) DEFAULT NULL,
  `montantparticipation` varchar(50) DEFAULT NULL,
  `motifparticipation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idParticipation`),
  KEY `idAdherent` (`idAdherent`),
  CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `participation` */

insert  into `participation`(`idParticipation`,`idAdherent`,`nomAdherent`,`dateparticipation`,`montantparticipation`,`motifparticipation`) values (1,3,'KUICHEU MOUNOU LANDRY','19102017','7000','PAIEMENT DE L\'AIDE DE FINTCHEU');

/*Table structure for table `pret` */

DROP TABLE IF EXISTS `pret`;

CREATE TABLE `pret` (
  `idPret` int(4) NOT NULL AUTO_INCREMENT,
  `idAdherent` int(4) DEFAULT NULL,
  `nomAdherent` varchar(50) DEFAULT NULL,
  `montantpret` varchar(50) DEFAULT NULL,
  `delaipret` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPret`),
  KEY `idAdherent` (`idAdherent`),
  CONSTRAINT `pret_ibfk_1` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `pret` */

insert  into `pret`(`idPret`,`idAdherent`,`nomAdherent`,`montantpret`,`delaipret`) values (1,3,'KUICHEU MOUNOU LANDRY','100000','12122017'),(2,3,'KUICHEU MOUNOU LANDRY','300000','31012017');

/*Table structure for table `pretordinaire` */

DROP TABLE IF EXISTS `pretordinaire`;

CREATE TABLE `pretordinaire` (
  `idPretOrdinaire` int(4) NOT NULL AUTO_INCREMENT,
  `idAdherent` int(4) DEFAULT NULL,
  `nomAdherent` varchar(50) DEFAULT NULL,
  `montantpret` varchar(50) DEFAULT NULL,
  `delaipret` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPretOrdinaire`),
  KEY `idAdherent` (`idAdherent`),
  CONSTRAINT `pretordinaire_ibfk_1` FOREIGN KEY (`idAdherent`) REFERENCES `adherent` (`idAdherent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pretordinaire` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
