package br.com.valdemir.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.valdemir.estoque.entity.Produto;
import br.com.valdemir.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	public Produto salvar(Produto produto) {
		return this.repositorio.save(produto);
	}

	public void excluir(String sku) {
		if (sku != null) {

			this.repositorio.deleteById(sku);
		}
	}
	
	public void excluir(Produto produto) {
		if (produto != null) {
			
			this.repositorio.delete(produto);
		}
	}
	
	public List<Produto> buscar(Produto produto){
		if(produto != null) {
			Example<Produto> exemplo = Example.of(produto);
			return this.repositorio.findAll(exemplo);
		}
		return null;
	}

	public Optional<Produto> buscarPorSku(String sku){
		if (sku != null) {

			return this.repositorio.findById(sku);
		}
		return Optional.empty();
	}

	public List<Produto> buscarTodos() {
		return this.repositorio.findAll();
	}

}
