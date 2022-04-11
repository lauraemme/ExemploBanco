package com.letscode.banco811.controller;

import com.letscode.banco811.dto.requests.UsuarioRequest;
import com.letscode.banco811.dto.response.UsuarioResponse;
import com.letscode.banco811.model.Usuario;
import com.letscode.banco811.service.UsusarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsusarioService ususarioService;

    @GetMapping
    public Page<Usuario> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
            ){
        return ususarioService.getAll(nome, page, size);
    }

    //arrumar
    @GetMapping("/cpf")
    public Page<UsuarioResponse> getAllByCpf(
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ){
        return ususarioService.getAllByCpf(cpf,page,size);
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
