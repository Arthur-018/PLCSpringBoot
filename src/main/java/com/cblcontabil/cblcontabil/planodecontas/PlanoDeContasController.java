package com.cblcontabil.cblcontabil.planodecontas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planodecontas")
public class PlanoDeContasController {

    private PlanoDeContasService planoDeContasService;

    public PlanoDeContasController(PlanoDeContasService planoDeContasService) {
        this.planoDeContasService = planoDeContasService;
    }

    @GetMapping
    public String boasVindas() {
        return "Boas vindas";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarContas(@RequestBody PlanoDeContasDTO conta) {
        PlanoDeContasDTO novaConta = planoDeContasService.criarConta(conta);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Conta criada com sucesso: " + novaConta.getDescricao() + " (Código): " + novaConta.getCodigo());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PlanoDeContasDTO>>  listarConta() {
        List<PlanoDeContasDTO> contas = planoDeContasService.listarConta();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/buscarcontaporcodigo/{codigo}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable int codigo) {
        PlanoDeContasDTO contaCodigo = planoDeContasService.buscarContaPorCodigo(codigo)
                .orElse(null);

        if (contaCodigo != null){
            return ResponseEntity.ok(contaCodigo);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta com o id: " + codigo + " não encontrada nos nossos registros.");
        }
    }

    @PutMapping("/alterarconta/{codigo}")
    public ResponseEntity<?> alterarConta(@PathVariable int codigo, @RequestBody PlanoDeContasDTO planoDeContasDTO) {

        PlanoDeContasDTO conta = planoDeContasService.atualizarConta(codigo, planoDeContasDTO);

        if (conta != null){
            return ResponseEntity.ok(conta);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta com o id: " + codigo + " não encontrada nos nossos registros.");
        }

    }

    @DeleteMapping("/deletarconta/{codigo}")
        public ResponseEntity<String> deletarConta(@PathVariable int codigo) {
        PlanoDeContasDTO conta = planoDeContasService.buscarContaPorCodigo(codigo)
            .orElse(null);
        if (planoDeContasService.buscarContaPorCodigo(codigo) != null){
            planoDeContasService.deletarPorCodigo(codigo);
            return ResponseEntity.ok("Conta com o código " + codigo + " excluída com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta com o código " + codigo + "não encontrada.");
        }


    }
}
