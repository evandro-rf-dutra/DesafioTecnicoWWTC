package com.wwtc.teapi.Service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.wwtc.teapi.Model.Transacao;

@Service
public class TransacaoService {

    // lista onde serao armazenadas em memória as transações cadastradas pelo POST
    private ArrayList<Transacao> listaTransacao;

    /**
     * construtor da classe.
     * instancia e inicializa a lista.
     * adiciona alguns registros para testar o GET
     */
    public TransacaoService(){
        this.listaTransacao = new ArrayList<Transacao>();
        adicionaAlgumasTransacoes();
    }

    /**
     * metodo que adiciona dois registros pre definidos na lista de transações.
     */
    private void adicionaAlgumasTransacoes(){
        this.listaTransacao.add(new Transacao(1000.12, "25/10/2023 18:10:00")); // isso aqui vai ser do tipo date
        this.listaTransacao.add(new Transacao(1200.00, "30/08/2023 07:45:30"));
        
    }

    /**
     * método que retorna toda a lista de transações
     * @return ArrayList<Transacao>
     */
    public ArrayList<Transacao> retornaTransacao(){
        return this.listaTransacao;
    }

    // VALIDAR JSON
    ////  TESTAR SE É JSON ???
    ////  TESTAR SE TODOS AS VARIAVEIS FORAM PREENCHIDAS

    /**
     * Metodo que recebe o objeto do tipo Transacao,
     * realiza as devidas validações, 
     * se dicionado com sucesso retorna true
     * @param transacao - Objeto do tipo transacao {double valor, Date dataHora}
     * @return boolean - true adicionadocom sucesso
     * */
    public boolean salvarTransacao(Transacao transacao) {

        // validacao da transacao
        if( transacao.getValor() >= 0 ){
            if(transacao.getDataHora() != null){
                // IF transacao dataHora no passado
                this.listaTransacao.add(transacao);
                return true;
            }
        }
        return false;
    }
    
}
