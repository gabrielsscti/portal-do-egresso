package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "curso")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_curso", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @OneToMany(mappedBy = "curso")
    Set<CursoEgresso> cursoEgresso;

    @Column(name="nome")
    private String name;

    @Column(name="nivel")
    private String level;

    public Curso() {
        this.cursoEgresso = new HashSet<>();
    }

    public int getQuantCursoEgresso() {
        return cursoEgresso.size();
    }
}
