package com.johnny.records;

public record CarRecord(String regNumber, String owner) {
//    private final int age; // instance fields must be listed in constructor signature
    public static final String CURRENT_YEAR = "23"; // Can have static fields

    public CarRecord{
        if(regNumber.length() <= 4){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String owner(){
        return owner.toUpperCase();
    }

    public boolean isNewCar(){
        return regNumber().substring(0,2).equals(CURRENT_YEAR);
    }

    public static CarRecord createBlankCarRecord(){
        return new CarRecord("     ", "");
    }
}
