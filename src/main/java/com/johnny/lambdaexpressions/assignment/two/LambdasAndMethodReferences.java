package com.johnny.lambdaexpressions.assignment.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        LambdasAndMethodReferences lamr = new LambdasAndMethodReferences();
        lamr.staticMR();
        lamr.boundMR();
        lamr.unboundedMR();
        lamr.constructorMR();
    }

    public void staticMR(){
        List<Integer> intList = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> consumerL = list -> Collections.sort(list);
        consumerL.accept(intList);
        System.out.println("Lambda sort: " +intList);


        intList = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(intList);
        System.out.println("Method Reference sort: " + intList);
    }

    public void boundMR(){
        String name = "Mr. Joe Bloggs";
        Predicate<String> predL = s -> name.startsWith(s);
        System.out.println("Lambda starts with Mr.: " + predL.test("Mr."));
        System.out.println("Lambda starts with Ms.: " + predL.test("Ms."));

        Predicate<String> predMR = name::startsWith;
        System.out.println("Method Reference starts with Mr.: " + predL.test("Mr."));
        System.out.println("Method Reference starts with Ms.: " + predL.test("Ms."));
    }

    public void unboundedMR(){
        Predicate<String> isEmptyL = s -> s.isEmpty();
        System.out.println("Lambda isEmpty: " + isEmptyL.test(""));
        System.out.println("Lambda isEmpty: " + isEmptyL.test("XYZ"));

        Predicate<String> isEmptyMR = String::isEmpty;
        System.out.println("Method Reference isEmpty: " + isEmptyL.test(""));
        System.out.println("Method Reference isEmpty: " + isEmptyL.test("XYZ"));

        BiPredicate<String, String> biPredL = (s1, s2) -> s1.startsWith(s2);
        System.out.println("Lambda first starts with seconds: " + biPredL.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Lambda first starts with seconds: " + biPredL.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredMR = String::startsWith;
        System.out.println("Method Reference first starts with seconds: " + biPredMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Method Referenc first starts with seconds: " + biPredMR.test("Mr. Joe Bloggs", "Ms."));
    }

    public void constructorMR(){
        Supplier<List<String>> supL = () -> new ArrayList<>();
        List<String> supList = supL.get();
        supList.add("Lambda");
        System.out.println(supList);

        Supplier<List<String>> supMR = ArrayList::new;
        List<String> supListMr = supL.get();
        supListMr.add("Method Reference");
        System.out.println(supListMr);

        Function<Integer, List<String>> funcL = i -> new ArrayList(10);
        List<String> funcList = funcL.apply(10);
        funcList.add("Lambda");
        System.out.println(funcList);

        Function<Integer, List<String>> funcMR = ArrayList::new;
        List<String> funcMrList = funcL.apply(10);
        funcMrList.add("Method Reference");
        System.out.println(funcMrList);
    }
}
