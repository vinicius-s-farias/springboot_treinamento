package br.com.solinftec.treinamentospringboot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "TIPO_SERVICO")
public class Tipo_Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String Descricao;

    @OneToMany(mappedBy = "TIPO_SERVICO")
    @JsonBackReference
    private List<Ordem_Servico> ordem_servicos;


}
