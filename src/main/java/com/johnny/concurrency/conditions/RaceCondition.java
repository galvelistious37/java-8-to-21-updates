package com.johnny.concurrency.conditions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 50;
    public int getBalance(){
        return balance;
    }
    public void withdraw(int balance){
        this.balance -= balance;
    }
}

public class RaceCondition implements Runnable {
    private static Lock lock = new ReentrantLock();

    // There is only one BankAccount and it is shared between two threads
    private BankAccount acct = new BankAccount();

    public static void main(String[] args) {
        Runnable r = new RaceCondition();
        Thread john = new Thread(r);
        Thread mary = new Thread(r);
        john.setName("John");
        mary.setName("Mary");
        john.start();
        mary.start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            makeWithdrawal(10);
            if(acct.getBalance() < 0){
                System.out.println("Account is overdrawn");
            }
            try{
                Thread.sleep(500);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

//    private synchronized void makeWithdrawal(int amtToWIthdraw){
//        if(acct.getBalance() >= amtToWIthdraw){
//            System.out.println(Thread.currentThread().getName() +
//                    ". Balance BEFORE: " + acct.getBalance());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ie){
//                ie.printStackTrace();
//            }
//            acct.withdraw(amtToWIthdraw);
//            System.out.println(Thread.currentThread().getName() +
//                    ". BALANCE AFTER: " + acct.getBalance());
//        } else {
//            System.out.println(Thread.currentThread().getName() +
//                    " is unable to withdraw as balance is: " + acct.getBalance());
//        }
//    }

        private void makeWithdrawal(int amtToWIthdraw){
        try{
            lock.lock();
            if(acct.getBalance() >= amtToWIthdraw){
                System.out.println(Thread.currentThread().getName() +
                        ". Balance BEFORE: " + acct.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                acct.withdraw(amtToWIthdraw);
                System.out.println(Thread.currentThread().getName() +
                        ". BALANCE AFTER: " + acct.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() +
                        " is unable to withdraw as balance is: " + acct.getBalance());
            }
        } finally {
            lock.unlock();
        }
    }
}