package com.example.my.cammertest;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperClass {
    /**
     * 获取格式化日期字符串,精确到四位毫秒
     *
     * @param date
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getDateFormatToString(Date date) {
        if (date == null)
            date = new Date();
        String formatStr = new String();
        SimpleDateFormat matter = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ssSSS");
        formatStr = matter.format(date);
        return formatStr;
    }

    /**
     * 将时间字符串后五位截取，并转换成double类型，为了获取毫秒
     * @param str
     * @return
     */
    public static double getDateStringToDouble(String str){
        str = str.substring(str.length()-5);
        double d = Double.parseDouble(str);
        return d;
    }
}
