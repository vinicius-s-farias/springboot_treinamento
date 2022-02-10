package br.com.solinftec.treinamentospringboot.Dto.Equipamento;


import br.com.solinftec.treinamentospringboot.Dto.Monitoramento.MonitoramentoDto;
import br.com.solinftec.treinamentospringboot.model.Equipamento;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EquipamentoWithMonitoramentoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float Longitude;
    private Boolean ativo;
    private List<MonitoramentoDto> monitoramento;

    public EquipamentoWithMonitoramentoDto(Equipamento equipamento) {
        this.id = equipamento.getId();
        this.descricao = equipamento.getDescricao();
        this.LATITUDE = equipamento.getLatitude();
        this.Longitude = equipamento.getLongitude();
        this.ativo = equipamento.getAtivo();
        this.monitoramento = equipamento.getMonitoramentos().stream().map(MonitoramentoDto::new).collect(Collectors.toList());
    }

}
