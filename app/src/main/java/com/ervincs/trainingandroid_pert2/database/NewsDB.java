package com.ervincs.trainingandroid_pert2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ervincs.trainingandroid_pert2.models.News;

import java.util.ArrayList;

public class NewsDB {

    DBHelper dbHelper;

    public NewsDB(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void insertNews(News news){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.FIELD_NEWS_TITLE, news.getNewsTitle());
        contentValues.put(DBHelper.FIELD_NEWS_DESCRIPTION, news.getNewsDescription());
        db.insert(DBHelper.TABLE_NEWS, null, contentValues);
        db.close();
    }

    public ArrayList<News> getAllNews(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NEWS, null);
        ArrayList<News> newsArrayList= new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String title =
                        cursor.getString(
                            cursor.getColumnIndex(DBHelper.FIELD_NEWS_TITLE));
                String description =
                        cursor.getString(
                                cursor.getColumnIndex(DBHelper.FIELD_NEWS_DESCRIPTION));
                newsArrayList.add(new News(title, description));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return newsArrayList;
    }

    public void updateNews(int i, String newsTitle, String newsDescription){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NEWS,
                null,
                null,
                null,
                null,
                null,
                null);
        if(cursor.moveToPosition(i)){
            String id = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_NEWS_ID));
            ContentValues contentValue = new ContentValues();
            contentValue.put(DBHelper.FIELD_NEWS_TITLE, newsTitle);
            contentValue.put(DBHelper.FIELD_NEWS_DESCRIPTION, newsDescription);
            db.update(DBHelper.TABLE_NEWS, contentValue, "id=?", new String[]{id});
        }
        cursor.close();
        db.close();
    }

    public void deleteNews(int i){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NEWS,
                null,
                null,
                null,
                null,
                null,
                null);
        if(cursor.moveToPosition(i)){
            String id = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_NEWS_ID));
            db.delete(DBHelper.TABLE_NEWS, "id=?", new String[]{id});
        }
        cursor.close();
        db.close();
    }
}
