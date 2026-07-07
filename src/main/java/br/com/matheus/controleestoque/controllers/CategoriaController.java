package br.com.matheus.controleestoque.controllers;

import br.com.matheus.controleestoque.entities.Categoria;
import br.com.matheus.controleestoque.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> delete(Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
