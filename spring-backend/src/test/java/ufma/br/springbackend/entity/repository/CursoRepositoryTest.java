package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.Egresso;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CursoRepositoryTest {
    @Autowired
    CursoRepository repository;

    @Test
    @Transactional
    public void shouldSaveEgressoRepository(){
        var curso = Curso.builder().name("Teste")
                .level("A")
                .build();

        var saved = repository.save(curso);

        Assertions.assertNotNull(saved);
    }
}
