package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.ProfEgresso;

import java.util.UUID;

public interface ProfEgressoRepository extends JpaRepository<ProfEgresso, UUID> { }
