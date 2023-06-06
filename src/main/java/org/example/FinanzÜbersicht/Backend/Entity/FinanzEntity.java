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
    private int id;
    private final Date date;
    private final double value;

    /**
     * Constructor FinanzEntity.
     * <p>
     *     Is used to return data of the database.
     * </p>
     * @param id the id of the database table.
     * @param date the date when value had been added.
     * @param value the value which had been added.
     */
    public FinanzEntity(int id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    /**
     * Constructor FinanzEntity.
     * <p>
     *     Is used to represent data of the client.
     * </p>
     * @param value the value of
     */
    public FinanzEntity(double value) {
        this.date = new Date(System.currentTimeMillis());
        this.value = value;
    }

    /**
     * Constructor FinanzEntity.
     * <p>
     *     Is used to return this object if an error in the service occurs.
     * </p>
     */
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
