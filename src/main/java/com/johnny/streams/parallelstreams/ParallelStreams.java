package com.johnny.streams.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        // Splits streams into substreams
        callParallelStream();
        callParallel();
        contrastParallelAndNormalStream();
        beMindfulOfOrder();
    }

    private static void callParallelStream(){
        // of type Collection<E>
        Stream<String> animalStream = List.of("sheep", "pigs", "horses")
                .parallelStream();
    }

    private static void callParallel(){
        // of type Stream<T>
        Stream<String> animalStream = Stream.of("sheep", "pigs", "horses")
                .parallel();
    }

    private static void contrastParallelAndNormalStream(){
        // Sequential stream
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                // IntStream has the sum() method so we can use
                // the mapToInt() method to map from Stream<Integer>
                // to an InstStream (i.e. a stream of int primitives).
                // IntStream mapToInt(ToIntFunction)
                //     ToIntFunction is a functional interface:
                //         int applyAsInt(T value)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum == " + sum);

        // Parallel
        int sum2 = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum == " + sum2);
    }

    private static void beMindfulOfOrder(){
        Arrays.asList("a", "b", "c")
                .stream()
                .forEach(System.out::print);
        System.out.println();

        Arrays.asList("a", "b", "c")
                .stream()
                .parallel()
                .forEach(System.out::print);
        System.out.println();
    }
}
