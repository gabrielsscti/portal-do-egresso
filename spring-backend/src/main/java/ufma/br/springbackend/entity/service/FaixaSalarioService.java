package ufma.br.springbackend.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufma.br.springbackend.entity.model.FaixaSalario;
import ufma.br.springbackend.entity.repository.FaixaSalarioRepository;

@Service
public class FaixaSalarioService {
  @Autowired
  FaixaSalarioRepository repository;

  public int numeroEgressos(FaixaSalario range) {
    int numero = repository.numeroEgressos(range);
    return numero;
  }
}
