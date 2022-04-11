package com.letscode.banco811.projections;

import com.letscode.banco811.model.enums.TipoTransacao;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface TransacaoView {

    TipoTransacao getTipoTransacao();

    @Value("#{'Conta de destino' + target.numero + '–' + target.agencia}")
    String getNumeroAgencia();

    BigDecimal getValor();

    ContaView getConta();
}
