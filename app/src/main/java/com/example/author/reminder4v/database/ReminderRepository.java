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
        String id = cursor.getString(cursor.getColumnIndex(MyDBHelper.COLUMN_ID));
        String subject = cursor.getString(cursor.getColumnIndex(MyDBHelper.COLUMN_SUBJECT));
        String body = cursor.getString(cursor.getColumnIndex(MyDBHelper.COLUMN_BODY));

        ReminderItem item = new ReminderItem(subject, body, id);
        return item;
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
