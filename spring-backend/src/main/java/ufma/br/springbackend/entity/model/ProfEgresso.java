package ufma.br.springbackend.entity.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prof_egresso")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfEgresso {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id_prof_egresso", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "egresso_id")
    Egresso egresso;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "faixa_salario_id")
    FaixaSalario faixaSalario;

    @Column(name="empresa")
    private String empresa;

    @Column(name="descricao")
    private String descricao;

    @Column(name="data_registro")
    private Date data_registro;
}
