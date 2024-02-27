package com.johnny.concurrency.threadsafety;

public class FixRaceWithSynchronized {
//    private static Object lock = new Object();
    private static int count = 0;

//    public synchronized static void addToCounter(){
////    public static void addToCounter() {
////        synchronized (FixRaceWithSynchronized.class) {
////        synchronized (lock){
//            int c = count;
//            System.out.println("Before. " + count + ". Thread Id: " + Thread.currentThread().getName());
//            count = c + 1;
//            System.out.println("After. " + count + ". Thread Id: " + Thread.currentThread().getName());
////        }
//    }

    public void addToCounter(){
        synchronized (this){
            int c = count;
            System.out.println("Before. " + count + ". Thread Id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After. " + count + ". Thread Id: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        // When synch on 'this' make sure all threads use the same isntance.
         FixRaceWithSynchronized instance = new FixRaceWithSynchronized();
        for(int i = 1; i <= 10; i++){
            new Thread(() -> instance.addToCounter()).start();
//            new Thread(() -> addToCounter()).start();
        }
    }
}
