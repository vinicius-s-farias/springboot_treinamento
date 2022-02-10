package br.com.solinftec.treinamentospringboot.service;

import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.OrdemdeServicoWithMonitoramentoDto;
import br.com.solinftec.treinamentospringboot.Dto.OrdemdeServico.SaveOrdemDto;
import br.com.solinftec.treinamentospringboot.model.Ordem_Servico;
import br.com.solinftec.treinamentospringboot.repository.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrdemServicoService {
    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemdeServicoWithMonitoramentoDto getORdem(Long idOrdem) throws Exception {

        Optional<Ordem_Servico> ordem_servico = ordemServicoRepository.findById(idOrdem);
        if(ordem_servico.isPresent()) {
            return new OrdemdeServicoWithMonitoramentoDto(ordem_servico.get());
        } else {
            throw new Exception("NOT_FOUND");
        }

    }

    public SaveOrdemDto saveOrdem(SaveOrdemDto saveOrdemDto) {
        Ordem_Servico ordem_servico = saveOrdemDto.pegarModelO();
        ordemServicoRepository.save(ordem_servico);
        saveOrdemDto.setId(ordem_servico.getId());
        return saveOrdemDto;
    }

    public SaveOrdemDto updateOrdem(SaveOrdemDto saveOrdemDto) throws Exception {

        Optional<Ordem_Servico> ordem_servico = ordemServicoRepository.findById(saveOrdemDto.getId());

        if(ordem_servico.isPresent()) {
            ordemServicoRepository.save(saveOrdemDto.pegarModelO());
            return saveOrdemDto;
        } else {
            throw new Exception("ORDEM_NOT_FOUND");
        }
    }

    public void deletarOrdem(Long idOrdem) throws Exception {

        Optional<Ordem_Servico> ordem_servico = ordemServicoRepository.findById(idOrdem);

        if(ordem_servico.isPresent()) {
            ordemServicoRepository.delete(ordem_servico.get());
        } else {
            throw new Exception("ORDEM_NOT_FOUND");
        }
    }
}
