package com.d3ltcod.androidnotifyreciver;

import android.app.Application;
import android.util.Log;

import com.onesignal.OneSignal;

import org.json.JSONObject;

public class Notify extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this).init();
    }

    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
            try {
                if (additionalData != null) {
                    if (additionalData.has("actionSelected"))
                        Log.d("OneSignalExample", "OneSignal notification button with id " + additionalData.getString("actionSelected") + " pressed");

                    Log.d("OneSignalExample", "Full additionalData:\n" + additionalData.toString());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}