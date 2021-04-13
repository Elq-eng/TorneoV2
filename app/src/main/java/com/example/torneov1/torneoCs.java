package com.example.torneov1;

public class torneoCs {

    String Ntorneo, Liga, Categoria;
    int Valor;

    public torneoCs() {
    }


    public torneoCs(String ntorneo, String liga, String categoria, int valor) {
        Ntorneo = ntorneo;
        Liga = liga;
        Categoria = categoria;
        Valor = valor;
    }

    public String getNtorneo() {
        return Ntorneo;
    }

    public void setNtorneo(String ntorneo) {
        Ntorneo = ntorneo;
    }

    public String getLiga() {
        return Liga;
    }

    public void setLiga(String liga) {
        Liga = liga;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }
}
