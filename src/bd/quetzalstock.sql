CREATE DATABASE quetzalstock;

USE quetzalstock;

CREATE TABLE empleados(
	rfc CHAR(13) PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	ape_p VARCHAR(25) NOT NULL,
	ape_m VARCHAR(25) NOT NULL,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_ext TINYINT(3) NOT NULL,
	no_int TINYINT(2) NULL,
	cp CHAR(5) NOT NULL, 
	telefono VARCHAR(12) NOT NULL,
	correo VARCHAR(40) NULL,
	genero ENUM('F','M'),
	fecha_nac DATE NOT NULL);

CREATE TABLE catalogo(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	codigo_barras INT UNSIGNED NULL,
                  nombre  VARCHAR(25) NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	iva ENUM('SI','NO') NOT NULL,
	precio DOUBLE UNSIGNED NOT NULL,
                 precio_mayoreo DOUBLE UNSIGNED NULL, 
	unidad ENUM('KILOS','LITROS','METRO LINEAL','PIEZAS') NOT NULL,
	existencia DOUBLE UNSIGNED NOT NULL);

CREATE TABLE clientes(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(25) NOT NULL DEFAULT ('PUNTO-VENTA'),
	ape_p VARCHAR(25) NOT NULL,
	ape_m VARCHAR(25) NULL,
	telefono VARCHAR(12) NOT NULL,
	rfc CHAR(13) NOT NULL,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_ext TINYINT(3) NOT NULL,
	no_int TINYINT(2) NULL,
	cp CHAR(5) NOT NULL, 
	no_compras  TINYINT UNSIGNED DEFAULT '0');

CREATE TABLE sucursal(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_ext TINYINT(3) NOT NULL,
	no_int TINYINT(2) NULL,
	cp CHAR(5) NOT NULL, 
	telefono VARCHAR(12) NULL);

CREATE USER 'quetzal'@'localhost' IDENTIFIED BY 'quetzal.2018';
GRANT ALL PRIVILEGES ON quetzalstock.* TO 'quetzal'@'localhost';
FLUSH PRIVILEGES;