package com.example.apptodo.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Helper extends SQLiteOpenHelper {

    public static String DB_NAME = "app_tarefas";
    public static Integer VERSION = 1;

    public Helper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableTarefa(db);

    }

    private void createTableTarefa(SQLiteDatabase db) {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE tarefa( ");
        query.append("id INTEGER PRIMARY KEY AUTOINCREMENT,");
        query.append("descricao TEXT, ");
        query.append("data TEXT,");
        query.append("feito BOOLEAN)");
        db.execSQL(query.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
