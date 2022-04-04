package com.letscode.banco811.repository;

import com.letscode.banco811.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
    Usuario findByCpf(String cpf); //cpf é um valor único
    //boolean existsById(Integer id);
}
