#!/bin/bash

args=`find dataset -type f | xargs`

echo "Building Java Concurrent implementation"
bash src/java/build.sh

echo "Running Serial implementation1"
time java -cp src/java/bin/ ContadorPalavras $args

echo "Running Concurrent implementation2"
time java -cp src/java/bin/ ContadorPalavras2 $args

echo "Running Concurrent implementation3"
time java -cp src/java/bin/ ContadorPalavras3 $args

echo "Running Concurrent implementation4"
time java -cp src/java/bin/ ContadorPalavras4 $args
