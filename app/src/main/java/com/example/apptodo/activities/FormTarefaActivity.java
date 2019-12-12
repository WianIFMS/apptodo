package com.example.apptodo.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apptodo.R;

import com.example.apptodo.dao.TarefaDAO;
import com.example.apptodo.model.Tarefa;


public class FormTarefaActivity extends AppCompatActivity {
    private Button botaoSalvar;
    private Button botaoTarefaFeita;
    private EditText campoDescricao;
    private EditText campoData;
    private TarefaDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Nova Tarefa");
        setContentView(R.layout.activity_form_tarefa);
        inicializarDAO();
        inicializarReferencias();
        inicializarAcoes();
    }

    private void inicializarDAO() {
        dao = new TarefaDAO(getBaseContext());
    }

    private void inicializarReferencias() {

        campoDescricao = findViewById(R.id.campoDescricaoTarefa);
        campoData = findViewById(R.id.campoData);
        botaoSalvar = findViewById(R.id.campoBotaoSalvar);

    }

    private void inicializarAcoes() {
        final Tarefa tarefa = new Tarefa();
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                tarefa.setDescricao(campoDescricao.getText().toString());
                tarefa.setData(campoData.getText().toString());
                dao.addNovaTarefa(tarefa);

                Intent intent = new Intent(FormTarefaActivity.this, ListTarefaActivity.class);
                startActivity(intent);

            }
        });

    }

}