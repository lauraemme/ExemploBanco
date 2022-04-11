package com.letscode.banco811.service.impl;

import com.letscode.banco811.dto.requests.ContaRequest;
import com.letscode.banco811.dto.response.ContaResponse;
import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.enums.TipoConta;
import com.letscode.banco811.projections.ContaView;
import com.letscode.banco811.repository.ContaRepository;
import com.letscode.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Override
    public ContaResponse create(ContaRequest contaRequest, Integer usuarioId) {
        var usuario = usuarioService.getById(usuarioId);
        Conta conta = new Conta(contaRequest,usuario);
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public List<ContaView> getAllByTipoConta(TipoConta tipoConta){
        return contaRepository.findAllByTipoConta(tipoConta);
    }

    @Override //não retorna a quantidade certa de elementos
    public Page<ContaResponse> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size,
                Sort.Direction.ASC, "id"
        );

        var contas = contaRepository.findAll();

        List<ContaResponse> contaResponses = ContaResponse.toResponse(contas);

        Page<ContaResponse> pageResposes = new PageImpl<>(contaResponses,pageRequest,contaResponses.size());

        return pageResposes;
    }

    @Override
    public ContaResponse update(Integer contaId, ContaRequest contaRequest) {
        Conta conta = contaRepository.getById(contaId);

        conta.setNumero(contaRequest.getNumero());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setSaldo(contaRequest.getSaldo());

        conta = contaRepository.save(conta);

        return new ContaResponse(conta);
    }

    @Override
    public void delete(Integer id) {
        var conta = contaRepository.findById(id).orElseThrow();
        contaRepository.delete(conta);
    }

    @Override
    public Conta getById(Integer contaId) {
        return contaRepository.findById(contaId).orElseThrow();
    }
}
