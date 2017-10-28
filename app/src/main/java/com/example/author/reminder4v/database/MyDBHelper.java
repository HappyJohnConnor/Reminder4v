package com.example.author.reminder4v.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by author on 2017/09/25.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "reminder.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "reminder_record";
    public static final String COL_ID = "_id";
    public static final String COL_SUBJECT = "title";
    public static final String COL_BODY = "body";
    public static final String COL_HAS_REMIND = "has_remind";
    public static final String COL_DATE = "date";

    private static final String CREATE_TABLE_SQL =
            "create table " + TABLE_NAME + " "
                    + "(" + COL_ID + " integer primary key autoincrement,"
                    + COL_SUBJECT + " text not null,"
                    + COL_BODY + " text not null,"
                    + COL_HAS_REMIND + " integer default 0,"
                    + COL_DATE + " integer)";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}