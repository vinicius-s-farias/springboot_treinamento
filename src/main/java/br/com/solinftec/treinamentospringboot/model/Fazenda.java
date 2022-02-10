package br.com.solinftec.treinamentospringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FAZENDA")
public class Fazenda {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name = "DESCRICAO")
        private String descricao;

        @ManyToOne
        @JoinColumn(name = "id_fazendeiro")
        @JsonManagedReference
        private Fazendeiro fazendeiro;

        @Column(name = "AREA")
        private float area;

        @Column(name = "LATITUDE")
        private float latitude;

        @Column(name = "LONGITUDE")
        private float longitude;

        @OneToMany(mappedBy = "ID_FAZENDA")
        @JsonBackReference
        private List<Ordem_Servico> ordem_servicos;


        public Fazenda(Fazenda fazenda) {
        }

        public Fazenda() {

        }
}
