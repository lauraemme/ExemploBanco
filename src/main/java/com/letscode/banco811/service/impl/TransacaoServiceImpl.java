package com.letscode.banco811.service.impl;

import com.letscode.banco811.dto.requests.TransacaoRequest;
import com.letscode.banco811.dto.response.TransacaoResponse;
import com.letscode.banco811.model.Transacao;
import com.letscode.banco811.repository.TransacaoRepository;
import com.letscode.banco811.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaServiceImpl contaService;

    @Override
    public TransacaoResponse create(TransacaoRequest transacaoRequest, Integer contaId) {
        var conta = contaService.getById(contaId);

        Transacao transacao = new Transacao(transacaoRequest, conta);

        transacaoRepository.save(transacao);

        return new TransacaoResponse(transacao);
    }

    @Override
    public Page<Transacao> getAllByContaId(Integer contaId, int page, int size) {
        var conta = contaService.getById(contaId);

        PageRequest pageRequest = PageRequest.of(page,size);

        return transacaoRepository.findAllByConta(conta, pageRequest);
    }
}
