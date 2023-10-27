package br.com.dennisapi.localizacao.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name = "tb_cidade" )
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "qtd_habitantes", length = 20)
    private Long habitantes;

}