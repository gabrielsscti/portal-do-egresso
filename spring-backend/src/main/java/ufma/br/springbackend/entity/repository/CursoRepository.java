package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.Curso;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> { }
