package com.epic.epicsports;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.onesignal.OneSignal;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;

public class ApplicationClass extends Application {

    private static final String ONESIGNAL_APP_ID = "45997b1f-6d91-4645-b347-495f94584f6d";

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable verbose OneSignal logging to debug issues if needed.
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        StartAppSDK.init(this, "207218939", false);
        StartAppAd.disableSplash();
        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}