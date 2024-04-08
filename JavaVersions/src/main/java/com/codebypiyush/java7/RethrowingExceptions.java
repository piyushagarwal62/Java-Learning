package com.codebypiyush.java7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RethrowingExceptions {
    //Starting from Java 7, rethrowing exceptions with more inclusive type checking became possible.
    // This feature allows you to catch a more general exception type in a catch block and
    // then rethrow it with a more specific exception type.
    public static void main(String[] args) throws FileNotFoundException {
        try {
            readFile("file.txt");
        } catch (IOException e) {
            // Rethrow with more specific exception type
            throw new FileNotFoundException("File not found");
        }
    }

    public static void readFile(String filename) throws IOException {
        // Read from a file
        FileReader reader = new FileReader(filename);
        // Other file processing logic...
    }
}
