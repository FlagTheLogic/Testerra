package com.flagthelogic.testerra.database;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.flagthelogic.testerra.database.entities.Questions;
import com.flagthelogic.testerra.database.entities.Tests;
import com.google.gson.Gson;

import java.util.Date;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 19.10.17.
 */

public class Converters {
    @TypeConverter
    public static Questions.POJOOptions stringToOptions(String jsonOptions) {
        return new Gson().fromJson(jsonOptions, Questions.POJOOptions.class);
    }

    @TypeConverter
    public static String optionsToString(Questions.POJOOptions options) {
        return options.toString();
    }

    @TypeConverter
    public static Tests.POJOParams stringToParams(String jsonParams) {
        return new Gson().fromJson(jsonParams, Tests.POJOParams.class);
    }

    @TypeConverter
    public static String testParamsToString(Tests.POJOParams params) {
        return params.toString();
    }

    @TypeConverter
    public static Date fromTimestamp(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
