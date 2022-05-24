package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Cargo;
import ufma.br.springbackend.entity.model.Contato;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContatoRepositoryTest {
    @Autowired
    ContatoRepository contatoRepository;

    @Test
    @Transactional
    public void shouldSaveCargoRepository(){
        var contato = Contato.builder()
                .name("contato_teste")
                .urlLogo("url_teste")
                .build();

        var saved = contatoRepository.save(contato);

        Assertions.assertNotNull(saved);
    }
}
