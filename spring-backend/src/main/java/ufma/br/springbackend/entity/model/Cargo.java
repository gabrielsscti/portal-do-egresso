package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="cargo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cargo {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_cargo", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @OneToMany(mappedBy = "cargo")
    Set<ProfEgresso> profEgresso;

    @Column(name="nome")
    private String name;

    @Column(name="descricao")
    private String descricao;
}
