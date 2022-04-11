package com.letscode.banco811.service;

import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.enums.TipoConta;
import com.letscode.banco811.projections.ContaView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest, Integer usuarioId);

    List<ContaView> getAllByTipoConta(TipoConta tipoConta);

    Page<ContaResponse> getAll(int page, int size);

    ContaResponse update(Integer contaId, ContaRequest contaRequest);

    void delete(Integer id);

    Conta getById(Integer contaId);
}
