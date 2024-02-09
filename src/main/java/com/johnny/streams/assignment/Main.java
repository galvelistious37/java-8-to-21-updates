package com.johnny.streams.assignment;

import java.util.*;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        questionOne();
        questionTwo();
        questionTwoAlternate();
        questionThree();
        questionFour();
        questionFive();
        questionSix();
        questionSeven();
        questionEight();
    }

    private static void questionOne(){
        double d =  IntStream.range(0, 5).average().orElse(0);
        System.out.println("Average: " + d);
    }

    private static void questionTwo(){
        List<Item> listPeople = List.of(new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));

        listPeople.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionTwoAlternate(){
        Stream.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"))
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionThree(){
        Predicate<List<String>> containsC = list -> list.contains("c");
        Stream<List<String>> strList = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        strList.filter(containsC)
                .flatMap(Collection::stream)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionFour(){
        int sum = Stream.of(1, 2, 3)
                        .mapToInt(Integer::intValue)
                        .sum();
        System.out.println(sum);

        OptionalInt max = Stream.of(1, 2, 3)
                .mapToInt(Integer::intValue)
                .max();
        max.ifPresent(System.out::println);

        Stream.of(new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29))
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        Stream.of(10, 47, 33, 23)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

        int sum2 = Stream.of(10, 47, 33, 23)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum2);
    }

    private static void questionFive(){
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN"));
        if(grade2.isPresent()){
            grade2.ifPresent(System.out::println);
        } else {
            System.out.println(grade2.orElse("Empty"));
        }
    }

    private static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks > 50){
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }

    private static void questionSix(){
        DoublePredicate greaterThan10 = p -> p > 10;
        DoublePredicate greaterThan90 = p -> p > 90;
        OptionalDouble avg = Stream.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0))
                .mapToDouble(Book::getPrice)
//                .filter(greaterThan90)
                .filter(greaterThan10)
                .average();

        avg.ifPresent(System.out::println);
    }

    private static void questionSeven(){
        List<Book> books = Arrays.asList();
        Map<String, Double> bookMap = Stream.of(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the Wind", 5.0))
                .collect(Collectors.toMap(
                        Book::getTitle,
                        Book::getPrice
                ));
        bookMap.forEach(Main::printBook);
    }

    private static void printBook(String title, Double price){
        Predicate<String> startsWithA = s -> s.startsWith("A");
        if(startsWithA.test(title)){
            System.out.println(title + ": " + price);
        }
    }

    private static void questionEight(){
        List<Book> books = Arrays.asList(
                new Book("Gone with the Wind", 5.0),
                new Book("Gone with the Wind", 10.0),
                new Book("Atlas Shrugged", 15.0));

        books.stream().collect(Collectors.toMap(
                        Book::getTitle, 
                        Book::getPrice,
                        (a, b) -> a * b))
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }

}
