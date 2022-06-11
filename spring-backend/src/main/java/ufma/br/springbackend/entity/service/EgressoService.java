package ufma.br.springbackend.entity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.Contato;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;
import ufma.br.springbackend.entity.model.contato.ContatoEgresso;
import ufma.br.springbackend.entity.repository.EgressoRepository;
import ufma.br.springbackend.entity.repository.ContatoRepository;
import ufma.br.springbackend.entity.repository.ContatoEgressoRepository;
import ufma.br.springbackend.entity.repository.CursoEgressoRepository;
import ufma.br.springbackend.entity.repository.CursoRepository;
import ufma.br.springbackend.entity.service.exceptions.ServiceRuntimeException;

@Service
public class EgressoService {
  @Autowired
  private EgressoRepository repository;

  @Transactional
  public Egresso save(Egresso newEgresso) {
    verifyEgresso(newEgresso);
    return repository.save(newEgresso);
  }

  @Transactional
  public void delete(Egresso newEgresso) {
    verifyID(newEgresso);
    repository.delete(newEgresso);
  }

  @Transactional
  public Egresso update(Egresso newEgresso) {
    verifyID(newEgresso);
    verifyEgresso(newEgresso);
    return repository.save(newEgresso);
  }

  public List<Egresso> find(Egresso filter) {
    Example<Egresso> example = Example.of(filter,
        ExampleMatcher.matching().withIgnoreCase().withStringMatcher((StringMatcher.CONTAINING)));

    return repository.findAll(example);
  }

  @Transactional
  public Egresso atualizarContatos(Egresso newEgresso, List<Contato> contatos) {
      verifyEgresso(newEgresso);
      verifyID(newEgresso);
      newEgresso.setContatos(contatos);
      return repo.save(newEgresso);
  }

  public List<Contato> buscarContatos(Egresso newEgresso) {
    verifyID(newEgresso);
    return newEgresso.getContatos();
  }

  @Transactional
  public Egresso atualizarCurso(Egresso newEgresso, List<CursoEgresso> cursos) {
      verifyEgresso(newEgresso);
      verifyID(newEgresso);
      newEgresso.setEgressoCursos(cursos);
      return repository.save(newEgresso);
  }

  @Transactional
  public Egresso atualizarProfissao(Egresso newEgresso, List<ProfEgresso> profissoes) {
      verifyEgresso(newEgresso);
      verifyID(newEgresso);
      newEgresso.setProfsEgressos(profissoes);
      return repository.save(newEgresso);
  }


  private void verifyEgresso(Egresso newEgresso) {
    if (newEgresso == null) {
      throw new ServiceRuntimeException("O egresso está nulo");
    }
    if ((newEgresso.getName() == null) || (newEgresso.getName().equals(""))) {
      throw new ServiceRuntimeException("Nome deve ser informado");
    }
    if ((newEgresso.getEmail() == null) || (newEgresso.getEmail().equals(""))) {
      throw new ServiceRuntimeException("Email deve ser informado");
    }
    if ((newEgresso.getCpf() == null) || (newEgresso.getCpf().equals(""))) {
      throw new ServiceRuntimeException("CPF deve ser informado");
    }
  }

  private void verifyID(Egresso newEgresso) {
    if ((newEgresso == null) || (newEgresso.getId() == null) || 
    !(repository.existsById(newEgresso.getId()))) {
      throw new ServiceRuntimeException("ID inválida");
    }
  }
}