package br.com.solinftec.treinamentospringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FAZENDA")
public class Fazenda {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_fazendeiro")
        private Fazendeiro ID_FAZENDEIRO;

        @Column(name = "AREA")
        private float area;

        @Column(name = "LATITUDE")
        private float latitude;

        @Column(name = "LONGITUDE")
        private float longitude;



}
