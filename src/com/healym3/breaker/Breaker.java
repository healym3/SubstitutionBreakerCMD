package com.healym3.breaker;

import java.util.HashMap;
import java.util.Map;



public class Breaker {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_SIZE = 26;
    private Map<Character, Integer> transCharToInt;
    // JsonObject quadgrams;

    public Breaker() {
        this.transCharToInt = new HashMap<Character, Integer>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            transCharToInt.put(ALPHABET.charAt(i), i);
        }
    }
}
