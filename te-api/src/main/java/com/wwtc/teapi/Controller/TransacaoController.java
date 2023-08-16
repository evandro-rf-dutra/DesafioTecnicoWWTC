package com.wwtc.teapi.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @return ArrayList<Transacao>
     */
    @GetMapping
    public ArrayList<Transacao> retornaTransacao(){
        return service.retornaTransacao();
    }


    /**
     * 
     * Adiciona a nova transacao na lista de transacoes, caso adicionado com sucesso retorna 201.
     * Recebe a transacao no formato "valor":111.11, "dataHora": "dd/mm/aaaa hh/mm/ss".
     * 
     */
    @PostMapping
    public ResponseEntity<Transacao> salvarTransacao(@RequestBody Transacao transacao){
        // (jackson realiza o mapeamento json -> classe Transacao)

        boolean teste = service.salvarTransacao(transacao);
        
        if(teste){
            return new ResponseEntity<>(null, HttpStatus.CREATED); // 201
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        // se a requisição for em formato errado retorna 400 por default
    }
    
}
