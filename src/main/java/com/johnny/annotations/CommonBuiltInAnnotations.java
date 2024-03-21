package com.johnny.annotations;


@FunctionalInterface
interface Moveable{
    void move();
//    void run();
//    boolean equals(Object o);
}

class Person implements Moveable{
    private String name;
    Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void move(){
        System.out.println("Moving");
    }
}

public class CommonBuiltInAnnotations {
    public static void main(String[] args) {
        Person jr = new Person("John Robertson");
        System.out.println(jr);
        jr.move();
    }
}
