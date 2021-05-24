-- Table: public.entregas

-- DROP TABLE public.entregas;

CREATE TABLE public.entregas
(
    id bigint NOT NULL,
    cliente_id bigint NOT NULL,
    taxa numeric(10,2) NOT NULL,
    status character varying(20) COLLATE pg_catalog."default" NOT NULL,
    data_pedido date NOT NULL,
    data_finalizacao date,
    destinatario_nome character varying(60) COLLATE pg_catalog."default" NOT NULL,
    destinatario_logradouro character varying(255) COLLATE pg_catalog."default" NOT NULL,
    destinatario_numero character varying(30) COLLATE pg_catalog."default" NOT NULL,
    destinatario_complemento character varying(60) COLLATE pg_catalog."default" NOT NULL,
    destinatario_bairro character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT entregas_pkey PRIMARY KEY (id),
    CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id)
        REFERENCES public.clientes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.entregas
    OWNER to postgres;