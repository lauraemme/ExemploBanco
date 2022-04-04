package com.letscode.banco811.controller;

import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;


    //não está funcionando estou recebendo status 500
    @PostMapping
    public ContaResponse create(@RequestBody ContaRequest contaRequest, @PathVariable Integer usuarioId){
        return contaService.create(contaRequest);
    }
}
