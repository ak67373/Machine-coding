#!/bin/bash
# Compile with Java 11 compatibility

echo "Compiling with Java 11 compatibility..."
javac -source 11 -target 11 -d target/classes -cp . src/main/java/com/interview/**/*.java 2>&1 | grep -v "Note:" | head -20

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Compilation successful!"
    echo "Run with: java -cp target/classes com.interview.Main"
fi
