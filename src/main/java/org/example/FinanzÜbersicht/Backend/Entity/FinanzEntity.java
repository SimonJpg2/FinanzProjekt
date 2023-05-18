package org.example.FinanzÜbersicht.Backend.Entity;

import java.sql.Date;

/**
 * Class FinanzEntity.
 * <p>
 *     Represents data of finance entry.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class FinanzEntity {
    private final int id;
    private final Date date;
    private final double value;

    public FinanzEntity(int id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public FinanzEntity() {
        this.id = -1;
        this.date = new Date(System.currentTimeMillis());
        this.value = 0;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
