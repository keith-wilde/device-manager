package com.payments.global.devicemanager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern SERIAL_PATTERN_1 =  Pattern.compile( "^\\d{2}[-]?\\d{4}");
    private static final Pattern SERIAL_PATTERN_2 =  Pattern.compile( "^\\d{7}[-]?\\d{5}");
    private static final Pattern SERIAL_PATTERN_3 =  Pattern.compile( "^\\d[-]?\\d{8}");

    public static boolean isSerialNumberValid(String ssn) {
        return (SERIAL_PATTERN_1.matcher(ssn).matches() || SERIAL_PATTERN_2.matcher(ssn).matches() || SERIAL_PATTERN_3.matcher(ssn).matches());
    }
}
