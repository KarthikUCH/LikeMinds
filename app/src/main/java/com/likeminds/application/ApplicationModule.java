package com.likeminds.application;

import android.app.Application;
import android.content.Context;

import com.likeminds.database.ContactsSyncManager;
import com.likeminds.database.DbManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by karthikeyan on 12/2/17.
 */

@Module
public class ApplicationModule {

    private Application mApp;

    ApplicationModule(Application app) {
        mApp = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApp;
    }

    @Provides
    DbManager provideDatabase() {
        return DbManager.getInstance(mApp);
    }

    @Provides
    @Singleton
    ContactsSyncManager provideContactsSyncManager(){
        return new ContactsSyncManager(mApp);
    }
}
