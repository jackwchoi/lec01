#!/usr/bin/env bash

shopt -s globstar

echo -e '\nCompiling...'
javac -cp bin/ -d bin/ src/**/*.java &&
  java -ea -cp bin/ main.Main
