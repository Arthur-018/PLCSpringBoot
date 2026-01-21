package com.cblcontabil.cblcontabil.planodecontas;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String boasVindas(){
        return "Boas vindas";
    }

    @PostMapping("/criar")
    public PlanoDeContasDTO criarContas(@RequestBody PlanoDeContasDTO planoDeContasDTO){
        return planoDeContasService.criarConta(planoDeContasDTO);
    }

    @GetMapping("/listar")
    public List<PlanoDeContasModel> listarConta(){
        return planoDeContasService.listarConta();
    }

    @GetMapping("/buscarcontaporcodigo/{codigo}")
    public PlanoDeContasModel buscarPorCodigo(@PathVariable int codigo) {
        return planoDeContasService.buscarContaPorCodigo(codigo)
                .orElse(null);
    }

    @PutMapping("/alterarconta/{codigo}")
    public PlanoDeContasModel alterarConta(@PathVariable int codigo){
        PlanoDeContasModel conta = planoDeContasService.buscarContaPorCodigo(codigo)
                .orElse(null);
        if (conta != null){
            planoDeContasService.atualizarConta(codigo);
        }else {
            throw new RuntimeException("Conta do codigo" + codigo + "não encontrada");
        }
        return conta;
    }

    @DeleteMapping("/deletarconta/{codigo}")
    public void deletarConta(@PathVariable int codigo){
        PlanoDeContasModel conta = planoDeContasService.buscarContaPorCodigo(codigo)
                .orElse(null);

        if (conta != null) {
            planoDeContasService.deletarPorCodigo(codigo);
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }

}
