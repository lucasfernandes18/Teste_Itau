package Java10x.Itau;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoDTO(
        @NonNull
        BigDecimal valor,

        @NonNull
        OffsetDateTime dataHora
) {
}
