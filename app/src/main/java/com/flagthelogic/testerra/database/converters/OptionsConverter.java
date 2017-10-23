package com.flagthelogic.testerra.database.converters;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import com.flagthelogic.testerra.database.entities.Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr Nahornyi on
 * device: dell
 * date: 23.10.17.
 */

public class OptionsConverter {
    private static final String TAG = "MyActivity";
    @TypeConverter
    public static List<Questions.Options> stringToOptions(String optionsString) {
        Log.e(TAG, optionsString);
        List<Questions.Options> options = new ArrayList<>();
        String[] opts = optionsString.split("\\|");
        for (String o:
             opts) {
            Log.e(TAG, o);
        }
        for (int i = 0; i < opts.length; i++) {
            String[] pair = opts[i].split("\\.");
            Log.e(TAG, pair[0]+" "+pair[1] +" length: "+pair.length);
            options.add(new Questions.Options(Integer.parseInt(pair[0]), pair[1]));
        }
        return options;
    }

    @TypeConverter
    public static String optionsToString(List<Questions.Options> options) {
        String optionsString = "";
        for (int i = 0; i < options.size(); i++) {
            String pair = options.get(i).getId() + "." + options.get(i).getTitle();
            if (options.size()-1 != i) optionsString += pair + "|";
            else optionsString += pair;
        }
        return optionsString;
    }
}
