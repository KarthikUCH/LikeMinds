package com.likeminds.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.likeminds.application.ApplicationComponent;
import com.likeminds.application.LikeMinds;
import com.likeminds.database.ContactsSyncManager;

import javax.inject.Inject;

/**
 * Created by karthikeyan on 10/7/17.
 */

public class LikeMindsSyncAdapter extends AbstractThreadedSyncAdapter {

    private final AccountManager mAccountManager;
    private final Context mContext;

    @Inject
    ContactsSyncManager mContContactsSyncManager;

    public LikeMindsSyncAdapter(Context context, boolean autoInitialize, Application application) {
        super(context, autoInitialize);

        this.mContext = context;
        mAccountManager = AccountManager.get(mContext);
        injectComponent(((LikeMinds) application)
                .getComponent());
    }


    void injectComponent(ApplicationComponent component) {
        component.inject(this);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.i("SUCCESS", "Sync Adapter Success");

        mContContactsSyncManager.syncPhoneContacts();
    }


}
