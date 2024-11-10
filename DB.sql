ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
DROP USER CASO CASCADE;
CREATE USER CASO IDENTIFIED BY A;
GRANT CONNECT, RESOURCE TO CASO;
ALTER USER CASO QUOTA UNLIMITED ON USERS;
CONN CASO/A

-- CREACIÓN DE LA TABLA CUERPO
CREATE TABLE CUERPO (
    ID_CUERPO NUMBER(10) PRIMARY KEY,
    DENOMINACION VARCHAR2(50) NOT NULL
);

-- CREACIÓN DE LA TABLA CUARTEL
CREATE TABLE CUARTEL (
    ID_CUARTEL NUMBER(10) PRIMARY KEY,
    NOMBRE VARCHAR2(50) NOT NULL,
    UBICACION VARCHAR2(50) NOT NULL
);

-- CREACIÓN DE LA TABLA COMPAÑIA
CREATE TABLE COMPANIA (
    ID_COMPANIA NUMBER(10) PRIMARY KEY,
    ACTIVIDAD_PRINCIPAL VARCHAR2(50) NOT NULL
);

-- CREACIÓN DE LA TABLA SERVICIO
CREATE TABLE SERVICIO (
    ID_SERVICIO NUMBER(10) PRIMARY KEY,
    DESCRIPCION VARCHAR2(50) NOT NULL
);

-- CREACIÓN DE LA TABLA SOLDADO
CREATE TABLE SOLDADO (
    ID_SOLDADO NUMBER(10) PRIMARY KEY,
    NOMBRE VARCHAR2(50) NOT NULL,
    APELLIDOS VARCHAR2(50) NOT NULL,
    GRADO VARCHAR2(50) NOT NULL,
    ID_CUERPO NUMBER(10)NOT NULL,
    ID_COMPANIA NUMBER(10)NOT NULL,
    ID_CUARTEL NUMBER(10) NOT NULL
);

-- CREACIÓN DE LA TABLA SOLDADO_SERVICIO
CREATE TABLE SOLDADO_SERVICIO (
    ID_SOLDADO NUMBER(10) NOT NULL,
    ID_SERVICIO NUMBER(10) NOT NULL,
    FECHA DATE NOT NULL,
	CONSTRAINT PK_SOLDADO_SERVICIO PRIMARY KEY (ID_SOLDADO,ID_SERVICIO)
);

-- CREACIÓN DE LA TABLA CUARTEL_COMPAÑIA
CREATE TABLE CUARTEL_COMPANIA (
    ID_CUARTEL NUMBER(10)  NOT NULL,
    ID_COMPANIA NUMBER(10) NOT NULL,
	CONSTRAINT PK_CUARTEL_COMPANIA PRIMARY KEY (ID_CUARTEL,ID_COMPANIA)
);

-- AGREGAR CLAVE FORÁNEA EN SOLDADO HACIA CUERPO
ALTER TABLE SOLDADO
ADD CONSTRAINT FK_CUERPO FOREIGN KEY (ID_CUERPO)
REFERENCES CUERPO(ID_CUERPO);

-- AGREGAR CLAVE FORÁNEA EN SOLDADO HACIA COMPAÑIA
ALTER TABLE SOLDADO
ADD CONSTRAINT FK_COMPANIA FOREIGN KEY (ID_COMPANIA)
REFERENCES COMPANIA(ID_COMPANIA);

-- AGREGAR CLAVE FORÁNEA EN SOLDADO HACIA CUARTEL
ALTER TABLE SOLDADO
ADD CONSTRAINT FK_CUARTEL FOREIGN KEY (ID_CUARTEL)
REFERENCES CUARTEL(ID_CUARTEL);

-- AGREGAR CLAVE FORÁNEA EN SOLDADO_SERVICIO HACIA SOLDADO
ALTER TABLE SOLDADO_SERVICIO
ADD CONSTRAINT FK_SOLDADO FOREIGN KEY (ID_SOLDADO)
REFERENCES SOLDADO(ID_SOLDADO);

-- AGREGAR CLAVE FORÁNEA EN SOLDADO_SERVICIO HACIA SERVICIO
ALTER TABLE SOLDADO_SERVICIO
ADD CONSTRAINT FK_SERVICIO FOREIGN KEY (ID_SERVICIO)
REFERENCES SERVICIO(ID_SERVICIO);

-- AGREGAR CLAVE FORÁNEA EN CUARTEL_COMPAÑIA HACIA CUARTEL
ALTER TABLE CUARTEL_COMPANIA
ADD CONSTRAINT FK_CUARTEL_ID FOREIGN KEY (ID_CUARTEL)
REFERENCES CUARTEL(ID_CUARTEL);

-- AGREGAR CLAVE FORÁNEA EN CUARTEL_COMPAÑIA HACIA COMPAÑIA
ALTER TABLE CUARTEL_COMPANIA
ADD CONSTRAINT FK_COMPANIA_ID FOREIGN KEY (ID_COMPANIA)
REFERENCES COMPANIA(ID_COMPANIA);

