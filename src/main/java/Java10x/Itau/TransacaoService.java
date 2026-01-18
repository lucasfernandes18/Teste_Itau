package Java10x.Itau;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    public void validarTransacao(TransacaoDTO transacao) {
        //VALOR MAIOR OU IGUAL A ZERO
        if (transacao.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: A transação deve ter um valor maior que zero");
            //lança uma exceptional ao usuário de argumento inválido.
        }

        //DATA ATUAL OU MAIS ANTIGA
        if (transacao.dataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: A data da transação não é válida");
        }

        //DATA E HOR PRESENTES (BODY NÃO PODE SER VAZIO)
        if (transacao.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Erro: O valor digitado não é valido");
        }


        if (transacao.dataHora() == null){
            throw new IllegalArgumentException("Erro: A data e a hora da transação não podem ser nulas.");
        }
    }
}
