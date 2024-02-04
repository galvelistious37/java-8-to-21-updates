package com.johnny.streams.intermediateoperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        // Unlike a terminal operation, an intermediate operation
        // produces a stream as a result
        System.out.println("Filter");
        intermediateFilter();
        System.out.println("Distinct");
        intermediateDistinct();
        System.out.println("Limit");
        intermediateLimit();
        System.out.println("Map");
        intermediateMap();
        System.out.println("FlatMap");
        intermediateFlatMap();
        System.out.println("Sorted");
        intermediateSorted();
        System.out.println("Sort No Comparator");
        intermediateSortedNoComparator();
    }

    private static void intermediateFilter(){
        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // MATCH the given predicate.
        Stream.of("galway", "mayo", "roscommon")
                .filter(countyName -> countyName.length() > 5)
                .forEach(System.out::println);
    }

    private static void intermediateDistinct(){
        // Stream<T> distinct()
        // distinct() is a stateful intermediate operation
        // Output: 1.eagle 2.eagle 1.eagle 1.EAGLE 2.EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.println(" 1."+s))
                .distinct()
                .forEach(s -> System.out.println(" 2."+s));
    }

    private static void intermediateLimit(){
        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful
        // intermediate operation. Lazy evaluation - 66, 77, 88 and 99
        // are not streamed as they are not needed (limit of 2 i.e. 44 and 55).
        // Output:
        Stream.of(11,22,33,44,55,66,77,88,99)
                .peek(n -> System.out.println("A - "+n))
                .filter(n -> n > 40)
                .peek(n -> System.out.println(" B - "+n))
                .limit(2)
                .forEach(n -> System.out.println(" C - "+n));
    }

    private static void intermediateMap(){
        // map() creates a one-to-one mapping between elements in
        // the stream and elements in the next stage of the stream.
        //
        // map() is for transforming data.
        //
        // <R> Stream<R> map(Function<T, R> mapper)
        //    Function's functional method: R apply(T t);
        Stream.of("book", "pen", "ruler")
                .map(String::length)
                .forEach(System.out::println);
    }

    private static void intermediateFlatMap(){
        // flatMap() takes each element in the stream
        // e.g. Stream<List<String>> and makes any elements it contains
        // top-level elements in a single stream e.g. Stream<String>.
        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("mary", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        // flatMap(Function(T, R)) IN:T OUT:R
        //    flatMap(List<String>, Stream<String>)
        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::println);
    }

    private static void intermediateSorted(){
        // Sorted returns a stream with the elements sorted.
        // Stream<T> sorted(Comparator<T> comparator)
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
        Stream.of(mary, john)
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }

    private static void intermediateSortedNoComparator(){
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.println(" 0."+name))
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.println(" 1."+name))
                .sorted()
                .peek(name -> System.out.println(" 2."+name))
                .limit(2)
                .forEach(name -> System.out.println(" 3."+name));
    }
}
