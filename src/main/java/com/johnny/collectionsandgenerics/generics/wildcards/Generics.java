package com.johnny.collectionsandgenerics.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    // ? - unbound wildcard
    //     - List<?> l = new LinkedList<Integer>();
    //     - Read only
    // ? extends type - Upper bound wildcard
    //     - List<? extends Number> l = new LinkedList<Integer>();
    //     - Read only
    // ? super type - Lower bound wildcard
    //     - List<? super Number> l = new LinkedList<Object>();
    //     - Not read only

    static class Animal{}
    static class Dog extends Animal{}
    static class Terrier extends Dog{}
    static class Cat extends Animal{}
    static class Manx extends Cat{}

    public static void main(String[] args) {
        unboundedWildcard();
        superAndExtends();
    }

    private static void showListUnboundedWildcard(List<?> list){
        for(Object o : list){
            System.out.println(o);
        }
//        list.add("test"); // cannot add to <?> - read only
    }

    private static void unboundedWildcard(){
        System.out.println("Unbounded Wildcard");
        List<String> names = new ArrayList<>();
        names.add("Sean");
        showListUnboundedWildcard(names);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        showListUnboundedWildcard(dogs);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        showListUnboundedWildcard(cats);
    }

    public static void addAnimal(Animal[] animals){
        animals[0] = new Dog();
//        animals[1] = new Cat(); // Generates an ArrayStoreException - JVM knows the type
    }

    public static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
    }

    private static void superAndExtends(){
        System.out.println("Super and Extends");
        Dog[] dogs0 = {new Dog(), new Dog()};
        addAnimal(dogs0);

        List<Cat> cats1 = new ArrayList<>();
//        List<Animal> animals = new ArrayList<>(Cat); // compiler error
        List<Cat> cats2 = new ArrayList<Cat>();
        List<Cat> cats3 = new ArrayList<>();
        // JVM does not know the type (stripped out during type erasure), the
        // compiler has to step in.
//        addAnimal(cats2); // cannot resolve List<Cat> to method call List<Animal>

        // extends - polymorphic assignments
        // Notes: extends is read-only
        List<? extends Animal> animals1 = new ArrayList<Animal>();
//        animals1.add(new Animal()); - read only
        List<? extends Animal> animals2 = new ArrayList<Dog>();
        List<? extends Animal> animals3 = new ArrayList<Terrier>();
        List<? extends Animal> animals4 = new ArrayList<Cat>();
        List<? extends Animal> animals5 = new ArrayList<Manx>();
        // This is an Upper Bound Wildcard and can only have
        // new ArrayList of types which extend Animal.
        // Animal is the upper bound.
//        List<? extends Animal> animals6 = new ArrayList<Object>();

        // super - polymorphic assignments
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog()); // can add to this list
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
        // This is a Lower Bound Wildcard and can create new
        // ArrayList of types which are parent to Dog.
        // Dog is the lower bound.
//        List<? super Dog> dogs4 = new ArrayList<Terrier>();

        // Declaring for 'extends' and 'super' examples
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        List<Manx> manxCats = new ArrayList<>();
        manxCats.add(new Manx());
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        List<Terrier> terriers = new ArrayList<>();
        terriers.add(new Terrier());

        // Extends
        ext(animals); // Animal is-an Animal - OK
        ext(cats); // Cat is-an Animal - OK
        ext(manxCats); // Manx is-an Animal - OK
        ext(dogs); // Dog is-an Animal - OK
        ext(terriers); // Terrier is-an Animal - OK
//        ext(objects); // Object is-not an Animal - Not OK

        // Super
        spr(cats); // Cat is Cat - OK
        spr(animals); // Animal is a supertype of Cat - OK
        spr(objects); // Object is a supertype of Cat - OK
//        spr(dogs) // Compiler error: Dog is not Cat or a supertype of Cat - Not OK
//        spr(terriers) // Compiler error: Terrier is not Cat or a supertype of Cat - Not OK
//        spr(manxCats) // Compiler error: Manx is not Cat or a supertype of Cat - Not OK

    }

    private static void ext(List<? extends Animal> list){
        list.forEach(System.out::println);
    }

    private static void spr(List<? super Cat> list){
        // The only objects that can be safely added are any type of Cat
        // (including subtypes) because the method could be getting in a list
        // of Animals or Objects (or Cats).
        list.add(new Cat());
        list.add(new Manx());
//        list.add(new Object());
//        list.add(new Animal());
//        list.add(new Dog()); compiler error
        list.forEach(System.out::println);
    }
}
