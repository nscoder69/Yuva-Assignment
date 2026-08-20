@echo off
if exist build rmdir /s /q build
mkdir build\classes
mkdir build\dist
javac -d build\classes src\*.java
jar --create --file build\dist\library-inventory.jar --main-class inventory.Main -C build\classes .
echo Built build\dist\library-inventory.jar
