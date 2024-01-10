-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 09, 2024 at 06:26 PM
-- Server version: 5.7.36
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e202200123721`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
CREATE TABLE IF NOT EXISTS `app_role` (
    `role` varchar(255) NOT NULL,
    PRIMARY KEY (`role`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_role`
--

INSERT INTO `app_role` (`role`) VALUES
                                    ('ADMIN'),
                                    ('USER');

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE IF NOT EXISTS `app_user` (
    `user_id` varchar(255) NOT NULL,
    `password` varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`user_id`, `password`, `username`) VALUES
                                                               ('92e7b5ce-5638-4629-98e9-e05d5f559461', '$2a$10$80cy8Xtm3KouFePlWh9SAeTTMH1kOIlDFXPSZF3CcJKr5yM.f4zWm', 'oumaima'),
                                                               ('f550a262-9587-43b8-aa30-ae9cff3a4856', '$2a$10$jnA6AxlF1cu5fGB1KerSJ.uwNnG1ltwV6KmlYN7HKrHpBVY4ToH3.', 'taha');

-- --------------------------------------------------------

--
-- Table structure for table `app_user_roles`
--

DROP TABLE IF EXISTS `app_user_roles`;
CREATE TABLE IF NOT EXISTS `app_user_roles` (
    `app_user_user_id` varchar(255) NOT NULL,
    `roles_role` varchar(255) NOT NULL,
    KEY `FKgr9tde1lxmnugu1yf5rbdqe24` (`roles_role`),
    KEY `FK7j68xnb7cl41m3b1leb0b186g` (`app_user_user_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_user_roles`
--

INSERT INTO `app_user_roles` (`app_user_user_id`, `roles_role`) VALUES
                                                                    ('92e7b5ce-5638-4629-98e9-e05d5f559461', 'USER'),
                                                                    ('92e7b5ce-5638-4629-98e9-e05d5f559461', 'ADMIN'),
                                                                    ('f550a262-9587-43b8-aa30-ae9cff3a4856', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `associea`
--

DROP TABLE IF EXISTS `associea`;
CREATE TABLE IF NOT EXISTS `associea` (
    `codeM` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
    `num_Celebrite` int(11) NOT NULL,
    KEY `FKi1cnj8em1pwtbbetdhjxh5bp8` (`codeM`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `associea`
--

INSERT INTO `associea` (`codeM`, `num_Celebrite`) VALUES
                                                      ('spdrjzvhx3eu', 2),
                                                      ('spdrjzvhx3eu', 3),
                                                      ('spfb054nhrd9', 1),
                                                      ('spfb054nhrd9', 2),
                                                      ('spfb054nhrd9', 5),
                                                      ('spfb054nhrd9', 6),
                                                      ('spfb054nhrd9', 7),
                                                      ('spfb05kxu4d5', 8),
                                                      ('spfb05kxu4d5', 9),
                                                      ('spfb05kxu4d5', 10);

-- --------------------------------------------------------

--
-- Table structure for table `celebrite`
--

DROP TABLE IF EXISTS `celebrite`;
CREATE TABLE IF NOT EXISTS `celebrite` (
    `num_Celebrite` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `nom` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `prenom` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `nationalite` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `epoque` varchar(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`num_Celebrite`)
    ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `celebrite`
--

INSERT INTO `celebrite` (`num_Celebrite`, `nom`, `prenom`, `nationalite`, `epoque`) VALUES
                                                                                        (1, 'Moulin', 'Jean', 'Francaise', 'XX'),
                                                                                        (2, 'Injalbert', 'Jean-Antoine', 'Francaise', 'XIX'),
                                                                                        (3, 'Poquelin', 'Jean-Baptiste', 'Francaise', 'XVII'),
                                                                                        (4, 'Chaptal', 'Jean-Antoine', 'Francaise', 'XVII'),
                                                                                        (5, 'Pitot', 'Henri', 'Francaise', 'XVIII'),
                                                                                        (6, 'Giral', 'Jean-Antoine', 'Francaise', 'XVIII'),
                                                                                        (7, 'Donnat', 'Jacques', 'Francaise', 'XVIII'),
                                                                                        (8, 'Rabelais', 'Francois', 'Francaise', 'XVI'),
                                                                                        (9, 'De Villeneuve', 'Arnaud', 'Francaise', 'XIII');

-- --------------------------------------------------------

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE IF NOT EXISTS `departement` (
    `dep` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nom_Dep` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `chef_Lieu` varchar(46) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `num_reg` varchar(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`dep`),
    KEY `departement_fk` (`chef_Lieu`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`dep`, `nom_Dep`, `chef_Lieu`, `num_reg`) VALUES
                                                                         ('30', 'GARD', '30189', '76'),
                                                                         ('34', 'HERAULT', '34172', '76');

-- --------------------------------------------------------

--
-- Table structure for table `jardin`
--

DROP TABLE IF EXISTS `jardin`;
CREATE TABLE IF NOT EXISTS `jardin` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `adresse` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `commune` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `date_creation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `nom_du_jardin` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `code_Insee` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `adresse_complete` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `date_de_creation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `jardin_fk` (`code_Insee`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `jardin`
--

INSERT INTO `jardin` (`id`, `adresse`, `commune`, `date_creation`, `nom_du_jardin`, `type`, `code_Insee`, `adresse_complete`, `date_de_creation`) VALUES
                                                                                                                                                      (1, 'Château de Flaugergues, 1744 Av. Albert Einstein, 34000 Montpellier, France', 'Montpellier', '2020-12-11', 'Parc de Flaugergues', 'Jardin régulier Parc paysager Jardin privé', '34172', NULL, NULL),
                                                                                                                                                      (2, '74 Rue Jean Valette, 34500 Béziers, France', 'Béziers​', '2020-12-11', 'Jardin de la Villa Antonine', 'Jardin remarquable', '34032', NULL, NULL),
                                                                                                                                                      (3, '45 Av. Jean Jaurès, 30900 Nîmes, France', 'Nîmes', '2020-12-11', 'Jardins de la Fontaine', 'Parc paysager, Jardin public', '30189', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
    `code_Insee` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nom_Com` varchar(46) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `longitude` float DEFAULT NULL,
    `latitude` float DEFAULT NULL,
    `dep` varchar(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`code_Insee`),
    KEY `lieu_fk` (`dep`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `lieu`
--

INSERT INTO `lieu` (`code_Insee`, `nom_Com`, `longitude`, `latitude`, `dep`) VALUES
                                                                                 ('30189', 'NIMES', 4.36005, 43.8367, '30'),
                                                                                 ('30334', 'UZES', 4.41995, 44.0121, '30'),
                                                                                 ('34032', 'BEZIERS', 3.2158, 43.3442, '34'),
                                                                                 ('34129', 'LATTES', 3.89647, 43.5673, '34'),
                                                                                 ('34142', 'LODEVE', 3.31398, 43.7337, '34'),
                                                                                 ('34172', 'MONTPELLIER', 3.87672, 43.6108, '34'),
                                                                                 ('34198', 'PEROLS', 3.95421, 43.5638, '34'),
                                                                                 ('34199', 'PEZENAS', 3.42319, 43.4615, '34'),
                                                                                 ('9119', '222', 2, 1, '34');

-- --------------------------------------------------------

--
-- Table structure for table `monument`
--

DROP TABLE IF EXISTS `monument`;
CREATE TABLE IF NOT EXISTS `monument` (
    `geohash` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nom` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `proprietaire` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `typeM` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `longitude` float DEFAULT NULL,
    `latitude` float DEFAULT NULL,
    `code_Insee` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`geohash`),
    KEY `monument_fk` (`code_Insee`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `monument`
--

INSERT INTO `monument` (`geohash`, `nom`, `proprietaire`, `typeM`, `longitude`, `latitude`, `code_Insee`) VALUES
                                                                                                              ('spdrjzvhx3eu', 'SQUARE MOLIERE', 'PUBLIC', 'SQUARE', 3.42393, 43.4613, '34199'),
                                                                                                              ('spdzbn81hv6q', 'EGLISE SAINT-MICHEL DE MONTELS', 'PUBLIC', 'EGLISE', 3.86739, 43.5857, '34172'),
                                                                                                              ('spf8pgvv6wse', 'EGLISE SAINTE-THERESE-DE-LISIEUX DE MONTPELLIER', 'PUBLIC', 'EGLISE', 3.86421, 43.6153, '34172'),
                                                                                                              ('spfb04fe0zkn', 'EGLISE SAINTE-EULALIE DE MONTPELLIER', 'PUBLIC', 'EGLISE', 3.87066, 43.6094, '34172'),
                                                                                                              ('spfb04jd7ux5', 'EGLISE SAINT-DENIS DE MONTPELLIER', 'PUBLIC', 'EGLISE', 3.87491, 43.6051, '34172'),
                                                                                                              ('spfb04ubqkr3', 'HOTEL DE RICARD', 'PRIVE', 'HOTEL_PARTICULIER', 3.87399, 43.6089, '34172'),
                                                                                                              ('spfb04v1ntsm', 'HOTEL DE CASTRIES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87434, 43.6091, '34172'),
                                                                                                              ('spfb04x7htxd', 'HOTEL SAINT-COME', 'PRIVE', 'HOTEL_PARTICULIER', 3.87735, 43.608, '34172'),
                                                                                                              ('spfb04xehcqt', 'HOTEL DE FOURQUES', 'PRIVE', 'HOTEL_PARTICULIER', 3.8777, 43.608, '34172'),
                                                                                                              ('spfb04xgf629', 'HOTEL REY', 'PRIVE', 'HOTEL_PARTICULIER', 3.87793, 43.6081, '34172'),
                                                                                                              ('spfb04xr32w4', 'HOTEL DE SAINT-FELIX', 'PRIVE', 'HOTEL_PARTICULIER', 3.87721, 43.6087, '34172'),
                                                                                                              ('spfb04ybz0hw', 'HOTEL LECOURT', 'PRIVE', 'HOTEL_PARTICULIER', 3.87676, 43.609, '34172'),
                                                                                                              ('spfb04yhhc7d', 'HOTEL DE MONTCALM', 'PRIVE', 'HOTEL_PARTICULIER', 3.87564, 43.6096, '34172'),
                                                                                                              ('spfb04yzxkr1', 'HALLE CASTELLANE', 'PUBLIC', 'EDIFICE', 3.87678, 43.6102, '34172'),
                                                                                                              ('spfb04zhzzfh', 'HOTEL DE GAYON', 'PRIVE', 'HOTEL_PARTICULIER', 3.87714, 43.6097, '34172'),
                                                                                                              ('spfb054nhrd9', 'PROMENADE DU PEYROU', 'PUBLIC', 'EDIFICE', 3.87012, 43.6113, '34172'),
                                                                                                              ('spfb055v1xfz', 'PORTE DU PEYROU', 'PUBLIC', 'EDIFICE', 3.87241, 43.6111, '34172'),
                                                                                                              ('spfb05h0fw4z', 'HOTEL DE LUNAS', 'PRIVE', 'HOTEL_PARTICULIER', 3.87279, 43.6104, '34172'),
                                                                                                              ('spfb05jcert7', 'HOTEL PAS DE BEAULIEU', 'PRIVE', 'HOTEL_PARTICULIER', 3.87523, 43.6105, '34172'),
                                                                                                              ('spfb05k426n3', 'ANCIENNE PRISON DE MONTPELLIER', 'PUBLIC', 'EDIFICE', 3.8727, 43.612, '34172'),
                                                                                                              ('spfb05kxu4d5', 'FACULTE DE MEDECINE DE MONTPELLIER', 'PUBLIC', 'UNIVERSITE', 3.87354, 43.6129, '34172'),
                                                                                                              ('spfb05m4pe36', 'HOTEL DE CAMBACERES-MURLES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87438, 43.612, '34172'),
                                                                                                              ('spfb05n1zkf3', 'HOTEL VERCHANT', 'PRIVE', 'HOTEL_PARTICULIER', 3.87574, 43.6106, '34172'),
                                                                                                              ('spfb05nw3q73', 'FONTAINE DE LA PREFECTURE', 'PUBLIC', 'EDIFICE', 3.87617, 43.6113, '34172'),
                                                                                                              ('spfb05nwqmvu', 'HOTEL DE GANGES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87639, 43.6113, '34172'),
                                                                                                              ('spfb05ptyz6b', 'HOTEL DE MIRMAN', 'PRIVE', 'HOTEL_PARTICULIER', 3.87778, 43.6113, '34172'),
                                                                                                              ('spfb05r1yesc', 'HOTEL D\'USTON', 'PRIVE', 'HOTEL_PARTICULIER', 3.87709, 43.6119, '34172'),
('spfb05r6jkf7', 'HOTEL DE SOLAS', 'PRIVE', 'HOTEL_PARTICULIER', 3.87737, 43.612, '34172'),
('spfb05rczjtg', 'HOTEL DE ROQUEMORE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87814, 43.6119, '34172'),
('spfb05ty554b', 'HOTEL DUFFAU', 'PRIVE', 'HOTEL_PARTICULIER', 3.87522, 43.614, '34172'),
('spfb05z3rwep', 'PORTE DE LA BLANQUERIE', 'PUBLIC', 'EDIFICE', 3.87747, 43.6146, '34172'),
('spfb068j1fdv', 'HOTEL LAMOUROUX', 'PRIVE', 'HOTEL_PARTICULIER', 3.87825, 43.6084, '34172'),
('spfb06b4s7pz', 'HOTEL DE FLAUGERGUES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87837, 43.6093, '34172'),
('spfb06b5cb0b', 'HOTEL DE BENEZET', 'PRIVE', 'HOTEL_PARTICULIER', 3.87825, 43.6095, '34172'),
('spfb06bkjnx2', 'HOTEL DES TRESORIERS DE FRANCE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87874, 43.6096, '34172'),
('spfb06bq3hfv', 'HOTEL DE MAGNY', 'PRIVE', 'HOTEL_PARTICULIER', 3.87856, 43.61, '34172'),
('spfb0702ubt1', 'HOTEL DE MANSE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87873, 43.6104, '34172'),
('spfb0703fxke', 'HOTEL BASCHY-DU-CAYLA', 'PRIVE', 'HOTEL_PARTICULIER', 3.87863, 43.6106, '34172'),
('spfb0704x32z', 'HOTEL DE VARENNES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87849, 43.6107, '34172'),
('spfb070h0d5t', 'HOTEL DE MONTFERRIER', 'PRIVE', 'HOTEL_PARTICULIER', 3.8782, 43.6109, '34172'),
('spfb070hzm8g', 'HOTEL DE GRIFFY', 'PRIVE', 'HOTEL_PARTICULIER', 3.87849, 43.6111, '34172'),
('spfb070q3mv0', 'HOTEL ESTORC', 'PRIVE', 'HOTEL_PARTICULIER', 3.87858, 43.6113, '34172'),
('spfb070qgp2u', 'HOTEL DE LA SOCIETE ROYALE DES SCIENCES', 'PRIVE', 'HOTEL_PARTICULIER', 3.87865, 43.6114, '34172'),
('spfb070wrnu3', 'HOTEL DE JOUBERT', 'PRIVE', 'HOTEL_PARTICULIER', 3.87917, 43.6113, '34172'),
('spfb07210dtw', 'HOTEL DE BAUDON DE MAUNY', 'PRIVE', 'HOTEL_PARTICULIER', 3.8782, 43.6118, '34172'),
('spfb07248bmb', 'HOTEL D\'AVEZE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87821, 43.612, '34172'),
                                                                                                              ('spfb0725nhcx', 'HOTEL DE BEAULAC', 'PRIVE', 'HOTEL_PARTICULIER', 3.87843, 43.6121, '34172'),
                                                                                                              ('spfb072k0td7', 'HOTEL DEYDE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87854, 43.6123, '34172'),
                                                                                                              ('spfb073h9t9u', 'HOTEL DE GRAVE', 'PRIVE', 'HOTEL_PARTICULIER', 3.87961, 43.6124, '34172'),
                                                                                                              ('spfb15q3018t', 'PRIEURE SAINT-PIERRE DE MONTAUBEROU', 'PUBLIC', 'PRIEURE', 3.91972, 43.6118, '34172');

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
    `numSS` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
    `nom` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `dateN` date DEFAULT NULL,
    `genre` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `localisation` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`numSS`),
    KEY `personne_fk` (`localisation`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`numSS`, `nom`, `dateN`, `genre`, `localisation`) VALUES
                                                                              ('1123', 'Eloi', '1978-09-02', 'M', 'Angers'),
                                                                              ('1234', 'Marie', '1988-06-02', 'F', 'Montpellier'),
                                                                              ('2345', 'Paul', '1998-06-06', 'M', 'Paris'),
                                                                              ('3456', 'Elise', '2008-06-02', 'F', 'Berlin');

-- --------------------------------------------------------

--
-- Table structure for table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
    `numProduit` int(11) NOT NULL,
    `catégorie` enum('téléphone','tablette','écouteurs') DEFAULT NULL,
    `nom` varchar(50) NOT NULL DEFAULT '',
    `marque` varchar(50) NOT NULL DEFAULT '',
    `prix` float DEFAULT NULL,
    PRIMARY KEY (`numProduit`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produits`
--

INSERT INTO `produits` (`numProduit`, `catégorie`, `nom`, `marque`, `prix`) VALUES
                                                                                (1, 'téléphone', 'Galaxy A20', 'Samsung', 155),
                                                                                (2, 'téléphone', 'Galaxy S10E', 'Samsung', 499.99),
                                                                                (3, 'téléphone', 'iPhone X', 'Apple', 729),
                                                                                (4, 'tablette', 'Oxygen', 'Archos', 169),
                                                                                (5, 'tablette', 'iPad Air 2', 'Apple', 199),
                                                                                (6, 'écouteurs', 'airPods 2', 'Apple', 179);

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
    `nom` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
    `pays` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`nom`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ville`
--

INSERT INTO `ville` (`nom`, `pays`) VALUES
                                        ('Angers', 'France'),
                                        ('Berlin', 'Allemagne'),
                                        ('Montpellier', 'France'),
                                        ('Paris', 'France');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
    ADD CONSTRAINT `FK7j68xnb7cl41m3b1leb0b186g` FOREIGN KEY (`app_user_user_id`) REFERENCES `app_user` (`user_id`),
  ADD CONSTRAINT `FKgr9tde1lxmnugu1yf5rbdqe24` FOREIGN KEY (`roles_role`) REFERENCES `app_role` (`role`);

--
-- Constraints for table `associea`
--
ALTER TABLE `associea`
    ADD CONSTRAINT `FKi1cnj8em1pwtbbetdhjxh5bp8` FOREIGN KEY (`codeM`) REFERENCES `monument` (`geohash`);

--
-- Constraints for table `departement`
--
ALTER TABLE `departement`
    ADD CONSTRAINT `departement_fk` FOREIGN KEY (`chef_Lieu`) REFERENCES `lieu` (`code_Insee`);

--
-- Constraints for table `jardin`
--
ALTER TABLE `jardin`
    ADD CONSTRAINT `jardin_fk` FOREIGN KEY (`code_Insee`) REFERENCES `lieu` (`code_Insee`);

--
-- Constraints for table `lieu`
--
ALTER TABLE `lieu`
    ADD CONSTRAINT `lieu_fk` FOREIGN KEY (`dep`) REFERENCES `departement` (`dep`);

--
-- Constraints for table `monument`
--
ALTER TABLE `monument`
    ADD CONSTRAINT `monument_fk` FOREIGN KEY (`code_Insee`) REFERENCES `lieu` (`code_Insee`);

--
-- Constraints for table `personne`
--
ALTER TABLE `personne`
    ADD CONSTRAINT `personne_fk` FOREIGN KEY (`localisation`) REFERENCES `ville` (`nom`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
