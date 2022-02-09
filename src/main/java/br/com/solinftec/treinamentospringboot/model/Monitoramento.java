package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "MONITORAMENTO")
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String Descricao;

    @Column(name = "LATITUDE")
    private Float Latitude;

    @Column(name = "DATE_HORA")
    private Date Data_Hora;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento ID_EQUIPAMENTO;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEM_SERVICO")
    private Ordem_Servico ID_ORDEM_SERVICO;
}
