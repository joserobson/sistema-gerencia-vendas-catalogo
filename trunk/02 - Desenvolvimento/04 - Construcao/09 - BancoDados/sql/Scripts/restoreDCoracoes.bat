@echo off

rem restaurando backup
"C:\Program Files\MySQL\MySQL Server 5.5\bin\mysql" -u root -pabc123 bd_dcoracoes < C:\DCoracoes\backupBD\"NOME_ARQUIVO".sql

echo Backup restaurado com sucesso!
pause
