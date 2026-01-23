package Java10x.Itau.Estatisticas;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {
}

