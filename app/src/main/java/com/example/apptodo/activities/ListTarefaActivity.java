package com.example.apptodo.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptodo.R;

import com.example.apptodo.adapters.AdapterPersonalizado;
import com.example.apptodo.dao.TarefaDAO;
import com.example.apptodo.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ListTarefaActivity extends AppCompatActivity {
    private TarefaDAO dao;
    private ListView listView;
    private AdapterPersonalizado adapterPersonalizado;
    private FloatingActionButton botaoNovaTarefa;
    private Button botaoTarefaFeita;
    private EditText campoDescricao;
    private EditText campoData;
    private List<Tarefa> tarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tarefas");
        setContentView(R.layout.activity_list_tarefa);
        inicializarDAO();
        inicializarReferencias();
        inicializarListView();
        inicializarAcoes();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterPersonalizado.setTarefa(dao.getTarefa());

        listView.setAdapter(adapterPersonalizado);
        tarefas = dao.getTarefa();

    }

    private void inicializarDAO() {
        dao = new TarefaDAO(getBaseContext());
    }

    @SuppressLint("WrongViewCast")
    private void inicializarReferencias() {
        listView = findViewById(R.id.activity_list_tarefas_listview);
        botaoNovaTarefa = findViewById(R.id.activity_list_tarefa_botao_nova_tarefa);

        campoDescricao = findViewById(R.id.campoDescricaoTarefa);
        campoData = findViewById(R.id.campoData);
        botaoTarefaFeita = findViewById(R.id.buttonTarefaFeita);


        adapterPersonalizado = new AdapterPersonalizado(this);
        dao = new TarefaDAO(getBaseContext());
        listView.setAdapter(adapterPersonalizado);
        tarefas = dao.getTarefa();
    }

    private void inicializarListView() {
        adapterPersonalizado = new AdapterPersonalizado(this);
        listView.setAdapter(adapterPersonalizado);
    }

    private void inicializarAcoes() {
        botaoNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTarefaActivity.this, FormTarefaActivity.class);
                startActivity(intent);
            }
        });


              /*  botaoTarefaFeita.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setFeito(true);
                        dao.atualizarTarefa(tarefa);
                        adapterPersonalizado.setTarefa(dao.getTarefa());
                        listView.setAdapter(adapterPersonalizado);
                    }
                });*/
    }


    public void tarefaFeita(View view) {
        Toast.makeText(this, "Tarefa feita", Toast.LENGTH_SHORT).show();
    }
}
