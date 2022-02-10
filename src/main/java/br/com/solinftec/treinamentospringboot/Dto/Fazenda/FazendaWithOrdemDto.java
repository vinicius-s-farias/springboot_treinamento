package br.com.solinftec.treinamentospringboot.Dto.Fazenda;

import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class FazendaWithOrdemDto {

    private Long id;
    private String descricao;
    private Float area;
    private Float latitude;
    private Float longitude;
    private List<OrdemdeServicoDto> ordem;

    public FazendaWithOrdemDto(Fazenda fazenda) {

        this.id = fazenda.getId();
        this.descricao = fazenda.getDescricao();
        this.area = fazenda.getArea();
        this.latitude = fazenda.getLatitude();
        this.longitude = fazenda.getLongitude();
        this.ordem = fazenda.getOrdem_servicos().stream().map(OrdemdeServicoDto::new).collect(Collectors.toList());
    }

}
