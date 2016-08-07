-- phpMyAdmin SQL Dump
-- version 4.0.10.6
-- http://www.phpmyadmin.net
--
-- Client: mysql1.alwaysdata.com
-- Généré le: Mer 25 Mars 2015 à 10:52
-- Version du serveur: 5.1.66-0+squeeze1
-- Version de PHP: 5.3.6-11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `miagecoaching_database`
--

-- --------------------------------------------------------

--
-- Structure de la table `DonneesUtilisateur`
--

CREATE TABLE IF NOT EXISTS `DonneesUtilisateur` (
  `idDonneesUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Utilisateur_idUtilisateur` int(10) unsigned NOT NULL,
  `dateUpdate` date DEFAULT NULL,
  `sommeil` int(11) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `poidsObjectif` float DEFAULT NULL,
  PRIMARY KEY (`idDonneesUtilisateur`),
  KEY `fk_DonneesUtilisateur_Utilisateur_idx` (`Utilisateur_idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `DonneesUtilisateur`
--

INSERT INTO `DonneesUtilisateur` (`idDonneesUtilisateur`, `Utilisateur_idUtilisateur`, `dateUpdate`, `sommeil`, `poids`, `poidsObjectif`) VALUES
(1, 1, '2015-03-25', 8, 90, 78),
(6, 20, NULL, NULL, NULL, NULL),
(7, 23, '2015-03-11', 8, 50, 50),
(9, 25, '2015-03-17', 5, 80, 90),
(10, 27, NULL, NULL, NULL, NULL),
(11, 31, NULL, NULL, NULL, NULL),
(12, 32, NULL, NULL, NULL, NULL),
(13, 33, NULL, NULL, NULL, NULL),
(14, 34, NULL, NULL, NULL, NULL),
(15, 36, '2015-03-24', 7, 52, 52),
(20, 41, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `DonneesUtilisateurGraphe`
--

CREATE TABLE IF NOT EXISTS `DonneesUtilisateurGraphe` (
  `idDonneesUtilisateurGraphe` int(11) NOT NULL AUTO_INCREMENT,
  `dateUpdate` date NOT NULL,
  `sommeil` int(11) NOT NULL,
  `poids` float NOT NULL,
  `poidsObjectif` float NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idDonneesUtilisateurGraphe`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `DonneesUtilisateurGraphe`
--

INSERT INTO `DonneesUtilisateurGraphe` (`idDonneesUtilisateurGraphe`, `dateUpdate`, `sommeil`, `poids`, `poidsObjectif`, `idUtilisateur`) VALUES
(1, '2015-03-11', 7, 70, 80, 1),
(2, '2015-03-11', 7, 75, 80, 1),
(3, '2015-03-11', 7, 75, 80, 1),
(4, '2015-03-11', 8, 50, 50, 23),
(5, '2015-03-15', 7, 65, 80, 1),
(6, '2015-03-16', 5, 68, 78, 1),
(7, '2015-03-17', 5, 80, 90, 25),
(8, '2015-03-17', 5, 80, 90, 25),
(9, '2015-03-24', 7, 52, 52, 36),
(10, '2015-03-25', 8, 90, 78, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Exercice`
--

CREATE TABLE IF NOT EXISTS `Exercice` (
  `idExercice` int(11) NOT NULL AUTO_INCREMENT,
  `TypeExercice_idTypeExercice` int(11) NOT NULL,
  `titre` varchar(45) DEFAULT NULL,
  `temps` float DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `repetition` int(11) DEFAULT NULL,
  `distance` float DEFAULT NULL,
  PRIMARY KEY (`idExercice`),
  KEY `fk_Exercice_TypeExercice1_idx` (`TypeExercice_idTypeExercice`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=114 ;

--
-- Contenu de la table `Exercice`
--

INSERT INTO `Exercice` (`idExercice`, `TypeExercice_idTypeExercice`, `titre`, `temps`, `description`, `repetition`, `distance`) VALUES
(6, 0, 'delete', 10, 'delete', 10, 20),
(7, 0, 'faire exo', 125, 'test', 0, 56),
(8, 1, 'danse', 24, 'danser toute la nuit sur du travolta', 24, 0),
(10, 0, 't', 1, 're', 0, 2),
(11, 0, 'b', 1, 'rer', 0, 22),
(12, 0, 'op', 14, 'po', 0, 12),
(13, 0, 'faire des abdo', 2, 'abdo', 0, 6),
(14, 0, 'courir', 30, 'footing', 0, 4),
(19, 1, 'abdos level 2', 10, 'Faire des abdos en position allongé. A chaque', 50, 0),
(20, 1, 'Pompes level 1', 5, 'Faire des pompes simples', 15, NULL),
(21, 0, 'Footing level 2', 45, 'Courir pendant 7 km', NULL, 10),
(22, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(23, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(24, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(25, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(26, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(27, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(28, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(29, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(30, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(31, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(32, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(33, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(34, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(37, 1, 'pompes level 2', 5, 'pompes en triangle', 9, 0),
(39, 1, 'monExercice', 60, 'madescription', 50, 0),
(42, 0, 'test', 20, 'monTest', 0, 30),
(43, 1, 'test2', 30, 'test', 20, 0),
(45, 1, 'monExercice', 35, 'test', 35, 0),
(47, 1, 'test', 50, 'test', 40, 0),
(48, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(49, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(50, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(51, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(52, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(53, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(54, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(55, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(56, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(57, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(58, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(59, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(60, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(61, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(62, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(63, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(64, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(65, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(66, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(67, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(68, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(69, 1, 'test', 10, 'test', 10, 0),
(70, 0, 'test2', 10, 'test', 0, 10),
(71, 0, 'ExoMatin', 10, 'Jogging', 0, 20),
(72, 1, 'ExoAnaerobis', 10, 'Jogging', 20, 0),
(73, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(74, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(75, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(76, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(77, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(78, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(79, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(80, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(81, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(82, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(83, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(84, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(85, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(86, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(87, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(88, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(89, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(90, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(91, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(92, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(93, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(94, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(95, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(96, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(97, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(98, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(99, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(100, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(101, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(102, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(103, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(104, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(105, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(106, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(107, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2),
(109, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, 0),
(110, 1, 'Pompe', 5, 'Pompe simple', 15, 0),
(111, 1, 'Squat', 5, 'Squat pour les jambes ', 30, 0),
(112, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, 0),
(113, 0, 'Course a pied ', 10, 'Course à pied rapide', 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `ExerciceDefaut`
--

CREATE TABLE IF NOT EXISTS `ExerciceDefaut` (
  `idExercice` int(11) NOT NULL AUTO_INCREMENT,
  `TypeExercice_idTypeExercice` int(11) NOT NULL,
  `titre` varchar(45) DEFAULT NULL,
  `temps` float DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `repetition` int(11) DEFAULT NULL,
  `distance` float DEFAULT NULL,
  PRIMARY KEY (`idExercice`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `ExerciceDefaut`
--

INSERT INTO `ExerciceDefaut` (`idExercice`, `TypeExercice_idTypeExercice`, `titre`, `temps`, `description`, `repetition`, `distance`) VALUES
(1, 1, 'Traction', 1, 'Traction avec le poids du corp', 5, NULL),
(2, 1, 'Pompe', 5, 'Pompe simple', 15, NULL),
(3, 1, 'Squat', 5, 'Squat pour les jambes ', 30, NULL),
(4, 1, 'Developpé couché', 15, 'Avec barre de musculation', 10, NULL),
(5, 0, 'Course a pied ', 10, 'Course à pied rapide', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `PlanEntrainement`
--

CREATE TABLE IF NOT EXISTS `PlanEntrainement` (
  `idPlanEntrainement` int(11) NOT NULL AUTO_INCREMENT,
  `difficulte` int(11) DEFAULT NULL,
  `duree` float DEFAULT NULL,
  PRIMARY KEY (`idPlanEntrainement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Contenu de la table `PlanEntrainement`
--

INSERT INTO `PlanEntrainement` (`idPlanEntrainement`, `difficulte`, `duree`) VALUES
(1, 5, 30),
(2, 3, 80),
(3, 2, 20),
(5, 0, 0),
(11, 7, 8),
(12, 7, 10),
(13, 3, 0),
(18, 2, 0),
(19, 3, 0),
(20, 3, 0),
(28, 1, 0),
(29, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `PlanEntrainementExercice`
--

CREATE TABLE IF NOT EXISTS `PlanEntrainementExercice` (
  `idPlanEntrainementExercice` int(11) NOT NULL AUTO_INCREMENT,
  `PlanEntrainement_idPlanEntrainement` int(11) NOT NULL,
  `Exercice_idExercice` int(11) NOT NULL,
  PRIMARY KEY (`idPlanEntrainementExercice`),
  KEY `fk_PlanEntrainementExercice_PlanEntrainement1_idx` (`PlanEntrainement_idPlanEntrainement`),
  KEY `fk_PlanEntrainementExercice_Exercice1_idx` (`Exercice_idExercice`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=65 ;

--
-- Contenu de la table `PlanEntrainementExercice`
--

INSERT INTO `PlanEntrainementExercice` (`idPlanEntrainementExercice`, `PlanEntrainement_idPlanEntrainement`, `Exercice_idExercice`) VALUES
(5, 3, 14),
(7, 3, 19),
(8, 3, 20),
(12, 3, 37),
(16, 1, 42),
(17, 1, 43),
(19, 18, 45),
(21, 19, 47),
(22, 20, 69),
(23, 20, 70),
(49, 28, 98),
(50, 28, 99),
(51, 28, 100),
(52, 28, 101),
(53, 28, 102),
(54, 29, 103),
(55, 29, 104),
(56, 29, 105),
(57, 29, 106),
(58, 29, 107);

-- --------------------------------------------------------

--
-- Structure de la table `PlanEntrainementUtilisateur`
--

CREATE TABLE IF NOT EXISTS `PlanEntrainementUtilisateur` (
  `idPlanEntrainementUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Utilisateur_idUtilisateur` int(10) unsigned NOT NULL,
  `PlanEntrainement_idPlanEntrainement` int(11) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `actif` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlanEntrainementUtilisateur`),
  KEY `fk_PlanEntrainementUtilisateur_Utilisateur1_idx` (`Utilisateur_idUtilisateur`),
  KEY `fk_PlanEntrainementUtilisateur_PlanEntrainement1_idx` (`PlanEntrainement_idPlanEntrainement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Contenu de la table `PlanEntrainementUtilisateur`
--

INSERT INTO `PlanEntrainementUtilisateur` (`idPlanEntrainementUtilisateur`, `Utilisateur_idUtilisateur`, `PlanEntrainement_idPlanEntrainement`, `date`, `actif`) VALUES
(1, 1, 1, NULL, 0),
(2, 1, 3, NULL, 1),
(4, 3, 3, NULL, 1),
(7, 1, 11, NULL, 0),
(8, 1, 12, NULL, 0),
(9, 1, 13, NULL, 0),
(14, 1, 18, NULL, 0),
(15, 25, 19, NULL, 1),
(16, 36, 20, NULL, 1),
(24, 41, 28, NULL, 1),
(25, 41, 29, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `Seance`
--

CREATE TABLE IF NOT EXISTS `Seance` (
  `idSeance` int(11) NOT NULL AUTO_INCREMENT,
  `Exercice_idExercice` int(11) NOT NULL,
  `Utilisateur_idUtilisateur` int(10) unsigned NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `temps` float DEFAULT NULL,
  `distance` float DEFAULT NULL,
  `repetition` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSeance`),
  KEY `fk_Seance_Exercice1_idx` (`Exercice_idExercice`),
  KEY `fk_Seance_Utilisateur1_idx` (`Utilisateur_idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `Seance`
--

INSERT INTO `Seance` (`idSeance`, `Exercice_idExercice`, `Utilisateur_idUtilisateur`, `date`, `temps`, `distance`, `repetition`) VALUES
(1, 14, 1, '2015-03-08 23:00:00', 25, 4, 0),
(2, 14, 1, '2015-03-09 23:00:00', 32, 4, 0),
(5, 20, 1, '2015-03-11 23:00:00', 5, 0, 15),
(6, 20, 1, '2015-03-10 23:00:00', 5, 0, 10),
(7, 19, 1, '2015-03-14 23:00:00', 30, 0, 50),
(8, 14, 1, '2015-03-17 23:00:00', 60, 50, 0),
(9, 37, 1, '2015-03-17 23:00:00', 4, 0, 10),
(10, 19, 1, '2015-03-17 23:00:00', 10, 0, 30),
(11, 14, 1, '2015-03-17 23:00:00', 20, 20, 0),
(12, 14, 1, '2015-03-23 23:00:00', 10, 20, 0),
(13, 69, 36, '2015-03-23 23:00:00', 10, 0, 10),
(14, 70, 36, '2015-03-23 23:00:00', 10, 10, 0),
(15, 69, 36, '2015-03-23 23:00:00', 5, 0, 5),
(16, 42, 1, '2015-03-24 23:00:00', 10, 25, 0),
(17, 109, 1, '2015-03-24 23:00:00', 1, 0, 10),
(18, 110, 1, '2015-03-24 23:00:00', 5, 0, 15),
(19, 112, 1, '2015-03-24 23:00:00', 20, 0, 20);

-- --------------------------------------------------------

--
-- Structure de la table `TypeExercice`
--

CREATE TABLE IF NOT EXISTS `TypeExercice` (
  `idTypeExercice` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTypeExercice`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `TypeExercice`
--

INSERT INTO `TypeExercice` (`idTypeExercice`, `name`) VALUES
(0, 'aerobis'),
(1, 'anaerobis');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `idUtilisateur` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sexe` varchar(1) DEFAULT NULL,
  `dateDeNaissance` varchar(20) DEFAULT NULL,
  `taille` float DEFAULT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=42 ;

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`idUtilisateur`, `nom`, `prenom`, `mail`, `login`, `password`, `sexe`, `dateDeNaissance`, `taille`) VALUES
(1, 'Mathieu', 'Lioret', 'mathieu.lioret@hotmail.fr', 'mat', 'motdepasse', 'h', '06/03/1992', 170),
(2, 'testmat', 'mat', 'mathieu.lioret@hotmail.fr', 'testmat', 'mat', 'h', '06/03/1992', 169),
(3, 'yass', 'test', 'mail', 'login', 'mdp', 'h', '01/01/1992', 1),
(20, '', '', '', 'aaa', 'eee', 'f', '', 0),
(23, 'root', 'root', 'root@hotmail.fr', 'root', 'root', 'h', '06/03/1992', 70),
(25, 'test', 'test', 'test@hotmail.fr', 'test93', 'test', 'h', '', 0),
(27, 'test', 'test', 'mail', 'logtest', 'mdp', 'h', '25/06/1965', 1),
(31, 'test', 'test', 'test@hotmail.fr', 'test', 'test93', 'h', '', 0),
(32, 'test2', 'test2', 'test2@hotmail.fr', 'test2', 'test94', 'h', '16/07/1991', 40),
(33, 'test3', 'test3', 'test3@hotmail.fr', 'test3', 'test94', 'h', '16/07/1991', 40),
(34, 'test5', 'test5', 'test5@hotmail.fr', 'test4', 'test95', 'h', '16/07/1991', 40),
(36, 'lulu', 'lulu', 'lulu', 'lulu', 'lulu', 'f', '16/08/1993', 200),
(41, '', '', '', 'tentacool', 'tentacool', 'f', '', 0);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `DonneesUtilisateur`
--
ALTER TABLE `DonneesUtilisateur`
  ADD CONSTRAINT `fk_DonneesUtilisateur_Utilisateur` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Exercice`
--
ALTER TABLE `Exercice`
  ADD CONSTRAINT `fk_Exercice_TypeExercice1` FOREIGN KEY (`TypeExercice_idTypeExercice`) REFERENCES `TypeExercice` (`idTypeExercice`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `PlanEntrainementExercice`
--
ALTER TABLE `PlanEntrainementExercice`
  ADD CONSTRAINT `fk_PlanEntrainementExercice_Exercice1` FOREIGN KEY (`Exercice_idExercice`) REFERENCES `Exercice` (`idExercice`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PlanEntrainementExercice_PlanEntrainement1` FOREIGN KEY (`PlanEntrainement_idPlanEntrainement`) REFERENCES `PlanEntrainement` (`idPlanEntrainement`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `PlanEntrainementUtilisateur`
--
ALTER TABLE `PlanEntrainementUtilisateur`
  ADD CONSTRAINT `fk_PlanEntrainementUtilisateur_PlanEntrainement1` FOREIGN KEY (`PlanEntrainement_idPlanEntrainement`) REFERENCES `PlanEntrainement` (`idPlanEntrainement`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PlanEntrainementUtilisateur_Utilisateur1` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Seance`
--
ALTER TABLE `Seance`
  ADD CONSTRAINT `fk_Seance_Exercice1` FOREIGN KEY (`Exercice_idExercice`) REFERENCES `Exercice` (`idExercice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Seance_Utilisateur1` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
