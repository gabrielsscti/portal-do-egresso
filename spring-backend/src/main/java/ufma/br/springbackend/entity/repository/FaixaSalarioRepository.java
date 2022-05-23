package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.FaixaSalario;

import java.util.UUID;

public interface FaixaSalarioRepository extends JpaRepository<FaixaSalario, UUID> { }
