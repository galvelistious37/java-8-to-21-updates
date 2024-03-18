package com.johnny.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDeleteMove {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        Path source = Paths.get("src/main/java/com/johnny/nio/nio2/source.txt");
        Path target = Paths.get("src/main/java/com/johnny/nio/nio2/target.txt");
        Path target2 = Paths.get("src/main/java/com/johnny/nio/nio2/target2.txt");

        Files.createDirectories(Paths.get("src/main/java/com/johnny/nio/nio2")); // create relative dir
        if(Files.exists(source)){
            System.out.println("source exists");
            // If source and target were directories then this would be a "shallow" copy
            // i.e. the files and sub-directories within the source dir are NOT copied. We
            // will perform a 'deep' copy where the whole tree is copied with stream later.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            Files.move(target, target2, StandardCopyOption.REPLACE_EXISTING);
        } else {
            System.out.println("source does not exists yet");
            Files.createFile(source); // create source file
            Files.copy(source, target); // now we have source and target files
            Files.move(target, target2); // now we have source and target2 files
            Files.delete(target2); // only the source file left
        }
    }
}
