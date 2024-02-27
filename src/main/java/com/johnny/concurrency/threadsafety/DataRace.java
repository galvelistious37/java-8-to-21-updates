package com.johnny.concurrency.threadsafety;

public class DataRace {
    // example of a data race
    private static int count = 0;

    public static void addToCounter(){
        int c = count;
        System.out.println("Before. " + count + ". Thread Id: " + Thread.currentThread().getId());
        count = c + 1; // not atomic
        System.out.println("After. " + count + ". Thread Id: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            new Thread(DataRace::addToCounter).start();
        }
    }
}
