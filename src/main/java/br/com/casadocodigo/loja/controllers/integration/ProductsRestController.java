package br.com.casadocodigo.loja.controllers.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;

@RestController
//@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsRestController {
	
	@Autowired
	private ProductDAO productDAO;

//	@RequestMapping(method = RequestMethod.GET)
//	@Cacheable(value = "lastProducts", keyGenerator = "headerKeyGenerator")
	public List<Product> listOtherFormats() {
		return productDAO.list();
	}
}
