@echo off

rem gerando backup
echo Gerando Backup
"C:\Program Files (x86)\MySQL\MySQL Server 5.5\bin\mysqldump" -u root -pabc123 bd_dcoracoes > C:\mysqlbackupdcoracoes\bkp_DCoracoesRestore.sql
rem restaurando backup
echo Resstaurando Backup no banco de teste
"C:\Program Files (x86)\MySQL\MySQL Server 5.5\bin\mysql" -u root -pabc123 bd_dcoracoes_teste < C:\mysqlbackupdcoracoes\bkp_DCoracoesRestore.sql

echo Banco de Teste Gerado com Sucesso!
pause
