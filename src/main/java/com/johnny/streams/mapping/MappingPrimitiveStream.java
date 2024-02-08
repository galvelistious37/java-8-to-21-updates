package com.johnny.streams.mapping;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingPrimitiveStream {
    public static void main(String[] args) {
        mappingPrimitiveStreams();
    }

    private static void mappingPrimitiveStreams(){
        // IntStream to Stream<T>
        Stream<String> streamAges = IntStream.of(1, 2, 3)
                // mapToObj(intFunction<R>)
                //     IntFunction is a functional interface:
                //         R apply(int value)
                .mapToObj(i -> "Number: " + i);
        // forEach is a terminal operation which closes the stream
        // forEach(Consumer) - Consumer is a functional interface:
        //     void accept(T t)
        streamAges.forEach(System.out::println);

        // IntStream to DoubleStream
        DoubleStream dblStream = IntStream.of(1, 2, 3)
                // mapToDouble(intToDoubleFunction)
                //     IntToDouble is a functional interface:
                //         double applyAsDouble(int value)
                .mapToDouble(num -> num);
        dblStream.forEach(System.out::println);

        // IntStream to IntStream
        IntStream.of(1, 2, 3)
                // map(IntUnaryOperator)
                //     IntUnaryOperator is a functional interface:
                //         int applyAsInt(int)
                .map(i -> i*2)
                .forEach(System.out::println);

        LongStream longSteam = IntStream.of(1, 2, 3)
                // mapToLong(IntToLongFunction)
                //     IntToLongFunction is a functional interface:
                //         long applyAsLong(int value)
                .mapToLong(num -> num);
        longSteam.forEach(System.out::println);
    }
}
