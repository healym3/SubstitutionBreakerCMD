package com.healym3.breaker;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;



public class Breaker {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_SIZE = 26;
    private Map<Character, Integer> transCharToInt;
    private int[] quadgramsArray;
    // JsonObject quadgrams;

    public Breaker() {

        this.transCharToInt = new HashMap<Character, Integer>();

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            transCharToInt.put(ALPHABET.charAt(i), i);
        }

//        String fileName = "src/main/java/com/healym3/breaker/EN.json";
//        InputStream is = Breaker.class.getResourceAsStream(fileName);
//        if (is == null) {
//            throw new NullPointerException("Cannot find resource file " + fileName);
//        }
        try (FileReader reader = new FileReader("src/main/resources/EN.json"))
        {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject object = new JSONObject(tokener);
            System.out.println("alphabet " + object.getString("alphabet"));
            JSONArray quadgramsJson = object.getJSONArray("quadgrams");
            this.quadgramsArray = new int[quadgramsJson.length()];
            for (int i = 0; i < quadgramsJson.length(); i++) {
                quadgramsArray[i] = quadgramsJson.optInt(i);
            }


//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
//
//            //Iterate over employee array
//            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
