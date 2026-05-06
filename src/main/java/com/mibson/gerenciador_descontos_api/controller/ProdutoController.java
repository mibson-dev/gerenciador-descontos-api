package com.mibson.gerenciador_descontos_api.controller;

import com.mibson.gerenciador_descontos_api.dto.ProdutoDigitalRequest;
import com.mibson.gerenciador_descontos_api.dto.ProdutoFisicoRequest;
import com.mibson.gerenciador_descontos_api.dto.ProdutoResponse;
import com.mibson.gerenciador_descontos_api.model.Produto;
import com.mibson.gerenciador_descontos_api.service.ProdutoService;
import jakarta.validation.Valid;
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

    @PostMapping("/fisico")
    public ResponseEntity<ProdutoResponse> salvarProdutoFisico(@RequestBody @Valid ProdutoFisicoRequest produto) {
        return ResponseEntity.ok(produtoService.salvarProdutoFisico(produto));
    }

    @PostMapping("/digital")
    public ResponseEntity<ProdutoResponse> salvarProdutoDigital(@RequestBody @Valid ProdutoDigitalRequest produto) {
        return ResponseEntity.ok(produtoService.salvarProdutoDigital(produto));
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
