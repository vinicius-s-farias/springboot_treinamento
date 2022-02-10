package br.com.solinftec.treinamentospringboot.Dto.TipoServico;

import br.com.solinftec.treinamentospringboot.model.Cooperativa;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.model.Tipo_Servico;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class SaveTipoServicoDto {


    private Long id;
    private String descricao;


    public Tipo_Servico pegarModelTS() {
        Tipo_Servico tipo_servico = new Tipo_Servico();
        tipo_servico.setId(this.id);
        tipo_servico.setDescricao(this.descricao);
        return tipo_servico;
    }

}
