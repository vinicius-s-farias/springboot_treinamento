package br.com.solinftec.treinamentospringboot.service;


import br.com.solinftec.treinamentospringboot.Dto.TipoEquipamento.SaveTipoEquipamentoDto;
import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import br.com.solinftec.treinamentospringboot.repository.TipoEquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TipoEquipamentoService {
    private final TipoEquipamentoRepository tipoEquipamentoRepository;



    public SaveTipoEquipamentoDto saveTipoEquipamentoDto(SaveTipoEquipamentoDto saveTipoEquipamentoDto) {
        Tipo_Equipamento tipo_equipamento = saveTipoEquipamentoDto.pegarModelTE();
        tipoEquipamentoRepository.save(tipo_equipamento);
        saveTipoEquipamentoDto.setId(tipo_equipamento.getId());
        return saveTipoEquipamentoDto;
    }

    public SaveTipoEquipamentoDto updateTEquipamento(SaveTipoEquipamentoDto saveTipoEquipamentoDto) throws Exception {

        Optional<Tipo_Equipamento> tipo_equipamentoo = tipoEquipamentoRepository.findById(saveTipoEquipamentoDto.getId());

        if(tipo_equipamentoo.isPresent()) {
            tipoEquipamentoRepository.save(saveTipoEquipamentoDto.pegarModelTE());
            return saveTipoEquipamentoDto;
        } else {
            throw new Exception("TIPO_EQUIPAMENTO_NOT_FOUND");
        }
    }

    public void deletarTEquipamento(Long idTipoEQ) throws Exception {

        Optional<Tipo_Equipamento> tipo_equipamento = tipoEquipamentoRepository.findById(idTipoEQ);

        if(tipo_equipamento.isPresent()) {
            tipoEquipamentoRepository.delete(tipo_equipamento.get());
        } else {
            throw new Exception("TIPO_EQUIPAMENTO_NOT_FOUND");
        }
    }
}
