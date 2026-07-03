package br.com.matheus.controleestoque.entities;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataRegistro;

    @ManyToOne
    private Funcionario funcionarioResponsavel;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "item")
    private List<Movimentacao> movimentacoes;

    public Item(Long id, String nome, String descricao, LocalDateTime dataRegistro, Funcionario funcionarioResponsavel, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.categoria = categoria;
    }
}
