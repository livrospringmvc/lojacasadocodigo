package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.validacao.ProdutoValidator;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtos;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		//binder.setValidator(new ProdutoValidator());
    }	

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastra(@Valid @ModelAttribute("produto") Produto produto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return form(produto);
		}
		produtos.adiciona(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping("/form")
	public ModelAndView form(@ModelAttribute Produto produto){
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
