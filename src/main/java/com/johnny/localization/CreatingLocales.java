package com.johnny.localization;

import java.util.Locale;

public class CreatingLocales  {
    public static void main(String[] args) {
        // 1. Constructors
        System.out.println(new Locale("en"));
        Locale locEnglishGB = new Locale("en", "GB");
        System.out.println(locEnglishGB.getDisplayLanguage());
        System.out.println(locEnglishGB.getDisplayCountry());

        // 2. Built-in constants
        System.out.println(Locale.FRENCH);
        Locale locFrenchFrance = Locale.FRENCH;
        System.out.println(locFrenchFrance.getDisplayLanguage());
        System.out.println(locFrenchFrance.getDisplayCountry());

        // 3. Locale.Builder() pattern
        Locale locArabicEgypt = new Locale.Builder()
                .setLanguage("ar")
                .setRegion("EG")
                .build();
        System.out.println(locArabicEgypt);
        Locale locArabicKuwait = new Locale.Builder()
                .setRegion("KW")
                .setLanguage("ar")
                .build();
        System.out.println(locArabicKuwait);
    }
}
