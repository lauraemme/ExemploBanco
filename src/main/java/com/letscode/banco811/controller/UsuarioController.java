package com.letscode.banco811.controller;

import com.letscode.banco811.dto.requests.UsuarioRequest;
import com.letscode.banco811.dto.response.UsuarioResponse;
import com.letscode.banco811.model.Usuario;
import com.letscode.banco811.service.UsusarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsusarioService ususarioService;

    @GetMapping
    public List<Usuario> getAll(@RequestParam(required = false) String nome){
        return ususarioService.getAll(nome);
    }

    @PostMapping
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return ususarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id){
        return ususarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return ususarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ususarioService.delete(id);
    }
}
