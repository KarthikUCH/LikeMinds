package com.likeminds.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by karthikeyan on 11/2/17.
 */

public class DbManager {

    private static final String TAG = DbManager.class.getName();

    private Context mContext;
    private static DbManager mDBManager;
    private SQLiteDatabase mDbHelper;

    public String testString() {
        return "works fine";
    }

    private DbManager(){

    }

    private DbManager(Context context) {
        mContext = context;
        mDbHelper = new DateBaseHelper(context).getWritableDatabase();
    }

    public SQLiteDatabase getDbHelper() {
        return mDbHelper;
    }

    public static DbManager getInstance(Context context) {
        if (mDBManager == null) {
            mDBManager = new DbManager(context);
        }
        return mDBManager;
    }

    private class DateBaseHelper extends SQLiteOpenHelper {
        public DateBaseHelper(Context context) {
            super(context, DbConstants.DB_NAME, null, DbConstants.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DbConstants.SQL_CREATE_CONTACTS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

                db.execSQL(DbConstants.SQL_DROP_CONTACTS_TABLE);
        }
    }
}
