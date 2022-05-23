package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="faixa_salario")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FaixaSalario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_faixa_salario", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name="descricao")
    private String descricao;

    @OneToMany(mappedBy = "faixaSalario")
    Set<ProfEgresso> profEgresso;
}
