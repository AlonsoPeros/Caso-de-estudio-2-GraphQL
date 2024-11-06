-- Creación de la tabla Cuerpo
CREATE TABLE Cuerpo (
    id_cuerpo NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    denominacion VARCHAR2(255) NOT NULL
);

-- Creación de la tabla Cuartel
CREATE TABLE Cuartel (
    id_cuartel NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(255) NOT NULL,
    ubicacion VARCHAR2(255) NOT NULL
);

-- Creación de la tabla Compañia
CREATE TABLE Compania (
    id_compania NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    actividad_principal VARCHAR2(255) NOT NULL
);

-- Creación de la tabla Servicio
CREATE TABLE Servicio (
    id_servicio NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    descripcion VARCHAR2(255) NOT NULL
);

-- Creación de la tabla Soldado
CREATE TABLE Soldado (
    id_soldado NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(255) NOT NULL,
    apellidos VARCHAR2(255) NOT NULL,
    grado VARCHAR2(255) NOT NULL,
    cuerpo_id NUMBER(20),
    compañia_id NUMBER(20),
    cuartel_id NUMBER(20)
);

-- Creación de la tabla Soldado_Servicio
CREATE TABLE Soldado_Servicio (
    id_soldadoServicio NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    soldado_id NUMBER(20),
    servicio_id NUMBER(20),
    fecha DATE NOT NULL
);

-- Creación de la tabla Cuartel_Compañia
CREATE TABLE Cuartel_Compañia (
    id_cuartelCompañia NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    cuartel_id NUMBER(20),
    compañia_id NUMBER(20)
);

-- Agregar clave foránea en Soldado hacia Cuerpo
ALTER TABLE Soldado
ADD CONSTRAINT fk_cuerpo FOREIGN KEY (cuerpo_id)
REFERENCES Cuerpo(id);

-- Agregar clave foránea en Soldado hacia Compañia
ALTER TABLE Soldado
ADD CONSTRAINT fk_compañia FOREIGN KEY (compañia_id)
REFERENCES Compañia(id);

-- Agregar clave foránea en Soldado hacia Cuartel
ALTER TABLE Soldado
ADD CONSTRAINT fk_cuartel FOREIGN KEY (cuartel_id)
REFERENCES Cuartel(id);

-- Agregar clave foránea en Soldado_Servicio hacia Soldado
ALTER TABLE Soldado_Servicio
ADD CONSTRAINT fk_soldado FOREIGN KEY (soldado_id)
REFERENCES Soldado(id);

-- Agregar clave foránea en Soldado_Servicio hacia Servicio
ALTER TABLE Soldado_Servicio
ADD CONSTRAINT fk_servicio FOREIGN KEY (servicio_id)
REFERENCES Servicio(id);

-- Agregar clave foránea en Cuartel_Compañia hacia Cuartel
ALTER TABLE Cuartel_Compañia
ADD CONSTRAINT fk_cuartel_id FOREIGN KEY (cuartel_id)
REFERENCES Cuartel(id);

-- Agregar clave foránea en Cuartel_Compañia hacia Compañia
ALTER TABLE Cuartel_Compañia
ADD CONSTRAINT fk_compañia_id FOREIGN KEY (compañia_id)
REFERENCES Compañia(id);
