package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {

  List<Contato> findByName(String name);
}
