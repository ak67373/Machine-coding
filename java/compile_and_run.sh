#!/bin/bash
# Simple compile and run script

javac -source 11 -target 11 -d target/classes -cp . src/main/java/com/interview/**/*.java 2>&1 | grep -v "Note:"
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    java -cp target/classes com.interview.Main
else
    echo "Compilation failed!"
fi
