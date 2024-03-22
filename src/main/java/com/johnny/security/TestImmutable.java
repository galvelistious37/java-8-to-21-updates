package com.johnny.security;

import java.util.ArrayList;

final class Department{ // Cannot subclass this class and all methods are final
    // private final instance variables
    private final String name, address; // String is immutable
    private final int numEmployees;
    private final ArrayList<String> employees; // mutable

    // private constructor - cannot subclass this class because the constructor
    // cannot be invoked from a subclass (hidden)
    private Department(String name, String address, int numEmployees, ArrayList<String> employees){
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
        this.employees = new ArrayList<String>(employees); // Creates a new ArrayList
//        this.employees = employees; // Breaks encapsulation
    }

    // factory method to create a Department
    public static Department createNewInstance(String name,
                                               String address,
                                               int numEmployees,
                                               ArrayList<String> employees){
        return new Department(name, address, numEmployees, employees);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public ArrayList<String> getEmployees() {
        return new ArrayList<String>(employees); // return new object
//        return employees; // Breaking encapsulation again
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numEmployees=" + numEmployees +
                ", employees=" + employees +
                '}';
    }
}

public class TestImmutable {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ann");
        employees.add("Liam");

        Department dept = Department.createNewInstance(
                "Argos",
                "Athlone",
                2,
                employees);

        System.out.println("Created: " + dept);

        String name = dept.getName();
        String address = dept.getAddress();
        int nunEmployees = dept.getNumEmployees();
        employees = dept.getEmployees();

        System.out.println("Retrieved: " + name + " " + address + " " +
                nunEmployees + " " + employees);

        // Change what I got back - any effect on the "dept" immutable object?
        name = "Boots"; // Strings are immutable so new objects are created in the background
        address = "Galway";
        nunEmployees = 3; // simple primitive value is just copied back
        employees.add("Tom"); // as we only got a copy of the AL back, we are changing that copy

        System.out.println("Any change? " + dept);
    }
}
