package com.healym3;

import com.healym3.breaker.Breaker;
import com.healym3.substitution.Key;
import com.healym3.substitution.Substitution;

public class Main {

    public static void main(String[] args) {
        Key key;
        key = new Key();
        key.setKey("defghijklmnopqrstuvwxyzabc");
        Substitution substitution = new Substitution(key);
        String cipher = substitution.encrypt("hello world this is mackenzie");
        String plain = substitution.decrypt(cipher);

        System.out.println(key);
        System.out.println(cipher);
        System.out.println(plain);
        Breaker breaker = new Breaker();
    }
}
