--------------------------------------------------------
--  Arquivo criado - Quinta-feira-Junho-18-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View VW_INCNF_INTERFACE_CLAIM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_INCNF_INTERFACE_CLAIM" ("SEQ_NFE", "NUM_NF", "SERIE", "CNPJ_CLIENTE", "NUM_NF_ORIGINAL") AS 
  select bis.SEQ_NFE, bis.NUM_NF, bis.SERIE, emit.CNPJ_CLIENTE, bis.NUM_NF_ORIGINAL
from 
BIS_NOTA_FISCAL bis, BIS_EMIT emit
where bis.SEQ_NFE = emit.SEQ_NFE
AND bis.COD_STATUS = 100;
--------------------------------------------------------
--  DDL for View VW_INCNF_INTERFACE_GR
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_INCNF_INTERFACE_GR" ("SEQ_NFE", "RDO") AS 
  select bis.SEQ_NFE, bis.RDO
from 
BIS_NOTA_FISCAL bis
WHERE bis.COD_STATUS = 300 AND 
bis.RDO IS NOT NULL;
--------------------------------------------------------
--  DDL for View VW_INCNF_INTERFACE_RDO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_INCNF_INTERFACE_RDO" ("SEQ_NFE", "NUM_NF", "SERIE", "CNPJ_CLIENTE", "NUM_NF_ORIGINAL") AS 
  select bis.SEQ_NFE, bis.NUM_NF, bis.SERIE, emit.CNPJ_CLIENTE, bis.NUM_NF_ORIGINAL
from 
BIS_NOTA_FISCAL bis, BIS_EMIT emit
where bis.SEQ_NFE = emit.SEQ_NFE
AND (bis.COD_STATUS = 100
OR bis.COD_STATUS = 200);
--------------------------------------------------------
--  DDL for View VW_INCNF_INTERFACE_RMA
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_INCNF_INTERFACE_RMA" ("SEQ_NFE", "NUM_NF", "SERIE", "CNPJ_CLIENTE", "NUM_NF_ORIGINAL") AS 
  select bis.SEQ_NFE, bis.NUM_NF, bis.SERIE, emit.CNPJ_CLIENTE, bis.NUM_NF_ORIGINAL
from 
BIS_NOTA_FISCAL bis, BIS_EMIT emit
where bis.SEQ_NFE = emit.SEQ_NFE
AND bis.COD_STATUS = 100;
--------------------------------------------------------
--  DDL for View VW_TSS_NFINC_CLAIM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_TSS_NFINC_CLAIM" ("RET_NF_NO", "RET_NF_SERIE", "CNPJ_SHIP_TO", "DO", "NF_ORIG", "RDO") AS 
  SELECT 
    "RET_NF_NO","RET_NF_SERIE","CNPJ_SHIP_TO","DO","NF_ORIG","RDO"
FROM 
  TB_TSS_NFINC_CLAIM;
--------------------------------------------------------
--  DDL for View VW_TSS_NFINC_GR
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_TSS_NFINC_GR" ("RDO", "RET_GR_UPDATE_DATE") AS 
  SELECT 
    "RDO","RET_GR_UPDATE_DATE"
FROM 
  TB_TSS_NFINC_GR;
--------------------------------------------------------
--  DDL for View VW_TSS_NFINC_RDO
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_TSS_NFINC_RDO" ("RET_NF_NO", "RET_NF_SERIE", "CNPJ_SHIP_TO", "DO", "NF_ORIG", "RDO") AS 
  SELECT 
    "RET_NF_NO","RET_NF_SERIE","CNPJ_SHIP_TO","DO","NF_ORIG","RDO"
FROM 
  TB_TSS_NFINC_RDO;
--------------------------------------------------------
--  DDL for View VW_TSS_NFINC_RMA
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "HR"."VW_TSS_NFINC_RMA" ("RET_NF_NO", "RET_NF_SERIE", "CNPJ_SHIP_TO", "DO", "NF_ORIG", "RMA") AS 
  SELECT 
    "RET_NF_NO","RET_NF_SERIE","CNPJ_SHIP_TO","DO","NF_ORIG","RMA"
FROM 
    TB_TSS_NFINC_RMA;
