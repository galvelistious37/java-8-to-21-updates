package com.johnny.concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    // Single Thread Executors will accept tasks sequentially in the order
    // they are submitted.
//    private static ExecutorService es = Executors.newSingleThreadExecutor();
    // With 4 threads to share the work, there is no guarantee which
    // letter will appear first.
    private static ExecutorService es = Executors.newFixedThreadPool(4);
    private static List<Callable<String>> callables = new ArrayList<>();

    public static void main(String[] args){
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");
//        invokeAny();
        invokeAll();
    }

    private static void invokeAny(){
        try{
            // Submitting a collection of tasks.
            // Executes synchronously and returns when one of the tasks has
            // completed, all other tasks are cancelled.
            // Note: Single thread executor will always execute the first
            // task submitted.
            String result = es.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        } finally {
            // don't forget to shutdown the executor
            es.shutdown();
        }
        System.out.println("Always at the end!");
    }

    private static void invokeAll(){
        try{
            // Submitting a collection of tasks.
            // Executes synchronously and returns when all of the tasks are completed.
            // Order is maintained i.e.the result for callables.get(0) goes into
            // list.get(0)
            List<Future<String>> list = es.invokeAll(callables);
            for(Future<String> f : list){
                System.out.println(f.get());
            }
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        } finally {
            // don't forget to shutdown the executor
            // finally always executes
            es.shutdown();
        }
        System.out.println("Always at the end");
    }
}
