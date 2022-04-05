package com.letscode.banco811.service;

import com.letscode.banco811.dto.requests.UsuarioRequest;
import com.letscode.banco811.dto.response.UsuarioResponse;
import com.letscode.banco811.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsusarioService {
    Page<Usuario> getAll(String nome, int page, int size);

    Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size);

    UsuarioResponse create(UsuarioRequest usuarioRequest);
    Usuario getById(Integer id);
    Usuario update(UsuarioRequest usuarioRequest, Integer id);
    void delete(Integer id);
    //boolean existsUsuario(Integer id);
}
