package com.justlearn.justlearn.utils;

import android.util.Log;

import com.google.gson.Gson;

public class Debugger {

    private static final String TAG = "JUSTLEARN";

    public static String printO(Object obj)
    {
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
        Log.d(TAG,gson.toJson(obj));
        return gson.toJson(obj);
    }

    public static void logD(String message)
    {
        Log.d(TAG, message);
    }

    public static void printException(Exception err)
    {
        Debugger.logD("Line " + err.getStackTrace()[0].getLineNumber());
        Debugger.logD(err.toString());
    }


    public static void logDInt(int value)
    {
        Log.d(TAG, String.valueOf(value));
    }

}