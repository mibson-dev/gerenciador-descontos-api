package com.mibson.gerenciador_descontos_api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mibson.gerenciador_descontos_api.exceptions.NomeInvalidoException;
import com.mibson.gerenciador_descontos_api.exceptions.PrecoInvalidoException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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

    @NotBlank(message = "Digite um nome válido")
    private String nome;

    @PositiveOrZero(message = "Preço do produto inválido.")
    private double precoBase;
}
