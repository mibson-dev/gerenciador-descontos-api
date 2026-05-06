package com.mibson.gerenciador_descontos_api.model;

import com.mibson.gerenciador_descontos_api.exceptions.TaxaFreteInvalidaException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto_fisico")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ProdutoFisico extends Produto {

    @PositiveOrZero(message = "Taxa de frete inválida.")
    private double taxaFrete;

    public ProdutoFisico(String nome, double precoBase, double taxaFrete) {
        super(null, nome, precoBase);
        setTaxaFrete(taxaFrete);
    }
}
