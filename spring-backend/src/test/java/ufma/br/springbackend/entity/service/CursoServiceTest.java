package ufma.br.springbackend.entity.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.repository.CursoRepository;
import ufma.br.springbackend.entity.service.exceptions.ServiceRuntimeException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CursoServiceTest {
  @Autowired
  CursoService service;

  @Autowired
  CursoRepository repository;

  @Test
  @Transactional
  public void shouldSaveCurso() {
    Curso newCurso = Curso.builder().name("Curso").level("Nível").build();

    Curso saved = service.save((newCurso));

    Assertions.assertNotNull(saved);
    Assertions.assertEquals(newCurso.getName(), saved.getName());
    Assertions.assertEquals(newCurso.getLevel(), saved.getLevel());

    service.delete(saved);
  }

  @Test
  @Transactional
  public void shouldDeleteCurso() {
    Curso newCurso = Curso.builder().name("Curso").level("Nível").build();

    Curso saved = service.save((newCurso));

    service.delete(saved);

    Optional<Curso> cursoDeleted = repository.findById(saved.getId());

    Assertions.assertTrue(cursoDeleted.isEmpty());
  }

  @Test
  @Transactional
  public void shouldUpdateCurso() {
    Curso newCurso = Curso.builder().name("Curso").level("Nível").build();

    Curso saved = service.save((newCurso));

    saved.setName("Curso Editado");
    saved.setLevel("Level Editado");

    Curso cursoUpdated = service.update(saved);

    Assertions.assertEquals(cursoUpdated.getName(), saved.getName());
    Assertions.assertEquals(cursoUpdated.getLevel(), saved.getLevel());

    service.delete(saved);
  }

  @Test
  @Transactional
  public void shouldThrowErrorWhenSaveWithoutName() {
    Curso newCurso = Curso.builder().level("Nível").build();

    Assertions.assertThrows(ServiceRuntimeException.class, () -> service.save(newCurso),
        "Um nome deve ser informado");
  }

  @Test
  @Transactional
  public void shouldThrowErrorWhenSaveWithoutLevel() {
    Curso newCurso = Curso.builder().name("Curso").build();

    Assertions.assertThrows(ServiceRuntimeException.class, () -> service.save(newCurso),
        "Um nível deve ser informado");
  }
}
