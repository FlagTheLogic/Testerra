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

public class Converters {
    @TypeConverter
    public static Questions.POJOOptions stringToOptions(String optionsString) {
        String[] options = optionsString.split("|");
        String[] idsInStrings = options[0].split(".");
        String[] titles = options[1].split(".");
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < idsInStrings.length; i++) {
            ids.add(Integer.parseInt(idsInStrings[i]));
        }
        return new Questions.POJOOptions(ids, Arrays.asList(titles));
    }

    @TypeConverter
    public static String optionsToString(Questions.POJOOptions options) {
        String ids = "";
        String titles = "";
        for (int i = 0; i < options.getIds().size(); i++) {
            if (i != options.getIds().size()) {
                ids += options.getIds().get(i) + ".";
                titles += options.getTitles().get(i) + ".";
            } else {
                ids += options.getIds().get(i);
                titles += options.getTitles().get(i);
            }
        }
        return ids + "|" + titles;
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
