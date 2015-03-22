package br.com.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	public Callable<String> checkout() {
		return () -> {
			BigDecimal total = shoppingCart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";
			String response = restTemplate.postForObject(uriToPay, new PaymentData(total),String.class);
			return "redirect:/success";
		};
	}

}
