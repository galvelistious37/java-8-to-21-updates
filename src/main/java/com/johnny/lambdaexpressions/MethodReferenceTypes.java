package com.johnny.lambdaexpressions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes{

    public static void main(String[] args) {
        MethodReferenceTypes mrt = new MethodReferenceTypes();
//        mrt.BoundMethodReferences();
        mrt.unboundedReferences();
    }

    public void BoundMethodReferences() {
        String name = "Mr. Jow Bloggs";
        // Supplier<T>
        //    T get()
        Supplier<String> lowerL = () -> name.toLowerCase(); // lambda
        Supplier<String> lowerMR = name::toLowerCase;       // method reference

        // No need to say which instance to call it on - the supplier is bound to name
        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());

        // Predicate<T>
        //    boolean test(T t)
        // Even though startsWith is overloaded, boolean startsWith(String) and
        // boolean startsWith(String, int), because we are creating a Predicate which
        // has a functional method of test(T t), the startsWith(String) is used.
        // This is where "context" is important.
        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr."));
        System.out.println(titleMR.test("Ms."));
    }

    public void unboundedReferences(){
        // Function<T, R>
        //    R apply(T)
        //        String apply(String)
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        // The function is unbound, so you need to specify which instance to
        // call it on.
        System.out.println(upperL.apply("Sean"));
        System.out.println(upperMR.apply("Sean"));

        // Function<T, U, R>
        //    R apply(T t, U u)
        //        String apply(String, String)
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatL.apply("Sean", "Kennedy"));
        System.out.println(concatMR.apply("Sean", "Kennedy"));

    }
}

