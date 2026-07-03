package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
