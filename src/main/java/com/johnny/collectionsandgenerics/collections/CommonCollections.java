package com.johnny.collectionsandgenerics.collections;

import java.util.*;

public class CommonCollections {
    public static void main(String[] args) {
        collection();
        listsFactoryMethods();
        arrayList();
        stack();
        linkedList();
    }

    private static void collection(){
        System.out.println("Collection");
        // Lists allow duplicates
        Collection<String> coll = new ArrayList<>();

        // asList() returns an unmodifiable collection
        // -> add() throws an UnsupportedOperationException
//        Collection<String> coll = Arrays.asList("Lucy", "April", "Lucy");
        // is immutable

        coll.add("Lucy");
        coll.add("April");
        coll.add("Lucy");
        System.out.println(coll);
        System.out.println(coll.remove("Lucy"));
        System.out.println(coll);
        System.out.println(coll.isEmpty());
        System.out.println(coll.size());
        System.out.println(coll.contains("John"));
        System.out.println(coll.contains("Lucy"));
        // removeIf(Predicate) and Predicate == boolean test(T t)
        System.out.println(coll.removeIf(s -> s.startsWith("A")));
        coll.forEach(name -> System.out.println(name));
        coll.clear();
        coll.forEach(System.out::println);
    }

    private static void listsFactoryMethods(){
        System.out.println("Lists Factory Methods");
        String[] array = new String[]{"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array); // "array" and "asList" are now "backed"
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);

        array[0] = "Delta"; // changes to array "write through" to the list
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        asList.set(1, "Echo"); // changes to the list "write through" to the array
        System.out.println(Arrays.toString(array));
        System.out.println(asList);

        // UnsupportedOperationException
//        of.add("Foxtrot");
//        copy.add("Foxtrot");
//        asList.add("Foxtrot");
    }

    private static void arrayList(){
        System.out.println("ArrayList");
        // LOD = Lord of the Dande
        //     = Lists maintain an order (index) and allow duplicates
        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");

        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(0);
        list.remove("Mary");
        System.out.println(list);
        list.set(0, "Jack");
        // replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T, T>
        // where the input and output are the same type
        list.replaceAll(name -> name + " Kennedy");
        System.out.println(list);
    }

    private static void stack(){
        System.out.println("Stack");
        // Stack is a LIFO structure (Last In First Out) - wa can manipulate one end only.
        // Using the stack type as the reference type, so we get access to the push(),
        // pop() and peek() methods.
        Stack<String> stack = new Stack<>(); // Legacy class, use Deque instead
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);

        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.push("Helen");
        System.out.println(stack);
    }

    private static void linkedList(){
        System.out.println("LinkedList");
        // A doubly-linked list. We can manipulate both ends.
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin");
        names.add("David");
        names.addFirst("Brian");
        names.addLast("Edward");
        System.out.println(names);

        names.remove("David");
        names.removeFirst();
        names.removeLast();
        System.out.println(names);
    }
}
