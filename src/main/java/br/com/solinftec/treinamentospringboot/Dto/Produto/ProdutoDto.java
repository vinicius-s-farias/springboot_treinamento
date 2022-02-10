package br.com.solinftec.treinamentospringboot.Dto.Produto;


import br.com.solinftec.treinamentospringboot.model.Produto;
import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float cidade;
    private Boolean ativo;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.cidade = produto.getCidade();
        this.ativo = produto.getAtivo();
    }
}
