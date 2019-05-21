insert into usuario (id,created_by, created_date, last_modified_by, last_modified_date, nome, senha, usuario) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', 'João da Silva', '$2a$10$X4r4k1x2J6QyJoasnl6p9.5kM0ej5WYAwVtj23YasquoqD2gTcqEW', 'joaosilva');
insert into equipamento (id, created_by, created_date, last_modified_by, last_modified_date, nome ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', 'Equipamento Teste' );
insert into instituicao (id, created_by, created_date, last_modified_by, last_modified_date, cnpj, nome_fantasia, razao_social ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', '12345678000195', 'Instituição Teste', 'Instituição Teste LTDA' );
insert into modelo (id, created_by, created_date, last_modified_by, last_modified_date, nome, metodologia, resultado ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', 'Modelo teste', 'Texto do Modelo Teste', 'Resultado do Modelo Teste' );
insert into permissoes (id, created_by, created_date, last_modified_by, last_modified_date, role_name ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', 'ROLE_ADMIN' );
insert into pessoa (id, created_by, created_date, last_modified_by, last_modified_date, celular, cpf_cnpj, departamento, nome, rg, status, telefone, instituicao_id, pessoa_id, usuario_id ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', '46999990000', '12345678909', 'Departamento', 'Pessoa Teste', '123456', 'Status', '4633333333', 1, null, 1 );
insert into preco (id, created_by, created_date, last_modified_by, last_modified_date, tipo_pessoa, un_medida, valor, equipamento_id ) values (1,'TESTE', '2019-05-21 19:10:11.484', 'TESTE', '2019-05-21 19:10:11.484', 'Tipo Pessoa', 'Unidade', 10.5, 1 );
insert into usuario_permissoes( id_usuario, id_permissao ) values ( 1, 1 );

select nextval( 'usuario_id_seq' );
select nextval( 'equipamento_id_seq' );
select nextval( 'instituicao_id_seq' );
select nextval( 'modelo_id_seq' );
select nextval( 'permissoes_id_seq' );
select nextval( 'pessoa_id_seq' );
select nextval( 'preco_id_seq' );