package com.letscode.banco811.service;

import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.dto.requests.ContaRequest;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest);
}
