package br.com.valdemir.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valdemir.estoque.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
