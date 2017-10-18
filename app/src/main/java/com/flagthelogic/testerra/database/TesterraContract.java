package com.flagthelogic.testerra.database;

import android.provider.BaseColumns;

/**
 * Created by Volodymyr Nahornyi on
 device: dell
 date: 17.10.17.
 */

class TesterraContract {
    private TesterraContract() {}

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String COMMA_SEP = ",";
    private static final String BRACKETS_OPEN = " ( ";
    private static final String BRACKETS_CLOSE = " ) ";
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";

    static final  String SQL_CREATE_TESTS =
            CREATE_TABLE + TestsEntry.TABLE_NAME + BRACKETS_OPEN +
                    TestsEntry._ID +                        INT_TYPE + PRIMARY_KEY + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_TITLE +          TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_AUTHOR +         TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_DESCRIPTION +    TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_LOGIC_TYPE +     TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_CATEGORY +       TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_TEST_COMPLETED + INT_TYPE  + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_PARAMS +         TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_INSTRUCTION +    TEXT_TYPE + BRACKETS_CLOSE;

    static final  String SQL_CREATE_OPTIONS =
            CREATE_TABLE + QuestionsEntry.TABLE_NAME + BRACKETS_OPEN +
                    QuestionsEntry._ID +                    INT_TYPE + PRIMARY_KEY + COMMA_SEP +
                    QuestionsEntry.COLUMN_NAME_TEST_ID +    INT_TYPE +  COMMA_SEP +
                    QuestionsEntry.COLUMN_NAME_QUESTION +   TEXT_TYPE + COMMA_SEP +
                    QuestionsEntry.COLUMN_NAME_OPTIONS +    TEXT_TYPE + COMMA_SEP +
                    TestsEntry.COLUMN_NAME_INSTRUCTION +    TEXT_TYPE + BRACKETS_CLOSE;

    static final  String SQL_CREATE_RESULTS =
            CREATE_TABLE + ResultsEntry.TABLE_NAME + BRACKETS_OPEN +
                    ResultsEntry._ID +                      INT_TYPE + PRIMARY_KEY + COMMA_SEP +
                    ResultsEntry.COLUMN_NAME_TEST_ID +      INT_TYPE +  COMMA_SEP +
                    ResultsEntry.COLUMN_NAME_VALUE +        TEXT_TYPE + COMMA_SEP + BRACKETS_CLOSE;

    static final  String SQL_DROP_TESTS =     DROP_TABLE + TestsEntry.TABLE_NAME;
    static final  String SQL_DROP_QUESTIONS = DROP_TABLE + QuestionsEntry.TABLE_NAME;
    static final  String SQL_DROP_RESULTS =   DROP_TABLE + ResultsEntry.TABLE_NAME;

    static abstract class TestsEntry implements BaseColumns {
        static final String TABLE_NAME = "tests";
        static final String COLUMN_NAME_TITLE= "title";
        static final String COLUMN_NAME_LOGIC_TYPE = "logic_type";
        static final String COLUMN_NAME_AUTHOR = "author";
        static final String COLUMN_NAME_DESCRIPTION = "description";
        static final String COLUMN_NAME_TEST_COMPLETED = "test_completed";
        static final String COLUMN_NAME_CATEGORY = "category";
        static final String COLUMN_NAME_PARAMS = "params";
        static final String COLUMN_NAME_INSTRUCTION = "instruction";
    }

    static abstract class QuestionsEntry implements BaseColumns {
        static final String TABLE_NAME = "questions";
        static final String COLUMN_NAME_TEST_ID = "test_id";
        static final String COLUMN_NAME_QUESTION = "question";
        static final String COLUMN_NAME_OPTIONS = "options";
    }

    static abstract class ResultsEntry implements BaseColumns {
        static final String TABLE_NAME = "results";
        static final String COLUMN_NAME_TEST_ID = "test_id";
        static final String COLUMN_NAME_VALUE = "value";
    }
}
