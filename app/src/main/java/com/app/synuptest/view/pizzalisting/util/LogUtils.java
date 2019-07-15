package com.app.synuptest.view.pizzalisting.util;

import android.util.Log;

public class LogUtils {
    static boolean shouldShowLog = true;

    public static void showLog(String message) {
        if (shouldShowLog) {
            Log.i("Log : ", message);
        }
    }
}
