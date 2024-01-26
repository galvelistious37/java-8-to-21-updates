package com.johnny.lambdaexpressions;

import java.util.function.Predicate;

// My own custom Functional Interface
interface Evaluate<T>{
    boolean isNegative(T t);
}

public class TestPredicate {
    public static void main(String[] args) {
        // Evaluate<T> is a functional interface i.e. one abstract method
        // boolean isNegative(T t)
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluation: " + lambda.isNegative(-1));
        System.out.println("Evaluation: " + lambda.isNegative(1));

        // Predicate<T> is a predefined functional interface i.e. one
        // abstract method boolean test(T t)
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(1));

        int x = 4;
        int y = 7;
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is " + x + " even? " + check(x, isEven));
        System.out.println("Is " + x + " even? " + check(x, isEven));

        String name = "Mr. Joe Bloggs";
        String name2 = "Mrs. Ann Bloggs";
        Predicate<String> nameCheck = s -> s.startsWith("Mr.");
        System.out.println("Does " + name + " start with Mr.? " +
                check(name, nameCheck));
        System.out.println("Does " + name2 + " start with Mr.? " +
                check(name2, nameCheck));

    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
}
