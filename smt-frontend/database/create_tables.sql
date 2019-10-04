-- drop table categoria cascade;
create table categoria
(
    id serial PRIMARY KEY,
    nome VARCHAR (50) UNIQUE NOT NULL
);

--drop table fatura
create table fatura
(
	id serial PRIMARY KEY,
	data_vencimento date not null,
	valor double precision not null,
	data_pagamento date not null
)

-- drop table lancamento cascade;
CREATE TABLE lancamento
(
    id serial primary key,
    estabelecimento character varying(100) NOT NULL,
    data date,
    valor double precision,
    categoria_id integer,
	fatura date
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);


create table public.user
(
    id serial primary key,
    username varchar(32),
    password varchar(64)
);

