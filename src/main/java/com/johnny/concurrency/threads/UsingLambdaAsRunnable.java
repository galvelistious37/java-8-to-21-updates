package com.johnny.concurrency.threads;

public class UsingLambdaAsRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("run(): " +
                Thread.currentThread().getName()));
        t.start();
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}
