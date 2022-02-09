package br.com.solinftec.treinamentospringboot.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TIPO_SERVICO")
public class Tipo_Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String Descricao;

}
