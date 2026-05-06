package com.mibson.gerenciador_descontos_api.controller;

import com.mibson.gerenciador_descontos_api.model.Produto;
import com.mibson.gerenciador_descontos_api.model.ProdutoFisico;
import com.mibson.gerenciador_descontos_api.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public List<Produto> mostrarlistaDeProdutos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto salvarProduto (@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PatchMapping("/desconto")
    public void atualizarDesconto(@RequestBody double desconto) {
        produtoService.setDescontoGlobal(desconto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }
}
