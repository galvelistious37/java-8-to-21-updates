package com.johnny.collectionsandgenerics.generics.classesinterfacesandmethods;

public class GenericInterface{
    public static void main(String[] args) {
        new MoveFeline().move(new Cat());
//        new MoveFeline().move(new Dog());
        new MoveCanine().move(new Dog());
//        new MoveCanine().move(new Cat());
        new SomeMovable<Dog>().move(new Dog());
        new SomeMovable<Cat>().move(new Cat());
    }
}

class MoveFeline implements Movable<Cat>{
    @Override
    public void move(Cat cat) {

    }
}

class MoveCanine implements Movable<Dog>{
    @Override
    public void move(Dog dog) {

    }
}

class SomeMovable<U> implements Movable<U>{
    @Override
    public void move(U u) {

    }
}

interface Movable<T> {
    void move(T t);
}
