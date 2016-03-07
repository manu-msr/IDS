CREATE DATABASE idsp1
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

CREATE TABLE calificaciones (
	id_usuario integer NOT NULL,
  	promedio double precision,
  	CONSTRAINT calificaciones_pkey PRIMARY KEY (id_usuario));

CREATE TABLE usuario (
  id_usuario integer NOT NULL,
  correo_usuario character varying(200) NOT NULL,
  contrasenia_usuario character varying(200) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario));