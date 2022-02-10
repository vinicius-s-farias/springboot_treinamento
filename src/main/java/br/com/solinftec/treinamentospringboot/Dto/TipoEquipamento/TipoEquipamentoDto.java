package br.com.solinftec.treinamentospringboot.Dto.TipoEquipamento;


import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import lombok.Data;

@Data
public class TipoEquipamentoDto {

    private Long id;
    private String descricao;

    public TipoEquipamentoDto(Tipo_Equipamento tipo_equipamento) {
        this.id = tipo_equipamento.getId();
        this.descricao = tipo_equipamento.getDescricao();
    }
}
