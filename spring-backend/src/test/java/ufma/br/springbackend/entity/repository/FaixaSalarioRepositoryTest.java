package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.FaixaSalario;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FaixaSalarioRepositoryTest {
    @Autowired
    FaixaSalarioRepository faixaSalarioRepository;

    @Test
    @Transactional
    public void shouldSaveFaixaSalarioRepository() {
        var faixaSalario = FaixaSalario.builder()
                .descricao("descricao_teste")
                .build();

        var saved = faixaSalarioRepository.save(faixaSalario);

        Assertions.assertNotNull(saved);
    }
}
