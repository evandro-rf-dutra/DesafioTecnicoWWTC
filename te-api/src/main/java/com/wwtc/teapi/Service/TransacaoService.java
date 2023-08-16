package com.wwtc.teapi.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.wwtc.teapi.Model.Transacao;

@Service
public class TransacaoService {

    private ArrayList<Transacao> listaTransacao;

    /**
     * construtor da classe.
     */
    public TransacaoService(){
        this.listaTransacao = new ArrayList<Transacao>();
        adicionaAlgumasTransacoes();
    }

    // lista sera criada e armazenada aqui
    private void adicionaAlgumasTransacoes(){
        this.listaTransacao.add(new Transacao(1000.12, "25/10/2020"));
        this.listaTransacao.add(new Transacao(1200.00, "30/08/2021"));
        
    }

    public ArrayList<Transacao> retornaTransacao(){
        return this.listaTransacao;
    }
    
}
