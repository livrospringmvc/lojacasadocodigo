package br.com.casadocodigo.loja.controllers.integration;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.casadocodigo.loja.models.PaymentData;

@RestController
@RequestMapping("/gateway")
public class PaymentGateway {
	
	//ab -r -n 600 -c 200 -p jsonData.txt -T 'application/json' http://localhost:8080/casadocodigo/gateway
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity pay(@RequestBody PaymentData paymentData, HttpServletResponse response)
			throws InterruptedException, IOException {
			URL url = new URL("https://www.bing.com");
			url.openStream();
			HttpHeaders httpHeaders = new HttpHeaders();
			if (paymentData.getValue().compareTo(new BigDecimal(500)) <= 0) {
				httpHeaders.add(HttpHeaders.LOCATION, "http://payment.com/" + UUID.randomUUID());			
				return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
			} else {
				httpHeaders.add(HttpHeaders.LOCATION, "http://payment.com/fail/" + UUID.randomUUID());			
				return new ResponseEntity(httpHeaders, HttpStatus.BAD_REQUEST);
			}
	}

}
