package br.com.solinftec.treinamentospringboot.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ORDEM_SERVICO")
public class Ordem_Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_COOPERATIVA")
    private Cooperativa ID_COOPERATIVA;

    @ManyToOne
    @JoinColumn(name = "ID_FAZENDA")
    private Fazenda ID_FAZENDA;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento ID_EQUIPAMENTO;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto ID_PRODUTO;

    @ManyToOne
    @JoinColumn(name = "TIPO_SERVICO")
    private Tipo_Servico TIPO_SERVICO;

    @Column(name = "DATE_EXECUCAO")
    private Date Data_Execucao;
}
