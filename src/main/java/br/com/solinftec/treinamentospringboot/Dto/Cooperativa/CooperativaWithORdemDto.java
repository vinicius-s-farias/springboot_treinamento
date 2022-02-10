package br.com.solinftec.treinamentospringboot.Dto.Cooperativa;

import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoDto;
import br.com.solinftec.treinamentospringboot.model.Cooperativa;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CooperativaWithORdemDto {

    private Long id;
    private String nome;
    private String email;
    private List<OrdemdeServicoDto> ordem;

    public CooperativaWithORdemDto(Cooperativa cooperativa) {

        this.id = cooperativa.getId();
        this.nome = cooperativa.getNome();
        this.email = cooperativa.getEmail();
        this.ordem = cooperativa.getOrdem_servicos().stream().map(OrdemdeServicoDto::new).collect(Collectors.toList());
    }
}
