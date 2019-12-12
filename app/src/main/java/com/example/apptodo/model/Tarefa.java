package com.example.apptodo.model;

public class Tarefa {
    private Integer id;
    private String descricao;
    private String data;
    private Boolean feito = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getFeito() {
        return feito;
    }

    public void setFeito(Boolean feito) {
        this.feito = feito;
    }
}
