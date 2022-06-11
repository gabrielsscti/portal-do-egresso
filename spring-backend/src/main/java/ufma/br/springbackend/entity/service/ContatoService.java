package ufma.br.springbackend.entity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ufma.br.springbackend.entity.model.Contato;
import ufma.br.springbackend.entity.repository.ContatoRepository;
import ufma.br.springbackend.entity.service.exceptions.ServiceRuntimeException;

@Service
public class ContatoService {
  @Autowired
  private ContatoRepository repository;

  @Transactional
  public Contato save(Contato newContato) {
    verifyContato(newContato);
    return repository.save(newContato);
  }

  @Transactional
  public void delete(Contato newContato) {
    verifyID(newContato);
    repository.delete(newContato);
  }

  @Transactional
  public Contato update(Contato newContato) {
    verifyID(newContato);
    verifyContato(newContato);
    return repository.save(newContato);
  }

  public List<Contato> find(Contato filter) {
    Example<Contato> example = Example.of(filter,
        ExampleMatcher.matching().withIgnoreCase().withStringMatcher((StringMatcher.CONTAINING)));

    return repository.findAll(example);
  }

  private void verifyContato(Contato newContato) {
    if (newContato == null) {
      throw new ServiceRuntimeException("O contato está nulo");
    }

    if ((newContato.getName() == null) || (newContato.getName().equals(""))) {
      throw new ServiceRuntimeException("Nome deve ser informado");
    }
  }

  private void verifyID(Contato newContato) {
    if ((newContato == null) || (newContato.getId() == null)) {
      throw new ServiceRuntimeException("ID inválida");
    }
  }
}
