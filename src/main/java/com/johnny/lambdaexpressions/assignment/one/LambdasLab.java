package com.johnny.lambdaexpressions.assignment.one;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasLab {

    public static void main(String[] args) {
        LambdasLab lambLab = new LambdasLab();
        lambLab.consumer();
        lambLab.supplier();
        lambLab.predicate();
        lambLab.function();
        List<Person> listPeople = getPeople();
        lambLab.sortAge(listPeople);
        lambLab.sortName(listPeople);
        lambLab.sortHeight(listPeople);
    }

    private void consumer(){
        Printable<String> lambda = s -> System.out.println(s);
        lambda.print("Printable Lambda");
        Consumer<String> consumerL = s -> System.out.println(s);
        Consumer<String> consumerMR = System.out::println;
        consumerL.accept("Consumer Lambda");
        consumerMR.accept("Consumer Method Reference");
    }

    private void supplier(){
        Retrievable<Integer> retL = () -> 77;
        System.out.println(retL.retrieve());
        Supplier<Integer> supL = () -> 77;
        System.out.println(supL.get());
    }

    private void predicate(){
        Evaluate<Integer> evalL = i -> i < 0;
        System.out.println(evalL.isNegative(-1));
        System.out.println(evalL.isNegative(1));
        Predicate<Integer> predL = i -> i < 0;
        System.out.println(predL.test(-1));
        System.out.println(predL.test(1));

        Predicate<Integer> isEven = i -> i % 2 == 0;
        System.out.println("isEven: " + check(4, isEven));
        System.out.println("isEven: " + check(7, isEven));

        Predicate<String> lamStartsWith = s -> s.startsWith("Mr.");
        System.out.println("lamStartsWith: " + check("Mr. Joe Bloggs", lamStartsWith));
        System.out.println("lamStartsWith: " + check("Mrs. Ann Bloggs", lamStartsWith));

        Person p1 = new Person("Mike", 33, 1.8);
        Person p2 = new Person("Ann", 13, 1.4);
        Predicate<Person> isAdult = i -> i.getAge() > 18;
        System.out.println("isAdult: " + isAdult.test(p1));
        System.out.println("isAdult: " + isAdult.test(p2));
    }

    private void function(){
        Functionable<Integer, String> funcL = i -> "Number is: " + i;
        System.out.println(funcL.applyThis(25));
        Function<Integer, String> functL = i -> "Number is: " + i;
        System.out.println(functL.apply(25));
    }

    private void sortAge(List<Person> people){
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age:");
        people.forEach(System.out::println);
    }

    private void sortName(List<Person> people){
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("Sorted by name:");
        people.forEach(System.out::println);
    }

    private void sortHeight(List<Person> people){
        people.sort(Comparator.comparing(Person::getHeight));
        System.out.println("Sorted by height:");
        people.forEach(System.out::println);
    }

    private <T> boolean check(T t, Predicate<T> pred){
        return pred.test(t);
    }

    private static List<Person> getPeople(){
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
}
