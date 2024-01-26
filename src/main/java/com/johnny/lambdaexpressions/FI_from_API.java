package com.johnny.lambdaexpressions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FI_from_API {
    public static void main(String[] args) {
        FI_from_API fiApi = new FI_from_API();
        fiApi.predicate();
        fiApi.supplier();
        fiApi.consumer();
    }

    public void predicate(){
        // Predicate<T> is a functional interface which contains
        // only one abstract method - boolean test(T t)
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City"));

        // BiPredicate<T> is a functional interface which contains
        // only one abstract method - boolean test(T t)
        BiPredicate<String , Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8));
        System.out.println(checkLength.test("Vatican City", 12));
    }

    public void supplier(){
        // Supplier is a functional interface which contains
        // only one abstract method - T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());

        Supplier<Person> supPerson = Person::new;
        System.out.println(supPerson.get().getName());
    }

    class Person{
        private String name = "Jekk Baerr";
        public String getName(){
            return name;
        }
    }

    public void consumer(){
        // Consumer is a functional interface with only one
        // abstract method - accept(T t)
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);

        // BiConsumer<T, U> is a functional interface with only one
        // abstract method - accept<T t, U u>
        var mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored and not returned
        // from the lambda
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint =
                (key, value) -> System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint);
    }
}
