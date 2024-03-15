package com.johnny.localization;

import java.util.Locale;

public class DefaultLocale {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale); // language_COUNTRY -- en_US
    }
}
