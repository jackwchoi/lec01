#!/usr/bin/env bash

shopt -s globstar

javac -cp bin/ -d bin/ src/**/*.java &&
  java -ea -cp bin/ main.Main
