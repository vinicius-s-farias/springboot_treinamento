package br.com.solinftec.treinamentospringboot.resource;

import br.com.solinftec.treinamentospringboot.Dto.Cooperativa.SaveCooperativaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazendeiro.FazendeiroWithFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazendeiro.SaveFazendeiroDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.service.FazendeiroService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fazendeiro")
@RequiredArgsConstructor
public class FazendeiroResource {
    private final FazendeiroService service;
    private static final Logger logger = LoggerFactory.getLogger(Fazendeiro.class);


    @GetMapping("/{idFazendeiro}")
    public ResponseEntity<FazendeiroWithFazendaDto> getFazendeiro(@PathVariable("idFazendeiro") Long idFazendeiro) {
        try {
            return ResponseEntity.ok().body(service.getFazendeiro(idFazendeiro));
        } catch (Exception e) {
            if(e.getMessage().equals("FAZENDEIRO_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<SaveFazendeiroDto> save(@RequestBody SaveFazendeiroDto saveFazendeiroDto) {
        try {
            return ResponseEntity.ok().body(service.save(saveFazendeiroDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Fazendeiro: {}", saveFazendeiroDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveFazendeiroDto> update(@RequestBody SaveFazendeiroDto saveFazendeiroDto) {
        try {
            return ResponseEntity.ok().body(service.update(saveFazendeiroDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Fazendeiros: {}, error: {}", saveFazendeiroDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idCooperativa}")
    public ResponseEntity<?> delete(@PathVariable("idFazendeiro") Long idFazendeiro) {
        try {
            service.deletar(idFazendeiro);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Fazendeiro: {}, error: {}", idFazendeiro, e.getMessage());
            if(e.getMessage().equals("FAZENDEIRO_NOT_FOUND"))
                return ResponseEntity.notFound().build();

            return ResponseEntity.badRequest().build();
        }
    }

}
