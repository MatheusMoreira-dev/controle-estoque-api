package br.com.matheus.controleestoque.services;

import br.com.matheus.controleestoque.entities.Funcionario;
import br.com.matheus.controleestoque.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public Funcionario create(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public boolean delete(Long id){
        repository.deleteById(id);

        return !repository.existsById(id);
    }

    public Optional<Funcionario> getById(Long id){
        return repository.findById(id);
    }

    public List<Funcionario> getAll(){
        return repository.findAll();
    }

    public Funcionario update(Funcionario funcionarioUpdate){
        if(!repository.existsById(funcionarioUpdate.getId())){
            return null;
        }

        return repository.save(funcionarioUpdate);
    }
}