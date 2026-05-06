package com.mibson.gerenciador_descontos_api.service;

import com.mibson.gerenciador_descontos_api.exceptions.DescontoInvalidoException;
import com.mibson.gerenciador_descontos_api.exceptions.ProdutoNaoEncontradoException;
import com.mibson.gerenciador_descontos_api.model.Produto;
import com.mibson.gerenciador_descontos_api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private double descontoGlobal;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public double calcularPrecoFinal(Produto produto) {
        return produto.getPrecoBase() - (produto.getPrecoBase() * descontoGlobal);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));
    }

    public void setDescontoGlobal(double descontoGlobal) {
        if (descontoGlobal < 0) {
            throw new DescontoInvalidoException("Desconto inválido.");
        } else {
            this.descontoGlobal = descontoGlobal;
        }
    }
}
