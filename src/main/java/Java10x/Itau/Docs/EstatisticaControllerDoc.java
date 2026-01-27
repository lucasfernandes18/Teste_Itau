package Java10x.Itau.Docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.ResourceBundle;


@Tag(name = "Estatísticas",
        description = "EndPoints responsáveis por retornar as estatísticas das operações")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Retorna as estatisticas",
            description = "valida se as estatísticas são dos últimos 60 segundos e as retornam")

    @ApiResponse(
            responseCode="201",
            description = "Estatísticas retornadas"
    )
    ResponseEntity<Void> exibirEstatisticas();



}
