package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos")
	public String cadastra(Produto produto){
		System.out.println("Salvando o produto "+produto);
		return "produtos/lista";
	}
}
