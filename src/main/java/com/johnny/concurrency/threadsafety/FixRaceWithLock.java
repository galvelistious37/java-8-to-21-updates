package com.johnny.concurrency.threadsafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class FixRaceWithLock {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void addToCounter(){
        if(lock.tryLock()){ // If thread cannot get the lock it can move on to something else
            try{
//                lock.lock(); // blocking call
                int c = count;
                System.out.println("Before. " + count + ". Thread Id: " + Thread.currentThread().getId());
                count++;
                System.out.println("After. " + count + ". Thread Id: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            // Did not get the lock... do something else
            System.out.println("Failed to get lock... Thread Id: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .forEach(i ->
                        new Thread(FixRaceWithLock::addToCounter)
                                .start());
    }
}
