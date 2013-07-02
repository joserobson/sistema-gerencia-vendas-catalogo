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



CREATE TABLE tb_item_pedido
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	cor VARCHAR(50),
	descricao VARCHAR(100),
	quantidade INTEGER,
	id_codigo_item INTEGER NOT NULL,
	valor_unitario FLOAT(0),
	id_pedido INTEGER NOT NULL,
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
