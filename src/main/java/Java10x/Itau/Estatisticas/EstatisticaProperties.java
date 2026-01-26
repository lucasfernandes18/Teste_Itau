package Java10x.Itau.Estatisticas;


import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
        Integer segundos
) {
        public EstatisticaProperties{
                if (segundos != 60) {
                        throw new IllegalArgumentException("os segundos devem ser igual a 60");
                }
        }

}

