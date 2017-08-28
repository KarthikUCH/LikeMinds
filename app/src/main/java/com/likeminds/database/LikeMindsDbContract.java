package com.likeminds.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.likeminds.database.DbConstants.*;

/**
 * The contract between clients and this 'Like Minds' content provider.
 * Created by karthikeyan on 10/7/17.
 */

public final class LikeMindsDbContract {

    /**
     * The authority of this 'LikeMind' provider.
     */
    public static final String AUTHORITY = "com.likeminds.database.LikeMindsProvider";

    /**
     * The content URI for the top-level 'sample app' authority.
     */
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    interface ContactsColumns {

        public static final String CONTACT_ROW_ID = BaseColumns._ID;
        public static final String CONTACT_ID = "contact_id";
        public static final String CONTACT_NAME = "contact_name";
        public static final String CONTACT_NUMBER = "contact_number";
    }

    public static final class Contacts implements ContactsColumns {

        /**
         * The content URI for {@link Tables#CONTACTS} table
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(LikeMindsDbContract.CONTENT_URI, Tables.CONTACTS);


        //TODO : FIND THE PURPOSE OF CONTENT TYPE
        //https://developer.android.com/guide/topics/providers/content-provider-creating.html#ContractClass
        /**
         * Content/Mime type for {@link Tables#CONTACTS} table
         */
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE+ "/vnd." + AUTHORITY + "."+Tables.CONTACTS;

        /**
         * Content/Mime type for items in {@link Tables#CONTACTS} table
         */
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE+ "/vnd." + AUTHORITY + "."+Tables.CONTACTS;


    }


}
