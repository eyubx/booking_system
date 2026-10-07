package com.eyubx.bookingsystem.util;

import java.security.SecureRandom;

public class UniqueIdGenerator {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateUniqueId(int totalLength) {
        long timestamp = System.currentTimeMillis() / 1000L;
        String timePart = Long.toString(timestamp, 36).toUpperCase();

        int randomLengthNeeded = totalLength - timePart.length();

        if (randomLengthNeeded < 0) {
            throw new IllegalArgumentException("Requested length must be at least " + timePart.length() + " to accommodate the timestamp.");
        }

        StringBuilder randomPart = new StringBuilder(randomLengthNeeded);
        for (int i = 0; i < randomLengthNeeded; i++) {
            randomPart.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return timePart + randomPart.toString();
    }
}
