package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgresso;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="contato")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contato {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_contato", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name="nome")
    private String name;

    @Column(name="url_logo")
    private String urlLogo;

    // TODO
    // @OneToMany(mappedBy = "contato")
    // Set<ContatoEgresso> contatoEgresso;
}
