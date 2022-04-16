package com.healym3.data;

public class BreakerResult {
    private String cipherText;
    private String plainText;
    private String keyString;
    private double fitness;
    private int rounds;
    private long duration;

    public BreakerResult(String cipherText, String plainText, String keyString, double fitness, int rounds, long duration) {
        this.cipherText = cipherText;
        this.plainText = plainText;
        this.keyString = keyString;
        this.fitness = fitness;
        this.rounds = rounds;
        this.duration = duration;
    }

    public String getCipherText() {
        return cipherText;
    }

    public String getPlainText() {
        return plainText;
    }

    public String getKeyString() {
        return keyString;
    }

    public double getFitness() {
        return fitness;
    }

    public int getRounds() {
        return rounds;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "BreakerResult{" +
                "cipherText='" + cipherText + '\'' +
                ", plainText='" + plainText + '\'' +
                ", keyString='" + keyString + '\'' +
                ", fitness=" + fitness +
                ", rounds=" + rounds +
                ", duration=" + duration +
                '}';
    }
}
