package br.com.solinftec.treinamentospringboot.Dto.Equipamento;

import br.com.solinftec.treinamentospringboot.model.Equipamento;

import lombok.Data;


@Data
public class SaveEquipamentoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float Longitude;
    private Boolean ativo;

    public Equipamento pegarModelE() {
        Equipamento equipamento = new Equipamento();
        equipamento.setAtivo(true);
        equipamento.setId(this.id);
        equipamento.setDescricao(this.descricao);
        equipamento.setLatitude(this.LATITUDE);
        equipamento.setLongitude(this.Longitude);
        return equipamento;
    }

}
