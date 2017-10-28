package com.example.author.reminder4v.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.author.reminder4v.model.ReminderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by author on 2017/09/28.
 */

public class ReminderRepository {
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public ReminderRepository(Context context) {
        this.mContext = context.getApplicationContext();
        mDatabase = new MyDBHelper(mContext).getReadableDatabase();
    }

    public List<ReminderItem> getAllItems() {
        List<ReminderItem> reminderList = new ArrayList<>();
        Cursor cursor = queryReminders(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                reminderList.add(getReminderItem(cursor));
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return reminderList;
    }

    public ReminderItem getReminderItem(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_ID));
        String subject = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_SUBJECT));
        String body = cursor.getString(cursor.getColumnIndex(MyDBHelper.COL_BODY));
        Boolean hasRemind=(cursor.getInt(cursor.getColumnIndex(MyDBHelper.COL_HAS_REMIND))==1);

        ReminderItem item = new ReminderItem(subject, body, id, hasRemind);
        return item;
    }

    public ReminderItem getReminderItem(String id){
        Cursor cursor= queryReminders(MyDBHelper.COL_ID +"=?", new String[]{id});

        try{
            if (cursor.getCount()==0){
                return null;
            }else {
                cursor.moveToFirst();
                return getReminderItem(cursor);
            }
        }finally {
            cursor.close();
        }
    }

    public Cursor queryReminders(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                MyDBHelper.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return cursor;
    }
}
