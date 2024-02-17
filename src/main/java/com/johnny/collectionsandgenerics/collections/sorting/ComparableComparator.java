package com.johnny.collectionsandgenerics.collections.sorting;

import java.util.*;

public class ComparableComparator {
    // Comparable<T> interface defines one method
    //     int compareTo(T that)
    // + num if current obj is larger
    // 0 if equal
    // - num if current is smaller
    //
    // Comparator - if we want sort in different ways
    //     int compare(T o1, To2)
    //
    public static void main(String[] args) {
        comparableOnInteger();
        comparableOnString();
        comparatorOnDog();
        comparatorSortingByMultipleFields();
        comparatorTreeSet();
        binarySearch();
    }

    private static void comparableOnInteger(){
        System.out.println("comparableOnInteger");
        List<Product> products = new ArrayList<>();
        products.add(new Product(99));
        products.add(new Product(9));
        products.add(new Product(19));
        Collections.sort(products);
        System.out.println(products);
    }

    private static void comparableOnString(){
        System.out.println("comparableOnString");
        Dog[] dogArray = new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)};
        List<Dog> dogList = Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7));

        Arrays.sort(dogArray);
        System.out.println(Arrays.toString(dogArray));

        Collections.sort(dogList);
        System.out.println(dogList);
    }

    private static void comparatorOnDog(){
        System.out.println("comparatorOnDog");
        Dog[] dogArray = new Dog[]{
                new Dog("Spot", 4),
                new Dog("Rover", 7),
                new Dog("Killer", 3)};
        List<Dog> dogList = Arrays.asList(
                new Dog("Spot", 4),
                new Dog("Rover", 7),
                new Dog("Killer", 3));

        // Sort ascending by age
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);

        Arrays.sort(dogArray, byAge);
        System.out.println(Arrays.toString(dogArray));

        dogList.sort(byAge);
        System.out.println(dogList);

        // Sort descending by age
        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();

        Arrays.sort(dogArray, byAgeReversed);
        System.out.println(Arrays.toString(dogArray));

        dogList.sort(byAgeReversed);
        System.out.println(dogList);
    }

    private static void comparatorSortingByMultipleFields(){
        System.out.println("comparatorSortingByMultipleFields");
        // No comparable on object which sorts on natural order
        // so there is no compareTo method.
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Trixy", 5));
        cats.add(new Cat("Bella", 7));
        cats.add(new Cat("Bella", 2));
        Comparator<Cat> comCat = Comparator
                .comparing(Cat::getName)
                .thenComparing(Cat::getAge);

        cats.sort(comCat);
//        Collections.sort(cats, comCat);
        System.out.println(cats);
    }

    private static void comparatorTreeSet(){
        System.out.println("comparatorTreeSet");
        Set<Boss> bosses = new TreeSet<>();
        bosses.add(new Boss(20));
        bosses.add(new Boss(10));
        bosses.add(new Boss(15));
        bosses.add(new Boss(4));
        System.out.println(bosses);

        // ClassCastException because Worker has not implemented Comparable or
        // set the compareTo method
//        Set<Worker> workers = new TreeSet<>();

        // All of these below will work
//        Set<Worker> workers = new TreeSet<>((worker1, worker2) -> worker1.getId() - worker2.getId());
        Set<Worker> workers = new TreeSet<>(Comparator.comparing(Worker::getId));
//        Set<Worker> workers = new TreeSet<>(Comparator.comparing(worker -> worker.getId()));

        workers.add(new Worker(30));
        workers.add(new Worker(20));
        workers.add(new Worker(10));
        workers.add(new Worker(21));
        System.out.println(workers);
    }

    private static void binarySearch(){
        System.out.println("binarySearch");
        List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
        Collections.sort(names);
        System.out.println(names);
        System.out.println(Collections.binarySearch(names, "John"));
        // if not found return -index it would have been - 1 more
//        System.out.println(Collections.binarySearch(names, "Jekk"));

        Cat fluffy = new Cat("Fluffy", 1);
        Cat bella = new Cat("Bella", 5);
        List<Cat> catList = Arrays.asList(fluffy, bella);
        Collections.sort(catList);
        System.out.println(catList);
        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella));

        Comparator<Cat> byAge = Comparator.comparing(Cat::getAge);
        catList.sort(byAge);
        System.out.println(catList);
        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella, byAge));
    }
}
