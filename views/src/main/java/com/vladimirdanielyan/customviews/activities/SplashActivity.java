package com.vladimirdanielyan.customviews.activities;

import android.os.Bundle;
import android.os.Handler;

import com.vladimirdanielyan.customviews.R;
import com.vladimirdanielyan.customviews.preference_manager.UserLoggedInStatusPreferenceManager;

public abstract class SplashActivity extends FullScreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        showWelcomePage();
    }

    private void showWelcomePage() {
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                checkUserAuth();
            }
        };
        handler.postDelayed(r, 1500);
    }

    private void checkUserAuth() {
        UserLoggedInStatusPreferenceManager prefManager = new UserLoggedInStatusPreferenceManager(this);

        if (prefManager.isLoggedIn()) {
            launchHomePageActivity();
        } else {
            launchLoginPageActivity();
        }
    }

    public abstract void launchHomePageActivity();

    public abstract void launchLoginPageActivity();
}
