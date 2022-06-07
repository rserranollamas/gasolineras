DROP DATABASE IF EXISTS gasolineras;
CREATE DATABASE gasolineras;

USE gasolineras;

CREATE TABLE usuario (
  `dni` VARCHAR(9) PRIMARY KEY,
  `nombre` VARCHAR(80) NOT NULL,
  `email` VARCHAR(200) ,
  `password` VARCHAR(20) NOT NULL
);
  
CREATE TABLE posicion (
`latitud` FLOAT(8,6),
`longitud` FLOAT(9,6),
`radioKm` INT(4),
`usuario` VARCHAR(9),
PRIMARY KEY(latitud,longitud,usuario),
FOREIGN KEY(usuario) REFERENCES usuario(dni)
);

CREATE TABLE localidad (
`nombre` VARCHAR(80),
`usuario` VARCHAR(9),
PRIMARY KEY(nombre,usuario), 
FOREIGN KEY(usuario) REFERENCES usuario(dni)
);

SELECT * FROM usuario;
DELETE FROM usuario WHERE dni='43120926C';