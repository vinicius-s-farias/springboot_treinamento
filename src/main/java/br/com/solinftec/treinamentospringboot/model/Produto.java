package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "LATITUDE")
    private Float LATITUDE;

    @Column(name = "ID_CIDADE")
    private Float id_cidade;

    @Column(name = "ATIVO")
    private Boolean ativo;

}
