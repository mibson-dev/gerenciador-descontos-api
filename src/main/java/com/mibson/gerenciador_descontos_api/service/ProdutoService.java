package com.mibson.gerenciador_descontos_api.service;

import com.mibson.gerenciador_descontos_api.dto.PrecoFinalResponse;
import com.mibson.gerenciador_descontos_api.dto.ProdutoDigitalRequest;
import com.mibson.gerenciador_descontos_api.dto.ProdutoFisicoRequest;
import com.mibson.gerenciador_descontos_api.dto.ProdutoResponse;
import com.mibson.gerenciador_descontos_api.exceptions.DescontoInvalidoException;
import com.mibson.gerenciador_descontos_api.exceptions.ProdutoNaoEncontradoException;
import com.mibson.gerenciador_descontos_api.model.Produto;
import com.mibson.gerenciador_descontos_api.model.ProdutoDigital;
import com.mibson.gerenciador_descontos_api.model.ProdutoFisico;
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

    public PrecoFinalResponse calcularPrecoFinal(Long id) {
        Produto produto = buscarPorId(id);

        double descontoAplicado = produto.getPrecoBase() - (produto.getPrecoBase() * descontoGlobal);

        return new PrecoFinalResponse(produto.getNome(), descontoAplicado);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));
    }

    public ProdutoResponse salvarProdutoFisico(ProdutoFisicoRequest request) {
        ProdutoFisico produtoFisico = new ProdutoFisico(request.nome(), request.precoBase(), request.taxaFrete());
        produtoRepository.save(produtoFisico);

        return new ProdutoResponse(produtoFisico.getId(), produtoFisico.getNome(), produtoFisico.getPrecoBase(), "FISICO");
    }

    public ProdutoResponse salvarProdutoDigital(ProdutoDigitalRequest request) {
        ProdutoDigital produtoDigital = new ProdutoDigital(request.nome(), request.precoBase());
        produtoRepository.save(produtoDigital);

        return new ProdutoResponse(produtoDigital.getId(), produtoDigital.getNome(), produtoDigital.getPrecoBase(), "DIGITAL");
    }

    public void setDescontoGlobal(double descontoGlobal) {
        if (descontoGlobal < 0) {
            throw new DescontoInvalidoException("Desconto inválido.");
        } else {
            this.descontoGlobal = descontoGlobal;
        }
    }
}
