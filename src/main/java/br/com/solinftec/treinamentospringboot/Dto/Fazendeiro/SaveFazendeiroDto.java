package br.com.solinftec.treinamentospringboot.Dto.Fazendeiro;


import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SaveFazendeiroDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<Fazenda> fazendas;

    public Fazendeiro pegarModelFZ() {
        Fazendeiro fazendeiro = new Fazendeiro();
        fazendeiro.setId(this.id);
        fazendeiro.setNome(this.nome);
        fazendeiro.setEmail(this.email);
        fazendeiro.setTelefone(this.telefone);
        fazendeiro.setFazendas(fazendas.stream().map(Fazenda::new).collect(Collectors.toList()));
        return fazendeiro;
    }
}
