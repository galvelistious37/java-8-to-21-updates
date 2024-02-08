package com.johnny.streams.primitives;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
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
        System.out.println("Primitive Streams");
        primitiveStreams();
        System.out.println("Reduce");
        primitiveReduce();
        System.out.println("Optional");
        primitiveOptional();
        System.out.println("Stats");
        primitiveStatistics(IntStream.of(5, 10, 15, 20));
        primitiveStatistics(IntStream.empty());
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

    private static void primitiveOptional(){
        OptionalInt max = IntStream.of(10, 20, 30).max();
        max.ifPresent(System.out::println);

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0).min();
//        OptionalDouble min = DoubleStream.of().min();
        // NoSuchElementException is thrown if no value is present
        System.out.println(min.orElseThrow());

        OptionalDouble average = LongStream.of(10L, 20L, 30L).average();
//        OptionalDouble average = LongStream.of().average();
        System.out.println(average.orElseGet(Math::random));
    }

    private static void primitiveStatistics(IntStream numbers){
        IntSummaryStatistics intStats = numbers.summaryStatistics();
        int min = intStats.getMin();  // largest int value if nothing in stream
        System.out.println(min);
        int max = intStats.getMax(); // smallest int value if nothing in stream
        System.out.println(max);
        double avg = intStats.getAverage();
        System.out.println(avg);
        long count = intStats.getCount();
        System.out.println(count);
        long sum = intStats.getSum();
        System.out.println(sum);
    }
}
