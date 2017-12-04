package com.flagthelogic.testerra;

import android.util.SparseIntArray;

/**
 * Created by Volodymyr Nahorny on:
 * device: Lenovo
 * date: 04.12.2017
 */

public class Utils {
    public static int[] sparseIntArrToIntArr(SparseIntArray sparseIntArray) {
        int[] ints = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            ints[i] = sparseIntArray.valueAt(i);
        }
        return ints;
    }
}
