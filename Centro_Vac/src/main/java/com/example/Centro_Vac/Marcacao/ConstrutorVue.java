package com.example.Centro_Vac.Marcacao;
public class ConstrutorVue {
    private String utilizador ;
    private String centro;
    private String marcacao;

    public ConstrutorVue() {
    }

    public ConstrutorVue(String utilizador, String centro, String marcacao) {
        this.utilizador = utilizador;
        this.centro = centro;
        this.marcacao = marcacao;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

    @Override
    public String toString() {
        return "ConstrutorVue{" +
                "utilizador='" + utilizador + '\'' +
                ", centro='" + centro + '\'' +
                ", marcacao='" + marcacao + '\'' +
                '}';
    }
}
