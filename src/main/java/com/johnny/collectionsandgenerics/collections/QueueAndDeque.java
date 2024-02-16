package com.johnny.collectionsandgenerics.collections;

import java.util.*;

public class QueueAndDeque {
    // Queue = A collection that specifies the order in which elements
    // are to be processed.
    // - Typically the order is FIFO
    // - Exceptions are priority queues (order is natural ordering
    //   or according to a supplied comparator) and LIFO queues (stacks).
    // - LinkedList:
    //   - as LinkedList implements Queue, basic queues can be handled
    //     with a LinkedList
    //
    // Deque:
    // - deque (double ended queue) and is pronounced "deck"
    // - access from both ends permitted
    // - can be used both FIFO and LIFO
    // - ArrayDeque:
    //   - expandable-array implementation of the Deque interface
    //     (No capacity restrictions)
    //   - API: likely to be faster that Stack when used as a stack,
    //     and faster than LinkedList when used as a queue
    public static void main(String[] args) {
        linkedListQueue();
        arrayDeque();
        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    private static void linkedListQueue(){
        System.out.println("LinkedListQueue");
        // A FIFO queue (First In First Out)
        Queue<Integer> queue = new LinkedList<>();
        // add() inserts into queue (throws exception if no space exists
        //   - if capacity is restricted)
        // offer() inserts into queue (returns false if no space exists
        //   - capacity is restricted)
        queue.add(1);      // head -> [1]
        queue.offer(2); // head -> [1, 2]
        queue.add(3);      // head -> [1, 2, 3]
        queue.offer(4); // head -> [1, 2, 3, 4]

        // element()) retrieves but does not remove the head of the queue (throws
        // exception if queue empty)
        // peek() retrieves but does not remove the head of the queue (returns
        // null if queue empty)
        System.out.println(queue.element()); // 1
        System.out.println(queue.peek());    // 1
        System.out.println(queue);           // [1, 2, 3, 4]

        // remove() - Retrieves and removes the head of this queue (throws
        // exception if queue empty)
        // poll() - Retrieves and removes the head of this queue (returns null
        // if the queue is empty)
        System.out.println(queue.remove());  // 1 head -> [2, 3, 4]
        System.out.println(queue.poll());    // 2 head -> [3, 4]
        System.out.println(queue);           // [3, 4]

        // Peek, Offer, and Poll are the preferred methods because they do not
        // throw exceptions - P.O.P
    }

    private static void arrayDeque(){
        System.out.println("ArrayDeque");
        // Deque = "doubly ended queue". Supports element insertion/removal at
        // both ends.
        // ArrayDeque - resizable-array implementation of the Deque interface
        // (no capacity restrictions)
        Deque<Integer> numbers = new ArrayDeque<>();
        // "arg" (as in main(Stingp[] args)
        //    Deque methods that begin with "a", "r", or "g" e.g. addFirst(),
        //    addLast(), removeFirst(), removeLast(), getFirst(), and getLast() all
        //    throw exceptions if the deque is both capacity-constrained and full.
        //    The other methods (POP): peekFirst(), peekLast(), offerFirst(), offerLast(),
        //    pollFirst(), and pollLast(), rather than throw exceptions in the same
        //    situation, return null/false.
        // add at front (the head)
        numbers.add(1);           // head -> [1] <- tail
        numbers.addFirst(2);   // head -> [2,1] <- tail
        numbers.offerFirst(3); // head -> [3,2,1] <- tail
        System.out.println("Head: " + numbers.getFirst() + ". Head: " +
                numbers.peekFirst());

        // add at the end (the tail)
        numbers.addLast(4);
        numbers.offerLast(5);

        // Remove from both ends
        numbers.removeFirst();
        numbers.pollFirst();
        numbers.removeLast();
        numbers.pollLast();
        System.out.println(numbers);

        // The common methods peek() offer() poll() in use:
        System.out.println(numbers.offer(11));
        System.out.println(numbers.offer(12));
        System.out.println(numbers.peek());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
        System.out.println(numbers.poll());
    }

    private static void priorityQueueNaturalOrdering(){
        System.out.println("PriorityQueue Natural Ordering");
        // Natural Ordering
        Queue<String> names = new PriorityQueue<>(); // alphanumeric ordering
        names.add("V");
        names.add("P");
        names.add("A");
        Iterator itNames = names.iterator();
        while(itNames.hasNext()){
            System.out.println(names.poll());
        }

        Queue<Integer> numbers = new PriorityQueue<>(); // numeric ordering
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);
        Iterator itNumbers = numbers.iterator();
        while(itNumbers.hasNext()){
            System.out.println(numbers.poll());
        }
    }

    private static void priorityQueueDifferentOrdering(){
        System.out.println("PriorityQueue Different Ordering");
        // Ordering specified by a comparator at construction time
        // 1. Order by the title of the book
        // Comparator.comparing(Function)
        // Function<T, R>
        //    R apply(T t)
        Comparator<Book> comparatorTitle = Comparator.comparing(Book::getTitle);
        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title:");
        Iterator itBooks = booksByTitle.iterator();
        while(itBooks.hasNext()){
            Book book = booksByTitle.poll();
            System.out.println(book);
        }

        Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
        Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
        booksByPrice.add(new Book("Java", 55.0));
        booksByPrice.add(new Book("Python", 23.0));
        booksByPrice.add(new Book("C++", 99.0));

        System.out.println("Ordering by Price:");
        Iterator itBooksByPrice = booksByPrice.iterator();
        while(itBooksByPrice.hasNext()){
            Book book = booksByPrice.poll();
            System.out.println(book);
        }
    }
}
