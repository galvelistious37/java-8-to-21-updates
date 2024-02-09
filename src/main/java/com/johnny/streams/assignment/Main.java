package com.johnny.streams.assignment;

import java.util.*;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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
        questionNine();
        questionTen();
        questionEleven();
        questionTwelve();
        questionThirteen();
    }

    private static void questionOne(){
        System.out.println("one");
        double d =  IntStream.range(0, 5).average().orElse(0);
        System.out.println("Average: " + d);
    }

    private static void questionTwo(){
        System.out.println("two");
        List<Item> listPeople = List.of(new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));

        listPeople.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionTwoAlternate(){
        System.out.println("two alternate");
        Stream.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"))
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionThree(){
        System.out.println("three");
        Predicate<List<String>> containsC = list -> list.contains("c");
        Stream<List<String>> strList = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        strList.filter(containsC)
                .flatMap(List::stream)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void questionFour(){
        System.out.println("four");
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
        System.out.println("five");
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
        System.out.println("six");
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
        System.out.println("seven");
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
        System.out.println("eight");
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

    private static void questionNine(){
        System.out.println("nine");
        IntPredicate isUnder30 = i -> i < 30;
        List<Person> personList = List.of(new Person("Bob", "Kelly", 31),
                new Person("Paul", "Landers", 32),
                new Person("John", "Paters", 33));


        double avg = personList.stream()
                .mapToInt(Person::getAge)
                .filter(isUnder30)
                .average()
                .orElse(0.0);

        System.out.println(avg);
    }

    private static void questionTen(){
        System.out.println("Ten");
        Supplier<Double> getDouble = () -> 5.0;

        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(getDouble));

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if(price2.isEmpty()) System.out.println("Empty");
        price2.ifPresent(System.out::println);
        Double x = price2.orElse(44.0);
        System.out.println(x);

//        Optional<Double> price3 = Optional.ofNullable(null);
//        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
//        System.out.println(z);
    }

    private static void questionEleven(){
        System.out.println("eleven");
        List<AnotherBook> abList = Arrays.asList(
                new AnotherBook("Gone with the Wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller"));

        List<String> genreList = new ArrayList<>();
        abList.stream()
                .map(AnotherBook::getGenre)
                .forEach(genreList::add);

        System.out.println(genreList);
    }

    private static void questionTwelve(){
        System.out.println("twelve");
        DoublePredicate isOdd = num -> num % 2 != 0;
        double sum = DoubleStream.of(0, 2, 4)
                .filter(isOdd)
                .sum();
        System.out.println(sum);

        DoublePredicate isEven = num -> num % 2 == 0;
        double sum2 = Stream.of(1.0, 3.0)
                .mapToDouble(Double::doubleValue)
                .filter(isEven)
                .average()
                .orElse(0.0);
        System.out.println(sum2);
    }

    private static void questionThirteen(){
        System.out.println("thirteen");

        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        System.out.println(ls.stream().distinct().anyMatch(i -> i == 11));
        System.out.println(ls.stream().distinct().noneMatch(x -> x % 11 > 0));
    }
}
