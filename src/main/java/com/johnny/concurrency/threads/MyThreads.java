package com.johnny.concurrency.threads;

/**
 * Extends Thread class
 */
public class MyThreads extends Thread {
    @Override
    public void run(){
        System.out.println("run(): " + getName());
    }

    public static void main(String[] args){
        new MyThreads().start();
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}