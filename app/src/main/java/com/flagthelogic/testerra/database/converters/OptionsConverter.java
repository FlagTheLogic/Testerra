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
    private static final String TAG = "Options CNV";
    private final static String ID_TITLE_SEPARATOR = "-";
    private final static String OPTIONS_SEPARATOR = "|";

    @TypeConverter
    public static List<Questions.Options> stringToOptions(String optionsString) {
        Log.e(TAG, optionsString); // 1-t1|2-t2|3-t3
        List<Questions.Options> options = new ArrayList<>();
        String[] opts = optionsString.split("\\|");// ["1-t1","1-t1"]
//        for (String o: opts) {
//            Log.e(TAG, o);
//        }
        for (int i = 0; i < opts.length; i++) {
            Log.e(TAG, opts[i]);
        }
        for (int i = 0; i < opts.length; i++) {

            String[] pair = opts[i].split(ID_TITLE_SEPARATOR);

//            Log.e(TAG, pair[0]+" "+pair[1] +" length: "+pair.length);
            options.add(new Questions.Options(Integer.parseInt(pair[0]), pair[1]));
        }
        return options;
    }

    @TypeConverter
    public static String optionsToString(List<Questions.Options> options) {
        String optionsString = "";
        for (int i = 0; i < options.size(); i++) {
            String pair = options.get(i).getId() + ID_TITLE_SEPARATOR + options.get(i).getTitle();
            if (options.size()-1 != i) optionsString += pair + OPTIONS_SEPARATOR;
            else optionsString += pair;
        }
        return optionsString;
    }
}
