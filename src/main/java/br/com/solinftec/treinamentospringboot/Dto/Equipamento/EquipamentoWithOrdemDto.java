package br.com.solinftec.treinamentospringboot.Dto.Equipamento;


import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoDto;
import br.com.solinftec.treinamentospringboot.model.Equipamento;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EquipamentoWithOrdemDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float Longitude;
    private Boolean ativo;
    private List<OrdemdeServicoDto> ordem;

    public EquipamentoWithOrdemDto(Equipamento equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.LATITUDE = equipamento.getLatitude();
        this.Longitude = equipamento.getLongitude();
        this.ativo = equipamento.getAtivo();
        this.ordem = equipamento.getOrdem_servicos().stream().map(OrdemdeServicoDto::new).collect(Collectors.toList());
    }
}
