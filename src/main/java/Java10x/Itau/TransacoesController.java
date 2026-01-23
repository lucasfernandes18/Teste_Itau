package Java10x.Itau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    public ResponseEntity deletar (){
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
