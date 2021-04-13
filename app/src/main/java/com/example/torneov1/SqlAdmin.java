package com.example.torneov1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlAdmin  extends SQLiteOpenHelper {

    public SqlAdmin(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table torneosv1a" +
                "(ntorneo text, categoria text, liga text, valor int)");

        db.execSQL("create table equipov1a" +
                "(nequipo text, torneop text, capitan text, ncelular text)");

        db.execSQL("create table partidosv1a" +
                "(nequipoa text, nequipob text, dia int,hora int, idpartido int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
