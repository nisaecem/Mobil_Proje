package com.example.tatliuygulamasi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TatliUygulamasi.db";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_TATLI = "Tatli";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ISIM = "isim";
    public static final String COLUMN_ACIKLAMA = "aciklama";
    public static final String COLUMN_RESIM = "resim";
    public static final String COLUMN_VIDEO = "video";
    public static final String COLUMN_MALZEMELER = "malzemeler";


    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_TATLI + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ISIM + " TEXT, " +
                    COLUMN_ACIKLAMA + " TEXT, " +
                    COLUMN_RESIM + " TEXT, " +
                    COLUMN_VIDEO + " TEXT, " +
                    COLUMN_MALZEMELER + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TATLI);
        onCreate(db);
    }
}

