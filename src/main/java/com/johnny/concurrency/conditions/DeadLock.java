package com.johnny.concurrency.conditions;

public class DeadLock {
    public static void main(String[] args){
        final String ransom = "ransom";
        final String hostage = "hostage";

        Thread criminals = new Thread(() -> {
            synchronized (hostage){
                System.out.println("The criminals have the hostage and want the ransom...");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                synchronized (ransom){
                    System.out.println("The criminals have BOTH");
                } // auto release ransom
            } // auto release hostage
        });

        Thread police = new Thread(() -> {
//            synchronized (ransom){
            synchronized (hostage){ // fix dead lock by placing locks in same order
//                System.out.println("The police have the ransom and want the hostage...");
                System.out.println("The police have the hostage and want the ransom...");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
//                synchronized (hostage){
                synchronized (ransom){ // fix dead lock by placing locks in same order
                    System.out.println("The police have BOTH");
                } // auto release hostage
            } // auto release ransom
        });

        criminals.start();
        police.start();
    }
}
