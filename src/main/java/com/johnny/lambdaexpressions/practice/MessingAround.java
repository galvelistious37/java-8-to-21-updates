package com.johnny.lambdaexpressions.practice;

import com.johnny.lambdaexpressions.FI_from_API;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MessingAround {
        private static final MyFunction<Map.Entry<String, String>, Integer> entryToInt =
                e -> e.getKey().length() + e.getValue().length();
        private static final MyFunction<Map.Entry<String, String>, String> concatEntry =
                e -> e.getKey().concat(e.getValue());

    public static void main(String[] args) {
        predicate();
        supplier();
        testSettingStreamFunctionDynamically();
    }

    private static void predicate(){
        System.out.println("Predicate check if person older than given age");
        Predicate<Integer> olderThan25 = i -> i > 25;
        Predicate<Integer> olderThan35 = i -> i > 35;
        Person jekk = new Person("Jekk", 24);
        Person jimmy = new Person("jimmy", 37);
        System.out.println("older than 25? " + olderThan25.test(jekk.getAge()));
        System.out.println("older than 35? " + olderThan35.test(jimmy.getAge()));
        System.out.println();

        System.out.println("Predicate stream all numbers greater than 35");
        // Applying a Predicate to a stream
        List<Integer> intList = Arrays.asList(10,20,30,45,46,47);
        intList.stream()
                .filter(olderThan35)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void supplier(){
        System.out.println("Supplier get a person's name");
        Supplier<Person> supPerson = () -> new Person("Jekk", 25);
        System.out.println(supPerson.get().getName());
        System.out.println();
    }

    private static void testSettingStreamFunctionDynamically() {
        runTheStream(true);
        runTheStream(false);
    }


    private static void runTheStream(boolean isInt){
        System.out.println("Run function interface dynamically in a stream");
        var myFunc = isInt ? entryToInt : concatEntry;
        getNamesMap().entrySet().stream()
                .map(myFunc::doIt)
                .forEach(System.out::println);
        System.out.println();
    }

    private static Map<String, String> getNamesMap() {
        Map<String, String> names = new HashMap<>();
        names.put("Jekk ", "Baerr");
        names.put("Jim ", "Beam");
        names.put("Jack ", "Daniels");
        return names;
    }

}
