package com.test.botalov.resultanttestapplication.Application;

import android.app.Application;
import android.content.Context;

public class ApplicationTest extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationTest.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ApplicationTest.context;
    }
}
