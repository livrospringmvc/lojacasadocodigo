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

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.validacao.ProductValidator;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

	@Autowired
	private ProductDAO products;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		//binder.setValidator(new ProductValidator());
    }	

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") @Valid Product product,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return form(product);
		}
		products.save(product);
		redirectAttributes.addFlashAttribute("success", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping("/form")
	public ModelAndView form(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("bookTypes", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(Model model){
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", products.list());
		return modelAndView;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("products/edit");
		Product product = products.busca(id);
		modelAndView.addObject("produto", product);
		return modelAndView;
	}
	
}
