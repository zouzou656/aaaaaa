@echo off
setlocal
mvn -P liberty package
"%LIBERTY_HOME%\bin\server" run defaultServer
