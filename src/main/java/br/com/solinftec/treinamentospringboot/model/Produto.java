package br.com.solinftec.treinamentospringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private Float cidade;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToMany(mappedBy = "ID_PRODUTO")
    @JsonBackReference
    private List<Ordem_Servico> ordem_servicos;

}
