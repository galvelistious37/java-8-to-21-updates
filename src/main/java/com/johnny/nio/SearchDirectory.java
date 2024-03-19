package com.johnny.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchDirectory {
    public static void main(String[] args) {
        Path startPath = Paths.get("./src/main/java/com/johnny/nio");
        try(var streamPaths = Files.find(startPath, 10,
                (path, attr) -> attr.isRegularFile() && path.toString().endsWith(".java"))){
            streamPaths.forEach(System.out::println);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
