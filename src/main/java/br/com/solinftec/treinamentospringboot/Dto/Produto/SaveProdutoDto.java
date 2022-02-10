package br.com.solinftec.treinamentospringboot.Dto.Produto;


import br.com.solinftec.treinamentospringboot.model.Produto;
import lombok.Data;


@Data
public class SaveProdutoDto {

    private Long id;
    private String descricao;
    private Float LATITUDE;
    private Float cidade;
    private Boolean ativo;

    public Produto pegarModelPR() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setDescricao(this.descricao);
        produto.setLATITUDE(this.LATITUDE);
        produto.setCidade(this.cidade);
        produto.setAtivo(this.ativo);
        return produto;

    }

}
