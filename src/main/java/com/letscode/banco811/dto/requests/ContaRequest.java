package com.letscode.banco811.dto.requests;

import com.letscode.banco811.model.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaRequest {

    private Integer numero;
    private Integer agencia;
    private BigDecimal saldo;
    private TipoConta tipoConta;

}
