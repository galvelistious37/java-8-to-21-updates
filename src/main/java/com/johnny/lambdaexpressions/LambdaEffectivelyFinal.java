package com.johnny.lambdaexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    private String name;

    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("John");

        int x = 12; // final or effectively final

        // Lambdas take a snapshot/picture of local variables; these local
        // variables MUST NOT change. Only setting up lambda here.

        Predicate<String> lambda = s -> {
            //x++;
            new LambdaEffectivelyFinal().name = "Kennedy"; // instance/class vars are ok
            System.out.println("x == " + x);
            return s.isEmpty() && x%2 == 0;
        };
        filterData(a1, lambda); // lambda vies 'x' as 12
        System.out.println(a1);

        new LambdaEffectivelyFinal().name = "Sean"; // instance/class vars are ok

        // If 'x' was allowed to change, then the method and the lambda would
        // have 2 different views of 'x'
        // x++;
        filterData(a1, lambda); // lambda views 'x' as 12
    }

    public static void filterData(List<String> list, Predicate<String> lambda){
        Iterator<String> i = list.iterator();
        while(i.hasNext()){
            if(lambda.test(i.next())){
                i.remove();
            }
        }
    }
}
