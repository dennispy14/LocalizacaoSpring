package br.com.dennisapi.localizacao.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table( name = "tb_cidade" )
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cidade")
    private Integer id;

    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "qtd_habitantes", length = 20)
    private Integer qtdHabitantes;

}