package com.letscode.banco811.service;

import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.model.TipoConta;
import com.letscode.banco811.projections.ContaView;

import java.util.List;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest);

    List<ContaView> getAllByTipoConta(TipoConta tipoConta);
}
