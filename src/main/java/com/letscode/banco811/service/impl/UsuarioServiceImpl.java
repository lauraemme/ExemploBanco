package com.letscode.banco811.service.impl;

import com.letscode.banco811.dto.requests.UsuarioRequest;
import com.letscode.banco811.dto.response.UsuarioResponse;
import com.letscode.banco811.model.Usuario;
import com.letscode.banco811.repository.UsuarioRepository;
import com.letscode.banco811.service.UsusarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServiceImpl implements UsusarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Page<Usuario> getAll(String nome, int page, int size){

        PageRequest pageRequest = PageRequest.of(page,size,
                Sort.Direction.ASC, "nome"
        );

        if (nome != null){
            return usuarioRepository.findByNome(nome, pageRequest);
        }else {
            return usuarioRepository.findAll(pageRequest);
        }
    }

    @Override
    public Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.ASC);
        return usuarioRepository.findByCpf(cpf, pageRequest);
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest){

        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);

        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        var usuario= usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }

    //@Override
    //public boolean existsUsuario(Integer id) {
     //   return usuarioRepository.existsById(id); //n??o pode receber arg null
    //}
}
