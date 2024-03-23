package com.johnny.patternmatchingswitchexpressions;

public class PatternMatching {
    public static void whatType(Object o) {
        switch(o){
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognized");
        }
    }

    public static void infOnType(Object o){
//        switch(o){
//            case String s && s.startsWith("A") -> System.out.println("String begging with A: " + s);
//            case Integer i && i.intValue() > 10 -> System.out.println("Integer > 10: " + i);
//            case null -> System.out.println("Null");
//            default -> System.out.println("Not recognized");
//        }
    }

    public static void main(String[] args) {
        whatType("ABC");
        whatType(122);
        whatType(null);
        whatType(32.39);
    }
}
