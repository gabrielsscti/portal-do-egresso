package ufma.br.springbackend.entity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.repository.CursoRepository;
import ufma.br.springbackend.entity.service.exceptions.ServiceRuntimeException;

@Service
public class CursoService {
  @Autowired
  private CursoRepository repository;

  @Transactional
  public Curso save(Curso newCurso) {
    verifyCurso(newCurso);
    return repository.save(newCurso);
  }

  @Transactional
  public void delete(Curso newCurso) {
    verifyID(newCurso);
    repository.delete(newCurso);
  }

  @Transactional
  public Curso update(Curso newCurso) {
    verifyID(newCurso);
    verifyCurso(newCurso);
    return repository.save(newCurso);
  }

  public List<Curso> find(Curso filter) {
    Example<Curso> example = Example.of(filter,
        ExampleMatcher.matching().withIgnoreCase().withStringMatcher((StringMatcher.CONTAINING)));

    return repository.findAll(example);
  }

  private void verifyCurso(Curso newCurso) {
    if (newCurso == null) {
      throw new ServiceRuntimeException("Um curso válido deve ser informado");
    }

    if ((newCurso.getName() == null) || (newCurso.getName().equals(""))) {
      throw new ServiceRuntimeException("Um nome deve ser informado");
    }

    if ((newCurso.getLevel() == null) || (newCurso.getLevel().toString().equals(""))) {
      throw new ServiceRuntimeException("Um nível deve ser informado");
    }
  }

  private void verifyID(Curso newCurso) {
    if ((newCurso == null) || (newCurso.getId() == null)) {
      throw new ServiceRuntimeException("ID inválida");
    }
  }
}
