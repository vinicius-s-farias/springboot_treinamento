package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TIPO_EQUIPAMENTO")
public class Tipo_Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
