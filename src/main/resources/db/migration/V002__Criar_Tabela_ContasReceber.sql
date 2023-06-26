create table contasreceber(
    id int not null primary key auto_increment,
    dataconta date,
    valorconta decimal(12,2),
    idcliente int not null
);
