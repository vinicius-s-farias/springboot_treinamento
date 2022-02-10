package br.com.solinftec.treinamentospringboot.resource;

import br.com.solinftec.treinamentospringboot.Dto.TipoEquipamento.SaveTipoEquipamentoDto;
import br.com.solinftec.treinamentospringboot.model.Tipo_Equipamento;
import br.com.solinftec.treinamentospringboot.service.TipoEquipamentoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/tipoequip")
@RequiredArgsConstructor
public class TipoEquipamentoResource {

    private final TipoEquipamentoService service;
    private static final Logger logger = LoggerFactory.getLogger(Tipo_Equipamento.class);

    @PostMapping("")
    public ResponseEntity<SaveTipoEquipamentoDto> saveTEquipamento(@RequestBody SaveTipoEquipamentoDto saveTipoEquipamentoDto) {
        try {
            return ResponseEntity.ok().body(service.saveTipoEquipamentoDto(saveTipoEquipamentoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Equipamento: {}", saveTipoEquipamentoDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveTipoEquipamentoDto> updateEquipamento(@RequestBody SaveTipoEquipamentoDto saveTipoEquipamentoDto) {
        try {
            return ResponseEntity.ok().body(service.updateTEquipamento(saveTipoEquipamentoDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Equipamento: {}, error: {}", saveTipoEquipamentoDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idTipoEQ}")
    public ResponseEntity<?> deleteServico(@PathVariable("idTipoEQ") Long idTipoEQ) {
        try {
            service.deletarTEquipamento(idTipoEQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Equipamento: {}, error: {}", idTipoEQ, e.getMessage());
            if(e.getMessage().equals("EQUIPAMENTO_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }
}
