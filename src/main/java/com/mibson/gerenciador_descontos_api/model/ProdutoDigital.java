package com.mibson.gerenciador_descontos_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto_digital")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ProdutoDigital extends Produto {

    public ProdutoDigital(Long id, String nome, double precoBase) {
        super(null, nome, precoBase);
    }
}
