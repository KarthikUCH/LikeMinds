package com.likeminds.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.likeminds.application.ApplicationComponent;
import com.likeminds.application.LikeMinds;
import com.likeminds.database.DbManager;

import javax.inject.Inject;

/**
 * Created by karthikeyan on 12/2/17.
 */

public abstract class InjectableActivity extends AppCompatActivity {

    @Inject
    DbManager mDbManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectComponent(((LikeMinds) getApplication())
                .getComponent());
    }

    abstract void injectComponent(ApplicationComponent component);


}
