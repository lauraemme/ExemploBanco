package com.letscode.banco811.repository;

import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

    Page<Transacao> findAllByConta(Conta conta, Pageable pageable);
}
