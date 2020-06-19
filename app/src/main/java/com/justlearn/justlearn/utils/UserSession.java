package com.justlearn.justlearn.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.annotations.SerializedName;

public class UserSession {

    @SerializedName("full_name")
    private String fullName;
    @SerializedName("token")
    private String authToken;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getToken(Context context)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString("AUTHTOKEN", "");
    }

    public void setToken(String token)
    {
        this.authToken = token;
    }

    public static boolean clearSession(Context context)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        return editor.commit();
    }

    public boolean saveUserSession(Context context)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("FULLNAME", fullName);
        editor.putString("AUTHTOKEN", authToken);
        editor.putString("EMAIL", getEmail());
        return editor.commit();
    }

}
