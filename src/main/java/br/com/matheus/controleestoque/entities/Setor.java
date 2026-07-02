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
@Table(name = "setor")
public class Setor implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios;

    public Setor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
