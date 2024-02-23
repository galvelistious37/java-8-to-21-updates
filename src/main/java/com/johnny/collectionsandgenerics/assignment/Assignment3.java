package com.johnny.collectionsandgenerics.assignment;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Assignment3 {
    public static void main(String[] args) {
        Map<String, Integer> chanSubs = generateMapChanSubs();
        Map<String, String> chanPubs = generateMapChanPubs();
        Map<String, Integer> pubSubs = generateMapPubSubs(chanSubs, chanPubs);

        pubSubs.forEach((k,v) -> System.out.println("Publisher: " + k + ", Subscribers: " + v));

        Predicate<Integer> conditionMin = i -> Objects.equals(i, Collections.min(pubSubs.values()));
        Predicate<Integer> conditionMax = i -> Objects.equals(i, Collections.max(pubSubs.values()));
        display(pubSubs, conditionMin, "fewest");
        display(pubSubs, conditionMax, "most");
    }

    private static void display(Map<String, Integer> pubSubs, Predicate<Integer> condition, String boundary) {
        pubSubs.entrySet().stream()
                .filter(entry -> condition.test(entry.getValue()))
                .limit(1)
                .forEach(entry -> System.out.println("Publisher with the " + boundary + " subscribers: " +
                        entry.getKey() + ", " + entry.getValue()));
    }

    private static  Map<String, Integer> generateMapChanSubs(){
        Map<String, Integer> temp = new TreeMap<>();
        temp.put("JustForLaughs", 120_000);
        temp.put("JustForGags", 10_000);
        temp.put("ContemplationTechniques", 10_000);
        temp.put("A New Earth", 20_000);
        return temp;
    }

    private static Map<String, String> generateMapChanPubs(){
        Map<String, String> temp = new TreeMap<>();
        temp.put("JustForLaughs", "Charlie Chaplin");
        temp.put("JustForGags", "Charlie Chaplin");
        temp.put("ContemplationTechniques", "Echhart Tolle");
        temp.put("A New Earth", "Echhart Tolle");
        return temp;
    }

    private static Map<String, Integer> generateMapPubSubs(Map<String, Integer> chanSubs, Map<String, String> chanPubs) {
        Map<String, Integer> tempMap = new TreeMap<>();
        BiConsumer<String, String> updateExistingValue = (chan, pub) ->
                tempMap.put(pub, (tempMap.get(pub) + chanSubs.get(chan)));
        BiConsumer<String, String> addToMap = (chan, pub) ->
                tempMap.put(pub, chanSubs.get(chan));

        chanPubs.forEach((chan,pub) -> {
            if(tempMap.containsKey(pub)) {
                updateExistingValue.accept(chan, pub);
            } else {
                addToMap.accept(chan, pub);
            }
        });

        return tempMap;
    }
}
