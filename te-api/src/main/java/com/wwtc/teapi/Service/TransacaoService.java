package com.wwtc.teapi.Service;
import java.time.LocalDateTime;
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
        this.listaTransacao.add(new Transacao(1000.12, LocalDateTime.now()));
        this.listaTransacao.add(new Transacao(1200.00, LocalDateTime.now()));
        
    }

    /**
     * método que retorna toda a lista de transações
     * @return ArrayList<Transacao>
     */
    public ArrayList<Transacao> retornaTransacao(){
        return this.listaTransacao;
    }

    /**
     * Metodo que recebe o objeto do tipo Transacao,
     * realiza as devidas validações, 
     * se dicionado com sucesso retorna true
     * @param transacao - Objeto do tipo transacao {double valor, Date dataHora}
     * @return boolean - true adicionadocom sucesso
     * */
    public boolean salvarTransacao(Transacao transacao) {

        // validacao da transacao se falhar retorna 422

        // Se foi passado um valor, e se é maior que zero.
        // isso tambem elimina a questao do valor nao ser passado no json
        if( transacao.getValor() > 0 ){
            // se foi passado a data e a hora e se esta no formato correto (notation jakarta na classe Transacao)
            //  e a dataHora da transacao deve ser no passado.
            if(transacao.getDataHora().isBefore(LocalDateTime.now())){
                //
                // tudo ok entao add na lista
                this.listaTransacao.add(transacao);
                return true;
            }
        }
        return false;
    }

    /** método que remove todos os itens da lista de transações */
    public void deletarTransacoes() {
        this.listaTransacao.clear();
        // PODERIA TER ALGUMA FORMA DE VALIDAR SE DELETOU MESMO
    }
    
}
