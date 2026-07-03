package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
