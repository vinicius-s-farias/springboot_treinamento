package br.com.solinftec.treinamentospringboot.Dto.TipoServico;

import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.model.Tipo_Servico;
import lombok.Data;

@Data
public class TipoServicoDto {

    private Long id;
    private String descricao;


    public TipoServicoDto(Tipo_Servico tipo_servico) {
        this.id = tipo_servico.getId();
        this.descricao = tipo_servico.getDescricao();
    }
}
