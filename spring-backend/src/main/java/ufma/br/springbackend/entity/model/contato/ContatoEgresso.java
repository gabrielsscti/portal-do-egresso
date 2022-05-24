package ufma.br.springbackend.entity.model.contato;

import lombok.*;
import ufma.br.springbackend.entity.model.Contato;
import ufma.br.springbackend.entity.model.Curso;
import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.curso_egresso.CursoEgressoKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contato_egresso")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class ContatoEgresso implements Serializable {
    @EmbeddedId
    private ContatoEgressoKey id = new ContatoEgressoKey();

    public ContatoEgressoKey getId() {
        if (id == null){
            if (contato == null && egresso == null)
                return null;
            else if (contato.getId() == null && egresso.getId() == null)
                return null;
            else {
                var keyBuilder = ContatoEgressoKey.builder();
                if (contato != null)
                    if (contato.getId() != null)
                        keyBuilder = keyBuilder.contatoID(contato.getId());
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
            id = ContatoEgressoKey.builder().egressoID(egresso.getId()).build();
        else
            id.setEgressoID(egresso.getId());
    }

    @ManyToOne
    @MapsId("contatoID")
    @JoinColumn(name = "contato_id")
    Contato contato;
    public void setContato(Contato contato) {
        if (id == null)
            id = ContatoEgressoKey.builder().contatoID(contato.getId()).build();
        else
            id.setCursoID(contato.getId());
    }
}
