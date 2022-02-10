package br.com.solinftec.treinamentospringboot.service;


import br.com.solinftec.treinamentospringboot.Dto.Monitoramento.SaveMonitoramentoDto;
import br.com.solinftec.treinamentospringboot.model.Monitoramento;
import br.com.solinftec.treinamentospringboot.repository.MonitoramentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MonitoramentoService {

    private final MonitoramentoRepository monitoramentoRepository;


    public SaveMonitoramentoDto save(SaveMonitoramentoDto saveMonitoramentoDto) {
        Monitoramento monitoramento = saveMonitoramentoDto.pegarModelMo();
        monitoramentoRepository.save(monitoramento);
        saveMonitoramentoDto.setId(monitoramento.getId());
        return saveMonitoramentoDto;
    }

    public SaveMonitoramentoDto update(SaveMonitoramentoDto saveMonitoramentoDto) throws Exception {

        Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(saveMonitoramentoDto.getId());

        if(monitoramento.isPresent()) {
            monitoramentoRepository.save(saveMonitoramentoDto.pegarModelMo());
            return saveMonitoramentoDto;
        } else {
            throw new Exception("MONITORAMENTO_NOT_FOUND");
        }
    }

    public void deletar(Long idMonitoramento) throws Exception {

        Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(idMonitoramento);

        if(monitoramento.isPresent()) {
            monitoramentoRepository.delete(monitoramento.get());
        } else {
            throw new Exception("MONITORAMENTO_NOT_FOUND");
        }
    }
}
