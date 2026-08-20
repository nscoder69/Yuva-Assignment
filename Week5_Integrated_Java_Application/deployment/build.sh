#!/bin/sh
set -e
rm -rf build
mkdir -p build/classes build/dist
javac -d build/classes src/*.java
jar --create --file build/dist/library-inventory.jar --main-class inventory.Main -C build/classes .
echo "Built build/dist/library-inventory.jar"
