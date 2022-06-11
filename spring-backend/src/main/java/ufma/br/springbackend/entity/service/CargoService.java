package ufma.br.springbackend.entity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ufma.br.springbackend.entity.model.Egresso;
import ufma.br.springbackend.entity.model.Cargo;
import ufma.br.springbackend.entity.repository.CargoRepository;
import ufma.br.springbackend.entity.service.exceptions.ServiceRuntimeException;
import ufma.br.springbackend.entity.service.exceptions.RegraNegocioRunTime;

@Service
public class CargoService {
    @Autowired
    CargoRepository repository;

    public Cargo salvar(Cargo newCargo){
        verifyCargo(newCargo);
        return repository.save(newCargo);
    }

    public Cargo atualizar(Cargo newCargo){
        verifyId(newCargo);
        return salvar(newCargo);
    }

    public void remover(Cargo newCargo){
        verifyId(newCargo);
        verifyProfEgresso(newCargo);
        repository.delete(newCargo);
    }

    public void remover(Long idCargo) {
        Optional<Cargo> newCargo = repository.findById(idCargo);
        remover(newCargo.get());
    }

    public List<Cargo> buscar (Cargo filtro){
        Example<Cargo> example = 
                Example.of(filtro, ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(StringMatcher.CONTAINING)
                );

        return repository.findAll(example);
    }

    private void verifyId(Cargo newCargo) {
        if ((newCargo == null) || (newCargo.getId() == null))
            throw new RegraNegocioRunTime("Cargo sem id");
    }

    private void verifyCargo(Cargo newCargo){
        if(newCargo == null)
            throw new RegraNegocioRunTime("Um cargo válido deve ser informado");

        if((newCargo.getNome() == null)
                || (newCargo.getName().equals("")))
            throw new RegraNegocioRunTime("Um cargo precisa ter nome");

        if((newCargo.getDescricao() == null)
                || (newCargo.getDescricao().equals("")))
            throw new RegraNegocioRunTime("Um cargo precisa ter descricao");
    }
}
