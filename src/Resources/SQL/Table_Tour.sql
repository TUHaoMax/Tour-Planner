-- Table: public.toursinfor

-- DROP TABLE public.toursinfor;

CREATE TABLE public.toursinfor
(
    name text COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('toursinfor_id_seq'::regclass),
    departure text COLLATE pg_catalog."default",
    destination text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    CONSTRAINT toursinfor_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.toursinfor
    OWNER to postgres;