package br.com.solinftec.treinamentospringboot.service;


import br.com.solinftec.treinamentospringboot.Dto.TipoServico.SaveTipoServicoDto;
import br.com.solinftec.treinamentospringboot.Dto.TipoServico.TipoServicoWithOrdemDto;
import br.com.solinftec.treinamentospringboot.model.Tipo_Servico;
import br.com.solinftec.treinamentospringboot.repository.TipoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TipoServicoService {
    private final TipoServicoRepository tipoServicoRepository;


    public TipoServicoWithOrdemDto getServico(Long idServico) throws Exception {

        Optional<Tipo_Servico> tipo_servico = tipoServicoRepository.findById(idServico);
        if(tipo_servico.isPresent()) {
            return new TipoServicoWithOrdemDto(tipo_servico.get());
        } else {
            throw new Exception("NOT_FOUND");
        }

    }

    public SaveTipoServicoDto saveTServico(SaveTipoServicoDto tipoServicoDto) {
        Tipo_Servico tipo_servico = tipoServicoDto.pegarModelTS();
        tipoServicoRepository.save(tipo_servico);
        tipo_servico.setId(tipo_servico.getId());
        return tipoServicoDto;
    }

    public SaveTipoServicoDto updateTServico(SaveTipoServicoDto saveTipoServicoDto) throws Exception {

        Optional<Tipo_Servico> tipo_servico = tipoServicoRepository.findById(saveTipoServicoDto.getId());

        if(tipo_servico.isPresent()) {
            tipoServicoRepository.save(saveTipoServicoDto.pegarModelTS());
            return saveTipoServicoDto;
        } else {
            throw new Exception("TIPO_NOT_FOUND");
        }
    }

    public void deletarTServico(Long idServico) throws Exception {

        Optional<Tipo_Servico> tipo_servico = tipoServicoRepository.findById(idServico);

        if(tipo_servico.isPresent()) {
            tipoServicoRepository.delete(tipo_servico.get());
        } else {
            throw new Exception("TIPO_NOT_FOUND");
        }
    }
}
