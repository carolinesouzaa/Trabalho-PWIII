create table cliente (
    id      int             not null    auto_increment      primary key,
    nome    varchar(100)    not null
);

create table contaspag (
    id          int             not null    auto_increment      primary key,
    data        date            not null,
    data_exp    date            not null,
    idcliente    int,
    valor       decimal(12, 2)
);

alter table contaspag add constraint fk_contaspag_cliente foreign key(idcliente) references cliente(id);

insert into cliente(nome) values ("carol");
insert into contaspag(data, data_exp, idcliente, valor) values ("2006/08/18", "2006/09/18", 1, 199.90);
