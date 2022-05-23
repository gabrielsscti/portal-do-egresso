package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.Cargo;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> { }
