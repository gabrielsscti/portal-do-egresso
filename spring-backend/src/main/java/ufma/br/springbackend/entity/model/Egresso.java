package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "egresso")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Egresso {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_egresso", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @OneToMany(mappedBy = "egresso")
    Set<CursoEgresso> cursoEgresso;

    @OneToMany(mappedBy = "egresso")
    Set<ProfEgresso> profEgresso;

    // TODO
    // @OneToMany(mappedBy = "egresso")
    // Set<ContatoEgresso> contatoEgresso;

    @Column(name="nome")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="cpf")
    private String cpf;
    @Column(name="resumo")
    private String resumo;
    @Column(name="url_foto")
    private String url_foto;

    public Egresso() {
        this.cursoEgresso = new HashSet<>();
        this.profEgresso  = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Egresso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", resumo='" + resumo + '\'' +
                ", url_foto='" + url_foto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Egresso egresso)) return false;
        return id.equals(egresso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getQuantCursoEgresso() {
        return cursoEgresso.size();
    }
    
    public int getQuantProfEgresso() {
        return profEgresso.size();
    }
}
