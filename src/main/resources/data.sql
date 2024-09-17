-- cursos
INSERT INTO curso (nombre, siglas, estado)
VALUES ('Java POO', 'JAV-POO', 1);

INSERT INTO curso (nombre, siglas, estado)
VALUES ('Spring Cloud', 'SCL-Cloud', 1);

INSERT INTO curso (nombre, siglas, estado)
VALUES ('PHP Básico', 'PHP-Base', 1);

INSERT INTO curso (nombre, siglas, estado)
VALUES ('React Básico', 'RCT-Base', 1);

-- estudiantes
INSERT INTO estudiante (nombres, apellidos, dni, edad)
VALUES ('Jose Mario', 'Vilchez Galvez', '75236489', 18);

INSERT INTO estudiante (nombres, apellidos, dni, edad)
VALUES ('Pablo Roberto', 'Martinez Osorio', '85263418', 35);

INSERT INTO estudiante (nombres, apellidos, dni, edad)
VALUES ('Daniel Martin', 'Bravo Alvarez Calderon', '71221756', 22);

-- matriculas
INSERT INTO matricula (fecha_matricula, id_estudiante, estado)
VALUES (CURRENT_TIMESTAMP, 1, 1);

INSERT INTO matricula (fecha_matricula, id_estudiante, estado)
VALUES (CURRENT_TIMESTAMP, 2, 1);

INSERT INTO matricula (fecha_matricula, id_estudiante, estado)
VALUES (CURRENT_TIMESTAMP, 3, 1);

INSERT INTO matricula (fecha_matricula, id_estudiante, estado)
VALUES (CURRENT_TIMESTAMP, 3, 1);

-- detalle_matriculas
INSERT INTO detalle_matricula (id_matricula, id_curso, aula)
VALUES (1, 3, 'C201');

INSERT INTO detalle_matricula (id_matricula, id_curso, aula)
VALUES (2, 1, 'C202');

INSERT INTO detalle_matricula (id_matricula, id_curso, aula)
VALUES (3, 1, 'C202');

INSERT INTO detalle_matricula (id_matricula, id_curso, aula)
VALUES (4, 3, 'C201');

INSERT INTO detalle_matricula (id_matricula, id_curso, aula)
VALUES (4, 2, 'A502');




