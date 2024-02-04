package com.johnny.streams.intermediateoperations;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    // As opposed to Stream<T> e.g. Stream<Integer>
    // Stream<Double and Stream<Long>, Java actually provides
    // other stream classes that you can use to work with primitives:
    //    IntStream
    //    DoubleStream
    //    LongStream
    public static void main(String[] args) {
        primitiveStreams();
        primitiveReduce();
    }

    private static void primitiveStreams(){
        int[] ia = {1, 2, 3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la = {1L, 2L, 3L};

        IntStream iStream1 = Arrays.stream(ia);
        DoubleStream dStream1 = Arrays.stream(da);
        LongStream lStream1 = Arrays.stream(la);

        System.out.println(iStream1.count() + ", " +
                dStream1.count() + ", " + lStream1.count());

        IntStream iStream2 = IntStream.of(1, 2, 3);
        DoubleStream dStream2 = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream lStream2 = LongStream.of(1L, 2L, 3L);

        System.out.println(iStream2.count() + ", " +
                dStream2.count() + ", " + lStream2.count());
    }

    private static void primitiveReduce(){
        // Stream<T> to reduce<identity, accumulator)
        Stream<Integer> numbers = Stream.of(1, 2, 3);
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2));

        // IntStream mapToInt(ToIntFunction)
        //    ToIntFunction is a functional interface:
        //        int applyAsInt(T value)
        IntStream intS = Stream.of(1, 2, 3)
                .mapToInt(n -> n); // unboxing from Integer to int
        int total = intS.sum();
        System.out.println(total);
    }
}
