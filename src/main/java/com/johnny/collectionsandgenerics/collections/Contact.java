package com.johnny.collectionsandgenerics.collections;

public class Contact {
    private String name;
    private int age;

    public Contact(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Contact){
            Contact otherContact = (Contact) obj;
            return this.name.equals(otherContact.name) &&
                    this.age == otherContact.age;
        }
        return false;
    }
}
