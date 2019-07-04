INSERT INTO usuario(celular, cpf_cnpj, departamento, dt_criacao, email, nome, password, rg, saldo, status, telefone, tipo_pessoa, instituicao_id, orientador_id) VALUES ('9999-9999', '12345678909', 'depto', CURRENT_DATE, 'admin@admin.com', 'João da Silva', '$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', '1234', 0.0, 'STATS', 'aa', 'aa', null, null);
INSERT INTO usuario(celular, cpf_cnpj, departamento, dt_criacao, email, nome, password, rg, saldo, status, telefone, tipo_pessoa, instituicao_id, orientador_id) VALUES ('9999-8888', '12345678999', 'depto', CURRENT_DATE, 'user@user.com', 'Carlos', '$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', '1234', 0.0, 'STATS', 'aa', 'aa', null, null);
INSERT INTO usuario(celular, cpf_cnpj, departamento, dt_criacao, email, nome, password, rg, saldo, status, telefone, tipo_pessoa, instituicao_id, orientador_id) VALUES ('9999-8888', '12345678999', 'depto', CURRENT_DATE, 'tecnico@tecnico.com', 'Tecnico', '$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', '1234', 0.0, 'STATS', 'aa', 'aa', null, null);
INSERT INTO usuario(celular, cpf_cnpj, departamento, dt_criacao, email, nome, password, rg, saldo, status, telefone, tipo_pessoa, instituicao_id, orientador_id) VALUES ('9999-8888', '12345678999', 'depto', CURRENT_DATE, 'recepcao@recepcao.com', 'Recepcionista', '$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem', '1234', 0.0, 'STATS', 'aa', 'aa', null, null);

insert into equipamento (nome) values ('Equipamento Teste');
insert into instituicao (cnpj, nome_fantasia, razao_social) values ('12345678000195', 'Instituição Teste', 'Instituição Teste LTDA');
insert into preco (tipo_pessoa, un_medida, valor, equipamento_id) values ('Tipo Pessoa', 'Unidade', 10.5, 1);
insert into modelo (nome, metodologia, resultado, preco_id) values ('Modelo teste', 'Texto do Modelo Teste', 'Resultado do Modelo Teste', 1);

insert into amostra (descricao, data_recebimento, usuario_id) values ('Amostra Teste', '2019-06-03 21:50:11.484', 1);


insert into permissao (nome) values ('ROLE_ADMIN');
insert into permissao (nome) values ('ROLE_SOLICITANTE');
insert into permissao (nome) values ('ROLE_TECNICO');
insert into permissao (nome) values ('ROLE_RECEPCIONISTA');

insert into usuario_permissoes (usuario_id, permissoes_id) values (1, 1);
insert into usuario_permissoes (usuario_id, permissoes_id) values (2, 2);
insert into usuario_permissoes (usuario_id, permissoes_id) values (3, 3);
insert into usuario_permissoes (usuario_id, permissoes_id) values (4, 4);


CREATE INDEX IDX_NOTA_01 ON nota (usuario_id, data_emissao);

INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (1, '/nota/nfe1.pdf','2019-07-01 19:10:25-07', '000000001', 'C', '5000', '2');
INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (2, '/nota/nfe2.pdf','2019-07-02 19:10:25-07', '000000002', 'D', '1200', '2');
INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (3, '/nota/nfe2.pdf','2019-07-02 19:10:25-07', '000000003', 'D', '250' , '2');
INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (4, '/nota/nfe1.pdf','2019-07-02 19:10:25-07', '000000004', 'D', '450',  '1');
INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (5, '/nota/nfe2.pdf','2019-07-03 19:10:25-07', '000000005', 'D', '1200', '1');
INSERT INTO nota(id, anexo, data_emissao, numero, tipo_nota, valor,usuario_id)	VALUES (6, '/nota/nfe2.pdf','2019-07-04 19:10:25-07', '000000006', 'C', '2500' , '1');




