-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
ROLLBACK;
BEGIN;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE IF NOT EXISTS public."Cargo"
(
    id_cargo UUID NOT NULL DEFAULT uuid_generate_v1(),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    descricao character varying COLLATE pg_catalog."default",
    CONSTRAINT pk_cargo PRIMARY KEY (id_cargo)
);

CREATE TABLE IF NOT EXISTS public.contato
(
    id_contato UUID NOT NULL DEFAULT uuid_generate_v1(),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    url_logo character varying COLLATE pg_catalog."default",
    CONSTRAINT pk_contato PRIMARY KEY (id_contato)
);

CREATE TABLE IF NOT EXISTS public.contato_egresso
(
    egresso_id UUID NOT NULL,
    contato_id UUID NOT NULL,
    CONSTRAINT pk_egresso_contato PRIMARY KEY (egresso_id, contato_id)
);

CREATE TABLE IF NOT EXISTS public.curso
(
    id_curso UUID NOT NULL DEFAULT uuid_generate_v1(),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    nivel character varying COLLATE pg_catalog."default" NOT NULL DEFAULT 'Graduação'::character varying,
    CONSTRAINT pk_curso PRIMARY KEY (id_curso)
);

CREATE TABLE IF NOT EXISTS public.curso_egresso
(
    egresso_id UUID NOT NULL,
    curso_id UUID NOT NULL,
    data_inicio date NOT NULL,
    data_conclusao date,
    CONSTRAINT pk_egresso_curso PRIMARY KEY (egresso_id, curso_id)
);

CREATE TABLE IF NOT EXISTS public.depoimento
(
    id_depoimento UUID NOT NULL DEFAULT uuid_generate_v1(),
    egresso_id UUID NOT NULL,
    texto character varying COLLATE pg_catalog."default" NOT NULL,
    data date NOT NULL,
    CONSTRAINT pk_depoimento PRIMARY KEY (id_depoimento)
);

CREATE TABLE IF NOT EXISTS public.egresso
(
    id_egresso UUID NOT NULL DEFAULT uuid_generate_v1(),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    cpf character varying COLLATE pg_catalog."default" NOT NULL,
    resumo character varying COLLATE pg_catalog."default",
    url_foto character varying COLLATE pg_catalog."default",
    CONSTRAINT pk_egresso PRIMARY KEY (id_egresso)
);

CREATE TABLE IF NOT EXISTS public.faixa_salario
(
    id_faixa_salario UUID NOT NULL DEFAULT uuid_generate_v1(),
    descricao character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_faixa_salario PRIMARY KEY (id_faixa_salario)
);

CREATE TABLE IF NOT EXISTS public.prof_egresso
(
    id_prof_egresso UUID NOT NULL DEFAULT uuid_generate_v1(),
    egresso_id UUID NOT NULL,
    cargo_id UUID NOT NULL,
    faixa_salario_id UUID NOT NULL,
    empresa character varying COLLATE pg_catalog."default",
    descricao character varying COLLATE pg_catalog."default",
    data_registro date NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT pk_prof_egresso PRIMARY KEY (id_prof_egresso)
);

COMMENT ON TABLE public.prof_egresso
    IS 'Consulta de informações dos egressos quanto aos cargos que desempenham atualmente e descrição de suas atividades';

ALTER TABLE IF EXISTS public.contato_egresso
    ADD CONSTRAINT fk_contato_egresso FOREIGN KEY (contato_id)
    REFERENCES public.contato (id_contato) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.contato_egresso
    ADD CONSTRAINT fk_egresso_contato FOREIGN KEY (egresso_id)
    REFERENCES public.egresso (id_egresso) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.curso_egresso
    ADD CONSTRAINT fk_curso_egresso FOREIGN KEY (curso_id)
    REFERENCES public.curso (id_curso) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.curso_egresso
    ADD CONSTRAINT fk_egresso_curso FOREIGN KEY (egresso_id)
    REFERENCES public.egresso (id_egresso) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.depoimento
    ADD CONSTRAINT fk_egresso FOREIGN KEY (egresso_id)
    REFERENCES public.egresso (id_egresso) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.prof_egresso
    ADD CONSTRAINT fk_cargo FOREIGN KEY (cargo_id)
    REFERENCES public."Cargo" (id_cargo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.prof_egresso
    ADD CONSTRAINT fk_egresso FOREIGN KEY (egresso_id)
    REFERENCES public.egresso (id_egresso) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.prof_egresso
    ADD CONSTRAINT fk_faixa_salario FOREIGN KEY (faixa_salario_id)
    REFERENCES public.faixa_salario (id_faixa_salario) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;