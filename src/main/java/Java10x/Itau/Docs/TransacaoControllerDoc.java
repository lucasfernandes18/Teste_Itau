package Java10x.Itau.Docs;

import Java10x.Itau.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(name = "Transações",
        description = "EndPoints responsáveis por criar transações")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria a transação",
            description = "Recebe a validação e adiciona em uma lista")

    @ApiResponse(
            responseCode="201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(
            responseCode="422",
            description = "Erro de validação capturado"
    )
    @ApiResponse(
            responseCode="400",
            description = "Erro Inesperado no servidor"
    )
    ResponseEntity<Void> adicionar(@RequestBody TransacaoDTO transacao);

    @Operation(summary = "Recebe a requisição de deleção",
            description = "Deleta a transação")

    @ApiResponse(
            responseCode="201",
            description = "Transação deletada"
    )
    ResponseEntity<Void> deletar();




}
