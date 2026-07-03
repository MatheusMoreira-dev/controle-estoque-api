package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
