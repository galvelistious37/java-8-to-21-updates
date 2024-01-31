package com.johnny.lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTypes{

    public static void main(String[] args) {
        MethodReferenceTypes mrt = new MethodReferenceTypes();
//        mrt.BoundMethodReferences();
//        mrt.unboundedReferences();
//        mrt.staticMethodReferences();
        mrt.constructorMethodReferences();
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

    public static void staticMethodReferences(){
        // Static method references are considered unbound also. An example
        // static method is Collections.sort(List)
        // Consumer<T>
        //    void accept(T t)
        // NB: Consumer takes one parameter => sort(List) is used, as opposed
        // to sort(List, Comparator)
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
        sortL.accept(listOfNumbers);
        System.out.println(listOfNumbers);

        listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers);
        System.out.println(listOfNumbers);
    }

    public static void constructorMethodReferences(){
        // Supplier<T>
        //    T get()
        Supplier<StringBuilder> sbL = () -> new StringBuilder();
        Supplier<StringBuilder> sbMR = StringBuilder::new;
        StringBuilder sb1 = sbL.get();
        sb1.append("Lambda version");
        System.out.println(sb1);

        StringBuilder sb2 = sbMR.get();
        sb2.append("Method Reference version");
        System.out.println(sb2);

        //Function<T, R>
        //    R apply(T t)
        //        List<String> apply(Integer)
        // ArrayList(int initialCapacity)
        Function<Integer, List<String>> alL = x -> new ArrayList(x);
        Function<Integer, List<String>> alMR = ArrayList::new;
        List<String> ls1 = alL.apply(10);
        ls1.add("21");
        System.out.println(ls1);

        List<String> ls2 = alMR.apply(5);
        ls2.add("88");
        System.out.println(ls2);
    }
}

