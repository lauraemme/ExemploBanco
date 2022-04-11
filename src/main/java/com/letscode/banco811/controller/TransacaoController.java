package com.letscode.banco811.controller;

import com.letscode.banco811.dto.requests.TransacaoRequest;
import com.letscode.banco811.dto.response.TransacaoResponse;
import com.letscode.banco811.model.Transacao;
import com.letscode.banco811.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public TransacaoResponse create(
            @RequestBody TransacaoRequest transacaoRequest,
            @PathParam("contaId") Integer contaId){
        return transacaoService.create(transacaoRequest, contaId);
    }

    @GetMapping("/{contaId}")
    public Page<Transacao> getAllByContaId(
            @RequestParam Integer contaId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ){
        return transacaoService.getAllByContaId(contaId, page, size);
    }
}
