package com.wwtc.teapi.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.wwtc.teapi.Model.Transacao;
import com.wwtc.teapi.Service.TransacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    /**
     * método que retorna a lista completa de transacoes.
     */
    @GetMapping
    public ArrayList<Transacao> retornaTransacao(){
        return service.retornaTransacao();
    }

    /**
     * 
     * Adiciona a nova transacao na lista de transacoes, caso adicionado com sucesso retorna 201.
     * Recebe a transacao no formato "valor":111.11, "dataHora": "formato LocalDataTime".
     * 
     */
    @PostMapping
    public ResponseEntity<Transacao> salvarTransacao(@RequestBody @Valid Transacao transacao){
        // (RequestBody realiza o mapeamento json -> classe Transacao)
        // os atributos que não foram passados no json serão setados com null ou 0 no atributo do objeto.
        // se o o json não etiver no mesmo formato do atributo da classe, entao retorna 400.

        boolean teste = service.salvarTransacao(transacao);
        
        if(teste){
            return new ResponseEntity<>(null, HttpStatus.CREATED); // 201
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        // se a requisição for em formato errado retorna 400 por default
    }

    @DeleteMapping
    @ResponseBody // descrição da resposta
    public ResponseEntity<String> deletarTransacoes(){

        service.deletarTransacoes();
        return new ResponseEntity<String>("Todas as transações foram removidas com sucesso!", HttpStatus.OK); // 200
    }

    /**
     * Metodo que intercepta a mensagem de erro 400,
     * retorna uma mensagem mais específica sobre o erro. TESTANDO
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        // MUDAR ISSO AQUI DEPOIS
        // de acordo com as notation colocadas nos models da para exibir mensagens de erro mais especificas
        // ou tmb deixar sem body ou criar mensagens padrao.

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    } 

    
}
