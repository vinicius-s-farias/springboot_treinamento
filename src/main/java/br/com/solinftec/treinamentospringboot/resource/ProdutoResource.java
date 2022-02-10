package br.com.solinftec.treinamentospringboot.resource;

import br.com.solinftec.treinamentospringboot.Dto.Fazenda.GetAllFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Fazenda.SaveFazendaDto;
import br.com.solinftec.treinamentospringboot.Dto.Produto.ProdutoDto;
import br.com.solinftec.treinamentospringboot.Dto.Produto.SaveProdutoDto;
import br.com.solinftec.treinamentospringboot.model.Fazenda;
import br.com.solinftec.treinamentospringboot.model.Produto;
import br.com.solinftec.treinamentospringboot.service.FazendaService;
import br.com.solinftec.treinamentospringboot.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoResource {

    private final ProdutoService produtoService;
    private static final Logger logger = LoggerFactory.getLogger(Produto.class);


    @GetMapping("")
    public ResponseEntity<List<ProdutoDto>> getAllProdutos() {
        return ResponseEntity.ok().body(produtoService.getAllProdutos());
    }

    @PostMapping("")
    public ResponseEntity<SaveProdutoDto> save(@RequestBody SaveProdutoDto saveProdutoDto) {
        try {
            return ResponseEntity.ok().body(produtoService.saveProduto(saveProdutoDto));
        } catch (Exception e) {
            logger.error("Erro ao salvar Produto: {}", saveProdutoDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveProdutoDto> update(@RequestBody SaveProdutoDto saveProdutoDto) {
        try {
            return ResponseEntity.ok().body(produtoService.updateProduto(saveProdutoDto));
        } catch (Exception e) {
            logger.error("Erro ao atualizar Produtos: {}, error: {}", saveProdutoDto, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<?> delete(@PathVariable("idProduto") Long idProduto) {
        try {
            produtoService.deletarProduto(idProduto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar Produto: {}, error: {}", idProduto, e.getMessage());
            if(e.getMessage().equals("EQUIPAMENTO_NOT_FOUND"))
                return ResponseEntity.notFound().build();
            return ResponseEntity.badRequest().build();
        }
    }
}
