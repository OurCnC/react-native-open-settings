package com.opensettings;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = OpenSettings.MODULE_NAME)
public class OpenSettings extends ReactContextBaseJavaModule {

    static final String MODULE_NAME = "RNOpenSettings";

    private ReactContext reactContext;

    public OpenSettings(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return this.MODULE_NAME;
    }

    //region React Native Methods
    @ReactMethod
    public void openSettings() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //above android 8.0 jump to notification channels
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", reactContext.getPackageName());
        }
        //android 5.0-7.0 notification settings
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", reactContext.getPackageName());
            intent.putExtra("app_uid", reactContext.getApplicationInfo().uid);
        }
        //others
        if (Build.VERSION.SDK_INT < 21) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", reactContext.getPackageName(), null));
        }
        reactContext.startActivity(intent);
    }
    //endregion
}
