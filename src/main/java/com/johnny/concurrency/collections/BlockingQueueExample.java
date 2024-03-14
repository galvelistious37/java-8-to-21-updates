package com.johnny.concurrency.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();

        queue.offer("Red"); // added to end
        queue.offer("Green"); // added to end
        queue.offer("Blue"); // added to end
        System.out.println(queue.poll()); // read and pulled from front
        System.out.println(queue.peek()); // read from front
        System.out.println(queue);

        try{
            queue.offer("White", 100, TimeUnit.MILLISECONDS);
            queue.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(queue);
    }
}
