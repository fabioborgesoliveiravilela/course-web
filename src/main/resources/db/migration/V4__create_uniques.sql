alter table public.tab_pessoa add constraint unq_pessoa unique (email);

alter table public.tab_area add constraint unq_area unique (nome);

alter table public.tab_distrito add constraint unq_distrito unique (nome, id_concelho);

alter table public.tab_curso add constraint unq_curso unique (nome);