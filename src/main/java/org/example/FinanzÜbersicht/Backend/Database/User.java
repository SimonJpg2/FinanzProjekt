package org.example.FinanzÜbersicht.Backend.Database;

import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;

import java.util.List;

/**
 * Interface User.
 * <p>
 *     Logic for UserService.
 * </p>
 */
public interface User {
    List<UserEntity> select();
    UserEntity selectById(int id);
    boolean create(UserEntity userEntity);
    boolean update(int id, UserEntity userEntity);
    boolean delete(int id);
}
