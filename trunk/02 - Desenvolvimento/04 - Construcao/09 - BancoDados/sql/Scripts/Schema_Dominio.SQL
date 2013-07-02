DROP TABLE IF EXISTS tb_item_dominio
;
DROP TABLE IF EXISTS tb_dominio
;



CREATE TABLE tb_item_dominio
(
	id INTEGER NOT NULL,
	id_dominio INTEGER NOT NULL,
	item_dominio VARCHAR(100),
	PRIMARY KEY (id),
	KEY (id_dominio)
) 
;


CREATE TABLE tb_dominio
(
	id INTEGER NOT NULL,
	dominio VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
) 
;





ALTER TABLE tb_item_dominio ADD CONSTRAINT FK_tb_item_dominio_tb_dominio 
	FOREIGN KEY (id_dominio) REFERENCES tb_dominio (id)
;
