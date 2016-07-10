package com.dssp.recyclervieweverything.util;

/**
 * Created by dhanrajnaik522 on 7/10/2016.
 */

import android.util.Log;

public class MyLog {

    public static void e(String tag, String msg) {
        if (Constant.DEBUG) {

            Log.e(tag, msg);

        }
    }

}
