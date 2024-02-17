package com.johnny.collectionsandgenerics.collections.types;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Maps {
    // Maps - map keys to values. Keys ar unique and can map to only
    // one value.
    // Maps DO NOT inherit from Collection
    public static void main(String[] args) {
        treeMap();
    }

    private static void treeMap(){
        System.out.println("TreeMap");
        Map<String, Integer> map = new TreeMap<>(); // sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);
        System.out.println(map.containsKey("John"));
        System.out.println(map.containsValue(18));
        System.out.println(map.isEmpty());

        System.out.println(map.get("John"));

        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);

        System.out.println(map.containsKey("Paul"));
        System.out.println(map.containsValue(21));
        System.out.println(map.size());
        map.clear();

        System.out.println(map.size());

        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        // forEach(BiConsumer)
        //    BiConsumer<T, U> void accept(T t, U u)
        map.forEach((k, v) -> System.out.println(k + " maps to " + v));

        // Set<Map.Entry<K,V> entrySet() - Map.Entry encapsulates a key-value pair
        // go from a Map to a Set (an official Collection)
        map.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue()));

        Set keys = map.keySet();
        System.out.println(keys);

        map.put("Mike", null);
        map.putIfAbsent("Chris", 99);
        map.putIfAbsent("Mike", 55);
        map.putIfAbsent("Luke", 31);
        System.out.println(map);

        Integer original = map.replace("Chris", 81);
        System.out.println(original);

        System.out.println(map);

        // BiFunction<T, U, R>
        //     R apply(T t, U u) = 2 inputs and an output; all of which can
        // be different types. replaceAll(BiFunction<K, V, V> fn) = not the return
        // type is of type V also.
        map.replaceAll((name, age) -> name.length());
        System.out.println(map);

        map.remove("Mike");
        System.out.println(map);
    }

    private static void  linkedMap(){
        System.out.println("LinkedMap");
    }

    private static void hashTable(){
        System.out.println("HashTable");
    }
}
