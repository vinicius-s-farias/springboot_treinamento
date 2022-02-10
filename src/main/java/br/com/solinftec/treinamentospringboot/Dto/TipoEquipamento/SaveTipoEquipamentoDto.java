package br.com.solinftec.treinamentospringboot.Dto.TipoEquipamento;

import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import lombok.Data;

@Data
public class SaveTipoEquipamentoDto {

    private Long id;
    private String descricao;


    public Tipo_Equipamento pegarModelTE() {
        Tipo_Equipamento tipo_equipamento = new Tipo_Equipamento();
        tipo_equipamento.setId(this.id);
        tipo_equipamento.setDescricao(this.descricao);
        return tipo_equipamento;
    }
}
