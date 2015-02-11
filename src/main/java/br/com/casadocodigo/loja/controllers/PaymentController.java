package br.com.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import br.com.casadocodigo.loja.models.PaymentData;
import br.com.casadocodigo.loja.models.ShoppingCart;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private ShoppingCart shoppingCart;
	@Autowired
	private RestTemplate restTemplate;

	// public Callable<String> checkout(){
	// return () -> {
	// BigDecimal total = shoppingCart.getTotal();
	// String uriToPay =
	// MvcUriComponentsBuilder.fromMappingName("PG#pay").arg(0, total).build();
	// restTemplate.postForLocation(uriToPay, null);
	// return "redirect:/success";
	// };
	// }

	@RequestMapping(method = RequestMethod.POST)
	public String checkout() throws MalformedURLException {
		BigDecimal total = shoppingCart.getTotal();
		String uriToPay = MvcUriComponentsBuilder.fromMappingName("PG#pay")
				.build();
		try {
			URI postForLocation = restTemplate.postForLocation(uriToPay,
					total.toString());
			return "redirect:" + postForLocation.toURL().toExternalForm();
		} catch (HttpClientErrorException clientErrorException) {
			return "redirect:"
					+ clientErrorException.getResponseHeaders().get(
							HttpHeaders.LOCATION);
		}
	}

}
