package com.johnny.textblocks;

public class TextBlockExample {
    public static void main(String[] args) {
        var sName = "John Robertson";
        var tbName = """
                John Robertson
                """;
        System.out.println(sName.equals(tbName));
        System.out.println(tbName.substring(5));
    }
}
