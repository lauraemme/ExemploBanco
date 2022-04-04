package com.letscode.banco811.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.letscode.banco811.dto.requests.UsuarioRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "usuario")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_criacao")
    @CreatedDate //JPA gerencia
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate //JPA gerencia
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    //@JsonIgnore para não mostrar o item
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //apenas da para escrever não irá aparecer para ler
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conta> contas;

    public Usuario(UsuarioRequest usuarioRequest){
        this.cpf = usuarioRequest.getCpf();
        this.nome = usuarioRequest.getNome();
        this.senha = usuarioRequest.getSenha();
    }
}
