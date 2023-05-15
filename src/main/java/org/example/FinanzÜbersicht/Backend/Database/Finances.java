package org.example.FinanzÜbersicht.Backend.Database;

import org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity;

import java.util.List;

/**
 * Interface Finances.
 * <p>
 *     Logic for FinanzService.
 * </p>
 */
public interface Finances {
    List<FinanzEntity> select();
    FinanzEntity selectById(int id);
    boolean create(FinanzEntity finanzEntity);
    boolean update(int id, FinanzEntity finanzEntity);
    boolean delete(int id);
}
