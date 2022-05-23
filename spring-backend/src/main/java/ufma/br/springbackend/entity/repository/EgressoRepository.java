package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.Egresso;

import java.util.UUID;

public interface EgressoRepository extends JpaRepository<Egresso, UUID> { }
