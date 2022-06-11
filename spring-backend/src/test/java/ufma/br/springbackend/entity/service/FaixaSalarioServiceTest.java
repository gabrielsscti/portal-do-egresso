package ufma.br.springbackend.entity.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import ufma.br.springbackend.entity.model.Cargo;
import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.FaixaSalario;
import ufma.br.springbackend.entity.model.ProfEgresso;
import ufma.br.springbackend.entity.repository.CargoRepository;
import ufma.br.springbackend.entity.repository.EgressoRepository;
import ufma.br.springbackend.entity.repository.FaixaSalarioRepository;
import ufma.br.springbackend.entity.repository.ProfEgressoRepository;

public class FaixaSalarioServiceTest {
  @Autowired
  FaixaSalarioRepository repository;

  @Autowired
  FaixaSalarioService service;

  @Autowired
  CargoRepository cargoRepository;

  @Autowired
  ProfEgressoRepository profEgressoRepository;

  @Autowired
  EgressoRepository egressoRepository;

  @Test
  @Transactional
  public void deveContabilizarEgressosPorFaixaSalarial() {
    Egresso egresso = Egresso.builder().name("Teste")
        .email("test@test.com")
        .cpf("49392493210")
        .resumo("Resumo teste")
        .url_foto("https://test.com/fsdf2412")
        .build();

    Cargo cargo = Cargo.builder()
        .name("cargo_teste")
        .descricao("desc_teste")
        .build();

    FaixaSalario faixaSalarial = FaixaSalario.builder()
        .descricao("descricao_teste")
        .build();

    ProfEgresso profEgresso = ProfEgresso.builder()
        .egresso(egresso)
        .cargo(cargo)
        .faixaSalario(faixaSalarial)
        .build();

    egressoRepository.save(egresso);
    cargoRepository.save(cargo);
    profEgressoRepository.save(profEgresso);
    repository.save(faixaSalarial);

    int numero = service.numeroEgressos(faixaSalarial);

    Assertions.assertEquals(1, numero);
  }
}
