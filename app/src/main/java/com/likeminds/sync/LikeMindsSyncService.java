package com.likeminds.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LikeMindsSyncService extends Service {

    private static final Object mSyncAdapterLock = new Object();
    private static LikeMindsSyncAdapter mSyncAdapter;

    public LikeMindsSyncService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return getSyncAdapter().getSyncAdapterBinder();
    }

    private LikeMindsSyncAdapter getSyncAdapter() {
        if (mSyncAdapter == null) {
            mSyncAdapter = new LikeMindsSyncAdapter(this, true, getApplication());
        }
        return mSyncAdapter;
    }
}
