-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 04 Décembre 2012 à 08:53
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données: `bdcinebook`
--

-- --------------------------------------------------------

--
-- Structure de la table `cinemafrequente`
--

CREATE TABLE IF NOT EXISTS `cinemafrequente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cinema` varchar(250) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commentairecinema`
--

CREATE TABLE IF NOT EXISTS `commentairecinema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `texte` varchar(250) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_cinema` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commentairefilm`
--

CREATE TABLE IF NOT EXISTS `commentairefilm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `texte` varchar(250) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_film` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE IF NOT EXISTS `droit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `membre` tinyint(1) NOT NULL,
  `moderateur` tinyint(1) NOT NULL,
  `administrateur` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `droit`
--

INSERT INTO `droit` (`id`, `membre`, `moderateur`, `administrateur`) VALUES
(1, 1, 0, 0),
(2, 1, 1, 0),
(3, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `filmvu`
--

CREATE TABLE IF NOT EXISTS `filmvu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_film` varchar(250) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(20) NOT NULL,
  `login` varchar(50) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `code_postal` varchar(5) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `id_droit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


