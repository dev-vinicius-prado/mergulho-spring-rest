CREATE TABLE public.ocorrencias
(
    id bigint NOT NULL,
    entrega_id bigint NOT NULL,
    descricao text NOT NULL,
    data_registro date NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_ocorrencia_entrega FOREIGN KEY (entrega_id)
        REFERENCES public.entregas (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.ocorrencias
    OWNER to postgres;