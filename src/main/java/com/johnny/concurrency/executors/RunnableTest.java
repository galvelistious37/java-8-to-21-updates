package com.johnny.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool consisting
        // of one thread.
        ExecutorService es = Executors.newSingleThreadExecutor();

        // Execute the Runnable task (asynchronously) - void run()
        es.execute(() -> System.out.println("Runnable example"));

        // shutdown the executor service otherwise this application will never
        // terminate. Existing tasks will be allowed to complete but no
        // new tasks accepted.
        es.shutdown();
    }
}
