package br.com.solinftec.treinamentospringboot.Dto.Fazenda;


import br.com.solinftec.treinamentospringboot.model.Fazenda;
import lombok.Data;

import java.util.List;

@Data
public class SaveFazendaDto {
    private Long id;
    private String descricao;
    private Float area;
    private Float latitude;
    private Float longitude;
    private List<Long> fazendeiros;

    public Fazenda pegarModelFA() {
        Fazenda fazenda = new Fazenda();
        fazenda.setDescricao(this.descricao);
        fazenda.setArea(this.area);
        fazenda.setLatitude(this.latitude);
        fazenda.setId(this.id);
//        fazenda.setFazendeiro(this.fazendeiros);
        return fazenda;
    }
}
