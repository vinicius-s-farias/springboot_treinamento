package br.com.solinftec.treinamentospringboot.service;

import br.com.solinftec.treinamentospringboot.Dto.Fazendeiro.FazendeiroWithFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazendeiro.SaveFazendeiroDto;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.repository.FazendeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FazendeiroService {

    private final FazendeiroRepository fazendeiroRepository;

    public FazendeiroWithFazendaDto getFazendeiro(Long idFazendeiro) throws Exception {

        Optional<Fazendeiro> fazendeiro = fazendeiroRepository.findById(idFazendeiro);
        if(fazendeiro.isPresent()) {
            return new FazendeiroWithFazendaDto(fazendeiro.get());
        } else {
            throw new Exception("FAZENDEIRO_NOT_FOUND");
        }

    }

    public SaveFazendeiroDto save(SaveFazendeiroDto saveFazendeiroDto) {
        Fazendeiro fazendeiro = saveFazendeiroDto.pegarModelFZ();
        fazendeiroRepository.save(fazendeiro);
        saveFazendeiroDto.setId(fazendeiro.getId());
        return saveFazendeiroDto;
    }

    public SaveFazendeiroDto update(SaveFazendeiroDto saveFazendeiroDto) throws Exception {

        Optional<Fazendeiro> fazendeiro = fazendeiroRepository.findById(saveFazendeiroDto.getId());

        if(fazendeiro.isPresent()) {
            fazendeiroRepository.save(saveFazendeiroDto.pegarModelFZ());
            return saveFazendeiroDto;
        } else {
            throw new Exception("COOPERATIVA_NOT_FOUND");
        }
    }

    public void deletar(Long idFazendeiro) throws Exception {

        Optional<Fazendeiro> fazendeiro = fazendeiroRepository.findById(idFazendeiro);

        if(fazendeiro.isPresent()) {
            fazendeiroRepository.delete(fazendeiro.get());
        } else {
            throw new Exception("COOPERATIVA_NOT_FOUND");
        }
    }
}
