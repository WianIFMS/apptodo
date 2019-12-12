package com.example.apptodo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptodo.R;
import com.example.apptodo.model.Tarefa;


import java.util.ArrayList;
import java.util.List;


public class AdapterPersonalizado extends BaseAdapter {

    private List<Tarefa> tarefas;
    private AppCompatActivity activity;
    private Context context;

    public AdapterPersonalizado(AppCompatActivity activity) {
        this.tarefas = new ArrayList<>();
        this.activity = activity;
    }

    public void setTarefa(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        Tarefa tarefa = tarefas.get(position);
        return tarefa.getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_list_tarefas_list_item, parent, false);
        view.setBackgroundColor(Color.parseColor("red"));
        Tarefa tarefa = tarefas.get(position);

        TextView campoDescricao = view.findViewById(R.id.acitivity_list_tarefas_list_item_campo_descricao);
        TextView campoData = view.findViewById(R.id.acitivity_list_tarefas_list_item_campo_data);

        if (tarefa.getFeito() == true) {

            view.setBackgroundColor(Color.parseColor("green"));
            campoDescricao.setText("Tarefa " + tarefa.getId() + ":" + tarefa.getDescricao());
            campoData.setText(tarefa.getData());

            return view;
        }

        campoDescricao.setText("Tarefa " + tarefa.getId() + ":" + tarefa.getDescricao());
        //campoDescricao.setText(tarefa.getDescricao());
        campoData.setText(tarefa.getData());


        return view;
    }
}
