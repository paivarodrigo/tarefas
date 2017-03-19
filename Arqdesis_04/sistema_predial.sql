drop schema if exists sistema_predial;

create schema if not exists sistema_predial;

use sistema_predial;

create table if not exists tbempresa (
    idempresa integer(10) not null auto_increment,
    cnpj varchar(18) not null unique key,
    razaosocial varchar(150) not null,
    conjunto smallint not null unique key,
    horarioabertura time not null,
    horariofechamento time not null,
    temperaturapadrao decimal(4,2) not null,
    primary key(idempresa)
);

create table if not exists tbusuario (
    idusuario integer(10) not null auto_increment,
    matricula varchar(10) not null,
    nome varchar(150) not null,
    cpf varchar(11) not null unique key,
    rg varchar(9) not null,
    endereco varchar(250) not null,
    telefone varchar(15) not null,
    email varchar(50) not null,
    funcao varchar(100) not null,
    conjunto smallint not null,
    primary key(idusuario)
);

create table if not exists tbtemperatura (
    idtemperatura integer(10) not null auto_increment,
    temperaturaatual decimal(4,2) not null,
    temperaturamaxima decimal(4,2) not null,
    indligado smallint not null,
    conjunto smallint not null unique key,
    primary key(idtemperatura),
    constraint tbempresa_tbtemperatura_fk
    foreign key(conjunto)
    references tbempresa (conjunto)
    on delete no action
    on update no action
);

create table if not exists tbcontroleacesso (
    idcontroleacesso integer(10) not null auto_increment,
    horarioentrada timestamp not null,
    horariosaida timestamp not null,
    idusuario integer(10) not null,
    idempresa integer(10) not null,
    primary key(idcontroleacesso),
    constraint tbusuario_tbcontroleacesso_fk
    foreign key(idusuario)
    references tbusuario (idusuario),
    constraint tbempresa_tbcontroleacesso_fk
    foreign key(idempresa)
    references tbempresa (idempresa)
    on delete no action
    on update no action
);

select * from tbempresa;
select * from tbtemperatura;
select * from tbusuario;