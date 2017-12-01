package com.flagthelogic.testerra.database.converters;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import java.util.Date;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 19.10.17.
 */

public class DateConverter {
    private static final String TAG = "Date CNV";

    @TypeConverter
    public static Date timestampToDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
