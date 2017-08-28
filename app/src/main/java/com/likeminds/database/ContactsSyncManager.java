package com.likeminds.database;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by karthikeyan on 16/7/17.
 */

public class ContactsSyncManager {

    private final Context mContext;

    public ContactsSyncManager(Context context){
        this.mContext = context;
    }


    public void syncPhoneContacts(){

        Cursor contactsCursor = mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        while(contactsCursor.moveToNext()){
            String contactId = contactsCursor.getString(contactsCursor.getColumnIndex(ContactsContract.Contacts._ID));
            String hasPhone = contactsCursor.getString(contactsCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

            if(TextUtils.equals(hasPhone,"1")){

                Cursor phones = mContext.getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId, null, null);
                while (phones.moveToNext()) {
                    String phoneNumber = phones.getString(phones.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Log.i("Phone Numbers", phoneNumber);
                }
                phones.close();
            }

        }
    }
}
