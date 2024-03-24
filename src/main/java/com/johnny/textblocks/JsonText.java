package com.johnny.textblocks;

public class JsonText {
    public static void main(String[] args) {
        jsonTraditionalStyle();
        jsonTextBlock();
    }

    private static void jsonTraditionalStyle(){
        String text = "{\n" +
                "  \"name\": \"Jane Doe\",\n" +
                "  \"age\": 23,\n" +
                "  \"address\": \"Main Street, Dublin\",\n" +
                "}";
        System.out.println(text);
    }

    private static void jsonTextBlock(){
        String text = """
                {
                  "name": "Jane Doe",
                  "age": 23,
                  "address": "Main Street, Dublin"
                }
                """;
        System.out.println(text);
    }
}
