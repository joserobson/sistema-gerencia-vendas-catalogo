DROP TABLE IF EXISTS tb_telefone
;
DROP TABLE IF EXISTS tb_revendedor
;
DROP TABLE IF EXISTS tb_endereco
;
DROP TABLE IF EXISTS tb_email
;
DROP TABLE IF EXISTS tb_associa_pessoa
;
DROP TABLE IF EXISTS tb_pessoa
;



CREATE TABLE tb_telefone
(
	id INTEGER NOT NULL,
	numero VARCHAR(20),
	operadora VARCHAR(50),
	id_tipo INTEGER,
	id_pessoa INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_revendedor
(
	id INTEGER NOT NULL,
	codigo INTEGER,
	codigo_confiscal BIGINT,
	data_cadastro DATETIME,
	data_ultima_compra DATETIME,
	limite_credito FLOAT(0),
	limite_emuso FLOAT(0),
	limite_utilizavel FLOAT(0),
	id_pessoa INTEGER NOT NULL,
	numero_nota_fiscal VARCHAR(50),
	observacoes VARCHAR(200),
	id_situacao INTEGER,
	id_estado_civil INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_endereco
(
	id INTEGER NOT NULL,
	id_pessoa INTEGER NOT NULL,
	cep VARCHAR(20),
	cidade VARCHAR(150),
	complemento VARCHAR(50),
	estado VARCHAR(2),
	numero VARCHAR(10),
	rua VARCHAR(150),
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_email
(
	id INTEGER NOT NULL,
	id_pessoa INTEGER NOT NULL,
	endereco_email VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_associa_pessoa
(
	id_pessoa_associada INTEGER NOT NULL,
	id_pessoa_associante INTEGER NOT NULL,
	grau_associacao VARCHAR(50),
	KEY (id_pessoa_associada),
	KEY (id_pessoa_associante)
) 
;


CREATE TABLE tb_pessoa
(
	id INTEGER NOT NULL,
	classe_name VARCHAR(50),
	nome VARCHAR(150),
	cpf VARCHAR(20),
	data_nascimento DATETIME,
	identidade VARCHAR(50),
	cnpj VARCHAR(20),
	inscricao_estadual VARCHAR(20),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;





ALTER TABLE tb_telefone ADD CONSTRAINT FK_tb_telefone_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_revendedor ADD CONSTRAINT FK_tb_revendedor_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_endereco ADD CONSTRAINT FK_tb_endereco_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_email ADD CONSTRAINT FK_tb_email_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_associa_pessoa ADD CONSTRAINT FK_tb_associa_pessoa_tb_pessoa_associada 
	FOREIGN KEY (id_pessoa_associada) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_associa_pessoa ADD CONSTRAINT FK_tb_associa_pessoa_tb_pessoa_associante 
	FOREIGN KEY (id_pessoa_associante) REFERENCES tb_pessoa (id)
;
