package com.example.joy.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by joy on 2018/2/14.
 * 包名：com.example.joy.smartbutler.utils
 * 描述：${CLASS_NAME}
 */

public class UtilTool {

    public static void setTypeFace(Context mContext, TextView textView){
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/FONT.TTF");
        textView.setTypeface(typeface);
    }
}
