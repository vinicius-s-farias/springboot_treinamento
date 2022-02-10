package br.com.solinftec.treinamentospringboot.Dto.Equipamento;

import br.com.solinftec.treinamentospringboot.model.Equipamento;

import lombok.Data;

@Data
public class EquipamentoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float Longitude;
    private Boolean ativo;

    public EquipamentoDto(Equipamento equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.Longitude = equipamento.getLongitude();
        this.ativo = equipamento.getAtivo();
    }
}
