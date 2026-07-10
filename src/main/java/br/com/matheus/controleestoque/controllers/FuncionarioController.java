package br.com.matheus.controleestoque.controllers;

import br.com.matheus.controleestoque.entities.Funcionario;
import br.com.matheus.controleestoque.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(funcionario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id){
        Optional<Funcionario> funcionario = service.getById(id);

        if(funcionario.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(funcionario.get());
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Funcionario> patch(@PathVariable Long id, @RequestBody Funcionario funcionario){
        funcionario.setId(id);
        Funcionario updateFuncionario = service.update(funcionario);

        if(updateFuncionario == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateFuncionario);
    }
}
