package com.letscode.banco811.repository;

import com.letscode.banco811.model.Conta;
import com.letscode.banco811.model.Usuario;
import com.letscode.banco811.model.enums.TipoConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Arrays;

@DataJpaTest
public class ContaRepositoryTest{

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private  ContaRepository contaRepository;

    @Test
    public void validar_findAllByTipoConta_se_repository_em_branco(){
        var contasPF = contaRepository.findAllByTipoConta(TipoConta.PF);
        var contasPJ = contaRepository.findAllByTipoConta(TipoConta.PJ);

        Assertions.assertEquals(Arrays.asList(),contasPF);
        Assertions.assertEquals(Arrays.asList(),contasPJ);
    }

    @Test
    public void trazer_contas_pelo_tipoConta_com_sucesso(){
        Conta conta1PF = new Conta();
        conta1PF.setTipoConta(TipoConta.PF);
        conta1PF.setSaldo(BigDecimal.valueOf(330.00));
        conta1PF.setNumero(1112);
        conta1PF.setAgencia(1);
        conta1PF.setUsuario(new Usuario());

        Conta conta2PF = new Conta();
        conta2PF.setTipoConta(TipoConta.PF);
        conta2PF.setSaldo(BigDecimal.valueOf(330.00));
        conta2PF.setNumero(2222);
        conta2PF.setAgencia(2);
        conta2PF.setUsuario(new Usuario());

        Conta conta1PJ = new Conta();
        conta1PJ.setTipoConta(TipoConta.PJ);
        conta1PJ.setSaldo(BigDecimal.valueOf(330.00));
        conta1PJ.setNumero(1112);
        conta1PJ.setAgencia(1);
        conta1PJ.setUsuario(new Usuario());

        Conta conta2PJ = new Conta();
        conta2PJ.setTipoConta(TipoConta.PJ);
        conta2PJ.setSaldo(BigDecimal.valueOf(330.00));
        conta2PJ.setNumero(2222);
        conta2PJ.setAgencia(2);
        conta2PJ.setUsuario(new Usuario());

       testEntityManager.persist(conta1PF);
       testEntityManager.persist(conta2PF);
       testEntityManager.persist(conta1PJ);
       testEntityManager.persist(conta2PJ);

       var contasPF = contaRepository.findAllByTipoConta(TipoConta.PF);
       var contasPJ = contaRepository.findAllByTipoConta(TipoConta.PJ);

       Assertions.assertEquals(Arrays.asList(conta1PF,conta2PF),contasPF);
       Assertions.assertEquals(Arrays.asList(conta1PJ,conta2PJ),contasPJ);
    }
}
