package br.com.solinftec.treinamentospringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "ATIVO")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_EQUIPAMENTO")
    private Tipo_Equipamento id_tipo_equipamento;

    @OneToMany(mappedBy = "ID_EQUIPAMENTO")
    @JsonBackReference
    private List<Monitoramento> monitoramentos;

    @OneToMany(mappedBy = "ID_EQUIPAMENTO")
    @JsonBackReference
    private List<Ordem_Servico> ordem_servicos;

}
