alter table public.tab_aluno
   add constraint FK2dmtvwock8ebto9hirymcypvg
   foreign key (id)
   references public.tab_pessoa;

alter table public.tab_curso
   add constraint FK6wbf611q7vumx3k40682we8nw
   foreign key (id_area)
   references public.tab_area;

alter table public.tab_curso
   add constraint FKftc2v8ha2sodvar2ibhsd2vln
   foreign key (id_distrito)
   references public.tab_distrito;

alter table public.tab_pessoa
   add constraint FK7ngkt2s1184dw62a4slhm5ywu
   foreign key (id_distrito)
   references public.tab_distrito;

alter table public.tab_professor
   add constraint FK5bek1367abthedjjy82pb8rs2
   foreign key (id)
   references public.tab_pessoa;

alter table public.tab_usuario
   add constraint FK866l6fs4w048j09h2vgggvplj
   foreign key (id)
   references public.tab_pessoa;

alter table public.tab_matricula
   add constraint FKinuupaiap2w0cycqjv016pu2o
   foreign key (id_curso)
   references public.tab_curso;

alter table public.tab_matricula
    add constraint FKp83j7hkr8gcy20ucux6tek0v0
    foreign key (id_aluno)
    references public.tab_aluno;

alter table public.rel_professores
    add constraint FKeviyxn5ep1q64hjh94gc8t7qq
    foreign key (id_professor)
    references public.tab_professor;

alter table public.rel_professores
    add constraint FKmrglh7c1x2c3r6w84b9kha8q2
    foreign key (id_matricula)
    references public.tab_matricula;