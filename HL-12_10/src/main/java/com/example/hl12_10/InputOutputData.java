package com.example.hl12_10;

import javafx.beans.property.SimpleStringProperty;

public class InputOutputData {
    private final SimpleStringProperty inputData;
    private final SimpleStringProperty outputData;

    public InputOutputData(String inputData, String outputData) {
        this.inputData = new SimpleStringProperty(inputData);
        this.outputData = new SimpleStringProperty(outputData);
    }

    public String getInputData() {
        return inputData.get();
    }

    public void setInputData(String inputData) {
        this.inputData.set(inputData);
    }

    public String getOutputData() {
        return outputData.get();
    }

    public void setOutputData(String outputData) {
        this.outputData.set(outputData);
    }
}

