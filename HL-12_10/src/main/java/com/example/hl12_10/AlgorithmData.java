package com.example.hl12_10;

public class AlgorithmData {
    private String name;
    private Double timeTaken;
    private Double memoryTaken;

    public AlgorithmData(String name, Double timeTaken, Double memoryTaken, String[] input, String[] output) {
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
