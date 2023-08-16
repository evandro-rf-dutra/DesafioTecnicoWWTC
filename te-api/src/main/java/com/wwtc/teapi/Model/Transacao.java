package com.wwtc.teapi.Model;

public class Transacao {

    private double valor;
    private String dataHora; // mudar para LocalDate...

    public Transacao(double valor, String dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
     
}
