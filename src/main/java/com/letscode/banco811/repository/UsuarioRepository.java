package com.letscode.banco811.repository;

import com.letscode.banco811.dto.response.UsuarioResponse;
import com.letscode.banco811.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Page<Usuario> findByNome(String nome, Pageable pageable);

    @Query("select new com.letscode.banco811.dto.response.UsuarioResponse(u.id, u.cpf, u.nome, u.dataCriacao, u.dataAtualizacao) " +
            "from Usuario u where u.cpf = :cpf")
    Page<UsuarioResponse> findByCpf(@Param("cpf")String cpf, Pageable pageable);

    //boolean existsById(Integer id);
}
