package com.johnny.streams.intermediateoperations;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class StreamOptionals {
    public static void main(String[] args) {
        // Optionals - A box that may or may not be empty
        showCalcAverage();
        showOrElse();
        showOrElseGet();
        dealWithNulls();
        optionalPrimitive();
    }

    private static Optional<Double> calcAverage(int... scores) {
        if (scores.length == 0) return Optional.empty();
        // working on streams but if I do it this way I get a 0
        // and can't demonstrate the orElse and orElseGet methods above
//        double average = IntStream.of(scores)
//                .summaryStatistics()
//                .getAverage();
//        return Optional.of(average);
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }

    private static void showCalcAverage(){
        System.out.println(calcAverage());
        Optional<Double> optAvg = calcAverage(50, 60, 70);
        // If you do a get() and the Optional is empty you get:
        //     NoSuchElementException: No value present
        // boolean isPresent() protects us from that.
        if(optAvg.isPresent()){
            System.out.println(optAvg.get());
        }
        // void ifPresent(Consumer c)
        optAvg.ifPresent(System.out::println);
        // Me just messing around
        calcAverage(50, 60, 70).ifPresent(System.out::println);
    }

    private static void showOrElse(){
        Optional<Double> optAvg = calcAverage(50, 60, 70);
        // T orElse(T t)
        System.out.println("Get average or get a NaN");
        System.out.println(optAvg.orElse(Double.NaN));
        System.out.println(calcAverage().orElse(Double.NaN));
    }

    private static void showOrElseGet(){
        Optional<Double> optAvg = calcAverage(50, 60, 70);
        // T orElseGet(Supplier<T> s)
        System.out.println("Get average or get a rando");
        System.out.println(optAvg.orElseGet(Math::random));
        System.out.println(calcAverage().orElseGet(Math::random));
    }

    private static void dealWithNulls(){
        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println);
        Optional<String> optNull = howToDealWithNull(null);
        System.out.println(optSK.orElse("Empty optional"));
        System.out.println(optNull.orElse("Empty optional"));
    }

    private static Optional<String> howToDealWithNull(String param){
        // Optional optReturn = param == null ? Optional.empty() : Optional.of(param);
        return Optional.ofNullable(param); // same as previous line
    }

    private static void optionalPrimitive(){
        OptionalDouble optAvg = IntStream.rangeClosed(1, 10).average();
        // DoubleConsumer - functional interface; function method is:
        //     void accept(double value)
        optAvg.ifPresent((d) -> System.out.println(d));
        optAvg.ifPresent(System.out::println);
        System.out.println(optAvg.getAsDouble());
        System.out.println(optAvg.orElse(Double.NaN));
    }
}
