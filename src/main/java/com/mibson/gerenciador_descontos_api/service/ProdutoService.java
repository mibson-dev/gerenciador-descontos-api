package com.mibson.gerenciador_descontos_api.service;

import com.mibson.gerenciador_descontos_api.exceptions.DescontoInvalidoException;
import com.mibson.gerenciador_descontos_api.model.Produto;
import com.mibson.gerenciador_descontos_api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public void setDescontoGlobal(double descontoGlobal) {
        if (descontoGlobal < 0) {
            throw new DescontoInvalidoException("Desconto inválido.");
        } else {
            this.descontoGlobal = descontoGlobal;
        }
    }
}
