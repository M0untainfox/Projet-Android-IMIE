package com.example.mbp.projetandroidimie.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mbp on 04/12/2017.
 */

public class BDDSQLITE extends SQLiteOpenHelper {
    public static final String TABLE_PERSONNES = "tb_personnes";
    public static final String COL_ID = "ID";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    private static final String CREATE_TABLE_PERSONNE =
            "CREATE TABLE " + TABLE_PERSONNES + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NOM + " TEXT NOT NULL, "
                + COL_PRENOM + " TEXT NOT NULL);";

    public BDDSQLITE(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERSONNE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor read(SQLiteDatabase db){
        Cursor c = db.rawQuery("SELECT "+ COL_ID +" as '_id'," + COL_NOM +","+ COL_PRENOM +" FROM "+TABLE_PERSONNES,null);
        return c;
    }
}
