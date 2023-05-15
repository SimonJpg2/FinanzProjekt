package org.example.FinanzÜbersicht.Backend.Entity;

public class FinanzEntity {
    private final int id;
    private final double value;

    public FinanzEntity(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public FinanzEntity() {
        this.id = -1;
        this.value = 0;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }
}
