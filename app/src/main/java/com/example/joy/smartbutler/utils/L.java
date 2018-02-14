package com.example.joy.smartbutler.utils;

import android.util.Log;

/**
 * Created by joy on 2018/2/13.
 * 包名：com.example.joy.smartbutler.utils
 * 描述：
 */

public class L {
    public static final boolean DEBUG = true;

    public static final String TAG="SmartBulter";

    public static void d(String text){
        if(DEBUG){
            Log.d(TAG,text);
        }
    }
}
