package com.johnny.streams.creating;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class CreateStreams {
    public static void main(String[] args) {
        streamArray();
        streamCollection();
        streamOfStatic();
        streamFromFile();
        infiniteStream();
    }

    private static void streamArray(){
        Double[] numbers = {1.1, 2.2, 3.3};
        // Arrays.stream() creates a stream from array 'numbers'.
        // The array is considered the source off the stream and while the
        // data is flowing through hte stream, we have an opportunity to
        // operate on the data.
        Stream<Double> stream1 = Arrays.stream(numbers);

        // Perform an operation on the data. Note the count()
        // is a "terminal operation" - this means that you cannot
        // perform and more operations on the stream.
        long n = stream1.count();
        System.out.println("Number of elements: " + n);
    }

    private static void streamCollection(){
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        // using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: " + streamAnimals.count());

        // stream() is a default method in the Collection interface and therefore
        // is inherited by all classes that implement Collection. Map is NOT one
        // of those i.e. Map is not a Collection. To bridge between the two, we use
        // the Map method entrySet() to return a Set view of the Map (Set IS-A Collection)
        Map<String, Integer> namesToAge = new HashMap<>();
        namesToAge.put("Mike", 22);
        namesToAge.put("Mary", 24);
        namesToAge.put("Alice", 31);
        System.out.println("Number of entries: " +
                namesToAge
                        .entrySet()
                        .stream()
                        .count());
    }

    private static void streamOfStatic(){
        Stream<Integer> streamI = Stream.of(1, 2, 3);
        System.out.println(streamI.count());

        Stream<String> streamS = Stream.of("a", "b", "c", "d");
        System.out.println(streamS.count());

        Stream<Dog> streamD = Stream.of(new Dog());
        System.out.println(streamD.count());
    }

    private static void streamFromFile(){
        List<Cat> cats = loadCats("src/main/java/com/johnny/streams/creating/Cats.txt");
        cats.forEach(System.out::println);
    }

    private static List<Cat> loadCats(String filename){
        List<Cat> cats = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(filename))){
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0], catsArray[1]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cats;
    }

    private static void infiniteStream(){
        // Would be infinite without limiting this at 10
        Stream.iterate(2, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}
