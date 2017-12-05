package com.example.mbp.projetandroidimie.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by mbp on 04/12/2017.
 */

public class Personne_Manager {
    private static final String NOM_BDD = "BDD";
    private static final int VERSION_BDD = 1;

    private SQLiteDatabase bdd;
    private BDDSQLITE maBaseSQLite;

    public Personne_Manager(Context context){
        maBaseSQLite = new BDDSQLITE(context,NOM_BDD,null,VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public long insertPersonne(Personne p){
        ContentValues ctv = new ContentValues();
        ctv.put(BDDSQLITE.COL_NOM, p.getNom());
        ctv.put(BDDSQLITE.COL_PRENOM, p.getPrenom());
        return bdd.insert(BDDSQLITE.TABLE_PERSONNES, null, ctv);
    }

    public Cursor getAll(){
        return maBaseSQLite.read(bdd);
    }
}
