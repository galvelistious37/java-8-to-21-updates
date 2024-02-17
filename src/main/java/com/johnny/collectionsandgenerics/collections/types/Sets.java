package com.johnny.collectionsandgenerics.collections.types;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    // No duplicate elements
    public static void main(String[] args) {
        factoryMethods();
        treeSet();
        hashSet();
        linkedHashSet();
    }

    private static void factoryMethods(){
        System.out.println("Factory Methods");
        // unmodifiable sets returned
        Set<String> of = Set.of("a", "b", "c");
        Set<String> copy = Set.copyOf(of);

        // UnsupportedOperationException
//        of.add("d");
//        copy.add("d");
//        of.remove("a");
        System.out.println(of);
    }

    private static void treeSet(){
        System.out.println("Tree Set");
        // SUU - Sets are Unique and Unordered
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");
        // No duplicates, elements are sorted alphabetically
        System.out.println(names);

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);
        // No duplicates, elements sorted numerically
        System.out.println(numbers);
    }

    private static void hashSet(){
        System.out.println("Hash Set");
        // HashSet - Object hashCode and equals should be written
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact("zoe", 45));
        contactsHS.add(new Contact("zoe", 45));
        contactsHS.add(new Contact("alice", 34));
        contactsHS.add(new Contact("andrew", 35));
        contactsHS.add(new Contact("brian", 36));
        contactsHS.add(new Contact("carol", 37));
        contactsHS.forEach(System.out::println);
    }

    private static void linkedHashSet(){
        System.out.println("Linked Hash Set");
        // LinkedHashSet
        // API: This implementation differs from HashSet in that it maintains
        // a doubly-linked list running through all of its entries. This linked list
        // defines the iteration ordering, which is the order in which elements were
        // inserted into the set (insertion order).
        // This implementation spares its clients from the unspecified, generally
        // chaotic ordering provided by HashSet, without incurring the increased cost
        // associated with TreeSet.
        Set<Contact> contactsLHS = new LinkedHashSet<>();
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("zoe", 45));
        contactsLHS.add(new Contact("alice", 34));
        contactsLHS.add(new Contact("andrew", 35));
        contactsLHS.add(new Contact("brian", 36));
        contactsLHS.add(new Contact("carol", 37));
        contactsLHS.forEach(System.out::println);
    }
}
