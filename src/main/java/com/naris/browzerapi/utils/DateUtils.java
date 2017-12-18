package com.naris.browzerapi.utils;

import org.joda.time.DateTime;

public class DateUtils {
    public static String strMillis(DateTime dateTime) {
        return String.valueOf(dateTime.getMillis());
    }
}
