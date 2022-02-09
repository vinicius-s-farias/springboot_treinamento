package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EQUIPAMENTO")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String Descricao;

    @Column(name = "LATITUDE")
    private Float Latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO")
    private Tipo_Equipamento id_tipo_equipamento;
}
