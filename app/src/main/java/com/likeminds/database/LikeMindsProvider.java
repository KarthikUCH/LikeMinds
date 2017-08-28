package com.likeminds.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.likeminds.database.DbConstants.*;
import com.likeminds.database.LikeMindsDbContract.*;

/**
 * Created by karthikeyan on 10/7/17.
 */

public class LikeMindsProvider extends ContentProvider {


    private static final int CONTACT_LIST = 1;
    private static final int CONTACT_ID = 2;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    //TODO : Inject this through Dagger
    private SQLiteDatabase mDb;

    static {
        /**
         * For {@link Tables.CONTACTS}
         */
        sUriMatcher.addURI(LikeMindsDbContract.AUTHORITY, Tables.CONTACTS, CONTACT_LIST);
        sUriMatcher.addURI(LikeMindsDbContract.AUTHORITY, Tables.CONTACTS + "/#", CONTACT_LIST);
    }

    @Override
    public boolean onCreate() {
        mDb = DbManager.getInstance(getContext()).getDbHelper();
        Log.i("SUCCESS", "ContentProviderSuccess");
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case CONTACT_LIST:
                return Contacts.CONTENT_TYPE;
            case CONTACT_ID:
                return Contacts.CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
