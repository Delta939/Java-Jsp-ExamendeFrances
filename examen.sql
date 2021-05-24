-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 21, 2018 at 12:19 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `examen`
--

-- --------------------------------------------------------

--
-- Table structure for table `estudiante`
--

CREATE TABLE `estudiante` (
  `matricula` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `ap_paterno` varchar(255) NOT NULL,
  `ap_materno` varchar(255) NOT NULL,
  `calificacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estudiante`
--

INSERT INTO `estudiante` (`matricula`, `nombre`, `ap_paterno`, `ap_materno`, `calificacion`) VALUES
('18-124-1245', 'Ceballos', 'Fernandez', 'Joshua', 10),
('19-003-1245', 'Rosales', 'Mendez', 'Eric', 10),
('20-002-1245', 'Nuñez', 'Ibañez', 'Shury', 10),
('20-342-6666', 'Alba', 'Rafael', 'Molina', 10),
('25-003-1245', 'Dorantes', 'Robotic', 'Joshua', 10),
('30-003-1345', 'JJ', 'Benitez', 'Elvira', 10),
('40-003-1276', 'Garcia', 'Pedraza', 'Yamilet', 10),
('50-003-1245', 'Mtz', 'Garcia', 'Estrella', 10),
('60-003-1453', 'Torre', 'Garcia', 'Rose', 10),
('60-232-1245', 'Mt', 'G', 'Estr', 10),
('99-77-6512', 'choc', 'Jony', 'Tartaro', 0);

-- --------------------------------------------------------

--
-- Table structure for table `examen`
--

CREATE TABLE `examen` (
  `n_pregunta` int(255) NOT NULL,
  `num_pregunta_vista` varchar(255) NOT NULL,
  `respuesta_estudiante` varchar(255) NOT NULL,
  `matricula` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examen`
--

INSERT INTO `examen` (`n_pregunta`, `num_pregunta_vista`, `respuesta_estudiante`, `matricula`) VALUES
(7, 'uno', 'b', '20-342-6666'),
(9, 'uno', 'b', '99-77-6512');

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

CREATE TABLE `profesor` (
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`email`, `password`) VALUES
('profesor@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `reactivos`
--

CREATE TABLE `reactivos` (
  `num_pregunta` int(11) NOT NULL,
  `pregunta` varchar(255) NOT NULL,
  `opcion_a` varchar(255) NOT NULL,
  `opcion_b` varchar(255) NOT NULL,
  `opcion_c` varchar(255) NOT NULL,
  `respuesta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reactivos`
--

INSERT INTO `reactivos` (`num_pregunta`, `pregunta`, `opcion_a`, `opcion_b`, `opcion_c`, `respuesta`) VALUES
(1, '¿En que año el hombre piso la luna?', '1964', '1986', '1996', 'a'),
(2, '¿Cuanto vale x en la ecuacion x-10=0?', 'x=1', 'x=10', 'x=9', 'b'),
(3, '¿Quien escribio \"El Quijote de la mancha\"?', 'Cervantes Saavedra', 'Carlos Fuentes', 'Elena Poniatovska', 'a'),
(4, '¿Cuando empezo la 2 Guerra Mundial?', '2016', '2013', '1945', 'c'),
(5, '¿Donde esta ubicado el Museo de Louvre?', 'Alemania', 'Francia', 'Italia', 'b'),
(6, '¿Cual es la fecha de la batalla de Puebla?', '3 de Mayo', '5 de Mayo', '7 de Mayo', 'b'),
(7, '¿Cual es la capital de Japon?', 'Berlin', 'Seul', 'Tokio', 'c'),
(8, '¿Cual es la capital de Argentina?', 'Lima', 'Rio de la Plata', 'Buenos Aires', 'c'),
(9, '¿Donde se encuentra la Torre Latinoamericana?', 'EUA', 'Ciudad de Mexico', 'Canada', 'b'),
(10, '¿En que estado quedan las ruinas de Tenochtitlan?', 'Morelos', 'Ciudad de Mexico', 'Puebla', 'b');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`matricula`);

--
-- Indexes for table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`matricula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
