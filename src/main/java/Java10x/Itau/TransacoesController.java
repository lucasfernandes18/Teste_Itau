package Java10x.Itau;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private TransacaoRepository transacaoRepository;




    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacao){
        try{
            transacaoService.validarTransacao(transacao);
            transacaoRepository.salvarDados(transacao);
            log.info("Transação aceita");
            return ResponseEntity.status(HttpStatus.CREATED).build();


        }catch (IllegalArgumentException exception){
            log.info("erro em uma ou mais validações, tente novamente.");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();


        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    public ResponseEntity deletar (){
        transacaoRepository.deletarDados();
        log.info("Transações deletadas");
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
