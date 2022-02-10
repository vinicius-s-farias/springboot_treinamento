package br.com.solinftec.treinamentospringboot.Dto.Fazendeiro;

import br.com.solinftec.treinamentospringboot.Dto.Fazenda.FazendaDto;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;

import java.util.List;
import java.util.stream.Collectors;

public class FazendeiroWithFazendaDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<FazendaDto> fazendas;

    public FazendeiroWithFazendaDto(Fazendeiro fazendeiro) {
        this.id = fazendeiro.getId();
        this.nome = fazendeiro.getNome();
        this.email = fazendeiro.getEmail();
        this.telefone = fazendeiro.getTelefone();
        this.fazendas = fazendeiro.getFazendas().stream().map(FazendaDto::new).collect(Collectors.toList());
    }
}
