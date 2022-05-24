package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgressoKey;

public interface CursoEgressoRepository extends JpaRepository<CursoEgresso, CursoEgressoKey> { }
