/* INSERTS TABELAS DE DOMINIO - ENUNS DA APLICACAO*/
INSERT INTO tb_dominio VALUES(1,'TIPOTELEFONE');
INSERT INTO tb_dominio VALUES(2,'SITUACAOREVENDEDOR');
INSERT INTO tb_dominio VALUES(3,'ESTADOCIVIL');
INSERT INTO tb_dominio VALUES(4,'TITULARIDADE');
INSERT INTO tb_dominio VALUES(5,'SITUACAOALERTA');
INSERT INTO tb_dominio VALUES(6,'FORMAPAGAMENTO');
INSERT INTO tb_dominio VALUES(7,'SITUACAOPARCELA');
INSERT INTO tb_dominio VALUES(8,'TIPOCODIGO');


/*INSERTS TABELAS DE ITEM DE DOMINIO */
/*DOMINIO TIPO TELEFONE */
INSERT INTO TB_ITEM_DOMINIO VALUES(11,1,'RESIDENCIAL');
INSERT INTO TB_ITEM_DOMINIO VALUES(12,1,'COMERCIAL');
INSERT INTO TB_ITEM_DOMINIO VALUES(13,1,'CELULAR');

/*DOMINIO SITUACAOREVENDEDOR */
INSERT INTO TB_ITEM_DOMINIO VALUES(21,2,'ATIVO');
INSERT INTO TB_ITEM_DOMINIO VALUES(22,2,'INATIVO');


/*DOMINIO ESTADO CIVIL */
INSERT INTO TB_ITEM_DOMINIO VALUES(31,3,'CASADO');
INSERT INTO TB_ITEM_DOMINIO VALUES(32,3,'SOLTEIRO');
INSERT INTO TB_ITEM_DOMINIO VALUES(33,3,'SEPARADO');
INSERT INTO TB_ITEM_DOMINIO VALUES(34,3,'DIVORCIADO');
INSERT INTO TB_ITEM_DOMINIO VALUES(35,3,'UNIAOESTAVEL');

/*DOMINIO TITULARIDADE */
INSERT INTO TB_ITEM_DOMINIO VALUES(41,4,'PRIMEIRO_TITULAR');
INSERT INTO TB_ITEM_DOMINIO VALUES(42,4,'SEGUNDO_TITULAR');

/*DOMINIO SITUACAO ALERTA */
INSERT INTO TB_ITEM_DOMINIO VALUES(51,5,'RESOLVIDO');
INSERT INTO TB_ITEM_DOMINIO VALUES(52,5,'EMALERTA');

/*DOMINIO FORMA PAGAMENTO*/
INSERT INTO TB_ITEM_DOMINIO VALUES(61,6,'AVISTA');
INSERT INTO TB_ITEM_DOMINIO VALUES(62,6,'APRAZO');
INSERT INTO TB_ITEM_DOMINIO VALUES(63,6,'APRAZOCOMCOMPLEMENTO');

/*DOMINIO SITUACAO PARCELA*/
INSERT INTO TB_ITEM_DOMINIO VALUES(71,7,'PENDENTE');
INSERT INTO TB_ITEM_DOMINIO VALUES(72,7,'QUITADA');

/*DOMINIO TIPO CODIGO*/
INSERT INTO TB_ITEM_DOMINIO VALUES(81,8,'REFERENCIA_CATALOGO');
INSERT INTO TB_ITEM_DOMINIO VALUES(82,8,'CODIGO_PROFISCAL');
INSERT INTO TB_ITEM_DOMINIO VALUES(83,8,'CODIGO_FORNECEDOR');
INSERT INTO TB_ITEM_DOMINIO VALUES(84,8,'CODIGO_FORFISCAL');
INSERT INTO TB_ITEM_DOMINIO VALUES(85,8,'CODIGO_BARRAS');

/*INSERIR PERFIL DE ADMINISTRADOR*/
INSERT INTO tb_perfil (id,nomeperfil,descricao) VALUES (1,'ADMINISTRADOR','ADMINISTRADOR DO SISTEMA');

/*INSERT PESSOA ADMINISTRADOR*/
INSERT INTO `bd_dcoracoes`.`tb_pessoa`(`id`,`classe_name`,`nome`,`cpf`,`data_nascimento`,`identidade`,`id_estado_civil`)
VALUES(1,'Pessoa','CICERO','123',null,null,null);

/*INSERT USUARIO ADMINISTRADOR*/
INSERT INTO `bd_dcoracoes`.`tb_usuario`(`id`,`login`,`senha`,`id_pessoa`,`id_perfil`)
VALUES(1,'CICERO','123',1,1);

/*INSERT PERMISSOES DO SISTEMA*/
INSERT INTO tb_permissao(id,descricao) VALUES (1,'Cadastrar Revendedor');
INSERT INTO tb_permissao(id,descricao) VALUES (2,'Consultar Revendedor');
INSERT INTO tb_permissao(id,descricao) VALUES (3,'Remover Revendedor');

INSERT INTO tb_permissao(id,descricao) VALUES (4,'Cadastrar Produto');
INSERT INTO tb_permissao(id,descricao) VALUES (5,'Consultar Produto');
INSERT INTO tb_permissao(id,descricao) VALUES (6,'Remover Produto');

INSERT INTO tb_permissao(id,descricao) VALUES (7,'Cadastrar Perfil');
INSERT INTO tb_permissao(id,descricao) VALUES (8,'Consultar Perfil');
INSERT INTO tb_permissao(id,descricao) VALUES (9,'Deletar Perfil');

INSERT INTO tb_permissao(id,descricao) VALUES (10,'Cadastrar Usuario');
INSERT INTO tb_permissao(id,descricao) VALUES (11,'Consultar Usuario');
INSERT INTO tb_permissao(id,descricao) VALUES (12,'Deletar Usuario');

INSERT INTO tb_permissao(id,descricao) VALUES (13,'Cadastrar Venda');
INSERT INTO tb_permissao(id,descricao) VALUES (14,'Consultar Venda');

INSERT INTO tb_permissao(id,descricao) VALUES (15,'Cadastrar Compra');
INSERT INTO tb_permissao(id,descricao) VALUES (16,'Consultar Compra');

INSERT INTO tb_permissao(id,descricao) VALUES (17,'Cadastrar Prospecções');
INSERT INTO tb_permissao(id,descricao) VALUES (18,'Consultar Prospecções');
INSERT INTO tb_permissao(id,descricao) VALUES (19,'Deletar Prospecções');

/*Vincular permissoes ao Administrador*/
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,1,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,2,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,3,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,4,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,5,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,6,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,7,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,8,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,9,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,10,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,11,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,12,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,13,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,14,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,15,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,16,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,17,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,18,true);
INSERT INTO `bd_dcoracoes`.`tb_associa_perfil_permissao`(`id_perfil`,`id_permissao`,`status`)VALUES(1,19,true);



