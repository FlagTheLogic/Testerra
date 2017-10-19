package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.Results;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Dao
public interface ResultsDao {
    @Query("SELECT * FROM results WHERE test_id = :testId")
    Results getAllResultsForTest(int testId);

    @Query("SELECT * FROM results WHERE test_id = :testId AND result_id = :resultId")
    Results getResultForTest(int testId, int resultId);

    @Insert
    void insertResult(Results result);

    @Insert
    void insertResults(Results... result);
}
