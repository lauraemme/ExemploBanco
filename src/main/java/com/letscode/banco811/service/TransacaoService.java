package com.letscode.banco811.service;

import com.letscode.banco811.dto.requests.TransacaoRequest;
import com.letscode.banco811.dto.response.TransacaoResponse;
import com.letscode.banco811.model.Transacao;
import org.springframework.data.domain.Page;

public interface TransacaoService {
    TransacaoResponse create(TransacaoRequest transacaoRequest, Integer contaId);

    Page<Transacao> getAllByContaId(Integer contaId, int page, int size);
}
