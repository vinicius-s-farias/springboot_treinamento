package br.com.solinftec.treinamentospringboot.Dto.TipoServico;

import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.model.Tipo_Servico;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TipoServicoWithOrdemDto {

    private Long id;
    private String descricao;
    private List<OrdemdeServicoDto> ordem;

    public TipoServicoWithOrdemDto(Tipo_Servico tipo_servico) {

        this.id = tipo_servico.getId();
        this.descricao = tipo_servico.getDescricao();
        this.ordem = tipo_servico.getOrdem_servicos().stream().map(OrdemdeServicoDto::new).collect(Collectors.toList());
    }
}
