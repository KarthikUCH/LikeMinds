package com.likeminds.application;

import android.app.Application;

/**
 * Created by karthikeyan on 12/2/17.
 */

public class LikeMinds extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
