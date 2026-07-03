package br.com.matheus.controleestoque.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Setor setor;

    @OneToMany(mappedBy = "funcionarioResponsavel")
    private List<Item> itensRegistrados;

    @OneToMany(mappedBy = "funcionarioResponsavel")
    private List<Movimentacao> movimentacoes;

    public Funcionario(Long id, String nome, Setor setor) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
    }
}
