package br.com.solinftec.treinamentospringboot.service;

import br.com.solinftec.treinamentospringboot.Dto.Equipamento.EquipamentoDto;
import br.com.solinftec.treinamentospringboot.Dto.Equipamento.SaveEquipamentoDto;
import br.com.solinftec.treinamentospringboot.model.Equipamento;
import br.com.solinftec.treinamentospringboot.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;

    public List<EquipamentoDto> getAllEquipamentos() {
        return equipamentoRepository.findAll()
                .stream()
                .map(equipamento -> new EquipamentoDto(equipamento))
                .collect(Collectors.toList());
    }


    public SaveEquipamentoDto saveEquipamento(SaveEquipamentoDto saveEquipamentoDto) {
        Equipamento equipamento = saveEquipamentoDto.pegarModelE();
        equipamentoRepository.save(equipamento);
        saveEquipamentoDto.setId(equipamento.getId());
        return saveEquipamentoDto;
    }

    public SaveEquipamentoDto updateEquipamento(SaveEquipamentoDto saveEquipamentoDto) throws Exception {

        Optional<Equipamento> equipamentoo = equipamentoRepository.findById(saveEquipamentoDto.getId());

        if(equipamentoo.isPresent()) {
            equipamentoRepository.save(saveEquipamentoDto.pegarModelE());
            return saveEquipamentoDto;
        } else {
            throw new Exception("EQUIPAMENTO_NOT_FOUND");
        }
    }

    public void deletarEquipamento(Long idEquipamento) throws Exception {

        Optional<Equipamento> equipamento = equipamentoRepository.findById(idEquipamento);

        if(equipamento.isPresent()) {
            equipamentoRepository.delete(equipamento.get());
        } else {
            throw new Exception("EQUIPAMENTO_NOT_FOUND");
        }
    }


}
