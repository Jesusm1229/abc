-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2020 a las 04:39:26
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `abcdatabase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idcategoria` int(11) NOT NULL,
  `categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategoria`, `categoria`) VALUES
(1, 'Backend'),
(2, 'Frontend'),
(3, 'DevOps'),
(4, 'UIX'),
(5, 'QA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificaciones`
--

CREATE TABLE `certificaciones` (
  `idcertificacion` int(11) NOT NULL,
  `certificacion` varchar(30) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `certificaciones`
--

INSERT INTO `certificaciones` (`idcertificacion`, `certificacion`, `idpostulante`) VALUES
(13, 'Oracle', 110),
(14, 'Laravel', 110),
(15, 'PHP', 111),
(16, 'Laravel', 111),
(17, 'SQL', 111),
(18, 'PHP', 112),
(19, 'Oracle', 112),
(20, 'SQL', 112),
(21, 'Javascript', 112),
(22, 'Oracle', 113),
(23, 'SQL', 113),
(24, 'PHP', 113),
(25, 'Java', 113),
(26, 'ssasssa', 114),
(27, 'fdf', 114),
(28, 'Java fx', 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificaciones_ofertaempleo`
--

CREATE TABLE `certificaciones_ofertaempleo` (
  `idcertificacion_ofertaempleo` int(11) NOT NULL,
  `certificacion` varchar(50) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `certificaciones_ofertaempleo`
--

INSERT INTO `certificaciones_ofertaempleo` (`idcertificacion_ofertaempleo`, `certificacion`, `idoferta_empleo`) VALUES
(12, 'Oracle', 57),
(13, 'Javascript', 57),
(14, 'Laravel', 58),
(15, 'PHP', 58),
(19, 'JAVA FX', 66),
(20, 'Oracle', 67),
(21, 'dsddd', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conocimientos_generales`
--

CREATE TABLE `conocimientos_generales` (
  `idconocimientos` int(11) NOT NULL,
  `conocimiento_general` varchar(30) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `conocimientos_generales`
--

INSERT INTO `conocimientos_generales` (`idconocimientos`, `conocimiento_general`, `idpostulante`) VALUES
(13, 'Ingles', 110),
(14, 'Ingles', 111),
(15, 'Frances', 111),
(16, 'Aleman', 111),
(17, 'Ingles', 112),
(18, 'Frances', 112),
(19, 'Italiano', 112),
(20, 'Ingles', 113),
(21, 'Frances', 113),
(22, 'Italiano', 113),
(23, 'Ingles', 125),
(24, 'Frances', 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades_ofertaempleo`
--

CREATE TABLE `especialidades_ofertaempleo` (
  `id_especialidadoe` int(11) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidades_ofertaempleo`
--

INSERT INTO `especialidades_ofertaempleo` (`id_especialidadoe`, `especialidad`, `idoferta_empleo`) VALUES
(28, 'Computacion', 57),
(29, 'Informatica', 57),
(30, 'Sistemas', 57),
(31, 'Computacion', 58),
(33, 'Computacion', 64),
(34, 'Informatica', 64),
(35, 'Sistemas', 64),
(54, 'Computacion', 66),
(55, 'Informatica', 66),
(56, 'Sistemas', 66),
(63, 'Computacion', 67),
(64, 'Informatica', 67),
(65, 'Sistemas', 67),
(66, 'Computacion', 67),
(67, 'Informatica', 67),
(68, 'Sistemas', 67),
(69, 'Computacion', 69),
(70, 'Informatica', 69),
(71, 'Sistemas', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacionespecifica`
--

CREATE TABLE `evaluacionespecifica` (
  `idevaluacion` int(11) NOT NULL,
  `idpostulante` int(11) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `puntaje` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluacionespecifica`
--

INSERT INTO `evaluacionespecifica` (`idevaluacion`, `idpostulante`, `idoferta_empleo`, `idcategoria`, `puntaje`) VALUES
(7, 110, 57, 1, 50),
(8, 111, 58, 1, 50),
(9, 112, 57, 1, 50),
(10, 113, 57, 1, 60),
(11, 112, 66, 1, 80),
(13, 114, 66, 1, 90),
(14, 125, 66, 2, 90);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluaciongeneral`
--

CREATE TABLE `evaluaciongeneral` (
  `idevaluacion` int(11) NOT NULL,
  `idpostulante` int(11) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL,
  `pB` int(3) NOT NULL,
  `pF` int(3) NOT NULL,
  `PDO` int(3) NOT NULL,
  `pUIX` int(3) NOT NULL,
  `pQA` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluaciongeneral`
--

INSERT INTO `evaluaciongeneral` (`idevaluacion`, `idpostulante`, `idoferta_empleo`, `pB`, `pF`, `PDO`, `pUIX`, `pQA`) VALUES
(29, 110, 57, 60, 40, 20, 20, 30),
(30, 111, 58, 60, 30, 20, 40, 30),
(31, 111, 57, 40, 40, 20, 30, 20),
(32, 112, 57, 50, 30, 0, 30, 30),
(33, 113, 57, 50, 30, 30, 20, 20),
(35, 113, 58, 40, 70, 50, 60, 20),
(40, 112, 66, 80, 40, 30, 0, 40),
(54, 114, 66, 90, 10, 20, 40, 10),
(55, 125, 66, 20, 100, 80, 30, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia_laboral`
--

CREATE TABLE `experiencia_laboral` (
  `idexperiencia_laboral` int(11) NOT NULL,
  `empresa` varchar(40) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  `ano_ingreso` int(11) NOT NULL,
  `ano_salida` int(11) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experiencia_laboral`
--

INSERT INTO `experiencia_laboral` (`idexperiencia_laboral`, `empresa`, `cargo`, `ano_ingreso`, `ano_salida`, `idpostulante`) VALUES
(14, 'Movistar', 'Full-Stack', 2010, 2017, 110),
(15, 'Movistar', 'Full-Stack', 1980, 2013, 111),
(16, 'Digitel CA', 'Backend', 2016, 2020, 111),
(17, 'sasas', 'Frontend', 2014, 2020, 112),
(18, 'sdddd', 'Full-Stack', 2013, 2013, 112),
(19, 'ssasa', 'QA', 2011, 2017, 113),
(20, 'dsdadss', 'Frontend', 2010, 2016, 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `filtrado_puntajes`
--

CREATE TABLE `filtrado_puntajes` (
  `idfiltrado_puntajes` int(11) NOT NULL,
  `pse` float NOT NULL,
  `psa` float NOT NULL,
  `pep` float NOT NULL,
  `total` float NOT NULL,
  `idoferta_empleo` int(11) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `filtrado_puntajes`
--

INSERT INTO `filtrado_puntajes` (`idfiltrado_puntajes`, `pse`, `psa`, `pep`, `total`, `idoferta_empleo`, `idpostulante`) VALUES
(17, 25, 4.5, 4, 11.1667, 57, 110),
(18, 25, 6.5, 5, 12.1667, 57, 111),
(19, 35, 6.5, 5, 15.5, 57, 112),
(20, 35, 6.5, 3, 14.8333, 58, 111),
(21, 30, 5.5, 3, 12.8333, 57, 113),
(22, 30, 5.5, 2, 12.5, 58, 113),
(23, 15, 6.5, 11, 10.8333, 66, 112),
(24, 100, 0, 0, 33.3333, 66, 114),
(25, 35, 3, 2, 13.3333, 66, 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramientas_manejadas`
--

CREATE TABLE `herramientas_manejadas` (
  `idherramientas` int(11) NOT NULL,
  `herramienta` varchar(30) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `herramientas_manejadas`
--

INSERT INTO `herramientas_manejadas` (`idherramientas`, `herramienta`, `idpostulante`) VALUES
(13, 'VS Code', 110),
(14, 'Android Studio', 110),
(15, 'VS Code', 111),
(16, 'Visual Studio', 111),
(17, 'Android Studio', 111),
(18, 'VS Code', 112),
(19, 'Visual Studio', 112),
(20, 'VS Code', 113),
(21, 'Visual Studio', 113),
(22, 'netbeans', 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramientas_ofertaempleo`
--

CREATE TABLE `herramientas_ofertaempleo` (
  `idherramienta_oferta` int(11) NOT NULL,
  `herramienta` varchar(40) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `herramientas_ofertaempleo`
--

INSERT INTO `herramientas_ofertaempleo` (`idherramienta_oferta`, `herramienta`, `idoferta_empleo`) VALUES
(10, 'VS Code', 57),
(11, 'Visual Studio', 57),
(12, 'VS Code', 58),
(13, 'Visual Studio', 58),
(19, 'NetBeans', 66),
(20, 'JAVA', 67),
(21, '69 Herramientas', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lenguajes`
--

CREATE TABLE `lenguajes` (
  `idlenguaje` int(11) NOT NULL,
  `nombrelenguaje` varchar(20) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lenguajes`
--

INSERT INTO `lenguajes` (`idlenguaje`, `nombrelenguaje`, `idpostulante`) VALUES
(12, 'C#', 110),
(13, 'Java', 110),
(14, 'Javascript', 110),
(15, 'C#', 111),
(16, 'Javascript', 111),
(17, 'Java', 111),
(18, 'Java', 112),
(19, 'C#', 112),
(20, 'Javascript', 112),
(21, 'Java', 113),
(22, 'C#', 113),
(23, 'PHP', 113),
(24, 'java', 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lenguajes_ofertaempleo`
--

CREATE TABLE `lenguajes_ofertaempleo` (
  `idlenguaje_oferta` int(11) NOT NULL,
  `nombrelenguaje` varchar(40) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lenguajes_ofertaempleo`
--

INSERT INTO `lenguajes_ofertaempleo` (`idlenguaje_oferta`, `nombrelenguaje`, `idoferta_empleo`) VALUES
(12, 'Javascript', 57),
(13, 'Java', 57),
(14, 'C#', 57),
(15, 'PHP', 58),
(16, 'Javascript', 58),
(20, 'Java', 66),
(21, 'C#', 67),
(22, 'sssdsd', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivelacademico`
--

CREATE TABLE `nivelacademico` (
  `idnivelacademico` int(11) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `idpostulante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nivelacademico`
--

INSERT INTO `nivelacademico` (`idnivelacademico`, `titulo`, `especialidad`, `idpostulante`) VALUES
(7, 'Bachiller', 'Computación', 110),
(8, 'Ingeniero', 'Computación', 111),
(9, 'Ingeniero', 'Computación', 112),
(10, 'Ingeniero', 'Computación', 113),
(11, 'Bachiller', 'Informatica', 114),
(12, 'Bachiller', 'Computación', 120),
(13, 'Licenciado', 'Sistemas', 124),
(14, 'Ingeniero', 'Computación', 125);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivelacademico_ofertaempleo`
--

CREATE TABLE `nivelacademico_ofertaempleo` (
  `idnc_ofertaempleo` int(11) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nivelacademico_ofertaempleo`
--

INSERT INTO `nivelacademico_ofertaempleo` (`idnc_ofertaempleo`, `titulo`, `idoferta_empleo`) VALUES
(50, 'Bachiller', 57),
(51, 'Licenciado', 57),
(52, 'Ingeniero', 57),
(53, 'Tecnico Superior', 57),
(54, 'Magister', 57),
(55, 'Doctor', 57),
(56, 'Ingeniero', 58),
(63, 'Bachiller', 64),
(64, 'Licenciado', 64),
(65, 'Ingeniero', 64),
(66, 'Tecnico Superior', 64),
(67, 'Magister', 64),
(68, 'Doctor', 64),
(69, 'Bachiller', 66),
(70, 'Licenciado', 66),
(71, 'Ingeniero', 66),
(72, 'Tecnico Superior', 66),
(73, 'Magister', 66),
(74, 'Doctor', 66),
(123, 'Bachiller', 67),
(124, 'Licenciado', 67),
(125, 'Ingeniero', 67),
(126, 'Tecnico Superior', 67),
(127, 'Magister', 67),
(128, 'Doctor', 67),
(135, 'Bachiller', 69),
(136, 'Licenciado', 69),
(137, 'Ingeniero', 69),
(138, 'Tecnico Superior', 69),
(139, 'Magister', 69),
(140, 'Doctor', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_empleo`
--

CREATE TABLE `oferta_empleo` (
  `idoferta_empleo` int(11) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `codcontrato` int(10) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `edadmin` int(11) NOT NULL,
  `edadmax` int(11) NOT NULL,
  `domicilio` varchar(20) NOT NULL,
  `modo` varchar(20) NOT NULL,
  `nacionalidad` varchar(100) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `correo` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oferta_empleo`
--

INSERT INTO `oferta_empleo` (`idoferta_empleo`, `empresa`, `codcontrato`, `sexo`, `edadmin`, `edadmax`, `domicilio`, `modo`, `nacionalidad`, `descripcion`, `correo`) VALUES
(57, 'Movistar LA', 3322332, 'Ambos', 18, 25, 'Nacional', 'Presencial', 'Venezuela', 'Desarrollo de Software en React JS', 'movistar_la@gmail.com'),
(58, 'Ubitcon', 223332, 'Femenino', 18, 25, 'Ambos', 'Ambos', 'Venezuela', 'Desarrollo de Software con Laravel', 'ubitcon@gmail.com'),
(64, 'Telecom', 211212, 'Ambos', 18, 33, 'Nacional', 'Presencial', 'Islas Vírgenes Británicas', 'App con Angular y .NET Core', 'telecom@telecom.net'),
(66, 'ClaroRD', 32233, 'Masculino', 18, 24, 'Internacional', 'Remoto', 'República Democrática del Congo', 'App Hibrida con Xamarin y ASP.NET', 'clarord@gmail.com'),
(67, 'AlticeCA', 3323232, 'Ambos', 18, 25, 'Ambos', 'Ambos', 'Venezuela', 'App Nativa Android con Android Studio', 'alticeca@gmail.com'),
(69, 'Disney Channel', 332323, 'Ambos', 18, 23, 'Ambos', 'Ambos', 'Venezuela', 'App Nativa en Swift para Dispositivos Apple', 'ddssddsd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `id` int(11) NOT NULL,
  `iso` char(2) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`id`, `iso`, `nombre`) VALUES
(1, 'AF', 'Afganistán'),
(2, 'AX', 'Islas Gland'),
(3, 'AL', 'Albania'),
(4, 'DE', 'Alemania'),
(5, 'AD', 'Andorra'),
(6, 'AO', 'Angola'),
(7, 'AI', 'Anguilla'),
(8, 'AQ', 'Antártida'),
(9, 'AG', 'Antigua y Barbuda'),
(10, 'AN', 'Antillas Holandesas'),
(11, 'SA', 'Arabia Saudí'),
(12, 'DZ', 'Argelia'),
(13, 'AR', 'Argentina'),
(14, 'AM', 'Armenia'),
(15, 'AW', 'Aruba'),
(16, 'AU', 'Australia'),
(17, 'AT', 'Austria'),
(18, 'AZ', 'Azerbaiyán'),
(19, 'BS', 'Bahamas'),
(20, 'BH', 'Bahréin'),
(21, 'BD', 'Bangladesh'),
(22, 'BB', 'Barbados'),
(23, 'BY', 'Bielorrusia'),
(24, 'BE', 'Bélgica'),
(25, 'BZ', 'Belice'),
(26, 'BJ', 'Benin'),
(27, 'BM', 'Bermudas'),
(28, 'BT', 'Bhután'),
(29, 'BO', 'Bolivia'),
(30, 'BA', 'Bosnia y Herzegovina'),
(31, 'BW', 'Botsuana'),
(32, 'BV', 'Isla Bouvet'),
(33, 'BR', 'Brasil'),
(34, 'BN', 'Brunéi'),
(35, 'BG', 'Bulgaria'),
(36, 'BF', 'Burkina Faso'),
(37, 'BI', 'Burundi'),
(38, 'CV', 'Cabo Verde'),
(39, 'KY', 'Islas Caimán'),
(40, 'KH', 'Camboya'),
(41, 'CM', 'Camerún'),
(42, 'CA', 'Canadá'),
(43, 'CF', 'República Centroafricana'),
(44, 'TD', 'Chad'),
(45, 'CZ', 'República Checa'),
(46, 'CL', 'Chile'),
(47, 'CN', 'China'),
(48, 'CY', 'Chipre'),
(49, 'CX', 'Isla de Navidad'),
(50, 'VA', 'Ciudad del Vaticano'),
(51, 'CC', 'Islas Cocos'),
(52, 'CO', 'Colombia'),
(53, 'KM', 'Comoras'),
(54, 'CD', 'República Democrática del Congo'),
(55, 'CG', 'Congo'),
(56, 'CK', 'Islas Cook'),
(57, 'KP', 'Corea del Norte'),
(58, 'KR', 'Corea del Sur'),
(59, 'CI', 'Costa de Marfil'),
(60, 'CR', 'Costa Rica'),
(61, 'HR', 'Croacia'),
(62, 'CU', 'Cuba'),
(63, 'DK', 'Dinamarca'),
(64, 'DM', 'Dominica'),
(65, 'DO', 'República Dominicana'),
(66, 'EC', 'Ecuador'),
(67, 'EG', 'Egipto'),
(68, 'SV', 'El Salvador'),
(69, 'AE', 'Emiratos Árabes Unidos'),
(70, 'ER', 'Eritrea'),
(71, 'SK', 'Eslovaquia'),
(72, 'SI', 'Eslovenia'),
(73, 'ES', 'España'),
(74, 'UM', 'Islas ultramarinas de Estados Unidos'),
(75, 'US', 'Estados Unidos'),
(76, 'EE', 'Estonia'),
(77, 'ET', 'Etiopía'),
(78, 'FO', 'Islas Feroe'),
(79, 'PH', 'Filipinas'),
(80, 'FI', 'Finlandia'),
(81, 'FJ', 'Fiyi'),
(82, 'FR', 'Francia'),
(83, 'GA', 'Gabón'),
(84, 'GM', 'Gambia'),
(85, 'GE', 'Georgia'),
(86, 'GS', 'Islas Georgias del Sur y Sandwich del Sur'),
(87, 'GH', 'Ghana'),
(88, 'GI', 'Gibraltar'),
(89, 'GD', 'Granada'),
(90, 'GR', 'Grecia'),
(91, 'GL', 'Groenlandia'),
(92, 'GP', 'Guadalupe'),
(93, 'GU', 'Guam'),
(94, 'GT', 'Guatemala'),
(95, 'GF', 'Guayana Francesa'),
(96, 'GN', 'Guinea'),
(97, 'GQ', 'Guinea Ecuatorial'),
(98, 'GW', 'Guinea-Bissau'),
(99, 'GY', 'Guyana'),
(100, 'HT', 'Haití'),
(101, 'HM', 'Islas Heard y McDonald'),
(102, 'HN', 'Honduras'),
(103, 'HK', 'Hong Kong'),
(104, 'HU', 'Hungría'),
(105, 'IN', 'India'),
(106, 'ID', 'Indonesia'),
(107, 'IR', 'Irán'),
(108, 'IQ', 'Iraq'),
(109, 'IE', 'Irlanda'),
(110, 'IS', 'Islandia'),
(111, 'IL', 'Israel'),
(112, 'IT', 'Italia'),
(113, 'JM', 'Jamaica'),
(114, 'JP', 'Japón'),
(115, 'JO', 'Jordania'),
(116, 'KZ', 'Kazajstán'),
(117, 'KE', 'Kenia'),
(118, 'KG', 'Kirguistán'),
(119, 'KI', 'Kiribati'),
(120, 'KW', 'Kuwait'),
(121, 'LA', 'Laos'),
(122, 'LS', 'Lesotho'),
(123, 'LV', 'Letonia'),
(124, 'LB', 'Líbano'),
(125, 'LR', 'Liberia'),
(126, 'LY', 'Libia'),
(127, 'LI', 'Liechtenstein'),
(128, 'LT', 'Lituania'),
(129, 'LU', 'Luxemburgo'),
(130, 'MO', 'Macao'),
(131, 'MK', 'ARY Macedonia'),
(132, 'MG', 'Madagascar'),
(133, 'MY', 'Malasia'),
(134, 'MW', 'Malawi'),
(135, 'MV', 'Maldivas'),
(136, 'ML', 'Malí'),
(137, 'MT', 'Malta'),
(138, 'FK', 'Islas Malvinas'),
(139, 'MP', 'Islas Marianas del Norte'),
(140, 'MA', 'Marruecos'),
(141, 'MH', 'Islas Marshall'),
(142, 'MQ', 'Martinica'),
(143, 'MU', 'Mauricio'),
(144, 'MR', 'Mauritania'),
(145, 'YT', 'Mayotte'),
(146, 'MX', 'México'),
(147, 'FM', 'Micronesia'),
(148, 'MD', 'Moldavia'),
(149, 'MC', 'Mónaco'),
(150, 'MN', 'Mongolia'),
(151, 'MS', 'Montserrat'),
(152, 'MZ', 'Mozambique'),
(153, 'MM', 'Myanmar'),
(154, 'NA', 'Namibia'),
(155, 'NR', 'Nauru'),
(156, 'NP', 'Nepal'),
(157, 'NI', 'Nicaragua'),
(158, 'NE', 'Níger'),
(159, 'NG', 'Nigeria'),
(160, 'NU', 'Niue'),
(161, 'NF', 'Isla Norfolk'),
(162, 'NO', 'Noruega'),
(163, 'NC', 'Nueva Caledonia'),
(164, 'NZ', 'Nueva Zelanda'),
(165, 'OM', 'Omán'),
(166, 'NL', 'Países Bajos'),
(167, 'PK', 'Pakistán'),
(168, 'PW', 'Palau'),
(169, 'PS', 'Palestina'),
(170, 'PA', 'Panamá'),
(171, 'PG', 'Papúa Nueva Guinea'),
(172, 'PY', 'Paraguay'),
(173, 'PE', 'Perú'),
(174, 'PN', 'Islas Pitcairn'),
(175, 'PF', 'Polinesia Francesa'),
(176, 'PL', 'Polonia'),
(177, 'PT', 'Portugal'),
(178, 'PR', 'Puerto Rico'),
(179, 'QA', 'Qatar'),
(180, 'GB', 'Reino Unido'),
(181, 'RE', 'Reunión'),
(182, 'RW', 'Ruanda'),
(183, 'RO', 'Rumania'),
(184, 'RU', 'Rusia'),
(185, 'EH', 'Sahara Occidental'),
(186, 'SB', 'Islas Salomón'),
(187, 'WS', 'Samoa'),
(188, 'AS', 'Samoa Americana'),
(189, 'KN', 'San Cristóbal y Nevis'),
(190, 'SM', 'San Marino'),
(191, 'PM', 'San Pedro y Miquelón'),
(192, 'VC', 'San Vicente y las Granadinas'),
(193, 'SH', 'Santa Helena'),
(194, 'LC', 'Santa Lucía'),
(195, 'ST', 'Santo Tomé y Príncipe'),
(196, 'SN', 'Senegal'),
(197, 'CS', 'Serbia y Montenegro'),
(198, 'SC', 'Seychelles'),
(199, 'SL', 'Sierra Leona'),
(200, 'SG', 'Singapur'),
(201, 'SY', 'Siria'),
(202, 'SO', 'Somalia'),
(203, 'LK', 'Sri Lanka'),
(204, 'SZ', 'Suazilandia'),
(205, 'ZA', 'Sudáfrica'),
(206, 'SD', 'Sudán'),
(207, 'SE', 'Suecia'),
(208, 'CH', 'Suiza'),
(209, 'SR', 'Surinam'),
(210, 'SJ', 'Svalbard y Jan Mayen'),
(211, 'TH', 'Tailandia'),
(212, 'TW', 'Taiwán'),
(213, 'TZ', 'Tanzania'),
(214, 'TJ', 'Tayikistán'),
(215, 'IO', 'Territorio Británico del Océano Índico'),
(216, 'TF', 'Territorios Australes Franceses'),
(217, 'TL', 'Timor Oriental'),
(218, 'TG', 'Togo'),
(219, 'TK', 'Tokelau'),
(220, 'TO', 'Tonga'),
(221, 'TT', 'Trinidad y Tobago'),
(222, 'TN', 'Túnez'),
(223, 'TC', 'Islas Turcas y Caicos'),
(224, 'TM', 'Turkmenistán'),
(225, 'TR', 'Turquía'),
(226, 'TV', 'Tuvalu'),
(227, 'UA', 'Ucrania'),
(228, 'UG', 'Uganda'),
(229, 'UY', 'Uruguay'),
(230, 'UZ', 'Uzbekistán'),
(231, 'VU', 'Vanuatu'),
(232, 'VE', 'Venezuela'),
(233, 'VN', 'Vietnam'),
(234, 'VG', 'Islas Vírgenes Británicas'),
(235, 'VI', 'Islas Vírgenes de los Estados Unidos'),
(236, 'WF', 'Wallis y Futuna'),
(237, 'YE', 'Yemen'),
(238, 'DJ', 'Yibuti'),
(239, 'ZM', 'Zambia'),
(240, 'ZW', 'Zimbabue');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `postulantes`
--

CREATE TABLE `postulantes` (
  `idpostulante` int(11) NOT NULL,
  `primernombre` varchar(20) NOT NULL,
  `segundonombre` varchar(20) NOT NULL,
  `primerapellido` varchar(20) NOT NULL,
  `segundoapellido` varchar(20) NOT NULL,
  `dni` int(15) NOT NULL,
  `edad` int(2) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `pais_origen` varchar(100) NOT NULL,
  `residencia` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `postulantes`
--

INSERT INTO `postulantes` (`idpostulante`, `primernombre`, `segundonombre`, `primerapellido`, `segundoapellido`, `dni`, `edad`, `sexo`, `pais_origen`, `residencia`, `telefono`, `correo`) VALUES
(110, 'Jesus', 'Nicolas', 'Gonzalez', 'Diaz', 23733841, 18, 'Masculino', 'Venezuela', 'Venezuela', '04140939380', 'jesusgonzalezd18@gmail.com'),
(111, 'Sabrina', 'Sofia', 'Carpenter', 'Lynn', 2399393, 18, 'Femenino', 'Venezuela', 'Venezuela', '04140939380', 'sabrinac@gmail.com'),
(112, 'Eduardo', 'Enrique', 'Lunar', 'Royero', 323223, 18, 'Masculino', 'Venezuela', 'Venezuela', '04243322332', 'eduardo_lunar@gmail.com'),
(113, 'Luisa', 'das', 'Ferreira', 'sasasa', 132132, 18, 'Femenino', 'Venezuela', 'Venezuela', '04163443422', 'luisafer@hotmail.com'),
(114, 'Jesus', 'Nicolas', 'Gonzalez', 'Diaz', 23733847, 18, 'Masculino', 'Venezuela', 'Venezuela', '04140939380', 'jesusgonzalez18@gmail.com'),
(120, 'Jose', 'Jose', 'Feliz', 'Rivas', 12121222, 18, 'Masculino', 'Venezuela', 'Venezuela', '33332', 'josefeliz@yahoo.com'),
(124, 'ssasa', 'sasasa', 'saass', 'sasas', 323232, 18, 'Femenino', 'Venezuela', 'Venezuela', '5445654', 'fdfddfdf@gmail.com'),
(125, 'dssdsd', 'dsds', 'sdd', 'sdsd', 34434343, 18, 'Masculino', 'Venezuela', 'Venezuela', '3323232', 'sddssdsd@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `idpregunta` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `dificultad` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL,
  `idrespuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`idpregunta`, `descripcion`, `dificultad`, `idcategoria`, `idrespuesta`) VALUES
(1, '¿Cuál de los siguientes Doctype es el que utilizarías para un documento HTML5?', 0, 2, 1),
(2, 'Selecciona el elemento en el cuál incluirías los links de la navegación primaria de un sitio:', 0, 2, 2),
(3, 'Si estuvieras maquetando un blog, en cuál de los siguientes elementos pondrías los links a archivo, categorías, íconos de redes sociales, links a artículos más populares, etc?', 0, 2, 3),
(4, '¿Cuál es el elemento HTML correcta para insertar un salto de línea?', 0, 2, 4),
(5, '¿Cuál es el HTML correcto para hacer una casilla de verificación?', 0, 2, 5),
(6, '¿Cuál es el HTML correcto para hacer un campo de entrada de texto?', 0, 2, 6),
(7, '¿Cuál es el HTML correcto para hacer una lista desplegable?', 0, 2, 7),
(8, '¿Cuál es el HTML correcto para crear un área de texto?', 0, 2, 8),
(9, '¿Cuál es el HTML correcto para insertar una imagen?', 0, 2, 9),
(10, '¿Cuál es el HTML correcto para referirse a una hoja de estilo externa?', 0, 2, 10),
(11, '¿Cómo puede abrir un enlace en una nueva pestaña / ventana del navegador?', 1, 2, 11),
(12, '¿Como se cambia el color de las viñetas?', 1, 2, 12),
(13, 'Como se puede representar una lista de informacion ordenada?', 1, 2, 13),
(14, 'Como se representa una lista de informacion no ordenada?', 1, 2, 14),
(15, 'Como se puede ignorar un texto por anotaciones?', 1, 2, 15),
(16, 'Como se representa una edicion para un texto agregado?', 1, 2, 16),
(17, 'Como se puede codificar un contexto de navegacion anidado?', 1, 2, 17),
(18, 'Como se pueden insertar aplicaciones externas?', 1, 2, 18),
(19, 'Como se puede colocar el titulo de una tabla?', 1, 2, 19),
(20, 'Como se representa un encabezado de tabla?', 1, 2, 20),
(21, 'Cual es la declaracion de inicio en XML?', 0, 4, 21),
(22, 'Como puedes declarar una etiqueta vacia en XML?', 0, 4, 22),
(23, 'Como se puede representar un atributo en un tag?', 0, 4, 23),
(24, 'Como se puede representar una cantidad en XML?', 0, 4, 24),
(25, 'Como se puede representar una cantidad con decimal en XML?', 0, 4, 25),
(26, 'Cual es la manera de representar un texto en XML?', 0, 4, 26),
(27, 'Como se codifica un tag dentro de otro tag con atributos en XML?', 0, 4, 27),
(28, 'Cual es la forma de representar un tag dentro de otro tag sin atributos?', 0, 4, 28),
(29, 'Cual es la manera de tener una cadena y una cantidad dentro de tags?', 0, 4, 29),
(30, 'Como se puede representar un tag dentro de otro que contenga una cadena y a su vez un atributo?', 0, 4, 30),
(31, 'En cual se las siguientes ejemplos XML hay 3 tags de textos?', 1, 4, 31),
(32, 'En cual de las siguientes XML contiene un atributo y un valor entero?', 1, 4, 32),
(33, 'En cual de las siguiente XML mostrara 2 textos y una fecha de calendario?', 1, 4, 33),
(34, 'Cual de estos XML mostrara 4 cadenas y una fecha de calendario?', 1, 4, 34),
(35, 'Cual de estos XML mostrara 3 textos o cadenas y una fecha?', 1, 4, 35),
(36, 'Cual de estos archivos XML contiene mas de 1 fecha de calendario y un atributo o tag?', 1, 4, 36),
(37, 'En cual de estos XML mostrara una fecha y la hora de China y Estados Unidos?', 1, 4, 37),
(38, 'En cual de estos XML se mostrara la hora de USA y algun atributo?', 1, 4, 38),
(39, 'Cual de estos XML muestra las 7\'s de la noche en los USA?', 1, 4, 39),
(40, 'Cual de estos XML mostrara las 12 en china y usa?', 1, 4, 40),
(41, 'Como se anade un intervalo de fecha para una BD MySQL>', 0, 1, 41),
(42, 'Con cual funcion de MySQL se anade un intervalo de hora en la base de datos en el backend?', 0, 1, 42),
(43, 'Con cual funcion en el backend se puede retornar la fecha actual de la base de datos?', 0, 1, 43),
(44, 'Con cual funcion retorna la hora mas reciente en la base de datos?', 0, 1, 44),
(45, 'Con cual funcion se puede obtener tanto la fecha como la hora en un sistema de bases de datos?', 0, 1, 45),
(46, 'Con cual funcion se puede extraer la fecha de una expresion DATETIME en la base de datos?', 0, 1, 46),
(47, 'Cual de las siguientes consultas retorna el numero de dias entre dos fechas?', 0, 1, 47),
(48, 'Cual de la siguientes consultas retorna el dia del mes dado por una fecha en particular?', 0, 1, 48),
(49, 'Cual de las siguientes consultas te devolvera el dia exacto del mes dado por una fecha?', 0, 1, 49),
(50, 'Con cual consulta se podra obtener el un formato especifico de la hora?', 0, 1, 50),
(51, 'Cual de estas consultas retorna el primer valor not null de una lista?', 1, 1, 51),
(52, 'Con cual de estas consultas se puede convertir un valor (cualquier tipo) a un tipo de dato en particular?', 1, 1, 52),
(53, 'Con cual de estas consultas verifica la condicion y retornara un valor cuando la primera condicion se cumpla?', 1, 1, 53),
(54, 'Cual de estas consultas remueve efectivamente los espacios en blanco de un string en la base de datos?', 1, 1, 54),
(55, 'De las siguientes consultas, con el se podra convertir un numero desde un sistema de base numerica a otro?', 1, 1, 55),
(56, 'Con cual consulta se puede convertir un valor a un especifico tipo de dato o caracter?', 1, 1, 56),
(57, 'Con cual de estas consultas se podra convertir un tipo de dato string a mayusculas?', 1, 1, 57),
(58, 'Con cual de estas consultas se podra convertir un valor de tipo String a minusculas?', 1, 1, 58),
(59, 'En estas consultas, cual de ellas retorna la posicion donde ocurre la primera ocurrencia de una subcadena dentro de otra?', 1, 1, 59),
(60, 'En dichas consultas, cual permite obtener la posicion de la primera ocurrencia de un string dentro de otro?', 1, 1, 60),
(61, 'Que es exactamente DevOps?', 0, 3, 61),
(62, '¿Cuál de las siguientes metodologías menos impacta el establecimiento de DevOps?', 0, 3, 62),
(63, 'En las organizaciones de TI típicas, ¿Cual es el conflicto típico entre los equipos de desarrollo y operaciones?', 0, 3, 63),
(64, 'Cual de las siguientes opciones hace que DevOps sea exitoso para desarrollar y entregar software?', 0, 3, 64),
(65, 'Cual de las siguientes opciones sobre DevOps es incorrecta?', 0, 3, 65),
(66, 'Que caracteriza a una organizacion DevOps durante su trabajo?', 0, 3, 66),
(67, 'En una organización DevOps, ¿cuál de las siguientes opciones no contribuye directamente a su flujo de valor?', 0, 3, 67),
(68, '¿Cuál de los siguientes no es uno de los principios de DevOps para una buena automatización de pruebas?', 0, 3, 68),
(69, '¿Cuál de las siguientes opciones no se realizan en código DevOps en sus sistemas de producción?', 0, 3, 69),
(70, '¿Cuál de las siguientes opciones es una técnica para convertir los cambios normales a estándar?', 0, 3, 70),
(71, '¿Cuál es un activo reutilizable ampliamente utilizado para reforzar la seguridad de la información en DevOps?', 1, 3, 71),
(72, 'En que se basa o fundamenta la telemetria?', 1, 3, 72),
(73, 'Qué es troncal en la entrega DevOps?', 1, 3, 73),
(74, 'En que se basa la \"Automatizacion de Pruebas\"?', 1, 3, 74),
(75, 'En que se fundamenta la tecnologia \"Memcached\"?', 1, 3, 75),
(76, 'Que proporciona Selenium como herramienta?', 1, 3, 76),
(77, 'Que ofrece la tecnologia Branching para DevOps?', 1, 3, 77),
(78, 'Que brinda el servidor Jenkins para DevOps?', 1, 3, 78),
(79, 'Que ofrece la Integracion Continua para DevOps?', 1, 3, 79),
(80, 'Que ofrece Component-Based-Development (CBD) para DevOps?', 1, 3, 80),
(81, 'En que se encuentra basado el desarrollo QA?', 0, 5, 81),
(82, 'Que proporcionan para el desarrollo las pruebas de software?', 0, 5, 82),
(83, 'En que se fundamenta la tecnologia Tesware en QA?', 0, 5, 83),
(84, 'Que provee exactamente la \"Compilacion\" en QA?', 0, 5, 84),
(85, 'Cual de las siguientes opciones es el fundamento del equipo QA durante las pruebas?', 0, 5, 85),
(86, 'En el desarrollo QA, en que se basa la fuga de errores?', 0, 5, 86),
(87, 'Que brinda la liberacion de errores en el desarrollo QA?', 0, 5, 87),
(88, 'En el desarrollo QA, que proporciona exactamente las pruebas basadas en datos?', 0, 5, 88),
(89, 'Que ofrece para el desarrollo QA la estrategia de prueba?', 0, 5, 89),
(90, 'Que brinda en el desarrollo QA la prueba de branches?', 0, 5, 90),
(91, 'En el desarrollo QA, que ofrecen las pruebas agiles?', 1, 5, 91),
(92, 'En que se fundamenta la auditoria de calidad durante el desarrollo QA?', 1, 5, 92),
(93, 'Que ofrecen para el desarrollo QA las pruebas de hilo?', 1, 5, 93),
(94, 'De que trata la prueba Ad Hoc en el desarrollo de calidad?', 1, 5, 94),
(95, 'Cual de las siguientes opciones se basa el Test Metric en QA?', 1, 5, 95),
(96, 'Para que sirve la matriz de trazabilidad en el desarrollo QA?', 1, 5, 96),
(97, 'Que se desea obtener cuando se realiza o lleva a cabo una prueba de regresion en QA?', 1, 5, 97),
(98, 'En que se basa MR en el desarrollo QA?', 1, 5, 98),
(99, 'Que permite obtener la clasificacion de errores en el desarrollo de calidad?', 1, 5, 99),
(100, 'Que permite obtener una prueba de volumen durante el desarrollo QA?', 1, 5, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos_ofertaempleo`
--

CREATE TABLE `proyectos_ofertaempleo` (
  `idproyecto` int(11) NOT NULL,
  `categoria` varchar(20) NOT NULL,
  `idoferta_empleo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proyectos_ofertaempleo`
--

INSERT INTO `proyectos_ofertaempleo` (`idproyecto`, `categoria`, `idoferta_empleo`) VALUES
(122, 'Backend', 57),
(123, 'Frontend', 57),
(124, 'UIX', 57),
(125, 'DevOps', 57),
(126, 'QA', 57),
(127, 'Backend', 58),
(128, 'Frontend', 58),
(129, 'UIX', 58),
(130, 'DevOps', 58),
(131, 'QA', 58),
(137, 'Backend', 64),
(138, 'Frontend', 64),
(139, 'UIX', 64),
(140, 'DevOps', 64),
(141, 'Q/A', 64),
(142, 'Backend', 66),
(143, 'Frontend', 66),
(144, 'UIX', 66),
(145, 'DevOps', 66),
(146, 'Q/A', 66),
(187, 'Backend', 67),
(188, 'Frontend', 67),
(189, 'UIX', 67),
(190, 'DevOps', 67),
(191, 'Q/A', 67),
(192, 'Backend', 67),
(193, 'Frontend', 67),
(194, 'UIX', 67),
(195, 'DevOps', 67),
(196, 'Q/A', 67),
(197, 'Backend', 69),
(198, 'Frontend', 69),
(199, 'UIX', 69),
(200, 'DevOps', 69),
(201, 'Q/A', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `idrespuesta` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `dificultad` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`idrespuesta`, `descripcion`, `dificultad`, `idcategoria`) VALUES
(1, '<!doctype html>', 0, 2),
(2, '<nav></nav>', 0, 2),
(3, '<section></section>', 0, 2),
(4, '<br></br>', 0, 2),
(5, '<input type=\"checkbox\">', 0, 2),
(6, '<input type=\"text\">', 0, 2),
(7, '<input type=\"dropdown\">', 0, 2),
(8, '<input type=\"textarea\">', 0, 2),
(9, '<img src=\"image.jpg\" alt=\"MyImage\">', 0, 2),
(10, '<style src=\"mystyle.css\"', 0, 2),
(11, '<a href=\"url\" target=\"_blank\">', 1, 2),
(12, '<li><font><li>', 1, 2),
(13, '<ol></ol>', 1, 2),
(14, '<ul></ul>', 1, 2),
(15, '<rp></rp>', 1, 2),
(16, '<ins></ins>', 1, 2),
(17, '<iframe></iframe>', 1, 2),
(18, '<embed></embed>', 1, 2),
(19, '<caption></caption>', 1, 2),
(20, '<thead><thead>', 1, 2),
(21, '<?xml version=\"1.0\"/>', 0, 4),
(22, '<name> </name>', 0, 4),
(23, '<book categoria=\"web\">', 0, 4),
(24, '<year>2005</year>', 0, 4),
(25, '<value> 39.95 </value>', 0, 4),
(26, '<author> Erik T. Ray </author>', 0, 4),
(27, '<movie category=\"horror\"><title>saw</title></movie>', 0, 4),
(28, '<movie><title>harry potter</title></movie>', 0, 4),
(29, '<book><author>Erik T. Ray</author><price>39.95</price></book>', 0, 4),
(30, '<book attrib=\"web\"><title>Learning</title></book>', 0, 4),
(31, '<note><to>Tove</to><from>Jani</from><body>Don\'t forget me this weekend!</body></note>', 1, 4),
(32, '<note thing=\"thing\">\r\n  <to>Tove</to>\r\n  <from>2.500</from>\r\n  <body>Don\'t forget me this weekend!</body>\r\n</note>', 1, 4),
(33, '<note>\r\n  <date>2018-01-10</date>\r\n  <to>Tove</to>\r\n  <from>Jani</from>\r\n  <heading>2.500</heading>\r\n  <body>Don\'t forget me this weekend!</body>\r\n</note>', 1, 4),
(34, '<note><date>2008-01-10</date><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don\'t forget me this weekend</body></note>', 1, 4),
(35, '<note><date>2008-01-10</date><from>Jani</from><heading>Reminder</heading><body>Don\'t forget me this weekend</body></note>', 1, 4),
(36, '<note id=\"thing\">\r\n  <date>2008-01-10</date>\r\n  <to>Tove</to>\r\n  <from>Jani</from>\r\n  <heading>Reminder</heading>\r\n  <body>2020-01</body>\r\n</note>', 1, 4),
(37, '<note>\r\n  <date>2008-01-10</date>\r\n  <to>Tove</to>\r\n  <us>00:39:00</us>\r\n  <heading>Reminder</heading>\r\n  <ch>19:30:43</ch>\r\n</note>', 1, 4),
(38, '<note id=\"global\">\r\n  <date>2008-01-10</date>\r\n  <to>Tove</to>\r\n  <from>Jani</from>\r\n  <us>19:00:01</us>\r\n  <body>Don\'t forget me this weekend!</body>\r\n</note>', 1, 4),
(39, '<note>\r\n  <date>2008-01-10</date>\r\n  <to>Tove</to>\r\n  <from>Jani</from>\r\n  <us>19:00:31</us>\r\n  <eu>Don\'t forget me this weekend!19:59</eu>\r\n</note>', 1, 4),
(40, '<note><date>2008-01-10</date><to>Tove</to><from>Jani</from><ch>00:00</ch><us>Don\'t forget me this weekend!00:49</us></note>', 1, 4),
(41, 'ADDDATE();', 0, 1),
(42, 'ADDTIME();', 0, 1),
(43, 'CURRENT_DATE();', 0, 1),
(44, 'CURRENT_TIME();', 0, 1),
(45, 'CURRENT_TIMESTAMP();', 0, 1),
(46, 'DATE();', 0, 1),
(47, 'DATEDIFF();', 0, 1),
(48, 'DAY();', 0, 1),
(49, 'DAYOFMONTH();', 0, 1),
(50, 'TIME_FORMAT();', 0, 1),
(51, 'COALESCE();', 1, 1),
(52, 'CAST();', 1, 1),
(53, 'CASE();', 1, 1),
(54, 'TRIM();', 1, 1),
(55, 'CONV();', 1, 1),
(56, 'CONVERT();', 1, 1),
(57, 'UCASE();', 1, 1),
(58, 'LOWER();', 1, 1),
(59, 'LOCATE()', 1, 1),
(60, 'INSTR', 1, 1),
(61, 'Metodologia de Desarrollo de Software', 0, 3),
(62, 'Entrega de Software en Cascada', 0, 3),
(63, 'Objetivos y Prioridades Comerciales', 0, 3),
(64, 'Software de Calidad y Monitoreo', 0, 3),
(65, 'Para Empresas de Nueva Creacion', 0, 3),
(66, 'Financiamiento de Productos y Servicios', 0, 3),
(67, 'Errores, incidentes y Correcciones', 0, 3),
(68, 'Mezcla del Desarrollo Impulsado por Pruebas y Enfoque Automatizado', 0, 3),
(69, 'Big Bang de Versiones Probadas', 0, 3),
(70, 'Historial de Implementaciones Automatizadas', 0, 3),
(71, 'Transferencia de Datos (Clientes y Software)', 1, 3),
(72, 'Registro del Comportamiento del Sistema', 1, 3),
(73, 'Colaboracion en Unica Rama de Codigo', 1, 3),
(74, 'Evaluacion y Operacionalizacion', 1, 3),
(75, 'Almacenamiento de Objetos en Cache', 1, 3),
(76, 'Pruebas Distribuidas Gratuitas', 1, 3),
(77, 'Clonacion y Derivaciones', 1, 3),
(78, 'Automatizacion del Proceso de Desarrollo', 1, 3),
(79, 'Automatizacion y Productividad', 1, 3),
(80, 'Aproximacion al Desarrollo', 1, 3),
(81, 'Monitorizacion de Calidad ', 0, 5),
(82, 'Garantizacion de Funcionalidad', 0, 5),
(83, 'Planeacion de Pruebas', 0, 5),
(84, 'Numeracion de Software Instalable', 0, 5),
(85, 'Adaptabilidad y Automatizacion', 0, 5),
(86, 'Descubrimiento del Error en Clientes', 0, 5),
(87, 'Defectos Presentes en Versiones', 0, 5),
(88, 'Evaluacion de Automatizacion', 0, 5),
(89, 'Herramientas y Planificacion de Pruebas', 0, 5),
(90, 'Evaluacion Total de Ramas', 0, 5),
(91, 'Evaluacion de Metodologia', 1, 5),
(92, 'Efectividad de Procedimientos de Control', 1, 5),
(93, 'Evaluacion de Subprocesos', 1, 5),
(94, 'Rompimiento del sistema funcional', 1, 5),
(95, 'Evaluacion de Medicion de Prueba', 1, 5),
(96, 'Asignacion de Scripts de Prueba', 1, 5),
(97, 'Impacto Funcional de Correccion de Defectos', 1, 5),
(98, 'Informe de Defectos', 1, 5),
(99, 'Garantizacion de Integridad', 1, 5),
(100, 'Verificacion del Sistema', 1, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Indices de la tabla `certificaciones`
--
ALTER TABLE `certificaciones`
  ADD PRIMARY KEY (`idcertificacion`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `certificaciones_ofertaempleo`
--
ALTER TABLE `certificaciones_ofertaempleo`
  ADD PRIMARY KEY (`idcertificacion_ofertaempleo`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `conocimientos_generales`
--
ALTER TABLE `conocimientos_generales`
  ADD PRIMARY KEY (`idconocimientos`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `especialidades_ofertaempleo`
--
ALTER TABLE `especialidades_ofertaempleo`
  ADD PRIMARY KEY (`id_especialidadoe`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `evaluacionespecifica`
--
ALTER TABLE `evaluacionespecifica`
  ADD PRIMARY KEY (`idevaluacion`),
  ADD KEY `idpostulante` (`idpostulante`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`),
  ADD KEY `idcategoria` (`idcategoria`);

--
-- Indices de la tabla `evaluaciongeneral`
--
ALTER TABLE `evaluaciongeneral`
  ADD PRIMARY KEY (`idevaluacion`),
  ADD KEY `idpostulante` (`idpostulante`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `experiencia_laboral`
--
ALTER TABLE `experiencia_laboral`
  ADD PRIMARY KEY (`idexperiencia_laboral`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `filtrado_puntajes`
--
ALTER TABLE `filtrado_puntajes`
  ADD PRIMARY KEY (`idfiltrado_puntajes`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `herramientas_manejadas`
--
ALTER TABLE `herramientas_manejadas`
  ADD PRIMARY KEY (`idherramientas`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `herramientas_ofertaempleo`
--
ALTER TABLE `herramientas_ofertaempleo`
  ADD PRIMARY KEY (`idherramienta_oferta`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `lenguajes`
--
ALTER TABLE `lenguajes`
  ADD PRIMARY KEY (`idlenguaje`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `lenguajes_ofertaempleo`
--
ALTER TABLE `lenguajes_ofertaempleo`
  ADD PRIMARY KEY (`idlenguaje_oferta`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `nivelacademico`
--
ALTER TABLE `nivelacademico`
  ADD PRIMARY KEY (`idnivelacademico`),
  ADD KEY `idpostulante` (`idpostulante`);

--
-- Indices de la tabla `nivelacademico_ofertaempleo`
--
ALTER TABLE `nivelacademico_ofertaempleo`
  ADD PRIMARY KEY (`idnc_ofertaempleo`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `oferta_empleo`
--
ALTER TABLE `oferta_empleo`
  ADD PRIMARY KEY (`idoferta_empleo`),
  ADD UNIQUE KEY `codcontrato` (`codcontrato`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `postulantes`
--
ALTER TABLE `postulantes`
  ADD PRIMARY KEY (`idpostulante`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`idpregunta`),
  ADD KEY `idcategoria` (`idcategoria`),
  ADD KEY `idrespuesta` (`idrespuesta`);

--
-- Indices de la tabla `proyectos_ofertaempleo`
--
ALTER TABLE `proyectos_ofertaempleo`
  ADD PRIMARY KEY (`idproyecto`),
  ADD KEY `idoferta_empleo` (`idoferta_empleo`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`idrespuesta`),
  ADD KEY `idcategoria` (`idcategoria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `certificaciones`
--
ALTER TABLE `certificaciones`
  MODIFY `idcertificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `certificaciones_ofertaempleo`
--
ALTER TABLE `certificaciones_ofertaempleo`
  MODIFY `idcertificacion_ofertaempleo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `conocimientos_generales`
--
ALTER TABLE `conocimientos_generales`
  MODIFY `idconocimientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `especialidades_ofertaempleo`
--
ALTER TABLE `especialidades_ofertaempleo`
  MODIFY `id_especialidadoe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT de la tabla `evaluacionespecifica`
--
ALTER TABLE `evaluacionespecifica`
  MODIFY `idevaluacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `evaluaciongeneral`
--
ALTER TABLE `evaluaciongeneral`
  MODIFY `idevaluacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `experiencia_laboral`
--
ALTER TABLE `experiencia_laboral`
  MODIFY `idexperiencia_laboral` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `filtrado_puntajes`
--
ALTER TABLE `filtrado_puntajes`
  MODIFY `idfiltrado_puntajes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `herramientas_manejadas`
--
ALTER TABLE `herramientas_manejadas`
  MODIFY `idherramientas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `herramientas_ofertaempleo`
--
ALTER TABLE `herramientas_ofertaempleo`
  MODIFY `idherramienta_oferta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `lenguajes`
--
ALTER TABLE `lenguajes`
  MODIFY `idlenguaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `lenguajes_ofertaempleo`
--
ALTER TABLE `lenguajes_ofertaempleo`
  MODIFY `idlenguaje_oferta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `nivelacademico`
--
ALTER TABLE `nivelacademico`
  MODIFY `idnivelacademico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `nivelacademico_ofertaempleo`
--
ALTER TABLE `nivelacademico_ofertaempleo`
  MODIFY `idnc_ofertaempleo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;

--
-- AUTO_INCREMENT de la tabla `oferta_empleo`
--
ALTER TABLE `oferta_empleo`
  MODIFY `idoferta_empleo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `paises`
--
ALTER TABLE `paises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=241;

--
-- AUTO_INCREMENT de la tabla `postulantes`
--
ALTER TABLE `postulantes`
  MODIFY `idpostulante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=127;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `idpregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `proyectos_ofertaempleo`
--
ALTER TABLE `proyectos_ofertaempleo`
  MODIFY `idproyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `idrespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `certificaciones`
--
ALTER TABLE `certificaciones`
  ADD CONSTRAINT `certificaciones_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `certificaciones_ofertaempleo`
--
ALTER TABLE `certificaciones_ofertaempleo`
  ADD CONSTRAINT `certificaciones_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `conocimientos_generales`
--
ALTER TABLE `conocimientos_generales`
  ADD CONSTRAINT `conocimientos_generales_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `especialidades_ofertaempleo`
--
ALTER TABLE `especialidades_ofertaempleo`
  ADD CONSTRAINT `especialidades_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `evaluacionespecifica`
--
ALTER TABLE `evaluacionespecifica`
  ADD CONSTRAINT `evaluacionespecifica_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`),
  ADD CONSTRAINT `evaluacionespecifica_ibfk_2` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`),
  ADD CONSTRAINT `evaluacionespecifica_ibfk_3` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`);

--
-- Filtros para la tabla `evaluaciongeneral`
--
ALTER TABLE `evaluaciongeneral`
  ADD CONSTRAINT `evaluaciongeneral_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`),
  ADD CONSTRAINT `evaluaciongeneral_ibfk_2` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `experiencia_laboral`
--
ALTER TABLE `experiencia_laboral`
  ADD CONSTRAINT `experiencia_laboral_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `filtrado_puntajes`
--
ALTER TABLE `filtrado_puntajes`
  ADD CONSTRAINT `filtrado_puntajes_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`),
  ADD CONSTRAINT `filtrado_puntajes_ibfk_2` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `herramientas_manejadas`
--
ALTER TABLE `herramientas_manejadas`
  ADD CONSTRAINT `herramientas_manejadas_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `herramientas_ofertaempleo`
--
ALTER TABLE `herramientas_ofertaempleo`
  ADD CONSTRAINT `herramientas_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `lenguajes`
--
ALTER TABLE `lenguajes`
  ADD CONSTRAINT `lenguajes_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `lenguajes_ofertaempleo`
--
ALTER TABLE `lenguajes_ofertaempleo`
  ADD CONSTRAINT `lenguajes_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `nivelacademico`
--
ALTER TABLE `nivelacademico`
  ADD CONSTRAINT `nivelacademico_ibfk_1` FOREIGN KEY (`idpostulante`) REFERENCES `postulantes` (`idpostulante`);

--
-- Filtros para la tabla `nivelacademico_ofertaempleo`
--
ALTER TABLE `nivelacademico_ofertaempleo`
  ADD CONSTRAINT `nivelacademico_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`),
  ADD CONSTRAINT `preguntas_ibfk_2` FOREIGN KEY (`idrespuesta`) REFERENCES `respuestas` (`idrespuesta`);

--
-- Filtros para la tabla `proyectos_ofertaempleo`
--
ALTER TABLE `proyectos_ofertaempleo`
  ADD CONSTRAINT `proyectos_ofertaempleo_ibfk_1` FOREIGN KEY (`idoferta_empleo`) REFERENCES `oferta_empleo` (`idoferta_empleo`);

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
