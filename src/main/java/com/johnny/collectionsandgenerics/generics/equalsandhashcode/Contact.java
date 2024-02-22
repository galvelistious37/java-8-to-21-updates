package com.johnny.collectionsandgenerics.generics.equalsandhashcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Contact {
    private String name;
    private int age;

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Contact){
            Contact otherContact = (Contact) o;
            return this.getName().equals(otherContact.getName()) &&
                    this.getAge() == otherContact.getAge();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.getAge();
        hash = 89 * hash + this.getName().length();
        return hash;
    }

    @Override
    public String toString() {
        return "Contact{age=" + age + ", name=" + name + '}';
    }
}

class ContactTest{
    private static Map<Contact, String> map = new HashMap<>();
    public static void main(String[] args) {
        Contact john = new Contact("John", 32);
        Contact peter = new Contact("Peter", 33);
        System.out.println("john.hashCode() is " + john.hashCode());
        System.out.println("peter.hashCode() is " + peter.hashCode());
        map.put(john, "Irish");
        map.put(peter, "American");
        System.out.println(map.get(john));
        System.out.println(map.get(peter));

        Contact mary = new Contact("Mary", 21);
        System.out.println("mary.hashCode() is " + mary.hashCode());
        map.put(mary, "engineer");
        otherScope();
        System.out.println("After otherScope(): " + map.get(mary));
        testJane();
        System.out.println(map);
    }

    private static void otherScope(){
        Contact anotherMary = new Contact("Mary", 21);
        System.out.println("anotherMary.hashCode() is " + anotherMary.hashCode());
        System.out.println("In otherScope(): " + map.get(anotherMary));

        // this overwrites original mary with anotherMary because the hashCode
        // is the same and they are both equal
        map.put(anotherMary, "accountant");
    }

    private static void testJane(){
        // jane will be found in the same hashing algorithm bucket
        // as "mary" and "anotherMary" because they have the same age
        // and same name string length. However, the equals method will
        // determine the age and name are not the same, so jave will result
        // in a new map key/value pair.
        Contact jane = new Contact("Jane", 21);
        System.out.println("jave.hashCode() is " + jane.hashCode());
        map.put(jane, "nurse");
        System.out.println(map.get(jane));
    }
}
