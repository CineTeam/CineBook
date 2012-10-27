-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Sam 27 Octobre 2012 à 12:36
-- Version du serveur: 5.1.36
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `bdcinebook`
--

-- --------------------------------------------------------

--
-- Structure de la table `cinemas_frequentes`
--

CREATE TABLE IF NOT EXISTS `cinemas_frequentes` (
  `id_cinema` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cinemas_frequentes`
--


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
-- Structure de la table `films_vus`
--

CREATE TABLE IF NOT EXISTS `films_vus` (
  `id_film` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `films_vus`
--


-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(20) NOT NULL,
  `login` varchar(50) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `code_postal` int(5) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `id_droit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `utilisateur`
--
