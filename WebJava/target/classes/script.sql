
CREATE TABLE Funcionario
(
  id_funcionario integer NOT NULL,
  nome character(50) NOT NULL,
  CONSTRAINT pk_funcionario PRIMARY KEY (id_funcionario)
)
WITH (
  OIDS=false
);
ALTER TABLE Funcionario
  OWNER TO postgres;
--REVOKE ALL ON TABLE "Funcionario" FROM public;
--REVOKE ALL ON TABLE "Funcionario" FROM postgres;


CREATE TABLE "Ponto"
(
  id_ponto integer NOT NULL,
  data date,
  hora_1 time without time zone,
  hora_2 time without time zone,
  hora_3 time without time zone,
  hora_4 time without time zone,
  id_funcionario integer,
  CONSTRAINT pk_id_ponot PRIMARY KEY (id_ponto),
  CONSTRAINT fk_funcionario FOREIGN KEY (id_funcionario)
      REFERENCES Funcionario (id_funcionario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Ponto"
  OWNER TO postgres;

-- Index: fki_funcionario

-- DROP INDEX fki_funcionario;

CREATE INDEX fki_funcionario
  ON "Ponto"
  USING btree
  (id_funcionario);



CREATE SEQUENCE seq_id_func INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;
CREATE SEQUENCE seq_id_ponto INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1  CACHE 1;

ALTER TABLE "Funcionario" ALTER COLUMN id_funcionario SET DEFAULT NEXTVAL("seq_id_func"::regclass); 
ALTER TABLE "Ponto" ALTER COLUMN id_ponto SET DEFAULT NEXTVAL("seq_id_ponto"::regclass); 




CREATE SEQUENCE seq_funcionario   INCREMENT 1     MINVALUE 1     MAXVALUE 9223372036854775807     START 1     CACHE 1;
ALTER TABLE funcionario ALTER COLUMN id_funcionario SET DEFAULT NEXTVAL('seq_funcionario'); 

CREATE SEQUENCE seq_ponto   INCREMENT 1     MINVALUE 1     MAXVALUE 9223372036854775807     START 1     CACHE 1;
ALTER TABLE "Ponto" ALTER COLUMN id_ponto SET DEFAULT NEXTVAL('seq_ponto'); 

