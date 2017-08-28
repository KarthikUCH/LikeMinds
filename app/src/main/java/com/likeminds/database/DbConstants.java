package com.likeminds.database;

import com.likeminds.database.LikeMindsDbContract.ContactsColumns;

/**
 * Created by karthikeyan on 10/7/17.
 */

public class DbConstants {

    public static final String DB_NAME = "likeminds.db";
    public static final int DB_VERSION = 1;

    // Table List
    interface Tables {
        String CONTACTS = "contacts";
    }

    // CREATE TABLE SQL QUERY
    public static final String SQL_CREATE_CONTACTS_TABLE =
            "CREATE TABLE " + Tables.CONTACTS + "(" +
                    ContactsColumns.CONTACT_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    ContactsColumns.CONTACT_ID + " TEXT NOT NULL ," +
                    ContactsColumns.CONTACT_NAME + " TEXT NOT NULL ," +
                    ContactsColumns.CONTACT_NUMBER + "TEXT NOT NULL ," +
                    "UNIQUE (" + ContactsColumns.CONTACT_ID + ") ON CONFLICT IGNORE)";

    // DROP TABLE SQL QUERY
    public static final String SQL_DROP_CONTACTS_TABLE = "DROP TABLE IF EXISTS " + Tables.CONTACTS;
}

