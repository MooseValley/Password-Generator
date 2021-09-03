REM -----------------------------
REM PasswordGenerator
REM -----------------------------
echo off
cls
REM

:STARTCOMPILE
echo "%dirlocation%"
del /q *.class
echo Create the Manifest file:
echo Main-Class: PasswordGenerator >MANIFEST.MF
echo .

echo Compile the Java code:
"%dirlocation%javac.exe" PasswordGenerator.java

echo .
echo Build the JAR file:
REM "%dirlocation%jar.exe" cvfm PasswordGenerator.jar MANIFEST.MF *.class *.png ..\icons\*.gif ..\icons\*.png  *.jpg PasswordGenerator*.txt
"%dirlocation%jar.exe" cfm PasswordGenerator.jar MANIFEST.MF *.class PasswordGenerator*.txt

REM
del /q *.class
del /q ..\00__common_code\*.class
REM del *.gif

:END
echo .
echo Finished!
pause