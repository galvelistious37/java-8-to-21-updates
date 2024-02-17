package com.johnny.collectionsandgenerics.collections.sorting;

import java.util.Objects;

public class Cat implements Comparable<Cat> {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Cat){
            Cat otherCat = (Cat) o;
            if(this.getName().equals(otherCat.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Cat o) {
        return name.compareTo(o.getName());
    }
}
