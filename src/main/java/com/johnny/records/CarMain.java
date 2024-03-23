package com.johnny.records;

public class CarMain {
    public static void main(String[] args) {
        // Using Car
//        Car car = new Car("231G2134", "Joe Bloggs");
//        System.out.println(car);
//        System.out.println(car.getOwner());
//        System.out.println(car.getRegNumber());

        // Using CarRecord
        CarRecord carRecord = new CarRecord("231G4321", "Mary Bloggs");
        System.out.println(carRecord);
        System.out.println(carRecord.owner());
        System.out.println(carRecord.regNumber());

        // Define an instance method; cannot define an instance field
        System.out.println(carRecord.isNewCar());
        System.out.println(CarRecord.CURRENT_YEAR);

        // Define a static method
        CarRecord blankCar = CarRecord.createBlankCarRecord();
        System.out.println("Blank owner: " + blankCar.owner());
        System.out.println("Blank reg number: " + blankCar.regNumber());
    }
}
