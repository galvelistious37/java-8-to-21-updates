package com.johnny.localization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizingDates {
    public static void main(String[] args) {
        Locale locUS = Locale.US;
        Locale locFrench = new Locale("fr", "FR");
        Locale locGerman = Locale.GERMANY;

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateMediumStyle.withLocale(locUS).format(ldt));
        System.out.println(dateMediumStyle.withLocale(locFrench).format(ldt));

        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(timeShortStyle.withLocale(locUS).format(ldt));
        System.out.println(timeShortStyle.withLocale(locGerman).format(ldt));

        DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTimeShortStyle.format(ldt));
        System.out.println(dateTimeShortStyle.withLocale(locFrench).format(ldt));
        System.out.println(dateTimeShortStyle.withLocale(locGerman).format(ldt));
    }
}
