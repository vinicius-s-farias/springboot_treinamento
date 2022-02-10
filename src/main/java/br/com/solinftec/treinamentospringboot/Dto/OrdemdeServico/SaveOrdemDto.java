package br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico;

import br.com.solinftec.treinamentospringboot.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class SaveOrdemDto {
    private Float Total_Aplicacao;
    private float Rate_Aplicacao;
    private Date Data_Execucao;
    private Tipo_Servico TIPO_SERVICO;
    private Produto ID_PRODUTO;
    private Equipamento ID_EQUIPAMENTO;
    private Fazenda ID_FAZENDA;
    private Cooperativa ID_COOPERATIVA;
    private Long id;

    public Ordem_Servico pegarModelO() {
        Ordem_Servico ordem_servico = new Ordem_Servico();
        ordem_servico.setID_COOPERATIVA(this.ID_COOPERATIVA);
        ordem_servico.setID_FAZENDA(this.ID_FAZENDA);
        ordem_servico.setID_EQUIPAMENTO(this.ID_EQUIPAMENTO);
        ordem_servico.setID_PRODUTO(this.ID_PRODUTO);
        ordem_servico.setData_Execucao(this.Data_Execucao);
        ordem_servico.setRate_Aplicacao(this.Rate_Aplicacao);
        ordem_servico.setTotal_Aplicacao(this.Total_Aplicacao);
        return ordem_servico;
    }
}
