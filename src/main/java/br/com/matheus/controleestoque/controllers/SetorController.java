package br.com.matheus.controleestoque.controllers;

import br.com.matheus.controleestoque.entities.Setor;
import br.com.matheus.controleestoque.services.SetorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {
    private final SetorService service;

    public SetorController(SetorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Setor> create(@RequestBody Setor setor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(setor));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Setor> getById(@PathVariable Long id){
        Optional<Setor> setor = service.getById(id);

        if(setor.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(setor.get());
    }

    @GetMapping
    public ResponseEntity<List<Setor>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Setor> patch(@PathVariable Long id, @RequestBody Setor setor){
        setor.setId(id);
        Setor updateSetor = service.update(setor);

        if(updateSetor == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateSetor);
    }
}
