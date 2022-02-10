package br.com.solinftec.treinamentospringboot.Dto.Fazenda;

import br.com.solinftec.treinamentospringboot.Dto.Fazendeiro.FazendeiroDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import lombok.Data;

@Data
public class GetAllFazendaDto {
    private Long id;
    private String descricao;
    private Float area;
    private Float latitude;
    private Float longitude;
    private FazendeiroDto fazendeiro;

    public GetAllFazendaDto(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.descricao = fazenda.getDescricao();
        this.area = fazenda.getArea();
        this.latitude = fazenda.getLatitude();
        this.longitude = fazenda.getLongitude();
        this.fazendeiro = new FazendeiroDto(fazenda.getFazendeiro());
    }
}
