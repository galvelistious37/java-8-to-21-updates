package com.johnny.collectionsandgenerics.collections.sorting;

import java.util.Objects;

public class Dog implements Comparable<Dog>{
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Dog){
            Dog other = (Dog) o;
            if(this.name.equals(other.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length();
        return hash;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Dog o) {
        // Delegate to String which implements comparable<String>
        return name.compareTo(o.getName());
    }
}
