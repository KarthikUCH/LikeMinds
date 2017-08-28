package com.likeminds.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LikeMindAuthenticatorService extends Service {

    private static final String TAG = LikeMindAuthenticatorService.class.getName();

    private LikeMindAuthenticator mLikeMindAuthenticator;

    public LikeMindAuthenticatorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return getAuthenticator().getIBinder();
    }

    private LikeMindAuthenticator getAuthenticator() {
        if (mLikeMindAuthenticator == null) {
            mLikeMindAuthenticator = new LikeMindAuthenticator(this);
        }
        return mLikeMindAuthenticator;
    }

}
