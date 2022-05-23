package ufma.br.springbackend.entity.model.curso_egresso;

import lombok.*;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.Egresso;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "curso_egresso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoEgresso implements Serializable {
    @EmbeddedId
    private CursoEgressoKey id = new CursoEgressoKey();
    public CursoEgressoKey getId() {
        if (id == null){
            if (curso == null && egresso == null)
                return null;
            else if (curso.getId() == null && egresso.getId() == null)
                return null;
            else {
                var keyBuilder = CursoEgressoKey.builder();
                if (curso != null)
                    if (curso.getId() != null)
                        keyBuilder = keyBuilder.cursoID(curso.getId());
                if (egresso != null)
                    if (egresso.getId() != null)
                        keyBuilder = keyBuilder.egressoID(egresso.getId());
                return keyBuilder.build();
            }
        }
        return id;

    }

    @ManyToOne
    @MapsId("egressoID")
    @JoinColumn(name = "egresso_id")
    Egresso egresso;
    public void setEgresso(Egresso egresso) {
        if (id == null)
            id = CursoEgressoKey.builder().egressoID(egresso.getId()).build();
        else
            id.setEgressoID(egresso.getId());
    }

    @ManyToOne
    @MapsId("cursoID")
    @JoinColumn(name = "curso_id")
    Curso curso;
    public void setCurso(Curso curso) {
        if (id == null)
            id = CursoEgressoKey.builder().cursoID(curso.getId()).build();
        else
            id.setCursoID(curso.getId());
    }

    @Column(name="data_inicio")
    private Date dtInicio;

    @Column(name="data_conclusao")
    private Date dtConclusao;
}

