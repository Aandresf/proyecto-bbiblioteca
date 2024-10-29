

-- Creamos la tabla de categorias para los libros
CREATE TABLE CATEGORIA_LIBROS(
    ID SERIAL PRIMARY KEY,
    DETALLES VARCHAR(20) NOT NULL
);

-- Insertar 10 categorías
INSERT INTO CATEGORIA_LIBROS (DETALLES) VALUES
    ('CIENCIA FICCION'),
    ('BIOGRAFIA'),
    ('HISTORIA'),
    ('FILOSOFÍA'),
    ('POESIA'),
    ('TECNOLOGI\QA'),
    ('LITERATURA'),
    ('ARTE'),
    ('CIENCIAS SOCIALES'),
    ('PSICOLOGIA');

-- Creamos la tabla de autores
CREATE TABLE AUTORES(
    ID SERIAL PRIMARY KEY,
    DETALLES VARCHAR(50) NOT NULL
);

-- Inserta los autores con sus IDs
INSERT INTO AUTORES (DETALLES) VALUES
    ('H.G. Wells'),
    ('Walter Isaacson'),
    ('Sun Tzu'),
    ('Jostein Gaarder'),
    ('Pablo Neruda'),
    ('Ray Kurzweil'),
    ('Gabriel García Márquez'),
    ('Leonardo da Vinci'),
    ('Immanuel Kant'),
    ('Charles Darwin'),
    ('Carl Jung'),
    ('Ray Bradbury'),
    ('Isaac Asimov'),
    ('Ana Frank'),
    ('Umberto Eco'),
    ('Jorge Luis Borges'),
    ('Franz Kafka'),
    ('George Orwell'),
    ('Marcel Proust'),
    ('Dante Alighieri'),
    ('Victor Hugo'),
    ('Daniel Kahneman'),
    ('Yuval Noah Harari'),
    ('Karl Marx'),
    ('Platón'),
    ('Oscar Wilde'),
    ('Stephen Hawking'),
    ('Rhonda Byrne');

-- Creamos la tabla libros
CREATE TABLE LIBROS(
    ID SERIAL PRIMARY KEY,
    TITULO_LIBRO VARCHAR(200) UNIQUE NOT NULL,
    AUTOR_LIBRO INT NOT NULL,
    FOREIGN KEY(AUTOR_LIBRO) REFERENCES AUTORES(ID),
    CATEGORIA INT NOT NULL,
    FOREIGN KEY(CATEGORIA) REFERENCES CATEGORIA_LIBROS(ID),
    ESTADO INT NOT NULL
);

-- Insertar 30 libros con categorías y estados variados
INSERT INTO LIBROS (TITULO_LIBRO, AUTOR_LIBRO, CATEGORIA, ESTADO) VALUES
    ('La Guerra de los Mundos', 1, 1, 1),
    ('Steve Jobs', 2, 2, 2),
    ('El Arte de la Guerra', 3, 3, 1),
    ('El Mundo de Sofía', 4, 4, 1),
    ('Veinte Poemas de Amor', 5, 5, 2),
    ('La Era de las Máquinas Espirituales', 6, 6, 2),
    ('Cien Años de Soledad', 7, 7, 1),
    ('El Arte de la Pintura', 8, 8, 2),
    ('Teoría del Conocimiento', 9, 4, 1),
    ('El Origen de las Especies', 10, 9, 1),
    ('El Hombre y sus Símbolos', 11, 10, 2),
    ('Crónicas Marcianas', 12, 1, 2),
    ('Yo, Robot', 13, 1, 1),
    ('El Diario de Ana Frank', 14, 2, 2),
    ('El Nombre de la Rosa', 15, 7, 1),
    ('Ficciones', 16, 7, 1),
    ('La Metamorfosis', 17, 7, 2),
    ('1984', 18, 7, 1),
    ('En Busca del Tiempo Perdido', 19, 7, 1),
    ('La Divina Comedia', 20, 7, 2),
    ('Fundación', 13, 1, 1),
    ('Los Miserables', 21, 7, 1),
    ('Pensar Rápido, Pensar Despacio', 22, 10, 2),
    ('Sapiens: De Animales a Dioses', 23, 3, 1),
    ('Fahrenheit 451', 12, 1, 1),
    ('El Capital', 24, 9, 2),
    ('La República', 25, 4, 1),
    ('El Retrato de Dorian Gray', 26, 7, 1),
    ('Breve Historia del Tiempo', 27, 6, 2),
    ('El Secreto', 28, 10, 1);

-- creamos la tabla de bibliotecas
CREATE TABLE BIBLIOTECAS(
    ID SERIAL PRIMARY KEY,
    DESCRIPCION VARCHAR(100) NOT NULL,
    DIRECCION VARCHAR(200) NOT NULL
);

-- Insertamos las bibliotecas.
INSERT INTO BIBLIOTECAS (DESCRIPCION, DIRECCION) VALUES
    ('Biblioteca Central', 'Calle Principal #123, Ciudad Central'),
    ('Biblioteca Norte', 'Av. de la Cultura #456, Ciudad Norte'),
    ('Biblioteca Sur', 'Calle Las Flores #789, Ciudad Sur');

-- Creamos la tabla de sectorizacion interna por biblioteca
CREATE TABLE SECTORIZACION(
    ID SERIAL PRIMARY KEY,
    BIBLIOTECA INT NOT NULL,
    FOREIGN KEY(BIBLIOTECA) REFERENCES BIBLIOTECAS(ID),
    SECTOR VARCHAR(100),
    ESTADO INT
);

-- Insertamos las sectorizaciones por biblioteca.
INSERT INTO SECTORIZACION (BIBLIOTECA, SECTOR, ESTADO) VALUES

(1, 'Sección A1',1), -- 1
(1, 'Sección A2',1), -- 2
(1, 'Sección B1',1), -- 3
(1, 'Sección B2',1), -- 4
(1, 'Sección C3',1), -- 5
(1, 'Sección D1',1), -- 6

(2, 'Sección A1',1), -- 7
(2, 'Sección A3',1), -- 8
(2, 'Sección A4',1), -- 9
(2, 'Sección B1',1), -- 10
(2, 'Sección C3',1), -- 11
(2, 'Sección B3',1), -- 12

(3, 'Sección B2',1), -- 13
(3, 'Sección C2',1), -- 14
(3, 'Sección C4',1), -- 15
(3, 'Sección D1',1), -- 16
(3, 'Sección D2',1); -- 17


-- Creamos la tabla estados de existencias de inventario
CREATE TABLE ESTADO_EXISTENCIAS(
    ID SERIAL PRIMARY KEY,
    DETALLES VARCHAR(20) NOT NULL
);

-- Insertamos datos en la tabla estados de existencia
INSERT INTO ESTADO_EXISTENCIAS (DETALLES) VALUES
    ('DISPONIBLE'),
    ('NO DISPONIBLE'),
    ('MANTENIMIENTO'),
    ('INACTIVO');

-- Creamos la tabla de existencias de libros por biblioteca
CREATE TABLE INVENTARIO(
    ID SERIAL PRIMARY KEY,
    CODIGO VARCHAR(100) NOT NULL,
    LIBRO INT NOT NULL,
    FOREIGN KEY(LIBRO) REFERENCES LIBROS(ID),
    UBICACION INT,
    FOREIGN KEY(UBICACION) REFERENCES SECTORIZACION(ID),
    ESTADO INT NOT NULL,
    FOREIGN KEY(ESTADO) REFERENCES ESTADO_EXISTENCIAS(ID)
);

-- Creamos los valores del inventario
INSERT INTO INVENTARIO (LIBRO, UBICACION, CODIGO, ESTADO) VALUES
    (1, 1, '1012345', 1),  -- 'La Guerra de los Mundos' en 'Biblioteca Central'
    (1, 8, '112345', 2),   -- 'La Guerra de los Mundos' en 'Biblioteca Norte' - PRESTAMO EN CARRERA
    (1, 13, '712346', 2),   -- 'La Guerra de los Mundos' en 'Biblioteca Sur'

    (2, 3, '012345', 1),   -- 'Steve Jobs' en 'Biblioteca Central' - PRESTAMO EN CARRERA
    (2, 9, '412346', 2),   -- 'Steve Jobs' en 'Biblioteca Norte'
    (2, 14, '312346', 1),   -- 'Steve Jobs' en 'Biblioteca Sur' - PRESTAMO EN CARRERA

    (3, 5, '812345', 2),   -- 'El Arte de la Guerra' en 'Biblioteca Central'
    (3, 10, '512345', 1),   -- 'El Arte de la Guerra' en 'Biblioteca Norte'
    (3, 15, '712347', 2),   -- 'El Arte de la Guerra' en 'Biblioteca Sur' - PRESTAMO EN CARRERA

    (4, 6, '612365', 1),   -- 'El Mundo de Sofía' en 'Biblioteca Central'
    (4, 13, '522345', 1),   -- 'El Mundo de Sofía' en 'Biblioteca Sur'

    (5, 7, '412345', 2),   -- 'Veinte Poemas de Amor' en 'Biblioteca Norte' - PRESTAMO EN CARRERA
    (5, 14, '022345', 2),   -- 'Veinte Poemas de Amor' en 'Biblioteca Sur' - PRESTAMO EN CARRERA

    (6, 2, '712345', 1),   -- 'La Era de las Máquinas Espirituales' en 'Biblioteca Central'
    (6, 11, '612346', 1),   -- 'La Era de las Máquinas Espirituales' en 'Biblioteca Norte'
    (6, 17, '842345', 4),   -- 'La Era de las Máquinas Espirituales' en 'Biblioteca Sur'

    (7, 4, '912345', 1),   -- 'Cien Años de Soledad' en 'Biblioteca Central'
    (7, 9, '612345', 1),   -- 'Cien Años de Soledad' en 'Biblioteca Norte'

    (8, 16, '3312345', 3),   -- 'El Arte de la Pintura' en 'Biblioteca Sur'
    (8, 12, '5312345', 3);  -- 'El Arte de la Pintura' en 'Biblioteca Norte'

-- Creamos la tabla de las categorias y los permisos de usuarios
CREATE TABLE CATEGORIA_USUARIOS(
    ID SERIAL PRIMARY KEY,
    DETALLES VARCHAR(20) NOT NULL,
    PRESTAMO_EXTENDIDO INT,
    PRESTAMO_MULTIPLE INT
);

-- Inseertamos las categorias y concedemos permisos
INSERT INTO CATEGORIA_USUARIOS (DETALLES, PRESTAMO_EXTENDIDO, PRESTAMO_MULTIPLE) VALUES
    ('VISITANTE',0,0),
    ('ESTUDIANTE',1,0),
    ('DOCENTE',1,1);

--Creamos la tabla de Carreras.
CREATE TABLE CARRERAS(
    ID SERIAL PRIMARY KEY,
    CARRERA VARCHAR(100) NOT NULL
);

-- Insertamos las carreras (si aplica) de los usuarios
INSERT INTO CARRERAS (CARRERA) VALUES
    ('No Aplica'),
    ('Derecho'),
    ('Medicina'),
    ('Ingeniería Informática'),
    ('Arquitectura'),
    ('Contaduría'),
    ('Psicología'),
    ('Ingeniería Civil'),
    ('Educación'),
    ('Biología'),
    ('Química');


-- Creamos la tabla de los usuarios
CREATE TABLE USUARIOS(
    ID SERIAL PRIMARY KEY,
    CATEGORIA INT NOT NULL,
    FOREIGN KEY(CATEGORIA) REFERENCES CATEGORIA_USUARIOS(ID),
    CEDULA INT UNIQUE NOT NULL,
    NOMBRE VARCHAR(30) NOT NULL,
    APELLIDO VARCHAR(30) NOT NULL,
    TELEFONO VARCHAR(15),
    CORREO VARCHAR(30),
    CARRERA INT,
    FOREIGN KEY(CARRERA) REFERENCES CARRERAS(ID),
    SEMESTRE INT,
    ESTADO INT NOT NULL
);

-- Registramos usuarios
INSERT INTO USUARIOS (CATEGORIA, CEDULA, NOMBRE, APELLIDO, TELEFONO, CORREO, CARRERA, SEMESTRE, ESTADO) VALUES
    -- Usuarios Activos - Estudiantes
    (2, 26789012, 'María', 'González', '04261234567', 'maria.gonzalez@hotmail.com', 2,1, 3),           
    (2, 27890123, 'José', 'Rodríguez', '04161234568', 'jose.rodriguez@yahoo.com', 2,2, 1),            
    (2, 25678901, 'Carlos', 'Pérez', '04161234567', 'carlos.perez@gmail.com', 3,6, 3),  
    (2, 28901234, 'Ana', 'Martínez', '04261234568', 'ana.martinez@gmail.com', 4,10, 3),            
    (2, 29012345, 'Luis', 'Hernández', '04161234569', 'luis.hernandez@outlook.com', 5,7, 1),        

    -- Usuarios Activos - Docentes
    (3, 17890123, 'Carmen', 'López', '04161234570', 'carmen.lopez@gmail.com', 1,0, 1),            
    (3, 18901234, 'Jorge', 'Fernández', '04261234570', 'jorge.fernandez@gmail.com', 1,0, 1),
    (3, 19456789, 'Laura', 'Ramírez', '04161234571', 'laura.ramirez@hotmail.com', 1,0, 1),         

    -- Usuarios Activos - Visitantes
    (1, 27901234, 'Pedro', 'Morales', '04261234571', 'pedro.morales@correo.com', 1,0, 1),                
    (1, 28567890, 'Lucía', 'Rivas', '04161234572', 'lucia.rivas@correo.com', 1,0, 1),                    

    -- Usuarios Inactivos
    (2, 29123456, 'Sofía', 'Suárez', '04261234572', 'sofia.suarez@gmail.com', 9,6, 3),
    (3, 18012345, 'Ricardo', 'Vega', '04161234573', 'ricardo.vega@universidad.edu', 1,0, 3);


-- Creamos la tabla de los estados de prestamos
CREATE TABLE ESTADO_PRESTAMOS(
    ID SERIAL PRIMARY KEY,
    DETALLES VARCHAR(20) NOT NULL
);

-- Insertmos los estados que van a tomar los prestamos
INSERT INTO ESTADO_PRESTAMOS (DETALLES) VALUES
    ('EN CARRERA'),
    ('FINALIZADO'),
	('SANCIONADO');

-- Creamos la tabla de prestamos
CREATE TABLE PRESTAMOS(
    ID SERIAL PRIMARY KEY,
    LIBRO INT NOT NULL,
    FOREIGN KEY(LIBRO) REFERENCES INVENTARIO(ID),
    USUARIO INT NOT NULL,
    FOREIGN KEY(USUARIO) REFERENCES USUARIOS(ID),
    FECHA_PRESTAMO DATE NOT NULL,
    FECHA_ESTIMADA DATE NOT NULL,
    FECHA_EXTENDIDA DATE,
    FECHA_DEVOLUCION DATE,
    ESTADO INT NOT NULL,
    FOREIGN KEY(ESTADO) REFERENCES ESTADO_PRESTAMOS(ID)
);

-- Insertamos varios prestamos
INSERT INTO PRESTAMOS (LIBRO, USUARIO, FECHA_PRESTAMO, FECHA_ESTIMADA, FECHA_EXTENDIDA, FECHA_DEVOLUCION, ESTADO) VALUES
    -- Préstamos para visitantes (no pueden extender el préstamo)
    (1, 1, '2024-09-01', '2024-09-08',NULL, '2024-09-07', 2),  -- Visitante, préstamo finalizado
    (2, 2, '2024-09-05', '2024-09-12', NULL,NULL , 1),         -- Visitante, préstamo en CARRERA

    -- Préstamos para estudiantes (pueden extender el préstamo a 15 días)
    (3, 3, '2024-09-01', '2024-09-08', '2024-09-15', '2024-09-14', 2),  -- Estudiante, préstamo finalizado
    (4, 4, '2024-09-05', '2024-09-12', '2024-09-19',NULL , 1),         -- Estudiante, préstamo en CARRERA
    (5, 5, '2024-09-10', '2024-09-17', '2024-09-24',NULL, 2),         -- Estudiante, multado (fecha extendida pasada)
    (6, 6, '2024-09-15', '2024-09-22', '2024-09-29', NULL, 1),         -- Estudiante, en CARRERA
    (7, 7, '2024-09-20', '2024-09-27', '2024-10-04', '2024-10-02', 2), -- Estudiante, finalizado

    -- Préstamos para docentes (pueden extender y pedir préstamos múltiples)
    (8, 8, '2024-08-20', '2024-08-27', '2024-09-03', '2024-09-02', 2), -- Docente, préstamo finalizado
    (9, 8, '2024-09-01', '2024-09-08', '2024-09-15',NULL , 1),         -- Docente, en CARRERA (préstamo múltiple)
    (10, 9, '2024-09-10', '2024-09-17', '2024-09-24', NULL, 2),        -- Docente, multado (fecha extendida pasada)
    (11, 9, '2024-09-15', '2024-09-22', '2024-09-29', '2024-09-27', 2),-- Docente, finalizado
    (12, 10, '2024-09-20', '2024-09-27', '2024-10-04',NULL , 1),       -- Docente, en CARRERA (préstamo extendido)
    (13, 10, '2024-09-25', '2024-10-02', '2024-10-09', NULL, 1);       -- Docente, en CARRERA (préstamo múltiple)



-- Creamos un procedimiento almacenado para registrar un prestamo a partir del id de un libro en inventario y un usuario
CREATE OR REPLACE PROCEDURE INSERTAR_PRESTAMO(in_id_inventario INT, in_usuario INT)
    LANGUAGE plpgsql AS
    $$
    DECLARE
        v_categoria_usuario INT;
        v_estado_usuario INT;
        v_numero_prestamos INT;
		v_estado_inventario INT;
    BEGIN
        -- Obtener el estado del usuario
        SELECT ESTADO INTO v_estado_usuario FROM USUARIOS as U WHERE U.ID = in_usuario;

        -- Obtener la categoria del usuario
        SELECT CATEGORIA INTO v_categoria_usuario FROM USUARIOS AS U WHERE U.ID = in_usuario;

        -- Obtener el total de prestamos activos del usuario
        SELECT COUNT(*) INTO v_numero_prestamos FROM PRESTAMOS WHERE USUARIO = in_usuario AND ESTADO = 1;
		
		-- Obtener el estado de libro a prestar
		SELECT ESTADO INTO v_estado_inventario FROM INVENTARIO AS INV WHERE INV.ID = in_id_inventario;
		-- Si no se afecta ninguna fila, lanzar un mensaje de advertencia
		IF NOT FOUND THEN
			RAISE NOTICE 'No se encontró ningún registro en la tabla INVENTARIO con ID: %', in_id_inventario;
		END IF;


        -- Comprobar si el usuario no esta multado
        IF v_estado_usuario <> 1 THEN
                RAISE EXCEPTION 'El usuario tiene una multa o esta inactivo.';
        END IF;

        -- Comprobar si el usuario no es un profesor
        IF v_categoria_usuario < 3 THEN

            -- Si tiene un préstamo activo, lanzar una excepción
            IF v_numero_prestamos > 0 THEN
                RAISE EXCEPTION 'El usuario ya tiene un préstamo activo.';
            END IF;
        END IF;


		IF v_estado_inventario <> 1 THEN
			RAISE NOTICE 'No se encontró disponible ningún registro en la tabla INVENTARIO con ID: %', in_id_inventario;
		END IF;


		IF v_estado_inventario = 1 THEN
        	-- Actualizar las existencias y el estado del inventario
        	UPDATE INVENTARIO SET ESTADO = 2 WHERE ID = in_id_inventario;

			-- Insertar el nuevo préstamo
	        INSERT INTO PRESTAMOS (LIBRO, USUARIO, FECHA_PRESTAMO, FECHA_ESTIMADA, ESTADO)
	        VALUES (in_id_inventario, in_usuario, CURRENT_DATE, CURRENT_DATE + INTERVAL '7 DAY', 1);

			SELECT * FROM PRESTAMOS ORDER BY ID DESC LIMIT 2;
		END IF;

    EXCEPTION
        WHEN unique_violation THEN
            RAISE EXCEPTION 'El préstamo ya existe o hay un error de duplicado.';
        WHEN others THEN
            RAISE EXCEPTION 'Se produjo un error inesperado: %', SQLERRM;
    END;
    $$;

-- CALL insertar_prestamo(1,1);


CREATE VIEW "LIBROS DISPONIBLES" AS
	SELECT CODIGO AS "CODIGO",
		(SELECT TITULO_LIBRO FROM LIBROS AS LIB WHERE LIB.ID = INV.LIBRO ) AS "TITULO",
	
			(SELECT (
					SELECT DESCRIPCION 
						FROM BIBLIOTECAS AS BIB WHERE BIB.ID = SEC.BIBLIOTECA)
				FROM SECTORIZACION AS SEC WHERE SEC.ID = INV.UBICACION) AS "BIBLIOTECA",
	
			(SELECT SECTOR FROM SECTORIZACION AS SEC WHERE SEC.ID = INV.UBICACION) AS "SECTOR",
	
			ESTADO AS "ESTADO"
	
	FROM INVENTARIO AS INV WHERE ESTADO = 1 ORDER BY "BIBLIOTECA", "SECTOR", "CODIGO" ASC;

CREATE VIEW "DETALLES PRESTAMOS"
 AS
   
    SELECT 

		ID AS "ID PRESTAMO", LIBRO AS "ID LIBRO",

		-- obtenemos la biblioteca a la que pertenece el sector donde esta ubicado el libro.
		(SELECT (SELECT (SELECT BIB.ID FROM BIBLIOTECAS AS BIB WHERE BIB.ID = SEC.BIBLIOTECA)
					FROM SECTORIZACION AS SEC WHERE SEC.ID = INV.UBICACION)
			FROM INVENTARIO AS INV WHERE INV.ID = PRES.LIBRO) AS "ID BIBLIOTECA",
			
		(SELECT (SELECT (SELECT DESCRIPCION FROM BIBLIOTECAS AS BIB WHERE BIB.ID = SEC.BIBLIOTECA)
					FROM SECTORIZACION AS SEC WHERE SEC.ID = INV.UBICACION)
			FROM INVENTARIO AS INV WHERE INV.ID = PRES.LIBRO) AS "BIBLIOTECA",
			
		(SELECT (SELECT SECTOR FROM SECTORIZACION AS SEC WHERE SEC.ID = INV.UBICACION)
			FROM INVENTARIO AS INV WHERE INV.ID = PRES.LIBRO) AS "SECTOR",

		-- Obtenemos el nombre del libro del inventario del que se tomo el prestamo
		(SELECT (SELECT TITULO_LIBRO FROM LIBROS AS LIB WHERE LIB.ID = INV.LIBRO)
			FROM INVENTARIO AS INV WHERE INV.ID = PRES.LIBRO) AS "LIBRO",
			
		(SELECT CODIGO FROM INVENTARIO AS INV WHERE INV.ID = PRES.LIBRO)AS "CODIGO",
			
		(SELECT CEDULA FROM USUARIOS AS U WHERE U.ID = PRES.USUARIO) AS "CEDULA",
		
		(SELECT NOMBRE || ' ' || APELLIDO FROM USUARIOS AS U WHERE U.ID = PRES.USUARIO) AS "USUARIO",
		
		-- obtenemos la categoría del usuario con el prestamo
		(SELECT (SELECT DETALLES FROM CATEGORIA_USUARIOS AS CTA_USER WHERE CTA_USER.ID = U.CATEGORIA)
			FROM USUARIOS AS U WHERE U.ID = PRES.USUARIO) AS "CATEGORIA",

		FECHA_PRESTAMO AS "FECHA PRESTAMO", FECHA_ESTIMADA AS " FECHA DE ENTREGA",
		
		(SELECT DETALLES FROM ESTADO_PRESTAMOS AS ED WHERE ED.ID = PRES.ESTADO) AS "ESTADO"	
			
	FROM PRESTAMOS AS PRES ORDER BY FECHA_PRESTAMO DESC;

CREATE VIEW "DETALLES LIBROS" AS 
	SELECT TITULO_LIBRO AS "TITULO",
			(SELECT DETALLES FROM AUTORES AS AUT WHERE AUT.ID = LIB.AUTOR_LIBRO )AS "AUTOR", 
			(SELECT DETALLES FROM CATEGORIA_LIBROS AS CL WHERE CL.ID = LIB.CATEGORIA) AS "CATEGORIA",
			(SELECT ID FROM CATEGORIA_LIBROS AS CL WHERE CL.ID = LIB.CATEGORIA) AS "ID CATEGORIA",
			(SELECT COUNT(*) FROM INVENTARIO AS INV WHERE INV.LIBRO = LIB.ID) AS "EXISTENCIAS"
			FROM LIBROS AS LIB;

CREATE VIEW "DETALLES USUARIOS" AS 
	SELECT ID AS "ID USUARIO", CEDULA AS "CEDULA", NOMBRE || ' ' || APELLIDO AS "NOMBRE",
			(SELECT DETALLES FROM CATEGORIA_USUARIOS AS CTUS WHERE CTUS.ID = US.CATEGORIA) AS "CATEGORIA",
			(SELECT ID FROM CATEGORIA_USUARIOS AS CTUS WHERE CTUS.ID = US.CATEGORIA) AS "ID CATEGORIA",
			(SELECT CARRERA FROM CARRERAS AS CARR WHERE CARR.ID = US.CARRERA) AS "CARRERA",
			(SELECT (SELECT DETALLES FROM ESTADO_PRESTAMOS AS EST_PRES WHERE EST_PRES.ID = PRES.ESTADO)
				FROM PRESTAMOS AS PRES WHERE US.ID = PRES.USUARIO ORDER BY PRES.ID DESC LIMIT 1) AS "ULTIMO PRESTAMO"
			FROM USUARIOS AS US;



-- Consulta para seleccionar los prestamos por sede (REPORTE 1) 
SELECT "BIBLIOTECA", COUNT(*) AS "PRESTAMOS TOTALES" 
	FROM "DETALLES PRESTAMOS" AS DP
	WHERE "FECHA PRESTAMO" <= TO_DATE('30-09-2024', 'DD-MM-YYYY') 
			AND "FECHA PRESTAMO" >= TO_DATE('01-09-2024', 'DD-MM-YYYY')
	GROUP BY "BIBLIOTECA"
	ORDER BY "BIBLIOTECA";

-- Consulta para seleccionar los SANCIONADOS por sede, FILTRANTO POR ESTADO (REPORTE 2) 
SELECT "BIBLIOTECA", "ESTADO", COUNT(*) AS "PRESTAMOS TOTALES" 
	FROM "DETALLES PRESTAMOS" AS DP
	WHERE "FECHA PRESTAMO" <= TO_DATE('30-09-2024', 'DD-MM-YYYY')
			AND "FECHA PRESTAMO" >= TO_DATE('01-09-2024', 'DD-MM-YYYY')
			AND DP."ESTADO" = 'SANCIONADO'
	GROUP BY  "ESTADO", "BIBLIOTECA";

-- Consulta para filtrar los libro por categoria. (REPORTE 3)
SELECT * FROM "DETALLES LIBROS" WHERE "ID CATEGORIA" = 1;

-- Consulta para filtar los usuarios por tipo (REPORTE 4)
SELECT * FROM "DETALLES USUARIOS" WHERE "ID CATEGORIA" = 2;


SELECT * FROM "DETALLES PRESTAMOS"

UPDATE PRESTAMOS SET FECHA_DEVOLUCION = TO_DATE('', 'DD-MM-YYYY'),ESTADO = 2 WHERE ID = 23;
