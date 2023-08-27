-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2022 a las 19:20:55
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresaramo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficinas`
--

CREATE TABLE `oficinas` (
  `idOficina` int(11) NOT NULL,
  `ofiNombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oficinas`
--

INSERT INTO `oficinas` (`idOficina`, `ofiNombre`) VALUES
(4, 'Archivo'),
(3, 'Contabilidad'),
(1, 'Gerencia'),
(5, 'Sistemas'),
(2, 'Talento Humano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `idPersona` int(11) NOT NULL,
  `perIdentificacion` varchar(45) NOT NULL,
  `perNombre` varchar(45) NOT NULL,
  `perApellido` varchar(45) NOT NULL,
  `perCorreo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`idPersona`, `perIdentificacion`, `perNombre`, `perApellido`, `perCorreo`) VALUES
(1, '435', 'dsfds', 'dsfds', 'dsf'),
(2, '32432', 'fdgfd', 'fdg', 'fdgfdg'),
(3, '2344', 'dsfds', 'dsfdsds', 'fdsfdsfds'),
(4, '12', 'fghfh', 'ghgfhgf', 'ghfhgf'),
(5, '43', 'gfd', 'fdg', 'fdg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visitantes`
--

CREATE TABLE `visitantes` (
  `idVisitantes` int(11) NOT NULL,
  `visPersona` varchar(45) NOT NULL,
  `visOficina` int(11) NOT NULL,
  `visFechaHoraIngreso` datetime NOT NULL,
  `visFechaHoraSalida` datetime DEFAULT NULL,
  `estado` enum('Ingreso','Salida') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `visitantes`
--

INSERT INTO `visitantes` (`idVisitantes`, `visPersona`, `visOficina`, `visFechaHoraIngreso`, `visFechaHoraSalida`, `estado`) VALUES
(1, '435', 3, '2022-12-07 20:08:17', '2022-12-07 20:09:25', 'Salida'),
(2, '32432', 4, '2022-12-07 22:02:15', NULL, 'Ingreso'),
(3, '2344', 5, '2022-12-07 22:49:36', NULL, 'Ingreso'),
(4, '12', 2, '2022-12-07 22:49:43', '2022-12-07 22:49:48', 'Salida'),
(5, '43', 1, '2022-12-08 09:42:55', '2022-12-08 09:43:17', 'Salida');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `oficinas`
--
ALTER TABLE `oficinas`
  ADD PRIMARY KEY (`idOficina`),
  ADD UNIQUE KEY `ofiNombre` (`ofiNombre`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`idPersona`),
  ADD UNIQUE KEY `perIdentificacion` (`perIdentificacion`),
  ADD UNIQUE KEY `perCorreo` (`perCorreo`);

--
-- Indices de la tabla `visitantes`
--
ALTER TABLE `visitantes`
  ADD PRIMARY KEY (`idVisitantes`),
  ADD KEY `visPersona` (`visPersona`),
  ADD KEY `visOficina` (`visOficina`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `oficinas`
--
ALTER TABLE `oficinas`
  MODIFY `idOficina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `visitantes`
--
ALTER TABLE `visitantes`
  MODIFY `idVisitantes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `visitantes`
--
ALTER TABLE `visitantes`
  ADD CONSTRAINT `visitantes_ibfk_1` FOREIGN KEY (`visPersona`) REFERENCES `personas` (`perIdentificacion`),
  ADD CONSTRAINT `visitantes_ibfk_2` FOREIGN KEY (`visOficina`) REFERENCES `oficinas` (`idOficina`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
