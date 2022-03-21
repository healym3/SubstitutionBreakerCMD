package com.healym3.breaker;

import java.io.*;
import java.security.SecureRandom;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Breaker {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_SIZE = 26;
    private static final int ROUNDS = 10000;
    private static final int CONSOLIDATE = 3;
    private Map<Character, Integer> transCharToInt;
    private Map<Integer, Character> transIntToChar;
    private int[] quadgrams;


    public Breaker() {

        this.transCharToInt = new HashMap<Character, Integer>();

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            transCharToInt.put(ALPHABET.charAt(i), i);
        }
        this.transIntToChar = new HashMap<Integer, Character>();

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            transIntToChar.put(i, ALPHABET.charAt(i));
        }

        try (FileReader reader = new FileReader("src/main/resources/EN.json"))
        {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject object = new JSONObject(tokener);
            System.out.println("alphabet " + object.getString("alphabet"));
            JSONArray quadgramsJson = object.getJSONArray("quadgrams");
            this.quadgrams = new int[quadgramsJson.length()];
            for (int i = 0; i < quadgramsJson.length(); i++) {
                quadgrams[i] = quadgramsJson.optInt(i);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void breakCipher(String cipher){
        cipher = cipher.toLowerCase(Locale.ROOT);
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: cipher.toCharArray()
             ) {
            if(transCharToInt.containsKey(ch)){
                stringBuilder.append(ch);
            }
        }
        String cipherAlphabetOnly = stringBuilder.toString();

        int[] cipherBinary = new int[cipherAlphabetOnly.length()];
        for (int i = 0; i < cipherAlphabetOnly.length(); i++) {
            int ch = transCharToInt.get(cipherAlphabetOnly.charAt(i));
            cipherBinary[i] = ch;

        }
        ArrayList<ArrayList<Integer>> charPositions = new ArrayList(ALPHABET_SIZE);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            charPositions.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < cipherBinary.length; i++) {
            charPositions.get(cipherBinary[i]).add(i);
        }

        System.out.println(charPositions);

        ArrayList<Integer> key = new ArrayList(ALPHABET_SIZE);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            key.add(i);
        }
        ArrayList<Integer> bestKey = new ArrayList<>(ALPHABET_SIZE);
        bestKey = (ArrayList<Integer>) key.clone();
        int localMaximum = 0;
        int localMaximumHit = 1;

        for (int i = 0; i < ROUNDS; i++) {
            Collections.shuffle(key, new SecureRandom());
            int fitness = hillClimb(key, cipherBinary, charPositions);
            System.out.println("fitness: " + fitness);
            if (fitness > localMaximum){
                localMaximum = fitness;
                localMaximumHit = 1;
                bestKey = (ArrayList<Integer>) key.clone();
            } else if (fitness == localMaximum){
                localMaximumHit +=1;
                if (localMaximumHit == CONSOLIDATE){
                    break;
                }
            }
        }
        System.out.println("Final: " + bestKey);




        int textLength = cipherBinary.length;
        int[] plaintext = new int[textLength];
        for (int i = 0; i < textLength; i++) {
            plaintext[i] = bestKey.indexOf(cipherBinary[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i: plaintext
             ) {
            sb.append(transIntToChar.get(i));
        }
        System.out.println(sb.toString());
    }
    private int hillClimb(ArrayList<Integer> key, int[] cipherBinary, ArrayList<ArrayList<Integer>> charPositions){
        int textLength = cipherBinary.length;
        int[] plaintext = new int[textLength];
        for (int i = 0; i < textLength; i++) {
            plaintext[i] = key.indexOf(cipherBinary[i]);
        }

        int maxFitness = 0;
        boolean betterKey = true;
        while(betterKey){
            betterKey = false;
            for (int idx1 = 0; idx1 < ALPHABET_SIZE-1; idx1++) {
                for (int idx2 = idx1 + 1; idx2 < ALPHABET_SIZE; idx2++) {
                    int ch1 = key.get(idx1);
                    int ch2 = key.get(idx2);
                    for (int index: charPositions.get(ch1)
                         ) {
                        plaintext[index] = idx2;

                    }
                    for (int index: charPositions.get(ch2)
                         ) {
                        plaintext[index] = idx1;
                    }
                    int tmpFitness = 0;
                    int quad_idx = (plaintext[0] << 10) + (plaintext[1] << 5) + plaintext[2];
                    for(int i = 3; i < textLength; i++){
                        quad_idx = ((quad_idx & 0x7FFF) << 5) + plaintext[i];
                        tmpFitness += quadgrams[quad_idx];
                    }
                    if(tmpFitness > maxFitness){
                        maxFitness = tmpFitness;
                        betterKey = true;
                        key.set(idx1, ch2);
                        key.set(idx2, ch1);
                    } else {
                        for (int index: charPositions.get(ch1)
                        ) {
                            plaintext[index] = idx1;

                        }
                        for (int index: charPositions.get(ch2)
                        ) {
                            plaintext[index] = idx2;
                        }
                    }
                }

            }
        }

        return maxFitness;
    }
}
