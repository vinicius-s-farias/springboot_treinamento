package br.com.solinftec.treinamentospringboot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "ORDEM_SERVICO")
public class Ordem_Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_COOPERATIVA")
    private Cooperativa ID_COOPERATIVA;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_FAZENDA")
    private Fazenda ID_FAZENDA;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento ID_EQUIPAMENTO;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ID_PRODUTO")
    private Produto ID_PRODUTO;

    @ManyToOne
    @JoinColumn(name = "TIPO_SERVICO")
    @JsonManagedReference
    private Tipo_Servico TIPO_SERVICO;

    @OneToMany(mappedBy = "ID_ORDEM_SERVICO")
    @JsonBackReference
    private List<Monitoramento> monitoramentos;

    @Column(name = "DATE_EXECUCAO")
    private Date Data_Execucao;

    @Column(name = "RATE_APLICACAO")
    private float Rate_Aplicacao;

    @Column(name = "TOTAL_APLICACAO")
    private Float Total_Aplicacao;




}
