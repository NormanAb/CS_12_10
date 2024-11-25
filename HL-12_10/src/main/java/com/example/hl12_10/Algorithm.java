package com.example.hl12_10;

public class Algorithm {
    private String name;
    private Double timeTaken;
    private Double memoryTaken;

    public Algorithm(String name, Double timeTaken, Double memoryTaken) {
        this.name = name;
        this.timeTaken = timeTaken;
        this.memoryTaken = memoryTaken;
    }

    public String getName() {
        return name;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public Double getMemoryTaken() {
        return memoryTaken;
    }
}
