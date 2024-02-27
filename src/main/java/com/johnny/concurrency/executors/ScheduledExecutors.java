package com.johnny.concurrency.executors;

import java.util.concurrent.*;

public class ScheduledExecutors {
    private static ScheduledExecutorService schedEs = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }

    private static void schedule(){
        System.out.println("Start...");
        Future<String> future = schedEs.schedule(() -> "A", 2, TimeUnit.SECONDS);
        try{
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        } finally {
            schedEs.shutdown();
        }
        System.out.println("Always at the end!");
    }

    private static void scheduleWithFixedDelay(){
        System.out.println("Start...");
        // 300 msecs is the time to wait from when the previous task finishes
        // to starting the next task.
        //  => previous task finished - wait 300 msecs - start next task
        final long INITIAL_DELAY = 2000;
        final long WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED = 300;
        schedEs.scheduleWithFixedDelay(() ->
                System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY,
                WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED,
                TimeUnit.MILLISECONDS);
    }

    private static void scheduleAtFixedRate(){
        System.out.println("Start...");
        // Assuming 300 msecs is the time after the initial delay to wait
        // to start the next task and so forth.
        final long INITIAL_DELAY = 2000;
        final long WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK = 300;
        schedEs.scheduleAtFixedRate(() ->
                        System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY,
                WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK,
                TimeUnit.MILLISECONDS);
    }

}
