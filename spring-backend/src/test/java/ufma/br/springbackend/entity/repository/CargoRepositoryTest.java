package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import ufma.br.springbackend.entity.model.Cargo;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CargoRepositoryTest {
    @Autowired
    CargoRepository cargoRepository;

    @Test
    @Transactional
    public void shouldSaveCargoRepository(){
        var cargo = Cargo.builder()
                .name("cargo_teste")
                .descricao("desc_teste")
                .build();

        var saved = cargoRepository.save(cargo);

        Assertions.assertNotNull(saved);
    }
}
