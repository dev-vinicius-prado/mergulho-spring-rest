package com.algaworks.algalog.domain.services;

import com.algaworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    /*
     * Não há necessidade de chamar um método de persistência, em função da sincronização do Jakarta Persistence.
     * Como há alteração no objeto {@Link Entrega}, ao fim da transação, os objetos envolvidos serão salvos.
     */
    @Transactional
    public Ocorrencia registrar(Long idEntrega, String descricao) {
        var entrega = buscaEntregaService.buscar(idEntrega);
        return entrega.adicionarOcorrencia(descricao);
    }
}
