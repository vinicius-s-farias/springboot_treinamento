package br.com.solinftec.treinamentospringboot.Dto.Monitoramento;

import br.com.solinftec.treinamentospringboot.model.*;
import lombok.Data;
import java.util.Date;

@Data
public class SaveMonitoramentoDto {

    private Long id;
    private String Descricao;
    private Float Latitude;
    private Date Data_Hora;
    private Equipamento ID_EQUIPAMENTO;
    private Ordem_Servico ID_ORDEM_SERVICO;

    public Monitoramento pegarModelMo() {
        Monitoramento monitoramento = new Monitoramento();
        monitoramento.setId(this.id);
        monitoramento.setDescricao(this.Descricao);
        monitoramento.setLatitude(this.Latitude);
        monitoramento.setData_Hora(this.Data_Hora);
        monitoramento.setID_EQUIPAMENTO(this.ID_EQUIPAMENTO);
        monitoramento.setID_ORDEM_SERVICO(this.getID_ORDEM_SERVICO());

        return monitoramento;
    }

}
