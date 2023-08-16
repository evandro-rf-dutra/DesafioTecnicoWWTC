package com.wwtc.teapi.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wwtc.teapi.Model.Transacao;
import com.wwtc.teapi.Service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    /**
     * método que retorna a lista completa de transacoes.
     * @return listaTransacao - ArrayList
     */
    @GetMapping
    public ArrayList<Transacao> retornaTransacao(){
        return service.retornaTransacao();
    }
    
}
