package br.com.solinftec.treinamentospringboot.service;

import br.com.solinftec.treinamentospringboot.Dto.Produto.ProdutoDto;
import br.com.solinftec.treinamentospringboot.Dto.Produto.SaveProdutoDto;
import br.com.solinftec.treinamentospringboot.model.Produto;
import br.com.solinftec.treinamentospringboot.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public List<ProdutoDto> getAllProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(produto -> new ProdutoDto(produto))
                .collect(Collectors.toList());
    }


    public SaveProdutoDto saveProduto(SaveProdutoDto saveprodutoDto) {
        Produto produto = saveprodutoDto.pegarModelPR();
        produtoRepository.save(produto);
        saveprodutoDto.setId(produto.getId());
        return saveprodutoDto;
    }

    public SaveProdutoDto updateProduto(SaveProdutoDto saveProdutoDto) throws Exception {

        Optional<Produto> produto = produtoRepository.findById(saveProdutoDto.getId());

        if(produto.isPresent()) {
            produtoRepository.save(saveProdutoDto.pegarModelPR());
            return saveProdutoDto;
        } else {
            throw new Exception("PRODUTO_NOT_FOUND");
        }
    }

    public void deletarProduto(Long idProduto) throws Exception {

        Optional<Produto> produto = produtoRepository.findById(idProduto);

        if(produto.isPresent()) {
            produtoRepository.delete(produto.get());
        } else {
            throw new Exception("PRODUTO_NOT_FOUND");
        }
    }


}
