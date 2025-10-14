@echo off
setlocal
mvn -P wildfly package
"%WILDFLY_HOME%\bin\standalone.bat" -c standalone-full.xml
