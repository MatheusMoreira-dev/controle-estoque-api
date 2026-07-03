package br.com.matheus.controleestoque.repositories;

import br.com.matheus.controleestoque.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
