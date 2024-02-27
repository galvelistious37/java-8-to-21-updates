package com.johnny.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        // Guaranteed to get to 10 with no duplcates
        // Order is not guaranteed
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 1; i <= 10; i++){
            es.submit(() -> System.out.println(atomicInteger.incrementAndGet() + " "));
        }
        es.shutdown();
    }
}
