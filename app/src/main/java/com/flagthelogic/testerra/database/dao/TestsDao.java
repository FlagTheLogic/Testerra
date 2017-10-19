package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.Tests;

import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Dao
public interface TestsDao {
    @Query("SELECT * FROM tests")
    List<Tests> getAll();

    @Query("SELECT * FROM tests WHERE id =:testId")
    Tests getTestById(int testId);

    @Query("SELECT * FROM tests WHERE id IN (:testIds)")
    List<Tests> getTestsByIds(int[] testIds);

    @Query("SELECT * FROM tests WHERE category = :category")
    List<Tests> getTestsByCategory(int category);

    @Insert
    void insertNewTest(Tests test);
}
