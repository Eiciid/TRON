-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 11 juil. 2018 à 22:07
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tron`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `ajout`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ajout` (IN `score` VARCHAR(255))  NO SQL
INSERT INTO tron.resultats (nom) VALUES (score)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `resultats`
--

DROP TABLE IF EXISTS `resultats`;
CREATE TABLE IF NOT EXISTS `resultats` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `resultats`
--

INSERT INTO `resultats` (`id`, `nom`) VALUES
(1, 'fvdrswsfedc'),
(2, 'ujhb'),
(3, 'zqd'),
(4, 'dz'),
(5, 'qzf'),
(6, 'esq'),
(7, ''),
(8, 'qze'),
(9, '2'),
(10, '1'),
(11, 'iju+'),
(12, 'hg'),
(13, 'ju'),
(14, '541'),
(15, 's'),
(16, '4'),
(17, 'a');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
