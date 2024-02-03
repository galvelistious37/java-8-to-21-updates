package com.johnny.streams.terminaloperations.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectWithApiDefinedCollectors {
    public static void main(String[] args) {
        collectorsJoiningAndAveragine();
        collectorsToMap();
        collectorsGroupingBy();
    }

    private static void collectorsJoiningAndAveragine() {
        String s = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(s);

        Double avg = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.averagingInt(String::length));
        System.out.println(avg);
    }

    private static void collectorsToMap(){
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //    (biscuits=8, cake=4, apple tart=10)
        Map<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart")
                        .collect(Collectors.toMap(
                                s -> s,
                                s -> s.length()));
        System.out.println(map);

        // We want a map: number of characters in dessert name -> dessert name.
        // However, 2 of the desserts have the same length (cake and tart) and
        // as length is our key and we can't have duplicate keys, this leads to an
        // exception as Java does not know what to do...
        //    IllegalStateException: Duplicate key 4 (attempted merging values cake and tart)
        // To get around this, we can supply a merge function, whereby we append the
        // colliding keys values together.
        Map<Integer, String> map2 =
                Stream.of("cake", "biscuit", "tart")
                        .collect(Collectors.toMap(
                                String::length,
                                s -> s,
                                (s1, s2) -> s1 + "," + s2)); // Merge Function: what to do with duplicate keys
        System.out.println(map2);

        // The maps returned are HashMaps but this is not guaranteed. What if we wanted
        // a TreeMap implementation so our keys would be sorted. The last argument
        // caters for this.
        TreeMap<String, Integer> treeMap =
                Stream.of("cake", "biscuit", "apple tart", "cake")
                        .collect(Collectors.toMap(
                                s -> s,
                                String::length,
                                Integer::sum, // Merge Function: what to do if we have duplicate keys
                                TreeMap::new));
        System.out.println(treeMap);
        System.out.println(treeMap.getClass());
    }

    private static void collectorsGroupingBy(){
        Stream<String> names = Stream.of("Joe", "Tom", "Tom" ,"Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        // Remove dups by creating a Set instead of a List
        Stream<String> names2 = Stream.of("Joe", "Tom", "Tom" ,"Alan", "Peter");
        Map<Integer, Set<String>> map2 =
                names2.collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toSet())); // Downstream collector
        System.out.println(map2);

        // Get a TreeMap
        Stream<String> names3 = Stream.of("Joe", "Tom", "Tom" ,"Alan", "Peter");
        TreeMap<Integer, List<String>> map3 =
                names3.collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,          // Map type supplier
                        Collectors.toList())); // Downstream collector
        System.out.println(map3);
        System.out.println(map3.getClass());
    }
}
