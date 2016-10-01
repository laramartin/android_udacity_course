package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lara on 25/09/2016.
 */
public class PetDbHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "shelter.db";
    private final static int DB_VERSION = 1;


    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_PETS = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + "(" +
                PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL," +
                PetContract.PetEntry.COLUMN_PET_BREED + " TEXT," +
                PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL DEFAULT 0," +
                PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL" + ")";
        Log.v("PetDbHelper", "create table: " + CREATE_TABLE_PETS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PETS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
