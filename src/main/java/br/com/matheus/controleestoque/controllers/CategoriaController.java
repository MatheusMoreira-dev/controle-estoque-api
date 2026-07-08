package br.com.matheus.controleestoque.controllers;

import br.com.matheus.controleestoque.entities.Categoria;
import br.com.matheus.controleestoque.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(categoria));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id){
        Optional<Categoria> categoria = service.getById(id);

        if(categoria.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoria.get());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PatchMapping
    public ResponseEntity<Categoria> patch(@RequestBody Categoria categoria){
        Categoria updateCategoria = service.update(categoria);

        if(updateCategoria == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateCategoria);
    }
}