@echo off
setlocal

for /f "usebackq tokens=1,* delims==" %%a in (`findstr /v "^#" .env`) do (
    set "%%a=%%b"
)

java -jar target\payments-risk-demo-0.0.1-SNAPSHOT.jar