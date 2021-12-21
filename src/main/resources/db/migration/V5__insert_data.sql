insert into public.tab_area (id, nome) values (1, 'Exatas');
insert into public.tab_area (id, nome) values (2, 'Médica');
insert into public.tab_area (id, nome) values (3, 'Humanas');

insert into public.tab_distrito (id, nome, id_concelho, id_global_local)
                         values (1,'Aveiro', 5, 1010500);

insert into public.tab_pessoa (id, codigo_postal, data_nascimento, email, morada, nome, telemovel, id_distrito, created_on)
                       values (1, '12345678' , '1983-04-11', 'email@gmail.com' , 'Morada Teste 123', 'Fábio Borges Oliveira Vilela', '(34) 999 998 888', 1, '2021-12-21');

insert into public.tab_pessoa (id, codigo_postal, data_nascimento, email, morada, nome, telemovel, id_distrito, created_on)
                       values (2, '12345678' , '1984-12-19', 'email2@gmail.com' , 'Morada Teste 1234', 'João Batista da Silva', '(34) 999 998 888', 1, '2021-12-21');

insert into public.tab_professor (id, valor_aula)
                          values (1, 155.00);

insert into public.tab_aluno (id, fotografia)
                        values (2, null);

insert into public.tab_usuario (id, nif, senha)
                         values (1, 'foliveiv' , '$2a$10$WQrrmtje3pffGtSXP05hOOkNxf7ThIfMGLoHxfXNgIgh81gcOrSg6');

insert into public.tab_usuario (id, nif, senha)
                         values (2, 'jbatists' , '$2a$10$WQrrmtje3pffGtSXP05hOOkNxf7ThIfMGLoHxfXNgIgh81gcOrSg6');