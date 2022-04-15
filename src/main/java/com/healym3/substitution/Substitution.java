package com.healym3.substitution;

import java.util.Locale;

public class Substitution {

    private SubstitutionKey key;

    public Substitution(SubstitutionKey key) {
        this.key = key;
    }

    public void setKey(SubstitutionKey key) {
        this.key = key;
    }

    public String encrypt(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        text = text.toUpperCase(Locale.ROOT);
        for (char ch : text.toCharArray()
        ) {
            if (key.keyHas(ch)) {
                stringBuilder.append(key.getCipherChar(ch));
            } else {
                stringBuilder.append(ch);
            }

        }

        return stringBuilder.toString();

    }

    public String decrypt(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        text = text.toUpperCase(Locale.ROOT);

        for (char ch : text.toCharArray()
        ) {
            if (key.decryptKeyHas(ch)) {
                stringBuilder.append(key.getPlainChar(ch));
            } else {
                stringBuilder.append(ch);
            }

        }

        return stringBuilder.toString();
    }
}
