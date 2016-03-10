@echo off
javac exp2/Order.java
:1
set /p a=
java exp2.Order %a%
set a=<nul
goto 1
pause