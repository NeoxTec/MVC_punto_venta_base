CREATE DATABASE quetzalstock;

USE quetzalstock;

CREATE TABLE IF NOT EXISTS empleado(
	rfc CHAR(13) PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	ape_p VARCHAR(25) NOT NULL,
	ape_m VARCHAR(25) NOT NULL,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_exterior INT(3) NOT NULL,
	no_interior INT(2) NULL,
	cp CHAR(5) NOT NULL, 
	telefono VARCHAR(12) NOT NULL,
	correo VARCHAR(40) NULL,
	genero ENUM('F','M'),
	fecha_nac DATE NOT NULL);
    
CREATE TABLE IF NOT EXISTS usuario(
	username CHAR(7) PRIMARY KEY,
    pass VARCHAR(50) NOT NULL,
    tipo ENUM('VENDEDOR','ADMIN') NOT NULL,
    validacion TINYINT(4) NOT NULL,
    id_sucursal TINYINT(2) UNSIGNED NOT NULL,
    rfc_e CHAR(13) NOT NULL,
    FOREIGN KEY (rfc_e) REFERENCES empleado(rfc));

CREATE TABLE IF NOT EXISTS cliente(
	id SMALLINT(3) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(25) NOT NULL DEFAULT 'PUNTO-VENTA',
	ape_p VARCHAR(25) NOT NULL,
	ape_m VARCHAR(25) NULL,
	telefono VARCHAR(12) NOT NULL,
	genero ENUM('F','M'),
	correo VARCHAR(40) NULL,
	rfc CHAR(13) NULL,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_exterior SMALLINT(3) NOT NULL,
	no_interior TINYINT(2) NULL,
	cp CHAR(5) NOT NULL, 
	no_compras  TINYINT UNSIGNED DEFAULT '0');

CREATE TABLE IF NOT EXISTS sucursal(
	id TINYINT(2) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	calle VARCHAR(25) NOT NULL,
	colonia VARCHAR(25) NOT NULL,
	no_exterior SMALLINT(3) NOT NULL,
	no_interior TINYINT(2) NULL,
	cp CHAR(5) NOT NULL, 
	telefono VARCHAR(12) NULL);

CREATE TABLE IF NOT EXISTS catalogo(
	id SMALLINT(4) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	codigo_barras INT UNSIGNED NULL,
	nombre  VARCHAR(80) NOT NULL,
	descripcion LONGTEXT NOT NULL,
	iva ENUM('SI','NO') NOT NULL,
	precio DOUBLE UNSIGNED NOT NULL,
	precio_mayoreo DOUBLE UNSIGNED NULL, 
	unidad ENUM('KILOS','LITROS','METRO LINEAL','PIEZAS') NOT NULL);

CREATE TABLE IF NOT EXISTS inventario(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    id_producto SMALLINT UNSIGNED NOT NULL,
    id_sucursal TINYINT(2) UNSIGNED NOT NULL,
    existencias DOUBLE UNSIGNED DEFAULT 0.0,
    descuentos INT UNSIGNED NULL,
    FOREIGN KEY (id_producto) REFERENCES catalogo(id),
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id));
    
CREATE TABLE IF NOT EXISTS venta(
	id MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    username CHAR(7) NOT NULL,
    id_cliente SMALLINT ZEROFILL UNSIGNED,
    id_inventario INT UNSIGNED NOT NULL,
    tipo_pago ENUM('EFECTIVO','CREDITO','DEBITO','OTRO') NOT NULL,
    fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    id_sucursal TINYINT(2) UNSIGNED NOT NULL,
    FOREIGN KEY (username) REFERENCES usuario(username),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_inventario) REFERENCES inventario(id));
    
CREATE TABLE IF NOT EXISTS detalle_venta(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    id_venta MEDIUMINT UNSIGNED NOT NULL,
    descuento INT UNSIGNED NOT NULL DEFAULT 0,
    cantidad DOUBLE UNSIGNED NOT NULL,
    subtotal DOUBLE UNSIGNED NOT NULL,
    total DOUBLE UNSIGNED NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES venta(id));

CREATE TABLE IF NOT EXISTS corte(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    fecha DATE  NOT NULL,
    id_sucursal TINYINT(2) UNSIGNED NOT NULL,
    total DOUBLE UNSIGNED NOT NULL,
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id));

CREATE TABLE IF NOT EXISTS proveedor(
	rfc CHAR(13) PRIMARY KEY,
    razons VARCHAR(75) NOT NULL,
    calle VARCHAR(25) NULL,
    colonia VARCHAR(25) NULL,
    no_exterior SMALLINT(3) UNSIGNED NULL,
    cp CHAR(5) NULL,
    telefono VARCHAR(12) NOT NULL,
    correo VARCHAR(40) NOT NULL);    

CREATE TABLE IF NOT EXISTS compra(
	no_factura VARCHAR(20) PRIMARY KEY,
    id_sucursal TINYINT(2) UNSIGNED NOT NULL,
    rfc_proveedor CHAR(13) NOT NULL,
    fecha DATE NOT NULL,
    forma_pago ENUM('EFECTIVO','CREDITO','DEBITO','OTRO') NOT NULL,
    total DOUBLE UNSIGNED NOT NULL,
    estado_factura ENUM('FISICA','CORREO','PENDIENTE') NOT NULL,
    id_inventario INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id),
    FOREIGN KEY (rfc_proveedor) REFERENCES proveedor(rfc),
    FOREIGN KEY (id_inventario) REFERENCES inventario(id));

CREATE TABLE IF NOT EXISTS detalle_compra(
	id_detalle INT UNSIGNED PRIMARY KEY,
    no_factura VARCHAR(20) NOT NULL,
    id_producto SMALLINT UNSIGNED NOT NULL,
    cantidad DOUBLE UNSIGNED NOT NULL,
    subtotal DOUBLE UNSIGNED NOT NULL,
    total DOUBLE UNSIGNED NOT NULL,
    FOREIGN KEY (no_factura) REFERENCES compra(no_factura),
    FOREIGN KEY (id_producto) REFERENCES catalogo(id));

CREATE USER 'quetzal'@'localhost' IDENTIFIED BY 'quetzal.2018';
GRANT ALL PRIVILEGES ON quetzalstock.* TO 'quetzal'@'localhost';

FLUSH PRIVILEGES;