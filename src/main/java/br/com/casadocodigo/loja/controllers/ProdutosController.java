package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtos;

	@RequestMapping(method=RequestMethod.POST)
	public String cadastra(Produto produto,RedirectAttributes redirectAttributes){
		produtos.adiciona(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return "redirect:produtos";
	}
	
	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tiposLivro", TipoLivro.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista(Model model){
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos.lista());
		return modelAndView;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edita(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("produtos/edita");
		Produto produto = produtos.busca(id);
		System.out.println(produto);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}
	
}
