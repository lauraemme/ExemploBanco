package com.letscode.banco811.dto.response;

import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.enums.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class ContaResponse {

    private Integer id;
    private Integer numero;
    private Integer agencia;
    private LocalDateTime dataAtualizacao;
    private TipoConta tipoConta;
    private String usuarioNome;

    public ContaResponse(Conta conta){
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.dataAtualizacao = conta.getDataAtualizacao();
        this.tipoConta = conta.getTipoConta();
        this.usuarioNome = conta.getUsuario().getNome();
    }

    public static List<ContaResponse> toResponse(List<Conta> contas){
        return contas.stream().map(ContaResponse::new).collect(Collectors.toList());
    }
}
