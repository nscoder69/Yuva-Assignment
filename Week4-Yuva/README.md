# Week 4 Refactored Library Inventory

## Requirements
Java 17 or later.

## Compile
javac src/*.java

## Design
The refactored application uses a HashMap keyed by ISBN for O(1) average lookup, update, and delete operations.
Validation is centralized, internal collections are protected, and responsibilities are kept small and focused.

## Run
Add a main class or connect LibraryManager to the command-line UI from Week 2.
