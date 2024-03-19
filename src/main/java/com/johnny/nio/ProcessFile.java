package com.johnny.nio;

import com.johnny.nio.fromfile.Cat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessFile {
    public static void main(String[] args) {
        List<Cat> cats = loadCats("src/main/java/com/johnny/nio/fromfile/Cats.txt");
        cats.forEach(System.out::println);
    }

    private static List<Cat> loadCats(String filename){
        List<Cat> cats = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(filename))){
             return stream.parallel()
                     .map(s -> s.split("/"))
                     .map(s -> new Cat(s[0], s[1]))
                     .collect(Collectors.toList());
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return cats;
    }
}
