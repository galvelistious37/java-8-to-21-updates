package com.johnny.textblocks;

public class TextBlockExample {
    public static void main(String[] args) {
        var sName = "John Robertson";
        var tbName = """
                John Robertson
                """;
        System.out.println(sName.equals(tbName));
        System.out.println(tbName.substring(5));

        String sQuote = "Hamlet: \"There is nothing either good ro bad, " +
                "but thinking makes it so\"";
        System.out.println(sQuote);
        String tbQuote = """
                Hamlet: "There is nothing either good or bad, but thinking makes it so"
                """;
        System.out.println(tbQuote);

        String tbBookTitle1 = """
                Java
                Memory
                Management"""; // No new line when closing on same line
        System.out.println(tbBookTitle1);

        String tbBookeTitle2 = """
                Java
                Memory
                Management
                """; // New line when closing on new line
        System.out.println(tbBookeTitle2);
        varsInTextBlock();
    }

    private static void varsInTextBlock(){
        String name = "Johnny";
        String address = "123 Fake St.";
        String varMsg = """
                {
                  "name:" %s,
                  "age:" 30;
                  "address:" %s
                }
                """;
        System.out.println(String.format(varMsg, name, address));
    }
}
