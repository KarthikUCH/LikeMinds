package com.likeminds.application;

import com.likeminds.sync.LikeMindsSyncAdapter;
import com.likeminds.ui.MainActivity;
import com.likeminds.ui.SignInActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by karthikeyan on 12/2/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(LikeMinds app);

    void inject(MainActivity activity);

    void inject(SignInActivity activity);

    void inject(LikeMindsSyncAdapter syncAdapter);
}
