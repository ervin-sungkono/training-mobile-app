package com.ervincs.trainingandroid_pert2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "NewsDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NEWS = "News";
    public static final String FIELD_NEWS_ID = "id";
    public static final String FIELD_NEWS_TITLE = "title";
    public static final String FIELD_NEWS_DESCRIPTION = "description";

    private static final String CREATE_TABLE_NEWS = "CREATE TABLE IF NOT EXISTS " + TABLE_NEWS + " (" + FIELD_NEWS_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + FIELD_NEWS_TITLE + " TEXT UNIQUE," + FIELD_NEWS_DESCRIPTION
            + " TEXT)";

    private static final String DROP_TABLE_NEWS = "DROP TABLE IF EXISTS " + TABLE_NEWS;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_NEWS);
        onCreate(db);
    }
}
