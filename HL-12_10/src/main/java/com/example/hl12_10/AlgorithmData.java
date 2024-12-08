package com.example.hl12_10;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class AlgorithmData {
    private final SimpleStringProperty type;
    private final SimpleLongProperty timeTaken;
    private final SimpleLongProperty memoryTaken;

    public AlgorithmData(String name, long timeTaken, long memoryTaken) {
        this.type = new SimpleStringProperty(name);
        this.timeTaken = new SimpleLongProperty(timeTaken);
        this.memoryTaken = new SimpleLongProperty(memoryTaken);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public long getTimeTaken() {
        return timeTaken.get();
    }

    public SimpleLongProperty timeTakenProperty() {
        return timeTaken;
    }

    public long getMemoryTaken() {
        return memoryTaken.get();
    }

    public SimpleLongProperty memoryTakenProperty() {
        return memoryTaken;
    }
}
