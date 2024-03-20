package com.johnny.localvariabletypeinferance;

public class LocalVariableTypeInference {
    // 1. Where they can be used:
    //    - Constructors, methods, and init blocks
    // 2. Where they CANNOT be used:
    //    - Constructor/method parameters or static/class variables
    //    - caveat: lambdas where the parameter type can be inferred
    // 3. Alway initialized on the same line as the declaration
    //    e.g. var x = 8;

//    var z = 3; - Not valid because class level
//    static var a = 3; - Not valid because static/class level

    { // init block
        var d = 4.5;
        d = 98.9;
//        d = "sss"; Can change value but cannot change type
//        var x; Need to initialize on same line
//        x = 2;
    }

//    LocalVariableTypeInference(var x){ - Cannot be a parameter type
    LocalVariableTypeInference(){
        var i = 9;
//        var j = null; Cannot be null
        var s = (String) null; // Can be cast to a type from null
    }

    public static void main(String[] args) {
        var s = "abc";
    }

}
