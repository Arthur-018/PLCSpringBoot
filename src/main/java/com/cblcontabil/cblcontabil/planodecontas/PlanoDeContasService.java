package com.cblcontabil.cblcontabil.planodecontas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoDeContasService {

    private PlanoDeContasRepository planoDeContasRepository;
    private PlanoDeContasMapper planoDeContasMapper;

    public PlanoDeContasService(PlanoDeContasRepository planoDeContasRepository, PlanoDeContasMapper planoDeContasMapper) {
        this.planoDeContasRepository = planoDeContasRepository;
        this.planoDeContasMapper = planoDeContasMapper;
    }

    public List<PlanoDeContasModel> listarConta(){
        return planoDeContasRepository.findAll();
    }

    public Optional<PlanoDeContasDTO> buscarContaPorCodigo(int codigo){
        return planoDeContasRepository.findByCodigo(codigo);
    }

    public PlanoDeContasDTO criarConta(PlanoDeContasDTO planoDeContasDTO){
        PlanoDeContasModel conta = planoDeContasMapper.map(planoDeContasDTO);
        conta = planoDeContasRepository.save(conta);
        return planoDeContasMapper.map(conta);
    }

    public void deletarPorCodigo(int codigo) {
        PlanoDeContasModel conta = planoDeContasRepository.findByCodigo(codigo)
                .orElse(null);

        planoDeContasRepository.delete(conta);
    }

    public PlanoDeContasModel atualizarConta(int codigo){
        PlanoDeContasModel conta = planoDeContasRepository.findByCodigo(codigo).orElse(null);
        return planoDeContasRepository.save(conta);
    }

}
