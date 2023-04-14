@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17.0.1
set path=C:\Users\yogy7\.m2\repository\allure\allure-2.20.1\bin;%JAVA_HOME%\bin;%path%
allure serve allure-results
pause
exit