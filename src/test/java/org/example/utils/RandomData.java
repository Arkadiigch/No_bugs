package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString() {
        return "test" + RandomStringUtils.randomAlphabetic(10);
    }
    public static String randomInt() {
        return "test" + RandomStringUtils.randomAlphanumeric(9);
    }
    public static String generatePassword() {
        return randomString();
    }
}
