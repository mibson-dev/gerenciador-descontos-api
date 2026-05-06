package com.mibson.gerenciador_descontos_api.model;

import com.mibson.gerenciador_descontos_api.exceptions.TaxaFreteInvalidaException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto_fisico")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ProdutoFisico extends Produto {

    private double taxaFrete;

    public ProdutoFisico(String nome, double precoBase, double taxaFrete) {
        super(null, nome, precoBase);
        setTaxaFrete(taxaFrete);
    }

    public void setTaxaFrete(double taxaFrete) {
        if (taxaFrete < 0) {
            throw new TaxaFreteInvalidaException("Taxa de frete inválida.");
        } else {
            this.taxaFrete = taxaFrete;
        }
    }
}
