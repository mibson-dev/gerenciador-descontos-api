package com.mibson.gerenciador_descontos_api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mibson.gerenciador_descontos_api.exceptions.NomeInvalidoException;
import com.mibson.gerenciador_descontos_api.exceptions.PrecoInvalidoException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProdutoFisico.class, name = "FISICO"),
        @JsonSubTypes.Type(value = ProdutoDigital.class, name = "DIGITAL")
})
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double precoBase;


    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new NomeInvalidoException("Digite um nome válido");
        } else {
            this.nome = nome;
        }
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase < 0) {
            throw new PrecoInvalidoException("Preço do produto inválido.");
        } else {
            this.precoBase = precoBase;
        }
    }
}
