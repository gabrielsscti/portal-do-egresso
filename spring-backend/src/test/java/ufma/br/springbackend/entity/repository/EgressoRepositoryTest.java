package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Egresso;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EgressoRepositoryTest {
    @Autowired
    EgressoRepository repository;

    @Test
    public void shouldSaveEgressoRepository(){
        var egresso = Egresso.builder().name("Teste")
                .email("test@test.com")
                .cpf("49392493210")
                .resumo("Resumo teste")
                .url_foto("https://test.com/fsdf2412")
                .build();

        var saved = repository.save(egresso);

        Assertions.assertNotNull(saved);

        repository.delete(saved);
    }
}
