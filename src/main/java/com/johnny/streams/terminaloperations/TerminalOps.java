package com.johnny.streams.terminaloperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        streamCount();
        streamMinMax();
        streamFindAnyFindFirst();
        streamAnyAllAndNoneMatch();
        streamForEach();
    }

    private static void streamCount(){
        long count = Stream.of("dog", "cat").count();
        System.out.println(count);
    }

    private static void streamMinMax(){
        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduced in Java 8 to replace 'null'. If the stream is
        // empty then the Optional will be empty (and we won't have to deal
        // with null).
        Optional<String> min = Stream.of("deer", "horse", "pig")
                .min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);

        Optional<Integer> max = Stream.of(4, 6, 2, 12, 9)
                .max(Comparator.comparingInt(i -> i));
        max.ifPresent(System.out::println);
    }

    private static void streamFindAnyFindFirst(){
        // Optional<T> findAny()
        // Optional<T> findFirst()
        // These are terminal operations but not reductions as they sometimes
        // return without processing all the elements in the stream.
        // Reductions reduce the entire stream into one value.
        Optional<String> any = Stream.of("John", "Paul")
                .findAny();
        any.ifPresent(System.out::println);

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println);
    }

    private static void streamAnyAllAndNoneMatch(){
        // boolean anyMatch(Predicate)
        // boolean allMatch(Predicate)
        // boolean noneMatch(Predicate)
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred));
        System.out.println(names.stream().allMatch(pred));
        System.out.println(names.stream().noneMatch(pred));
    }

    private static void streamForEach(){
        // As there is no return value, forEach() is not a reduction.
        // As the return type is 'void', if you want something to
        // happen, it has to happen inside the Consumer (side-effect).
        Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
        names.forEach(System.out::print);

        // Note: forEach is also a method in the Collection interface.
        //    Streams cannot be the source of a for-each loop
        //    because stream do not implement the Iterable interface.
        Stream<Integer> s = Stream.of(1);
        // for(Integer i : s){} -- Throws an error: required array or iterable
    }
}
