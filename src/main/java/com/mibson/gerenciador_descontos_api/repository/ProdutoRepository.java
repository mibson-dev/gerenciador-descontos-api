package com.mibson.gerenciador_descontos_api.repository;

import com.mibson.gerenciador_descontos_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
