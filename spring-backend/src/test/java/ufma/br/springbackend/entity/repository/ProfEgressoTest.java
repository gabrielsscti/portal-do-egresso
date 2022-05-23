package ufma.br.springbackend.entity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ufma.br.springbackend.entity.model.Cargo;
import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.FaixaSalario;
import ufma.br.springbackend.entity.model.ProfEgresso;

import javax.transaction.Transactional;
import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProfEgressoTest {
    @Autowired
    ProfEgressoRepository profEgressoRepository;

    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    FaixaSalarioRepository faixaSalarioRepository;


    @Test
    @Transactional
    public void shouldSaveProfEgressoRepository() {
        var egresso = Egresso.builder()
                .name("teste_nome")
                .url_foto("teste_url")
                .resumo("teste_resumo")
                .email("teste_email")
                .cpf("teste_cpf")
                .build();

        var cargo = Cargo.builder()
                .name("teste_nome")
                .descricao("teste_descricao")
                .build();

        var faixaSalario = FaixaSalario.builder()
                .descricao("teste_descricao")
                .build();

        var savedEgresso = egressoRepository.save(egresso);
        var savedCargo = cargoRepository.save(cargo);
        var savedFaixaSalarial = faixaSalarioRepository.save(faixaSalario);

        var profEgresso = ProfEgresso.builder()
                .egresso(egresso)
                .cargo(cargo)
                .faixaSalario(faixaSalario)
                .build();

        var savedProfEgresso = profEgressoRepository.save(profEgresso);

        Assertions.assertEquals(savedProfEgresso.getEgresso().getId(), savedEgresso.getId());
        Assertions.assertEquals(savedProfEgresso.getCargo().getId(), savedCargo.getId());
        Assertions.assertEquals(savedProfEgresso.getFaixaSalario().getId(), savedFaixaSalarial.getId());
        Assertions.assertNotNull(savedProfEgresso);
    }
}
