package br.com.solinftec.treinamentospringboot.dto.cooperativa;

import br.com.solinftec.treinamentospringboot.model.Cooperativa;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SaveCooperativaDto {

    private Long id;
    private String nome;
    private String email;
    private List<Long> fazendeiros;

    public Cooperativa pegarModel() {
        Cooperativa cooperativa = new Cooperativa();
        cooperativa.setAtivo(true);
        cooperativa.setNome(this.nome);
        cooperativa.setEmail(this.email);
        cooperativa.setId(this.id);
        cooperativa.setFazendeiros(fazendeiros.stream().map(Fazendeiro::new).collect(Collectors.toList()));
        return cooperativa;
    }

}
