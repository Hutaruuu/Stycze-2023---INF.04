@echo off
set "APP_HOME=%~dp0"
set "WRAPPER=%APP_HOME%gradle\wrapper\gradle-wrapper.jar"
if not exist "%WRAPPER%" (
    powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/gradle/gradle/v8.9.0/gradle/wrapper/gradle-wrapper.jar' -OutFile '%WRAPPER%'" 
    if errorlevel 1 exit /b 1
)
java -classpath "%WRAPPER%" org.gradle.wrapper.GradleWrapperMain %*
