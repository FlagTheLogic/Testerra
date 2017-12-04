package com.flagthelogic.testerra.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.flagthelogic.testerra.database.entities.Question;

import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Dao
public interface QuestionsDao {
    @Query("SELECT * FROM questions WHERE test_id = :testId")
    List<Question> getQuestionsForTest(int testId);

    @Insert
    void insertQuestion(Question question);

    @Insert
    void insertQuestions(Question... questions);
}
