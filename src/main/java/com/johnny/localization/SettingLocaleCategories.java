package com.johnny.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class SettingLocaleCategories {
    public static void main(String[] args){
        double n = 77_000.11;
        Locale locFrench = new Locale("fr", "FR");
//        Locale.setDefault(locFrench); // changes "both" DISPLAY and FORMAT

        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayCountry());
        System.out.println(NumberFormat.getInstance().format(n));

        Locale.setDefault(Locale.Category.DISPLAY, locFrench);
        System.out.println("\nDisplay changed: " + defaultLocale.getDisplayName());
        System.out.println("Display changed: " + defaultLocale.getDisplayLanguage());
        System.out.println("Display changed: " + defaultLocale.getDisplayCountry());
        System.out.println("Display changed: " + NumberFormat.getInstance().format(n));

        Locale.setDefault(Locale.Category.FORMAT, locFrench);
        System.out.println("FORMAT changed: \t" + NumberFormat.getInstance().format(n));

    }
}
