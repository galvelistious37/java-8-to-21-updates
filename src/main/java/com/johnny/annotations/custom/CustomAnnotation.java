package com.johnny.annotations.custom;

enum Device {LAPTOP, PHONE};

// 1. Define an annotation
// Can be public or package-private
@interface Human{} // marge annotation (no elements)

@interface OnWeb{
    // The elements - abstract and public by default
    //  - can't be protected, private, or final
    int startTime() default 9;  // optional (due to defualt value)
    int hoursPerDay();          // required element (ne default value)

    // As in interfaces, values are public static final be default.
    // Constants are not considered elements => maker interfaces can have constants
    int PEAK_TIME_START = 19;
    public static final int PEAK_TIME_END = 22;

    //The element type must be a primitive type, a String, an enum, Class, another
    // annotation or an array
//    Integer turnOff();  - wrapper types not allowed
    String name() default "JKR";
    Device consume() default Device.LAPTOP;
    Class humanOrBot() default Human.class;
    Human extraInfo() default @Human;
    String[] sites() default {"J", "K", "R"};
}

@OnWeb(hoursPerDay = 6)
@Human
class Student{}

@OnWeb(hoursPerDay = 3, startTime = 18)
@Human
class Worker{
}

public class CustomAnnotation {
    public static void main(String[] args) {
        System.out.println();
    }
}
