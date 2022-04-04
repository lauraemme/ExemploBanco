package com.letscode.banco811.model;

import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.repository.UsuarioRepository;
import com.letscode.banco811.service.impl.UsuarioServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "conta")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING) //para utilizar enums
    private TipoConta tipoConta;

    @ManyToOne(cascade = CascadeType.ALL) //muitas classes contas para o msm usuario
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Conta(ContaRequest contaRequest, Usuario usuario) {
        this.numero = contaRequest.getNumero();
        this.agencia = contaRequest.getAgencia();
        this.saldo = contaRequest.getSaldo();
        this.tipoConta = contaRequest.getTipoConta();
        this.usuario = usuario;
    }
}
