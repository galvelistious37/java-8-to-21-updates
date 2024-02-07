package com.johnny.streams.intermediateoperations;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingObjectStream {
    public static void main(String[] args) {
        mappingObjectStreams();
    }

    private static void mappingObjectStreams(){
        // Stream<T> to Stream<T>
        Stream.of("ash", "beech", "sycamore")
                // map(Function)
                //     Function<T, R> -> Function<String, String>
                //         String apply(String s)
                .map(tree -> tree.toUpperCase())
                .forEach(System.out::println);

        // Stream<T> to DoubleStream
        DoubleStream dblStream = Stream.of("ash", "beech", "sycamore")
                // mapToDouble(ToDoubleFunction)
                //     ToDoubleFunction is a functional interface:
                //        double applyAsDouble(T value)
                .mapToDouble(tree -> tree.length());
        dblStream.forEach(System.out::println);

        // Stream<T> to IntStream
        IntStream intStream = Stream.of("ash", "beech", "sycamore")
                // mapToInt(ToIntFunction)
                //     ToIntFunction is a functional interface:
                //         int applyAsInt(T value)
                .mapToInt(String::length);
        intStream.forEach(System.out::println);

        // Stream<T> to LongStream
        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                // mapToLong(ToLongFunction)
                //     ToLongFunction is a functional interface:
                //         long applyAsLong(T value)
                .mapToLong(String::length);
        longStream.forEach(System.out::println);
    }
}
