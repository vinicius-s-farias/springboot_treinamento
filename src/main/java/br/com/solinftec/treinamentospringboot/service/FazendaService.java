package br.com.solinftec.treinamentospringboot.service;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.GetAllFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.repository.FazendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FazendaService {

    private final FazendaRepository repository;

    public List<GetAllFazendaDto> getAll() {
        return repository.findAll().stream()
                .map(fazenda -> new GetAllFazendaDto(fazenda))
                .collect(Collectors.toList());
    }

    public SaveFazendaDto save(SaveFazendaDto saveFazendaDto) {
        Fazenda fazenda = saveFazendaDto.pegarModelFA();
        repository.save(fazenda);
        saveFazendaDto.setId(fazenda.getId());
        return saveFazendaDto;
    }

    public SaveFazendaDto update(SaveFazendaDto saveFazendaDto) throws Exception {

        Optional<Fazenda> fazenda = repository.findById(saveFazendaDto.getId());

        if(fazenda.isPresent()) {
            repository.save(saveFazendaDto.pegarModelFA());
            return saveFazendaDto;
        } else {
            throw new Exception("COOPERATIVA_NOT_FOUND");
        }
    }

    public void deletar(Long idFazenda) throws Exception {

        Optional<Fazenda> fazenda = repository.findById(idFazenda);

        if(fazenda.isPresent()) {
            repository.delete(fazenda.get());
        } else {
            throw new Exception("COOPERATIVA_NOT_FOUND");
        }
    }

}
