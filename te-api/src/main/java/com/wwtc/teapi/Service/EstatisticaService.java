package com.wwtc.teapi.Service;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwtc.teapi.Model.Estatistica;

@Service
public class EstatisticaService {
    
    @Autowired
    private TransacaoService service; // usando o service de Transacao para acessar a lista

    // este valor pode ser alterado pela interface grafica depois... por parâmetro no get
    private long intervaloDeTempoEmSegundos = 60;
    

    public Estatistica retornaEstatistica(){

        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();

        // VERIFICAR QUAIS SAO AS TRANSACOES <60 SEG
            // 1 Converter as duas datas em segundos(timestamp), e subtrair por 60 e por fim COMPARA-LAS.
            // OU SOMAR 60 SEGUNDOS EM  CADA DATA, E DEPOIS UTILIZAR O METODO IsAfter (mais facil).
        // ADICIONAR OS VALORES DESSAS TRANSACOES NA DOUBLESUMARYSTATISTICS
        // GERAR OS DADOS E COLOCA-LOS NO OBJETO ESTATISTICAS, por fim retornar.


        // LocalDateTime i = LocalDateTime.now();
        // Timestamp timestamp = Timestamp.valueOf(i);
        // System.out.println(timestamp.getTime());

        service.retornaTransacao().forEach( i -> {
            
            // se a hora da transação + 60 segundos for maior que a hora atual
            // ou seja, se a hora da transação + 60 segundos estiver no futuro
            // então significa que está no intervalo de tempo pre definido
            if((i.getDataHora().plusSeconds(this.intervaloDeTempoEmSegundos)).isAfter(LocalDateTime.now())){

                doubleSummaryStatistics.accept(i.getValor());
            }
        });

        Estatistica estatistica = new Estatistica();
        
        estatistica.setCount( doubleSummaryStatistics.getCount() );
        estatistica.setSum( doubleSummaryStatistics.getSum() );
        estatistica.setAvg( doubleSummaryStatistics.getAverage() );

        if(estatistica.getCount() != 0){
            // precisa desse if, senao retorna infinity
            estatistica.setMin( doubleSummaryStatistics.getMin() );
            estatistica.setMax( doubleSummaryStatistics.getMax() );
        }else{
            estatistica.setMin( 0 );
            estatistica.setMax( 0 );
        }
        
        return estatistica;

    }
    
}
