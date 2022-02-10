package br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico;

import br.com.solinftec.treinamentospringboot.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class OrdemdeServicoDto {

    private Float Total_Aplicacao;
    private float Rate_Aplicacao;
    private Date Data_Execucao;
    private Tipo_Servico TIPO_SERVICO;
    private Produto ID_PRODUTO;
    private Equipamento ID_EQUIPAMENTO;
    private Fazenda ID_FAZENDA;
    private Cooperativa ID_COOPERATIVA;
    private Long id;

    public OrdemdeServicoDto(Ordem_Servico ordem_servico) {
        this.id = ordem_servico.getId();
        this.ID_COOPERATIVA = ordem_servico.getID_COOPERATIVA();
        this.ID_FAZENDA = ordem_servico.getID_FAZENDA();
        this.ID_EQUIPAMENTO = ordem_servico.getID_EQUIPAMENTO();
        this.TIPO_SERVICO = ordem_servico.getTIPO_SERVICO();
        this.Data_Execucao = ordem_servico.getData_Execucao();
        this.Rate_Aplicacao = ordem_servico.getRate_Aplicacao();
        this.Total_Aplicacao = ordem_servico.getTotal_Aplicacao();
    }
}
