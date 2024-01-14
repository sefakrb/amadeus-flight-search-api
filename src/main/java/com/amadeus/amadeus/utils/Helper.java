package com.amadeus.amadeus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Helper {
    public static boolean isNullObject(Object object) {
        return object == null;
    }
    public static boolean isStringNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date formattedDate = dateFormat.parse(str);
        return formattedDate;
    }

}
