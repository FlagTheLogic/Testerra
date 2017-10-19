package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.UserResults;

import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 19.10.17.
 */
@Dao
public interface UserResultsDao {
    /*TODO: добавить запрос
      select results.value from results where results.result_id = user_results.result_id
      или вызывать getResultForTest(
    */

    @Query("SELECT * FROM user_results")
    List<UserResults> getAllResults();

    @Query("SELECT * FROM user_results WHERE test_id =")
    @Insert
    void insertResult(UserResults userResult);
}
