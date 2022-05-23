package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;
import ufma.br.springbackend.entity.model.Egresso;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CursoEgressoRepositoryTest {
    @Autowired
    CursoEgressoRepository repository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    EgressoRepository egressoRepository;

    @Test

    public void shouldSaveCursoEgressoRepository(){
        var curso = Curso.builder().name("Teste")
                .level("A")
                .build();

        var egresso = Egresso.builder().name("Teste")
                .email("test@test.com")
                .cpf("49392493210")
                .resumo("Resumo teste")
                .url_foto("https://test.com/fsdf2412")
                .build();

        var cursoSaved = cursoRepository.save(curso);
        var egressoSaved = egressoRepository.save(egresso);

        var cursoEgresso = CursoEgresso.builder()
                .curso(curso)
                .egresso(egresso)
                .dtInicio(new Date(System.currentTimeMillis()))
                .dtConclusao(new Date(System.currentTimeMillis()))
                .build();

        var saved = repository.save(cursoEgresso);

        Assertions.assertNotNull(saved);

        repository.delete(saved);
        cursoRepository.delete(cursoSaved);
        egressoRepository.delete(egressoSaved);
    }

}
