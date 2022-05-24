package ufma.br.springbackend.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufma.br.springbackend.entity.model.contato.ContatoEgresso;
import ufma.br.springbackend.entity.model.contato.ContatoEgressoKey;

public interface ContatoEgressoRepository extends JpaRepository<ContatoEgresso, ContatoEgressoKey> { }
