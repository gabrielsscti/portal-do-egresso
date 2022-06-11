package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufma.br.springbackend.entity.model.FaixaSalario;

import java.util.UUID;

public interface FaixaSalarioRepository extends JpaRepository<FaixaSalario, UUID> {
  @Query(value = "SELECT COUNT(e) from Egresso e JOIN e.profsEgressos pe WHERE pe.faixaSalario =: faixaSalario")
  int numeroEgressos(
      @Param("faixaSalario") FaixaSalario range);
}
