package com.letscode.banco811.dto.requests;

import com.letscode.banco811.model.enums.TipoTransacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class TransacaoRequest {

    private TipoTransacao tipoTransacao;
    private Integer numero;
    private Integer agencia;
    private BigDecimal valor;

}
