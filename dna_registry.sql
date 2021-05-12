-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2021 at 02:52 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dna_registry`
--
CREATE DATABASE IF NOT EXISTS `dna_registry` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dna_registry`;

-- --------------------------------------------------------

--
-- Table structure for table `genomes`
--

DROP TABLE IF EXISTS `genomes`;
CREATE TABLE `genomes` (
  `id` int(11) NOT NULL,
  `dna` text NOT NULL,
  `is_mutant` tinyint(1) NOT NULL,
  `is_human` tinyint(1) NOT NULL,
  `is_defective` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `genomes`
--
ALTER TABLE `genomes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dna` (`dna`) USING HASH,
  ADD KEY `is_mutant` (`is_mutant`),
  ADD KEY `is_human` (`is_human`),
  ADD KEY `is_defective` (`is_defective`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `genomes`
--
ALTER TABLE `genomes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
