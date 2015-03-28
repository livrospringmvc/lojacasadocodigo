package br.com.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.PaymentData;
import br.com.casadocodigo.loja.models.ShoppingCart;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private ShoppingCart shoppingCart;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method=RequestMethod.POST)
	public Callable<ModelAndView> checkout() {
		return () -> {
			if(shoppingCart.isEmpty()){
				ModelAndView modelAndView = new ModelAndView("/shopping");
				modelAndView.addObject("error", "O carrinho está vazio");
				return modelAndView;
			}
			BigDecimal total = shoppingCart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";
			restTemplate.postForObject(uriToPay, new PaymentData(total),String.class);
			return new ModelAndView("redirect:/success");
		};
	}

}
