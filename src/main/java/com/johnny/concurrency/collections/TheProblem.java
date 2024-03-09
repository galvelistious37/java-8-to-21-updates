package com.johnny.concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheProblem {
    public static void main(String[] args) {
//        Map<String, String> capitalCities = new HashMap<>();
        Map<String, String> capitalCities = new ConcurrentHashMap<>(); // Fixes the issue
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");

        for(String key : capitalCities.keySet()){
            System.out.println(key + " is the capital of " + capitalCities.get(key));
            capitalCities.remove(key); // ConcurrentMethodModificationException
        }
    }
}
