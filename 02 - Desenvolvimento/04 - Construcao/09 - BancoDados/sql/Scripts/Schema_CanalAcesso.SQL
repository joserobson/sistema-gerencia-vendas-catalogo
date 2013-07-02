DROP TABLE IF EXISTS tb_usuario
;
DROP TABLE IF EXISTS tb_associa_perfil_permissao
;
DROP TABLE IF EXISTS tb_permissao
;
DROP TABLE IF EXISTS tb_perfil
;



CREATE TABLE tb_usuario
(
	id INTEGER NOT NULL,
	login VARCHAR(10) NOT NULL,
	senha VARCHAR(10),
	id_pessoa INTEGER NOT NULL,
	id_perfil INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (login),
	KEY (id_perfil),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_associa_perfil_permissao
(
	id_perfil INTEGER NOT NULL,
	id_permissao INTEGER NOT NULL,
	status BOOL NOT NULL,
	PRIMARY KEY (id_perfil, id_permissao),
	KEY (id_perfil),
	KEY (id_permissao)
) 
;


CREATE TABLE tb_permissao
(
	id INTEGER NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;


CREATE TABLE tb_perfil
(
	id INTEGER NOT NULL,
	nomeperfil VARCHAR(50) NOT NULL,
	descricao VARCHAR(100),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;





ALTER TABLE tb_usuario ADD CONSTRAINT FK_tb_usuario_tb_perfil 
	FOREIGN KEY (id_perfil) REFERENCES tb_perfil (id)
;

ALTER TABLE tb_usuario ADD CONSTRAINT FK_tb_usuario_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_associa_perfil_permissao ADD CONSTRAINT FK_tb_associa_perfil_permissao_tb_perfil 
	FOREIGN KEY (id_perfil) REFERENCES tb_perfil (id)
;

ALTER TABLE tb_associa_perfil_permissao ADD CONSTRAINT FK_tb_associa_perfil_permissao_tb_permissao 
	FOREIGN KEY (id_permissao) REFERENCES tb_permissao (id)
;
