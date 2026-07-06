package br.com.matheus.controleestoque.services;

import br.com.matheus.controleestoque.entities.Categoria;
import br.com.matheus.controleestoque.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){
        this.repository = repository;
    }

    public Categoria create(Categoria categoria){
        return repository.save(categoria);
    }

    public boolean delete(Long id){
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    public Optional<Categoria> getById(Long id){
        return repository.findById(id);
    }

    public List<Categoria> getAll(){
        return repository.findAll();
    }

    public Categoria update(Categoria categoria){
        if(!repository.existsById(categoria.getId())){
            throw new RuntimeException("Não há nenhuma categoria cadastrada com esse Id!");
        }

        return repository.save(categoria);
    }
}
