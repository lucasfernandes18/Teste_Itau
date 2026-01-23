package Java10x.Itau;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transacao{


    private Long id;

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public Transacao(TransacaoDTO transacaoDTO) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
    }

}
