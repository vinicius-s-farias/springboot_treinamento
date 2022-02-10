package br.com.solinftec.treinamentospringboot.resource;

import br.com.solinftec.treinamentospringboot.Dto.Monitoramento.SaveMonitoramentoDto;
import br.com.solinftec.treinamentospringboot.model.Monitoramento;
import br.com.solinftec.treinamentospringboot.service.MonitoramentoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoramento")
@RequiredArgsConstructor
public class MonitoramentoResource {

    private final MonitoramentoService service;
    private static final Logger logger = LoggerFactory.getLogger(Monitoramento.class);


    @PostMapping("")
    public ResponseEntity<SaveMonitoramentoDto> save(@RequestBody SaveMonitoramentoDto saveMonitoramentoDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveMonitoramentoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Monitoramento: {}", saveMonitoramentoDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveMonitoramentoDto> update(@RequestBody SaveMonitoramentoDto saveMonitoramentoDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveMonitoramentoDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Monitoramento: {}, error: {}", saveMonitoramentoDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idMonitoramento}")
    public ResponseEntity<?> deleteMonitoramento(@PathVariable("idMonitoramento") Long idMonitoramento) {
        try {
            service.deletar(idMonitoramento);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar monitoramento: {}, error: {}", idMonitoramento, e.getMessage());
            if(e.getMessage().equals("MONITORAMENTO_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}
