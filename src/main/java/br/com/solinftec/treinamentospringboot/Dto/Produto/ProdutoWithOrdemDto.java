package br.com.solinftec.treinamentospringboot.Dto.Produto;

import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoDto;
import br.com.solinftec.treinamentospringboot.model.Produto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProdutoWithOrdemDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float cidade;
    private Boolean ativo;
    private List<OrdemdeServicoDto> ordem;

    public ProdutoWithOrdemDto(Produto produto) {

        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.cidade = produto.getCidade();
        this.ativo = produto.getAtivo();
        this.ordem = produto.getOrdem_servicos().stream().map(OrdemdeServicoDto::new).collect(Collectors.toList());
    }
}
