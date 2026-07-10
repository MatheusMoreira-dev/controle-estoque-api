package br.com.matheus.controleestoque.services;

import br.com.matheus.controleestoque.entities.Setor;
import br.com.matheus.controleestoque.repositories.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    private final SetorRepository repository;

    public SetorService(SetorRepository repository){
        this.repository = repository;
    }

    public Setor create(Setor setor){
        return repository.save(setor);
    }

    public boolean delete(Long id){
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    public Optional<Setor> getById(Long id){
        return repository.findById(id);
    }

    public List<Setor> getAll(){
        return repository.findAll();
    }

    public Setor update(Setor setorUpdate){
        if(!repository.existsById(setorUpdate.getId())){
            return null;
        }

        return repository.save(setorUpdate);
    }
}