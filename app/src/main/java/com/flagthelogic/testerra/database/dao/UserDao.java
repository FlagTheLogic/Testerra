package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.User;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    User selectUser();

    @Insert
    void insertNewUser(User user);
}
