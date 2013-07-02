DROP TABLE IF EXISTS tb_alerta
;



CREATE TABLE tb_alerta
(
	id INTEGER NOT NULL,
	assunto VARCHAR(200),
	id_usuario INTEGER NOT NULL,
	dataalerta DATETIME,
	descricao VARCHAR(200),
	protocolo INTEGER,
	situacao INTEGER NOT NULL,
	id_pessoa INTEGER NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	KEY (id_pessoa),
	KEY (id_usuario)
) 
;





ALTER TABLE tb_alerta ADD CONSTRAINT FK_tb_alerta_tb_pessoa 
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id)
;

ALTER TABLE tb_alerta ADD CONSTRAINT FK_tb_alerta_tb_usuario 
	FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id)
;
