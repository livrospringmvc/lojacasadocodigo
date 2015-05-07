package br.com.casadocodigo.loja.controllers.integration;

import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsRestController {

    @Autowired
    private ProductRepository productRepository;

    //	@RequestMapping(method = RequestMethod.GET)
//	@Cacheable(value = "lastProducts", keyGenerator = "headerKeyGenerator")
    public List<Product> listOtherFormats() {
        return productRepository.findAll();
    }
}
