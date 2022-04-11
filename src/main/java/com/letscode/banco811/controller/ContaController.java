package com.letscode.banco811.controller;

import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.model.enums.TipoConta;
import com.letscode.banco811.projections.ContaView;
import com.letscode.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public Page<ContaResponse> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ){
        return  contaService.getAll(page, size);
    }

    @PostMapping()
    public ContaResponse create(@RequestBody ContaRequest contaRequest, @PathParam("usuarioId") Integer usuarioId){
        return contaService.create(contaRequest, usuarioId);
    }

    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta(@RequestParam TipoConta tipoConta){
        return contaService.getAllByTipoConta(tipoConta);
    }



    @PutMapping()
    public ContaResponse update(@PathParam("contaId") Integer contaId, @RequestBody ContaRequest contaRequest){
        return contaService.update(contaId, contaRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        contaService.delete(id);
    }
}
