package com.letscode.banco811.service.impl;

import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.TipoConta;
import com.letscode.banco811.projections.ContaView;
import com.letscode.banco811.repository.ContaRepository;
import com.letscode.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Override
    public ContaResponse create(ContaRequest contaRequest) {
        var usuario = usuarioService.getById(contaRequest.getUsuarioId());
        Conta conta = new Conta(contaRequest,usuario);
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public List<ContaView> getAllByTipoConta(TipoConta tipoConta){
        return contaRepository.findAllByTipoConta(tipoConta);
    }
}
