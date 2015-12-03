delimiter $$

CREATE DATABASE `bd_motos` /*!40100 DEFAULT CHARACTER SET utf8 */$$
delimiter $$

CREATE TABLE `tb_proveedor` (
  `IdProveedor` int(11) NOT NULL,
  `Proveedor` varchar(100) DEFAULT NULL,
  `Direccion` varchar(150) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_cliente` (
  `IdCliente` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Fec_Nac` datetime DEFAULT NULL,
  `Tipo_Doc` varchar(45) NOT NULL,
  `Num_Doc` varchar(12) NOT NULL,
  `Direccion` varchar(150) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_empleado` (
  `IdEmpleado` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Cargo` varchar(100) NOT NULL,
  PRIMARY KEY (`IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_usuario` (
  `IdUsuario` int(11) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  KEY `IdEmpleado` (`IdEmpleado`),
  KEY `IdCliente` (`IdCliente`),
  CONSTRAINT `IdEmpleado` FOREIGN KEY (`IdEmpleado`) REFERENCES `tb_empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IdCliente` FOREIGN KEY (`IdCliente`) REFERENCES `tb_cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_producto` (
  `IdProducto` int(11) NOT NULL,
  `IdProveedor` int(11) NOT NULL,
  `Proveedor` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Precio` decimal(12,2) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `IdProveedor` (`IdProveedor`),
  CONSTRAINT `IdProveedor` FOREIGN KEY (`IdProveedor`) REFERENCES `tb_proveedor` (`IdProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_comentario` (
  `IdComentario` int(11) NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `Descripcion` varchar(150) NOT NULL,
  `Puntuacion` int(11) DEFAULT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  PRIMARY KEY (`IdComentario`),
  KEY `comentarioxCliente` (`IdCliente`),
  KEY `comentarioxProducto` (`IdProducto`),
  CONSTRAINT `comentarioxCliente` FOREIGN KEY (`IdCliente`) REFERENCES `tb_cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comentarioxProducto` FOREIGN KEY (`IdProducto`) REFERENCES `tb_producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_categoria` (
  `IdCategoria` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Nombre` varchar(150) DEFAULT NULL,
  `Descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `IdProducto` FOREIGN KEY (`IdProducto`) REFERENCES `tb_producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_venta` (
  `IdVenta` int(11) NOT NULL,
  `Fecha` datetime NOT NULL,
  `IGV` decimal(12,2) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`IdVenta`),
  KEY `Empleado_Relacion` (`IdEmpleado`),
  KEY `Cliente_Relacion` (`IdCliente`),
  CONSTRAINT `Empleado_Relacion` FOREIGN KEY (`IdEmpleado`) REFERENCES `tb_empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Cliente_Relacion` FOREIGN KEY (`IdCliente`) REFERENCES `tb_cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tb_detalleventa` (
  `IdDetalleVenta` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio_Unitario` decimal(12,2) NOT NULL,
  `Total` decimal(12,2) NOT NULL,
  `IdVenta` int(11) NOT NULL,
  PRIMARY KEY (`IdDetalleVenta`),
  KEY `detallexVenta` (`IdVenta`),
  CONSTRAINT `detallexVenta` FOREIGN KEY (`IdVenta`) REFERENCES `tb_venta` (`IdVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$



