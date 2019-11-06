package br.com.valdemir.estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.valdemir.estoque.entity.Produto;
import br.com.valdemir.estoque.service.ProdutoService;

@Controller
public class ProdutorController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/")
	public String mostrarPaginaInicial(Model model) {
		
		model.addAttribute("produtos", service.buscarTodos());
		return "index";
	}
	
	@GetMapping("/adicionar")
	public String mostrarPaginaAdicionar(Produto produto) {
		
		return "novo";
	}

	@GetMapping("/editar/{sku}")
	public String mostrarPaginaEditar(@PathVariable("sku") String sku, Model model) {
		Produto produto = service.buscarPorSku(sku)
				.orElseThrow(() -> new IllegalArgumentException("Produto não existe com SKU " + sku));
		model.addAttribute("produto", produto);
		return "editar";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Produto produto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "novo";
		}

		service.salvar(produto);
		model.addAttribute("produtos", service.buscarTodos());
		return "index";
	}

	@PostMapping("/editar/{sku}")
	public String editar(@PathVariable("sku") String sku, @Valid Produto produto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			produto.setSku(sku);
			return "editar";
		}

		service.salvar(produto);
		model.addAttribute("produtos", service.buscarTodos());
		return "index";
	}

	@GetMapping("/excluir/{sku}")
	public String excluir(@PathVariable("sku") String sku, Model model) {
		Produto produto = service.buscarPorSku(sku)
				.orElseThrow(() -> new IllegalArgumentException("Produto não existe com SKU " + sku));
		service.excluir(produto);
		model.addAttribute("produtos", service.buscarTodos());
		return "index";
	}

}
