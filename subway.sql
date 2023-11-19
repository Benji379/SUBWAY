-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2023 a las 13:49:46
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `subway`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `dniCliente` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dniCliente`, `nombre`, `apellido`, `direccion`) VALUES
('4839234', 'luis', 'lopez', 'mz e lt 21 lima'),
('72839215', 'justo', 'bruno', 'mz h lt 41'),
('73820343', 'brad', 'cueva', 'mz j lt 50 los olivos'),
('82928290', 'maria', 'miranda', 'av velazco lt 21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  `rango` varchar(20) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`dni`, `nombre`, `apellido`, `sexo`, `correo`, `direccion`, `contraseña`, `rango`, `fecha`) VALUES
('12345678', 'Benjamin', 'Atoche', 'M', 'benjamin@gmail.com', 'Mz e lt 22', '123', 'Administrador', '2023-10-02'),
('71828293', 'Maria', 'Cueva', 'M', 'maria@gmail.com', 'mz e lt. 21 los olivos', '123', 'Empleado', '2023-10-04'),
('87654321', 'juan', 'lopez', 'M', 'juan@gmail.com', 'mz e lt 34 los olivos', '321', 'Administrador', '2023-11-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigoProducto` varchar(25) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(6) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigoProducto`, `nombre`, `precio`, `stock`, `fecha`) VALUES
('172827812', 'gaseosa', '5.50', 1, '2023-10-06'),
('1920301921', 'combo triple', '10.00', 21, '2023-10-10'),
('329328893', 'helado', '13.00', 12, '2023-11-13'),
('81278912812', 'hambuerguesa', '10.00', 5, '2023-11-13'),
('8219821889', 'parrillada', '40.30', 7, '2023-10-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` varchar(8) NOT NULL,
  `trabajador` varchar(8) NOT NULL,
  `cliente` varchar(8) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `trabajador`, `cliente`, `total`, `fecha`) VALUES
('00000001', '71828293', '72839215', '102.00', '2023-01-06'),
('00000002', '12345678', '72839215', '185.30', '2023-01-07'),
('00000003', '12345678', '82928290', '922.40', '2023-01-13'),
('00000004', '12345678', '4839234', '355.90', '2023-01-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaproductos`
--

CREATE TABLE `ventaproductos` (
  `N` int(11) NOT NULL,
  `idVenta` varchar(8) NOT NULL,
  `codigoProducto` varchar(25) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ventaproductos`
--

INSERT INTO `ventaproductos` (`N`, `idVenta`, `codigoProducto`, `cantidad`, `total`) VALUES
(1, '00000001', '172827812', 2, '51.00'),
(3, '00000002', '1920301921', 2, '80.00'),
(4, '00000002', '8219821889', 1, '105.30'),
(5, '00000002', '329328893', 8, '184.00'),
(6, '00000002', '1920301921', 2, '80.00'),
(7, '00000003', '8219821889', 8, '842.40'),
(8, '00000003', '1920301921', 2, '80.00'),
(9, '00000004', '1920301921', 1, '40.00'),
(10, '00000004', '8219821889', 3, '315.90');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dniCliente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigoProducto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `cliente` (`cliente`),
  ADD KEY `trabajador` (`trabajador`);

--
-- Indices de la tabla `ventaproductos`
--
ALTER TABLE `ventaproductos`
  ADD PRIMARY KEY (`N`),
  ADD KEY `codigoProducto` (`codigoProducto`),
  ADD KEY `idVenta` (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ventaproductos`
--
ALTER TABLE `ventaproductos`
  MODIFY `N` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`trabajador`) REFERENCES `empleados` (`dni`) ON UPDATE CASCADE,
  ADD CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`dniCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventaproductos`
--
ALTER TABLE `ventaproductos`
  ADD CONSTRAINT `ventaproductos_ibfk_2` FOREIGN KEY (`codigoProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ventaproductos_ibfk_3` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
