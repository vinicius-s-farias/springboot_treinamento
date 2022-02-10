package br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico;

import br.com.solinftec.treinamentospringboot.Dto.Monitoramento.MonitoramentoDto;
import br.com.solinftec.treinamentospringboot.model.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrdemdeServicoWithMonitoramentoDto {

    private List<MonitoramentoDto> monitoramento;
    private Float Total_Aplicacao;
    private float Rate_Aplicacao;
    private Date Data_Execucao;
    private Tipo_Servico TIPO_SERVICO;
    private Produto ID_PRODUTO;
    private Equipamento ID_EQUIPAMENTO;
    private Fazenda ID_FAZENDA;
    private Cooperativa ID_COOPERATIVA;
    private Long id;

    public OrdemdeServicoWithMonitoramentoDto(Ordem_Servico ordemdeServico) {
        this.id = ordemdeServico.getId();
        this.Total_Aplicacao = ordemdeServico.getTotal_Aplicacao();
        this.Data_Execucao = ordemdeServico.getData_Execucao();
        this.Rate_Aplicacao = ordemdeServico.getRate_Aplicacao();
        this.ID_PRODUTO = ordemdeServico.getID_PRODUTO();
        this.ID_EQUIPAMENTO = ordemdeServico.getID_EQUIPAMENTO();
        this.ID_FAZENDA = ordemdeServico.getID_FAZENDA();
        this.ID_COOPERATIVA = ordemdeServico.getID_COOPERATIVA();
        this.TIPO_SERVICO = ordemdeServico.getTIPO_SERVICO();
        this.monitoramento = ordemdeServico.getMonitoramentos().stream().map(MonitoramentoDto::new).collect(Collectors.toList());
    }
}
