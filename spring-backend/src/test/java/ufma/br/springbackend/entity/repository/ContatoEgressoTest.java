package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Contato;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.contato.ContatoEgresso;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContatoEgressoTest {
    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ContatoEgressoRepository contatoEgressoRepository;

    @Test
    @Transactional
    public void shouldSaveContatoEgressoRepository(){
        var egresso = Egresso.builder()
                .cursoEgresso(new HashSet<>())
                .profEgresso(new HashSet<>())
                .cpf("teste cpf")
                .name("teste nome")
                .resumo("teste resumo")
                .url_foto("teste url")
                .build();

        var contato = Contato.builder()
                .urlLogo("teste url")
                .name("teste nome")
                .build();

        var egressoSaved = egressoRepository.save(egresso);
        var contatoSaved = contatoRepository.save(contato);

        var contatoEgresso = ContatoEgresso.builder()
                .egresso(egresso)
                .contato(contato)
                .build();

        var contatoEgressoSaved = contatoEgressoRepository.save(contatoEgresso);

        Assertions.assertNotNull(contatoEgressoSaved);
        Assertions.assertEquals(contatoEgressoSaved.getEgresso().getId(), egressoSaved.getId());
        Assertions.assertEquals(contatoEgressoSaved.getContato().getId(), contatoSaved.getId());
    }

}
