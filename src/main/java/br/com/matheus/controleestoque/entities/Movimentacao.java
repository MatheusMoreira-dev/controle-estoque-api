package br.com.matheus.controleestoque.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "movimentacoes")
public class Movimentacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataRegistro;
    private LocalDateTime dataVencimento;

    private TipoMovimentacao tipoMovimentacao;

    private Funcionario funcionarioResponsavel;
    private Deposito deposito;
    private Item item;
}
