package br.com.solinftec.treinamentospringboot.Dto.Monitoramento;

import br.com.solinftec.treinamentospringboot.model.Equipamento;
import br.com.solinftec.treinamentospringboot.model.Monitoramento;
import br.com.solinftec.treinamentospringboot.model.Ordem_Servico;
import lombok.Data;

import java.util.Date;

@Data
public class MonitoramentoDto {

    private Long id;
    private String Descricao;
    private Float Latitude;
    private Date Data_Hora;
    private Equipamento ID_EQUIPAMENTO;
    private Ordem_Servico ID_ORDEM_SERVICO;


    public MonitoramentoDto(Monitoramento monitoramento) {
        this.id = monitoramento.getId();
        this.Descricao = monitoramento.getDescricao();
        this.Latitude = monitoramento.getLatitude();
        this.Data_Hora = monitoramento.getData_Hora();
        this.ID_EQUIPAMENTO = monitoramento.getID_EQUIPAMENTO();
        this.ID_ORDEM_SERVICO = monitoramento.getID_ORDEM_SERVICO();
    }
}
