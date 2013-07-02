@echo off

set dia=%date:~0,2%
set mes=%date:~3,2%
set ano=%date:~6,4%
set hh=%time:~0,2%
if "%hh:~0,1%" == " " set hh=0%hh:~1,1%
set mm=%time:~3,2%
if "%mm:~0,1%" == " " set mm=0%mm:~1,1%
set ss=%time:~6,2%
if "%ss:~0,1%" == " " set ss=0%ss:~1,1%

set versao=%dia%_%mes%_%ano%_%hh%_%mm%_%ss%
rem gerando backup
"C:\Program Files\MySQL\MySQL Server 5.5\bin\mysqldump" -u root -pabc123 bd_dcoracoes > C:\DCoracoes\backupBD\bkp_%versao%.sql

echo Backup gerado com sucesso!
