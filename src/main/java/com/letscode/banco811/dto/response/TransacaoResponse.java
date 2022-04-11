package com.letscode.banco811.dto.response;

import com.letscode.banco811.model.Transacao;
import com.letscode.banco811.model.enums.TipoTransacao;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
public class TransacaoResponse {

    private Integer id;
    private TipoTransacao tipoTransacao;
    private Integer numero;
    private Integer agencia;
    private LocalDateTime dataCriacao;
    private BigDecimal valor;
    private Integer numeroConta;
    private String usuarioNome;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.numero = transacao.getNumero();
        this.agencia = transacao.getAgencia();
        this.dataCriacao = transacao.getDataCriacao();
        this.valor = transacao.getValor();
        this.numeroConta = transacao.getConta().getNumero();
        this.usuarioNome = transacao.getConta().getUsuario().getNome();
    }
}
