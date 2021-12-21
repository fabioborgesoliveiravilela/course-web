create table public.tab_aluno (
   fotografia LONGBLOB  null,
    id integer not null,
    primary key (id)
);

create table public.tab_area (
   id integer not null,
    nome varchar(255) not null,
    primary key (id)
);

create table public.tab_curso (
   id integer not null,
    descricao varchar(255) not null,
    inicio date not null,
    nome varchar(255) not null,
    situacao integer not null,
    termino date not null,
    vagas integer not null,
    id_area integer not null,
    id_distrito integer not null,
    created_on timestamp not null,
    updated_on timestamp null,
    inactivated_on timestamp null,
    primary key (id)
);

create table public.tab_distrito (
   id integer not null,
    nome varchar(255) not null,
    id_concelho integer not null,
    id_global_local integer not null,
    primary key (id)
);

create table public.tab_pessoa (
   id integer not null,
    codigo_postal varchar(255) not null,
    data_nascimento date not null,
    email varchar(255) not null,
    morada varchar(255) not null,
    nome varchar(255) not null,
    telemovel varchar(255) not null,
    id_distrito integer not null,
    created_on timestamp not null,
    updated_on timestamp null,
    inactivated_on timestamp null,
    primary key (id)
);

create table public.tab_professor (
   valor_aula decimal(19,2) not null,
    id integer not null,
    primary key (id)
);

create table public.tab_usuario (
   nif varchar(255) not null,
    senha varchar(255) not null,
    id integer not null,
    primary key (id)
);

create table public.tab_matricula (
   id integer not null,
    id_aluno integer not null,
    id_curso integer not null,
    primary key (id)
);

create table public.rel_professores (
   id_matricula integer not null,
    id_professor integer not null
);

create table public.tab_historico (
   id integer not null,
    data timestamp not null,
    id_objeto varchar(255) not null,
    tipo_objeto varchar(255) not null,
    objeto text not null,
    primary key (id)
);