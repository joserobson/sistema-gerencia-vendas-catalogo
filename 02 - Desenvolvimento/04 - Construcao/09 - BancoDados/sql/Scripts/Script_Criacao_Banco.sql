DROP TABLE IF EXISTS tb_item_pedido
;
DROP TABLE IF EXISTS tb_pedido
;
DROP TABLE IF EXISTS tb_parcela
;
DROP TABLE IF EXISTS tb_pagamento
;
DROP TABLE IF EXISTS tb_codigo_item
;
DROP TABLE IF EXISTS tb_item_produto
;
DROP TABLE IF EXISTS tb_produto
;
DROP TABLE IF EXISTS tb_fornecedor
;
DROP TABLE IF EXISTS tb_cor
;
DROP TABLE IF EXISTS tb_telefone
;
DROP TABLE IF EXISTS tb_alerta
;
DROP TABLE IF EXISTS tb_revendedor
;
DROP TABLE IF EXISTS tb_endereco
;
DROP TABLE IF EXISTS tb_email
;
DROP TABLE IF EXISTS tb_associa_pessoa
;
DROP TABLE IF EXISTS tb_item_dominio
;
DROP TABLE IF EXISTS tb_dominio
;
DROP TABLE IF EXISTS tb_associa_pessoa_movimento
;
DROP TABLE IF EXISTS tb_movimento_financeiro
;
DROP TABLE IF EXISTS tb_usuario
;
DROP TABLE IF EXISTS tb_associa_perfil_permissao
;
DROP TABLE IF EXISTS tb_permissao
;
DROP TABLE IF EXISTS tb_perfil
;
DROP TABLE IF EXISTS tb_pessoa
;

CREATE TABLE tb_item_pedido
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	cor VARCHAR(50),
	descricao VARCHAR(100),
	quantidade INTEGER,
	id_codigo_item INTEGER NOT NULL,
	valor_unitario FLOAT(10),
	id_pedido INTEGER NOT NULL,
	id_item_produto INTEGER NOT NULL,
  valor_total Float(10),
  cor_extenso Varchar(100),
  codigo_fiscal Varchar(20),    
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_codigo_item),
	KEY (id_pedido)
) 
;


CREATE TABLE tb_pedido
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	codigo VARCHAR(20) NOT NULL,
	data_pedido DATETIME,
	id_pagamento INTEGER,
	id_revendedor INTEGER,
	sub_total FLOAT(10) NOT NULL,
	total FLOAT(10) NOT NULL,
	valor_pedido_escrito FLOAT(10),
	classe_name VARCHAR(100) NOT NULL,
	desconto_dinheiro FLOAT(10),
	desconto_porcentagem FLOAT(10),
	id_fornecedor INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_revendedor),
	KEY (id_fornecedor),
	KEY (id_pagamento)
) 
;


CREATE TABLE tb_parcela
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	data_vencimento DATE NOT NULL,
	status INTEGER NOT NULL,
	valor FLOAT(10) NOT NULL,
	id_pagamento INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pagamento)
) 
;


CREATE TABLE tb_pagamento
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_forma_pagamento INTEGER NOT NULL,
    valor FLOAT(10) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;


CREATE TABLE tb_codigo_item
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	codigo VARCHAR(50) NOT NULL,
	tipo INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;

CREATE TABLE tb_alerta
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	assunto VARCHAR(200),
	id_usuario INTEGER NOT NULL,
	dataalerta DATETIME,
	descricao VARCHAR(200),
	protocolo VARCHAR(11),
	situacao INTEGER NOT NULL,
	id_pessoa INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa),
	KEY (id_usuario)
) 
;


CREATE TABLE tb_telefone
(
	id INTEGER NOT NULL AUTO_INCREMENT,
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
	id INTEGER NOT NULL AUTO_INCREMENT,
	codigo INTEGER,
	codigo_confiscal VARCHAR(30),
	data_cadastro DATETIME,
	data_ultima_compra DATETIME,
	limite_credito FLOAT(0),
	limite_emuso FLOAT(0),
	limite_utilizavel FLOAT(0),
	id_pessoa INTEGER NOT NULL,
	numero_nota_fiscal VARCHAR(50),
	observacoes Text,
	id_situacao INTEGER,
	id_estado_civil INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_endereco
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_pessoa INTEGER NOT NULL,
	cep VARCHAR(20),
	cidade VARCHAR(150),
	complemento VARCHAR(50),
	estado VARCHAR(2),
	numero VARCHAR(10),
	rua VARCHAR(150),
	bairro VARCHAR(50),
	referencia VARCHAR(150),
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_email
(
	id INTEGER NOT NULL AUTO_INCREMENT,
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
	id INTEGER NOT NULL AUTO_INCREMENT,
	classe_name VARCHAR(50),
	nome VARCHAR(150),
	cpf VARCHAR(20),
	data_nascimento DATETIME,
	identidade VARCHAR(50),
    id_estado_civil INTEGER,
	cnpj VARCHAR(20),
	inscricao_estadual VARCHAR(20),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;

CREATE TABLE tb_associa_pessoa_movimento
(
	id_pessoa INTEGER NOT NULL,
	id_movimento INTEGER NOT NULL,
	titularidade INTEGER,
	KEY (id_movimento),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_movimento_financeiro
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	classe_name VARCHAR(100),
	agencia VARCHAR(20),
	banco VARCHAR(20),
	numero_conta VARCHAR(20),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;

CREATE TABLE tb_item_dominio
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_dominio INTEGER NOT NULL,
	item_dominio VARCHAR(100),
	PRIMARY KEY (id),
	KEY (id_dominio)
) 
;


CREATE TABLE tb_dominio
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	dominio VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
) 
;

CREATE TABLE tb_usuario
(
	id INTEGER NOT NULL AUTO_INCREMENT,
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
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;


CREATE TABLE tb_perfil
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	nomeperfil VARCHAR(50) NOT NULL,
	descricao VARCHAR(100),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;

CREATE TABLE tb_item_produto
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	id_produto INTEGER NOT NULL,
	id_cor INTEGER NOT NULL,
	estoque_minimo INTEGER,
	estoque_atual INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_cor),
	KEY (id_produto)
) 
;


CREATE TABLE tb_produto
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	codigo_barra VARCHAR(20),
	codigo_for_fiscal VARCHAR(20),
	codigo_pro_fiscal VARCHAR(20),
	descricao VARCHAR(150),
	estoque_total INTEGER,
	referencia_catalogo VARCHAR(20),
	id_fornecedor INTEGER,
  valor_custo Float,
  valor_venda Float,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_fornecedor)
) 
;


CREATE TABLE tb_fornecedor
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	codigo VARCHAR(20),
	id_pessoa INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_cor
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(100) NOT NULL,
  codigo VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;


ALTER TABLE tb_item_pedido ADD CONSTRAINT FK_tb_item_pedido_tb_codigo_item 
	FOREIGN KEY (id_codigo_item) REFERENCES tb_codigo_item (id)
;

ALTER TABLE tb_item_pedido ADD CONSTRAINT FK_tb_item_venda_tb_movimento_pedido 
	FOREIGN KEY (id_pedido) REFERENCES tb_pedido (id)
;

ALTER TABLE tb_pedido ADD CONSTRAINT FK_tb_movimento_pedido_tb_revendedor 
	FOREIGN KEY (id_revendedor) REFERENCES tb_revendedor (id)
;

ALTER TABLE tb_pedido ADD CONSTRAINT FK_tb_pedido_tb_fornecedor 
	FOREIGN KEY (id_fornecedor) REFERENCES tb_fornecedor (id)
;

ALTER TABLE tb_pedido ADD CONSTRAINT FK_tb_pedido_tb_pagamento 
	FOREIGN KEY (id_pagamento) REFERENCES tb_pagamento (id)
;

ALTER TABLE tb_parcela ADD CONSTRAINT FK_tb_parcela_tb_pagamento 
	FOREIGN KEY (id_pagamento) REFERENCES tb_pagamento (id)
;

ALTER TABLE tb_alerta ADD CONSTRAINT FK_tb_alerta_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_alerta ADD CONSTRAINT FK_tb_alerta_tb_usuario 
	FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id)
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


ALTER TABLE tb_associa_pessoa_movimento ADD CONSTRAINT FK_tb_associa_pessoa_movimento_tb_movimento_financeiro 
	FOREIGN KEY (id_movimento) REFERENCES tb_movimento_financeiro (id)
;

ALTER TABLE tb_associa_pessoa_movimento ADD CONSTRAINT FK_tb_associa_pessoa_movimento_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_item_dominio ADD CONSTRAINT FK_tb_item_dominio_tb_dominio 
	FOREIGN KEY (id_dominio) REFERENCES tb_dominio (id)
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

ALTER TABLE tb_item_produto ADD CONSTRAINT FK_tb_item_produto_tb_cor 
	FOREIGN KEY (id_cor) REFERENCES tb_cor (id)
;

ALTER TABLE tb_item_produto ADD CONSTRAINT FK_tb_item_produto_tb_produto 
	FOREIGN KEY (id_produto) REFERENCES tb_produto (id)
;

ALTER TABLE tb_produto ADD CONSTRAINT FK_tb_produto_tb_fornecedor 
	FOREIGN KEY (id_fornecedor) REFERENCES tb_fornecedor (id)
;

ALTER TABLE tb_fornecedor ADD CONSTRAINT FK_tb_fornecedor_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;