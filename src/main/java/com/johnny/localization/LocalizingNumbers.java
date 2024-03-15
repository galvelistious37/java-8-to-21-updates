package com.johnny.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalizingNumbers {
    public static void main(String[] args) {
        formatNumbers();
        formatCurrencies();
        parseNumbers();
        parseCurrencies();
        customFormats();
    }

    private static void formatNumbers(){
        // format: number --> String
        double n = 77_000.11;
        System.out.println(NumberFormat.getInstance().format(n));
        System.out.println(NumberFormat.getInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getInstance(Locale.FRANCE).format(n));
    }

    private static void formatCurrencies(){
        // format: number --> String
        double n = 23.22;
        System.out.println(NumberFormat.getCurrencyInstance().format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(n));
    }

    private static void parseNumbers(){
        // parse: String --> number
        String unitedStatesNumber = "77,000.11",
                italianNumber = "77.000,11",
                frenchNumber = "77 000,11";
        try{
            System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
        } catch (ParseException pe){
            pe.printStackTrace();
        }
    }

    private static void parseCurrencies(){
        String irishCurrency = "£23.22", unitedStateCurrency = "$23.22",
                italianCurrency = "23,22 €", unitedKingdomCurrency = "£23.22";
        try{
            System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(irishCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(unitedStateCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).parse(italianCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(unitedKingdomCurrency));
        } catch (ParseException pe){
            pe.printStackTrace();
        }
    }

    private static void customFormats(){
        // DecimalFormat specifies the custom format
        //     # means leave it out if we don't have a digit in this position
        //     0 means insert 0 if we don't have a digit in this position
        // format: number --> String
        double n = 77_000.17;
        System.out.println(new DecimalFormat("$#,###,###.#").format(n));
        System.out.println(new DecimalFormat("$0,000,000.0").format(n));
    }
}
