package com.wwtc.teapi.Model;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

public class Transacao {

    private double valor;

    @NotNull(message = "Campo não informado!")
    private LocalDateTime dataHora;

    public Transacao(double valor, LocalDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
     
}
