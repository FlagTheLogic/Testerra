package com.flagthelogic.testerra.database;

import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.flagthelogic.testerra.database.entities.Questions;
import com.flagthelogic.testerra.database.entities.Tests;
import com.flagthelogic.testerra.objs.Question;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 19.10.17.
 */

public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
