package Java10x.Itau.Estatisticas;

import Java10x.Itau.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {
    @Autowired
    private  TransacaoRepository transacaoRepository;

    @Autowired
    private  EstatisticaProperties estatisticaProperties;


    @GetMapping
    public ResponseEntity exibirEstatisticas() {
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
return ResponseEntity.ok(transacaoRepository.exibirEstatisticas(horaInicial));

    }


}
