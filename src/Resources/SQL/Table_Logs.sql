-- Table: public.logs

-- DROP TABLE public.logs;

CREATE TABLE public.logs
(
    id integer NOT NULL DEFAULT nextval('logs_logid_seq'::regclass),
    date date,
    duration time without time zone,
    tourid integer,
    rating integer,
    weather text COLLATE pg_catalog."default",
    distance integer,
    transport text COLLATE pg_catalog."default",
    CONSTRAINT logs_pk PRIMARY KEY (id),
    CONSTRAINT logs_toursinfor_id_fk FOREIGN KEY (tourid)
        REFERENCES public.toursinfor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE public.logs
    OWNER to postgres;