#!/bin/bash
# Simple compile and run script

javac -d target/classes -cp . src/main/java/com/interview/**/*.java 2>&1
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    java -cp target/classes com.interview.Main
else
    echo "Compilation failed!"
fi
