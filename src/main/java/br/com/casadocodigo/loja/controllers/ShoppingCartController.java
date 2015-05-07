package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.ShoppingItem;
import br.com.casadocodigo.loja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCart shoppingCart;


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(Integer productId, @RequestParam BookType bookType) {
        ShoppingItem item = createItem(productId, bookType);
        shoppingCart.add(item);

        return new ModelAndView("redirect:/shopping");
    }

    private ShoppingItem createItem(Integer productId, BookType bookType) {
        Product product = productRepository.findOne(productId);
        ShoppingItem item = new ShoppingItem(product, bookType);
        return item;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String items() {
        return "shoppingCart/items";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{productId}")
    public String remove(@PathVariable("productId") Integer productId, BookType bookType) {
        shoppingCart.remove(createItem(productId, bookType));
        return "redirect:/shopping";
    }
}
