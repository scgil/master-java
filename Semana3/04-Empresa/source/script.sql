CREATE SCHEMA `bdempresa` ;
CREATE TABLE `bdempresa`.`empleados` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(10) NULL,
  `apellido1` VARCHAR(15) NULL,
  `apellido2` VARCHAR(15) NULL,
  `fecha_nacimiento` DATE NULL,
  `salario` DOUBLE NULL
  
  PRIMARY KEY (`codigo`));
  
INSERT INTO empleados (codigo, nombre, apellido1, apellido2, fecha_nacimiento, salario)  VALUES (1, 'Juan', 'Pérez', 'García', '1990-01-01', 30000.50);
INSERT INTO empleados (codigo, nombre, apellido1, apellido2, fecha_nacimiento, salario)  VALUES (2, 'Ana', 'López', 'Martínez', '1985-05-15', 45000.75);
INSERT INTO empleados (codigo, nombre, apellido1, apellido2, fecha_nacimiento, salario)  VALUES (3, 'Eva', 'Fernández', 'Sánchez', '1992-08-20', 38000.00);