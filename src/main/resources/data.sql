create table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 12396372),
    (2, 'Porto Alegre', 10000000),
    (3, 'Rio de Janeiro', 10000000),
    (4, 'Recife', 10000000);