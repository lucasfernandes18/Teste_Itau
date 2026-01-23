package Java10x.Itau;

import Java10x.Itau.Estatisticas.EstataisticaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Repository
public class TransacaoRepository {

    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();



    //salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacao) {
        listaDeTransacoes.add(transacao);
    }


    //apagar a lista depiois de 60 segundos
    public  void limparDados(TransacaoDTO transacao){

    }
    //apagar todas as transações da lista

    public void deletarDados(){
        listaDeTransacoes.clear();
    }

    public EstataisticaDTO exibirEstatisticas (OffsetDateTime horaInicial){
        if(listaDeTransacoes.isEmpty()){
            return new EstataisticaDTO(0L,0.0,0.0,0.0,0.0);
        }

// transformar a lista de transações em números para fazer uma operação.
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.dataHora().isAfter(horaInicial) || t.dataHora().isEqual(horaInicial)
                )
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

                return new EstataisticaDTO(
                        summary.getCount(),
                        summary.getAverage(),
                        summary.getMax(),
                        summary.getMin(),
                        summary.getSum());


    }
}














