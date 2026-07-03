package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {
}
