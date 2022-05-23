package ufma.br.springbackend.entity.model.curso_egresso;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoEgressoKey implements Serializable {


    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")
    @Column(name = "egresso_id")
    private UUID egressoID;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "pg-uuid")
    @Column(name = "curso_id")
    private UUID cursoID;

    public void setEgressoID(UUID egressoID) {
        this.egressoID = egressoID;
    }

    public void setCursoID(UUID cursoID) {
        this.cursoID = cursoID;
    }
}
