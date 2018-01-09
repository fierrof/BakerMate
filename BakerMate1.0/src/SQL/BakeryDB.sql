

DROP TABLE ROOT.COMPRA;
DROP TABLE ROOT.VENTA;
DROP TABLE ROOT.MOVIMIENTO;
DROP TABLE ROOT.TIPO_VENTA;
DROP TABLE ROOT.ESTADO_COMPRA;
DROP TABLE ROOT.TIPO_MOVIMIENTO;
DROP TABLE ROOT.PRODUCTO;
DROP TABLE ROOT.PROVEEDOR;
DROP TABLE ROOT.USUARIO;
DROP TABLE ROOT.GASTO;
DROP TABLE ROOT.TIPO_GASTO;
DROP TABLE ROOT.ESTADO_GASTO;

CREATE TABLE proveedor
(
id_proveedor INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255),
apellido VARCHAR(255),
email VARCHAR(255),
telefono VARCHAR(255),
direccion VARCHAR(255)
);
CREATE TABLE usuario
(
id_usuario INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255),
apellido VARCHAR(255),
email VARCHAR(255),
pass VARCHAR(255),
telefono VARCHAR(255),
direccion VARCHAR(255)
);
CREATE TABLE producto
(
id_producto INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255),
precio_compra DOUBLE,
precio_venta DOUBLE,
id_proveedor INT NOT NULL,
FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor)
);
CREATE TABLE tipo_venta
(
id_tipo_venta INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255)
);
CREATE TABLE venta
(
id_venta INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
fecha DATE NOT NULL,
cantidad DOUBLE,
precio_vendido DOUBLE,
id_producto INT NOT NULL,
id_usuario INT NOT NULL,
id_tipo_venta INT NOT NULL,
FOREIGN KEY (id_producto) REFERENCES producto (id_producto),
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
FOREIGN KEY (id_tipo_venta) REFERENCES tipo_venta (id_tipo_venta)	
);
CREATE TABLE estado_compra
(
id_estado_compra INTEGER NOT NULL PRIMARY KEY,
nombre VARCHAR(255)
);
CREATE TABLE compra
(
id_compra INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
fecha DATE NOT NULL,
cantidad DOUBLE,
id_estado_compra INT NOT NULL,
id_producto INT NOT NULL,
id_usuario INT NOT NULL,
FOREIGN KEY (id_estado_compra) REFERENCES estado_compra (id_estado_compra),
FOREIGN KEY (id_producto) REFERENCES producto (id_producto),
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);
CREATE TABLE tipo_movimiento
(
id_tipo_movimiento INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255)
);
CREATE TABLE movimiento
(
id_movimiento INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
fecha DATE NOT NULL,
detalle VARCHAR(255),
monto DOUBLE NOT NULL,
id_tipo_movimiento INT NOT NULL,
id_usuario INT NOT NULL,
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);
CREATE TABLE tipo_gasto
(
id_tipo_gasto INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255)
);
CREATE TABLE estado_gasto
(
id_estado_gasto INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
nombre VARCHAR(255)
);
CREATE TABLE gasto
(
id_gasto INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
mes INT,
detalle VARCHAR(255),
monto DOUBLE,
observacion VARCHAR(255),
id_tipo_gasto INT NOT NULL,
id_estado_gasto INT NOT NULL,
FOREIGN KEY (id_tipo_gasto) REFERENCES tipo_gasto  (id_tipo_gasto),
FOREIGN KEY (id_estado_gasto) REFERENCES estado_gasto (id_estado_gasto)
);
INSERT INTO TIPO_VENTA (nombre) VALUES ('Efectivo');
INSERT INTO TIPO_VENTA (nombre) VALUES ('Visa Debito');
INSERT INTO TIPO_VENTA (nombre) VALUES ('Visa Credito');
INSERT INTO TIPO_VENTA (nombre) VALUES ('Master Debito');
INSERT INTO TIPO_VENTA (nombre) VALUES ('Master Credito');
INSERT INTO TIPO_VENTA (nombre) VALUES ('A.Express Debito');
INSERT INTO TIPO_VENTA (nombre) VALUES ('A.Express Credito');
INSERT INTO ESTADO_COMPRA (id_estado_compra,nombre) VALUES (0,'Pagado');
INSERT INTO ESTADO_COMPRA (id_estado_compra,nombre) VALUES (1,'No Pagado');
INSERT INTO TIPO_MOVIMIENTO (nombre) VALUES ('Egreso');
INSERT INTO TIPO_MOVIMIENTO (nombre) VALUES ('Ingreso');
INSERT INTO TIPO_GASTO (nombre) VALUES ('Fijo');
INSERT INTO TIPO_GASTO (nombre) VALUES ('No Fijo');
INSERT INTO ESTADO_GASTO (nombre) VALUES ('No Pagado');
INSERT INTO ESTADO_GASTO (nombre) VALUES ('Pagado');
INSERT INTO USUARIO (nombre, apellido, email, pass, telefono, direccion) VALUES ('Facundo', 'Fierro', 'fierrof_47@hotmail.com', '123', '3513878776', 'Samuel Morse 2084');

INSERT INTO PROVEEDOR (nombre, apellido, email, telefono, direccion) VALUES ('Juan', NULL, NULL, '123', NULL);
INSERT INTO USUARIO (nombre, apellido, email, pass, telefono, direccion) VALUES ('Facundo', 'Fierro', 'fierrof_47@hotmail.com', '123', '3513878776', 'Samuel Morse 2084');
INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, id_proveedor) VALUES ('Pan',24,40,1);

INSERT INTO VENTA (fecha, cantidad, precio_vendido, id_producto, id_usuario, id_tipo_venta) VALUES (CURRENT_DATE, 0.25, 40, 1, 1,1);

INSERT INTO COMPRA (fecha, cantidad, id_estado_compra, id_producto, id_usuario) VALUES (CURRENT_DATE, 8, 1, 1, 1);

INSERT INTO MOVIMIENTO (fecha, detalle, monto, id_tipo_movimiento, id_usuario) VALUES (CURRENT_DATE, 'caja grande', 60000.35,1, 1);
