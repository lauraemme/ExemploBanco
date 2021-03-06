package com.letscode.banco811.repository;

import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.Usuario;
import com.letscode.banco811.model.enums.TipoConta;
import com.letscode.banco811.projections.ContaView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    List<ContaView> findAllByTipoConta(TipoConta tipoConta);
    Page<Conta> findByUsuarioAndNumero(Usuario usuario, Integer numero, Pageable pageable);
}
