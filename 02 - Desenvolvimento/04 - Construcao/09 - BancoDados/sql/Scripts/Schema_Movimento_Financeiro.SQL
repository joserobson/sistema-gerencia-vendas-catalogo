DROP TABLE IF EXISTS tb_associa_pessoa_movimento
;
DROP TABLE IF EXISTS tb_movimento_financeiro
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
	id INTEGER NOT NULL,
	classe_name VARCHAR(100),
	agencia VARCHAR(20),
	banco VARCHAR(20),
	numero_conta VARCHAR(20),
	PRIMARY KEY (id),
	UNIQUE (id)
) 
;





ALTER TABLE tb_associa_pessoa_movimento ADD CONSTRAINT FK_tb_associa_pessoa_movimento_tb_movimento_financeiro 
	FOREIGN KEY (id_movimento) REFERENCES tb_movimento_financeiro (id)
;

ALTER TABLE tb_associa_pessoa_movimento ADD CONSTRAINT FK_tb_associa_pessoa_movimento_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;
