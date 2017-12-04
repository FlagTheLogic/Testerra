package com.flagthelogic.testerra.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;

import com.flagthelogic.testerra.database.converters.DateConverter;
import com.flagthelogic.testerra.database.converters.OptionsConverter;
import com.flagthelogic.testerra.database.dao.QuestionsDao;
import com.flagthelogic.testerra.database.dao.TestsDao;
import com.flagthelogic.testerra.database.entities.Question;
import com.flagthelogic.testerra.database.entities.Result;
import com.flagthelogic.testerra.database.entities.Test;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 18.10.17.
 */
@Database(entities = {Test.class, Question.class, Result.class},
          version = 5,
          exportSchema = false)
@TypeConverters({OptionsConverter.class, DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract TestsDao testsDao();
    public abstract QuestionsDao questionsDao();

    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE tests ADD COLUMN test_column INTEGER NOT NULL DEFAULT 0");
        }
    };
    public static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            /*
            * все поля INTEGER нужно устанавливать в NOT NULL
            * embedded поля воспринимаются как текст вне зависимости от внутренностей  POJO обьекта
            * текстовые поля все ОК
            * */
            database.execSQL("CREATE TABLE tests_new " +
                    "(id INTEGER NOT NULL," +
                    "title TEXT," +
                    "author TEXT," +
                    "description TEXT," +
                    "test_completed INTEGER NOT NULL DEFAULT 0," +
                    "category INTEGER NOT NULL DEFAULT 0," +
                    "param1 TEXT," +
                    "param2 INTEGER," +
                    "logic_type INTEGER NOT NULL," +
                    "instruction TEXT," +
                    " PRIMARY KEY(id))");
            database.execSQL("INSERT INTO tests_new (id,title,author,description," +
                    "test_completed,category,param1,param2,logic_type,instruction)" +
                    " SELECT id,title,author,description," +
                    "test_completed,category,param1,param2,logic_type,instruction" +
                    " FROM tests");
            database.execSQL("ALTER TABLE tests RENAME TO tests_old");
            database.execSQL("ALTER TABLE tests_new RENAME TO tests");
            database.execSQL("DROP TABLE tests_old");
        }
    };


}
