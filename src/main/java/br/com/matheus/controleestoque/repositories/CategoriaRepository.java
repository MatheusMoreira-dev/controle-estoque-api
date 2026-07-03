package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
