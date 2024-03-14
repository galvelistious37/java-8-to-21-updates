package com.johnny.concurrency.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedCollection {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new HashMap<>();
//        Map<String, String> capitalCities = new ConcurrentHashMap<>();
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");

        Map<String, String> syncapitalCities = Collections.synchronizedMap(capitalCities);
        for(String key : syncapitalCities.keySet()){
            System.out.println(key + " is the capital of " + syncapitalCities.get(key));
//            syncapitalCities.remove(key);
        }
    }
}
