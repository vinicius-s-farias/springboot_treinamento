package br.com.solinftec.treinamentospringboot.resource;


import br.com.solinftec.treinamentospringboot.Dto.Fazenda.GetAllFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.service.FazendaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fazenda")
@RequiredArgsConstructor
public class FazendaResource {

    private final FazendaService service;
    private static final Logger logger = LoggerFactory.getLogger(Fazenda.class);


    @GetMapping("")
    public ResponseEntity<List<GetAllFazendaDto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping("")
    public ResponseEntity<SaveFazendaDto> save(@RequestBody SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar saveCooperativaDto: {}", saveFazendaDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveFazendaDto> update(@RequestBody SaveFazendaDto saveFazendaDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveFazendaDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Fazendas: {}, error: {}", saveFazendaDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idFazenda}")
    public ResponseEntity<?> delete(@PathVariable("idFazenda") Long idFazenda) {
        try {
            service.deletar(idFazenda);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Fazenda: {}, error: {}", idFazenda, e.getMessage());
            if(e.getMessage().equals("FAZENDA_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }

}
