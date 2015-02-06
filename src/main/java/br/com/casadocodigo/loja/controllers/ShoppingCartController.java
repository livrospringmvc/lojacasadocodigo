package br.com.casadocodigo.loja.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.ShoppingCart;

@Controller
@RequestMapping("/shopping")
@Lazy
public class ShoppingCartController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCart shoppingCart;
	
//	@InitBinder
//    protected void initBinder(HttpSession session) {
//		session.setAttribute("shoppingCart", shoppingCart);
//    }

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(Integer productId){
		Product product = productDAO.busca(productId);
		shoppingCart.add(product);
		return new ModelAndView("redirect:produtos");
	}
}
