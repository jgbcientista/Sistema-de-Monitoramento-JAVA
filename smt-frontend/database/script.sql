-- Cara Categorias

insert into categoria (nome) values('Educação');
insert into categoria (nome) values('Alimentação');
insert into categoria (nome) values('Moradia');
insert into categoria (nome) values('Entretenimento');
insert into categoria (nome) values('Veículo');
insert into categoria (nome) values('Vestuário');
insert into categoria (nome) values('Cuidados pessoais');

select *
from categoria;
-- delete from categoria;

-----------------------------------------------------------------------
-- Craga Fatura
insert into fatura (data_vencimento, valor, data_pagamento) values ('13/03/2019', 6055.73, '13/03/2019');

select * from fatura;

-----------------------------------------------------------------------
-- Carga lancamentos

select *
from lancamento;

-- Fatura do mês 03
insert into lancamento (estabelecimento, data, valor, categoria_id) values('TENDTUDO 09/10', '23/06/2018', 103.22, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('FERREIRA COSTA 08/10', '07/07/2018', 150.05, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('FERREIRA COSTA 08/10', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('ENOPP S*TOP MOVEIS 07/10', '18/08/2018', 204.7, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('COLCHÕES 06/10', '06/10/2018', 34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('EBANX-UDA 06/09', '06/09/2018', 92.4, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('FARMO 04/04', '20/11/2018', 91.25, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('LIVRARIA 03/03', '08/12/2018', 97.34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('SARAIVA 03/06', '08/12/2018', 38.35, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('LOJAS AMERICANAS', '21/12/2018', 244.82, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('VIA VAREJO', '22/12/2018', 259.9, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('DOCE LAR ENXOVAIS 03/04', '22/12/2018', 38.39, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('CRA CLOVES REBOQUE 03/03', '28/12/2018', 145.68, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('HAIR NATA', '26/01/2019', 90, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('PANIFICADORA AVENIDA', '03/02/2019', 14.93, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('hiper frango', '23/06/2018', 103.22, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('drogaria rio branco', '07/07/2018', 150.05, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('condental c odonto 01/03', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('jsm combustiveis', '18/08/2018', 204.7, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('drogaria rio branco', '06/10/2018', 34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('tudotec', '06/09/2018', 92.4, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('clube café', '20/11/2018', 91.25, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('mercado pago mercado li 01/10', '08/12/2018', 97.34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Pizzaria cheiro e sabor', '08/12/2018', 38.35, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Franbrasa', '21/12/2018', 244.82, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Internacional Travessia', '22/12/2018', 259.9, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Monumental Fitness', '22/12/2018', 38.39, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('JSM Combustíveis', '28/12/2018', 145.68, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Clube Café', '26/01/2019', 90, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('So Sabor', '03/02/2019', 14.93, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '23/06/2018', 103.22, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Siosiphone 01/03', '07/07/2018', 150.05, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Delícia de pão', '18/08/2018', 204.7, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Atakadão Atakarejo', '06/10/2018', 34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Atakadão Atakarejo', '06/09/2018', 92.4, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('INCOMAF Madereira 01/04', '20/11/2018', 91.25, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Morena Veículos', '08/12/2018', 97.34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('GR Revendedora de combustíveis', '08/12/2018', 38.35, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('UNICOM', '21/12/2018', 244.82, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('English Town 01/04', '21/12/2018', 244.82, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Internacional Travessia', '22/12/2018', 259.9, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Ecoposto Albatroz', '22/12/2018', 38.39, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Só Sabor', '28/12/2018', 145.68, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Clube Café', '26/01/2019', 90, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '23/06/2018', 103.22, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Delícias de Pão', '07/07/2018', 150.05, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Uber do Brasil Tecnolo', '22/07/2018', 117.61, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('C&A Modas', '06/10/2018', 34, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('99* POP', '06/09/2018', 92.4, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Cleber Manoel Olavo CA', '20/11/2018', 91.25, 3);
insert into lancamento (estabelecimento, data, valor, categoria_id) values('Maria do Carmo do Ros', '08/12/2018', 97.34, 3);


-- Fatura do mês 03/2018
