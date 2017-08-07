package com.vladimirdanielyan.customviews.preference_manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Danielyan on 6/5/17.
 * The Preference Manager Class
 */

public class UserLoggedInStatusPreferenceManager {
    private SharedPreferences userPreferenceManager;

    // Shared preferences file name
    private static final String IS_LOGGED_IN = "IsLoggedIn";


    @SuppressLint("CommitPrefEdits")
    public UserLoggedInStatusPreferenceManager(Context context) {
        int PRIVATE_MODE = 0;
        userPreferenceManager = context.getSharedPreferences(IS_LOGGED_IN, PRIVATE_MODE);
    }

    public void setLoggedInStatus() {
        SharedPreferences.Editor editor = userPreferenceManager.edit();
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.apply();
    }

    public void unsetLoggedInStatus() {
        SharedPreferences.Editor editor = userPreferenceManager.edit();
        editor.putBoolean(IS_LOGGED_IN, false);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return userPreferenceManager.getBoolean(IS_LOGGED_IN, false);
    }

}
