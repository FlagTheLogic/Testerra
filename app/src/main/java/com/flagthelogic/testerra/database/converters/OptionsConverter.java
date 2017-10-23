package com.flagthelogic.testerra.database.converters;

import android.arch.persistence.room.TypeConverter;
import com.flagthelogic.testerra.database.entities.Questions;
import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 23.10.17.
 */

public class OptionsConverter {
    @TypeConverter
    public static List<Questions.Options> stringToOptions(String optionsString) {

        return null;
    }

    @TypeConverter
    public static String optionsToString(List<Questions.Options> options) {

        return null;
    }
}
