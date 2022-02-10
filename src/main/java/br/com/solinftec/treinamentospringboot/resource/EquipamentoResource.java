package br.com.solinftec.treinamentospringboot.resource;


import br.com.solinftec.treinamentospringboot.Dto.Equipamento.EquipamentoDto;
import br.com.solinftec.treinamentospringboot.Dto.Equipamento.SaveEquipamentoDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Produto.ProdutoDto;
import br.com.solinftec.treinamentospringboot.Dto.Produto.SaveProdutoDto;
import br.com.solinftec.treinamentospringboot.model.Equipamento;
import br.com.solinftec.treinamentospringboot.model.Produto;
import br.com.solinftec.treinamentospringboot.service.EquipamentoService;
import br.com.solinftec.treinamentospringboot.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
@RequiredArgsConstructor
public class EquipamentoResource {

    private final EquipamentoService equipamentoService;
    private static final Logger logger = LoggerFactory.getLogger(Equipamento.class);


    @GetMapping("")
    public ResponseEntity<List<EquipamentoDto>> getAllEquipamentos() {
        return ResponseEntity.ok().body(equipamentoService.getAllEquipamentos());
    }

    @PostMapping("")
    public ResponseEntity<SaveEquipamentoDto> saveEquipamento(@RequestBody SaveEquipamentoDto saveEquipamentoDto) {
        try {
            return ResponseEntity.ok().body(equipamentoService.saveEquipamento(saveEquipamentoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Equipamento: {}", saveEquipamentoDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveEquipamentoDto> update(@RequestBody SaveEquipamentoDto saveEquipamentoDto) {
        try {
            return ResponseEntity.ok().body(equipamentoService.updateEquipamento(saveEquipamentoDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Equipamentos: {}, error: {}", saveEquipamentoDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idEquipamento}")
    public ResponseEntity<?> delete(@PathVariable("idEquipamento") Long idEquipamento) {
        try {
            equipamentoService.deletarEquipamento(idEquipamento);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Equipamento: {}, error: {}", idEquipamento, e.getMessage());
            if(e.getMessage().equals("Equipamento_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }


}
