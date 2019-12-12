package com.example.apptodo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.apptodo.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private static TarefaDAO instance;
    private SQLiteDatabase db;
    private Helper helper;

    public TarefaDAO(Context context) {
        helper = new Helper(context);
    }

    public void atualizarTarefa(Tarefa tarefa) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("descricao", tarefa.getDescricao());
        values.put("data", tarefa.getData());
        values.put("feito", true);

        String where[] = {String.valueOf(tarefa.getId())};

        db.update("tarefa", values, "id = ?", where);
    }

    public void addNovaTarefa(Tarefa tarefa) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("descricao", tarefa.getDescricao());
        values.put("data", tarefa.getData());

        db.insert("tarefa", null, values);
    }

    public void removerTarefa(Tarefa tarefa) {


    }

    public List<Tarefa> getTarefa() {
        db = helper.getWritableDatabase();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM tarefa ");
        Cursor cursor = db.rawQuery(query.toString(), null);

        List<Tarefa> tarefas = new ArrayList<>();

        if (cursor == null) {
            return tarefas;
        }

        Tarefa tarefa;
        while (cursor.moveToNext()) {
            tarefa = new Tarefa();

            tarefa.setId(cursor.getInt(0));
            tarefa.setDescricao(cursor.getString(1));
            tarefa.setData(cursor.getString(2));
            tarefas.add(tarefa);
        }
        return tarefas;
    }
}
