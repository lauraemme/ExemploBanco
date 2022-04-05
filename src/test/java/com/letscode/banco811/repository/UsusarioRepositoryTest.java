package com.letscode.banco811.repository;

import com.letscode.banco811.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;


@DataJpaTest     //informa que estamos fazendo testes com o jpa
public class UsusarioRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void validar_findAll_vazio_se_repository_em_branco(){
        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(),usuarios);
    }

    @Test
    public void trazer_usuarios_cadastrados_no_findAll(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("usuario1");
        usuario1.setSenha("12345678");
        usuario1.setCpf("11111111111");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("usuario2");
        usuario2.setSenha("12345678");
        usuario2.setCpf("11111111112");

        testEntityManager.persist(usuario1);
        testEntityManager.persist(usuario2);

        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(usuario1,usuario2),usuarios);
    }

    @Test
    public void trazer_usuarios_pelo_nome_com_sucesso(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("usuario1");
        usuario1.setSenha("12345678");
        usuario1.setCpf("11111111111");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("usuario2");
        usuario2.setSenha("12345678");
        usuario2.setCpf("11111111112");

        testEntityManager.persist(usuario1);
        testEntityManager.persist(usuario2);

        PageRequest pageRequest = PageRequest.of(0,3);

        var usuarios = usuarioRepository.findByNome("usuario1",pageRequest);

        Assertions.assertEquals(1,usuarios.getTotalElements());
        Assertions.assertEquals(usuario1, usuarios.stream().findFirst().get());
    }

    @Test
    public void validar_atualizacao_do_nome_do_usuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("usuario1");
        usuario.setSenha("12345678");
        usuario.setCpf("11111111111");

        usuario = testEntityManager.persist(usuario);

        String nomeAtualizado = "nomeAtualizado";
        usuario.setNome(nomeAtualizado);

        usuarioRepository.save(usuario);

        var usuarioPersistence = usuarioRepository.findById(usuario.getId());

        Assertions.assertEquals(usuarioPersistence.get().getId(), usuario.getId());
        Assertions.assertEquals(nomeAtualizado, usuarioPersistence.get().getNome());
    }
}
