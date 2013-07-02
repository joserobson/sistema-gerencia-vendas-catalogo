DROP TABLE IF EXISTS tb_item_produto
;
DROP TABLE IF EXISTS tb_associa_produto_cor
;
DROP TABLE IF EXISTS tb_produto
;
DROP TABLE IF EXISTS tb_fornecedor
;
DROP TABLE IF EXISTS tb_cor
;



CREATE TABLE tb_item_produto
(
	id INTEGER NOT NULL,
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


CREATE TABLE tb_associa_produto_cor
(
	id_produto INTEGER NOT NULL,
	id_cor INTEGER NOT NULL,
	estoque_atual INTEGER NOT NULL,
	estoque_minimo INTEGER NOT NULL,
	KEY (id_cor),
	KEY (id_produto)
) 
;


CREATE TABLE tb_produto
(
	id INTEGER NOT NULL,
	codigo_barra VARCHAR(20),
	codigo_for_fiscal VARCHAR(20),
	codigo_pro_fiscal VARCHAR(20),
	descricao VARCHAR(150),
	estoque_total INTEGER,
	referencia_catalogo VARCHAR(20),
	id_fornecedor INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_fornecedor)
) 
;


CREATE TABLE tb_fornecedor
(
	id INTEGER NOT NULL,
	codigo VARCHAR(20),
	id_pessoa INTEGER,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa)
) 
;


CREATE TABLE tb_cor
(
	id INTEGER NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	cor VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;





ALTER TABLE tb_item_produto ADD CONSTRAINT FK_tb_item_produto_tb_cor 
	FOREIGN KEY (id_cor) REFERENCES tb_cor (id)
;

ALTER TABLE tb_item_produto ADD CONSTRAINT FK_tb_item_produto_tb_produto 
	FOREIGN KEY (id_produto) REFERENCES tb_produto (id)
;

ALTER TABLE tb_associa_produto_cor ADD CONSTRAINT FK_tb_associa_produto_cor_tb_cor 
	FOREIGN KEY (id_cor) REFERENCES tb_cor (id)
;

ALTER TABLE tb_associa_produto_cor ADD CONSTRAINT FK_tb_associa_produto_cor_tb_produto 
	FOREIGN KEY (id_produto) REFERENCES tb_produto (id)
;

ALTER TABLE tb_produto ADD CONSTRAINT FK_tb_produto_tb_fornecedor 
	FOREIGN KEY (id_fornecedor) REFERENCES tb_fornecedor (id)
;

ALTER TABLE tb_fornecedor ADD CONSTRAINT FK_tb_fornecedor_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;
