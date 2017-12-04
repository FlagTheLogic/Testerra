package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.Test;

import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Dao
public interface TestsDao {
    @Query("SELECT * FROM tests")
    List<Test> getAll();

    @Query("SELECT * FROM tests WHERE id =:testId")
    Test getTestById(int testId);

    @Query("SELECT * FROM tests WHERE id IN (:testIds)")
    List<Test> getTestsByIds(int[] testIds);

    @Query("SELECT * FROM tests WHERE category = :category")
    List<Test> getTestsByCategory(int category);

    @Insert
    void insertNewTest(Test test);
}
